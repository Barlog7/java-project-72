package hexlet.code.controller;

import hexlet.code.NamedRoutes;
import hexlet.code.dto.UrlPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import static io.javalin.rendering.template.TemplateUtil.model;


public class UrlController {
    public static void create(Context ctx) throws SQLException {
        boolean isExist = false;
        var name = ctx.formParam("url");

        isExist = UrlRepository.find(name);
        if (!isExist) {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            var url = new Url(name, timestamp);
            UrlRepository.save(url);
            ctx.sessionAttribute("status", "запись создана");
            /*ctx.redirect(NamedRoutes.urlsPath());*/

            var page = new UrlPage();
            page.setUrls(UrlRepository.getEntities());
            ctx.render("urls.jte", model("urlPage", page));
        } else {
            ctx.sessionAttribute("status", "запись уже существует");
            ctx.redirect(NamedRoutes.basePath());
        }

    }
}
