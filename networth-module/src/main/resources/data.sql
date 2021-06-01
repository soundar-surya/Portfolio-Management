DROP TABLE IF EXISTS User;
CREATE TABLE User (
	id INT PRIMARY KEY,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(250) NOT NULL
);


INSERT INTO User VALUES(1, 'saikiran', '$2a$10$sFPlcRRlFmzHSHa0V4lbT.w7kf86edKVp19oLJdUN4Vgupx0a.tOG');
INSERT INTO User VALUES(2, 'avanish', '$2a$10$WVaPrAN0VRkrV86Ej0q0P.h1Bl/zrR0teEZ7p2na6DXzNSyG7ZcAa');
INSERT INTO User VALUES(3, 'soundarsurya', '$2a$10$iHQmn.vUc.YAsq87ba32lOwTzu1tPnhpcvKnL8mVHsw6s8TU4l2U6');
INSERT INTO User VALUES(4, 'swetha', '$2a$10$6TCsm7JVyYXnywd1O/rcz.4p3sa0/TDY.qMwRLSEF0gGriE5XmwlW');
INSERT INTO User VALUES(5, 'soumya', '$2a$10$dLfJ6lUY9AK7n88wmxK2DuIbeKQjoaZuaekCbzFs4ywkvaH.9ZBui');
INSERT INTO User VALUES(6, 'Alex123', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu');


