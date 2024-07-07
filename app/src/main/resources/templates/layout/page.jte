@import gg.jte.Content
@import hexlet.code.dto.MainPage
@import hexlet.code.NamedRoutes
@param Content content
@param MainPage pageIndex = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Анализатор страниц</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <style>
      .title{
        color: white;
        font-size: 20px;
        background-color: #0c0f76;
      }
    </style>
</head>
<body>

@if(pageIndex != null && pageIndex.getFlash() != null)
    @if(pageIndex.getStatus().equals("ok"))
        <div class="alert alert-success" role="alert">
            ${pageIndex.getFlash()}
        </div>
    @else
        <div class="alert alert-danger" role="alert">
            ${pageIndex.getFlash()}
        </div>

    @endif
    <%--<p>${pageIndex.getFlash()}</p>--%>
@else
    <%--<div>Пусто</div>--%>
@endif
<%--<div class="collapse navbar-collapse" id="navbarNav">
    <div class="navbar-nav">
        <a class="nav-link" href="${NamedRoutes.basePath()}">Главная</a>
        <a class="nav-link" href="${NamedRoutes.urlsPath()}">Список URL</a>
    </div>
</div>--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${NamedRoutes.basePath()}">Главная страница</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${NamedRoutes.urlsPath()}">Список URL</a>
            </li>
        </ul>
    </div>
</nav>
<%--
<div>
    <a class="nav-link" href="${NamedRoutes.basePath()}">Главная страница</a>
    <a class="nav-link" href="${NamedRoutes.urlsPath()}">Список URL</a>
</div>
--%>
<div class="title">
    <h1>Анализатор страниц</h1>
</div>

${content}
</body>
</html>