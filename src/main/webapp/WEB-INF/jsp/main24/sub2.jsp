<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-10
  Time: PM 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Supplier List</h1>

<table border="1">
    <thead>
    <tr>
        <th>Supplier Name</th>
        <th>Contact Name</th>
        <th>Address</th>
        <th>City</th>
        <th>Postal Code</th>
        <th>Country</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${custList}" var="supplier">
        <tr>
            <td>${supplier.supplierName}</td>
            <td>${supplier.contactName}</td>
            <td>${supplier.address}</td>
            <td>${supplier.city}</td>
            <td>${supplier.postalCode}</td>
            <td>${supplier.country}</td>
            <td>${supplier.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
