-- Data types:
-- https://www.mysqltutorial.org/mysql-data-types.aspx
-- Operators:
-- https://dev.mysql.com/doc/refman/5.7/en/comparison-operators.html

-- Display available databases
SHOW DATABASES;

-- Create a database called Shamrock
CREATE DATABASE IF NOT EXISTS shamrock;

-- Delete database gifted if exists
DROP DATABASE shamrock;

-- Activate database shamrock
USE shamrock;

-- Show tables in the active database
SHOW TABLES;

-- Create a table called 'mentor' with id, name, birth date and gender
CREATE TABLE mentor (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM("F", "M") NOT NULL
);

-- Show tables in the active database
SHOW TABLES;

-- Rename table to 'mentors'
RENAME TABLE mentor TO mentors;

-- Check the structure of table 'mentors'
DESCRIBE mentors;

-- Insert data into table 'mentors'
INSERT INTO mentors (birth_date, name, gender)  VALUES 
	("1999-01-01", "Máté", "M"),
    ("1800-02-02", "Bella", "F"),
    ("2000-03-03", "Riel", "M"),
    ("1995-05-19", "Jázmin", "F");

-- See all the mentors
SELECT * FROM mentors;

-- How can I delete them all?
DROP TABLE mentors;

-- MODIFICATIONS of table:
-- Add column 'score' (int) after 'birth_date'
ALTER TABLE mentors ADD score INT DEFAULT 0 AFTER birth_date;

-- Delete column
ALTER TABLE mentors DROP score;

-- Change column 'gender' (change gender to sex and properties)
ALTER TABLE mentors CHANGE gender sex ENUM("F", "M", "AH") NOT NULL;

-- Modify column 'sex' (only properties)
ALTER TABLE mentors MODIFY COLUMN sex ENUM("F", "M") NOT NULL;

-- Modify column 'sex' to 'gender' (only name)
ALTER TABLE mentors RENAME COLUMN sex TO gender;


-- DELETE RECORD
-- Delete mentor with the name 'Máté'
DELETE FROM mentors WHERE name = "Máté";


-- MODIFY RECORD
-- Modify name to Gedeon for mentor with id 3
UPDATE mentors SET name = "Gedeon" WHERE id = 3;