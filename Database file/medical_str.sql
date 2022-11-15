/*
SQLyog Community v13.1.3  (64 bit)
MySQL - 5.5.35 : Database - medical_str
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`medical_str` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `medical_str`;

/*Table structure for table `medicine` */

DROP TABLE IF EXISTS `medicine`;

CREATE TABLE `medicine` (
  `pname` varchar(20) DEFAULT NULL,
  `cname` varchar(20) DEFAULT NULL,
  `pcat` varchar(20) DEFAULT NULL,
  `pquat` varchar(20) DEFAULT NULL,
  `pprice` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `medicine` */

insert  into `medicine`(`pname`,`cname`,`pcat`,`pquat`,`pprice`) values 
('pcm','medicose','general','20','12'),
('avil','medicose','general','20','10'),
('psm','medicose','general','20','10'),
('pcm 500','medicose','general','50','10');

/*Table structure for table `pagal` */

DROP TABLE IF EXISTS `pagal`;

CREATE TABLE `pagal` (
  `bid` int(20) DEFAULT NULL,
  `dop` date DEFAULT NULL,
  `cname` varchar(20) DEFAULT NULL,
  `dname` varchar(20) DEFAULT NULL,
  `phno` varchar(20) DEFAULT NULL,
  `pname` varchar(20) DEFAULT NULL,
  `pprice` varchar(20) DEFAULT NULL,
  `pqut` varchar(20) DEFAULT NULL,
  `total` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pagal` */

insert  into `pagal`(`bid`,`dop`,`cname`,`dname`,`phno`,`pname`,`pprice`,`pqut`,`total`) values 
(28,'2019-07-17','Sahil','Salgotra','8825023390','avil','10','3','30');

/*Table structure for table `quantity` */

DROP TABLE IF EXISTS `quantity`;

CREATE TABLE `quantity` (
  `pqut` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `quantity` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `upass` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`fname`,`lname`,`uname`,`upass`) values 
('Sahil','Salgotra','Zain','moti@123'),('Chann','preet','chan','chan@123'),
('Rimpy','Sharma','Rimp','789@moti');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
