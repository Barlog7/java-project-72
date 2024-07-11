@import hexlet.code.NamedRoutes
@import hexlet.code.dto.UrlPage
@import java.sql.Timestamp
@import java.time.format.DateTimeFormatter
@import java.util.Date
@param  UrlPage urlPage

!{var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");}

@template.layout.page(
pageIndex = urlPage,
content = @`

            <h2>Список URL</h2>
    @for(var url : urlPage.getUrls())
    <%--<div>${course.getName()}</div>--%>
    <%--<h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>--%>
        <%--<h2><a href="${NamedRoutes.usersPath(user.getId())}">${user.getName()}</a></h2>--%>
        <%--<p>${url.getId()} ${url.getName()} ${url.getCreatedAt().toString()}</p>--%>
        <a href="${NamedRoutes.urlPath(url.getId())}">${url.getId()} ${url.getName()} ${url.getCreatedAt().toLocalDateTime().format(formatter)}</a>
    @endfor

`
)