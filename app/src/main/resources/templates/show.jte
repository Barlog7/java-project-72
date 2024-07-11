@import hexlet.code.NamedRoutes
@import hexlet.code.dto.IdPage
@import java.time.format.DateTimeFormatter
@param IdPage page

!{var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");}

@template.layout.page(
content = @`
    <div>${page.getUrl().getId().toString()}</div>
    <div>${page.getUrl().getName()}</div>
    <div>${page.getUrl().getCreatedAt().toLocalDateTime().format(formatter)}</div>

    <form action="${NamedRoutes.urlPathCheck(page.getUrl().getId())}" method="get">
        <%--<input type="text" name="url" value="" placeholder="Ссылка"/>--%>
        <input type="submit" value="Запустить проверку"/>
    </form>

    @if(page.getUrlCheck() != null)
        <p> </p>
        <div>Результаты проверки</div>
        <div>${page.getUrlCheck().getStatusCode().toString()}</div>
        <div>${page.getUrlCheck().getTitle()}</div>
        <div>${page.getUrlCheck().getH1()}</div>
        <div>${page.getUrlCheck().getDescription()}</div>
        <div>${page.getUrlCheck().getCreatedAt().toLocalDateTime().format(formatter)}</div>
    @endif


`
)