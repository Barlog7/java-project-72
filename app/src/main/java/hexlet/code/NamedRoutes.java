package hexlet.code;

public class NamedRoutes {
    public static String urlsPath() {
        return "/urls";
    }
    public static String urlPath(Long id) {
        return urlPath(String.valueOf(id));
    }

    public static String urlPath(String id) {
        return urlsPath() + "/" + id;
    }
    public static String basePath() {
        return "/";
    }

    public static String urlPathCheck(Long id) {
        return urlPathCheck(String.valueOf(id));
    }

    public static String urlPathCheck(String id) {
        return urlsPath() + "/" + id + "/checks";
    }
}
