<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-24
  Time: PM 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="0" end="3" var="i">
  <p>${foodList[i]}</p>
</c:forEach>

<hr>
<c:forEach items="${names}" var="item">
  <p>${item}</p>
</c:forEach>

<hr>

<style>
  .box {
    border: 1px solid black;
    margin: 5px;
    display: flex;
    justify-content: space-between;
    padding: 10px;
  }
  .box > div {
    border: 2px solid orange;
  }
</style>

<c:forEach begin="0" end="3" var="n" varStatus="status">
  <div class="box">
    <div class="content1">
      n : ${n}
    </div>
    <div class="content2">
      <div>
        count : ${status.count}
      </div>
    </div>
  </div>
</c:forEach>

<hr>

<ul>
  <c:forEach items="${foodList}" var="item" varStatus="i">
    <p>${i.count} : ${item}</p>
  </c:forEach>
</ul>

</body>
</html>
