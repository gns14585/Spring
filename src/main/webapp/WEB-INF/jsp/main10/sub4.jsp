<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-22
  Time: PM 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>forEach tag</h1>
    <p>콘텐츠 반복 출력</p>
    <p>주요 addribute : begin, end, var, items, varStatus</p>

    <%--begin과 end 포함해서 반복 --%>
    <%--end는 begin보다 커야함--%>
    <%--begin = 시작 (포함) / end = 끝 (포함)--%>
    <c:forEach begin="0" end="3">
        <li>Lorem ipsum.</li>
    </c:forEach>

    <hr>

    <%--num에 0부터 들어감 총 3번 반복(0~2)--%>
    <c:forEach begin="0" end="2" var="num">
        <li>num : ${num}</li>
    </c:forEach>

    <hr>

    <c:forEach begin="0" end="2" var="num">
        <li>car : ${myList[num]}</li>
    </c:forEach>

    <hr>

    <c:forEach items="${myList}" var="item">
        <li>car2 : ${item}</li>
    </c:forEach>
</body>
</html>
