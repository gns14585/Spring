<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-09-22
  Time: AM 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<hr>
<h1>${attr3.name}</h1>
<h1>${attr3["name"]}</h1>
<%-- <h1> ${attr3.my name} </h1> --%>
<h1>${attr3["my name"]}</h1>
<%-- <h1> ${attr3.your-name} </h3> --%>
<h1>${attr3["your-name"]}</h1>



<hr>
<h1>${myMap}</h1>
<h1>${myMap["son"]}</h1>
<h1>${myMap["lee"]}</h1>
<h1>${myMap["kim"]}</h1>

<hr>

<%--해당 문법을 더 자주 사용--%>
<h1>${myMap.son}</h1>
<h1>${myMap.lee}</h1>
<h1>${myMap.kim}</h1>

<hr>

<h1>${cityMap.seoul}</h1>
<h1>${cityMap.busan}</h1>
<h1>${color.red}</h1>
<h1>${color.blue}</h1>
<h1>${color["black"]}</h1>
</body>
</html>
