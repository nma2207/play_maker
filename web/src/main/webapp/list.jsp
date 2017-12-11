<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>


<c:if test="${not empty list}">

    <ul>
        <c:forEach var="listValue" items="${list}">
            <li>${listValue.getName_song()}   ${listValue.getPath()} </li>
        </c:forEach>
    </ul>

</c:if>
</body>
</html>