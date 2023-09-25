<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: AM 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--true 일 경우--%>
<c:if test="${(param.dan >= 2) && (param.dan <=9) }" var="okDan">
    <h1>구구단 ${param.dan}단</h1>
    <c:forEach begin="1" end="9" var="i">
        <p>${param.dan} * ${i} = ${param.dan * i}</p>
    </c:forEach>
</c:if>

<%--false 일 경우--%>
<c:if test="${not okDan}">
    <p>2~9까지 단을 다시 입력해주세요</p>
</c:if>

</body>
</html>
