<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-15
  Time: PM 4:21
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
    h1, div {
        width: 100%;
        text-align: center;
    }

    table {
        margin: 0 auto;
        border-collapse: collapse;
        border: 1px solid black;
    }

    tr:first-child {
        background-color: #eeeeee;
        font-weight: bold;
    }

    tr td {
        text-align: center;
        border: 1px solid black;
    }

</style>
<h1>고객 목록</h1>
<div>
    <c:if test="${prevPageNumber >= 1}">
        <a href="/main27/sub1?page=${firstPageNumber}">처음</a>
        <a href="/main27/sub1?page=${prevPageNumber}">이전</a>
    </c:if>
    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
        <a href="/main27/sub1?page=${pageNumber}">${pageNumber}</a>
    </c:forEach>
    <c:if test="${nextPageNumber < lastPageNumber}">
        <a href="/main27/sub1?page=${nextPageNumber}">다음</a>
        <a href="/main27/sub1?page=${lastPageNumber}">마지막</a>
    </c:if>
</div>
<table>
    <tr>
        <td>번호</td>
        <td>이름</td>
        <td>주소</td>
        <td>도시</td>
        <td>나라</td>
    </tr>
    <c:forEach items="${custList}" var="i">
        <tr>
            <td>${i.customerID}</td>
            <td>${i.customerName}</td>
            <td>${i.address}</td>
            <td>${i.city}</td>
            <td>${i.country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
