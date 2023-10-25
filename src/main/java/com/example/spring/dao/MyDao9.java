package com.example.spring.dao;

import com.example.spring.domain.MyDto33Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyDao9 {
    @Insert("""
            INSERT INTO employees (FirstName, LastName, BirthDate, Notes)
            VALUES (#{firstName}, #{lastName}, #{birthDate}, #{notes})
            """)
    int insertEmployee(MyDto33Employee dto);
}
