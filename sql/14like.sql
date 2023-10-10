SELECT * FROM customers WHERE CustomerName = 'Alfreds Futterkiste';
SELECT * FROM customers WHERE CustomerName LIKE '%the%';
SELECT * FROM customers WHERE CustomerName LIKE '%ch%';

-- LIKE : 검색
-- %, _ 기호(wildcard)와 같이
SELECT * FROM customers WHERE CustomerName LIKE 'ch%'; -- % : ch로 시작하는 0개 이상의 문자
SELECT * FROM customers WHERE CustomerName LIKE '%er'; -- % : er로 끝나는 0개 이상의 문자
SELECT * FROM customers WHERE CustomerName LIKE '%er%'; -- % : 단어 중간에 er이 있다면 0개 이상의 문자

-- _ : 1개의 문자 아무거나
SELECT * FROM employees WHERE FirstName LIKE '_____'; -- _____ : 5개의 문자 아무거나
SELECT * FROM employees WHERE LastName LIKE '____'; -- ____ : 4개의 문자 아무거나

SELECT * FROM employees WHERE LastName LIKE '_e%'; -- 두번째 문자가 e인 LastName

-- 1) ch로 시작하는 상품명 조회
SELECT * FROM products WHERE ProductName LIKE 'ch%';

-- 2) es로 끝나는 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '%es';

-- 3) 중간에 use가 들어간 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '%use%';

-- 4) 두번째 글자가 u인 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '_u%';

SELECT * FROM customers WHERE CustomerName LIKE '%red%';
SELECT * FROM customers WHERE ContactName LIKE '%red%';

SELECT * FROM employees;