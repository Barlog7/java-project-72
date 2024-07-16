@import hexlet.code.NamedRoutes
@import hexlet.code.dto.UrlPage
@import java.sql.Timestamp
@import java.time.format.DateTimeFormatter
@import java.util.Date
@import static hexlet.code.repository.CheckRepository.findStatusCheck
@import static hexlet.code.repository.CheckRepository.findDateTimeCheck
@import static hexlet.code.repository.CheckRepository.findUrl
@import hexlet.code.model.UrlCheck
@param  UrlPage urlPage

!{var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");}


@template.layout.page(
pageIndex = urlPage,
content = @`

            <h2>Список URL</h2>
    <ul>
    @for(var url : urlPage.getUrls())
    <%--<div>${course.getName()}</div>--%>
    <%--<h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>--%>
        <%--<h2><a href="${NamedRoutes.usersPath(user.getId())}">${user.getName()}</a></h2>--%>
        <%--<p>${url.getId()} ${url.getName()} ${url.getCreatedAt().toString()}</p>--%>
        <li>
            !{
    var status = " ";
    var dateCheck = " ";
    try {
        status = findStatusCheck(url.getId());
        dateCheck = findDateTimeCheck(url.getId());
    }
    catch (Exception e) {}

}

       <p> ${url.getId()}    <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()}</a>    ${url.getCreatedAt().toLocalDateTime().format(formatter)}    Код возврата ${status} Дата проверки ${dateCheck}</p>
        </li>
    @endfor
    </ul>

`
)