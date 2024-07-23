package hexlet.code.controller;

import hexlet.code.NamedRoutes;
import hexlet.code.dto.UrlPage;
import hexlet.code.dto.IdPage;
import hexlet.code.model.Url;
import hexlet.code.repository.CheckRepository;
import hexlet.code.repository.UrlRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.sql.SQLException;
import static hexlet.code.utils.CheckUrl.checkStringToUrl;
import static io.javalin.rendering.template.TemplateUtil.model;


public class UrlController {
    public static void create(Context ctx) throws SQLException {
        boolean isExist = false;
        var name = ctx.formParam("url");

        var returnUrl = checkStringToUrl(name);
        if (returnUrl.equals("-1")) {
            ctx.sessionAttribute("flash", "Некорректный URL");
            ctx.sessionAttribute("status", "notUrl");
            ctx.redirect(NamedRoutes.basePath());
            return;
        } else {
            name = returnUrl;
        }

        isExist = UrlRepository.find(name);
        if (!isExist) {
            var url = new Url(name);
            UrlRepository.save(url);
            ctx.sessionAttribute("flash", "Запись создана");
            ctx.sessionAttribute("status", "ok");

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
        page.setMapChecks(CheckRepository.getChecksMap());
        ctx.render("urls.jte", model("urlPage", page));

    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.findUrl(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        var urlCheck = CheckRepository.findUrl(id);
        var page = new IdPage(url, urlCheck.orElse(null));
        ctx.render("show.jte", model("page", page));
    }
}
