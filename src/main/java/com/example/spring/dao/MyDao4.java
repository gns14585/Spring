package com.example.spring.dao;

import com.example.spring.domain.*;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MyDao4 {
    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = #{id}
            """)
        // 파라미터가 하나면 이름이 일치하지 않아도 됨.
        // 두개 이상이면 꼭 이름이 동일 해야함
    String select1(int id);

    @Select("""
            SELECT ProductName
            FROM products
            WHERE Price BETWEEN #{from} AND #{to} -- 파라미터의 정확한 위치에 잘 맞춰서 사용해야함
            """)
    List<String> select2(Double from, Double to);

    @Select("""
            SELECT DISTINCT ProductName
            FROM orderdetails OD JOIN orders O
            ON OD.OrderID = O.OrderID
            JOIN products P
            ON P.ProductID = OD.ProductID
            WHERE O.OrderDate BETWEEN #{from} AND #{to}
            """)
    List<String> select3(LocalDate from, LocalDate to);

    @Select("""
            SELECT ProductName
            FROM products
            WHERE Price BETWEEN #{min} AND #{max}
            """)
    List<String> select4(MyDto25 dto);


    @Select("""
               -- country1 또는 country2에 사는 고객명 조회
               SELECT CustomerName
               FROM customers
               WHERE COUNTRY = #{country1} OR #{country2}  -- 방법1
            -- WHERE COUNTRY IN (#{country1}, #{country2}) -- 방법2
               """)
    List<String> select5(MyDto26 dto);


    // bean 2개일 경우
    // 파라미터명.필드명
    @Select("""
            SELECT COUNT(OrderID)
            FROM orders
            WHERE OrderDate BETWEEN #{dto1.from} AND #{dto2.to}
            """)
    Integer select6(MyDto27 dto1, MyDto28 dto2);


    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerName LIKE #{dto2.keyword}
            LIMIT #{dto1.from}, #{dto1.rows}
            """)
    List<String> select7(MyDto29 dto1, MyDto30 dto2);


    @Insert("""
            INSERT INTO customers (CustomerName, Country)
            VALUES (#{name}, #{country})
            """)
    int insert1(MyDto31 dto);

    @Insert("""
            INSERT INTO employees (LastName, FirstName)
            VALUES (#{lastName}, #{firstName})
            """)
    int insert2(MyDto32 emp);

    // 10-19일 시작
    @Delete("""
            DELETE FROM customers
            WHERE CustomerID = #{id}
            """)
    int delete1(Integer id);


    @Delete("""
            DELETE FROM products
            WHERE ProductID = #{pid}
            """)
    int delete2(Integer pid);


    @Select("""
            SELECT EmployeeID id, LastName, FirstName, BirthDate, Photo, Notes
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    MyDto33Employee select8(Integer id);

    @Update("""
            UPDATE employees
            SET LastName = #{lastName}, 
                FirstName = #{firstName},
                Photo = #{photo},
                Notes = #{notes},
                BirthDate = #{birthDate}
            WHERE EmployeeID = #{id}
            """)
    int update1(MyDto33Employee employee);

    @Select("""
            SELECT CustomerID id, CustomerName, ContactName, Address, City, PostalCode, Country
            FROM customers
            WHERE CustomerID = #{id}
            """)
    MyDto34Customer select9(Integer id);


    @Update("""
            UPDATE customers
            SET CustomerName = #{customerName},
                ContactName = #{contactName},
                Address = #{address},
                City = #{city},
                PostalCode = #{postalCode},
                Country = #{country}
            WHERE CustomerID = #{id}
            """)
    int update2(MyDto34Customer customer);
}


























