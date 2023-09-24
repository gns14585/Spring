<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-24
  Time: PM 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${people["1st"].lastName}</h1>
<h1>${people["2nd"].lastName}</h1>

<hr>

<h3>${person1.cars[0]}</h3>
<h3>${person1.cars[1]}</h3>
<h3>${person1.cars[2]}</h3>
</body>
</html>
