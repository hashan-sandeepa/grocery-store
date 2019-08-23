-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: grocery_store
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--
DROP DATABASE IF EXISTS grocery_store;
CREATE DATABASE grocery_store;
USE grocery_store;

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustID` varchar(6) NOT NULL,
  `CustName` varchar(30) DEFAULT NULL,
  `CustAddress` varchar(30) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`CustID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('C001','Danapala','Panadura',54000.00),('C002','Gunapala','Matara',44000.00),('C003','Somapala','Galle',82000.00),('C004','Siripala','Galle',24000.00),('C005','Jinadasa','Panadura',94000.00),('C006','Sepalika','Kalutara',58000.00),('C007','Jinasena','Ambalangoda',51000.00),('C008','Somadasa','Baddegama',34000.00),('C009','Danasiri','Moratuwa',29000.00),('C010','Somasiri','Kandy',64000.00),('C011','HaShaN','Tangalle',10000.00);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `ItemCode` varchar(6) NOT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `QtyOnHand` int(5) DEFAULT NULL,
  `UnitPrice` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`ItemCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('P001','Keerisamba Retail',3000,100.00),('P002','Keerisamba 5Kg ',200,525.00),('P003','Keerisamba 10Kg',36,995.00),('P004','Keerisamba 50Kg',36,4100.00),('P005','Red Raw Rice',6000,60.00),('P006','Red Raw Rice 10Kg Pack',300,560.00),('P007','Red Raw Rice 50Kg Pack',80,5230.00),('P008','White Raw Rice 5Kg Pack',130,275.00),('P009','White Raw Rice 50Kg Pack',13,2600.00),('P010','Wattana Dhal 500g',83,90.00),('P011','Wattana Dhal 1Kg',40,170.00),('P012','Mysoor Dhal 500g',89,90.00),('P013','Mysoor Dhal 1Kg',59,180.00),('P014','Orient Green Gram 500g',39,118.00),('P015','Orient Green Gram 1Kg',12,220.00),('P016','Anchor F/C Milk powder 450g',93,220.00),('P017','Anchor F/C Milk powder 1Kg',40,580.00),('P018','Anchor N/F Milk powder 1Kg',33,560.00),('P019','Milo Packet 400g',33,240.00),('P020','Lipton Ceylon Tea 100g',38,107.00);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetail` (
  `OID` varchar(6) NOT NULL,
  `ItemCode` varchar(6) NOT NULL,
  `QTY` int(11) DEFAULT NULL,
  `UnitPrice` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`OID`,`ItemCode`),
  KEY `ItemCode` (`ItemCode`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`OID`) REFERENCES `orders` (`OID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`ItemCode`) REFERENCES `item` (`ItemCode`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES ('D001','P001',3,105.00),('D001','P002',5,525.00),('D001','P003',8,995.00),('D001','P006',1,560.00),('D001','P020',2,107.00),('D002','P002',4,525.00),('D002','P003',4,995.00),('D002','P008',3,275.00),('D002','P010',7,90.00),('D002','P012',3,90.00),('D003','P001',9,105.00),('D003','P004',6,4100.00),('D003','P014',7,118.00),('D004','P002',2,525.00),('D004','P004',3,190.00),('D004','P005',7,60.00),('D004','P008',1,275.00),('D004','P012',2,90.00),('D004','P014',4,118.00),('D004','P015',5,220.00),('D004','P016',8,220.00),('D004','P019',9,240.00),('D004','P020',5,107.00),('D005','P001',6,105.00),('D005','P003',8,995.00),('D005','P007',9,5230.00),('D006','P003',9,995.00),('D006','P006',8,560.00),('D007','P020',1,107.00),('D008','P001',3,105.00),('D009','P001',9,105.00),('D009','P002',2,525.00),('D009','P003',2,995.00),('D009','P005',2,60.00),('D009','P006',5,560.00),('D009','P007',9,5230.00),('D009','P008',2,275.00),('D010','P001',6,105.00),('D010','P002',3,525.00),('D010','P004',6,4100.00),('D010','P010',6,90.00),('D010','P012',3,90.00),('D010','P016',5,220.00);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `OID` varchar(6) NOT NULL,
  `CustID` varchar(6) NOT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`OID`),
  KEY `CustID` (`CustID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`CustID`) REFERENCES `customer` (`CustID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('D001','C001','2017-12-15'),('D002','C005','2017-12-15'),('D003','C007','2017-12-20'),('D004','C002','2017-12-21'),('D005','C001','2017-12-22'),('D006','C003','2017-12-23'),('D007','C004','2017-12-23'),('D008','C005','2017-12-23'),('D009','C006','2017-12-24'),('D010','C006','2017-12-24');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `PID` varchar(6) NOT NULL,
  `OID` varchar(6) NOT NULL,
  `Total` decimal(8,2) DEFAULT NULL,
  `Discount` decimal(8,2) DEFAULT NULL,
  `Cash` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`PID`),
  KEY `OID` (`OID`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`OID`) REFERENCES `orders` (`OID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('P001','D001',10174.00,1500.00,9000.00);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-25  7:54:49
