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
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String method1(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) throws SQLException {
        String sql = """
                SELECT CustomerID ,CustomerName, Address, City, Country 
                FROM customers ORDER BY CustomerID LIMIT ? , ?
                """;

        String sql1 = """
                SELECT COUNT(*) FROM customers;
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (page - 1) * 5);
        statement.setInt(2, 5);
        ResultSet resultSet = statement.executeQuery();

        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);

        List<Map<String, Object>> list = new ArrayList<>();

        int lastPageNumber = 1;
        try (connection; connection1; statement; statement1; resultSet; resultSet1) {
            while (resultSet.next()) {
                if (resultSet1.next()) {
                    int countAll = resultSet1.getInt(1);
                    lastPageNumber = (countAll - 1) / 5;

                    model.addAttribute("lastPageNumber", lastPageNumber);
                }
                Map<String, Object> map = new HashMap<>();
                /*CustomerID ,CustomerName, Address, City, Country*/
                map.put("customerID", resultSet.getString("CustomerID"));
                map.put("customerName", resultSet.getString("CustomerName"));
                map.put("address", resultSet.getString("Address"));
                map.put("city", resultSet.getString("City"));
                map.put("country", resultSet.getString("Country"));

                list.add(map);
                System.out.println("list = " + list);
            }
        }
        int leftPageNumber = (page - 1) / 5 * 5 + 1;
        int rightPageNumber = leftPageNumber + 4;
        rightPageNumber = Math.min(rightPageNumber, lastPageNumber);

        int prevPageNumber = leftPageNumber - 4;
        int nextPageNumber = rightPageNumber + 1;
        int firstPageNumber = 1;

        model.addAttribute("firstPageNumber", firstPageNumber);
        model.addAttribute("prevPageNumber", prevPageNumber);
        model.addAttribute("nextPageNumber", nextPageNumber);
        model.addAttribute("leftPageNumber", leftPageNumber);
        model.addAttribute("rightPageNumber", rightPageNumber);
        model.addAttribute("custList", list);

        return "/main27/sub1";
    }
}
