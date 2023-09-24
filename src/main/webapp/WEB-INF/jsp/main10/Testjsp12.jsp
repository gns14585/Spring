<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-24
  Time: PM 1:18
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
    h1 {
        margin: 0 auto;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    table {
        border-collapse: collapse;
        width: 100%;
        margin: 0 auto;
        display: flex;
        justify-content: center;
        align-items: center;

    }

    tr:first-child {
        background-color: #eeeeee;
        font-weight: bold;
    }

    tr td {
        text-align: center;
        padding: 10px;
        border: 1px solid #eeeeee;
    }

</style>
<h1>Practice</h1>

<table>
    <tr>
        <td>번호</td>
        <td>이름</td>
        <td>나이</td>
        <td>성별</td>
        <td>주소</td>
    </tr>

    <c:forEach items="${Info}" var="item" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${item.name}</td>
            <td>${item.age}</td>
            <td>${item.gender}</td>
            <td>${item.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
