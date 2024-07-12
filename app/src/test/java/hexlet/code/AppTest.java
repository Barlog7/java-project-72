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
        server.enqueue(new MockResponse().setBody("hello, world!"));
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

/*        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        var url = new Url("https://www.example.com", ts);
        UrlRepository.save(url);*/
        //RecordedRequest request1 = server.takeRequest();
        //request1.getBody();
        //nameSait = "https://www.exampleWWWWWWWWW.com";
        var urlCheck = checkExsist(nameSait, 1L);
        assertThat(urlCheck.getStatusCode()).isEqualTo(200);
        assertThat(urlCheck.getDescription()).isEqualTo("hello, world!");

        //Chat chat = new Chat(baseUrl);

       /* JavalinTest.test(app, (server, client) -> {
            //var response = client.get("/urls/" + url.getId());
            var response = client.get("/urls/" + url.getId() +"/checks");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.example.com");
        });*/
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
