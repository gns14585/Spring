package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(@RequestParam(value = "id", required = false) Integer customerId) throws SQLException {

        // 주소창에 ?id=값 안넣어주면 id 넣으라고 콘솔에 문구 출력
        if (customerId == null) {
            System.out.println("삭제할 id를 넣어주세요");
            return;
        }
        String sql = """
                DELETE FROM customers WHERE customerID = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement;) {
            statement.setInt(1, customerId);
            int rows = statement.executeUpdate();

            if (rows == 1) {
                System.out.println(rows + "개 레코드 잘 지워짐");
            } else {
                System.out.println("지워지지 않음");
            }
        }
    }

    @GetMapping("sub2")
    public void method2() {

    }

    // 1) 예제
    // 브라우저에 번호를 입력하면 해당 테이블에 ID 행 삭제
    @PostMapping("sub2")
    public void method2(@RequestParam(value = "pid", required = false) Integer delete) throws SQLException {
        String sql = """
                DELETE FROM products WHERE ProductID = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement;) {
            statement.setInt(1, delete);
            int de = statement.executeUpdate();
            if (de == 1) {
                System.out.println("o");
            } else {
                System.out.println("x");
            }
        }
    }

    @GetMapping("sub4")
    public void method4() throws SQLException {
        String sql = """
                UPDATE shippers
                SET ShipperName = ?, phone = ?
                WHERE ShipperID = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement) {
            statement.setString(1, "이강인");
            statement.setString(2, "01036138304");
            statement.setInt(3, 1);

            int rows = statement.executeUpdate();

            if (rows == 1) {
                System.out.println("잘 변경됨");
            } else {
                System.out.println("문제있음");
            }
        }
    }

    @GetMapping("sub5")
    public void method5(@RequestParam(value = "id", defaultValue = "1") Integer shipperId, Model model) throws SQLException {
        String sql = """
                SELECT * FROM shippers
                WHERE shipperId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        // 행이 하나이기 때문에 List , Map 객체 선언 할 필요 없음
        try (connection; statement) {
            statement.setInt(1, shipperId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    // Map 객체 선언 안해도 Map.of 사용 가능
                    model.addAttribute("shipper", Map.of("shipperId", resultSet.getInt("shipperId"),
                            "shipperName", resultSet.getString("shipperName"),
                            "phone", resultSet.getString("phone")));
                }
            }
        }
    }

    @PostMapping("sub5")
    public String method6(
            @RequestParam("id") Integer shipperId,
            @RequestParam("name") String shipperName,
            @RequestParam("phone") String phone,
            RedirectAttributes rttr
    ) throws SQLException {
        String sql = """
                UPDATE shippers
                SET shipperName = ?,
                    phone = ?
                WHERE
                    shipperId = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement) {
            statement.setString(1, shipperName);
            statement.setString(2, phone);
            statement.setInt(3, shipperId);

            int rows = statement.executeUpdate();

            // if문은 제대로 되었는지 콘솔에 확인하는 용도라 굳이 작성 할 필요 없음
            if (rows == 1) {
                System.out.println("잘 변경됨");
            } else {
                System.out.println("문제 생김");
            }
        }
        rttr.addAttribute("id", shipperId);
        // redirect 쓰는 이유는 저장 버튼 누르면 화면이 초기화 되는데, 해당 저장하려는 정보들 그대로 노출
        return "redirect:/main25/sub5";
    }

    @GetMapping("sub7")
    public void method7(@RequestParam(value = "id", required = false) Integer employeeId, Model model) throws SQLException {
        if (employeeId == null) {
            return;
        }
        String sql = """
                SELECT * FROM employees
                WHERE employeeId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    String lastName = resultSet.getString("lastName");
                    String firstName = resultSet.getString("firstName");
                    String birthDate = resultSet.getString("birthDate");
                    String photo = resultSet.getString("photo");
                    String notes = resultSet.getString("notes");

                    model.addAttribute("employee", Map.of("lastName", lastName,
                            "firstName", firstName,
                            "birthDate", birthDate,
                            "photo", photo,
                            "notes", notes,
                            "employeeId", employeeId));
                }
            }
        }
    }

    @PostMapping("sub7")
    public String method7(String lastName,
                          String firstName,
                          String birthDate,
                          String photo,
                          String notes,
                          @RequestParam("id") Integer employeesId,
                          RedirectAttributes rttr) throws SQLException {
        String sql = """
                UPDATE employees
                SET LastName = ?,
                FirstName = ?,
                BirthDate = ?,
                Photo = ?,
                Notes = ?
                WHERE EmployeeID = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement;) {
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, birthDate);
            statement.setString(4, photo);
            statement.setString(5, notes);
            statement.setInt(6, employeesId);

            int rowss = statement.executeUpdate();

            if (rowss == 1) {
                rttr.addFlashAttribute("message", "직원 정보가 변경되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "직원 정보가 변경되지 않았습니다.");
            }
        }
        rttr.addAttribute("id", employeesId);
        return "redirect:/main25/sub7";
    }

    @GetMapping("sub9")
    public String method9(RedirectAttributes rttr) {
        // Controller의 request handler 메소드의 리턴이
        // void(또는 null 리턴) 이면 view의 이름으로 해석

        // String 이면 view의 이름으로 해석
        // "redirect:" 접두어가 붙으면
        // 응답코드가 302이고 location 응답 헤더의 값이 접두어 이후의 값으로 셋팅

        // 쿼리스트링에 request parameter로 붙음
        rttr.addAttribute("abc", "def");
        rttr.addAttribute("address", "seoul");

        // 모델에 붙임(session을 잠깐 거침)
        rttr.addFlashAttribute("email", "abc@gmail.com");
        return "redirect:/main25/sub10";
    }

    @GetMapping("sub10")
    public void method10(Model model) {
        Object email = model.getAttribute("email");
        System.out.println("email = " + email);
        System.out.println("Controller25.method10");
    }


}














