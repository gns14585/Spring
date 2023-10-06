<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-06
  Time: AM 11:46
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
        margin: 10px;
    }

    a {
        text-decoration: none;
    }

    a:visited {
        color: black;
    }

    table {
        margin: 0 auto;
        border: 1px solid #eeeeee;
        text-align: center;
        border-collapse: collapse;
        font-size: 13px;
    }

    tr:first-child td {
        background-color: #eeeeee;
        font-weight: bold;
    }

    td {
        border: 1px solid #eeeeee;
        font-weight: 200;
        padding: 5px;
    }



</style>
<h1>${param.page} / 5</h1>
<div>
    <c:forEach begin="1" end="${lastPageNumber}" var="pageNumber">
        <a href="/main22/sub2?page=${pageNumber}">${pageNumber}</a>
    </c:forEach>
</div>
<table>
    <tr>
        <td>ID</td>
        <td>SUPPLIERNAME</td>
        <td>COUNTACTNAME</td>
        <td>ADDRESS</td>
        <td>CITY</td>
    </tr>

    <c:forEach items="${pageList}" var="supplier">
        <tr>
            <td>${supplier.SupplierID}</td>
            <td>${supplier.SupplierName}</td>
            <td>${supplier.ContactName}</td>
            <td>${supplier.Address}</td>
            <td>${supplier.City}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
