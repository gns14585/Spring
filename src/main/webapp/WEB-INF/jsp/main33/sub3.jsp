<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-20
  Time: PM 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>파일 전송</h3>
<form action="/main33/sub4" method="post" enctype="multipart/form-data">
    <input type="file" name="upload">
    <input type="submit" value="전송">
</form>
</body>
</html>
