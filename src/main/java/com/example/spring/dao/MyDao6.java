package com.example.spring.dao;

import com.example.spring.domain.MyDto37;
import com.example.spring.domain.MyDto38;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao6 {

    @Insert("""
            INSERT INTO customers (CustomerName)
            VALUES (#{name})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert1(MyDto37 dto);


    @Insert("""
            INSERT INTO employees (LastName)
            VALUES (#{lastName})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert2(MyDto38 dto);


    @Insert("""
            INSERT INTO employees (LastNAme, FirstName)
            VALUES (#{lastName}, #{firstName})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert3(MyDto38 dto);


    @Update("""
            UPDATE bank
            SET money = money - 1000
            WHERE name = 'son'
            """)
    int update1();

    @Update("""
            UPDATE bank
            SET money = money + 1000
            WHERE name = 'kim'
            """)
    // 반환타입이 int 인 이유는 몇개의 행이 변경됐는지 확인 하는 용도, ex) 1개 행이 변경되었습니다.
    int update2();

    @Select("""
            SELECT *
            FROM bank
            ORDER BY name
            """)
    List<Map<String, Object>> select3();
}























