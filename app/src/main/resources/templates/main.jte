@import hexlet.code.NamedRoutes
@import hexlet.code.dto.MainPage
@param  MainPage mainPage


@template.layout.page(
content = @`

            <form action="${NamedRoutes.urlsPath()}" method="post">
                <input type="text" name="url" value="" placeholder="Ссылка"/>
                <input type="submit" value="Проверить"/>
            </form>

`
)