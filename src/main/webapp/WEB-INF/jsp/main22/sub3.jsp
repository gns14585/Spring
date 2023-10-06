<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-06
  Time: PM 2:25
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

    h1, div {
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

    <%--현재 페이지 색상 넣기--%>
    .active {
        background-color: darkblue;
        color: white;
    }
</style>
<h1>${param.page} / ${lastPageNumber}</h1>

<%--페이지 조회--%>
<div>
    <%--<a href="/main22/sub3?page=${leftPageNumber -1}"> << </a>
    <a href="/main22/sub3?page=${currentPage-1}"> < </a>--%>

    <%--1페이지 일땐 이전 버튼이 안나오게--%>
    <c:if test="${prevPageNumber > 0}">
        <a href="/main22/sub3?page=${firstPageNumber}">처음</a>
        <a href="/main22/sub3?page=${prevPageNumber}">이전</a>
    </c:if>
    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
        <a
            <%--현재 페이지 색상 넣기--%>
                <c:if test="${pageNumber == currentPage}">
                    class = "active"
                </c:if>
                href="/main22/sub3?page=${pageNumber}">${pageNumber}</a>
    </c:forEach>
    <%--마지막 페이지일땐 다음 버튼이 안나오게--%>
    <c:if test="${lastPageNumber >= nextPageNumber}">
        <a href="/main22/sub3?page=${nextPageNumber}">다음</a>
        <a href="/main22/sub3?page=${lastPageNumber}">마지막</a>
    </c:if>



    <%--<a href="/main22/sub3?page=${currentPage+1}"> > </a>
    <a href="/main22/sub3?page=${rightPageNumber +1}"> >> </a>--%>
</div>
<%--테이블 출력--%>
<table>
    <tr>
        <td>CustomerId</td>
        <td>CustomerName</td>
        <td>CustactName</td>
        <td>Address</td>
        <td>City</td>
        <td>PostalCode</td>
        <td>Country</td>
    </tr>
    <%--sql에서 가져온 데이터 조회--%>
    <c:forEach items="${cusList}" var="item">
        <tr>
            <td>${item.CustomerId}</td>
            <td>${item.CustomerName}</td>
            <td>${item.ContactName}</td>
            <td>${item.Address}</td>
            <td>${item.City}</td>
            <td>${item.PostalCode}</td>
            <td>${item.Country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
