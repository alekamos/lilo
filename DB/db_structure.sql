-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: Ott 16, 2015 alle 13:33
-- Versione del server: 5.6.12-log
-- Versione PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: 'a1db'
--
CREATE DATABASE IF NOT EXISTS a1db DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE a1db;

-- --------------------------------------------------------

--
-- Struttura della tabella 'calendar'
--

DROP TABLE IF EXISTS calendar;
CREATE TABLE IF NOT EXISTS calendar (
  `DATE` date NOT NULL,
  DAY_OF_WEEK varchar(2) DEFAULT NULL COMMENT '{SU,MO,TU,WE,TH.FR,SA}',
  PRIMARY KEY (`DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA DI UTILITY DI CALENDARIO';

-- --------------------------------------------------------

--
-- Struttura della tabella 'list_elements'
--

DROP TABLE IF EXISTS list_elements;
CREATE TABLE IF NOT EXISTS list_elements (
  ID_ELEMENT int(11) NOT NULL AUTO_INCREMENT,
  ID_USER int(11) DEFAULT NULL,
  `TYPE` varchar(100) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  DESCRIPTION varchar(100) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  PRIMARY KEY (ID_ELEMENT),
  KEY ID_USER_FK (ID_USER)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE CONTIENE GLI ID DEI CONTENUTI LISTA DEI MODULI';

-- --------------------------------------------------------

--
-- Struttura della tabella 'modules_cluster'
--

DROP TABLE IF EXISTS modules_cluster;
CREATE TABLE IF NOT EXISTS modules_cluster (
  ID_MODULE_CLUSTER int(11) NOT NULL,
  ID_USER int(11) DEFAULT NULL,
  ID_MODULE_TYPE int(11) DEFAULT NULL,
  ID_MODULE int(11) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  KEY FK_ID_USER_IDX (ID_USER),
  KEY FK_ID_MODULE_TYPE_IDX (ID_MODULE_TYPE),
  KEY FK_ID_MODULE_IDX (ID_MODULE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE RAGGRUPPA I MODULI';

-- --------------------------------------------------------

--
-- Struttura della tabella 'modules_datetime'
--

DROP TABLE IF EXISTS modules_datetime;
CREATE TABLE IF NOT EXISTS modules_datetime (
  ID_MODULE int(11) DEFAULT NULL,
  DATETIME_1_VALUE datetime DEFAULT NULL,
  DATETIME_2_VALUE datetime DEFAULT NULL,
  DATETIME_3_VALUE datetime DEFAULT NULL,
  KEY MODA_ID_MODULE_FK_IDX (ID_MODULE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE RAGGRUPPA I MODULI';

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste 'modules_dayhost'
--
DROP VIEW IF EXISTS `modules_dayhost`;
CREATE TABLE IF NOT EXISTS `modules_dayhost` (
`ID_MODULE_CLUSTER` int(11)
,`ID_MODULE` int(11)
,`ID_MODULE_TYPE` int(11)
,`ID_USER` int(11)
,`DATE_DAYHOST` date
);
-- --------------------------------------------------------

--
-- Struttura della tabella 'modules_header'
--

DROP TABLE IF EXISTS modules_header;
CREATE TABLE IF NOT EXISTS modules_header (
  ID_MODULE int(11) NOT NULL AUTO_INCREMENT,
  ID_MODULE_TYPE int(11) DEFAULT NULL,
  ID_USER int(11) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  PRIMARY KEY (ID_MODULE),
  KEY FK_ID_MODULE_TYPE_IDX (ID_MODULE_TYPE),
  KEY ID_USER (ID_USER)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='LA TABELLA CONTIENE I MODULI, QUI VANNO GLI ID LEGATI ALLE A';

-- --------------------------------------------------------

--
-- Struttura della tabella 'modules_list'
--

DROP TABLE IF EXISTS modules_list;
CREATE TABLE IF NOT EXISTS modules_list (
  ID_MODULE int(11) DEFAULT NULL,
  ID_ELEMENT int(11) DEFAULT NULL,
  ID_LIST_CONTENT int(11) NOT NULL COMMENT 'E'' specificato per legarsi alla tabella type, se corrisponde al List_content_1, 2 o 3',
  KEY ID_MODULE (ID_MODULE),
  KEY FK_ID_ELEMENT (ID_ELEMENT)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE CONTIENE GLI ELEMENTI DI UNA LISTA';

-- --------------------------------------------------------

--
-- Struttura della tabella 'modules_numeric_data'
--

DROP TABLE IF EXISTS modules_numeric_data;
CREATE TABLE IF NOT EXISTS modules_numeric_data (
  ID_MODULE int(11) DEFAULT NULL,
  NUMERIC_DATA_1_VALUE double DEFAULT NULL,
  NUMERIC_DATA_2_VALUE double DEFAULT NULL,
  NUMERIC_DATA_3_VALUE double DEFAULT NULL,
  KEY MODU_ID_MODULE_FK_IDX (ID_MODULE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA SALVA I DATI NUMERICI DEI MODULI';

-- --------------------------------------------------------

--
-- Struttura della tabella 'modules_text'
--

DROP TABLE IF EXISTS modules_text;
CREATE TABLE IF NOT EXISTS modules_text (
  ID_MODULE int(11) DEFAULT NULL,
  TEXT_1_VALUE text,
  TEXT_2_VALUE varchar(100) DEFAULT NULL,
  TEXT_3_VALUE varchar(100) DEFAULT NULL,
  KEY MOTE_ID_MODULE_FK_IDX (ID_MODULE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE RAGGRUPPA I MODULI';

-- --------------------------------------------------------

--
-- Struttura della tabella 'modules_types'
--

DROP TABLE IF EXISTS modules_types;
CREATE TABLE IF NOT EXISTS modules_types (
  ID_MODULE_TYPE int(11) NOT NULL AUTO_INCREMENT,
  ID_USER int(11) DEFAULT NULL,
  `NAME` varchar(60) DEFAULT NULL,
  DESCRIPTION varchar(500) DEFAULT NULL,
  TEXT_CONTENT_1_NAME varchar(45) DEFAULT NULL,
  TEXT_CONTENT_2_NAME varchar(45) DEFAULT NULL,
  TEXT_CONTENT_3_NAME varchar(45) DEFAULT NULL,
  LIST_CONTENT_1_NAME varchar(45) DEFAULT NULL,
  LIST_CONTENT_1_TYPE varchar(45) DEFAULT NULL,
  LIST_CONTENT_2_NAME varchar(45) DEFAULT NULL,
  LIST_CONTENT_2_TYPE varchar(45) DEFAULT NULL,
  LIST_CONTENT_3_NAME varchar(45) DEFAULT NULL,
  LIST_CONTENT_3_TYPE varchar(45) DEFAULT NULL,
  NUMERIC_DATA_CONTENT_1_NAME varchar(45) DEFAULT NULL,
  NUMERIC_DATA_CONTENT_1_TYPE varchar(45) DEFAULT NULL,
  NUMERIC_DATA_CONTENT_2_NAME varchar(45) DEFAULT NULL,
  NUMERIC_DATA_CONTENT_2_TYPE varchar(45) DEFAULT NULL,
  NUMERIC_DATA_CONTENT_3_NAME varchar(45) DEFAULT NULL,
  NUMERIC_DATA_CONTENT_3_TYPE varchar(45) DEFAULT NULL,
  DATETIME_CONTENT_1_NAME varchar(45) DEFAULT NULL,
  DATETIME_CONTENT_1_TYPE varchar(45) DEFAULT NULL,
  DATETIME_CONTENT_2_NAME varchar(45) DEFAULT NULL,
  DATETIME_CONTENT_2_TYPE varchar(45) DEFAULT NULL,
  DATETIME_CONTENT_3_NAME varchar(45) DEFAULT NULL,
  DATETIME_CONTENT_3_TYPE varchar(45) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  PRIMARY KEY (ID_MODULE_TYPE),
  KEY FK_ID_USER_IDX (ID_USER)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE DEFINISCE I MODULI.';

-- --------------------------------------------------------

--
-- Struttura della tabella 'module_type_settings'
--

DROP TABLE IF EXISTS module_type_settings;
CREATE TABLE IF NOT EXISTS module_type_settings (
  ID_MODULE_TYPE int(11) NOT NULL,
  ID_USER int(11) NOT NULL,
  ID_PROPERTY int(11) DEFAULT NULL,
  `VALUE` varchar(100) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  KEY MOPR_ID_USER_FK_IDX (ID_USER),
  KEY MOPR_ID_MODULE_FK_IDX (ID_MODULE_TYPE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE RAGGRUPPA I MODULI';

-- --------------------------------------------------------

--
-- Struttura della tabella 'properties'
--

DROP TABLE IF EXISTS properties;
CREATE TABLE IF NOT EXISTS properties (
  ID_PROPERTY int(11) NOT NULL AUTO_INCREMENT,
  NAME_PROPERTY varchar(100) DEFAULT NULL,
  DESCR_PROPERTY text,
  AVAILABLE_VALUES varchar(100) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  PRIMARY KEY (ID_PROPERTY)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella 'users'
--

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
  ID_USER int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  SURNAME varchar(50) DEFAULT NULL,
  EMAIL varchar(70) DEFAULT NULL,
  BIRTH_DATE date DEFAULT NULL,
  USERNAME varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  PRIMARY KEY (ID_USER),
  UNIQUE KEY EMAIL_UNIQUE (EMAIL),
  UNIQUE KEY USERNAME_UNIQUE (USERNAME)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='TABELLA CHE CONTIENE LE IMPOSTAZIONI DEGLI UTENTI.';

-- --------------------------------------------------------

--
-- Struttura della tabella 'user_settings'
--

DROP TABLE IF EXISTS user_settings;
CREATE TABLE IF NOT EXISTS user_settings (
  ID_USER int(11) NOT NULL,
  ID_PROPERTY int(11) DEFAULT NULL,
  `VALUE` varchar(200) DEFAULT NULL,
  INSERT_TIMESTAMP timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIMESTAMP timestamp NULL DEFAULT NULL,
  PRIMARY KEY (ID_USER),
  UNIQUE KEY ID_PROPERTY_UNIQUE (ID_PROPERTY)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura per la vista 'modules_dayhost'
--
DROP TABLE IF EXISTS `modules_dayhost`;

CREATE ALGORITHM=UNDEFINED DEFINER=root@localhost SQL SECURITY DEFINER VIEW modules_dayhost AS select mc.ID_MODULE_CLUSTER AS ID_MODULE_CLUSTER,mc.ID_MODULE AS ID_MODULE,mc.ID_MODULE_TYPE AS ID_MODULE_TYPE,mc.ID_USER AS ID_USER,cast(md.DATETIME_1_VALUE as date) AS DATE_DAYHOST from (modules_cluster mc join modules_datetime md) where ((mc.ID_MODULE = md.ID_MODULE) and (mc.ID_MODULE_TYPE = 7));

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella list_elements
--
ALTER TABLE list_elements
  ADD CONSTRAINT LIST_ELEMENTS_IBFK_1 FOREIGN KEY (ID_USER) REFERENCES `users` (ID_USER) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella modules_cluster
--
ALTER TABLE modules_cluster
  ADD CONSTRAINT FK_ID_MODULE_MODULES_CLUSTER FOREIGN KEY (ID_MODULE) REFERENCES modules_header (ID_MODULE) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT FK_ID_MODULE_TYPE_MODULES_CLUSTER FOREIGN KEY (ID_MODULE_TYPE) REFERENCES modules_types (ID_MODULE_TYPE) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT FK_ID_USER_MODULES_CLUSTER FOREIGN KEY (ID_USER) REFERENCES `users` (ID_USER) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella modules_datetime
--
ALTER TABLE modules_datetime
  ADD CONSTRAINT MODA_ID_MODULE_FK FOREIGN KEY (ID_MODULE) REFERENCES modules_header (ID_MODULE) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella modules_header
--
ALTER TABLE modules_header
  ADD CONSTRAINT MOHE_ID_MODULE_TYPE FOREIGN KEY (ID_USER) REFERENCES `users` (ID_USER) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT MOHE_ID_MODULE_TYPE_FK FOREIGN KEY (ID_MODULE_TYPE) REFERENCES modules_types (ID_MODULE_TYPE) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella modules_list
--
ALTER TABLE modules_list
  ADD CONSTRAINT MODULES_LIST_IBFK_1 FOREIGN KEY (ID_MODULE) REFERENCES modules_header (ID_MODULE) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella modules_numeric_data
--
ALTER TABLE modules_numeric_data
  ADD CONSTRAINT MODU_ID_MODULE_FK FOREIGN KEY (ID_MODULE) REFERENCES modules_header (ID_MODULE) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella modules_text
--
ALTER TABLE modules_text
  ADD CONSTRAINT MOTE_ID_MODULE_FK FOREIGN KEY (ID_MODULE) REFERENCES modules_header (ID_MODULE) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella modules_types
--
ALTER TABLE modules_types
  ADD CONSTRAINT FK_ID_USER_MODULES_TYPES FOREIGN KEY (ID_USER) REFERENCES `users` (ID_USER) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella module_type_settings
--
ALTER TABLE module_type_settings
  ADD CONSTRAINT MOPR_ID_MODULE_FK FOREIGN KEY (ID_MODULE_TYPE) REFERENCES modules_types (ID_MODULE_TYPE) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT MOPR_ID_USER_FK FOREIGN KEY (ID_USER) REFERENCES `users` (ID_USER) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella user_settings
--
ALTER TABLE user_settings
  ADD CONSTRAINT FK_ID_PROPERTY FOREIGN KEY (ID_PROPERTY) REFERENCES properties (ID_PROPERTY) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT FK_ID_USERS_USER_SETTINGS FOREIGN KEY (ID_USER) REFERENCES `users` (ID_USER) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
