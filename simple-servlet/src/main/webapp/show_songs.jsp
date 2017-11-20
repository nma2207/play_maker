<%--
  Created by IntelliJ IDEA.
  User: Марат
  Date: 2017-11-20
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" pageEncoding="UTF-8" %>

<html>
<head>

</head>
<body>
<%--<c:if test="${!empty itemList}">--%>
<table class="song-table">
    <tr>
        <th>Name</th>
        <th>Desscription</th>
        <th>Category</th>
        <th>Price</th>
    </tr>
    <%--<%--%>
        <%--import java.util.List;--%>
    <%--%>--%>
    <!--<c:forEach items="song_list" var="${item}">
        <tr>
            <td>${item.name}</td>
            <td>${item.genre}</td>
            <td>${item.singer}</td>
            <td>${item.durability}</td>
        </tr>
    </c:forEach>-->
    <%--<%--%>
        <%--List list = (List) requset.getAttribute("name");--%>
    <%--%>--%>
</table>
<%--</c:if>--%>
</body>
</html>
