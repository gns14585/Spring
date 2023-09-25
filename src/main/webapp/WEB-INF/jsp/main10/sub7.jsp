<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: AM 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>el에서 사용할 수 있는 연산자</h1>
<h4>산술연산자</h4>
<h4>+, -, *, /, %</h4>
<hr>
<h5>+ : 더하기</h5>
<p>${a} + ${b} = ${a + b}</p>
<p>${c} + ${d} = ${c + d}</p>

<h5>- : 빼기</h5>
<p>${a} - {b} = ${a - b}</p>
<p>${c} - {d} = ${c - d}</p>

<h5>* : 곱하기</h5>
<p>${a} * ${b} = ${a * b}</p>
<p>${c} * ${d} = ${c * d}</p>

<h5>/ : 나누기</h5>
<p>${a} / ${b} = ${a / b}</p>
<p>${c} / ${d} = ${c / d}</p>
<p>${a} / ${b} = ${a div b}</p>
<p>${c} / ${d} = ${c div d}</p>

<h5>% (mod) : 나머지(modulo, remainder)</h5>
<p>${b} % ${a} = ${b % a}</p>
<p>${c} % ${a} = ${c % a}</p>
<p>${d} % ${a} = ${d % a}</p>
<p>${b} % ${a} = ${b mod a}</p>
<p>${c} % ${a} = ${c mod a}</p>
<p>${d} % ${a} = ${d mod a}</p>

<h5>() : 우선순위 높음</h5>
<p>${a * b - c}</p>
<p>${a * (b - c)}</p>
<p>${(a * b) - c}</p>

<hr>
<h5>구구단 2단</h5>
<c:forEach begin="1" end="9" var="i">
    <p>2 X ${i} = ${2 * i}</p>
</c:forEach>

<hr>
<h5>구구단 2단 ~ 9단</h5>
<c:forEach begin="2" end="9" var="i">
    <c:forEach begin="1" end="9" var="l">
        <p>${i} * ${l} = ${i * l}</p>
    </c:forEach>
</c:forEach>

<hr>
<h5>구구단 9단 ~ 2단</h5>
<c:forEach begin="1" end="9" var="i">
    <h1>구구단 ${10-i}단</h1>
    <c:forEach begin="1" end="9" var="l">
        <p>${10-i} * ${l} = ${(10-i) * l}</p>
    </c:forEach>
</c:forEach>
</body>
</html>
