use mydb1;

-- PRIMARY KEY (주키, 기본키, pk)
CREATE TABLE my_table27 (
    id INT PRIMARY KEY,
    name VARCHAR(20)
);
CREATE TABLE my_table28 (
    id INT,
    name VARCHAR(10),
    PRIMARY KEY (id)
);
CREATE TABLE my_table29(
    name VARCHAR(10),
    birth DATE,
    PRIMARY KEY (name, birth)
);

CREATE TABLE my_table30 (
    id INT PRIMARY KEY AUTO_INCREMENT, -- 기본키는 주로 이런식으로 작성
    name VARCHAR(10)
);
-- 총 6번까지 있을때 4번을 지워서 다시 값을 넣는다 해도 4번으로 할당되지않음
-- 지워진 4번의 값에 다른 값을 넣는 행동은 최대한 하지 않아야함 ( 지워진 값을 복구 할 가능성도 있기 때문에 )
INSERT INTO my_table30 (name) VALUE ('son');
INSERT INTO my_table30 (name) VALUE ('lee');
INSERT INTO my_table30 (name) VALUE ('kim');
SELECT * FROM my_table30;
DELETE FROM my_table30 WHERE id = 4;


