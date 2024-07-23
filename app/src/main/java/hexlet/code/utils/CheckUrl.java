package hexlet.code.utils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import hexlet.code.model.UrlCheck;
import org.jsoup.Jsoup;

import java.net.MalformedURLException;
import java.net.URL;

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
            body = response.getBody();

        } catch (UnirestException e) {
            code = 404;
            body = null;
            var urlCheck = new UrlCheck(code, "", "", "", id);
            return urlCheck;
        }

        var document = Jsoup.parse(body);
        String title = document.title();
        var h1Elemetnt = document.selectFirst("h1");

        String h1  = h1Elemetnt == null ? "" : h1Elemetnt.text();
        String description = document.select("meta[name=description]").attr("content");

        var urlCheck = new UrlCheck(code, title, h1, description, id);
        return urlCheck;
    }

}
