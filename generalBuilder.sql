use mmdb;

CREATE TABLE `managers` (
  `managerid` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`managerid`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `medications` (
  `name` varchar(50) DEFAULT NULL,
  `ndc` bigint NOT NULL,
  `strength` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `schedule` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ndc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `customername` varchar(60) DEFAULT NULL,
  `ndc` bigint DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `orders_fk` (`ndc`),
  CONSTRAINT `orders_fk` FOREIGN KEY (`ndc`) REFERENCES `medications` (`ndc`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `updatehistory` (
  `date` VARCHAR(20) NOT NULL,
  `description` VARCHAR(100) NOT NULL);
