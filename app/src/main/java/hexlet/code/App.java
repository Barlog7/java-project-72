package hexlet.code;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class App {

    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");
        log.info("какой-то лог");
        var app = getApp();

        app.start();
    }
    public static Javalin getApp() throws Exception {
/*        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());

        });*/
/*        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");*/

        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(getPort());
        return app;
    }

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }

}
