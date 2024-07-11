package hexlet.code.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import hexlet.code.NamedRoutes;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


import static hexlet.code.utils.CheckUrl.checkStringToUrl;

public class UrlCheckController {
    public static void create(Context ctx) throws SQLException, UnirestException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.findUrl(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        CheckRepository.delete(id);
        String urlSring = url.getName();
        //String body =  Unirest.get(urlSring).getBody().toString();
        //System.out.println(body);
        //var bodyReturn = Unirest.get(url.getName()).getBody();
        //HttpResponse<JsonNode> jsonResponse = Unirest.get(urlSring).asJson();
        //int code = jsonResponse.getCode();
        //var body = jsonResponse.getBody().toString();

        /*jsonResponse.getHeaders();
        jsonResponse.*/
        int code = 1;
        String title = "A";
        String h1  = "B";
        String description = "C";
        Long idLink = id;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        var urlCheck = new UrlCheck(code, title, h1, description, idLink, timestamp);
        CheckRepository.save(urlCheck);
        ctx.sessionAttribute("flash", "Запись о проверке создана");
        ctx.sessionAttribute("status", "ok");
        ctx.redirect(NamedRoutes.urlPath(id));

    }

}
