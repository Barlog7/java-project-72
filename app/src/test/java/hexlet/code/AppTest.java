package hexlet.code;
import static hexlet.code.utils.CheckUrl.checkExsist;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE_TIME;

import com.mashape.unirest.http.exceptions.UnirestException;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import java.io.IOException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


public class AppTest {


    private static Javalin app;
    private static MockWebServer server;

    @BeforeEach
    public final void setUp() throws Exception {
        app = App.getApp();
        server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("<head>\n" +
                "    <title>Example Domain</title>\n" +
                "\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta name=\"description\" content=\"Описание сайта\">\n" +
                "    <style type=\"text/css\">\n" +
                "    body {\n" +
                "        background-color: #f0f0f2;\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "        font-family: -apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n" +
                "        \n" +
                "    }\n" +
                "    div {\n" +
                "        width: 600px;\n" +
                "        margin: 5em auto;\n" +
                "        padding: 2em;\n" +
                "        background-color: #fdfdff;\n" +
                "        border-radius: 0.5em;\n" +
                "        box-shadow: 2px 3px 7px 2px rgba(0,0,0,0.02);\n" +
                "    }\n" +
                "    a:link, a:visited {\n" +
                "        color: #38488f;\n" +
                "        text-decoration: none;\n" +
                "    }\n" +
                "    @media (max-width: 700px) {\n" +
                "        div {\n" +
                "            margin: 0 auto;\n" +
                "            width: auto;\n" +
                "        }\n" +
                "    }\n" +
                "    </style>    \n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div>\n" +
                "    <h1>Example Domain Header</h1>\n" +
                "    <p>This domain is for use in illustrative examples in documents. You may use this\n" +
                "    domain in literature without prior coordination or asking for permission.</p>\n" +
                "    <p><a href=\"https://www.iana.org/domains/example\">More information...</a></p>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "</body>"));
        server.start();

    }


    @Test
    public void testMainPage() throws Exception {
        //app = App.getApp();
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void testAddUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=https://www.example.com";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.example.com");
        });
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
        });
    }


    @Test
    void testUrlNotFound() throws Exception {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/999999");
            assertThat(response.code()).isEqualTo(404);
        });
    }

    @Test
    public void testUrlPage() throws SQLException {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        var url = new Url("https://www.example.com", ts);
        UrlRepository.save(url);

        JavalinTest.test(app, (server, client) -> {

            var response = client.get("/urls/" + url.getId());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.example.com");
        });
    }
    @Test
    public void testCheckExsist() throws SQLException, InterruptedException, UnirestException {


        HttpUrl baseUrl = server.url("/");
        var nameSait = server.url("/").toString();


        var urlCheck = checkExsist(nameSait, 1L);
        assertThat(urlCheck.getStatusCode()).isEqualTo(200);
        assertThat(urlCheck.getTitle()).isEqualTo("Example Domain");
        assertThat(urlCheck.getH1()).isEqualTo("Example Domain Header");
        assertThat(urlCheck.getDescription()).isEqualTo("Описание сайта");


    }
    @Test
    public void testUrlCheck() throws SQLException, InterruptedException, UnirestException {


        HttpUrl baseUrl = server.url("/");
        var nameSait = server.url("/").toString();
        URL urlName = baseUrl.url();
        String protokol = urlName.getProtocol();
        String body = urlName.getAuthority();
        String urlString = protokol + "://" + body;

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        var url = new Url(urlString, ts);
        UrlRepository.save(url);

        JavalinTest.test(app, (server, client) -> {

            var response = client.get("/urls/" + url.getId() + "/checks");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains(urlString);
        });

    }
    @AfterAll
    public static void setEnd() throws IOException {
        server.shutdown();
    }

}
