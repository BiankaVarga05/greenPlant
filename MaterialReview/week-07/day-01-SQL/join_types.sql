DROP TABLE classes;
DROP TABLE mentors;
SHOW TABLES;

CREATE TABLE mentors (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30) NOT NULL, 
    birth_date DATE NOT NULL, 
    gender ENUM("F", "U", "M") NOT NULL
);

CREATE TABLE classes (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL, 
    tech VARCHAR (30) NOT NULL,
    mentor_id INT UNSIGNED
);

INSERT INTO mentors (name, birth_date, gender) VALUES  ("Ferenc", "1978-04-04", "M"), ("Ági", "1979-04-04", "F"), ("Tamás", "1980-04-04", "M"), ("Emese", "1981-04-04", "F");
INSERT INTO classes (name, tech, mentor_id) VALUES ("A", "Java", 1), ("B", "C#", 2), ("C", "JS", null),  ("D", "Python", null);


-- Display all mentors
SELECT * FROM mentors  
	JOIN classes 
    -- LEFT JOIN classes
    -- RIGHT JOIN classes
    ON mentors.id = classes.mentor_id;
    
-- (INNER) JOIN: Returns records that have matching values in both tables
-- LEFT (OUTER) JOIN: Returns all records from the left table, and the matched records from the right table
-- RIGHT (OUTER) JOIN: Returns all records from the right table, and the matched records from the left table
