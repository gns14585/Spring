SELECT * FROM products;
SELECT * FROM categories;

-- chais 상품의 카테고리명은?
SELECT CategoryID FROM products WHERE ProductName = 'chais';
SELECT CategoryName FROM categories WHERE CategoryID = 1;

-- JOIN : 두개의 테이블 결합
SELECT * FROM categories JOIN products; -- 616

SELECT COUNT(*) FROM categories; -- 8
SELECT COUNT(*) FROM products; -- 77

--
CREATE TABLE table_a (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(20),
    category_id INT
);
CREATE TABLE table_b (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(20)
);
INSERT INTO table_b (category_name) VALUES ('음료수'), ('반찬');
INSERT INTO table_a (product_name, category_id)
VALUES ('콜라', 1),
       ('사이다', 1),
       ('제육', 2),
       ('돈까스', 2),
       ('두부', 2);

SELECT * FROM table_a JOIN table_b;

-- 두 테이블을 결합하면 조회된 레코드 수는 A테이블 row * B테이블 row
-- 컬럼 수는 A테이블 열 + B테이블 열

-- JOIN 여러테이블 사용시 컬럼명 작성할땐 테이블명.컬럼명 으로 작성
SELECT *
FROM table_a JOIN table_b WHERE table_a.product_name = '콜라' -- 컬럼명이 하나의 테이블에만 있을때 테이블명 생략 가능
                                     -- 같은 컬럼명이 여러테이블에 있다면 테이블명 작성
                                     -- category_id는 table_a 에도 있고 , table_b에도 있으니 테이블명 적어줘야 함
                                     AND table_a.category_id = table_a.category_id;

SELECT *
FROM table_a JOIN table_b
WHERE table_a.category_id = table_b.category_id
AND product_name = '콜라';














