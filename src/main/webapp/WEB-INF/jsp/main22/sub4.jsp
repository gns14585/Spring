<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-06
  Time: PM 4:58
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
    a {
        width: 100%;
        text-align: center;
        text-decoration: none;
    }

    h3 {
        width: 100%;
        text-align: center;
        margin: 10px;

    }

    table {
        width: 70%;
        margin: 0 auto;
        border: 1px solid #eeeeee;
        border-collapse: collapse;
        text-align: center;
        font-size: 13px;
    }

    tr:first-child {
        background-color: #eeeeee;
        font-weight: bold;

    }

    td {
        border: 1px solid #eeeeee;
    }

    .pa {
        background-color: darkblue;
        color: white;
    }
</style>

<h3>${param.page} / ${lastPageNumber}</h3>
<div>
    <c:if test="${prevPageNumber > 0}">
        <a href="/main22/sub4?page=${firstPage}">처음</a>
        <a href="/main22/sub4?page=${prevPageNumber}"> 이전</a>
    </c:if>
    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
        <a
                <c:if test="${currentPage == pageNumber}">
                    class = "pa"
                </c:if>
                href="/main22/sub4?page=${pageNumber}">${pageNumber}</a>
    </c:forEach>
    <c:if test="${lastPageNumber >= nextPageNumber}">
        <a href="/main22/sub4?page=${nextPageNumber}">다음</a>
        <a href="/main22/sub4?page=${lastPageNumber}">마지막</a>
    </c:if>
</div>
<table>
    <tr>
        <%--CustomerID, CustomerName, Address, City, Country--%>
        <td>CustomerID</td>
        <td>CustomerName</td>
        <td>Address</td>
        <td>City</td>
        <td>Country</td>
    </tr>
    <c:forEach items="${tableList}" var="i">
        <tr>
            <td>${i.CustomerID}</td>
            <td>${i.CustomerName}</td>
            <td>${i.Address}</td>
            <td>${i.City}</td>
            <td>${i.Country}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
