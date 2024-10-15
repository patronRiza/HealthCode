<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Открытые медицинские карты</title>
</head>
<body>
<h1>Поиск Пациентов</h1>
<form action="/records/find" method="get">
    <label for="firstName">Name:</label>
    <input type="text" id="firstName" name="firstName" required>
    <button type="submit">Search</button>
</form>
<#if records?? && records?size != 0>
    <h2>Результат</h2>
    <ul>
        <#list records as record>
            <li>
                <strong>Доктор:</strong> ${record.doctor.firstName} ${record.doctor.lastName}<br>
                <strong>Пациент:</strong> ${record.firstName} ${record.lastName}<br>
                <strong>Диагноз:</strong> ${record.disease.name}
                <a href="/records/edit/${record.id}">Редактировать</a>
            </li>
        </#list>
    </ul>
<#else>
    <p>Пациенты не найдены</p>
</#if>
</body>
</html>