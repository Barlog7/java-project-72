package hexlet.code.utils;
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
}
