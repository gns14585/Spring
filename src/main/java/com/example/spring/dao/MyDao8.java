package com.example.spring.dao;

import com.example.spring.domain.MyDto45;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface MyDao8 {


    @Select("""
            SELECT *
            FROM products
            WHERE ProductID = #{id}
            """)
    Map<String, Object> selectProductById(Integer id);


    @Select("""
            SELECT EmployeeID id,
                    FirstName,
                    LastName,
                    BirthDate,
                    Photo,
                    Notes
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    Map<String, Object> selectByEmployeeId(Integer id);


    @Select("""
            SELECT P.ProductID, P.Price, C.CategoryName , P.Unit, P.ProductName
            FROM products P JOIN categories C
            ON P.CategoryID = C.CategoryID
            WHERE P.ProductID = #{id}
            """)
    MyDto45 selectByProductId2(Integer id);
}


