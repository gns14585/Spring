-- LIMIT 조회 레코드(행, ROW) 제한
SELECT * FROM customers;
SELECT * FROM customers LIMIT 3;
SELECT * FROM employees LIMIT 2;

SELECT * FROM employees ORDER BY BirthDate LIMIT 2;

SELECT * FROM products ORDER BY Price LIMIT 10;

-- 1) 직원 나이가 어린 순서대로 3개만 조회
SELECT * FROM employees ORDER BY BirthDate DESC LIMIT 3;

-- 2) 2번 카테고리에서 가장 저렴한 상품 조회
SELECT * FROM products WHERE CategoryID = 2 ORDER BY Price LIMIT 1;

-- LIMIT n : n 개
-- LIMIT n, m : n 번부터 m 개 (n은 0번부터)
SELECT ProductName, Price FROM products ORDER BY Price LIMIT 3, 3;

-- 페이지 나누기
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID; -- 91개 ROW
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 0, 10; -- 1페이지 10개
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 10, 10; -- 1페이지 10개
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 20, 10; -- 1페이지 10개
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 90, 10; -- 마지막 페이지 10개

-- 1) 공급자(suppliers)를 한 페이지에 5개씩 공급자 번호 순으로 보여줄 때 3번째 페이지 조회 코드 작성
SELECT * FROM suppliers ORDER BY SupplierID LIMIT 10, 5;

-- 한페이지가 n개의 레코드(row)를 보여주면
-- m번째 페이지 조회
-- LIMIT (m-1)*n, n
