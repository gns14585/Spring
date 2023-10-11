-- 수형(정수, 실수)
-- 문자열
-- 날짜 (날짜시간)

-- 정수 : int
CREATE TABLE my_table3 (
    col1 int
);
INSERT INTO my_table3 (col1)
VALUE (298743);
INSERT INTO my_table3 (col1)
VALUE ('12300');
INSERT INTO my_table3 (col1) VALUE ('two'); -- 안됨
SELECT * FROM my_table3;

-- 실수 : DEC
CREATE TABLE my_table4 (
    col1 DEC -- (10,0)
);
INSERT INTO my_table4 (col1) VALUE (3.14);
SELECT * FROM my_table4;

CREATE TABLE my_table5 (
    col1 DEC(5, 3) -- 총 길이 5, 소수점 이하 길이 3
);
INSERT INTO my_table5 (col1) VALUE (10.123);
SELECT * FROM my_table5;
INSERT INTO my_table5 (col1) VALUE (123.456); -- 총 길이 6개라 불가

-- 1) my_table6 만들기
-- age 컬럼 정수타입
-- score 컬럼 총길이 7, 소수점이하길이 2
CREATE TABLE my_table6(
    age int,
    score DEC(7, 2)
);
SELECT * FROM my_table6;
INSERT INTO my_table6 (age, score) VALUE (29, 836.25);

-- 문자열 : VARCHAR
-- VARCHAR() : 괄호 안에 들어가는 숫자는 문자열의 길이
CREATE TABLE my_table7 (
    col1 VARCHAR(1), -- 1글자 사용가능
    col2 VARCHAR(2), -- 2글자 사용 가능
    col3 VARCHAR(16000) -- 16,000글자 사용 가능
);
CREATE TABLE my_table8 (
    col1 VARCHAR(8000),
    col2 VARCHAR(8000)
);

INSERT INTO my_table7 (col1) VALUE ('a');
INSERT INTO my_table7 (col1) VALUE ('가');
INSERT INTO my_table7 (col1) VALUE ('ab');

INSERT INTO my_table7 (col2) VALUE ('가');
INSERT INTO my_table7 (col2) VALUE ('나다');
INSERT INTO my_table7 (col2) VALUE ('abc');
INSERT INTO my_table7 (col2) VALUE ('😂😊');

SELECT * FROM my_table7;

-- 1) my_table9 만들기
-- name 문자열 최대길이 100자
-- 주소 문자열 최대길이 200자
-- 전화번호 문자열 최대길이 100자
CREATE TABLE my_table9 (
    name VARCHAR(100),
    address VARCHAR(200),
    number VARCHAR(100)
);
INSERT INTO my_table9 (name, address, number) VALUE ('이정훈', '서울', '36138304');
SELECT * FROM my_table9;


-- 날짜 : DATE
CREATE TABLE my_table10 (
    col1 DATE
);

INSERT INTO my_table10 (col1) VALUE (NOW());
SELECT * FROM my_table10;

CREATE TABLE my_table11 (
    col1 DATETIME
);

-- 날짜시간 : DATETIME
INSERT INTO my_table11 (col1) VALUE ('2002-12-30');
INSERT INTO my_table11 (col1) VALUE ('2002-12-30 14:05:12');
INSERT INTO my_table11 (col1) VALUE (NOW());
SELECT * FROM my_table11;


SELECT NOW();






