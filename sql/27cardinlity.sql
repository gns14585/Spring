-- 1 : n

-- 책 347p
-- 1 : 1
CREATE TABLE my_table37_employee (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(20),
    birth DATE
);
CREATE TABLE my_table38_employee_info(
    id INT REFERENCES my_table37_employee(id),
    salary INT,
    address VARCHAR(20)
);

-- 책 350p
-- n : n (多 대 多)
-- 1 : n , 1 : m 인 중
CREATE TABLE my_table39_person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20)
);
CREATE TABLE my_table40_skill (
    id INT PRIMARY KEY AUTO_INCREMENT,
    skill_name VARCHAR(20)
);
CREATE TABLE my_table41_person_skill (
    person_id INT REFERENCES my_table39_person(id),
    skill_id INT REFERENCES my_table40_skill(id),
    PRIMARY KEY (person_id, skill_id)
);












