<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 이정훈
  Date: 2023-09-22
  Time: PM 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        text-align: center;
    }

    tr:first-child {
        background-color: #eeeeee;
        font-weight: bold;
    }

    tr td {

        border: 1px solid #eeeeee;
        padding: 10px;
    }
</style>

<table>
    <tr>
        <td>번호</td>
        <td>영화</td>
        <td>나라</td>
        <td>종류</td>
        <td>연령</td>
    </tr>
<%--    private String movie;   // 영화명--%>
<%--    private String contry;  // 나라별--%>
<%--    private String kind;    // 종류--%>
<%--    private String age;     // 연령--%>
    <c:forEach items="${mov}" var="item" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${item.movie}</td>
            <td>${item.contry}</td>
            <td>${item.kind}</td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
