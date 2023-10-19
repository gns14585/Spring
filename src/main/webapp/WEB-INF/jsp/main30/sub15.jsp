<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-19
  Time: AM 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main30/sub15">
    <input type="text" name="id" placeholder="고객번호">
    <button>조회</button>
</form>

<div>
    <h3>${message}</h3>
</div>

<hr>

<form action="/main30/sub16" method="post">
    <div>
        <input type="text" name="id" value="${customer.id}">
    </div>
    <div>
        <input type="text" name="customerName" value="${customer.customerName}">
    </div>
    <div>
        <input type="text" name="contactName" value="${customer.contactName}">
    </div>
    <div>
        <input type="text" name="address" value="${customer.address}">
    </div>
    <div>
        <input type="text" name="city" value="${customer.city}">
    </div>
    <div>
        <input type="text" name="postalCode" value="${customer.postalCode}">
    </div>
    <div>
        <input type="text" name="country" value="${customer.country}">
    </div>
    <div>
        <button>수정</button>
    </div>
</form>

</body>
</html>
