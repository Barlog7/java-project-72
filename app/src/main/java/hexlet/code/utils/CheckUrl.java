package hexlet.code.utils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import hexlet.code.model.UrlCheck;
import org.jsoup.Jsoup;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
/*import hexlet.code.model.UrlCheck;*/

public class CheckUrl {
    public static String checkStringToUrl(String str) {
        String urlString = "";
        try {
            var url = new URL(str);
            String protokol = url.getProtocol();
            String body = url.getAuthority();
            urlString = protokol + "://" + body;
        } catch (MalformedURLException e) {
            urlString = "-1";
        }
        return urlString;
    }
    public static UrlCheck checkExsist(String url, Long id) {
        HttpResponse<String> response = null;
        int code = 0;
        String body = null;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        try {
            response = Unirest
                    .get(url)
                    .asString();
            code = response.getCode();
            //var heder = response.getHeaders();
            body = response.getBody();

        } catch (UnirestException e) {
            code = 404;
            //var heder = response.getHeaders();
            body = null;
            var urlCheck = new UrlCheck(code, "", "", "", id, timestamp);
            return urlCheck;
        }
/*        int code = response.getCode();
        //var heder = response.getHeaders();
        var body = response.getBody();*/
        var document = Jsoup.parse(body);
        String title = document.title();
        var h1Elemetnt = document.selectFirst("h1");

        //String title = "A";

        String h1  = h1Elemetnt == null ? "" : h1Elemetnt.text();
        //String description = "C";
        //var descAtrr = document.selectFirst("meta").getElementsByAttributeValue("name", "description");
        //var descAtrr = document.selectFirst("meta").getElementsByAttributeValue("name", "viewport");
        String description = document.select("meta[name=description]").attr("content");
        //viewport
        //var descAtrr = document.selectFirst("meta[name=\"description\"]");
        //var description = descAtrr.attr("content");
        //String description = body;
        //Long idLink = id;
        /*Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());*/
        var urlCheck = new UrlCheck(code, title, h1, description, id, timestamp);
        return urlCheck;
    }

}
