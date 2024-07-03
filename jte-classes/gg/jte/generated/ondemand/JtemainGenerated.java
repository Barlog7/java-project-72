package gg.jte.generated.ondemand;
public final class JtemainGenerated {
	public static final String JTE_NAME = "main.jte";
	public static final int[] JTE_LINE_INFO = {10,10,10,10,10,10,16,16,16,16,16,16};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Hello Hexlet!</title>\n</head>\n<body>\n<div class=\"col-lg-8 mx-auto p-4 py-md-5\">\n    <main>\n        <h1 class=\"text-body-emphasis\">Анализатор страниц</h1>\n        ");
		jteOutput.writeContent("\n        <input type=\"text\" name=\"url\" value=\"\" placeholder=\"Ссылка\"/>\n        <input type=\"submit\" value=\"Проверить\"/>\n    </main>\n</div>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
