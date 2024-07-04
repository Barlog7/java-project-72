package gg.jte.generated.ondemand;
import hexlet.code.NamedRoutes;
import hexlet.code.dto.MainPage;
public final class JtemainGenerated {
	public static final String JTE_NAME = "main.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,7,7,9,9,9,9,9,9,9,9,9,14,14,14,14,14,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage mainPage) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n            <form");
				var __jte_html_attribute_0 = NamedRoutes.urlsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n                <input type=\"text\" name=\"url\" value=\"\" placeholder=\"Ссылка\"/>\n                <input type=\"submit\" value=\"Проверить\"/>\n            </form>\n\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage mainPage = (MainPage)params.get("mainPage");
		render(jteOutput, jteHtmlInterceptor, mainPage);
	}
}
