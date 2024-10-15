<#import "parts/common.ftlh" as c>

<@c.page>
    <h1>Добро пожаловать в ${appName}!</h1>
    <div>
        <form action="/create">
            <button type="submit">Создать запись</button>
        </form>

        <form action="/records">
            <button type="submit">Выбрать существующую</button>
        </form>
    </div>
</@c.page>
