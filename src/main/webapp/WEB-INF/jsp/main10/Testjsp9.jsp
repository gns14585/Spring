<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-24
  Time: PM 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>번호</td>
        <td>영화명</td>
        <td>종류</td>
        <td>연령</td>
        <td>나라</td>
    </tr>

    <c:forEach items="${mov}" var="item" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${item.movie}</td>
            <td>${item.kind}</td>
            <td>${item.age}</td>
            <td>${item.contry}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
