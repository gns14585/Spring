-- < 작다 , > 크다, >= 크거나 같다 , <= 작거다 같다

SELECT * FROM products WHERE Price < 10.00;
SELECT * FROM products WHERE Price > 10.00;
SELECT * FROM products WHERE Price >= 10.00;
SELECT * FROM products WHERE Price <= 10.00;
SELECT * FROM products WHERE Price = 10.00;

-- 밑 3개 코드 동일함 부정문 (NOT , != , <>)
SELECT * FROM products WHERE NOT Price = 10.00;
SELECT * FROM products WHERE Price != 10.00;
SELECT * FROM products WHERE Price <> 10.00;

SELECT * FROM customers WHERE CustomerID < 3;
SELECT * FROM customers WHERE CustomerID < '3';

-- 문자열 대소문자 구분 안함
SELECT * FROM customers WHERE CustomerName = 'Alfreds Futterkiste';
SELECT * FROM customers WHERE CustomerName < 'D';
SELECT * FROM customers WHERE CustomerName > 'Y';

-- 날짜형식
SELECT * FROM employees;
SELECT * FROM employees WHERE BirthDate >= '1960-01-01';
SELECT * FROM employees WHERE BirthDate < '1960-01-01';
