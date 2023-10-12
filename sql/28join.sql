SELECT * FROM products;
SELECT * FROM categories;

-- chais 상품의 카테고리명은?
SELECT CategoryID FROM products WHERE ProductName = 'chais';
SELECT CategoryName FROM categories WHERE CategoryID = 1;

-- JOIN : 두개의 테이블 결합
SELECT * FROM categories JOIN products; -- 616

SELECT COUNT(*) FROM categories; -- 8
SELECT COUNT(*) FROM products; -- 77

--
CREATE TABLE table_a (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(20),
    category_id INT
);
CREATE TABLE table_b (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(20)
);
INSERT INTO table_b (category_name) VALUES ('음료수'), ('반찬');
INSERT INTO table_a (product_name, category_id)
VALUES ('콜라', 1),
       ('사이다', 1),
       ('제육', 2),
       ('돈까스', 2),
       ('두부', 2);

SELECT * FROM table_a JOIN table_b;

-- 두 테이블을 결합하면 조회된 레코드 수는 A테이블 row * B테이블 row
-- 컬럼 수는 A테이블 열 + B테이블 열

-- JOIN 여러테이블 사용시 컬럼명 작성할땐 테이블명.컬럼명 으로 작성
SELECT *
FROM table_a JOIN table_b WHERE table_a.product_name = '콜라' -- 컬럼명이 하나의 테이블에만 있을때 테이블명 생략 가능
                                     -- 같은 컬럼명이 여러테이블에 있다면 테이블명 작성
                                     -- category_id는 table_a 에도 있고 , table_b에도 있으니 테이블명 적어줘야 함
                                     AND table_a.category_id = table_a.category_id;

-- WHERE 대신 ON 사용
SELECT *
FROM table_a JOIN table_b
ON table_a.category_id = table_b.category_id
AND product_name = '콜라';

SELECT ProductID, ProductName, CategoryName     -- 컬럼명
FROM products JOIN categories                   -- 테이블명
ON products.CategoryID = categories.CategoryID
WHERE ProductName = 'chais';

-- AS 사용으로 코드양 줄이기
SELECT ProductID, ProductName, CategoryName
FROM products p JOIN categories c
ON p.CategoryID = c.CategoryID
WHERE ProductName = 'chais';

-- 예제
-- 1) chais 상품의 공급자명, 전화번호
SELECT SupplierName, Phone
FROM suppliers JOIN products
ON suppliers.SupplierID = products.SupplierID
WHERE ProductName = 'chais';

-- 2) 1996년 7월 4일 에 주문한 고객명 (customers, orders)
SELECT CustomerName
FROM customers JOIN orders
ON customers.CustomerID = orders.CustomerID
WHERE OrderDate = '1996-07-04';

-- 3) 1996년 7월 4일 에 주문을 담당한 직원명 (employees, orders)
SELECT LastName, FirstName
FROM employees JOIN orders
ON employees.EmployeeID = orders.EmployeeID
WHERE OrderDate = '1996-07-04';

SELECT COUNT(*) FROM products;  -- 77
SELECT COUNT(*) FROM shippers;  -- 29
SELECT COUNT(*) FROM categories;-- 7
SELECT 77 * 29 * 8;

-- 3개 테이블 조회
SELECT p.ProductName, s.SupplierName, s.Phone, c.CategoryName
FROM products p JOIN suppliers s JOIN categories c
ON P.SupplierID = S.SupplierID
AND P.CategoryID = C.CategoryID
WHERE P.ProductName = 'chais';

-- 예제
-- 1) 'Chang'상품의 공급자명, 카테고리명 조회
SELECT ProductName, SupplierName, CategoryName
FROM products P JOIN categories C JOIN suppliers S
ON P.SupplierID = S.SupplierID
AND P.CategoryID = C.CategoryID
WHERE P.ProductName = 'Chang';

-- 2) 1996년 7월 9일에 주문한 고객명과, 처리한 직원명
SELECT CustomerName , FirstName, LastName
FROM customers C JOIN employees E JOIN orders O
ON O.CustomerID = C.CustomerID
AND O.EmployeeID = E.EmployeeID
WHERE O.OrderDate = '1996-07-09';

-- 3) 1996년 7월 9일에 주문한 상품명 (orders, orderDetails, products)
SELECT ProductName
FROM orders O JOIN orderdetails D JOIN products P
ON P.ProductID = D.ProductID
AND O.OrderID = D.OrderID
WHERE O.OrderDate = '1996-07-09';


-- 1) 'Chang' 상품이 주문된 날짜들
SELECT ProductName, OrderDate, CustomerName, CONCAT(E.LastName , ' ' , E.FirstName) FullName
FROM products p JOIN orderdetails OD JOIN orders O JOIN customers C JOIN employees E
ON P.ProductID = OD.ProductID
-- 매칭 시키는게 주문날짜니까 주문날짜는 Orders 에 있으니 조회 하려는 것들과 매칭
-- 중요한것은 해당 테이블에 어떤 데이터들이 있는지 알아야 하는게 중요함
AND O.OrderID = OD.OrderID
AND O.CustomerID = C.CustomerID
AND O.EmployeeID = E.EmployeeID
WHERE P.ProductName = 'Chang';








