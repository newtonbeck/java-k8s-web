<!DOCTYPE html>

<html>
    <head>
        <title>Meu Blog</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>

    <body>
        <h1>Meus Posts</h1>

        <#list posts as post>
            <h2>${post.title}</h2>
            <p>${post.summary}</p>
        </#list>
    </body>
</html>
