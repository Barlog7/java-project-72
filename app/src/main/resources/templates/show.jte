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

    <form action="${NamedRoutes.urlPathCheck(page.getUrl().getId())}" method="post">
        <%--<input type="text" name="url" value="" placeholder="Ссылка"/>--%>
        <input type="submit" value="Запустить проверку"/>
    </form>

    @if(page.getUrlCheck() != null)
        <p> </p>
        <div>Результаты проверки</div>
<%--        <table>
            <tr>
                <td>${page.getUrlCheck().getStatusCode().toString()}</td>
                <td>$${page.getUrlCheck().getTitle()}</td>
                <td>${page.getUrlCheck().getH1()}</td>
                <td>${page.getUrlCheck().getDescription()}</td>
                <td>${page.getUrlCheck().getCreatedAt().toLocalDateTime().format(formatter)}</td>
            </tr>
        </table>--%>
        <div>Код возврата: ${page.getUrlCheck().getStatusCode().toString()}</div>
        <div>название (title): ${page.getUrlCheck().getTitle()}</div>
        <div>Заголовок (H1): ${page.getUrlCheck().getH1()}</div>
        <div>Описание: ${page.getUrlCheck().getDescription()}</div>
        <div>Дата проверки: ${page.getUrlCheck().getCreatedAt().toLocalDateTime().format(formatter)}</div>
    @endif


`
)