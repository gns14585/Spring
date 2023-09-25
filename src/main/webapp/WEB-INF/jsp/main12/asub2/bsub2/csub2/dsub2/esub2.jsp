<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: PM 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%----%>
<h3>상대경로 .. 은 한 path 위</h3>
<form action="..">
    <input type="text" name="age">
    <button>전송</button>
</form>

<%--여러번 사용 가능 ex) ../../../.. --%>
<form action="../..">
    <button>전송</button>
</form>

<form action="../dsub3">
    <button>전송</button>
</form>

<form action="../../csub3">
    <button>전송</button>
</form>

<form action="../../csub3/../bsub3">
    <button>전송</button>
</form>
</body>
</html>
