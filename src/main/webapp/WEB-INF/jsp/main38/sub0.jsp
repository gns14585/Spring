<%--
  Created by IntelliJ IDEA.
  User: 사용자
  Date: 2023-10-24
  Time: PM 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<button onclick="ajax1()">button1</button>
<script>
    function ajax1() {
        axios.get("/main38/sub1");
    }
</script>
</body>
<div>
    <button onclick="ajax2()">button2</button>
    <script>
        function ajax2() {
            axios.get("/main38/sub2")
                .then(function (response) {
                    console.log("응답 받은 후 해야하는 일");
                    console.log(response.data);
                    console.log(response.status);
                    console.log(response.statusText);
                    console.log(response.headers);
                    console.log(response.config);
                });
        }
    </script>
</div>

<div>
    <button onclick="ajax3()">button3</button>
    <script>
        function ajax3() {
            axios.get("/main38/sub3")
                .then(function (res) {
                    console.log(res.data);
                    console.log(res.data.age);
                    console.log(res.data.name);
                });
        }
    </script>
</div>

<div>
    <button onclick="ajax4()">button4</button>
    <script>
        function ajax4() {
            axios.get("/main38/sub4")
                .then(function (response) {
                    const data = response.data;
                    console.log(data.city)
                    console.log(data.price)
                    console.log(data.list[0])
                    console.log(data.birth)
                });
        }
    </script>
</div>

<div>
    <input type="text" id="input1" value="7">
    <button onclick="ajax5()">button5</button>
    <script>
        function ajax5() {
            const pid = document.querySelector("#input1").value;
            axios.get("/main38/sub5?id=" + pid)
                .then(function (response) {
                    const product = response.data;
                    console.log(product.ProductID);
                    console.log(product.ProductName);
                    console.log(product.Unit);
                    console.log(product.Price);
                })
        }
    </script>
</div>

<div>
    <button onclick="ajax6()">button6</button>
    <script>
        function ajax6() {
            axios.get("/main38/sub2")
                .then(function (p) {
                    console.log("응답 완료 후 실행");
                })
                .then(function (p) {
                    console.log("그 다음 실행");
                })
                .then(function (p) {
                    console.log("또 그 다음 실행")
                })
        }
    </script>
</div>

<div>
    <button onclick="ajax7()">button7</button>
    <script>
        function ajax7() {
            axios.get("/main38/sub2")
                .then(function () {
                    console.log('첫 함수')
                    return "abcd";
                })
                .then(function (param) { // 직전 함수의 리턴한 값이 들어감
                    console.log('두번째 함수')
                    console.log(param)
                    return 345;
                })
                .then(function (param) {
                    console.log(param) // 직전 함수의 리턴한 값이 들어감
                })
        }
    </script>
</div>

<div>
    <button onclick="ajax8()">button8</button>
    <script>
        function ajax8() {
            axios.get("/main38/sub2")
                .then(function (param) {
                    console.log("첫번째 함수 일함")
                    return param.data;
                })
                .then(function (param) {
                    console.log("두번째 함수 일함")
                    console.log(param)
                })
        }
    </script>
</div>

<div>
    <button onclick="ajax9()">button9</button>
    <script>
        function ajax9() {
            axios.get("/main38/sub2")
                .then(response => response.data)
                .then(data => console.log(data));
        }
    </script>
</div>


</html>
