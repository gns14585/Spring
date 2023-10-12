-- 1. null 허용 여부
-- 2. 유일한 값 여부
-- 3. 기본값 지정
-- 4. 값 체크

USE mydb1;

-- 1. null 허용 여부
CREATE TABLE my_table13 (
  col1 INT NULL, -- null 허용
  col2 INT NOT NULL -- null 허용 안함
);

INSERT INTO my_table13 (col1, col2)
VALUE (33, 44); -- ok

INSERT INTO my_table13 (col2)
VALUE (55);

-- col2에 null 허용하지 않아서 오류발생
INSERT INTO my_table13 (col1)
VALUE (66); -- NOT OK

SELECT * FROM my_table13;

-- 2. 유일한 값 여부
-- UNIQUE : 해당 컬럼에 유일한 값만 허용
CREATE TABLE my_table14 (
    col1 INT,
    col2 INT UNIQUE -- 이 컬럼에 중복된 값을 넣을 수 없음
);
INSERT INTO my_table14 (col1, col2) VALUE (11, 22); -- OK
INSERT INTO my_table14 (col1, col2) VALUE (11, 33); -- OK
INSERT INTO my_table14 (col1, col2) VALUE (11, 33); -- 불가, 중복된 값
INSERT INTO my_table14 (col1) VALUE (11); -- OK , col2 = null / null 은 중복이 아니라 연속적으로 가능

SELECT * FROM my_table14;

-- null 허용불가 , 유일한값 조합
CREATE TABLE my_table15 (
    col1 INT,
    col2 INT NOT NULL,
    col3 INT UNIQUE ,
    col4 INT NOT NULL UNIQUE
);
INSERT INTO my_table15 (col1, col2, col3, col4) VALUE (11, 22, 33, 44); -- OK
INSERT INTO my_table15 (col1, col2, col3, col4) VALUE (11, 22, 33, 44); -- NOT OK / col3,4 중복불가
INSERT INTO my_table15 (col1, col2, col3, col4) VALUE (11, 22, 44, NULL); -- NOT OK / col4 null 불가
INSERT INTO my_table15 (col1, col2, col3, col4) VALUE (11, 22, 44, 55); -- OK
INSERT INTO my_table15 (col1, col3, col4) VALUE (11, 44, 55); -- NOT OK / col2 null 불가

SELECT * FROM my_table15;

-- 1) my_table16
CREATE DATABASE TESTDB;
USE TESTDB;
CREATE TABLE test_table1 (
    col1 INT,
    col2 INT NOT NULL,
    col3 INT UNIQUE,
    col4 INT NOT NULL UNIQUE
);
INSERT INTO test_table1 (col1, col2, col3, col4)
VALUE (11, 22, 33, 44);
INSERT INTO test_table1 (col1, col2, col3, col4)
VALUE (11, 22, 44, 66);

SELECT * FROM test_table1;


-- DEFAULT : 기본값
USE mydb1;
CREATE TABLE my_table17 (
    col1 INT,
    col2 INT DEFAULT 100, -- 값을 넣지 않으면 100
    col3 VARCHAR(10) DEFAULT 'empty', -- 값을 넣지 않으면 'empty'
    col4 DATETIME DEFAULT NOW() -- 값을 넣지 않으면 현재 일시
);
INSERT INTO my_table17 (col1, col2, col3, col4) VALUE (22, 33, 'son', '2023-11-11 22:23:24');
INSERT INTO my_table17 (col1) VALUE (22);
INSERT INTO my_table17 (col1, col2, col3, col4) VALUE (333, NULL, NULL, NULL);

SELECT * FROM my_table17;

CREATE TABLE my_table18 (
    col1 INT,
    col2 INT DEFAULT 300,
    col3 INT NOT NULL DEFAULT 500
);
INSERT INTO my_table18 (col1, col3) VALUE (3, 222);
INSERT INTO my_table18 (col1) VALUE (4);
SELECT * FROM my_table18;

CREATE TABLE my_table19 (
    col1 INT NOT NULL UNIQUE DEFAULT 100
);
INSERT INTO my_table19 () VALUE();
SELECT * FROM my_table19;


-- 테이블의 컬럼과 타입, 제약사항 등을 확인
-- DESCRIBE, DESC
DESCRIBE my_table18;
DESC my_table18;

DESC my_table15;

-- TABLE 생성 쿼리 확인 (TABLE 만들었을때 어떤 쿼리를 짜서 생성했는지 확인용도)
SHOW CREATE TABLE my_table15;
CREATE TABLE `my_table15` (
                              `col1` int(11) DEFAULT NULL,
                              `col2` int(11) NOT NULL,
                              `col3` int(11) DEFAULT NULL,
                              `col4` int(11) NOT NULL,
                              UNIQUE KEY `col4` (`col4`),
                              UNIQUE KEY `col3` (`col3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CHECK : 값의 유효범위 체크
CREATE TABLE my_table20 (
    col1 INT,
    col2 INT CHECK (col2 > 100),
    col3 INT CHECK (col3 > 1000 AND col3 < 2000)
);
DESC my_table20;
SHOW CREATE TABLE my_table20;
CREATE TABLE `my_table20` (
                              `col1` int(11) DEFAULT NULL,
                              `col2` int(11) DEFAULT NULL CHECK (`col2` > 100),
                              `col3` int(11) DEFAULT NULL CHECK (`col3` > 1000 and `col3` < 2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO my_table20 (col1, col2, col3) VALUE (10000, 50, -10); -- NOT OK
INSERT INTO my_table20 (col1, col2, col3) VALUE (10000, 150, 1500); -- OK
SELECT * FROM my_table20;







