package com.example.spring.controller;

import com.example.spring.domain.MyDto15;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main20")
public class Controller20 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() {

    }

    @GetMapping("sub2")
    public String method2(String id, Model model) throws Exception {
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country FROM customers WHERE CustomerID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        List<MyDto15> list = new ArrayList<>();

        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                MyDto15 dto = new MyDto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        model.addAttribute("customerList", list);
        return "/main19/sub6";
    }

    @GetMapping("sub3")
    public void method3(String id, Model model) throws SQLException {
        String sql = """
                SELECT customerId, customerName, country FROM customers WHERE customerId = ?
                """;

        Connection connection = dataSource.getConnection();
        // 쿼리문에 ? 가 있는경우 prepareStatement 사용해야함
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet;) {
            while (resultSet.next()) {
                System.out.println();
                System.out.println("고객 정보");
                System.out.println("id = " + resultSet.getString(1));
                System.out.println("name = " + resultSet.getString(2));
            }
        }
    }
    // /main20/sub4?pid=5
    @GetMapping("sub4")
    public void method4(Model model, String pid) throws Exception {
        String sql = """
                SELECT productId, productName FROM products WHERE productId = ?        
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        // 첫번째 파라미터는 물음표의 위치 , 두번째 파라미터는 메소드 파라미터에 있는 값, +첫번째 파라미터와 타입이 동일해야함
        statement.setString(1, pid);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println();
            System.out.println("상품 정보");
            System.out.println("상품 번호 = " + resultSet.getInt(1));
            System.out.println("상품명 = " + resultSet.getString(2));
        }
    }

    // /main20/sub5?country=spain
    // 콘솔에 spain에 사는 고객 이름 출력
    @GetMapping("sub5")
    public void method5(String country, Model model) throws SQLException {
        String sql = """
                SELECT Country, CustomerName FROM customers WHERE Country = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println();
            System.out.println("나라 이름");
            System.out.println("나라 = " + resultSet.getString(1));
            System.out.println("고객명 = " + resultSet.getString(2));
        }
    }

    @GetMapping("sub6")
    public void method6(String c1, String c2) throws Exception {
        String sql = """
                SELECT customerName, country FROM customers WHERE country = ? OR country = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, c1);
        statement.setString(2, c2);

        ResultSet resultSet = statement.executeQuery();

        List<String> list = new ArrayList<>();

        try(connection; statement; resultSet;) {
            while (resultSet.next()) {
                String country = resultSet.getString(2);
                String name = resultSet.getString(1);

                System.out.println(country + ":" + name);
            }
        }
    }

    @GetMapping("sub7")
    public void method7() {

    }

    // 가격으로 상품 조회 + 예제연습하기 좋음
    // dto로도 한번 만들어보기
    // 콘솔로도 찍어보고 브라우저로도 출력해보기
    @GetMapping("sub8")
    public String method8(Integer min, Integer max, Model model) throws Exception {
        String sql = """
                SELECT ProductID, ProductName, Price FROM products WHERE Price >= ? AND Price <= ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, min);
        statement.setInt(2, max);

        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();

        try(connection; statement; resultSet;) {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", resultSet.getString(1));
                map.put("name", resultSet.getString(2));
                map.put("price", resultSet.getString(3));

                list.add(map);
            }
        }
        model.addAttribute("proList", list);

        return "/main20/sub8";
    }

    // /main20/sub9?country=spain&country=mexico&country=uk
    @GetMapping("sub9")
    public void method9(@RequestParam("country") List<String> countryList) throws SQLException {
        String questionMarks = "";
        for (int i = 0; i < countryList.size(); i++) {
            questionMarks += "?";

            if (i < countryList.size()-1) {
                questionMarks += ", ";
            }
        }
        // 특정 국가에 속한 고객들 조회
        String sql = """
                SELECT *
                FROM customers
                WHERE country IN ("""

                +

                questionMarks

                +

                """
                )
                """;

//        System.out.println("sql = " + sql);

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < countryList.size(); i++) {
            statement.setString(i + 1, countryList.get(i));
        }
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String country = resultSet.getString(7);

                System.out.println(name + " : " + country);
            }
        }
    }

    // 문제
    @GetMapping("sub10")
    public void method10(Model model) throws SQLException {
        String sql = """
                SELECT DISTINCT country FROM suppliers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> list = new ArrayList<>();
        try(connection; statement; resultSet;) {
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        }


        model.addAttribute("countryList", list);
    }

    @GetMapping("sub11")
    public String method11(@RequestParam("country") List<String> countryList, Model model) throws Exception {
        String rttr = "";
        for (int i = 0; i < countryList.size(); i++) {
            rttr += "?";
            if (i < countryList.size()-1) {
                rttr += ", ";
            }
        }
        String sql = """
                SELECT DISTINCT Country FROM suppliers WHERE Country IN ("""
                +
                rttr
                +
                """
                )
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < countryList.size(); i++) {
            statement.setString(i+1, countryList.get(i));
        }
        ResultSet resultSet = statement.executeQuery();

        List<String> list = new ArrayList<>();
        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        }
        model.addAttribute("countryList", list);
        return "/main20/sub11";

    }







}

