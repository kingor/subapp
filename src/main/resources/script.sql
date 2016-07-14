-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: subscriber_db
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'id: 1 --- Логин: user --- Имя:Иванов Сергей Александрович --- Категория0','2016-07-14 15:25:10','Insert','admin'),(2,'id: 2 --- Логин: operator --- Имя:Семенов Виктор Васильевич --- Категория1','2016-07-14 15:26:01','Insert','admin'),(3,'id: 3 --- Логин: admin --- Имя:Логинов Леонид Игоревич --- Категория2','2016-07-14 15:27:06','Insert','admin'),(4,'id: 1 --- ФИО: Александров Владимир Михайлович --- Адрес: ул. Мира, д. 15 --- Примечание: ','2016-07-14 15:32:46','Insert','admin'),(5,'id: 1 --- ФИО: Александров Владимир Михайлович --- Номер: 552316 --- Громпол: 123 --- Охрана: 456 --- СЦВ: 7897 --- ADSL: 1234','2016-07-14 15:33:09','Insert','admin'),(6,'id: 2 --- ФИО: Миронов Иван Иванович --- Адрес: ул. --- Примечание: ','2016-07-14 15:33:47','Insert','admin'),(7,'id: 2 --- ФИО: Миронов Иван Иванович --- Адрес: ул. --- Примечание: ','2016-07-14 15:33:55','Before Update','admin'),(8,'id: 2 --- ФИО: Миронов Иван Иванович --- Адрес: ул. Первая, д.11 --- Примечание: неплательщик','2016-07-14 15:34:35','After Update','admin'),(9,'id: 2 --- ФИО: Александров Владимир Михайлович --- Номер: 114512 --- Громпол: 789 --- Охрана: 1234 --- СЦВ: 7891 --- ADSL: 7789','2016-07-14 15:35:08','Insert','admin'),(10,'id: 1 --- ФИО: Александров Владимир Михайлович --- Номер: 552316 --- Громпол: 123 --- Охрана: 456 --- СЦВ: 7897 --- ADSL: 1234','2016-07-14 15:35:37','Before Update','admin'),(11,'id: 2 --- ФИО: Миронов Иван Иванович --- Номер: 114512 --- Громпол: 789 --- Охрана: 1234 --- СЦВ: 7891 --- ADSL: 7789','2016-07-14 15:36:18','Before Update','admin'),(12,'id: 3 --- ФИО: Любимов Николай Федорович --- Адрес: ул. Ленина, д.8 --- Примечание: ','2016-07-14 15:37:45','Insert','admin'),(13,'id: 3 --- ФИО: Любимов Николай Федорович --- Номер: 784456 --- Громпол: 4788 --- Охрана: 896 --- СЦВ: 230 --- ADSL: 111','2016-07-14 15:38:23','Insert','admin');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subscriber`
--

LOCK TABLES `subscriber` WRITE;
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
INSERT INTO `subscriber` VALUES (1,'ул. Мира, д. 15','','Александров Владимир Михайлович'),(2,'ул. Первая, д.11','неплательщик','Миронов Иван Иванович'),(3,'ул. Ленина, д.8','','Любимов Николай Федорович');
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (1,'1234','123','552316','7897','456',1),(2,'7789','789','114512','7891','1234',2),(3,'111','4788','784456','230','896',3);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,'user','Иванов Сергей Александрович','user'),(2,1,'operator','Семенов Виктор Васильевич','operator'),(3,2,'admin','Логинов Леонид Игоревич','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-14 15:46:57
