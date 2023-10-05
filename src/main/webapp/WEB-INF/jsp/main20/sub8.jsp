<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-05
  Time: PM 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>해당 가격 상품명</h1>
<table>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>PRICE</td>
    </tr>
    <c:forEach items="${proList}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.name}</td>
            <td>${i.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
