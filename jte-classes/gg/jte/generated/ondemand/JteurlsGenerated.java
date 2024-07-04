package gg.jte.generated.ondemand;
import hexlet.code.NamedRoutes;
import hexlet.code.dto.UrlPage;
import java.sql.Timestamp;
import java.util.Date;
public final class JteurlsGenerated {
	public static final String JTE_NAME = "urls.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,4,4,6,6,9,9,12,12,13,14,15,16,16,16,16,16,16,16,16,16,17,17,19,19,19,19,19,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage urlPage) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n            <h1>Список URL</h1>\n    ");
				for (var url : urlPage.getUrls()) {
					jteOutput.writeContent("\n    ");
					jteOutput.writeContent("\n    ");
					jteOutput.writeContent("\n        ");
					jteOutput.writeContent("\n        <p>");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent(" ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent(" ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(Date.parse(url.getCreatedAt().getTime()));
					jteOutput.writeContent("</p>\n    ");
				}
				jteOutput.writeContent("\n\n");
			}
		}, urlPage);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage urlPage = (UrlPage)params.get("urlPage");
		render(jteOutput, jteHtmlInterceptor, urlPage);
	}
}
