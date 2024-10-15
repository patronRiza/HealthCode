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
<h1>Редактирование медицинской карточки</h1>
<form action="/records/update" method="post">
    <input type="hidden" name="id" value="${record.id}">
    <label for="doctor" class="form-label">Доктор</label>
    <select class="form-control" id="doctor" name="doctor" required>
        <#list doctors as doctor>
            <#if doctor.id = record.doctor.id>
                <option value="${doctor.id}" selected>${doctor.position} - ${doctor.firstName} ${doctor.lastName}</option>
            <#else>
                <option value="${doctor.id}">${doctor.position} - ${doctor.firstName} ${doctor.lastName}</option>
            </#if>
        </#list>
    </select><br>

    <label for="firstName">Имя пациента:</label>
    <input type="text" id="firstName" name="firstName" value="${record.firstName}" required><br>

    <label for="lastName">Фамилия пациента:</label>
    <input type="text" id="lastName" name="lastName" value="${record.lastName}" required><br>

    <label for="email">Почта:</label>
    <input type="email" id="email" name="email" value="${record.email}" required><br>

    <label for="phoneNumber">Номер телефона:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="${record.phoneNumber}" required><br>

    <label for="address">Адрес:</label>
    <input type="text" id="address" name="address" value="${record.address}" required><br>

    <label for="age">Возраст:</label>
    <input type="number" id="age" name="age" value="${record.age}" required><br>

    <label for="weight">Вес:</label>
    <input type="number" id="weight" name="weight" value="${record.weight}" required><br>

    <label for="disease" class="form-label">Болезнь</label>
    <select class="form-control" id="disease" name="disease" required>
        <#list diseases as disease>
            <#if disease.id = record.disease.id>
                <option value="${disease.id}" selected>${disease.name}</option>
            <#else>
                <option value="${disease.id}">${disease.name}</option>
            </#if>
        </#list>
    </select><br>

    <label for="description">Описание:</label>
    <textarea id="description" name="description" rows="4" cols="50"></textarea><br>

    <label for="isClosed" class="form-label">Статус больничного</label>
    <select class="form-control" id="isClosed" name="isClosed" required>
        <#if record.isClosed = false>
            <option value="false" selected>Открытый</option>
            <option value="true">Закрытый</option>
        <#else>
            <option value="false">Открытый</option>
            <option value="true" selected>Закрытый</option>
        </#if>
    </select><br>

    <button type="submit">Update</button><br>
</form>
<form action="/records/delete" method="post">
    <input type="hidden" name="id" value="${record.id}">
    <button type="submit">Удалить</button>
</form>
</body>
</html>