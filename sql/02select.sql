-- SELECT : 데이터 조회(읽기, 검색, 가져오기 등등)
-- ; 세미콜론을 기준으로 다음 쿼리문 실행
SELECT * FROM w3schools.customers;
SELECT * FROM w3schools.employees;
SELECT * FROM w3schools.products;

SELECT * FROM customers;
SELECT * FROM customers;

SELECT * FROM categories;
SELECT * FROM orderdetails;
SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM shippers;
SELECT * FROM suppliers;
--
SELECT CustomerName -- column(열) 명 나열
FROM customers-- table 명 나열
;

SELECT CustomerID, CustomerName FROM customers;
-- 출력되는 테이블 순서는 쿼리문 작성 방식에 어떤걸 먼저 작성할지에 따라 다름
SELECT CustomerID, CustomerName, City FROM customers;
SELECT CustomerName, CustomerID, Country FROM customers;

-- 전체 * culumn(열) 표시
SELECT * FROM customers;

-- 1) 직원(employees)의 lastName, firstName, birthDate 조회
SELECT LastName, FirstName, BirthDate FROM employees;

-- 2) 상품(products)의 이름(productName), 단위(unit), 가격(price) 조회
SELECT ProductName, Unit FROM products;

-- 3) 공급자(suppliers)의 이름(supplierName), 주소(address), 국가(country) 조회
SELECT SupplierName, Address, Country FROM suppliers;

-- 고객테이블의 국가 컬럼 조회
SELECT Country FROM customers;

-- DISTINCT 중복 제거
SELECT DISTINCT Country FROM customers; -- 21 ROW

SELECT City, Country FROM customers; -- 91 ROW
SELECT DISTINCT City, Country FROM customers; -- 69 ROW

-- COUNT : 행(ROW, RECORD)의 수
SELECT COUNT(Country) FROM customers; -- 91
SELECT COUNT(DISTINCT Country) FROM customers; -- 21

-- 전체 행의 수
SELECT COUNT(*) FROM customers;
SELECT COUNT(*) FROM employees;
SELECT COUNT(*) FROM orders;

-- 1) 공급자들이 있는 나라 수
SELECT COUNT(DISTINCT Country) FROM suppliers;
-- 2) 주문(ORDER) 건수
SELECT COUNT(*) FROM orders;
-- 3) 몇 개의 카테고리가 있는지 조회
SELECT COUNT(*) FROM categories;
-- 4) 고객이 있는 도시의 수
SELECT COUNT(DISTINCT City) FROM customers;

