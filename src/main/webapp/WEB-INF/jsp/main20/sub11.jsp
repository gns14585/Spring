<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-05
  Time: PM 4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>선택한 국가 목록</h1>
    <c:forEach items="${countryList}" var="i">
        <p>나라 : ${i}</p>
    </c:forEach>
</body>
</html>
