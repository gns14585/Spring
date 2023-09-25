<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
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
<c:if test="${not empty mes}">
    <p>${mes}</p>
</c:if>

<a href="/main12/sub5">다시 검색하러 가기</a>

</body>
</html>
