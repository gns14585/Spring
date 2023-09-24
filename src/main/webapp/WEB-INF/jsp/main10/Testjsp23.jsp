<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-24
  Time: PM 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach begin="1" end="3">
        <li>Lorem ipsum.</li>
    </c:forEach>

    <hr>

    <c:forEach begin="0" end="2" var="num">
        <li>${num}</li>
    </c:forEach>

    <hr>

    <c:forEach begin="0" end="2" var="num">
        <li>car : ${myList[num]}</li>
    </c:forEach>

    <hr>

    <c:forEach items="${myList}" var="item">
        <li>car : ${item}</li>
    </c:forEach>
</body>
</html>
