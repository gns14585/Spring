-- INSERT INTO tableName (columnName1, columnName2 ...) VALUES (value1, value2 ...);

-- 칼럼의 갯수와 밸류의 갯수가 일치해야함
-- 엔터는 한번만 가능 2번부턴 안됨 ( 데이터를 넣는거니 1번만 넣는걸로 인식 )
INSERT INTO employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
    VALUE(10, '손', '흥민', '2000-01-01', '사진10', 'epl 득점왕');

INSERT INTO employees(EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
VALUE (11, '이', '강인', '2000-02-02', '사진11', '드리블 잘함');

-- 모든 컬럼에 값 넣을 떄 컬럼명 나열 생략 가능
INSERT INTO employees VALUE (12, '김', '민재', '2000-03-03', '사진12', '수비 잘함');

-- 특정 컬럼에만 값을 넣을 때 컬럼명 나열 생략하면 안됨
-- 나열된 컬럼명과 값의 순서, 갯수가 같아야함
INSERT INTO employees (EmployeeID, LastName, FirstName) VALUE (13, '박', '지성');

INSERT INTO employees(EmployeeID, FirstName, LastName) VALUE (14, '차', '범근');
INSERT INTO employees(EmployeeID, FirstName, LastName) VALUE (16, '김', '두식');

SELECT * FROM employees ORDER BY EmployeeID DESC;

-- 값의 타입에 따라 넣는 방법이 다름
INSERT INTO employees (EmployeeID) VALUE (15);
INSERT INTO employees (LastName) VALUE ('SON');
INSERT INTO employees (LastName) VALUE ('10000'); -- 따옴표 치는걸 권장
INSERT INTO employees (LastName) VALUE (10000); -- 권장하지 않음
INSERT INTO employees (BirthDate) VALUE ('2000-01-01');


INSERT INTO products (Price) VALUE (20.10);
INSERT INTO products (Price) VALUE ('30.33');

SELECT * FROM products ORDER BY Price DESC;
-- 1) 80번 상품 입력 (productId, productName, supplierId, categoryId, unit, price)
INSERT INTO products(ProductID, ProductName, SupplierID, CategoryID, Unit, Price)
    VALUE(80, 'IPHONE', 80, 80, 'ABCDEFG', 1560.0);

-- 2) 새상품 입력 (productName, supplierId, categoryId, unit, price)
-- ProductId 는 설정하지 않아도 자동으로 증가함
INSERT INTO products(PRODUCTNAME, SUPPLIERID, CATEGORYID, UNIT, PRICE)
VALUE('PRO', 81,81,'DIFNELV', 1700.0);

SELECT * FROM suppliers;

SELECT * FROM employees;







