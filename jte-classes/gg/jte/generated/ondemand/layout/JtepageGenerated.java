package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import hexlet.code.dto.MainPage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,13,13,13,13,15,15,15,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, MainPage pageIndex) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <title>Анализатор страниц</title>\n</head>\n<body>\n<h1>Анализатор страниц</h1>\n");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		MainPage pageIndex = (MainPage)params.getOrDefault("pageIndex", null);
		render(jteOutput, jteHtmlInterceptor, content, pageIndex);
	}
}
