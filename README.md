### Hexlet tests and linter status:
[![Actions Status](https://github.com/Barlog7/java-project-72/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Barlog7/java-project-72/actions)

<a href="https://codeclimate.com/github/Barlog7/java-project-72/maintainability"><img src="https://api.codeclimate.com/v1/badges/96f002c1926c0064d817/maintainability" /></a>
<a href="https://codeclimate.com/github/Barlog7/java-project-72/test_coverage"><img src="https://api.codeclimate.com/v1/badges/96f002c1926c0064d817/test_coverage" /></a>

### Проект
### Анализатор страниц

https://java-project-72-apep.onrender.com/

Проект анализирует адреса страниц.

Выбранный сайт можно внести в список проверяемых сайтов. Для этого на главной странице надо ввести название сайта и нажать кнопку проверить. 
Если название сайта будет написано не в правильном формате, то выйдет сообщение "Некорректный URL".
Если запись уже существует, то выйдет сообщение "Запись уже существует". Если запись внесена в список проверяемых сайтов то выйдет сообщение "Запись создана". При вводе какой-либо внутренней страницы сайта в список проверки попадет только главная страница.



Если сайт внесен в список проверяемых, то выбрав его из списка можно запустить его проверку нажав кнопку "Запустить проверку". В результате можно получить код ответа, наименование из раздела title, основной заголовок и описание.
Проверку можно запускать повторно если необходимо проверить данные по сайту заново. 