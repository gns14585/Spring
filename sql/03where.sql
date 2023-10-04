SELECT CustomerName, Address, City, Country FROM customers;

-- WHERE : 레코드 선택(솎아내기)
-- 특정 레코드에 맞는 행들을 뽑아냄
-- 대소문자 구분 안함
-- 문자열은 '' 작은 따옴표로 사용해야함
-- 수 형식은 따옴표 없이 사용 ( 따옴표 사용 가능하긴 함 )
SELECT * FROM customers WHERE CustomerID = 1;
SELECT * FROM customers WHERE CustomerID = 2;
SELECT * FROM customers WHERE Country = 'USA';
SELECT * FROM customers WHERE Country = 'Mexico';
SELECT * FROM customers WHERE Country = 'MEXICO';
SELECT * FROM customers WHERE Country = 'mexico'; -- 대소문자 구분 안함
SELECT * FROM customers WHERE Country = 'France'; -- 문자열은 '' 작은따옴표로 사용
SELECT * FROM customers WHERE CustomerID = 3; -- 수 형식은 따옴표 없이 사용
SELECT * FROM customers WHERE CustomerID = '3'; -- 수 형식은 따옴표 없이 사용되긴 함

-- 1) 영국(UK)에 사는 고객들 조회
SELECT * FROM customers WHERE Country = 'UK';
-- 2) 1번 카테고리에 속한 상품(Products)들 조회
SELECT * FROM products WHERE CategoryID = 1;
-- 3) Osaka에 있는 공급자들 조회
SELECT * FROM suppliers WHERE City = 'Osaka';


-- 미국에 사는 고객의 이름들 조회
SELECT CustomerName FROM customers WHERE Country = 'USA';

-- 영국에 사는 고객의 이름과, 고객번호 조회
SELECT CustomerID, CustomerName FROM customers WHERE Country = 'UK';


-- 1) 2번 카테고리에 있는 상품명과, 가격, 조회
SELECT ProductName, Price FROM products WHERE CategoryID = 2;
-- 2) 일본에 있는 공급자의 이름(SupplierName)과 전화번호 조회
SELECT SupplierName, SupplierID FROM suppliers WHERE Country = 'Japan';
-- 3) 2번 카테고리의 이름(categoryName) 조회
SELECT CategoryName FROM categories WHERE CategoryID = 2;