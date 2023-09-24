<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-24
  Time: PM 5:35
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
        text-align: center;

    }

    tr:first-child {
        background-color: #eeeeee;
        font-weight: bold;
    }

    tr td {
        border: 1px solid black;
        padding: 10px;

    }
</style>
<table>

    <tr>
        <td>number</td>
        <td>ID</td>
        <td>First Name</td>
        <td>Last Nmae</td>
        <td>Address</td>
        <td>Phone</td>
    </tr>
    <c:forEach items="${moving}" var="item" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${item.id}</td>
            <td>${item.firstName}</td>
            <td>${item.lastName}</td>
            <td>${item.className}</td>
            <td>${item.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
