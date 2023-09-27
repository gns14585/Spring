<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-27
  Time: AM 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>\${modelAttr1} : ${modelAttr1}</h4>
    <h4>\${sessionAttr1} : ${sessionAttr1}</h4>
    <h4>\${appAttr1} : ${appAttr1}</h4>

    <hr>

    <h4>\${attr1} : ${attr1}</h4>
    <h4>\${sessionScope.attr1} : ${sessionScope.attr1}</h4>
    <h4>\${applicationScope.attr1} : ${applicationScope.attr1}</h4>


</body>
</html>
