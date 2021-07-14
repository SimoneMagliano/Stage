-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: ecobonus
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `iniziolavori`
--

DROP TABLE IF EXISTS `iniziolavori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iniziolavori` (
  `idInizioLavori` int NOT NULL,
  `idIntervento` int NOT NULL,
  `dataInizio` datetime DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idInizioLavori`),
  KEY `FK_InizioLavori_Interventi_idx` (`idIntervento`),
  CONSTRAINT `FK_InizioLavori_Interventi` FOREIGN KEY (`idIntervento`) REFERENCES `interventi` (`idIntervento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iniziolavori`
--

LOCK TABLES `iniziolavori` WRITE;
/*!40000 ALTER TABLE `iniziolavori` DISABLE KEYS */;
/*!40000 ALTER TABLE `iniziolavori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interventi`
--

DROP TABLE IF EXISTS `interventi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interventi` (
  `idIntervento` int NOT NULL AUTO_INCREMENT,
  `CodiceSede` varchar(45) DEFAULT NULL,
  `CodTipoIntervento` varchar(45) DEFAULT NULL,
  `Descrizione` varchar(45) DEFAULT NULL,
  `Referente` varchar(45) DEFAULT NULL,
  `Contatto` varchar(45) DEFAULT NULL,
  `Cliente` varchar(45) DEFAULT NULL,
  `idRegione` int NOT NULL,
  PRIMARY KEY (`idIntervento`),
  KEY `FK_Interventi_Regioni_idx` (`idRegione`),
  KEY `FK_Interventi_Tipiinterventi_idx` (`CodTipoIntervento`),
  KEY `FK_Interventi_Sedi_idx` (`CodiceSede`),
  CONSTRAINT `FK_Interventi_Regioni` FOREIGN KEY (`idRegione`) REFERENCES `regioni` (`IdRegione`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Interventi_Sedi` FOREIGN KEY (`CodiceSede`) REFERENCES `sedi` (`CodSede`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Interventi_Tipiinterventi` FOREIGN KEY (`CodTipoIntervento`) REFERENCES `tipiinterventi` (`CodiceTipoIntervento`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interventi`
--

LOCK TABLES `interventi` WRITE;
/*!40000 ALTER TABLE `interventi` DISABLE KEYS */;
INSERT INTO `interventi` VALUES (1,'TORINO','A','Sono un figo','Sempre Simo','Diretto','Simo',7),(2,'TORINO','B','Sono un figo','Sempre Simo','Diretto','Simo',12),(3,'TORINO','C','Intervento a gamba tesa','Sempre Simo','Diretto','Simo',12);
/*!40000 ALTER TABLE `interventi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regioni`
--

DROP TABLE IF EXISTS `regioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regioni` (
  `IdRegione` int NOT NULL,
  `NomeRegione` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdRegione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regioni`
--

LOCK TABLES `regioni` WRITE;
/*!40000 ALTER TABLE `regioni` DISABLE KEYS */;
INSERT INTO `regioni` VALUES (0,'Non definita'),(1,'Abruzzo'),(2,'Basilicata'),(3,'Calabria'),(4,'Campania'),(5,'Emilia Romagna'),(6,'Friuli-Venezia Giulia'),(7,'Lazio'),(8,'Liguria'),(9,'Lombardia'),(10,' Marche'),(11,' Molise'),(12,' Piemonte'),(13,' Puglia'),(14,' Sardegna'),(15,' Sicilia'),(16,' Toscana'),(17,' Trentino-Alto Adige'),(18,' Umbria'),(19,' Val d\'Aosta'),(20,' Veneto');
/*!40000 ALTER TABLE `regioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sedi`
--

DROP TABLE IF EXISTS `sedi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sedi` (
  `CodSede` varchar(13) NOT NULL,
  `Descrizione` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodSede`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sedi`
--

LOCK TABLES `sedi` WRITE;
/*!40000 ALTER TABLE `sedi` DISABLE KEYS */;
INSERT INTO `sedi` VALUES ('CASERTA','Caserta'),('NAPOLI','Napoli'),('TORINO','Torino');
/*!40000 ALTER TABLE `sedi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipiinterventi`
--

DROP TABLE IF EXISTS `tipiinterventi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipiinterventi` (
  `CodiceTipoIntervento` varchar(1) NOT NULL,
  `Descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CodiceTipoIntervento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipiinterventi`
--

LOCK TABLES `tipiinterventi` WRITE;
/*!40000 ALTER TABLE `tipiinterventi` DISABLE KEYS */;
INSERT INTO `tipiinterventi` VALUES ('A','A'),('B','B'),('C','C');
/*!40000 ALTER TABLE `tipiinterventi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipiutente`
--

DROP TABLE IF EXISTS `tipiutente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipiutente` (
  `IdTipoUtente` int NOT NULL,
  `Descrizione` varchar(50) NOT NULL,
  PRIMARY KEY (`IdTipoUtente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipiutente`
--

LOCK TABLES `tipiutente` WRITE;
/*!40000 ALTER TABLE `tipiutente` DISABLE KEYS */;
INSERT INTO `tipiutente` VALUES (1,'admin'),(2,'superuser'),(11,'Impresa'),(12,'Professionista'),(13,'Amministratore cond.');
/*!40000 ALTER TABLE `tipiutente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenti` (
  `IdUtente` int NOT NULL AUTO_INCREMENT,
  `IdTipoUtente` int NOT NULL DEFAULT '99',
  `IdRegione` int NOT NULL DEFAULT '0',
  `Email` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Cognome` varchar(45) DEFAULT NULL,
  `RagioneSociale` varchar(45) DEFAULT NULL,
  `CodFisc_PIva` varchar(16) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Indirizzo` varchar(50) DEFAULT NULL,
  `Pec` varchar(50) DEFAULT NULL,
  `IsActive` tinyint NOT NULL DEFAULT '0',
  `IdLastMod` int NOT NULL DEFAULT '0',
  `StartDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LastDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`IdUtente`),
  KEY `utenti_ibfk_1_idx` (`IdTipoUtente`),
  KEY `FK_Utenti_Regioni_idx` (`IdRegione`),
  CONSTRAINT `FK_Utenti_Regioni` FOREIGN KEY (`IdRegione`) REFERENCES `regioni` (`IdRegione`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utenti_ibfk_1` FOREIGN KEY (`IdTipoUtente`) REFERENCES `tipiutente` (`IdTipoUtente`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (119,1,12,'simone.magliano@libero.it','Scorpion1985','Simone','Magliano','Simo',NULL,NULL,NULL,NULL,0,0,'2021-06-29 11:35:25','2021-06-29 11:35:25'),(120,1,13,'simone.magliano@libero.it','Scorpion1985','Simone','Magliano','Simo',NULL,NULL,NULL,NULL,0,0,'2021-06-29 11:52:49','2021-06-29 11:52:49'),(121,1,12,'simone.magliano@libero.it','Vaacaghenavota','Simone','Magliano','Simo',NULL,NULL,NULL,NULL,0,0,'2021-06-29 11:57:51','2021-06-29 11:57:51'),(122,2,12,'simo.magliano@gmail.com','Vaacaghenavota','Simone','Magliano','Simo','MGLSMN85S19A124Q','3393509353','Via Pomaro, 6','simo.magliano@legalmail.it',0,0,'2021-06-29 14:01:00','2021-06-29 14:01:00'),(123,2,12,'simone.magliano@libero.it','Scorpion1985','Simone','Magliano','Simo',NULL,NULL,NULL,NULL,0,0,'2021-06-29 14:27:30','2021-06-29 14:27:30'),(124,1,12,'simone.magliano@libero.it','Scorpion1985','Simone','Magliano','Simo',NULL,NULL,NULL,NULL,0,0,'2021-06-29 16:15:01','2021-06-29 16:15:01'),(126,1,13,'simo.magliano@gmail.com','Vaacaghenavota','Simone','Magliano','qwerty',NULL,NULL,NULL,NULL,0,0,'2021-06-29 16:55:38','2021-06-29 16:55:38'),(127,1,12,'simone.magliano@libero.it','Scorpion1985','Simone','Magliano','qwerty','MGLSMN85S19A124Q','3393509353','Via Pomaro, 6','simo.magliano@legalmail.it',0,0,'2021-06-30 16:24:07','2021-06-30 16:24:07'),(128,1,12,'simone.magliano@libero.it','Scorpion1985','Simone','Magliano','Simo',NULL,NULL,NULL,NULL,0,0,'2021-07-06 14:52:02','2021-07-06 14:52:02');
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-10  9:16:11
