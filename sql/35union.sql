use w3schools;- GK

-- union 합집합 (중복없음)
SELECT Country FROM customers;
SELECT Country FROM suppliers;

SELECT Country FROM customers
UNION
SELECT Country FROM suppliers;

-- UNION ALL (중복된 원소들까지 같이 나옴)
SELECT Country FROM customers
UNION ALL
SELECT Country FROM suppliers;


-- 여러개도 상관없음 다만 열의 갯수가 맞아야함 ( 타입이 다르면 UNION 밑에있는 SELECT절은 해당 열에 NULL 나옴 )
SELECT CustomerName, Country, City FROM customers
UNION
SELECT SupplierName, Country, Address FROM suppliers;

-- 1) 직원의 lastName과 firstName을 name 이라는 하나의 컬럼으로 조회
SELECT LastName name FROM employees
UNION ALL
SELECT FirstName FROM employees;

-- FULL OUTER JOIN
USE mydb1;
SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1
UNION
SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;

-- LEFT OUTER JOIN
SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1;

-- RIGHT OUTER JOIN
SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;
