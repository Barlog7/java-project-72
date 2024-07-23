@import hexlet.code.NamedRoutes
@import hexlet.code.dto.UrlPage
@import java.time.format.DateTimeFormatter
@import hexlet.code.model.UrlCheck
@param  UrlPage urlPage

!{var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");}
!{final String EMPTY = "пусто";}


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
        UrlCheck check = urlPage.getMapChecks().get(url.getId());
        if (check == null) {
            status = EMPTY;
            dateCheck = EMPTY;
        } else {
            status = String.valueOf(check.getStatusCode());
            dateCheck = check.getCreatedAt().toLocalDateTime().format(formatter);
        }
    }
    catch (Exception e) {}

}

       <p> ${url.getId()}    <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()}</a>    ${url.getCreatedAt().toLocalDateTime().format(formatter)}    Код возврата ${status} Дата проверки ${dateCheck}</p>
        </li>
    @endfor
    </ul>

`
)