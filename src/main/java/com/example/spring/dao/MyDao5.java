package com.example.spring.dao;

import com.example.spring.domain.MyDto35;
import com.example.spring.domain.MyDto36;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao5 {
    @Select("""
            <script>
                SELECT COUNT(*)
                FROM customers
                
                <if test='country != null'>
                WHERE country = #{country}
                </if>
            </script>
            """)
    String select1(String country);

    // script 태그 안에서
    // (작다)< 기호는 태그코드의 시작으로 인식되어서 작다라는 코드로 사용 불가
    // lt로 사용해야함 또는 (작거나 같을땐) <= lte
    @Select("""
            <script>
                SELECT CustomerName FROM customers
                
                <if test='num == 10'>
                    -- 수가 10이다.
                </if>
                <if test='num != 10'>
                    -- 수가 10이 아니다.
                </if>
                <if test='num > 10'>
                    -- 수가 10보다 크다.
                </if>
                
                <if test='num lt 10'>
                    -- 수가 10보다 작다.
                </if>
                
                <if test='num >= 10'>
                    -- 수가 10보다 크거나 같다.
                </if>
                <if test='num lte 10'>
                    -- 수가 10보다 작거나 같다.
                </if>
            </script>
            """)
    List<String> select2(Integer num);


    @Select("""
                <script>
                -- select에서 추가하려는 열의 첫 글자가 대문자면 가져와지지 않음 왜?????
                SELECT CustomerName, ContactName
                FROM customers
                
                <if test='code == 1'>
                    WHERE customerName 
                </if>
                
                <if test='code == 2'>
                    WHERE contactName 
                </if>
                
                    LIKE #{k}
            </script>
            """)
    List<Map<String, Object>> select3(Integer code, String k);

    @Select("""
            <script>
                SELECT COUNT(*) FROM customers
                WHERE
                    <if test='i gt 10'>
                    -- i가 10보다 큼
                    </if>
                    <if test='i lt 10'>
                    -- i가 10보다 작음
                    </if>
                    <if test='(i gt 0) and (i lt 100)'>
                    -- i가 0보다 크고 100보다 작음
                    </if>
            </script>
            """)
    String select4(int i);


    @Select("""
            SELECT *
            FROM customers
            WHERE CustomerName < 'a';
            """)
    String select5();

    // CDATA : char data 약자
    // < 이런 기호를 태그로 인식하지 말라는 속성 (문자로만 인식)
    @Select("""
                <script>
                <![CDATA[
                    SELECT *
                    FROM customers
                    WHERE customerName < 'a';
                ]]>
            </script>
                """)
    String select6();

    // separator : 값 사이사이 들어가는 값
    @Select("""
            <script>
            SELECT *
            FROM customers
            WHERE 
                Country IN 
                <foreach collection="args"
                         item="elem"
                         separator=", "
                         open="(" 
                         close=")">
                    #{elem}
                </foreach>
            </script>
            """)
    String select7(List args);

    // prefixOverrides : 맨 앞에 있는 문구 삭제
    @Select("""
            <script>
            SELECT *
            FROM customers
                <trim prefix="WHERE" prefixOverrides="OR">
                    <foreach collection="args"
                             item="elem">
                     OR country = #{elem}        
                    </foreach>       
                </trim>
                </script>  
            """)
    String select8(List args);


    @Select("""
            <script>
            <bind name="alterKeyword" value="'%' + keyword + '%'" />
                SELECT *
                FROM customers
                WHERE CustomerName LIKE #{alterKeyword}
            </script>
            """)
    String select9(String keyword);

    @Select("""
            <script>
                SELECT * FROM
                WHERE 
                    <if test="word == 'abc'">
                        -- word는 abc
                    </if>
                    <if test='word == "def"'>
                        -- word는 def
                    </if>
                    <if test="word == 'q'">
                        -- word는 q
                    </if>
                    <if test='word == "k"'>
                        -- word는 k
                    </if>
            </script>
            """)
    String select10(String word);


    @Select("""
            SELECT DISTINCT city 
            FROM customers
            WHERE City IS NOT NULL AND City != ''
            ORDER BY 1 
            """)
    List<String> listCustomerCity();
    @Select("""
            SELECT DISTINCT country
            FROM customers
            WHERE country IS NOT NULL AND country != ''
            ORDER BY 1
            """)
    List<String> listCustomerCountry();

    @Select("""
            <script>
                SELECT customerName name, city, country
                FROM customers
                <trim prefix="WHERE">
                    <if test='type == "1"'>
                        city
                        <foreach collection="city" item="elem" open=" IN ( "
                                 separator="," close=")">
                                 #{elem}
                        </foreach>
                    </if>
                    <if test='type == "2"'>
                        country
                        <foreach collection="country" item="elem" open=" IN ( "
                                 separator="," close=")">
                        #{elem}
                        </foreach>
                    </if>
                </trim>
                ORDER BY name, country, city
            </script>
            """)
    List<Map<String, Object>> listCustomer(MyDto36 dto);
}



















