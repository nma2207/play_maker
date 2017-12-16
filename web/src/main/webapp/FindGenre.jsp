<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
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
        Определен жанр ${genre}
        <div class="block_header">Результаты поиска</div>
        <div class="result_list">
            <table>
                <c:forEach var="listValue" items="${list}">
            <!--<div class="result">-->
                    <tr>
                        <td>
                            ${listValue.getName_song()}
                        </td>
                    <td>
            <audio controls="">
            <source src="music/${listValue.getPath()}">
            Тег audio не поддерживается вашим браузером.
            </audio>
            </td>

            </tr>
            <!--</div>-->
            </c:forEach>
            <!-- Сюда нужно вставить результаты поиска -->
            </table>
        </div>
        <div class="bitton_click"><input type="submit" value="Найти"></div>
    </div>
</section>
</body>
</html>