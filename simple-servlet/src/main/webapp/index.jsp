<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> PlayMaker </title>
</head>
<body>
<h2> Добро пожаловать на PlayMaker!!!</h2>
<h4> Определить жанр песни:</h4>
<form action="get_genre" method="get">
    <p>Кто поет?  <input type="text" name="singer_name"></p>
    <p>Что поет?  <input type="text" name="sing_name"></p>
    <p><input type="submit" value="Определить жанр"></p>
</form>
<br>
<br>
<h4> Найти песни по жанру</h4>
<form action = "get_by_genre">
    <p>Какой жанр? <input type = "text" name="genre"></p>
    <p><input type="submit" value="Песн"></p>
</form>

<h4><a href = "/all_songs">Показать все песни</a></h4>
<h4><a href = "">Показать всех певцов</a></h4>
</body>
</html>
