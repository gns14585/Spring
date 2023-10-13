USE w3schools;
SELECT DISTINCT CustomerID
FROM orders
ORDER BY 1;

SELECT CustomerName
FROM customers
WHERE CustomerID NOT IN (SELECT DISTINCT CustomerID FROM orders ORDER BY 1);

SELECT CustomerName
FROM customers C LEFT JOIN orders O
ON C.CustomerID = O.CustomerID
WHERE O.CustomerID IS NULL;

SELECT LastName
FROM employees E LEFT JOIN orders O
ON E.EmployeeID = O.EmployeeID
WHERE O.EmployeeID IS NULL;

SELECT DISTINCT EmployeeID FROM orders ORDER BY 1;
SELECT COUNT(*) FROM employees;

INSERT INTO employees (LastName, FirstName, BirthDate, Photo, Notes)
VALUES ('손', '흥민', '2000-01-01', '사진1', '축구선수');
