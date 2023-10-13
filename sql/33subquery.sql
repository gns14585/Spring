use w3schools;

SELECT Price
FROM products
WHERE ProductName = 'ipoh coffee';
SELECT ProductName, Price
FROM products
WHERE Price > 46.00;

-- 어떤 쿼리가 다른 쿼리를 감싸고 있으면 SUBQUERY 라고함
SELECT ProductName, Price
FROM products
WHERE Price > (SELECT Price FROM products WHERE ProductName = 'ipoh coffee');

SELECT BirthDate
FROM employees
WHERE LastName = 'Leverling';

SELECT LastName, FirstName, BirthDate
FROM employees
WHERE BirthDate < '1963-08-30';

-- SUBQUERY
SELECT LastName, FirstName, BirthDate
FROM employees
WHERE BirthDate < (SELECT BirthDate
                   FROM employees
                   WHERE LastName = 'Leverling');
-- 행 1개, 열 1개
SELECT BirthDate
FROM employees
WHERE LastName = 'Leverling';

-- 행 여러개, 열 1개
SELECT ShipperID
FROM orders
WHERE OrderDate = '1996-07-08';
SELECT CustomerName
FROM customers
WHERE Country = 'MEXICO';

-- 행 여러개 , 열 여러개
SELECT CustomerID, CustomerName
FROM customers
WHERE Country = 'MEXICO';

-- 행 1개, 열 1개
-- 1) 'Tofu' 상품을 공급한 공급자명
-- 3가지의 방법
SELECT SupplierID FROM products WHERE ProductName = 'TOFU';
SELECT SupplierID, SupplierName FROM suppliers
WHERE SupplierID = 6;

SELECT SupplierID, SupplierName FROM suppliers
WHERE SupplierID = (SELECT SupplierID FROM products WHERE ProductName = 'TOFU');

SELECT S.SupplierID, S.SupplierName
FROM suppliers S JOIN products P
    ON S.SupplierID = P.SupplierID
WHERE ProductName = 'TOFU';

-- 여러 행, 1개 열
-- 2) 멕시코 고객이 주문한 일자들 조회
SELECT CustomerID FROM customers WHERE Country = 'MEXICO';
SELECT OrderDate FROM orders WHERE CustomerID IN (2, 3, 13, 58, 80);

SELECT OrderDate
FROM orders
WHERE CustomerID IN (SELECT CustomerID FROM customers WHERE Country = 'MEXICO');

-- 2) 1번 카테고리에 있는 상품이 주문된 주문번호 (orderDetails, products)
-- JOIN 방식
SELECT O.OrderID
FROM products P
    JOIN orderdetails o
        ON P.ProductID = O.ProductID
WHERE P.CategoryID = 1;

-- SUBQUERY 방식
SELECT ProductID FROM products WHERE CategoryID = '1';
SELECT OrderID FROM orderdetails
               WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID = '1');

-- 2) 1번 카테고리에 있는 상품이 주문된 날짜 (orderDetails, products)
-- SUBQUERY 방식
SELECT OrderDate FROM orders
WHERE OrderID IN (SELECT OrderID FROM orderdetails
                  WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID = '1'));

-- JOIN 방식
SELECT DISTINCT O.OrderID, O.OrderDate
FROM orders O
    JOIN orderdetails OD
        ON O.OrderID = OD.OrderID
    JOIN products P
        ON OD.ProductID = P.ProductID
WHERE P.CategoryID = 1;

-- 주문한 적 없는 고객들
-- NOT IN
SELECT CustomerID FROM orders;
SELECT * FROM customers WHERE CustomerID NOT IN (SELECT  CustomerID FROM orders);


-- 행 여러개 , 열 여러개
SELECT * FROM customers;

SELECT SupplierName, Address, Country FROM suppliers;

INSERT INTO customers (CustomerName, Address, Country)
(SELECT SupplierName, Address, Country FROM suppliers);

-- 열의 타입이 달라도됨
INSERT INTO customers (CustomerName, Address, Country)
(SELECT ContactName, City, Phone FROM suppliers)
-- 열의 갯수는 동일해야힘
INSERT INTO customers (CustomerName, Address, Country)
    (SELECT ContactName, City, Phone, suppliers.Country FROM suppliers); -- 불가

SELECT * FROM customers
WHERE (City, Country)
IN (SELECT City, Country FROM suppliers);

-- table_c에 customers 테이블의 CustomerName, City, Country 데이터가 들어감
CREATE TABLE table_c
SELECT CustomerName, City, Country FROM customers;

SELECT * FROM table_c;
DESC table_c;

-- 1) 1번 카테고리에 있는 상품들로 새 테이블을 만드는데, 새로운 테이블은 productName, categoryName, price
/*
CREATE TABLE table_d
SELECT ProductName p, CategoryName c , Price pr FROM products JOIN categories;
SELECT DISTINCT * FROM table_d;
*/

CREATE TABLE table_d
SELECT p.ProductName, c.CategoryName, p.Price
FROM products p
         JOIN categories c
              ON p.CategoryID = c.CategoryID
WHERE p.CategoryID = 1;

SELECT *
FROM table_d;

SELECT *
FROM products;



























