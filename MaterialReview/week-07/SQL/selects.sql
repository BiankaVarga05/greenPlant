-- retreive data for female mentors
SELECT * FROM mentors WHERE gender LIKE "F";

-- retrive data for mentors whos name is ending with 'n'
SELECT * FROM mentors WHERE name LIKE "%n";

-- retreive names from mentors in a descending order by birth date
SELECT name FROM mentors ORDER BY birth_date DESC;

-- retreive first 2 items
SELECT * FROM mentors LIMIT 2;

-- retrive one item from the seconf record
SELECT * FROM mentors LIMIT 1 OFFSET 2;

-- retreive the genders present in the students table
SELECT DISTINCT gender FROM mentors;

-- count how many genders are present in the mentors table as 'number of genders'
SELECT COUNT(DISTINCT gender) AS "number of genders" FROM mentors;

-- count how many people are present in different sexes
SELECT COUNT(*), gender FROM mentors GROUP BY gender;