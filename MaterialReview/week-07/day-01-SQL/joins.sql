-- Create table for classes (One class can have one mentor)
-- id, name, tech
-- connect it with mentors table
CREATE TABLE classes(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    tech VARCHAR(30) NOT NULL,
    mentor_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (mentor_id) REFERENCES mentors(id)
);

DESCRIBE classes;

SELECT * FROM mentors;
-- insert data
INSERT INTO classes (name, tech, mentor_id) VALUES 
	("Shamrock", "Java", 3), 
    ("Mantis", "Java", 2), 
    ("Forest", "JS", 3);
SELECT * FROM classes;

-- get all records from mentors with their classes
SELECT * FROM mentors JOIN classes 
	ON mentors.id = classes.mentor_id;
SELECT * FROM mentors, classes 
	WHERE mentors.id = classes.mentor_id;
    
-- List mentor names and class names only
SELECT mentors.name AS "mentorname", classes.name FROM mentors JOIN classes 
	ON mentors.id = classes.mentor_id;

-- Show the names of those mentors who teach Java
SELECT DISTINCT mentors.name FROM mentors JOIN classes
	ON mentors.id = classes.mentor_id 
    WHERE tech = "Java";