use mmdb;
show create table Managers;

CREATE TABLE `managers` (
  `managerid` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`managerid`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci