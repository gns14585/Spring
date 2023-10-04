<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-04
  Time: PM 4:28
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
    h4 {
        width: 70%;
        text-align: center;
        margin: 0 auto;
    }

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

    th {
        border: 1px solid black;
    }

    td {
        border: 1px solid black;
        font-weight: 300;
    }
</style>
<h4>고객 목록</h4>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>country</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
