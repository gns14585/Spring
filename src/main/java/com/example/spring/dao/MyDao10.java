package com.example.spring.dao;

import com.example.spring.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
