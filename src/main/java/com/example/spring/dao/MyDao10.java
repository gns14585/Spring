package com.example.spring.dao;

import com.example.spring.domain.MyDto33Employee;
import com.example.spring.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao10 {

    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = 5;
            """)
    String selectCustomerId();


    @Select("""
            SELECT CustomerID id,
            CustomerName name,
            ContactName,
            Address,
            City,
            PostalCode,
            Country
            FROM customers
            WHERE CustomerID = 3;
            """)
    MyDto34Customer getCustomer();


    @Select("""
            SELECT CustomerID id,
            CustomerName name,
            ContactName,
            Address,
            City,
            PostalCode,
            Country
            FROM customers
            WHERE CustomerID = #{id};
            """)
    MyDto34Customer getCustomerById(Integer id);


    @Select("""
            SELECT 
                EmployeeID id,
                LastName,
                FirstName,
                Photo,
                Notes,
                BirthDate
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    MyDto33Employee getEmployeeById(Integer id);

    @Select("""
            SELECT CustomerID
            FROM customers
            ORDER BY CustomerID
            """)
    List<Integer> getCustomerIdList();

    @Select("""
            SELECT EmployeeID
            FROM employees
            ORDER BY EmployeeID
            """)
    List<Integer> getEmployeeIdList();
}

























