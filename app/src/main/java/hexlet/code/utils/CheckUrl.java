package hexlet.code.utils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import hexlet.code.model.UrlCheck;

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
        }
/*        int code = response.getCode();
        //var heder = response.getHeaders();
        var body = response.getBody();*/

        String title = "A";
        String h1  = "B";
        //String description = "C";
        String description = body;
        //Long idLink = id;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        var urlCheck = new UrlCheck(code, title, h1, description, id, timestamp);
        return urlCheck;
    }

}
