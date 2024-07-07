package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import hexlet.code.dto.MainPage;
import hexlet.code.NamedRoutes;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,25,25,25,26,26,28,28,28,30,30,32,32,32,35,35,36,37,37,38,39,39,40,51,51,51,51,51,51,51,51,51,54,54,54,54,54,54,54,54,54,59,69,69,69,71,71,71,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, MainPage pageIndex) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <title>Анализатор страниц</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\n          rel=\"stylesheet\"\n          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\n          crossorigin=\"anonymous\">\n    <style>\n      .title{\n        color: white;\n        font-size: 20px;\n        background-color: #0c0f76;\n      }\n    </style>\n</head>\n<body>\n\n");
		if (pageIndex != null && pageIndex.getFlash() != null) {
			jteOutput.writeContent("\n    ");
			if (pageIndex.getStatus().equals("ok")) {
				jteOutput.writeContent("\n        <div class=\"alert alert-success\" role=\"alert\">\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(pageIndex.getFlash());
				jteOutput.writeContent("\n        </div>\n    ");
			} else {
				jteOutput.writeContent("\n        <div class=\"alert alert-danger\" role=\"alert\">\n            ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(pageIndex.getFlash());
				jteOutput.writeContent("\n        </div>\n\n    ");
			}
			jteOutput.writeContent("\n    ");
			jteOutput.writeContent("\n");
		} else {
			jteOutput.writeContent("\n    ");
			jteOutput.writeContent("\n");
		}
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n\n    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n        <ul class=\"navbar-nav\">\n            <li class=\"nav-item\">\n                <a class=\"nav-link\"");
		var __jte_html_attribute_0 = NamedRoutes.basePath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная страница</a>\n            </li>\n            <li class=\"nav-item\">\n                <a class=\"nav-link\"");
		var __jte_html_attribute_1 = NamedRoutes.urlsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Список URL</a>\n            </li>\n        </ul>\n    </div>\n</nav>\n");
		jteOutput.writeContent("\n<div class=\"title\">\n    <h1>Анализатор страниц</h1>\n</div>\n\n");
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
