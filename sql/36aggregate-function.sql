use w3schools;

-- aggregate function (집계함수, 집합함수, 그룹함수)
-- MAX, MIN, COUNT, SUM, AVG

-- MAX 최대값
SELECT MAX(Price) FROM products;
-- MAX 값의 상품정보 조회
-- 서브쿼리 방식
SELECT *
FROM products
WHERE Price = (SELECT MAX(Price) FROM products);

-- MIN 최소값
SELECT MIN(Price) FROM products;
-- MIN 값의 상품정보 조회
SELECT  *
FROM products
WHERE Price =(SELECT MIN(Price) FROM products);

-- 1) 가장 어린 직원명 조회
SELECT *
FROM employees
WHERE BirthDate = (SELECT MAX(BirthDate) FROM employees);

-- 2) 가장 나이 많은 직원명 조회
SELECT *
FROM employees
WHERE BirthDate = (SELECT MIN(BirthDate) FROM employees);

-- COUNT : 갯수
SELECT * FROM employees;
SELECT COUNT(EmployeeID) FROM employees;
SELECT COUNT(LastName) FROM employees;
SELECT COUNT(FirstName) FROM employees;
-- NULL 은 갯수 포함 안됨
INSERT INTO employees (LastName)
VALUES ('흥민');
SELECT * FROM employees ORDER BY 1 DESC;

SELECT MIN(BirthDate) FROM employees;
SELECT MAX(BirthDate) FROM employees;

INSERT INTO products (ProductName)
VALUES ('커피');

SELECT * FROM products ORDER BY 1 DESC;
SELECT MIN(Price) FROM products;

-- 최소값 조회할때 NULL이 포함될 경우 IFNULL 을 사용해서 대체 값 사용
SELECT MIN(IFNULL (Price, 0)) FROM products;

SELECT * FROM products
WHERE IFNULL(Price, 0) = (SELECT MIN(IFNULL (Price, 0)) FROM products);


-- SUM : 합
SELECT * FROM products;
SELECT SUM(Price) FROM products;

-- 1996-07-04 에 구매한 총 구매 수량
SELECT SUM(OD.Quantity), P.Price, P.ProductName
FROM orders O JOIN orderdetails OD
ON O.OrderID = OD.OrderID
JOIN products p
ON P.ProductID = OD.ProductID
WHERE O.OrderDate = '1996-07-04';

-- 1) 1996-07-04 매출액 구하기
SELECT SUM(P.Price * OD.Quantity) '매출액'
FROM orders O JOIN orderdetails OD
ON O.OrderID = OD.OrderID
JOIN products p
ON OD.ProductID = P.ProductID
WHERE O.OrderDate = '1996-07-04';

-- AVG : 평균
SELECT AVG(Price) FROM products;
SELECT SUM(Price) FROM products; -- 2222.71
SELECT COUNT(*) FROM products; -- 78











