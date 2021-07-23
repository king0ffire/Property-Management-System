-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: propertymanagement
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `build`
--

DROP TABLE IF EXISTS `build`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `build` (
  `build_id` int NOT NULL AUTO_INCREMENT,
  `build_name` varchar(36) DEFAULT NULL,
  `build_floornum` int NOT NULL,
  `build_housenum` int NOT NULL,
  `build_time` date DEFAULT NULL,
  `build_accept` int NOT NULL,
  `build_layout` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`build_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `build`
--

LOCK TABLES `build` WRITE;
/*!40000 ALTER TABLE `build` DISABLE KEYS */;
INSERT INTO `build` VALUES (10,'1号楼',6,12,'1998-10-10',12,'A型'),(11,'2号楼',12,36,'2003-10-10',30,'B型'),(12,'3号楼',34,68,'2008-10-10',54,'C型');
/*!40000 ALTER TABLE `build` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost` (
  `cost_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cost_reason` varchar(36) DEFAULT NULL,
  `cost_time` date DEFAULT NULL,
  `owner_id` varchar(36) DEFAULT NULL,
  `cost_total` double DEFAULT NULL,
  PRIMARY KEY (`cost_id`),
  KEY `cost_FK` (`owner_id`),
  CONSTRAINT `cost_FK` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
INSERT INTO `cost` VALUES ('088802d2-dc6b-4d59-ae1a-69ea3f5b5392','物业费','2001-04-29','d0f9b417-a408-42f3-85b2-c38028ddbc3f',232.53),('3324131f-d533-49b7-8252-e90291f9e716','电费','2020-11-14','f1a48898-7fc5-4de4-8ba2-810a02fd70fa',10.23),('36df3c98-3b2c-4e2c-9fe1-f4ebabb7a91b','维修费','2006-08-18','fdd63346-f147-4e2d-921f-02a2c1302a2f',556.23),('52db2015-650b-4afe-a147-43288c2c8104','水费','2004-04-29','6c6bdc5d-fd63-47ac-965e-6635fa001aa0',12.54),('6b8be1ad-3857-4183-8037-445fc4712509','电费','2019-02-12','5869abab-9ae9-4762-a260-8d679ac53c6a',40.32),('706f29f3-2ae3-4d8b-8546-244acedbec73','水费','2020-11-10','f1a48898-7fc5-4de4-8ba2-810a02fd70fa',31.2),('8e58e834-d64e-4660-8ae8-2d085a747f8d','停车费','2006-09-12','1bb30fef-dc96-47fc-a599-2f742f5afb15',54.38),('948ad000-1fc8-445f-8ee5-19de3ca075d5','电费','2001-03-15','2b6d3a62-29f1-45aa-a4c5-7b9c595475fc',253.56),('a39880ce-7a79-44b3-a1fd-1ca2296a5150','燃气费','2007-09-18','4d74de89-f86e-47ef-8cda-60532fa3cb3b',12.1),('cf5aee3f-59d7-41b0-8ad8-83b14e7e1ff1','水费','2001-03-14','2b6d3a62-29f1-45aa-a4c5-7b9c595475fc',104.25);
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `property_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `build_id` int NOT NULL,
  `house_id` int DEFAULT NULL,
  `house_time` date DEFAULT NULL,
  `house_type` varchar(36) DEFAULT NULL,
  `house_area` int NOT NULL,
  `owner_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`property_id`),
  KEY `house_FK` (`build_id`),
  KEY `house_FK_1` (`owner_id`),
  CONSTRAINT `house_FK` FOREIGN KEY (`build_id`) REFERENCES `build` (`build_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `house_FK_1` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES ('09d4433e-9763-4dff-af61-7606b0a22785',11,502,'2004-03-10','三室一厅',120,'6c6bdc5d-fd63-47ac-965e-6635fa001aa0'),('1e26fdaa-4e77-4b50-9a0f-626569902037',11,902,'2006-08-10','三室一厅',100,'1bb30fef-dc96-47fc-a599-2f742f5afb15'),('3f87c7b6-00bb-4005-af68-476a352b1052',10,502,'2000-03-10','两室一厅',100,'2b6d3a62-29f1-45aa-a4c5-7b9c595475fc'),('4adea8d9-e134-45c6-8cc5-9c9d2faec4bf',11,1001,'2006-08-11','三室一厅',100,'4d74de89-f86e-47ef-8cda-60532fa3cb3b'),('71edbdaa-6d5e-4234-879f-ded9258077a3',11,1103,'2005-12-10','三室一厅',100,'fdd63346-f147-4e2d-921f-02a2c1302a2f'),('987a2963-2064-42fb-bd92-335cde84b831',10,601,'2000-10-01','两室一厅',100,'d0f9b417-a408-42f3-85b2-c38028ddbc3f'),('9fab97ce-a0da-479f-918c-def9e5ce4337',10,301,'2000-03-10','两室一厅',100,'2b6d3a62-29f1-45aa-a4c5-7b9c595475fc'),('c32391b6-b300-4cc1-a3ab-4b1f61fac891',12,1002,'2019-01-11','四室两厅',120,'5869abab-9ae9-4762-a260-8d679ac53c6a'),('d07d59c2-67f6-4557-8539-db845b7294c6',12,1601,'2009-04-11','四室两厅',120,'f1a48898-7fc5-4de4-8ba2-810a02fd70fa'),('e03b0960-ec84-45b9-9fec-a5b2e1c785a2',12,1801,'2019-10-12','四室两厅',120,'f1a48898-7fc5-4de4-8ba2-810a02fd70fa');
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `member_id` varchar(36) NOT NULL,
  `owner_id` varchar(36) DEFAULT NULL,
  `member_name` varchar(36) DEFAULT NULL,
  `member_gender` varchar(36) DEFAULT NULL,
  `member_hometown` varchar(36) DEFAULT NULL,
  `member_phone` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `member_FK` (`owner_id`),
  CONSTRAINT `member_FK` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('1b786208-a8b2-47ef-b78e-65300db0fe19','6c6bdc5d-fd63-47ac-965e-6635fa001aa0','王师傅','男','大连','1981897344821'),('22b9d108-3c6a-405b-9808-86611876f501','895633e5-690b-4505-a00c-2524c40e5d56','瑟提','男','德克萨斯','13211454473'),('531a1a0d-7ae4-4ff1-84c8-b941dfe8be0e','f1a48898-7fc5-4de4-8ba2-810a02fd70fa','张大炮','男','黑龙江','16648274822'),('63abda78-d52a-46cd-8eb8-20eb8edd5230','1bb30fef-dc96-47fc-a599-2f742f5afb15','尉','女','山东','13724483900'),('7a12c654-1c92-4834-8ec8-d7e2f89d3288','2b6d3a62-29f1-45aa-a4c5-7b9c595475fc','塔脑西','女','日本','19777263729'),('8eb604f9-3242-4776-9623-11622bd642a7','fdd63346-f147-4e2d-921f-02a2c1302a2f','萨满','男','贫瘠之地','15526385755'),('a1f4339a-c6fd-4d96-a08a-21f9edfbe496','a4834726-20b4-4183-a8f0-48aeade11f52','沃尔玛','女','美国','12234567890'),('b077ec9f-fc9f-4d1f-be99-af3d17836a02','d0f9b417-a408-42f3-85b2-c38028ddbc3f','拉克丝','女','德玛西亚','18463967593'),('dd6d1b00-cce2-4a97-83e4-1e05f158d03c','4d74de89-f86e-47ef-8cda-60532fa3cb3b','亚托克斯','男','陕西','14526338944'),('fe36fdf0-9dc8-4e31-8430-7ebddce6ee69','5869abab-9ae9-4762-a260-8d679ac53c6a','李不苟','男','山西','15652456722');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `owner_id` varchar(36) NOT NULL,
  `owner_name` varchar(36) DEFAULT NULL,
  `owner_gender` varchar(36) DEFAULT NULL,
  `owner_hometown` varchar(36) DEFAULT NULL,
  `owner_phone` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES ('1bb30fef-dc96-47fc-a599-2f742f5afb15','凯特琳','女','皮尔特沃夫','11017283955'),('2b6d3a62-29f1-45aa-a4c5-7b9c595475fc','塔姆','男','符文之地','14404829046'),('4d74de89-f86e-47ef-8cda-60532fa3cb3b','易','男','艾欧尼亚','1847204729'),('5869abab-9ae9-4762-a260-8d679ac53c6a','李四','男','上海','17462957105'),('6c6bdc5d-fd63-47ac-965e-6635fa001aa0','王二麻','女','天津','19472957200'),('895633e5-690b-4505-a00c-2524c40e5d56','德莱厄斯','男','诺克萨斯','17629840038'),('a4834726-20b4-4183-a8f0-48aeade11f52','沃里克','男','祖安','19375018402'),('d0f9b417-a408-42f3-85b2-c38028ddbc3f','拉莫斯','男','恕瑞玛','17387733679'),('f1a48898-7fc5-4de4-8ba2-810a02fd70fa','张三','男','北京','18784738247'),('fdd63346-f147-4e2d-921f-02a2c1302a2f','萨科','男','符文之地','18364827492');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay`
--

DROP TABLE IF EXISTS `pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay` (
  `pay_id` varchar(36) NOT NULL,
  `cost_id` varchar(36) DEFAULT NULL,
  `pay_money` double DEFAULT NULL,
  `pay_time` date DEFAULT NULL,
  `pay_remark` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`pay_id`),
  KEY `pay_FK` (`cost_id`),
  CONSTRAINT `pay_FK` FOREIGN KEY (`cost_id`) REFERENCES `cost` (`cost_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay`
--

LOCK TABLES `pay` WRITE;
/*!40000 ALTER TABLE `pay` DISABLE KEYS */;
INSERT INTO `pay` VALUES ('0aee1e2a-5d11-4577-ad71-7d6dd28f1c88','cf5aee3f-59d7-41b0-8ad8-83b14e7e1ff1',500,'2001-03-16','用水量过大'),('194d1859-d5fb-4f61-8ace-7aceb0f2d833','36df3c98-3b2c-4e2c-9fe1-f4ebabb7a91b',600,'2008-02-12','交钱拖拉'),('3d0415e2-f0f0-483a-8dcf-6326081b1b31','088802d2-dc6b-4d59-ae1a-69ea3f5b5392',300,'2001-06-18','态度很好'),('3e59c273-7140-427e-80a7-b0a8ee563bba','3324131f-d533-49b7-8252-e90291f9e716',100,'2020-11-23','无'),('87448837-15c9-4877-9dd1-c529b71896ef','8e58e834-d64e-4660-8ae8-2d085a747f8d',100,'2006-10-10','无'),('aa5b682d-af4a-41fd-883a-71f721e8644d','52db2015-650b-4afe-a147-43288c2c8104',100,'2004-05-01','无'),('bcd2f6b9-90dd-4e2b-9e92-5aad9cf87086','706f29f3-2ae3-4d8b-8546-244acedbec73',100,'2020-11-18','无'),('cf248635-0c96-4c57-99fc-c869b30c7c2f','a39880ce-7a79-44b3-a1fd-1ca2296a5150',100,'2007-09-20','无'),('dde2daed-a501-4fa2-944e-bb391fddea57','6b8be1ad-3857-4183-8037-445fc4712509',100,'2019-03-01','无'),('e766d37d-42e7-4fa0-8690-9b204528cd51','948ad000-1fc8-445f-8ee5-19de3ca075d5',300,'2001-03-20','无');
/*!40000 ALTER TABLE `pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'propertymanagement'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-21  9:57:20
