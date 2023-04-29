CREATE DATABASE  IF NOT EXISTS `isms`;

USE `isms`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
--
-- Default passwords here are: test123
--

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$12$0wiAbv7HyThTtQwz1A.VP.t2dqSWPaRKmeq3PLu.nm1HtU0hEu3E6',1),
('mary','{bcrypt}$2a$12$0wiAbv7HyThTtQwz1A.VP.t2dqSWPaRKmeq3PLu.nm1HtU0hEu3E6',1),
('smith','{bcrypt}$2a$12$0wiAbv7HyThTtQwz1A.VP.t2dqSWPaRKmeq3PLu.nm1HtU0hEu3E6',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_USER'),
('mary','ROLE_USER'),
('mary','ROLE_PROFESSOR'),
('smith','ROLE_USER'),
('smith','ROLE_PROFESSOR'),
('smith','ROLE_ADMIN');

CREATE DATABASE  IF NOT EXISTS `isms`;
USE `isms`;

--
-- Table structure for table `studentusers`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `student`
--

INSERT INTO `student` VALUES
	(1,'Leslie','Andrews','leslie@gmail.com'),
	(2,'Emma','Baumgarten','emma@gmail.com'),
	(3,'Avani','Gupta','avani@gmail.com'),
	(4,'Yuri','Petrov','yuri@gmail.com'),
	(5,'Juan','Vega','juan@gmail.com');

--
-- Table structure for table `professors`
--

DROP TABLE IF EXISTS `professor`;

CREATE TABLE `professor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `professor`
--

INSERT INTO `professor` VALUES
	(1,'Amjad','Nusayr','Nusayr@uhv.com'),
	(2,'John','Smith','smith@uhv.com'),
	(3,'Paris','Oak','oak@uhv.com'),
	(4,'Poliack','Ash','ash@uhv.com'),
	(5,'Hector','Hills','hector@uhv.com');

    --
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `admin`
--

INSERT INTO `admin` VALUES
	(1,'Admin1','lastname1','Admin1@uhv.com'),
	(2,'Admin2','lastname2','Admin2@uhv.com');


