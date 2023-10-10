package com.example.spring.controller;

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
@RequestMapping("main23")
public class Controller23 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(String keyword, Model model) throws SQLException {
        String sql = """
                SELECT * FROM products WHERE productName LIKE ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword +"%");
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet;) {
            System.out.println();
            System.out.println(keyword + "가 포함된 상품명들");
            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                System.out.println("name = " + name);
            }
        }
    }

    // //main23/sub2?k=erd
    // erd 라는 텍스트가 중간에 있는 고객명 조회
    @GetMapping("sub2")
    public void method2(@RequestParam(value = "k",defaultValue = "") String keyword,
                        Model model) throws SQLException {
        String sql = """
                SELECT * FROM customers
                WHERE customerName LIKE ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();

        List<String> list = new ArrayList<>();
        try (connection; resultSet; statement) {
            System.out.println();
            System.out.println(keyword + "가 포함된 고객명들");
            while (resultSet.next()) {
                String name = resultSet.getString("customerName");
//                System.out.println("name = " + name);
                list.add(name);
            }

            model.addAttribute("keyword", keyword);
            model.addAttribute("nameList", list);
        }
    }

    // /main23/sub3?st=name1 첫번째 if
    // /main23/sub3?st=name2 두번째 if
    // /main23/sub3?str=name2&k=red
    @GetMapping("sub3")
    public void method3(@RequestParam(value = "st", defaultValue = "name1") String searchType,
                        @RequestParam(value = "k", defaultValue = "") String keyword,
                        Model model) throws SQLException {
        String sql = """
                SELECT * FROM customers
                WHERE
                """;

        if (searchType.equals("name1")) {
            sql += "customerName LIKE ?";
        } else if (searchType.equals("name2")) {
            sql += "contactName LIKE ?";
        }

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");

        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                String customerName = resultSet.getString("customerName");
                String contactName = resultSet.getString("contactName");

                list.add(Map.of("customerName", customerName, "contactName", contactName));
            }
            model.addAttribute("searchType", searchType);
            model.addAttribute("keyword", keyword);
            model.addAttribute("customers", list);
        }
    }

    // 예제
    // 연습 많이 해보기
    @GetMapping("sub4")
    // "t" defaultValue 를 작성하지 않으면 브라우저 주소창에 /main23/sub4?t=lname or fname or note를 적어줘야 검색됨
    public void method4(@RequestParam(value = "t" , defaultValue = "lname") String searchType,
                        @RequestParam(value = "k", defaultValue = "") String keyword, Model model) throws Exception {
        String sql = """
                SELECT * FROM employees
                WHERE 
                """;
        // if, else if문을 통해 lastName , firstName , note 검색에 따라 결과가 달라짐
        // 해당 코드는 헷갈릴 수 있으므로 이해해야함 (위 sql 문이랑 연결됨)
        // if문 사용 1번째 방법
        if (searchType.equals("lname")) {
            sql += "lastName LIKE ?";
        } else if (searchType.equals("fname")) {
            sql += "firstName LIKE ?";
        } else if (searchType.equals("note")) {
            sql += "Notes LIKE ?";
        }
        /* switch 사용 2번째 방법
        switch (searchType) {
            case "lname":
                sql += "lastName LIKE ?";
                break;
            case "fname":
                sql += "firstName LIKE ?";
                break;
            case "note":
                sql += "Notes LIKE ?";
                break;
        }
        */
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        // 키워드 조합 "%" + keyword + "%" 이해하기
        statement.setString(1,"%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();

        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                // 1번째 방법
                /*
                Map<String, Object> map = new HashMap<>();
                map.put("lastName", resultSet.getString("lastName"));
                map.put("firstName", resultSet.getString("firstName"));
                map.put("notes", resultSet.getString("Notes"));
                list.add(map);
                */

                // 2번째 방법
                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                String notes = resultSet.getString("Notes");

                list.add(Map.of("lastName", lastName, "firstName", firstName, "notes", notes));
            }
        }
        model.addAttribute("custList", list);
        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);
    }
}
