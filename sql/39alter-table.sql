use w3schools;

-- ALTER TABLE : 테이블 수정
-- 컬럼 추가, 변경, 삭제

-- 제약사항 변경
-- NOT NULL, UNIQUE, PRIMARY KEY, DEFAULT, FOREIGN KEY

-- 컬럼 추가
ALTER TABLE products
ADD COLUMN col1 INT;
ALTER TABLE products
ADD COLUMN col2 VARCHAR(10);
-- ProductName 뒤에 추가 (주의)
ALTER TABLE products
ADD COLUMN col3 VARCHAR(10) AFTER ProductName;
-- 첫번째에 추가
ALTER TABLE products
ADD COLUMN col4 VARCHAR(10) FIRST;
-- 제약사항 추가
ALTER TABLE products
ADD COLUMN col5 INT
    NOT NULL DEFAULT 1 REFERENCES employees(EmployeeID);
DESC products;
DESC employees;
-- 1) 직원 테이블에 salay 컬럼 마지막에 추가
-- data type은 dec(10, 2), null 허용안하고, default 0,00
ALTER TABLE employees
ADD COLUMN salay1 DEC(10,2) NOT NULL DEFAULT 0.00;

-- 컬럼 삭제
ALTER TABLE products
DROP COLUMN col1;

-- 1) products 테이블에서 col2 컬럼 삭제
ALTER TABLE products
DROP COLUMN col2;

-- 컬럼 변경 (type)
ALTER TABLE products
MODIFY COLUMN col3 INT;

INSERT INTO products (col4)
VALUES ('pizza');
SELECT * FROM products
ORDER BY ProductID DESC;

-- 이미 데이터 값이 pizza로 들어갔기 때문에 타입을 INT로 변경 불가
ALTER TABLE products
MODIFY COLUMN col4 INT;
-- 길이를 늘리는건 상관없지만 줄이는건 위험부담이 큼
ALTER TABLE products
MODIFY COLUMN col4 VARCHAR(20);

ALTER TABLE products
MODIFY COLUMN col4 VARCHAR(3); -- 'pizza' 길이가 5라 3으로 변경불가

DESC products;





















