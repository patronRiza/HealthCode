<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container mt-5">
        <h2>Создание медицинской карты</h2>
        <form action="/records" method="post">
            <div class="mb-3">
                <label for="doctor" class="form-label">Доктор</label>
                <select class="form-control" id="doctor" name="doctor" required>
                    <#list doctors as doctor>
                        <option value="${doctor.id}">${doctor.position} - ${doctor.firstName} ${doctor.lastName}</option>
                    </#list>
                </select>
            </div>

            <label for="firstName">Имя пациента:</label>
            <input type="text" id="firstName" name="firstName" required><br>

            <label for="lastName">Фамилия пациента:</label>
            <input type="text" id="lastName" name="lastName" required><br>

            <label for="email">Почта:</label>
            <input type="text" id="email" name="email" required><br>

            <label for="phoneNumber">Номер телефона:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required><br>

            <label for="address">Адрес:</label>
            <input type="text" id="address" name="address" required><br>

            <label for="age">Возраст:</label>
            <input type="number" id="age" name="age" required><br>

            <label for="weight">Вес:</label>
            <input type="number" id="weight" name="weight" required><br>

            <div class="mb-3">
                <label for="disease" class="form-label">Болезнь</label>
                <select class="form-control" id="disease" name="disease" required>
                    <#list diseases as disease>
                        <option value="${disease.id}">${disease.name}</option>
                    </#list>
                </select>
            </div>

            <label for="description">Описание:</label>
            <textarea id="description" name="description" rows="4" cols="50"></textarea><br>

            <label for="isClosed" class="form-label">Статус больничного</label>
            <select class="form-control" id="isClosed" name="isClosed" required>
                <option value="false">Открытый</option>
                <option value="true">Закрытый</option>
            </select><br>

            <button type="submit">Создать</button>
        </form>
    </div>
</@c.page>
