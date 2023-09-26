<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-26
  Time: PM 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main14/sub4" method="post">
    <div>
        제목 :
        <input type="text" name="title">
    </div>
    <div>
        주제 :
        <textarea type="text" name="content">
        </textarea>
    </div>
    <button>전송</button>
</form>
</body>
</html>
