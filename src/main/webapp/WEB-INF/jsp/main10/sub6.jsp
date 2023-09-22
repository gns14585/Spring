<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-22
  Time: PM 3:40
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
        width: 100%;
    }
    tr:first-child {
        background-color: #eee;
        font-weight: bold;
    }
    th, td {
        padding: 5px;
        text-align: center;
        border: 1px solid #eeeeee;
    }
</style>

<table>
    <tr>
        <td>id</td>
        <td>first Name</td>
        <td>last Name</td>
        <td>class</td>
        <td>Phone</td>
    </tr>
    <c:forEach items="${moving}" var="item" varStatus="status">
        <tr>
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
