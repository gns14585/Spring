<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-04
  Time: PM 3:37
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

    th {
        border: 1px solid black;
    }

    td {
        border: 1px solid black;
        font-weight: 300;
    }
</style>
<table>
    <tr>
        <th>번호</th>
        <th>상품명</th>
        <th>단위</th>
        <th>가격</th>
    </tr>
    <c:forEach items="${productList}" var="prod">
        <tr>
            <td>${prod.pid}</td>
            <td>${prod.productName}</td>
            <td>${prod.unit}</td>
            <td>${prod.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
