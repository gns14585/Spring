<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: AM 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>implicit el objects</h1>
<p>${pageScope}</p>
<p>${param}</p>
<p>${header}</p>

<hr>

<h1>param el 객체</h1>
<p>request parameter</p>
<%--
ex) name=son&age=33
("name", "son")
("age", "33")
두 entry를 param 맵에 넣어둠
--%>
<p>\${param.name} : ${param.name}</p>
<p>\${param.age} : ${param.age}</p>
<p>\${param.email} : ${param.email}</p>
</body>
</html>
