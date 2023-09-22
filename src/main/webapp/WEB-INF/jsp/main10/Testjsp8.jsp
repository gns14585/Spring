<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-22
  Time: PM 4:44
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
        border: 1px solid black;
        border-collapse: collapse;
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
        <td>번호</td>
        <td>이름</td>
        <td>나이</td>
        <td>주소</td>
    </tr>
    <c:forEach items="${Info}" var="item" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${item.name}</td>
            <td>${item.age}</td>
            <td>${item.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
