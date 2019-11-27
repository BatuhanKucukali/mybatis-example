CREATE TABLE employees
(
    id         INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) not null
);

INSERT INTO employees (first_name, last_name, email) VALUES ('John', 'Doe', 'john@doe.com');
INSERT INTO employees (first_name, last_name, email) VALUES ('Jane', 'Doe', 'john@doe.com');