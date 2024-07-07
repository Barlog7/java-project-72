package hexlet.code.controller;

import hexlet.code.NamedRoutes;
import hexlet.code.dto.UrlPage;
import hexlet.code.dto.idPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

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
            //ctx.sessionAttribute("status", "запись создана");
            ctx.sessionAttribute("flash", "Запись создана");
            ctx.sessionAttribute("status", "ok");
/*            *//*ctx.redirect(NamedRoutes.urlsPath());*//*

            var page = new UrlPage();

            page.setUrls(UrlRepository.getEntities());
            ctx.render("urls.jte", model("urlPage", page));*/
            ctx.redirect(NamedRoutes.urlsPath());
        } else {
            ctx.sessionAttribute("flash", "Запись уже существует");
            ctx.sessionAttribute("status", "exsist");
            ctx.redirect(NamedRoutes.basePath());
        }

    }
    public static void index(Context ctx) throws SQLException {
        String flash = ctx.consumeSessionAttribute("flash");
        String status = ctx.consumeSessionAttribute("status");
        var page = new UrlPage();
        page.setFlash(flash);
        page.setStatus(status);
        page.setUrls(UrlRepository.getEntities());
        ctx.render("urls.jte", model("urlPage", page));

    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.findUrl(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new idPage(url);
        ctx.render("show.jte", model("page", page));
    }
}
