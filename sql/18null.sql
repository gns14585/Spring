SELECT * FROM customers ORDER BY 1 DESC;
INSERT INTO customers (CustomerName)
VALUE ('흥민');
INSERT INTO customers(CustomerName, ContactName)
-- 빈괄호로 하게되면 NULL 아님
VALUE ('강인', '');
INSERT INTO customers(CustomerName, ContactName)
VALUE ('민재', null);

SELECT ProductID, ProductName, Price FROM products ORDER BY 1 DESC;
INSERT INTO products(ProductName, Price)
VALUE ('피자', 0.00);
INSERT INTO products(ProductName, Price)
    VALUE ('햄버거', null);

-- NULL : 값이 없음
SELECT * FROM products WHERE Price = 0.00 ORDER BY 1 DESC;
SELECT * FROM products WHERE Price != 0.00 ORDER BY 1 DESC;

-- 피연산자가 null이면 결과는 항상 false
SELECT * FROM products WHERE Price IS NULL; -- IS NULL : 컬럼의 값이 null인지 확인
SELECT * FROM products WHERE NOT Price IS NULL;
SELECT * FROM products WHERE Price IS NOT NULL;

SELECT ProductName, Price * 100 FROM products; -- 산술연산시 null 피연산자이면 결과 null

SELECT ProductName, Price FROM products ORDER BY ProductID DESC;



-- IFNULL : 첫번째 매개변수 값엔 컬럼명 , 두번째 매개변수엔 첫번째 컬럼명에있는 값이 null 이면 대체할 값 지정
SELECT ProductName, IFNULL(Price, 0.00)
FROM products
ORDER BY ProductID DESC;

-- 1) contactName이 null인 고객들 조회
SELECT * FROM customers WHERE ContactName IS NULL;
-- 2) address가 null인 고객들 조회
SELECT * FROM customers WHERE Address IS NULL;
-- 3) 고객들 조회(customerName, country 컬럼만), 단 country가 null이면 '없음'으로 표시
SELECT CustomerName, IFNULL(Country, '없음') FROM customers ORDER BY Country;