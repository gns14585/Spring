<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-04
  Time: PM 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>공급자 목록</h3>
<table style="border-collapse: collapse; border: 1px solid black; width: 100%; text-align: center">
    <tr>
        <th style="background-color: #eeeeee">ID</th>
        <th style="background-color: #eeeeee">NAME</th>
        <th style="background-color: #eeeeee">PHONE</th>
    </tr>
    <c:forEach items="${shippers}" var="supplier">
        <tr>
            <td>${supplier.id}</td>
            <td>${supplier.name}</td>
            <td>${supplier.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
