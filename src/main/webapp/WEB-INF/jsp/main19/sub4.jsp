<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-04
  Time: PM 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    table {
        border-collapse: collapse;
        border: 1px solid black;
        width: 70%;
        text-align: center;
        margin: 0 auto;
    }

    tr:first-child {
        background-color: #eeeeee;
        font-weight: bold;
        border: 1px solid black;
    }

    td {
        border: 1px solid black;
        font-weight: 300;
    }
</style>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>CITY</th>
        <th>COUNTRY</th>
    </tr>
    <c:forEach items="${customers}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.city}</td>
            <td>${item.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
