DROP TABLE IF EXISTS User;
CREATE TABLE User (
	id INT PRIMARY KEY,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL
);
INSERT INTO User VALUES(1, 'surya', 'keychron');
INSERT INTO User VALUES(2, 'jesse', 'bluemeth');