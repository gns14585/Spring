package com.example.spring.controller;

import com.example.spring.domain.MyDto17Supplier;
import com.example.spring.domain.MyDto18Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main24")
public class Controller24 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {
        String sql = """
                INSERT INTO products (ProductName, SupplierID, CategoryID, Unit, Price)
                VALUE (?, ?, ?, ?, ?)
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement;) {
            statement.setString(1, "돈까스");
            statement.setInt(2, 3);
            statement.setInt(3, 4);
            statement.setString(4, "한장");
            statement.setDouble(5, 500.00);
            // INSERT는 (Delete, Update) 쿼리 사용
            int count = statement.executeUpdate();

            if (count == 1) {
                System.out.println("잘됨");
            } else {
                System.out.println("잘못됨");
            }
        }
    }

    // /main24/sub2로 요청시
    // suppliers 테이블에 하나의 레코드 추가하는 메소드 작성

    @PostMapping("sub2")
    public void method2(MyDto17Supplier supplier) throws Exception {
        String sql = """
                INSERT INTO suppliers 
                (SupplierName, ContactName, Address, City, PostalCode, Country, Phone) 
                VALUE (?, ?, ?, ?, ?, ?, ?);
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement;) {
            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getContactName());
            statement.setString(3, supplier.getAddress());
            statement.setString(4, supplier.getCity());
            statement.setString(5, supplier.getPostalCode());
            statement.setString(6, supplier.getCountry());
            statement.setString(7, supplier.getPhone());

            int count = statement.executeUpdate();

            if (count == 1) {
                System.out.println("이상없음");
            } else {
                System.out.println("이상함");
            }
        }
    }
    @GetMapping("sub3")
    public void method3() {

    }

    @GetMapping("sub4")
    public void method5() {

    }

    @PostMapping("sub4")
    public void method4(MyDto18Employee employee, Model model) throws Exception {
        String sql = """
                INSERT INTO employees (LastName, FirstName, BirthDate, Photo, Notes)
                VALUE (?, ?, ?, ?, ?)
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try(connection; statement;) {
            statement.setString(1, employee.getLastName());
            statement.setString(2, employee.getFirstName());
//            statement.setTimestamp(3, Timestamp.valueOf(employee.getBirthDate().atStartOfDay()));
            statement.setString(4, employee.getPhoto());
            statement.setString(5, employee.getNotes());
            int count = statement.executeUpdate();

            // 해당 if문은 데이터들이 출력하는데 이상 없는지 콘솔로 확인하는용
            if (count == 1) {
                System.out.println("이상없음");
            } else {
                System.out.println("이상함");
            }
        }
    }
}









