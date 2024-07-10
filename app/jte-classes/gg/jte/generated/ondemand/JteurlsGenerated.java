package gg.jte.generated.ondemand;
import hexlet.code.NamedRoutes;
import hexlet.code.dto.UrlPage;
import java.sql.Timestamp;
import java.util.Date;
public final class JteurlsGenerated {
	public static final String JTE_NAME = "urls.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,4,4,6,6,9,9,12,12,13,14,15,16,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,18,18,20,20,20,20,20,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage urlPage) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n            <h2>Список URL</h2>\n    ");
				for (var url : urlPage.getUrls()) {
					jteOutput.writeContent("\n    ");
					jteOutput.writeContent("\n    ");
					jteOutput.writeContent("\n        ");
					jteOutput.writeContent("\n        ");
					jteOutput.writeContent("\n        <a");
					var __jte_html_attribute_0 = NamedRoutes.urlPath(url.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent(" ");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent(" ");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getCreatedAt().toString());
					jteOutput.writeContent("</a>\n    ");
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