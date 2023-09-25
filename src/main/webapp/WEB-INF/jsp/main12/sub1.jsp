<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-25
  Time: PM 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>form 요소</h1>

<form>
    <input type="text" name="param1">
    <br>
    <input type="text" name="param2">
    <br>
    <%-- select(option), textarea --%>
    <button>전송</button>

    <hr>

    <form>
        <%--전송버튼 클릭시
        ?name=lee&age=44&address=seoul&email=abc@naver.com
        --%>
        <input type="text" name="name" placeholder="이름을 적어주세요">
        <br>
        <input type="text" name="age" placeholder="나이를 적어주세요">
        <br>
        <input type="text" name="address" placeholder="주소를 적어주세요">
        <br>
        <input type="text" name="email" placeholder="메일을 적어주세요">
        <br>


    </form>
</form>

<hr>
<h3>action 속성 : request 파라미터를 어디로 보낼지 결정</h3>
<p>action 속성이 없거나 빈 문자열일 경우 현재경로</p>
<form action="https://search.naver.com/search.naver">
    <input type="text" name="query">
    <br>
    <button>전송</button>
</form>

<form action="https://google.com/search">
    <input type="text" name="q">
    <br>
    <button>전송</button>
</form>

<form action="https://search.daum.net/search">
    <input type="text" name="q">
    <button>다음에 전송</button>
</form>

<hr>

<h1>action 속성 값 : /로 시작하는 경우 path가 결정됨</h1>
<form action="/">
    <input type="text" name="email">
    <button>전송</button>
</form>
<%--전송버튼 클릭시 request parameter가 /main12/sub2로 전송되도록--%>
<form action="/main12/sub2">
    <input type="text" name="age">
    <button>전송</button>
</form>

<hr>
<h1>action 속성 값 : /도 아니고 protocol(scheme)이 아니면 현재 페이지의 상대경로</h1>
<h1>path에서 마지막 / 기준 (현재경로 기준)</h1>
<%--경로를 main12/sub2로 하게되면 실제 브라우저 주소에 main12/main12/sub2로 나옴--%>
<form action="/main12/sub2">
    <input type="text" name="email">
    <button>전송</button>
</form>

<form action="sub3">
    <input type="text" name="address">
    <button>전송</button>
</form>

<%-- ..: 한 경로 위--%>
<%--여러번 사용 가능 ex) ../../../.. --%>
<form action="..">
    <input type="text" name="age">
    <button>전송</button>
</form>
</body>
</html>
