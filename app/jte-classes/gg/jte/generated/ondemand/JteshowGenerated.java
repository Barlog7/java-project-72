package gg.jte.generated.ondemand;
import hexlet.code.NamedRoutes;
import hexlet.code.dto.IdPage;
import java.time.format.DateTimeFormatter;
public final class JteshowGenerated {
	public static final String JTE_NAME = "show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,5,7,9,9,10,10,10,11,11,11,12,12,12,14,14,14,14,14,14,14,14,14,15,19,19,22,22,22,23,23,23,24,24,24,25,25,25,26,26,26,27,27,30,30,30,30,30,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, IdPage page) {
		jteOutput.writeContent("\n");
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div>");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUrl().getId().toString());
				jteOutput.writeContent("</div>\n    <div>");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</div>\n    <div>");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getUrl().getCreatedAt().toLocalDateTime().format(formatter));
				jteOutput.writeContent("</div>\n\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.urlPathCheck(page.getUrl().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\n        ");
				jteOutput.writeContent("\n        <input type=\"submit\" value=\"Запустить проверку\"/>\n    </form>\n\n    ");
				if (page.getUrlCheck() != null) {
					jteOutput.writeContent("\n        <p> </p>\n        <div>Результаты проверки</div>\n        <div>");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getUrlCheck().getStatusCode().toString());
					jteOutput.writeContent("</div>\n        <div>");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getUrlCheck().getTitle());
					jteOutput.writeContent("</div>\n        <div>");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getUrlCheck().getH1());
					jteOutput.writeContent("</div>\n        <div>");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getUrlCheck().getDescription());
					jteOutput.writeContent("</div>\n        <div>");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getUrlCheck().getCreatedAt().toLocalDateTime().format(formatter));
					jteOutput.writeContent("</div>\n    ");
				}
				jteOutput.writeContent("\n\n\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		IdPage page = (IdPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
