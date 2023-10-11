package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("main26")
public class Controller26 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws Exception {
        String sql = """
                INSERT INTO mydb1.my_table12 (int_col1, dec_col, str_col, date_col, date_time_col) 
                VALUE (?, ?, ?, ?, ?)
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try(connection; statement) {
            statement.setInt(1, 28465);
            statement.setDouble(2, 3.14);
            statement.setString(3, "string val");
            // 날짜 관련은 Timestamp 사용
            statement.setTimestamp(4, Timestamp.valueOf(LocalDate.now().atStartOfDay()));
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            statement.executeUpdate();
        }
    }

    @GetMapping("sub2")
    public void method2() throws Exception {
        String sql = """
                SELECT * 
                FROM mydb1.my_table12 
                LIMIT 1
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try (connection; statement; resultSet) {
            if (resultSet.next()) {
                int intCol = resultSet.getInt("int_col1");
                double decCol = resultSet.getDouble("dec_col");
                String strCol = resultSet.getString("str_col");
                LocalDate dateCol = resultSet.getTimestamp("date_col").toLocalDateTime().toLocalDate();
                LocalDateTime dateTimeCol = resultSet.getTimestamp("date_time_col").toLocalDateTime();

                System.out.println("intCol = " + intCol);
                System.out.println("decCol = " + decCol);
                System.out.println("strCol = " + strCol);
                System.out.println("dateCol = " + dateCol);
                System.out.println("dateTimeCol = " + dateTimeCol);
            }
        }
    }
}
