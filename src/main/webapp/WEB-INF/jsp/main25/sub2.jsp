<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-11
  Time: AM 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>상품 지우기</h3>
<form action="" method="post">
    번호
    <%-- name은 @RequestParam에 넘어오는 값 (브라우저 주소창에 검색하는 란) --%>
    <input type="number" name="pid" placeholder="상품번호를 입력하세요">
    <button>지우기</button>
</form>
</body>
</html>
