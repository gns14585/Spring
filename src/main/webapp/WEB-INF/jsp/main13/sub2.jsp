<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-26
  Time: AM 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub3">
    <div>
        <label for="input1">Lorem.</label>
        <input type="text" name="param1" id="input1">
    </div>
    <div>
        <label for="input2">Obcaecati.</label>
        <input type="number" name="param2" id="input2">
    </div>
    <div>
        <label for="input3">Recusandae!</label>
        <input type="password" name="param3" id="input3">
    </div>
    <div>
        <label for="input4">Perferendis.</label>
        <input type="date" name="param4" id="input4">
    </div>
    <div>
        <label for="input5">Illo.</label>
        <input type="datetime-local" name="param5" id="input5">
    </div>
    <div>
        <label for="input6">Repudiandae.</label>
        <input type="radio" name="param6" value="inaccept" id="input6">
    </div>
    <div>
        <label for="input7">Rerum.</label>
        <input type="radio" name="param6" value="accept" id="input7">
    </div>
    <div>
        <label for="input8">Consequuntur!</label>
        <input type="checkbox" name="param8" value="pizza" id="input8">
    </div>
    <div>
        <label for="input9">Eaque!</label>
        <input type="checkbox" name="param8" value="melon" id="input9">
    </div>
    <div>
        <label for="input10">Quos?</label>
        <input type="checkbox" name="param8" value="coffee" id="input10">
    </div>
    <button>전송</button>
</form>
</body>
</html>
