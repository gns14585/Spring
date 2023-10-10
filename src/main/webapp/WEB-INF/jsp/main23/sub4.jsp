<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-10
  Time: AM 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    table {
        border-collapse: collapse;
        font-size: 13px;
    }
    th {
        background-color: skyblue;
    }
    table, th, td {
        border: 1px solid black;
    }
</style>
<h4>직원 조회</h4>
<form action="">
    <div>
        검색 조건
        <select name="t">
            <%-- 검색 결과 박스를 저장해주는게 selected 키워드 --%>
            <%-- ex) firstName으로 검색했을때 selected를 작성하지 않으면 기본값인 lastName 으로 넘어감 --%>
            <%-- 근데 selected 설정하게 되면 검색한 firstName으로 고정됨 --%>
            <option value="lname" ${searchType == 'lanme' ? 'selected' : ''}>Last Name</option>
            <option value="fname" ${searchType == 'fname' ? 'selected' : ''}>First Name</option>
            <option value="note" ${searchType == 'note' ? 'selected' : ''}>Notes</option>
        </select>
    </div>
    <div>
        검색어
        <input type="text" name="k" value="${keyword}" placeholder="검색해주세요">
    </div>
    <div>
        <button>조회</button>
    </div>
</form>

<hr>
<table>
    <tr>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Notes</th>
    </tr>
    <c:forEach items="${custList}" var="i">
        <tr>
            <td>${i.lastName}</td>
            <td>${i.firstName}</td>
            <td>${i.notes}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
