<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: AM 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>empty</h2>
<p>null, 빈 문자열, 사이즈가 0인 컬렉션 이면 true</p>

<p>\${empty a} : ${empty a}}</p>
<p>\${empty b} : ${empty b}}</p>
<p>\${empty c} : ${empty c}}</p>
<p>\${empty d} : ${empty d}}</p>
<p>\${empty e} : ${empty e}}</p>
<p>\${empty f} : ${empty f}}</p>
<p>\${empty g} : ${empty g}}</p>
<p>\${empty h} : ${empty h}</p>

<h2>not empty (! empty)</h2>
<p>null 아닌 속성, 길이가 1이상인 컬렉션/문자열 true</p>
<%-- !(not) 을 붙히면 empty는 비어있는지 확인하는거니까 ! empyt 는 비어있지 않다로 인식되어서 true --%>

<p>\${not empty a} : ${not empty a}}</p>
<p>\${not empty b} : ${not empty b}}</p>
<p>\${not empty c} : ${not empty c}}</p>
<p>\${not empty d} : ${not empty d}}</p>
<p>\${not empty e} : ${not empty e}}</p>
<p>\${not empty f} : ${not empty f}}</p>
<p>\${not empty g} : ${not empty g}}</p>
<p>\${not empty h} : ${not empty h}</p>

</body>
</html>
