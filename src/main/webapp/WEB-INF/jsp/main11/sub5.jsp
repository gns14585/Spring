<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: PM 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jstl choose, when, otherwise tag</h1>
<%--choose 안에 있는 when 중 처음 만나는 태그가 true이면 그것만 실행--%>
<c:choose>
    <c:when test="false">
        <p>when 1번</p>
    </c:when>
    <c:when test="false">
        <p>when 2번</p>
    </c:when>
    <c:when test="false">
        <p>when 3번</p>
    </c:when>

<%--choose 가 다 false 이면 실행되는 otherwise--%>
    <c:otherwise>
        <p>otherwise 태그 내용</p>
    </c:otherwise>
</c:choose>
</body>
</html>
