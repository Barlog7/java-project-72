package gg.jte.generated.ondemand;
import hexlet.code.dto.IdPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,6,6,6,7,7,7,8,8,8,9,9,9,9,9,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, IdPage page) {
		jteOutput.writeContent("\n");
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
				jteOutput.writeUserContent(page.getUrl().getCreatedAt().toString());
				jteOutput.writeContent("</div>\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		IdPage page = (IdPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
