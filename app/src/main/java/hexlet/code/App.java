package hexlet.code;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class App {

    public static void main(String[] args) throws Exception {
        var app = getApp();

        app.start();
    }
    public static Javalin getApp() throws Exception {
/*        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });*/

        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);
        return app;
    }
}
