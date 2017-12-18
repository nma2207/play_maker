<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/css/main.css" rel="stylesheet" />
    <title> PlayMaker </title>
</head>
<body>
<header>
    <div id="logo_block">
        <div id="logo">
            <a href="/"></a>
        </div>
    </div>
</header>
<section>
    <div class="find_block">
        <div class="block_header">Результаты поиска по запросу</div>
        <div class="result_list">
            <table class="result">
                <c:forEach var="listValue" items="${list}">
                    <tr class="table_element">
                        <td class="text_element">
                                ${listValue.getSinger()} - ${listValue.getName()}
                        </td>
                        <td class="audio_element">
                            <audio controls="">
                                <source src="music/${listValue.getPath()}">
                                Тег audio не поддерживается вашим браузером.
                            </audio>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <form action="/">
            <div class="bitton_click_big"><input type="submit" value="Вернуться назад"/></div>
        </form>
    </div>
</section>
</body>
</html>