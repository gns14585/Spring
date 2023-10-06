package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@Controller
@RequestMapping("main22")
public class Controller22 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Integer page) throws Exception {
        String sql = """
                SELECT customerId id, customerName name FROM customers ORDER BY id LIMIT ?, ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, 0); // 1페이지
//        statement.setInt(1, 10); // 2페이지

        // (page - 1) * 10 코드 작성하게 되면 원하는 페이지로 검색 가능
        statement.setInt(1, (page - 1) * 10);
        statement.setInt(2, 10);
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet;) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println(id + " : " + name);
            }
        }
    }

    // 해당 예제 중요 잘 보고 복습 열심히 해야함
    // jsp파일까지 만들어서 브라우저에 출력 가능하도록
    // 페이지당 7개씩 공급자 목록 조회
    // /main22/sub2?p=3
    @GetMapping("sub2")
    public String method2(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) throws Exception {
        String sql = """
                SELECT SupplierID, SupplierName, ContactName, Address, City FROM suppliers ORDER BY SupplierID LIMIT ? , ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (page - 1) * 7);
        statement.setInt(2, 7);
        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("SupplierID", resultSet.getString("SupplierID"));
                map.put("SupplierName", resultSet.getString("SupplierName"));
                map.put("ContactName", resultSet.getString("ContactName"));
                map.put("Address", resultSet.getString("Address"));
                map.put("City", resultSet.getString("City"));

                list.add(map);
            }
        }

        String sql1 = """
                SELECT COUNT(*) FROM suppliers
                """;
        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);
        try (statement1; resultSet1; connection1) {
            if (resultSet1.next()) {
                int countAll = resultSet1.getInt(1);

                // 마지막 페이지 번호
                int lastPageNumber = ((countAll - 1) / 7) + 1;
                model.addAttribute("lastPageNumber", lastPageNumber);
            }
        }


        model.addAttribute("pageList", list);
        return "/main22/sub2";

    }

    // /main22/sub3?p=2
    // 2페이지 고객목록 jsp 테이블 형식 출력
    // 1페이지당 15개씩 리스트 출력
    // 페이지 번호를 링크로
    @GetMapping("sub3")
    public String method3(Model model, @RequestParam(defaultValue = "1") Integer page) throws Exception {
        String sql = """
                SELECT *
                FROM customers ORDER BY CustomerID LIMIT ? , ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (page - 1) * 5);
        statement.setInt(2, 5);
        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("CustomerId", resultSet.getString(1));
                map.put("CustomerName", resultSet.getString(2));
                map.put("ContactName", resultSet.getString(3));
                map.put("Address", resultSet.getString(4));
                map.put("City", resultSet.getString(5));
                map.put("PostalCode", resultSet.getString(6));
                map.put("Country", resultSet.getString(7));

                list.add(map);
            }
        }

        // 페이지 몇개인지 조회
        String sql1 = """
                SELECT COUNT(*) FROM customers
                """;
        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);

        int lastPageNumber = 1;
        try (connection1; statement1; resultSet1) {
            if (resultSet1.next()) {
                int countAll = resultSet1.getInt(1);

                // 마지막 페이지 번호 계산식 5는 몇개 보여줄건지 갯수
                lastPageNumber = ((countAll - 1) / 5) + 1;
                model.addAttribute("lastPageNumber", lastPageNumber);
            }
        }

        model.addAttribute("cusList", list);

        // 현재 페이지 색상 넣기
        model.addAttribute("currentPage", page);

        // 왼쪽, 오른쪽 페이지 5개씩 넘어가기
        int leftPageNumber = (page - 1) / 5 * 5 + 1;
        int rightPageNumber = leftPageNumber + 4;
        int prevPageNumber = leftPageNumber - 5;
        int nextPageNumber = rightPageNumber + 1;
        int firstPageNumber = 1;

        rightPageNumber = Math.min(rightPageNumber, lastPageNumber);

        model.addAttribute("firstPageNumber", firstPageNumber);
        model.addAttribute("prevPageNumber", prevPageNumber);
        model.addAttribute("nextPageNumber", nextPageNumber);
        model.addAttribute("leftPageNumber", leftPageNumber);
        model.addAttribute("rightPageNumber", rightPageNumber);



        return "/main22/sub3";


    }
    // /main22/sub4p=2
    // 2페이지 고객목록 jsp 테이블 형식 출력
    // 1페이지당 5개씩 리스트 출력
    // 페이지 번호를 링크로

    @GetMapping("sub4")
    public String method4(@RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {
        String sql = """
                SELECT CustomerID, CustomerName, Address, City, Country 
                FROM customers ORDER BY CustomerID LIMIT ? , ?
                """;

        String sql1 = """
                SELECT COUNT(*) FROM customers;
                """;

        // sql
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (page - 1) * 5);
        statement.setInt(2, 5);
        ResultSet resultSet = statement.executeQuery();

        // sql1
        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);

        List<Map<String, Object>> list = new ArrayList<>();
        int lastPageNumber = 1;
        try(connection; connection1; statement; statement1; resultSet; resultSet1) {
            while (resultSet.next()) {
                if (resultSet1.next()) {
                    int countAll = resultSet1.getInt(1);

                    lastPageNumber = ((countAll - 1) / 5);
                    model.addAttribute("lastPageNumber", lastPageNumber);
                }
                Map<String, Object> map = new HashMap<>();
                // CustomerID, CustomerName, Address, City, Country
                map.put("CustomerID", resultSet.getString("CustomerID"));
                map.put("CustomerName", resultSet.getString("CustomerName"));
                map.put("Address", resultSet.getString("Address"));
                map.put("City", resultSet.getString("City"));
                map.put("Country", resultSet.getString("Country"));

                list.add(map);
            }
        }

        int leftPageNumber = (page - 1) / 5 * 5 + 1;
        int rightPageNumber = leftPageNumber + 4;
        int prevPageNumber = leftPageNumber - 5;
        int nextPageNumber = rightPageNumber + 1;
        int firstPage = 1;

        rightPageNumber = Math.min(rightPageNumber, lastPageNumber);

        model.addAttribute("firstPage", firstPage);pp
        model.addAttribute("prevPageNumber", prevPageNumber);
        model.addAttribute("nextPageNumber", nextPageNumber);
        model.addAttribute("currentPage", page);
        model.addAttribute("leftPageNumber", leftPageNumber);
        model.addAttribute("rightPageNumber", rightPageNumber);
        model.addAttribute("tableList", list);

        return "/main22/sub4";
    }














}
