package com.example.spring.controller;

import com.example.spring.domain.MyDto15;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}

