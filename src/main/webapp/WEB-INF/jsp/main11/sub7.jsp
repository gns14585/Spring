<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: PM 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- /main11/sub7?show=true--%>
<%-- table 형식 데이터 출력 --%>
<style>
    table {
        border-collapse: collapse;
        border: 1px solid black;
    }

    tr:first-child {
        font-weight: bold;
        background-color: #eeeeee;
    }

    tr td {
        padding: 10px;
        border: 1px solid black;
        text-align: center;
    }
</style>
<table>
    <c:choose>
        <c:when test="${param.show}">
            <tr>
                <td>Number</td>
                <td>ID</td>
                <td>Frist Name</td>
                <td>Last Name</td>
                <td>ClassName</td>
                <td>PhoneNumber</td>
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
        </c:when>
        <c:otherwise>
            <p>데이터가 없습니다.</p>
        </c:otherwise>
    </c:choose>

</table>

<%--/main11/sub7--%>
<%-- 데이터가 없습니다.--%>
</body>
</html>
