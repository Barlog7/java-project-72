package hexlet.code.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import hexlet.code.NamedRoutes;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.sql.SQLException;

import static hexlet.code.utils.CheckUrl.checkExsist;

public class UrlCheckController {
    public static void create(Context ctx) throws SQLException, UnirestException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.findUrl(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        CheckRepository.delete(id);
        String urlSring = url.getName() + "/";
        UrlCheck urlCheck = checkExsist(urlSring, id);
        CheckRepository.save(urlCheck);
        ctx.sessionAttribute("flash", "Запись о проверке создана");
        ctx.sessionAttribute("status", "ok");
        ctx.redirect(NamedRoutes.urlPath(id));

    }

}
