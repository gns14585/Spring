<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-26
  Time: PM 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub8">
    <div>
        <label for="input1">아이디</label>
        <input type="text" id="input1" name="id">
    </div>

    <div>
        <label for="input2">이름</label>
        <input type="text" id="input2" name="name">
    </div>

    <div>
        <label for="input3">주소</label>
        <input type="text" id="input3" name="address">
    </div>

    <div>
        <label for="input4">약속시간</label>
        <input type="datetime-local" id="input4" name="schedule">
    </div>

    <div>
        <label for="input5">카페</label>
        <input type="checkbox" id="input5" name="todos">
    </div>

    <div>
        <label for="input6">영화</label>
        <input type="checkbox" id="input6" name="todos">
    </div>

    <div>
        <label for="input7">산책</label>
        <input type="checkbox" id="input7" name="todos">
    </div>
    <button>전송</button>
</form>
</body>
</html>
