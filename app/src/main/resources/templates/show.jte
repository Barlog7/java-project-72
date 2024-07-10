@import hexlet.code.dto.IdPage
@param IdPage page

@template.layout.page(
content = @`
    <div>${page.getUrl().getId().toString()}</div>
    <div>${page.getUrl().getName()}</div>
    <div>${page.getUrl().getCreatedAt().toString()}</div>
`
)