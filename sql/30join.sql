use mydb1;

CREATE TABLE my_table42_a (
    col1 VARCHAR(1)
);
CREATE TABLE my_table43_b (
    col1 VARCHAR(1)
);
INSERT INTO my_table42_a (col1)
VALUES ('a'),
       ('b'),
       ('c');
INSERT INTO my_table43_b (col1)
VALUES ('b'),
       ('c'),
       ('d'),
       ('e');

-- INNER JOIN
-- A컬럼, B컬럼 비교 했을때 같은 값만 조회
SELECT *
FROM my_table42_a A JOIN my_table43_b B
ON A.col1 = B.col1;
SELECT *
FROM my_table42_a A INNER JOIN my_table43_b B
                         ON A.col1 = B.col1;

-- LEFT JOIN
SELECT *
FROM my_table42_a A LEFT JOIN my_table43_b B
ON A.col1 = B.col1;

-- RIGHT JOIN
SELECT *
FROM my_table42_a A RIGHT JOIN my_table43_b B
ON A.col1 = B.col1;


-- 컬럼이 하나 이상일 경우
CREATE TABLE my_table44_a (
    col1 VARCHAR(1),
    name VARCHAR(10),
    address VARCHAR(10)
);
CREATE TABLE my_table45_b (
    col1 VARCHAR(1),
    product VARCHAR(10),
    country VARCHAR(10)
);
INSERT INTO my_table44_a (col1, name, address)
VALUES ('a', '흥민', '런던'),
       ('b', '강인', '파리'),
       ('c', '민재', '뮌헨');
INSERT INTO my_table45_b (col1, product, country)
VALUES ('b', '축구공', '한국'),
       ('c', '컴퓨터', '미국'),
       ('d', '전화기', '호주'),
       ('e', '햄버거', '영국');
-- col1 기준으로 조회
-- JOIN
SELECT *
FROM my_table44_a A JOIN my_table45_b B
ON A.col1 = B.col1;
-- LEFT JOIN
SELECT *
FROM my_table44_a A LEFT JOIN my_table45_b B
                         ON A.col1 = B.col1;
-- RIGHT JOIN
SELECT *
FROM my_table44_a A RIGHT JOIN my_table45_b B
                         ON A.col1 = B.col1;


