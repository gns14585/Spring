SELECT * FROM products;
SELECT * FROM products WHERE ProductID = 4;

UPDATE products
SET ProductName = '차이즈',
    Unit = '10 박스',
    Price = 36.00
WHERE ProductID = 4;

UPDATE products
SET ProductName = '두부김치'; -- WHERE 절 필수

-- 1) 3번 고객의 이름 수정하기
SELECT * FROM customers;
UPDATE customers
SET CustomerName = '이정훈'
WHERE CustomerID = 3;

-- 2) 5번 직원의 notes 변경하기
SELECT * FROM employees WHERE EmployeeID = 5;
UPDATE employees
SET Notes = '안녕하세요?'
WHERE EmployeeID = 5;

-- 3) 1번 공급자의 전화번호, 주소 변경하기
SELECT * FROM suppliers WHERE SupplierID = 1;
UPDATE suppliers
SET Phone = 36138304,
    Address = 'SEOUL'
WHERE SupplierID = 1;

--

SELECT * FROM products WHERE CategoryID = 1;
UPDATE products
SET Price = Price * 2
WHERE CategoryID = 1;

SELECT * FROM shippers;

SELECT * FROM employees;












