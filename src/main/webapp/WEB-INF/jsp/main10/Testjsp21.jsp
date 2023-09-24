<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-24
  Time: PM 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${studentList[0].firstName}</h3>
<h3>${studentList[1].firstName}</h3>
<h3>${studentList[2].firstName}</h3>

<hr>

<h3>${personMap.person1.lastName}</h3>
<h3>${personMap.person2.lastName}</h3>
<h3></h3>
</body>
</html>
