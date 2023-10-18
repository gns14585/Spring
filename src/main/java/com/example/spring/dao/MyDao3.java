package com.example.spring.dao;

import com.example.spring.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao3 {
    @Select("""
            SELECT CustomerName FROM customers
            WHERE CustomerID = 1
            """)
    String select1();

    @Select("""
            SELECT Price FROM products
            WHERE ProductID = 1
            """)
    Double select2();


    @Select("""
            SELECT LastName FROM employees
            WHERE EmployeeID = 1
            """)
    String select3();


    @Select("""
            SELECT BirthDate FROM employees
            WHERE EmployeeID = 2
            """)
    LocalDate select4();


    @Select("""
            SELECT DISTINCT Country
            FROM customers
            ORDER BY 1
            """)
        // 여러 행일 땐 List< > 로 받아야함
    List<String> select5();

    @Select("""
            SELECT BirthDate FROM employees
            ORDER BY 1
            """)
    List<String> select6();


    @Select("""
            SELECT Price FROM products
            ORDER BY 1
            """)
    List<Double> select7();


    @Select("""
            SELECT CustomerID, CustomerName, Address
            FROM customers
            WHERE CustomerID = 1
            """)
        // map은 순서가 없어서 어떤게 먼저 출력될지 모름
    Map<String, Object> select8();


    @Select("""
            SELECT p.ProductName, p.Price, c.CategoryName
            FROM products P JOIN categories C 
            ON P.CategoryID = c.CategoryID
            WHERE p.ProductID = 1
            """)
    Map<String, Object> select9();


    // java bean
    @Select("""
            SELECT EmployeeID, LastName, FirstName
            FROM employees
            WHERE EmployeeID = 1
            """)
    MyDto19_2 select10();

    @Select("""
            -- select 별칭 가능
            SELECT P.ProductName name, P.Price, C.CategoryName category
            FROM products P JOIN categories C
            ON P.CategoryID = C.CategoryID
            WHERE P.ProductID = 1
            """)
    MyDto20 select11();


    @Select("""
            SELECT CustomerID id, CustomerName name, Country
            FROM customers
            WHERE CustomerID = 2
            """)
    MyDto21 select12();

    // 여러행, 여러열
    @Select("""
            SELECT ProductID id, ProductName name, Price
            FROM products
            WHERE CategoryID = 2
            ORDER BY Price
            """)
    List<Map<String, Object>> select13();

    // 예제
    @Select("""
            SELECT P.ProductName '이름' , OD.Quantity '수량', P.Price '가격'
            FROM orders O JOIN orderdetails OD
            ON O.OrderID = OD.OrderID
            JOIN products P
            ON OD.ProductID = P.ProductID
            WHERE OrderDate = '1996-07-04'
            ORDER BY P.Price
            """)
    List<Map<String, Object>> select14();


    @Select("""
            SELECT P.ProductName name , OD.Quantity quantity, P.Price price
            FROM orders O JOIN orderdetails OD
            ON O.OrderID = OD.OrderID
            JOIN products P
            ON OD.ProductID = P.ProductID
            WHERE OrderDate = '1996-07-04'
            ORDER BY P.Price
            """)
    List<MyDto22> select15();


    @Select("""
            SELECT O.OrderDate date, P.ProductName name, C.CategoryName category, OD.Quantity, P.Price
            FROM orderdetails OD JOIN orders O
            ON OD.OrderID = O.OrderID
            JOIN products P 
            ON P.ProductID = OD.ProductID
            JOIN categories C
            ON P.CategoryID = C.CategoryID
            WHERE c.CategoryID = 1
            ORDER BY O.OrderDate, P.ProductName
            """)
    List<MyDto23> select16();


    @Select("""
            SELECT CustomerName 
            FROM customers
            WHERE CustomerID = 100
            """)
    String select17();

    @Select("""
            SELECT CustomerID
            FROM customers
            WHERE CustomerID = 100
            """)
    // Integer 같이 참조타입으로 사용하게 되면 nullPointException 발생 안하고 null로 출력됨 (없는 값을 대입했을때)
    Integer select18();


    @Select("""
            SELECT CustomerID id, CustomerName name, Country
            FROM customers
            WHERE CustomerID = 1
            """)
    MyDto24 select19();


    @Select("""
            SELECT CustomerID id, CustomerName name, Country
            FROM customers
            WHERE CustomerID > 1
            """)
    MyDto24 select20();
}


















