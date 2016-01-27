-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.32-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema youi2
--

CREATE DATABASE IF NOT EXISTS youi2;
USE youi2;

--
-- Definition of table `act_ge_bytearray`
--

DROP TABLE IF EXISTS `act_ge_bytearray`;
CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ge_bytearray`
--

/*!40000 ALTER TABLE `act_ge_bytearray` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ge_bytearray` ENABLE KEYS */;


--
-- Definition of table `act_ge_property`
--

DROP TABLE IF EXISTS `act_ge_property`;
CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ge_property`
--

/*!40000 ALTER TABLE `act_ge_property` DISABLE KEYS */;
INSERT INTO `act_ge_property` (`NAME_`,`VALUE_`,`REV_`) VALUES 
 (0x6E6578742E64626964,0x31,1),
 (0x736368656D612E686973746F7279,0x63726561746528352E313329,1),
 (0x736368656D612E76657273696F6E,0x352E3133,1);
/*!40000 ALTER TABLE `act_ge_property` ENABLE KEYS */;


--
-- Definition of table `act_hi_actinst`
--

DROP TABLE IF EXISTS `act_hi_actinst`;
CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_actinst`
--

/*!40000 ALTER TABLE `act_hi_actinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_actinst` ENABLE KEYS */;


--
-- Definition of table `act_hi_attachment`
--

DROP TABLE IF EXISTS `act_hi_attachment`;
CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_attachment`
--

/*!40000 ALTER TABLE `act_hi_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_attachment` ENABLE KEYS */;


--
-- Definition of table `act_hi_comment`
--

DROP TABLE IF EXISTS `act_hi_comment`;
CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_comment`
--

/*!40000 ALTER TABLE `act_hi_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_comment` ENABLE KEYS */;


--
-- Definition of table `act_hi_detail`
--

DROP TABLE IF EXISTS `act_hi_detail`;
CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_detail`
--

/*!40000 ALTER TABLE `act_hi_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_detail` ENABLE KEYS */;


--
-- Definition of table `act_hi_identitylink`
--

DROP TABLE IF EXISTS `act_hi_identitylink`;
CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_identitylink`
--

/*!40000 ALTER TABLE `act_hi_identitylink` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_identitylink` ENABLE KEYS */;


--
-- Definition of table `act_hi_procinst`
--

DROP TABLE IF EXISTS `act_hi_procinst`;
CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  UNIQUE KEY `ACT_UNIQ_HI_BUS_KEY` (`PROC_DEF_ID_`,`BUSINESS_KEY_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_procinst`
--

/*!40000 ALTER TABLE `act_hi_procinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_procinst` ENABLE KEYS */;


--
-- Definition of table `act_hi_taskinst`
--

DROP TABLE IF EXISTS `act_hi_taskinst`;
CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_taskinst`
--

/*!40000 ALTER TABLE `act_hi_taskinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_taskinst` ENABLE KEYS */;


--
-- Definition of table `act_hi_varinst`
--

DROP TABLE IF EXISTS `act_hi_varinst`;
CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_hi_varinst`
--

/*!40000 ALTER TABLE `act_hi_varinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_varinst` ENABLE KEYS */;


--
-- Definition of table `act_id_group`
--

DROP TABLE IF EXISTS `act_id_group`;
CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_id_group`
--

/*!40000 ALTER TABLE `act_id_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_group` ENABLE KEYS */;


--
-- Definition of table `act_id_info`
--

DROP TABLE IF EXISTS `act_id_info`;
CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_id_info`
--

/*!40000 ALTER TABLE `act_id_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_info` ENABLE KEYS */;


--
-- Definition of table `act_id_membership`
--

DROP TABLE IF EXISTS `act_id_membership`;
CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_id_membership`
--

/*!40000 ALTER TABLE `act_id_membership` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_membership` ENABLE KEYS */;


--
-- Definition of table `act_id_user`
--

DROP TABLE IF EXISTS `act_id_user`;
CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_id_user`
--

/*!40000 ALTER TABLE `act_id_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_id_user` ENABLE KEYS */;


--
-- Definition of table `act_re_deployment`
--

DROP TABLE IF EXISTS `act_re_deployment`;
CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOY_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_re_deployment`
--

/*!40000 ALTER TABLE `act_re_deployment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_deployment` ENABLE KEYS */;


--
-- Definition of table `act_re_model`
--

DROP TABLE IF EXISTS `act_re_model`;
CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_re_model`
--

/*!40000 ALTER TABLE `act_re_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_model` ENABLE KEYS */;


--
-- Definition of table `act_re_procdef`
--

DROP TABLE IF EXISTS `act_re_procdef`;
CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_re_procdef`
--

/*!40000 ALTER TABLE `act_re_procdef` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_procdef` ENABLE KEYS */;


--
-- Definition of table `act_ru_event_subscr`
--

DROP TABLE IF EXISTS `act_ru_event_subscr`;
CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ru_event_subscr`
--

/*!40000 ALTER TABLE `act_ru_event_subscr` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_event_subscr` ENABLE KEYS */;


--
-- Definition of table `act_ru_execution`
--

DROP TABLE IF EXISTS `act_ru_execution`;
CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_RU_BUS_KEY` (`PROC_DEF_ID_`,`BUSINESS_KEY_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ru_execution`
--

/*!40000 ALTER TABLE `act_ru_execution` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_execution` ENABLE KEYS */;


--
-- Definition of table `act_ru_identitylink`
--

DROP TABLE IF EXISTS `act_ru_identitylink`;
CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ru_identitylink`
--

/*!40000 ALTER TABLE `act_ru_identitylink` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_identitylink` ENABLE KEYS */;


--
-- Definition of table `act_ru_job`
--

DROP TABLE IF EXISTS `act_ru_job`;
CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ru_job`
--

/*!40000 ALTER TABLE `act_ru_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_job` ENABLE KEYS */;


--
-- Definition of table `act_ru_task`
--

DROP TABLE IF EXISTS `act_ru_task`;
CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DUE_DATE_` datetime DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ru_task`
--

/*!40000 ALTER TABLE `act_ru_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_task` ENABLE KEYS */;


--
-- Definition of table `act_ru_variable`
--

DROP TABLE IF EXISTS `act_ru_variable`;
CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `act_ru_variable`
--

/*!40000 ALTER TABLE `act_ru_variable` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_variable` ENABLE KEYS */;


--
-- Definition of table `youi_agency`
--

DROP TABLE IF EXISTS `youi_agency`;
CREATE TABLE `youi_agency` (
  `AGENCY_ID` varchar(32) NOT NULL,
  `AGENCY_CODE` varchar(20) DEFAULT NULL,
  `AGENCY_CAPTION` varchar(80) DEFAULT NULL,
  `PARENT_AGENCY_ID` varchar(32) DEFAULT NULL,
  `AGENCY_PATH` varchar(512) DEFAULT NULL,
  `LEAF` int(11) DEFAULT NULL,
  PRIMARY KEY (`AGENCY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='910101机构';

--
-- Dumping data for table `youi_agency`
--

/*!40000 ALTER TABLE `youi_agency` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_agency` ENABLE KEYS */;


--
-- Definition of table `youi_bus_adapter`
--

DROP TABLE IF EXISTS `youi_bus_adapter`;
CREATE TABLE `youi_bus_adapter` (
  `ADAPTER_ID` varchar(36) NOT NULL,
  `YOU_ADAPTER_GROUP_ID` varchar(36) DEFAULT NULL,
  `ADAPTER_CAPTION` varchar(80) DEFAULT NULL,
  `ADAPTER_URL` varchar(1024) DEFAULT NULL,
  `ADAPTER_PORT` varchar(20) DEFAULT NULL,
  `ADAPTER_DLURL` varchar(1024) DEFAULT NULL,
  `ADAPTER_NAME` varchar(1024) DEFAULT NULL,
  `ADAPTER_STATUS` int(11) DEFAULT NULL,
  `ADAPTER_GROUP_ID` varchar(36) DEFAULT NULL,
  `ADAPTER_USERNAME` varchar(80) DEFAULT NULL,
  `ADAPTER_PASSWORD` varchar(80) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `CHANNEL_EXPRESSION` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ADAPTER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='960102服务适配器';

--
-- Dumping data for table `youi_bus_adapter`
--

/*!40000 ALTER TABLE `youi_bus_adapter` DISABLE KEYS */;
INSERT INTO `youi_bus_adapter` (`ADAPTER_ID`,`YOU_ADAPTER_GROUP_ID`,`ADAPTER_CAPTION`,`ADAPTER_URL`,`ADAPTER_PORT`,`ADAPTER_DLURL`,`ADAPTER_NAME`,`ADAPTER_STATUS`,`ADAPTER_GROUP_ID`,`ADAPTER_USERNAME`,`ADAPTER_PASSWORD`,`UPDATE_TIME`,`CHANNEL_EXPRESSION`) VALUES 
 ('4028d08150ea9c3c0150eacf625d0002','expression','业务系统001_RMI_9200','127.0.0.1','9200',NULL,'sys001',NULL,NULL,'sys001',NULL,NULL,'\'sys001QmqpAdapter\'');
/*!40000 ALTER TABLE `youi_bus_adapter` ENABLE KEYS */;


--
-- Definition of table `youi_bus_app`
--

DROP TABLE IF EXISTS `youi_bus_app`;
CREATE TABLE `youi_bus_app` (
  `APP_ID` varchar(36) NOT NULL,
  `APP_NAME` varchar(60) DEFAULT NULL,
  `APP_CAPTION` varchar(100) DEFAULT NULL,
  `APP_TYPE` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`APP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='960103应用系统';

--
-- Dumping data for table `youi_bus_app`
--

/*!40000 ALTER TABLE `youi_bus_app` DISABLE KEYS */;
INSERT INTO `youi_bus_app` (`APP_ID`,`APP_NAME`,`APP_CAPTION`,`APP_TYPE`) VALUES 
 ('4028d08150ea9c3c0150eac4d6790001','web001','web001','web'),
 ('4028d08150eb1e3e0150eb6b86670002','web002','web002','web'),
 ('4028d08150eb1e3e0150eb6ba9b00003','web003','web003','web'),
 ('4028d08150eb1e3e0150eb6dc2690008','sys001','sys001','002');
/*!40000 ALTER TABLE `youi_bus_app` ENABLE KEYS */;


--
-- Definition of table `youi_bus_export_port`
--

DROP TABLE IF EXISTS `youi_bus_export_port`;
CREATE TABLE `youi_bus_export_port` (
  `EXPORT_PORT_ID` varchar(36) NOT NULL,
  `PROTOCOL_ID` varchar(20) DEFAULT NULL,
  `PROTOCOL_PORT` varchar(20) DEFAULT NULL,
  `EXPORT_PORT_NAME` varchar(40) DEFAULT NULL,
  `EXPORT_PORT_CAPTION` varchar(80) DEFAULT NULL,
  `EXPORT_PORT_USERNAME` varchar(40) DEFAULT NULL,
  `EXPORT_PORT_PASSWORD` varchar(40) DEFAULT NULL,
  `EXPORT_PORT_MD5` varchar(40) DEFAULT NULL,
  `EXPORT_PORT_STATUS` varchar(3) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `EXPORT_PORT_BDL` text,
  PRIMARY KEY (`EXPORT_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储发布的服务接口';

--
-- Dumping data for table `youi_bus_export_port`
--

/*!40000 ALTER TABLE `youi_bus_export_port` DISABLE KEYS */;
INSERT INTO `youi_bus_export_port` (`EXPORT_PORT_ID`,`PROTOCOL_ID`,`PROTOCOL_PORT`,`EXPORT_PORT_NAME`,`EXPORT_PORT_CAPTION`,`EXPORT_PORT_USERNAME`,`EXPORT_PORT_PASSWORD`,`EXPORT_PORT_MD5`,`EXPORT_PORT_STATUS`,`UPDATE_TIME`,`EXPORT_PORT_BDL`) VALUES 
 ('4028d08150ebae1d0150ebbb98cb0001','rmi','9020','esb001','esb001',NULL,NULL,NULL,NULL,NULL,NULL),
 ('4028d08150ebae1d0150ebbc1a640002','rmi','9021','esb002','esb002',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `youi_bus_export_port` ENABLE KEYS */;


--
-- Definition of table `youi_bus_r_app_service`
--

DROP TABLE IF EXISTS `youi_bus_r_app_service`;
CREATE TABLE `youi_bus_r_app_service` (
  `SERVICE_ID` varchar(36) NOT NULL,
  `APP_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`SERVICE_ID`,`APP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用系统服务权限';

--
-- Dumping data for table `youi_bus_r_app_service`
--

/*!40000 ALTER TABLE `youi_bus_r_app_service` DISABLE KEYS */;
INSERT INTO `youi_bus_r_app_service` (`SERVICE_ID`,`APP_ID`) VALUES 
 ('4028d08150ef79280150ef7f355c0001','4028d08150ea9c3c0150eac4d6790001');
/*!40000 ALTER TABLE `youi_bus_r_app_service` ENABLE KEYS */;


--
-- Definition of table `youi_bus_r_export_service`
--

DROP TABLE IF EXISTS `youi_bus_r_export_service`;
CREATE TABLE `youi_bus_r_export_service` (
  `SERVICE_ID` varchar(36) NOT NULL,
  `EXPORT_PORT_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`SERVICE_ID`,`EXPORT_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口关联服务';

--
-- Dumping data for table `youi_bus_r_export_service`
--

/*!40000 ALTER TABLE `youi_bus_r_export_service` DISABLE KEYS */;
INSERT INTO `youi_bus_r_export_service` (`SERVICE_ID`,`EXPORT_PORT_ID`) VALUES 
 ('4028d08150ea9c3c0150eaddee8f0003','4028d08150ebae1d0150ebbb98cb0001'),
 ('4028d08150ea9c3c0150eaddee8f0003','4028d08150ebae1d0150ebbc1a640002'),
 ('4028d08150ef79280150ef7f355c0001','4028d08150ebae1d0150ebbb98cb0001');
/*!40000 ALTER TABLE `youi_bus_r_export_service` ENABLE KEYS */;


--
-- Definition of table `youi_bus_service`
--

DROP TABLE IF EXISTS `youi_bus_service`;
CREATE TABLE `youi_bus_service` (
  `SERVICE_ID` varchar(36) NOT NULL,
  `ADAPTER_ID` varchar(36) DEFAULT NULL,
  `SERVICE_CAPTION` varchar(80) DEFAULT NULL,
  `SERVICE_INTERFACE` varchar(100) DEFAULT NULL,
  `SERVICE_NAME` varchar(60) DEFAULT NULL,
  `SERVICE_EXPORT_NAME` varchar(60) DEFAULT NULL,
  `SERVICE_CODE` varchar(100) DEFAULT NULL,
  `SERVICE_VERSION` varchar(20) DEFAULT NULL,
  `CREATE_TIME` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `SERVICE_STATUS` int(11) DEFAULT NULL,
  `FOLDER_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`SERVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='960101服务';

--
-- Dumping data for table `youi_bus_service`
--

/*!40000 ALTER TABLE `youi_bus_service` DISABLE KEYS */;
INSERT INTO `youi_bus_service` (`SERVICE_ID`,`ADAPTER_ID`,`SERVICE_CAPTION`,`SERVICE_INTERFACE`,`SERVICE_NAME`,`SERVICE_EXPORT_NAME`,`SERVICE_CODE`,`SERVICE_VERSION`,`CREATE_TIME`,`UPDATE_TIME`,`SERVICE_STATUS`,`FOLDER_ID`) VALUES 
 ('4028d08150ea9c3c0150eaddee8f0003','4028d08150ea9c3c0150eacf625d0002',NULL,'userManager','addUser',NULL,NULL,NULL,NULL,NULL,1,NULL),
 ('4028d08150eb1e3e0150eb239f780001',NULL,NULL,'userManager','getUser',NULL,NULL,NULL,NULL,NULL,0,NULL),
 ('4028d08150ef79280150ef7f355c0001','4028d08150ea9c3c0150eacf625d0002',NULL,'userManager','getPagerUsers',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `youi_bus_service` ENABLE KEYS */;


--
-- Definition of table `youi_code_config_item`
--

DROP TABLE IF EXISTS `youi_code_config_item`;
CREATE TABLE `youi_code_config_item` (
  `ITEM_ID` varchar(36) NOT NULL,
  `PROJECT_ID` varchar(36) DEFAULT NULL,
  `ITEM_NAME` varchar(40) DEFAULT NULL,
  `ITEM_CAPTION` varchar(80) DEFAULT NULL,
  `ITEM_VALUE` varchar(200) DEFAULT NULL,
  `ITEM_TYPE` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `FK_R_90_0101_0106` (`PROJECT_ID`),
  CONSTRAINT `FK_R_90_0101_0106` FOREIGN KEY (`PROJECT_ID`) REFERENCES `youi_code_project` (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900106开发配置项';

--
-- Dumping data for table `youi_code_config_item`
--

/*!40000 ALTER TABLE `youi_code_config_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_code_config_item` ENABLE KEYS */;


--
-- Definition of table `youi_code_file`
--

DROP TABLE IF EXISTS `youi_code_file`;
CREATE TABLE `youi_code_file` (
  `CODE_FILE_ID` varchar(36) NOT NULL,
  `ENTITY_ID` varchar(36) DEFAULT NULL,
  `CODE_FILE_NAME` varchar(40) DEFAULT NULL,
  `CODE_FILE_CONTENT` text,
  PRIMARY KEY (`CODE_FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900104代码文件';

--
-- Dumping data for table `youi_code_file`
--

/*!40000 ALTER TABLE `youi_code_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_code_file` ENABLE KEYS */;


--
-- Definition of table `youi_code_module`
--

DROP TABLE IF EXISTS `youi_code_module`;
CREATE TABLE `youi_code_module` (
  `MODULE_ID` varchar(36) NOT NULL,
  `PROJECT_ID` varchar(36) DEFAULT NULL,
  `MODULE_CODE` varchar(20) DEFAULT NULL,
  `MODULE_NAME` varchar(40) DEFAULT NULL,
  `MODULE_CAPTION` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900103代码模块';

--
-- Dumping data for table `youi_code_module`
--

/*!40000 ALTER TABLE `youi_code_module` DISABLE KEYS */;
INSERT INTO `youi_code_module` (`MODULE_ID`,`PROJECT_ID`,`MODULE_CODE`,`MODULE_NAME`,`MODULE_CAPTION`) VALUES 
 ('1',NULL,'1','1',NULL),
 ('4028d0815095936f0150959e1c190006','4028d0815095936f0150959caff90005',NULL,'employee','员工管理'),
 ('4028d0815095936f0150959e1c190007','4028d0815095936f0150959caff90005',NULL,'organize','组织管理'),
 ('4028d0815098dc35015098f3bb5c0001','4028d08150898257015089842d9c0001',NULL,'codemng','代码管理'),
 ('4028d0815098dc35015098f3bb660002','4028d08150898257015089842d9c0001',NULL,'codepdm','模型管理'),
 ('4028d08150a4a0330150a4b075eb002f','4028d08150a4a0330150a4a5860d0001',NULL,'rptqry','08通用查询'),
 ('4028d08150a4a0330150a4b075f70033','4028d08150a4a0330150a4a5860d0001',NULL,'rptcfg','01报表配置'),
 ('4028d08150a4a0330150a4b075ff0036','4028d08150a4a0330150a4a5860d0001',NULL,'rptmng','02报表管理'),
 ('4028d08150a4a0330150a4b0760a0039','4028d08150a4a0330150a4a5860d0001',NULL,'rptsecurity','03报表安全'),
 ('4028d08150faf7e80150fafc197c0002','4028d08150faf7e80150fafa423b0001',NULL,'rmbimp','冠字号数据入库'),
 ('4028d08150faf7e80150fafc197d0003','4028d08150faf7e80150fafa423b0001',NULL,'rmbquery','冠字号查询'),
 ('4028d08152535c39015253c7309e0002','2016000020',NULL,'member',NULL),
 ('4028d08152535c39015253c7309e0003','2016000020',NULL,'account',NULL);
/*!40000 ALTER TABLE `youi_code_module` ENABLE KEYS */;


--
-- Definition of table `youi_code_module_web`
--

DROP TABLE IF EXISTS `youi_code_module_web`;
CREATE TABLE `youi_code_module_web` (
  `WEB_MODULE_ID` varchar(36) NOT NULL,
  `PROJECT_ID` varchar(36) DEFAULT NULL,
  `WEB_MODULE_NAME` varchar(20) DEFAULT NULL,
  `WEB_MODULE_CAPTION` varchar(80) DEFAULT NULL,
  `WEB_MODULE_CODE` varchar(20) DEFAULT NULL,
  `WEB_PORT` varchar(20) DEFAULT NULL,
  `WEB_MODULE_TYPE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`WEB_MODULE_ID`),
  KEY `FK_YOUI_COD_R_90_0101_YOUI_CO2` (`PROJECT_ID`),
  CONSTRAINT `FK_YOUI_COD_R_90_0101_YOUI_CO2` FOREIGN KEY (`PROJECT_ID`) REFERENCES `youi_code_project` (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='war项目';

--
-- Dumping data for table `youi_code_module_web`
--

/*!40000 ALTER TABLE `youi_code_module_web` DISABLE KEYS */;
INSERT INTO `youi_code_module_web` (`WEB_MODULE_ID`,`PROJECT_ID`,`WEB_MODULE_NAME`,`WEB_MODULE_CAPTION`,`WEB_MODULE_CODE`,`WEB_PORT`,`WEB_MODULE_TYPE`) VALUES 
 ('4028d0815092fa30015092fe58700004','4028d08150898257015089842d9c0001','web',NULL,NULL,NULL,NULL),
 ('4028d0815092fa30015092fe58700005','4028d08150898257015089842d9c0001','server-code',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `youi_code_module_web` ENABLE KEYS */;


--
-- Definition of table `youi_code_project`
--

DROP TABLE IF EXISTS `youi_code_project`;
CREATE TABLE `youi_code_project` (
  `PROJECT_ID` varchar(36) NOT NULL,
  `PROJECT_GROUP_ID` varchar(36) DEFAULT NULL,
  `PROJECT_CODE_NAME` varchar(40) DEFAULT NULL,
  `PROJECT_CAPTION` varchar(80) DEFAULT NULL,
  `PROJECT_CODE` varchar(20) DEFAULT NULL,
  `PROJECT_DETAILS` text,
  `SVN_URL` varchar(255) DEFAULT NULL,
  `SRC_BASE_PACKAGE` varchar(255) DEFAULT NULL,
  `PROJECT_TYPE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`PROJECT_ID`),
  KEY `FK_R_90_0105_0101` (`PROJECT_GROUP_ID`),
  KEY `FKDCBABC9C68BEDF39` (`PROJECT_GROUP_ID`),
  CONSTRAINT `FKDCBABC9C68BEDF39` FOREIGN KEY (`PROJECT_GROUP_ID`) REFERENCES `youi_code_project_group` (`PROJECT_GROUP_ID`),
  CONSTRAINT `FK_R_90_0105_0101` FOREIGN KEY (`PROJECT_GROUP_ID`) REFERENCES `youi_code_project_group` (`PROJECT_GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900101项目';

--
-- Dumping data for table `youi_code_project`
--

/*!40000 ALTER TABLE `youi_code_project` DISABLE KEYS */;
INSERT INTO `youi_code_project` (`PROJECT_ID`,`PROJECT_GROUP_ID`,`PROJECT_CODE_NAME`,`PROJECT_CAPTION`,`PROJECT_CODE`,`PROJECT_DETAILS`,`SVN_URL`,`SRC_BASE_PACKAGE`,`PROJECT_TYPE`) VALUES 
 ('2015000001',NULL,'gsoft-enterprise','企业平台',NULL,'企业平台',NULL,'com.gsoft.enterprise','default'),
 ('2015000003',NULL,'gsoft-report','报表管理平台',NULL,'报表管理平台',NULL,'com.gsoft.report','default'),
 ('2015000004',NULL,'psbc-rmbdc','冠字号项目',NULL,NULL,NULL,'com.gsoft.psbc','esb'),
 ('2015000019',NULL,'gsoft-jobs',NULL,NULL,NULL,NULL,NULL,NULL),
 ('2016000020',NULL,'gsoft-vtui','捧场平台',NULL,NULL,NULL,'com.gsoft.vtui',NULL),
 ('4028d08150898257015089842d9c0001',NULL,'gsoft-platform','代码项目管理系统','P000001','代码项目管理系统',NULL,'com.gsoft.platform','default');
/*!40000 ALTER TABLE `youi_code_project` ENABLE KEYS */;


--
-- Definition of table `youi_code_project_group`
--

DROP TABLE IF EXISTS `youi_code_project_group`;
CREATE TABLE `youi_code_project_group` (
  `PROJECT_GROUP_ID` varchar(36) NOT NULL,
  `PROJECT_GROUP_CAPTION` varchar(80) DEFAULT NULL,
  `PARENT_GROUP_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`PROJECT_GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='树形结构的文件夹';

--
-- Dumping data for table `youi_code_project_group`
--

/*!40000 ALTER TABLE `youi_code_project_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_code_project_group` ENABLE KEYS */;


--
-- Definition of table `youi_codeitem`
--

DROP TABLE IF EXISTS `youi_codeitem`;
CREATE TABLE `youi_codeitem` (
  `ITEM_ID` varchar(36) NOT NULL,
  `CODEMAP_ID` varchar(36) DEFAULT NULL,
  `ITEM_VALUE` varchar(512) DEFAULT NULL,
  `ITEM_CAPTION` varchar(80) DEFAULT NULL,
  `ITEM_GROUP` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `FK_R99_0101_0102` (`CODEMAP_ID`),
  KEY `FK649872F57A013BE8` (`CODEMAP_ID`),
  CONSTRAINT `FK649872F57A013BE8` FOREIGN KEY (`CODEMAP_ID`) REFERENCES `youi_codemap` (`CODEMAP_ID`),
  CONSTRAINT `FK_R99_0101_0102` FOREIGN KEY (`CODEMAP_ID`) REFERENCES `youi_codemap` (`CODEMAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='990102代码项';

--
-- Dumping data for table `youi_codeitem`
--

/*!40000 ALTER TABLE `youi_codeitem` DISABLE KEYS */;
INSERT INTO `youi_codeitem` (`ITEM_ID`,`CODEMAP_ID`,`ITEM_VALUE`,`ITEM_CAPTION`,`ITEM_GROUP`) VALUES 
 ('2c9dc604391da4c701391dab23d70002','2c9dc604391da4c701391daaedc80001','1','代码集',NULL),
 ('2c9dc604391da4c701391dab42bd0003','2c9dc604391da4c701391daaedc80001','2','SQL代码集',NULL),
 ('4028d0815094e93f01509526a09c0011','4028d0815094e93f01509519de3e0010','default','普通项目',NULL),
 ('4028d0815094e93f01509526ce0a0012','4028d0815094e93f01509519de3e0010','esb','esb项目',NULL),
 ('4028d0815094e93f015095270f7b0013','4028d0815094e93f01509519de3e0010','esbsso','带SSO的ESB项目',NULL),
 ('4028d08150a1df4a0150a20a29e50008','4028d08150a1df4a0150a208fc1c0007','esbssoweb','集成SSO的WEB项目',NULL),
 ('4028d08150a1df4a0150a20afe3a0009','4028d08150a1df4a0150a208fc1c0007','esbserver','esb业务系统',NULL),
 ('4028d08150f3d9900150f4090b200002','4028d08150f3d9900150f408a1a70001','expression','表达式',NULL),
 ('4028d08150f3d9900150f40942cf0003','4028d08150f3d9900150f408a1a70001','rmi','rmi适配器',NULL),
 ('4028d08150f3d9900150f4097bd10004','4028d08150f3d9900150f408a1a70001','amqp','amqp适配器',NULL),
 ('4028d08150f3d9900150f409cf930005','4028d08150f3d9900150f408a1a70001','ws','webservice适配器',NULL),
 ('4028d08151f126740151f1851ade0002','4028d08151f126740151f184dbe80001','1','男',NULL),
 ('4028d08151f126740151f18533f10003','4028d08151f126740151f184dbe80001','2','女',NULL);
/*!40000 ALTER TABLE `youi_codeitem` ENABLE KEYS */;


--
-- Definition of table `youi_codemap`
--

DROP TABLE IF EXISTS `youi_codemap`;
CREATE TABLE `youi_codemap` (
  `CODEMAP_ID` varchar(36) NOT NULL,
  `CODE` varchar(40) DEFAULT NULL,
  `CAPTION` varchar(80) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `EXPRESSION` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`CODEMAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='990101代码集';

--
-- Dumping data for table `youi_codemap`
--

/*!40000 ALTER TABLE `youi_codemap` DISABLE KEYS */;
INSERT INTO `youi_codemap` (`CODEMAP_ID`,`CODE`,`CAPTION`,`TYPE`,`EXPRESSION`) VALUES 
 ('2c9dc604391da4c701391daaedc80001','codemapType','代码集类型','1',''),
 ('4028d0815094e93f01509519de3e0010','codeProjectType','项目类型','1',NULL),
 ('4028d08150a1df4a0150a208fc1c0007','moduleWebType','war模块类型','1',NULL),
 ('4028d08150f3d9900150f408a1a70001','adapterGroup','适配器类型','1',NULL),
 ('4028d08151f126740151f184dbe80001','sex','性别','1',NULL);
/*!40000 ALTER TABLE `youi_codemap` ENABLE KEYS */;


--
-- Definition of table `youi_file_store`
--

DROP TABLE IF EXISTS `youi_file_store`;
CREATE TABLE `youi_file_store` (
  `FILE_STORE_ID` varchar(32) NOT NULL,
  `FILE_STORE_PATH` varchar(800) DEFAULT NULL,
  `FILE_STORE_NAME` varchar(512) DEFAULT NULL,
  `FILE_SIZE` bigint(20) DEFAULT NULL,
  `FILE_STORE_STATUS` char(1) DEFAULT NULL COMMENT '0：未使用\r\n            1：已经使用',
  `TIME_STAMP` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`FILE_STORE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件索引';

--
-- Dumping data for table `youi_file_store`
--

/*!40000 ALTER TABLE `youi_file_store` DISABLE KEYS */;
INSERT INTO `youi_file_store` (`FILE_STORE_ID`,`FILE_STORE_PATH`,`FILE_STORE_NAME`,`FILE_SIZE`,`FILE_STORE_STATUS`,`TIME_STAMP`) VALUES 
 ('4028d0814e48dd20014e48e308a90002','201507\\542b59de-97aa-4ad9-8e21-00fe3c3c8f63.jpg','Windows8系统图标PSD素材.jpg',11,'1','20150701171155'),
 ('4028d0814e48ec4d014e48ec92150001','201507\\ed373dc9-706e-4788-9ee0-fe2a9792217a.jpg','Windows8系统图标PSD素材.jpg',NULL,'1','20150701172220'),
 ('4028d0814e48ec4d014e48ed098b0002','201507\\6e5e78c9-94b3-4943-b17e-1a5dc1a08d95.psd','Windows8系统图标PSD素材.psd',NULL,'1','20150701172240'),
 ('4028d0814e48ec4d014e48ee048e0003','201507\\30df59a8-57f5-4a68-a973-e2d731feb9aa.psd','Windows8系统图标PSD素材.psd',1511958,'1','20150701172355'),
 ('4028d0814e48ec4d014e48f18f420004','201507\\b3fd1a77-67e6-4edb-8f44-db4aac0ddcda.jpg','Windows8系统图标PSD素材.jpg',69437,'1','20150701172747'),
 ('4028d0814e48ec4d014e48f9d38d0005','201507\\43203b32-ea42-44a6-a02b-40776f8315cd.jpg','Windows8系统图标PSD素材.jpg',69437,'1','20150701173649'),
 ('4028d0814e48ec4d014e490c4e990006','201507\\5f980d18-1f59-495d-9938-b422b8fb904c.jpg','Windows8系统图标PSD素材.jpg',69437,'1','20150701175700'),
 ('4028d0814e48ec4d014e490c6de10007','201507\\ca191d11-a53d-4318-a015-03867c1f78b7.jpg','landscape.jpg',97258,'1','20150701175708'),
 ('4028d0814e48ec4d014e490f02520008','201507\\325a5764-7d64-4286-8b4f-b2c7b89e64a9.jpg','landscape.jpg',97258,'1','20150701175957'),
 ('4028d0814e4cc9df014e4d618bc20001','201507\\1a35c5e6-c377-4e80-b270-31f64bb9cb00.jpg','landscape.jpg',NULL,'1','20150702140835'),
 ('4028d0814e67124c014e6713d54e0001','201507\\a8f253ca-a941-4dfa-bb77-5838ceb0c58b.pom','ojdbc-6.pom',0,'1','20150707135349'),
 ('4028d0814e67124c014e671437290002','201507\\20a83927-5c33-4927-a9c4-64d4e1adb310.jar','ojdbc-6.jar',NULL,'1','20150707135414'),
 ('4028d0814e67124c014e67149dfb0003','201507\\2177cc3d-bbfb-4dae-84a3-c6688a45c0c6.xml','settings.xml',NULL,'1','20150707135441'),
 ('4028d0814e67124c014e671da0200004','201507\\808cb97c-7038-4f8d-ad35-f35ec64ce13d.rar','mvnrepo.rar',NULL,'1','20150707140431'),
 ('4028d0814e6c3b20014e6c3b99010001','201507\\bfcd1f2b-2e94-4709-8acc-a30473b90128.xml','settings.xml',NULL,'1','20150708135521'),
 ('4028d0815088028101508808692c0002','201510\\e69cd693-3bcd-4ddb-a8de-86dea8528e54.java','FireImpl.java',1293,'1','20151021093424'),
 ('4028d081508802810150880869770003','201510\\565938fe-a572-4f72-b82d-853b7a2a16c6.html','freemindbrowser.html',923,'1','20151021093424'),
 ('4028d081508802810150880869fd0004','201510\\13d2b09c-296f-4898-99ab-b9d7767d880d.pdf','http___v3.bootcss.pdf',1021634,'1','20151021093424'),
 ('4028d08150880281015088086a730005','201510\\dea72c76-ff0a-4b94-b95e-20063555be4f.pdf','http___v3.bootcss_3.pdf',794463,'1','20151021093424'),
 ('4028d0815093626f0150936893940001','201510\\ec18d99c-6f8d-4c13-a4dd-b10a4502a9d7.zip','export.zip',10,'1','20151023143515'),
 ('4028d0815093626f015093693dec0002','201510\\323ab317-86e4-4844-8d29-3a7c374daa7c.zip','export.zip',10,'1','20151023143548'),
 ('4028d081509390190150939973760001','201510\\4abbae96-df6c-4ca8-85eb-a556f8281325.zip','platform.zip',135165,'1','20151023152838'),
 ('4028d081509390190150939d42090002','201510\\2d670c0c-23fe-406e-8a27-fd8cd7656401.zip','platform.zip',135165,'1','20151023153248'),
 ('4028d081509390190150939d7d9f0003','201510\\ee69927c-6303-4ab1-8631-63873aaa530b.zip','platform.zip',135165,'1','20151023153303'),
 ('4028d081509390190150939eec8d0004','201510\\607207bb-050f-4cc4-a3d1-d95e06b29558.zip','platform.zip',135165,'1','20151023153437'),
 ('4028d081509390190150939fde470005','201510\\bf2e1577-36c2-4875-b11e-197e4f898815.zip','platform.zip',135165,'1','20151023153539'),
 ('4028d08150939019015093a15ebf0006','201510\\d1acf6a1-a59c-492b-a240-3e2bed3f801a.zip','platform.zip',135165,'1','20151023153717'),
 ('4028d08150939019015093ab00410007','201510\\68a1a514-22b2-467a-a2d0-b12e57368d17.zip','platform.zip',135165,'1','20151023154748'),
 ('4028d08150939019015093aba8070008','201510\\211a7389-0c61-4a9a-9279-0352836e7e95.zip','platform.zip',135165,'1','20151023154831'),
 ('4028d08150939019015093ac6a750009','201510\\aaec5fcc-c8ea-40c8-ba4b-b72de888839e.zip','platform.zip',135165,'1','20151023154921'),
 ('4028d08150939019015093acbee0000a','201510\\923a9fe2-7c57-43a5-abda-c5f7bab89df6.zip','platform.zip',135165,'1','20151023154943'),
 ('4028d08150939019015093b0b010000b','201510\\07ec860b-22eb-4983-b333-e89c501c4529.zip','platform.zip',135165,'1','20151023155401'),
 ('4028d08150939019015093b2615e000c','201510\\3c6b2160-b66b-43c8-ae2f-4d588ad46191.zip','platform.zip',135165,'1','20151023155552'),
 ('4028d08150939019015093b2e24c000d','201510\\57a8ed16-1d7a-45e4-80a1-66a03a060da9.zip','platform.zip',135165,'1','20151023155625'),
 ('4028d08150939019015093b5a153000e','201510\\8ce83ca3-04db-4417-8c62-21704286d1a8.zip','platform.zip',135165,'1','20151023155925'),
 ('4028d08150939019015093b76436000f','201510\\c75168aa-17a6-46f5-927f-926548ce3b76.zip','platform.zip',135165,'1','20151023160120'),
 ('4028d08150939019015093b8333a0010','201510\\06856f96-a96c-473c-b124-692e5d820b77.zip','platform.zip',135165,'1','20151023160213'),
 ('4028d08150939019015093ba1f560011','201510\\e26c011b-20dd-4bb6-af78-282aeb1326e7.zip','platform.zip',135165,'1','20151023160419'),
 ('4028d0815093bf6a015093bfe1440001','201510\\31508dbc-eeb2-4078-8a0e-c85361e795bd.zip','platform.zip',135165,'1','20151023161037'),
 ('4028d0815093bf6a015093c0d4b00002','201510\\82a78d5f-81b8-4a36-8896-72e2a8e59900.zip','platform.zip',135165,'1','20151023161139'),
 ('4028d0815093bf6a015093c47c480003','201510\\becf3b89-81b1-4fbd-af2d-0f0d3d791296.zip','platform.zip',135165,'1','20151023161539'),
 ('4028d0815093bf6a015093c658770004','201510\\989fd5a2-9cba-4da4-9364-d6c60dbc9eb3.zip','platform.zip',135165,'1','20151023161740'),
 ('4028d0815093bf6a015093c7aacf0005','201510\\dbace5b1-dfaf-45cb-925f-68ea056b919b.zip','gsoft-platform.zip',135196,'1','20151023161907'),
 ('4028d0815093bf6a015093c97f100006','201510\\8c2b7574-ea26-4a1b-b671-2ad38047e4d2.zip','gsoft-platform.zip',135196,'1','20151023162107'),
 ('4028d0815093bf6a015093ca6c9a0007','201510\\b49f004f-cb6f-4259-9c6c-878a675b83f7.zip','gsoft-platform.zip',135196,'1','20151023162208'),
 ('4028d0815093bf6a015093cb224e0008','201510\\e3215d1f-f0b0-4bae-86bf-36cbc90653fa.zip','gsoft-platform.zip',135196,'1','20151023162254'),
 ('4028d0815093bf6a015093cbe2fb0009','201510\\e72932fc-1ab0-44e2-adb5-b69d04a32386.zip','gsoft-platform.zip',135196,'1','20151023162344'),
 ('4028d0815093bf6a015093ccf047000a','201510\\b1a530fd-8761-48bc-90c8-5b623baf2c22.zip','gsoft-platform.zip',135196,'1','20151023162453'),
 ('4028d0815094da99015094db33df0001','201510\\adf92cbf-dec1-4fc9-a302-ba58e4556ad5.zip','gsoft-platform.zip',135196,'1','20151023212005'),
 ('4028d0815094da99015094dcac620002','201510\\3e6f29d1-3f0d-4caa-91d2-eb4d412d854e.zip','gsoft-platform.zip',135196,'1','20151023212141'),
 ('4028d0815094da99015094dcf44e0003','201510\\ef68ac56-adf1-4179-99d6-a1c09ba8ef45.zip','gsoft-platform.zip',135196,'1','20151023212159'),
 ('4028d0815094da99015094de24000004','201510\\2081f3b3-d135-44f3-9ebc-ee5747086bcf.zip','gsoft-platform.zip',135196,'1','20151023212317'),
 ('4028d0815094da99015094dfe1fc0005','201510\\f32b2046-7610-4d0c-90dc-2d0ba1e67e06.zip','gsoft-platform.zip',135196,'1','20151023212511'),
 ('4028d0815094e6c8015094e768e20001','201510\\ea32a58c-a970-46b9-ad7d-c01fbc72f1ef.zip','gsoft-platform.zip',57765,'1','20151023213325'),
 ('4028d0815094e93f015094e9b65f0001','201510\\5b84dcdd-fe2e-4c94-b347-415549ae9b5e.zip','gsoft-platform.zip',56157,'1','20151023213555'),
 ('4028d0815094e93f015094ebdecb0002','201510\\7204d38f-77d1-4237-bd61-497ad53adb5a.zip','gsoft-platform.zip',56157,'1','20151023213817'),
 ('4028d0815094e93f015094ef90f10003','201510\\4f206b67-41aa-4d80-9f74-76c5c8d5e50f.zip','gsoft-platform.zip',56157,'1','20151023214219'),
 ('4028d0815094e93f015094f2a7770004','201510\\04877bc9-d04f-4557-a305-680eae5a49b5.zip','gsoft-platform.zip',56157,'1','20151023214542'),
 ('4028d0815094e93f015094f3c5810005','201510\\15ee2def-51cc-4085-9ad4-f6b683a280e7.zip','gsoft-platform.zip',56157,'1','20151023214655'),
 ('4028d0815094e93f015094f42b340006','201510\\f7755966-ff8a-4663-a4a5-03f5ab81620b.zip','gsoft-platform.zip',56157,'1','20151023214721'),
 ('4028d0815094e93f015094f4c9e50007','201510\\8d7a58d0-a357-45bd-9896-11754dd40a63.zip','gsoft-platform.zip',11836,'1','20151023214801'),
 ('4028d0815094e93f015094f7d8e70008','201510\\9363d1fa-a20d-4fca-ad1b-54453e84f305.zip','gsoft-platform.zip',74531,'1','20151023215122'),
 ('4028d0815094e93f01509509d4260009','201510\\d4ea126f-8dad-4297-9f33-919967cdc733.zip','gsoft-platform.zip',22,'1','20151023221100'),
 ('4028d0815094e93f0150950d05d9000a','201510\\912210ed-eaa9-433b-af0d-d3ebaf8a7646.zip','gsoft-platform.zip',30995,'1','20151023221430'),
 ('4028d0815094e93f0150950e4f50000b','201510\\cd37cd04-d950-4f32-aa6a-cec135c28629.zip','gsoft-platform.zip',30995,'1','20151023221554'),
 ('4028d0815094e93f01509510ed95000c','201510\\5589f22a-6c36-45cf-829a-aaa2abb529d1.zip','gsoft-platform.zip',66017,'1','20151023221846'),
 ('4028d0815094e93f01509513b8bb000d','201510\\79eba7b0-9cce-4880-ab73-3be18fab2b1b.zip','gsoft-platform.zip',65814,'1','20151023222149'),
 ('4028d0815094e93f015095151cf4000e','201510\\4801ec4b-ae5a-489a-a46e-1d98a1a7b8f7.zip','gsoft-platform.zip',65814,'1','20151023222320'),
 ('4028d0815094e93f015095172843000f','201510\\03f714cb-8fab-4295-adc9-738c0b2baa27.zip','gsoft-platform.zip',65814,'1','20151023222534'),
 ('4028d08150952aaf0150952b943c0001','201510\\b4900f8e-5619-47ec-ab6e-f083cdd88e5d.zip','gsoft-platform.zip',30792,'1','20151023224752'),
 ('4028d08150952aaf0150952e1be60002','201510\\fdc91d33-5ad5-4b22-bff9-31edc36d4bf5.zip','gsoft-platform.zip',30792,'1','20151023225038'),
 ('4028d08150952aaf0150952e61340003','201510\\1f24b32e-eefa-4255-852f-d2f80c27d401.zip','gsoft-platform.zip',30792,'1','20151023225056'),
 ('4028d08150952aaf0150953022e90004','201510\\ce66d22d-9aeb-40a2-bb81-963204c073bf.zip','gsoft-platform.zip',30792,'1','20151023225251'),
 ('4028d081509532b8015095333f250001','201510\\7bc61af7-9abf-458c-8e23-9e176214b6fb.zip','gsoft-platform.zip',20777,'1','20151023225615'),
 ('4028d081509532b801509533a5840002','201510\\5f32b65c-6673-40fb-858a-508889f9f7f4.zip','gsoft-platform.zip',65814,'1','20151023225641'),
 ('4028d081509532b801509535377d0003','201510\\370910ac-f96f-4da5-93f0-efb867fd128f.zip','gsoft-platform.zip',65814,'1','20151023225824'),
 ('4028d08150953bdf0150953cca510001','201510\\9cff5584-afca-49e8-bb42-bf1c2824952f.zip','gsoft-platform.zip',55440,'1','20151023230640'),
 ('4028d08150953bdf0150953d75a50002','201510\\0e7c775f-5e4c-400d-9c7b-b3be22cd8ca1.zip','gsoft-platform.zip',65627,'1','20151023230724'),
 ('4028d08150953bdf01509541a7ab0003','201510\\7688d7e6-5586-4d9f-b4ae-b3caaa4e97b0.zip','gsoft-platform.zip',87601,'1','20151023231159'),
 ('4028d081509544e4015095457e930001','201510\\ad8aa303-ced2-4586-a9cf-64ddb347070b.zip','gsoft-platform.zip',86801,'1','20151023231611'),
 ('4028d08150957d5e0150957dc3c40001','201510\\85db37df-a498-46f9-bd00-09b819838e3c.zip','gsoft-platform.zip',23160,'1','20151024001738'),
 ('4028d08150957d5e0150957f8c210002','201510\\8d8ec1c4-3d2a-42db-b9f5-665432a31b4f.zip','gsoft-platform.zip',75061,'1','20151024001935'),
 ('4028d0815095936f01509593e81b0001','201510\\8a13d67b-cc95-43bb-bfb1-db81c6122b08.zip','gsoft-platform.zip',78430,'1','20151024004149'),
 ('4028d0815095936f0150959808ad0002','201510\\f666cac8-2044-4ca0-a74c-016d3bea719a.zip','gsoft-platform.zip',63583,'1','20151024004620'),
 ('4028d0815095936f01509598e37a0003','201510\\f2f77131-2450-4f3c-b859-c5b2bfe5d76c.zip','gsoft-platform.zip',63583,'1','20151024004716'),
 ('4028d0815095936f0150959e45830008','201510\\27ea00c7-cbc1-4bc6-97a9-dbeef488d843.zip','gsoft-enterprise .zip',78750,'1','20151024005309'),
 ('4028d0815095936f0150959eb3890009','201510\\fa4e374a-5f30-44df-aadb-09bc09825818.zip','gsoft-enterprise.zip',78740,'1','20151024005337'),
 ('4028d0815095936f015095a4fa5f000a','201510\\d74a0220-f75e-4de8-9a36-54e44f9bd6cd.zip','gsoft-enterprise.zip',78740,'1','20151024010028'),
 ('4028d0815095936f015095a571a8000b','201510\\aeeb43e7-491c-4b2f-b456-ac770918a9a7.zip','gsoft-enterprise.zip',78740,'1','20151024010059'),
 ('4028d0815095936f015095a68a57000c','201510\\b16ede29-b5d5-4e98-92c1-d8320beb3e86.zip','gsoft-enterprise.zip',78740,'1','20151024010211'),
 ('4028d0815095936f015095a751d6000d','201510\\63bc2bbd-1b87-49f6-8d45-ae85f1809693.zip','gsoft-enterprise.zip',78740,'1','20151024010302'),
 ('4028d0815095b839015095b8a6b10001','201510\\9fcd7af8-db95-40a1-9332-e62fdae4dc17.zip','gsoft-enterprise.zip',78738,'1','20151024012157'),
 ('4028d0815095c1e5015095c24a1d0001','201510\\5cacd31f-7982-4287-9c2e-47e64b4e1cfc.zip','gsoft-enterprise.zip',78106,'1','20151024013229'),
 ('4028d0815095c1e5015095c797510002','201510\\0c79599a-4fb0-4d20-9829-f628c7745a5c.zip','gsoft-enterprise.zip',78796,'1','20151024013817'),
 ('4028d0815095ce10015095ce5a090001','201510\\900e71b6-025b-469c-b4cd-679b2dca138b.zip','gsoft-enterprise.zip',79065,'1','20151024014540'),
 ('4028d08150a21f0c0150a302dea50003','201510\\368a2598-1e54-44d2-9531-9ce98b05a1b6.zip','gsoft-platform.zip',78882,'1','20151026151805'),
 ('4028d08150a34d3b0150a37251f40001','201510\\812b471f-3e19-4d12-8c06-c2d1180c7a6e.zip','gsoft-platform.zip',78882,'1','20151026171949'),
 ('4028d08150a34d3b0150a376e3eb0002','201510\\755a213c-2a03-48f7-87a6-89bb978d6553.zip','gsoft-platform.zip',78882,'1','20151026172449'),
 ('4028d08150a34d3b0150a37915900003','201510\\239b9fc8-e474-4b24-88db-6c370f05da2a.zip','gsoft-platform.zip',78882,'1','20151026172713'),
 ('4028d08150a34d3b0150a396f8d70004','201510\\c5b6a0e3-a94d-4489-a71a-4e285992f445.zip','gsoft-enterprise.zip',79065,'1','20151026175951'),
 ('4028d08150a3deb20150a459eedb0001','201510\\cf6d9cec-85d5-4bd3-be78-bbd375cb708f.pdf','http___v3.bootcss.pdf',1021634,'1','20151026213248'),
 ('4028d08150a3deb20150a459f06c0002','201510\\0e456abb-3352-4baa-8690-1c5ad91b0c45.pdf','http___v3.bootcss_3.pdf',794463,'1','20151026213249'),
 ('4028d08150a3deb20150a46436780003','201510\\ae9c24e1-871f-4a72-ba88-60833fdd36d1.pdf','http___v3.bootcss.pdf',1021634,'1','20151026214402'),
 ('4028d08150a3deb20150a46436c40004','201510\\d57500b7-436f-4495-bc30-1687a9a6acb4.pdf','http___v3.bootcss_3.pdf',794463,'1','20151026214402'),
 ('4028d08150a3deb20150a4690c170005','201510\\358ac422-1acd-45d4-ad08-307eed173689.pdm','platform.pdm',354494,'1','20151026214919'),
 ('4028d08150a3deb20150a46a2b6c0006','201510\\0f0b1ca7-9476-4458-9052-43aaf35697a9.pdm','esb.pdm',300046,'1','20151026215032'),
 ('4028d08150a472a70150a47376fd0001','201510\\abc986dd-e202-43dc-be07-ffb805a6c94d.pdm','framework.codemap.pdm',189775,'1','20151026220041'),
 ('4028d08150a472a70150a47738a80002','201510\\1df78239-0531-47ad-9cbc-1e823fcfc6fc.pdm','framework.codemap.pdm',189775,'1','20151026220448'),
 ('4028d08150a4a0330150a4a674380002','201510\\98d59207-fc94-42a4-92fe-000a445b5959.pdm','rpt.pdm',343109,'1','20151026225623'),
 ('4028d08150a4a0330150a4af675a002e','201510\\07b455b3-516c-467f-80bd-a24e03f8bea1.pdm','rpt.pdm',343109,'1','20151026230610'),
 ('4028d08150a4a0330150a4b1174e003b','201510\\35fd7065-0289-4d3f-8a4e-5481731fc3d8.pdm','rpt.pdm',343109,'1','20151026230800'),
 ('4028d08150a4a0330150a4b4403c0041','201510\\91efd2af-544a-4ac7-bbaf-fac01944c57e.pdm','rpt.pdm',343109,'1','20151026231127'),
 ('4028d08150a4a0330150a4bd03e40049','201510\\026abece-ad6c-4414-a6fb-261bc6c15995.pdm','rpt.pdm',343109,'1','20151026232102'),
 ('4028d08150a4ded70150a4dff9ec0001','201510\\41b3f45c-db92-4871-87ee-0178e5a2b86b.pdm','rpt.pdm',343109,'1','20151026235913'),
 ('4028d08150a4ded70150a4e2a0610050','201510\\26aa5a50-8fed-45db-ace8-c524e596f684.pdm','rpt.pdm',343109,'1','20151027000207'),
 ('4028d08150a4ded70150a4ec30bb00c7','201510\\b4c9f048-4ab5-46e6-910b-1558957de8f6.pdm','rpt.pdm',343109,'1','20151027001233'),
 ('4028d08150ae07eb0150ae2795db0001','201510\\454b2f3d-9dec-4686-b55c-1007f4ed8ef8.zip','gsoft-platform.zip',48884,'1','20151028191401'),
 ('4028d08150ae07eb0150ae27f47d0002','201510\\b2f430d6-b680-42e3-be6c-aa36bff99bd9.pdb','framework.codemap.pdb',147112,'1','20151028191425'),
 ('4028d08150ae07eb0150ae27f4f10003','201510\\03390ac1-b8d9-4d0f-9ebd-e6e0d718aa7f.pdm','framework.codemap.pdm',189775,'1','20151028191425'),
 ('4028d08150ae07eb0150ae27f5390004','201510\\ef5722c3-b6fa-4c7b-9283-da9e0be7b1f9.pdb','framework.dbcontext.pdb',159850,'1','20151028191425'),
 ('4028d08150c41c010150c5edbef10001','201511\\ebff29b1-6464-4bf0-b8c5-fa09002a9f7d.zip','gsoft-platform.zip',78882,'1','20151102100143'),
 ('4028d08150c41c010150c5f54cec0002','201511\\f979b8e3-aa1a-42e0-9eae-ee2a70fd8b77.pdm','esb.pdm',300046,'1','20151102100959'),
 ('4028d08150c41c010150c5f54d5c0003','201511\\7ae714f8-819a-426c-b821-280143192d54.pdm','framework.dbcontext.pdm',159850,'1','20151102100959'),
 ('4028d08150c6c9630150c6d5376c0001','201511\\0f137457-f267-433c-9958-946db7b232c0.pdm','framework.codemap.pdm',189775,'1','20151102141433'),
 ('4028d08150c6c9630150c6d538540002','201511\\53b8a585-369e-4b75-a6b2-0279b3a9054d.pdm','framework.dbcontext.pdm',159850,'1','20151102141433'),
 ('4028d08150c728c10150c7a9a9410001','201511\\9934d49d-25e3-48f4-a2cb-bbf191d8426d.pdm','framework.codemap.pdm',189775,'1','20151102180636'),
 ('4028d08150faf7e80150fafc5c1f0004','201511\\d20fddb9-2eb3-42a4-b24a-41b3cdbe2a0e.zip','psbc-rmbdc.zip',40836,'1','20151112171734'),
 ('4028d08150fe7d580150fe7e52500001','201511\\a6641ac6-8dec-42b4-980c-3562cdf9ace2.jar','ojdbc-6.jar',2678672,'1','20151113093822'),
 ('4028d08150fe7d580150fe7e52ea0002','201511\\55067636-bd73-4c59-9dca-d52197cf734d.lastUpdated','ojdbc-6.jar.lastUpdated',3022,'1','20151113093823'),
 ('4028d08150fe7d580150fe7e536d0003','201511\\273a457f-c9b0-407c-8d40-d5f044f7e457.sha1','ojdbc-6.jar.sha1',40,'1','20151113093823'),
 ('4028d08150fe7d580150fe7e53cf0004','201511\\730044c3-57e4-4548-9d4c-1ef3ef304dd5.pom','ojdbc-6.pom',443,'1','20151113093823'),
 ('4028d08150fe7d580150fe87ffff0005','201511\\dcd07665-5bfc-4a51-a2c5-4d35ae17a50d.jar','ojdbc-6.jar',2678672,'1','20151113094857'),
 ('4028d08150fe7d580150fe8ae7cd0006','201511\\fb7715f0-67f7-469b-b730-4439dc175fe6.lastUpdated','ojdbc-6.jar.lastUpdated',3022,'1','20151113095207'),
 ('4028d0815147928601514794ed890001','201511\\7fa92077-5e6e-46dc-82a5-6f71dfcd814f.pdf','cql33.pdf',5236158,'1','20151127141521'),
 ('4028d08151479286015147972dd80002','201511\\001abbe4-c373-4dc4-9c34-fb35338953dd.ior','test.ior',354,'1','20151127141748'),
 ('4028d0815147a918015147a9ee600001','201511\\cbb3dcec-f80c-41c9-a8df-bbe1d23556f1.pdf','Ansible-notes.pdf',1073114,'1','20151127143817'),
 ('4028d0815147a918015147aa300c0002','201511\\5d2aeeb6-21a2-4e29-8ad7-4d9f96bb09ac.css','qunit-1.20.0.css',5349,'1','20151127143834'),
 ('4028d0815147a918015147aa30720003','201511\\46ef6e24-4de3-494d-9116-e69587a8662c.js','qunit-1.20.0.js',112454,'1','20151127143834'),
 ('4028d0815147a918015147aa31170004','201511\\d10270a4-523b-4809-b2d8-b1e96fecabb0.bat','runDeskFile.bat',46,'1','20151127143834'),
 ('4028d0815147a918015147aa50200005','201511\\93219c89-ee24-4b3d-b0d9-2eac65c529ee.jar','spark-examples-1.4.1-hadoop2.6.0.jar',105738089,'1','20151127143842'),
 ('4028d0815147a918015147aa51930006','201511\\da9f520f-2854-4c2b-933d-5e93f96418ec.docx','spring ldap.docx',132268,'1','20151127143843'),
 ('4028d0815147a918015147ac30fc0007','201511\\37b9bd28-a38e-41e1-8799-4fecb6319d5d.ior','test.ior',354,'1','20151127144045'),
 ('4028d0815147a918015147aded200008','201511\\e0484350-5752-405e-a3ba-1beaed166009.ior','test.ior',354,'1','20151127144239'),
 ('4028d0815148256f0151484393930001','201511\\67088415-1f27-4891-b145-cb0119110536.msi','ide.msi',98099200,'1','20151127172606'),
 ('4028d0815148256f01514844c2540002','201511\\8aacf4dd-6519-4c56-b59d-7b39f9455bbf.msi','ide.msi',98099200,'1','20151127172724'),
 ('4028d0815148256f0151484893280003','201511\\28c95bcf-58fb-4814-a095-e46942726f1b.msi','ide.msi',98099200,'1','20151127173134'),
 ('4028d0815148256f01514849beb90004','201511\\b5dc24ec-9337-41f9-b3d7-c40c9f6730f3.msi','ide.msi',98099200,'1','20151127173251'),
 ('4028d0815148256f0151484baa340005','201511\\584b2c61-583c-4a36-99f8-93b7e840af88.msi','ide.msi',98099200,'1','20151127173457'),
 ('4028d0815148256f0151484d23eb0006','201511\\958c25c0-55db-4e74-b1bb-cef9a9dbbd2e.msi','ide.msi',98099200,'1','20151127173633'),
 ('4028d081514853a00151485ae5fb0001','201511\\569e4f5f-a59a-4b27-afab-9e7f091c104d.msi','ide.msi',98099200,'1','20151127175135'),
 ('4028d081514853a00151485c91a60002','201511\\71905adb-afb0-470c-8a76-68deec232609.msi','ide.msi',98099200,'1','20151127175324'),
 ('4028d081514853a00151485f25e90003','201511\\57a8a71b-35c4-4db7-b89e-080f83772437.msi','ide.msi',98099200,'1','20151127175613'),
 ('4028d081514853a00151485f96420004','201511\\37043854-a4eb-4b4e-b215-c1e352ea3c9e.msi','ide.msi',98099200,'1','20151127175642'),
 ('4028d081514853a0015148614bc80005','201511\\531eef44-e159-47c5-b5db-f0804b6b30f0.ior','test.ior',354,'1','20151127175834'),
 ('4028d081514853a0015148625f350006','201511\\90691d27-6376-487d-8503-5ac0c5b20631.zip','connection_manager_3_6_3.zip',2838106,'1','20151127175945'),
 ('4028d081514853a00151486643840007','201511\\bcab07a8-66f0-4dab-beda-26e9be18b003.zip','connection_manager_3_6_3.zip',2838106,'1','20151127180400'),
 ('4028d081514853a001514868687b0008','201511\\d4c7cb11-b46b-4922-957a-982133719511.zip','connection_manager_3_6_3.zip',2838106,'1','20151127180620'),
 ('4028d081514853a001514869a0860009','201511\\7dbe7762-8f11-4a59-b271-cd9033570398.msi','ide.msi',98099200,'1','20151127180740'),
 ('4028d081514853a00151486c187e000a','201511\\c16ad968-80ef-4e57-a5ce-df3d5d6e8fa5.msi','ide.msi',98099200,'1','20151127181022'),
 ('4028d081514853a00151486c3845000b','201511\\34e2e44b-3d14-4ad9-bbed-989219be0549.msi','ide.msi',98099200,'1','20151127181030'),
 ('4028d081514853a00151486da38f000c','201511\\0fe1e362-e7f5-4e1c-af80-286a128cf984.msi','ide.msi',98099200,'1','20151127181203'),
 ('4028d081514853a00151486e6042000d','201511\\eb3b506d-9312-44b5-a55a-4e17a2d8a619.msi','ide.msi',98099200,'1','20151127181251'),
 ('4028d081514853a00151487bfb7e000e','201511\\550cec2d-9685-4023-a5f2-698dc6d38195.msi','ide.msi',98099200,'1','20151127182743'),
 ('4028d081514853a00151487cb3d9000f','201511\\828adb2d-6226-4309-ae1d-80dc45cf1378.msi','ide.msi',98099200,'1','20151127182830'),
 ('4028d081514853a00151487da4890010','201511\\dd07bdde-324c-41ba-8a81-6cf73fe561d6.msi','ide.msi',98099200,'1','20151127182932'),
 ('4028d081514853a00151487e48100011','201511\\8add437d-7b28-4213-8482-b5352d5a16b9.msi','ide.msi',98099200,'1','20151127183014'),
 ('4028d081514853a001514880ad660012','201511\\f06232aa-08a6-43c2-a64d-1c097308e58e.msi','ide.msi',98099200,'1','20151127183251'),
 ('4028d081516c663c015170b0631d0001','201512\\b444ff68-e618-4637-9f03-0d458f6f57fe.png','icon.png',6034,'0','20151205134946'),
 ('4028d081519021670151902288800001','201512\\8b87ec9f-2d97-48f7-9bdd-2fe954688e9b.png','icon.png',6034,'0','20151211162241'),
 ('4028d081519021670151902602ec0002','201512\\25281fe3-2689-4085-9034-f82951c1e70d.png','icon.png',6034,'0','20151211162628'),
 ('4028d0815190216701519026d9b60003','201512\\03a7cfd5-51f8-4814-befc-f951380e0fd0.png','icon.png',6034,'0','20151211162723'),
 ('4028d0815190216701519027428f0004','201512\\0b73503b-d43f-41ad-a331-bc5f2c6a6302.png','icon.png',6034,'0','20151211162750'),
 ('4028d081519021670151903347460005','201512\\5b64e54b-e31d-46b5-a744-6110f2de910d.png','icon.png',6034,'0','20151211164058'),
 ('4028d081519043f6015190447d310001','201512\\212aa15f-9a03-4952-9b8c-42e68940d3ed.png','icon.png',6034,'0','20151211165946'),
 ('4028d08151905747015190596f280001','201512\\5c0cf2a6-3766-4b53-abcb-f91111b10a6f.jpg','ebb6c51ca6e18b89.jpg',815460,'0','20151211172238'),
 ('4028d081519057470151905bdb850002','201512\\afde8b34-7c9b-431b-af99-7a2f416098d3.jpg','LOGO-指南针.jpg',19993,'0','20151211172517'),
 ('4028d081519057470151905c43e00003','201512\\727b8168-a776-431e-9f0d-6fbe7fde06ca.png','circle.png',1721,'0','20151211172544'),
 ('4028d0815190574701519068fa0e0004','201512\\04695b16-1c40-498b-bdc2-bcdc9536c908.png','circle.png',1721,'0','20151211173937'),
 ('4028d081519057470151906adc5e0005','201512\\adb7cb36-1e81-426e-bbe9-774f46cbe51b.png','circle.png',1721,'0','20151211174141'),
 ('4028d08151907d2d0151907e6e1f0001','201512\\0b8abddb-a26f-47f9-8cac-6bfa3662cb45.png','circle.png',1721,'0','20151211180303'),
 ('4028d08151907d2d0151907fcafa0002','201512\\688e14e8-13a7-451c-8ce1-7615713e6d8f.png','circle.png',1721,'0','20151211180432'),
 ('4028d08151909c270151909cf8b20001','201512\\ac4e0f05-f7f6-432e-8826-6afc94403e26.png','circle.png',1721,'0','20151211183625'),
 ('4028d0815190a453015190a5432e0001','201512\\e65bbfa0-c2b1-49ae-9680-38d41cdf8c68.png','circle.png',1721,'0','20151211184528'),
 ('4028d0815190a453015190a5bcf60002','201512\\263d80da-3a42-49c2-9511-601f1aee95b3.png','circle.png',1721,'0','20151211184559'),
 ('4028d0815190b46b015190c082b70001','201512\\c31c32de-545c-4167-9c34-902ef1e8878b.png','circle.png',1721,'0','20151211191514'),
 ('4028d0815190b46b01519402bce90002','201512\\c525307f-d579-476b-94a7-636e22803625.png','circle.png',1721,'0','20151212102626'),
 ('4028d081519468b501519477a5460001','201512\\24043a56-7277-4233-83b2-e37a8deda8aa.jpg','LOGO-指南针.jpg',19993,'0','20151212123407'),
 ('4028d08152535c39015253c750720004','201601\\4a142be2-e66e-4dd8-a9ed-cd3eccbd47df.zip','gsoft-vtui.zip',40524,'0','20160118160837');
/*!40000 ALTER TABLE `youi_file_store` ENABLE KEYS */;


--
-- Definition of table `youi_flow`
--

DROP TABLE IF EXISTS `youi_flow`;
CREATE TABLE `youi_flow` (
  `FLOW_ID` varchar(32) NOT NULL,
  `FLOW_CONTENT` text,
  `DEPLOY_ID` varchar(32) DEFAULT NULL,
  `DEPLOY_TIME` varchar(20) DEFAULT NULL,
  `FLOW_CAPTION` varchar(80) DEFAULT NULL,
  `FLOW_CODE` varchar(20) DEFAULT NULL,
  `FLOW_NAME` varchar(20) DEFAULT NULL,
  `START_FORM` varchar(60) DEFAULT NULL,
  `STATUS` varchar(2) DEFAULT NULL,
  `FLOW_BUSINESS_SERVICE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FLOW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='930101流程定义';

--
-- Dumping data for table `youi_flow`
--

/*!40000 ALTER TABLE `youi_flow` DISABLE KEYS */;
INSERT INTO `youi_flow` (`FLOW_ID`,`FLOW_CONTENT`,`DEPLOY_ID`,`DEPLOY_TIME`,`FLOW_CAPTION`,`FLOW_CODE`,`FLOW_NAME`,`START_FORM`,`STATUS`,`FLOW_BUSINESS_SERVICE`) VALUES 
 ('4028d0815088028101508807374f0001','<?xml version=\"1.0\" encoding=\"UTF-8\"?><definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:activiti=\"http://activiti.org/bpmn\"	xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\"	xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\"	expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://activiti.org/bpmn20\">	<process id=\"flow01\" name=\"flow01\">		<startEvent id=\"startEvent\" name=\"Start\" activiti:initiator=\"loginName\"></startEvent>		<endEvent id=\"endEvent\" name=\"End\"></endEvent>		</process>	<bpmndi:BPMNDiagram id=\"BPMNDiagram_flow01\">		<bpmndi:BPMNPlane bpmnElement=\"flow01\"			id=\"BPMNPlane_flow01\">			<bpmndi:BPMNShape bpmnElement=\"startEvent\"				id=\"BPMNShape_startevent1\">				<omgdc:Bounds height=\"35\" width=\"35\" x=\"30\" y=\"135\"></omgdc:Bounds>			</bpmndi:BPMNShape>					<bpmndi:BPMNShape bpmnElement=\"endEvent\" id=\"BPMNShape_endEvent\">				<omgdc:Bounds height=\"35\" width=\"35\" x=\"555\" y=\"135\"></omgdc:Bounds>			</bpmndi:BPMNShape>		</bpmndi:BPMNPlane>	</bpmndi:BPMNDiagram></definitions>',NULL,NULL,'flow01',NULL,'flow01',NULL,'0',NULL);
/*!40000 ALTER TABLE `youi_flow` ENABLE KEYS */;


--
-- Definition of table `youi_menu`
--

DROP TABLE IF EXISTS `youi_menu`;
CREATE TABLE `youi_menu` (
  `MENU_ID` varchar(32) NOT NULL,
  `MENU_CAPTION` varchar(512) DEFAULT NULL,
  `MENU_SRC` varchar(800) DEFAULT NULL,
  `MENU_STYLE` varchar(20) DEFAULT NULL,
  `SUBPAGE` int(11) DEFAULT NULL,
  `PARENT_MENU_ID` varchar(32) DEFAULT NULL,
  `MENU_TARGET` varchar(60) DEFAULT NULL,
  `MENU_NUM` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920102系统菜单';

--
-- Dumping data for table `youi_menu`
--

/*!40000 ALTER TABLE `youi_menu` DISABLE KEYS */;
INSERT INTO `youi_menu` (`MENU_ID`,`MENU_CAPTION`,`MENU_SRC`,`MENU_STYLE`,`SUBPAGE`,`PARENT_MENU_ID`,`MENU_TARGET`,`MENU_NUM`) VALUES 
 ('010000','项目定制',NULL,NULL,0,NULL,'1','001'),
 ('010100','项目定制','page/platform.codemng.codeProject/codeProject.html',NULL,0,'010000','1','001'),
 ('010200','菜单模版定制','page/platform.codemng.codeProject/codeProjectMenus.html',NULL,0,'010000','1','002'),
 ('010300','模型设计','page/platform.codepdm.pdm/pdm.html',NULL,0,'010000','1','003'),
 ('020000','公共管理',NULL,NULL,0,NULL,'1','002'),
 ('020100','角色管理','page/security.fuc.role/role.html',NULL,0,'020000',NULL,NULL),
 ('020200','人员管理','page/security.agt.user/user.html',NULL,0,'020000',NULL,NULL),
 ('020300','系统菜单','page/security.fuc.menu/menu.html',NULL,0,'020000',NULL,NULL),
 ('020400','代码集管理','page/codemap/codemap.html',NULL,0,'020000',NULL,NULL),
 ('020500','日志管理','admin/transLog/index.html',NULL,0,'020000',NULL,NULL),
 ('030000','流程管理',NULL,NULL,0,NULL,'1','003'),
 ('030100','流程定义','page/workflow.flow/flow.html',NULL,0,'030000','1',NULL),
 ('030200','表单设计','page/workflow.flow/formDesigner.html',NULL,0,'030000','1',NULL),
 ('040000','报表管理',NULL,NULL,0,NULL,'1','004'),
 ('040100','报表定义','page/report.rptmng.rptTemplate/rptTemplate.html',NULL,0,'040000','1','004'),
 ('040200','报表参数',NULL,NULL,0,'040000','1','005'),
 ('040300','灵活报表','page/report.rptqry/rptflexible.html',NULL,0,'040000','1','006'),
 ('040400','立方体定义','page/report.rptcfg.rptCube/rptCube.html',NULL,0,'040000','1','003'),
 ('040500','报表数据源','page/report.rptcfg.rptDataSource/rptDataSource.html',NULL,0,'040000','1','001'),
 ('040600','报表数据集','page/report.rptcfg.rptDataSet/rptDataSet.html',NULL,0,'040000','1','002'),
 ('040900',' 用户报表','page/report.viewer/example.html',NULL,0,'040000',NULL,'099'),
 ('060000','表单管理',NULL,NULL,0,NULL,'1','005'),
 ('060100','表单设计','page/platform.codepage.page/page.html',NULL,0,'060000',NULL,NULL),
 ('090000','调度管理',NULL,NULL,0,NULL,'1','006'),
 ('090100','定时任务','page/scheduler.job/job.html',NULL,0,'090000',NULL,NULL),
 ('300100','我的账户','{contextPath}/cms/account/index/{loginName}.html','account',0,NULL,'1','001'),
 ('309900','我的设置',NULL,'setting',0,NULL,'1','099'),
 ('309901','个人资料','{contextPath}/cms/setting/info/{loginName}.html',NULL,0,'309900','1','001'),
 ('309902','认证信息','{contextPath}/cms/setting/auth/{loginName}.html',NULL,0,'309900','1','002'),
 ('700000','微信服务号',NULL,NULL,0,NULL,NULL,'007'),
 ('700100','素材管理','page/wx.wxmessage.wxmedia/wxMedia.html',NULL,0,'700000',NULL,'001'),
 ('700200','消息管理','page/wx.wxmessage.wxmessage/wxMessage.html',NULL,0,'700000',NULL,'002'),
 ('700300','群发管理','page/wx.wxmessage.wxmass/wxMass.html',NULL,0,'700000',NULL,'003'),
 ('700500','客服管理',NULL,NULL,0,'700000',NULL,'005'),
 ('700600','粉丝分组','page/wx.wxmember.wxmembergroup/wxMemberGroup.html',NULL,0,'700000','1','006'),
 ('704000','粉丝管理','page/wx.wxmember.wxmember/wxMember.html',NULL,0,'700000','1','004'),
 ('960000','服务总线',NULL,NULL,0,NULL,NULL,'007'),
 ('960100','服务适配器','page/esb.buscfg.busAdapter/busAdapter.html',NULL,0,'960000','1','001'),
 ('960200','服务定义','page/esb.buscfg.busService/busService.html',NULL,0,'960000','1','002'),
 ('960300','服务发布','page/esb.buscfg.busExportPort/busExportPort.html',NULL,0,'960000','1','003'),
 ('960400','应用系统','page/esb.buscfg.busApp/busApp.html',NULL,0,'960000','1','004'),
 ('960500','服务日志',NULL,NULL,0,'960000','1','005'),
 ('980000','运维监控',NULL,NULL,0,NULL,NULL,'008'),
 ('980100','监控配置',NULL,NULL,0,'980000',NULL,'001'),
 ('980101','监控插件管理',NULL,NULL,0,'980100','1','001'),
 ('980102','监控代理管理',NULL,NULL,0,'980100',NULL,'002'),
 ('980200','设备管理',NULL,NULL,0,'980000',NULL,'002'),
 ('980201','主机管理',NULL,NULL,0,'980200',NULL,'001'),
 ('980300','应用管理',NULL,NULL,0,'980000',NULL,'003'),
 ('980301','应用管理',NULL,NULL,0,'980300',NULL,'001'),
 ('980302','节点管理',NULL,NULL,0,'980300',NULL,'002'),
 ('980303','集群管理',NULL,NULL,0,'980300',NULL,'003'),
 ('980400','监控预警',NULL,NULL,0,'980000',NULL,'004'),
 ('980401','预警规则管理',NULL,NULL,0,'980400',NULL,'001'),
 ('980402','监控项管理',NULL,NULL,0,'980400',NULL,'002');
/*!40000 ALTER TABLE `youi_menu` ENABLE KEYS */;


--
-- Definition of table `youi_page_element`
--

DROP TABLE IF EXISTS `youi_page_element`;
CREATE TABLE `youi_page_element` (
  `PAGE_ELEMENT_ID` varchar(32) NOT NULL,
  `MENU_ID` varchar(32) DEFAULT NULL,
  `PAGE_ELEMENT_NAME` varchar(20) DEFAULT NULL,
  `PAGE_ELEMENT_CAPTION` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`PAGE_ELEMENT_ID`),
  KEY `FK_R_0102_0102` (`MENU_ID`),
  CONSTRAINT `FK_R_0102_0102` FOREIGN KEY (`MENU_ID`) REFERENCES `youi_menu` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920102页面元素';

--
-- Dumping data for table `youi_page_element`
--

/*!40000 ALTER TABLE `youi_page_element` DISABLE KEYS */;
INSERT INTO `youi_page_element` (`PAGE_ELEMENT_ID`,`MENU_ID`,`PAGE_ELEMENT_NAME`,`PAGE_ELEMENT_CAPTION`) VALUES 
 ('addUser','010100',NULL,'增加用户'),
 ('removeUser','010100',NULL,'删除用户');
/*!40000 ALTER TABLE `youi_page_element` ENABLE KEYS */;


--
-- Definition of table `youi_pdm`
--

DROP TABLE IF EXISTS `youi_pdm`;
CREATE TABLE `youi_pdm` (
  `PDM_ID` varchar(36) NOT NULL,
  `PDM_CAPTION` varchar(80) DEFAULT NULL,
  `DIAGRAM_ID` varchar(60) DEFAULT NULL,
  `PDM_XML` text,
  PRIMARY KEY (`PDM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900303实体关系模型';

--
-- Dumping data for table `youi_pdm`
--

/*!40000 ALTER TABLE `youi_pdm` DISABLE KEYS */;
INSERT INTO `youi_pdm` (`PDM_ID`,`PDM_CAPTION`,`DIAGRAM_ID`,`PDM_XML`) VALUES 
 ('4028d081509a511c01509a53a8f60001',NULL,'4028d0815095936f0150959e1c190006-cd','<div id=\"4028d081509a511c01509a53b5a90002\" class=\"node entity\" style=\"left: 135px; top: 20px;\" data-entity-id=\"4028d081509a511c01509a53b5a90002\" title=\"用户\"><div class=\"entity-top node-title\">用户</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>userId</td><td class=\"m\"></td><td>varchar(36)</td><td class=\"p\"> pi </td></tr><tr class=\"entity-prop\"><td>userName</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>userCaption</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>password</td><td class=\"m\"></td><td>varchar(36)</td><td class=\"p\"></td></tr></tbody></table></div></div><div class=\"entity-bottom\">990101 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div><div id=\"4028d081509a552101509a560cad0002\" class=\"node entity\" style=\"left: 135px; top: 253px;\" data-entity-id=\"4028d081509a552101509a560cad0002\" title=\"机构\"><div class=\"entity-top node-title\">机构</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>agencyId</td><td class=\"m\">&lt;m&gt;</td><td>varchar</td><td class=\"p\"> pi </td></tr><tr class=\"entity-prop\"><td>agencyName</td><td class=\"m\"></td><td>varchar</td><td class=\"p\"></td></tr></tbody></table></div></div><div class=\"entity-bottom\">990102 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div><div id=\"4028d081509a552101509a560cad0002_4028d081509a511c01509a53b5a90002\" class=\"transition\" data-source-ref=\"4028d081509a552101509a560cad0002\" data-target-ref=\"4028d081509a511c01509a53b5a90002\"><div class=\"point in-straight-line\" style=\"left: 227px; top: 257px;\"></div></div><div id=\"4028d081509aa3ea01509b1852110004\" class=\"node entity\" style=\"left: 451px; top: 44px;\" data-entity-id=\"4028d081509aa3ea01509b1852110004\" title=\"菜单\"><div class=\"entity-top node-title\">菜单</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>menuId</td><td class=\"m\">&lt;m&gt;</td><td>varchar</td><td class=\"p\"> pi </td></tr><tr class=\"entity-prop\"><td>menuCaption</td><td class=\"m\"></td><td>varchar</td><td class=\"p\"></td></tr></tbody></table></div></div><div class=\"entity-bottom\">990103 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div><div id=\"4028d081509d782701509dce48ef0006\" class=\"node entity ui-click\" style=\"left: 451px; top: 253px;\" data-entity-id=\"4028d081509d782701509dce48ef0006\" title=\"数据集\"><div class=\"entity-top node-title\">数据集</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>name</td><td class=\"m\">&lt;M&gt;</td><td>varchar(40)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>caption</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr></tbody></table></div></div><div class=\"entity-bottom\">990104 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div><div id=\"4028d081509a552101509a560cad0002_4028d081509d782701509dce48ef0006\" class=\"transition\" data-source-ref=\"4028d081509a552101509a560cad0002\" data-target-ref=\"4028d081509d782701509dce48ef0006\"><div class=\"point in-straight-line\" style=\"left: 4px; top: 0px;\"></div></div>'),
 ('4028d081509ce6eb01509d0e0ab50001',NULL,'4028d0815095936f0150959e1c190007-cd','<div id=\"4028d08150a21f0c0150a267fafb0001\" class=\"node entity ui-click\" style=\"left: 143px; top: 37px;\" data-entity-id=\"4028d08150a21f0c0150a267fafb0001\" title=\"区域\"><div class=\"entity-top node-title\">区域</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>areaId</td><td class=\"m\">&lt;m&gt;</td><td>varchar(36)</td><td class=\"p\"> pi </td></tr></tbody></table></div></div><div class=\"entity-bottom\">990201 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div>'),
 ('4028d081509d782701509e7018b10013',NULL,'4028d0815098dc35015098f3bb5c0001-cd',NULL),
 ('4028d08150a1db530150a1dd8b750001',NULL,'4028d0815098dc35015098f3bb660002-cd',NULL),
 ('4028d08150a4a0330150a4b0a54e003a',NULL,'4028d08150a4a0330150a4b075f70033-cd',NULL),
 ('4028d08150a4a0330150a4b39f510040',NULL,'4028d08150a4a0330150a4b0760a0039-cd',NULL),
 ('4028d08150a4ded70150a4e7ecb300c6',NULL,'4028d08150a4a0330150a4b075eb002f-cd','<div id=\"4028d08150a4ded70150a4ec379b00c8\" class=\"node entity\" style=\"left: 155px; top: 92px;\" data-entity-id=\"4028d08150a4ded70150a4ec379b00c8\" title=\"通用查询\"><div class=\"entity-top node-title\">通用查询</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>queryId</td><td class=\"m\"></td><td>varchar(32)</td><td class=\"p\">&lt;pi&gt;</td></tr><tr class=\"entity-prop\"><td>datasourceId</td><td class=\"m\"></td><td>varchar(32)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>rptFolderId</td><td class=\"m\"></td><td>varchar(32)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>querySql</td><td class=\"m\"></td><td>varchar(2048)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>queryCaption</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr></tbody></table></div></div><div class=\"entity-bottom\">920801 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div><div id=\"4028d08150a4ded70150a4ec37a200ce\" class=\"node entity\" style=\"left: 458.5px; top: 109px;\" data-entity-id=\"4028d08150a4ded70150a4ec37a200ce\" title=\"查询条件\"><div class=\"entity-top node-title\">查询条件</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>rptQueryCondId</td><td class=\"m\"></td><td>varchar(40)</td><td class=\"p\">&lt;pi&gt;</td></tr><tr class=\"entity-prop\"><td>mapName</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>mapCaption</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>mapNum</td><td class=\"m\"></td><td>varchar(20)</td><td class=\"p\"></td></tr></tbody></table></div></div><div class=\"entity-bottom\">920802 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div><div id=\"4028d08150a4ded70150a4ec37a900d3\" class=\"node entity\" style=\"left: 249px; top: 308px;\" data-entity-id=\"4028d08150a4ded70150a4ec37a900d3\" title=\"查询结果映射\"><div class=\"entity-top node-title\">查询结果映射</div><div class=\"entity-center\"><div class=\"entity-prop-container\"><table><tbody><tr class=\"entity-prop\"><td>queryMapId</td><td class=\"m\"></td><td>varchar(32)</td><td class=\"p\">&lt;pi&gt;</td></tr><tr class=\"entity-prop\"><td>mapName</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>mapCaption</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr><tr class=\"entity-prop\"><td>mapColumn</td><td class=\"m\"></td><td>varchar(80)</td><td class=\"p\"></td></tr></tbody></table></div></div><div class=\"entity-bottom\">920803 pi</div><div class=\"col-resize-handler\"></div><div class=\"row-resize-handler\"></div></div>'),
 ('4028d08150a4ded70150a4edb95600f6',NULL,'4028d08150a4a0330150a4b075ff0036-cd',NULL);
/*!40000 ALTER TABLE `youi_pdm` ENABLE KEYS */;


--
-- Definition of table `youi_pdm_domain`
--

DROP TABLE IF EXISTS `youi_pdm_domain`;
CREATE TABLE `youi_pdm_domain` (
  `DOMAIN_ID` varchar(36) NOT NULL,
  `DOMAIN_NAME` varchar(40) DEFAULT NULL,
  `DOMAIN_CAPTION` varchar(80) DEFAULT NULL,
  `DATA_TYPE` varchar(20) DEFAULT NULL,
  `DATA_LENGTH` varchar(20) DEFAULT NULL,
  `DATA_PRECISION` varchar(3) DEFAULT NULL,
  `MANDATORY` int(11) DEFAULT NULL,
  PRIMARY KEY (`DOMAIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900304属性域';

--
-- Dumping data for table `youi_pdm_domain`
--

/*!40000 ALTER TABLE `youi_pdm_domain` DISABLE KEYS */;
INSERT INTO `youi_pdm_domain` (`DOMAIN_ID`,`DOMAIN_NAME`,`DOMAIN_CAPTION`,`DATA_TYPE`,`DATA_LENGTH`,`DATA_PRECISION`,`MANDATORY`) VALUES 
 ('uuid','UUID','UUID','varchar','36',NULL,NULL);
/*!40000 ALTER TABLE `youi_pdm_domain` ENABLE KEYS */;


--
-- Definition of table `youi_pdm_entity`
--

DROP TABLE IF EXISTS `youi_pdm_entity`;
CREATE TABLE `youi_pdm_entity` (
  `ENTITY_ID` varchar(36) NOT NULL,
  `MODULE_ID` varchar(36) DEFAULT NULL,
  `ENTITY_NAME` varchar(40) DEFAULT NULL,
  `ENTITY_CAPTION` varchar(80) DEFAULT NULL,
  `TABLE_NAME` varchar(40) DEFAULT NULL,
  `ENTITY_CODE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ENTITY_ID`),
  KEY `FK_R_90_0103_0308` (`MODULE_ID`),
  CONSTRAINT `FK_R_90_0103_0308` FOREIGN KEY (`MODULE_ID`) REFERENCES `youi_code_module` (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实体';

--
-- Dumping data for table `youi_pdm_entity`
--

/*!40000 ALTER TABLE `youi_pdm_entity` DISABLE KEYS */;
INSERT INTO `youi_pdm_entity` (`ENTITY_ID`,`MODULE_ID`,`ENTITY_NAME`,`ENTITY_CAPTION`,`TABLE_NAME`,`ENTITY_CODE`) VALUES 
 ('4028d081509a511c01509a53b5a90002','4028d0815095936f0150959e1c190006','user','用户','YOUI_USER','990101'),
 ('4028d081509a552101509a560cad0002','4028d0815095936f0150959e1c190006','agency','机构',NULL,'990102'),
 ('4028d081509aa3ea01509b1852110004','4028d0815095936f0150959e1c190006','menu','菜单','YOUI_MENU','990103'),
 ('4028d081509d782701509d9eea3e0003','4028d0815095936f0150959e1c190006','tran','交易','YOUI_TRAN','990105'),
 ('4028d081509d782701509dce48ef0006','4028d0815095936f0150959e1c190006','codemap','数据集','YOUI_CODEMAP','990104'),
 ('4028d081509d782701509e705a7f0014','4028d0815098dc35015098f3bb5c0001','newEntity2','新实体2',NULL,NULL),
 ('4028d081509d782701509e7089050015','4028d0815098dc35015098f3bb5c0001','newEntity3','新实体3',NULL,NULL),
 ('4028d08150a1b51e0150a1bd14080005','4028d0815095936f0150959e1c190006','Role','角色','YOUI_ROLE','990106'),
 ('4028d08150a21f0c0150a267fafb0001','4028d0815095936f0150959e1c190007','area','区域','YOUI_AREA','990201'),
 ('4028d08150a4ded70150a4ec379b00c8','4028d08150a4a0330150a4b075eb002f','rptQuery','通用查询','YOUI_RPT_QUERY','920801'),
 ('4028d08150a4ded70150a4ec37a200ce','4028d08150a4a0330150a4b075eb002f','rptQueryCond','查询条件','YOUI_RPT_QUERY_COND','920802'),
 ('4028d08150a4ded70150a4ec37a900d3','4028d08150a4a0330150a4b075eb002f','rptQueryMap','查询结果映射','YOUI_RPT_QUERY_MAP','920803'),
 ('4028d08150a4ded70150a4ec37b100d8','4028d08150a4a0330150a4b075f70033','rptDataSource','数据源','YOUI_RPT_DATA_SOURCE','920101'),
 ('4028d08150a4ded70150a4ec37bc00e0','4028d08150a4a0330150a4b075f70033','rptFolder','报表文件夹','YOUI_RPT_FOLDER','920102'),
 ('4028d08150a4ded70150a4ec37c400e6','4028d08150a4a0330150a4b075ff0036','rptTemplate','报表模板','YOUI_RPT_TEMPLATE','920201'),
 ('4028d08150a4ded70150a4ec37cf00ee','4028d08150a4a0330150a4b075ff0036','rptParam','报表模板参数','YOUI_RPT_PARAM','920202');
/*!40000 ALTER TABLE `youi_pdm_entity` ENABLE KEYS */;


--
-- Definition of table `youi_pdm_entity_attr`
--

DROP TABLE IF EXISTS `youi_pdm_entity_attr`;
CREATE TABLE `youi_pdm_entity_attr` (
  `ENTITY_ATTR_ID` varchar(36) NOT NULL,
  `ENTITY_ID` varchar(36) DEFAULT NULL,
  `ENTITY_ATTR_NAME` varchar(40) DEFAULT NULL,
  `ENTITY_DATA_TYPE` varchar(20) DEFAULT NULL,
  `COLL` int(11) DEFAULT NULL,
  `TABLE_COLUMN` varchar(40) DEFAULT NULL,
  `LENGTH` varchar(10) DEFAULT NULL,
  `MANDATORY` varchar(1) DEFAULT NULL,
  `PRIMARY_KEY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ENTITY_ATTR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900302实体属性';

--
-- Dumping data for table `youi_pdm_entity_attr`
--

/*!40000 ALTER TABLE `youi_pdm_entity_attr` DISABLE KEYS */;
INSERT INTO `youi_pdm_entity_attr` (`ENTITY_ATTR_ID`,`ENTITY_ID`,`ENTITY_ATTR_NAME`,`ENTITY_DATA_TYPE`,`COLL`,`TABLE_COLUMN`,`LENGTH`,`MANDATORY`,`PRIMARY_KEY`) VALUES 
 ('4028d081509a511c01509a53b5a90002','4028d081509a511c01509a53b5a90002','userId','varchar',0,NULL,'36','0','1'),
 ('4028d081509a511c01509a53b5a90011','4028d081509a511c01509a53b5a90002','userName','varchar',0,NULL,'80','0','0'),
 ('4028d081509d782701509dd162f1000a','4028d081509d782701509dce48ef0006','name',NULL,NULL,NULL,'40','1','1'),
 ('4028d081509d782701509dd162f1000b','4028d081509d782701509dce48ef0006','caption',NULL,NULL,NULL,'80','0','0'),
 ('4028d081509faf0f01509fd8d3150001','4028d081509a552101509a560cad0002','agencyId',NULL,NULL,NULL,NULL,'1','1'),
 ('4028d081509faf0f01509fd8d31a0002','4028d081509a552101509a560cad0002','agencyName',NULL,NULL,NULL,NULL,NULL,NULL),
 ('4028d08150a1b51e0150a1bb54580003','4028d081509aa3ea01509b1852110004','menuId',NULL,NULL,NULL,NULL,'1','1'),
 ('4028d08150a1b51e0150a1bb54580004','4028d081509aa3ea01509b1852110004','menuCaption',NULL,NULL,NULL,NULL,NULL,NULL),
 ('4028d08150a1df4a0150a1f87cd10001','4028d08150a1b51e0150a1bd14080005','roleId',NULL,NULL,NULL,'36','1','1'),
 ('4028d08150a1df4a0150a1f87cd70002','4028d08150a1b51e0150a1bd14080005','roleCaption',NULL,NULL,NULL,NULL,NULL,NULL),
 ('4028d08150a1df4a0150a1fa81810003','4028d081509d782701509d9eea3e0003','tranId',NULL,NULL,NULL,NULL,'1','1'),
 ('4028d08150a1df4a0150a1fae7c10004','4028d081509a511c01509a53b5a90002','userCaption','varchar',NULL,NULL,'80',NULL,NULL),
 ('4028d08150a1df4a0150a1fc519b0005','4028d081509a511c01509a53b5a90002','password','varchar',NULL,NULL,'36',NULL,NULL),
 ('4028d08150a21f0c0150a268a6ae0002','4028d08150a21f0c0150a267fafb0001','areaId',NULL,NULL,NULL,'36','1','1'),
 ('4028d08150a4ded70150a4ec379b00c9','4028d08150a4ded70150a4ec379b00c8','queryId','varchar',NULL,NULL,'32',NULL,'1'),
 ('4028d08150a4ded70150a4ec379b00ca','4028d08150a4ded70150a4ec379b00c8','datasourceId','varchar',NULL,NULL,'32',NULL,'0'),
 ('4028d08150a4ded70150a4ec379b00cb','4028d08150a4ded70150a4ec379b00c8','rptFolderId','varchar',NULL,NULL,'32',NULL,'0'),
 ('4028d08150a4ded70150a4ec379b00cc','4028d08150a4ded70150a4ec379b00c8','querySql','varchar',NULL,NULL,'2048',NULL,'0'),
 ('4028d08150a4ded70150a4ec379b00cd','4028d08150a4ded70150a4ec379b00c8','queryCaption','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37a200cf','4028d08150a4ded70150a4ec37a200ce','rptQueryCondId','varchar',NULL,NULL,'40',NULL,'1'),
 ('4028d08150a4ded70150a4ec37a300d0','4028d08150a4ded70150a4ec37a200ce','mapName','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37a300d1','4028d08150a4ded70150a4ec37a200ce','mapCaption','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37a300d2','4028d08150a4ded70150a4ec37a200ce','mapNum','varchar',NULL,NULL,'20',NULL,'0'),
 ('4028d08150a4ded70150a4ec37a900d4','4028d08150a4ded70150a4ec37a900d3','queryMapId','varchar',NULL,NULL,'32',NULL,'1'),
 ('4028d08150a4ded70150a4ec37a900d5','4028d08150a4ded70150a4ec37a900d3','mapName','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37a900d6','4028d08150a4ded70150a4ec37a900d3','mapCaption','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37a900d7','4028d08150a4ded70150a4ec37a900d3','mapColumn','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37b100d9','4028d08150a4ded70150a4ec37b100d8','datasourceId','varchar',NULL,NULL,'32',NULL,'1'),
 ('4028d08150a4ded70150a4ec37b100da','4028d08150a4ded70150a4ec37b100d8','jdbcUsername','varchar',NULL,NULL,'60',NULL,'0'),
 ('4028d08150a4ded70150a4ec37b100db','4028d08150a4ded70150a4ec37b100d8','jdbcPassword','varchar',NULL,NULL,'32',NULL,'0'),
 ('4028d08150a4ded70150a4ec37b200dc','4028d08150a4ded70150a4ec37b100d8','jdbcUrl','varchar',NULL,NULL,'800',NULL,'0'),
 ('4028d08150a4ded70150a4ec37b200dd','4028d08150a4ded70150a4ec37b100d8','jdbcDriver','varchar',NULL,NULL,'100',NULL,'0'),
 ('4028d08150a4ded70150a4ec37b200de','4028d08150a4ded70150a4ec37b100d8','jdbcDbtype','varchar',NULL,NULL,'20',NULL,'0'),
 ('4028d08150a4ded70150a4ec37b200df','4028d08150a4ded70150a4ec37b100d8','jdbcSchema','varchar',NULL,NULL,'20',NULL,'0'),
 ('4028d08150a4ded70150a4ec37bc00e1','4028d08150a4ded70150a4ec37bc00e0','rptFolderId','varchar',NULL,NULL,'32',NULL,'1'),
 ('4028d08150a4ded70150a4ec37bc00e2','4028d08150a4ded70150a4ec37bc00e0','rptFolderName','varchar',NULL,NULL,'40',NULL,'0'),
 ('4028d08150a4ded70150a4ec37bc00e3','4028d08150a4ded70150a4ec37bc00e0','rptFolderCaption','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37bc00e4','4028d08150a4ded70150a4ec37bc00e0','rptFolderPid','varchar',NULL,NULL,'32',NULL,'0'),
 ('4028d08150a4ded70150a4ec37bc00e5','4028d08150a4ded70150a4ec37bc00e0','rptFolderPath','varchar',NULL,NULL,'1024',NULL,'0'),
 ('4028d08150a4ded70150a4ec37c400e7','4028d08150a4ded70150a4ec37c400e6','rptTemplateId','varchar',NULL,NULL,'32',NULL,'1'),
 ('4028d08150a4ded70150a4ec37c400e8','4028d08150a4ded70150a4ec37c400e6','rptFolderId','varchar',NULL,NULL,'32',NULL,'0'),
 ('4028d08150a4ded70150a4ec37c400e9','4028d08150a4ded70150a4ec37c400e6','rptTemplateCaption','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37c500ea','4028d08150a4ded70150a4ec37c400e6','rptTemplateContent','text',NULL,NULL,NULL,NULL,'0'),
 ('4028d08150a4ded70150a4ec37c500eb','4028d08150a4ded70150a4ec37c400e6','status','int',NULL,NULL,NULL,NULL,'0'),
 ('4028d08150a4ded70150a4ec37c500ec','4028d08150a4ded70150a4ec37c400e6','createTime','varchar',NULL,NULL,'20',NULL,'0'),
 ('4028d08150a4ded70150a4ec37c500ed','4028d08150a4ded70150a4ec37c400e6','updateTime','varchar',NULL,NULL,'20',NULL,'0'),
 ('4028d08150a4ded70150a4ec37cf00ef','4028d08150a4ded70150a4ec37cf00ee','rptParamId','varchar',NULL,NULL,'32',NULL,'1'),
 ('4028d08150a4ded70150a4ec37d000f0','4028d08150a4ded70150a4ec37cf00ee','rptParamCaption','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37d000f1','4028d08150a4ded70150a4ec37cf00ee','fieldType','varchar',NULL,NULL,'80',NULL,'0'),
 ('4028d08150a4ded70150a4ec37d000f2','4028d08150a4ded70150a4ec37cf00ee','fieldLength','varchar',NULL,NULL,'20',NULL,'0'),
 ('4028d08150a4ded70150a4ec37d000f3','4028d08150a4ded70150a4ec37cf00ee','fieldDefaultValue','varchar',NULL,NULL,'512',NULL,'0'),
 ('4028d08150a4ded70150a4ec37d000f4','4028d08150a4ded70150a4ec37cf00ee','notNull','int',NULL,NULL,NULL,NULL,'0'),
 ('4028d08150a4ded70150a4ec37d000f5','4028d08150a4ded70150a4ec37cf00ee','fieldConvert','varchar',NULL,NULL,'80',NULL,'0');
/*!40000 ALTER TABLE `youi_pdm_entity_attr` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_blob_triggers`
--

DROP TABLE IF EXISTS `youi_qrtz_blob_triggers`;
CREATE TABLE `youi_qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `youi_qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `youi_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_blob_triggers`
--

/*!40000 ALTER TABLE `youi_qrtz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_blob_triggers` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_calendars`
--

DROP TABLE IF EXISTS `youi_qrtz_calendars`;
CREATE TABLE `youi_qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_calendars`
--

/*!40000 ALTER TABLE `youi_qrtz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_calendars` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_cron_triggers`
--

DROP TABLE IF EXISTS `youi_qrtz_cron_triggers`;
CREATE TABLE `youi_qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `youi_qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `youi_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_cron_triggers`
--

/*!40000 ALTER TABLE `youi_qrtz_cron_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_cron_triggers` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_fired_triggers`
--

DROP TABLE IF EXISTS `youi_qrtz_fired_triggers`;
CREATE TABLE `youi_qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_fired_triggers`
--

/*!40000 ALTER TABLE `youi_qrtz_fired_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_fired_triggers` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_job_details`
--

DROP TABLE IF EXISTS `youi_qrtz_job_details`;
CREATE TABLE `youi_qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_job_details`
--

/*!40000 ALTER TABLE `youi_qrtz_job_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_job_details` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_locks`
--

DROP TABLE IF EXISTS `youi_qrtz_locks`;
CREATE TABLE `youi_qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_locks`
--

/*!40000 ALTER TABLE `youi_qrtz_locks` DISABLE KEYS */;
INSERT INTO `youi_qrtz_locks` (`SCHED_NAME`,`LOCK_NAME`) VALUES 
 ('schedulerFactoryBean','STATE_ACCESS'),
 ('schedulerFactoryBean','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `youi_qrtz_locks` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `youi_qrtz_paused_trigger_grps`;
CREATE TABLE `youi_qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_paused_trigger_grps`
--

/*!40000 ALTER TABLE `youi_qrtz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_paused_trigger_grps` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_scheduler_state`
--

DROP TABLE IF EXISTS `youi_qrtz_scheduler_state`;
CREATE TABLE `youi_qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_scheduler_state`
--

/*!40000 ALTER TABLE `youi_qrtz_scheduler_state` DISABLE KEYS */;
INSERT INTO `youi_qrtz_scheduler_state` (`SCHED_NAME`,`INSTANCE_NAME`,`LAST_CHECKIN_TIME`,`CHECKIN_INTERVAL`) VALUES 
 ('schedulerFactoryBean','NON_CLUSTERED',1453106564915,7500);
/*!40000 ALTER TABLE `youi_qrtz_scheduler_state` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_simple_triggers`
--

DROP TABLE IF EXISTS `youi_qrtz_simple_triggers`;
CREATE TABLE `youi_qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `youi_qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `youi_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_simple_triggers`
--

/*!40000 ALTER TABLE `youi_qrtz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_simple_triggers` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_simprop_triggers`
--

DROP TABLE IF EXISTS `youi_qrtz_simprop_triggers`;
CREATE TABLE `youi_qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `youi_qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `youi_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_simprop_triggers`
--

/*!40000 ALTER TABLE `youi_qrtz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_simprop_triggers` ENABLE KEYS */;


--
-- Definition of table `youi_qrtz_triggers`
--

DROP TABLE IF EXISTS `youi_qrtz_triggers`;
CREATE TABLE `youi_qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `youi_qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `youi_qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_qrtz_triggers`
--

/*!40000 ALTER TABLE `youi_qrtz_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_qrtz_triggers` ENABLE KEYS */;


--
-- Definition of table `youi_r_role_menu`
--

DROP TABLE IF EXISTS `youi_r_role_menu`;
CREATE TABLE `youi_r_role_menu` (
  `ROLE_ID` varchar(32) NOT NULL,
  `MENU_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`MENU_ID`),
  KEY `FK_YOUI_R_ROLE_MENU2` (`MENU_ID`),
  CONSTRAINT `FK_YOUI_R_ROLE_MENU` FOREIGN KEY (`ROLE_ID`) REFERENCES `youi_role` (`ROLEID`),
  CONSTRAINT `FK_YOUI_R_ROLE_MENU2` FOREIGN KEY (`MENU_ID`) REFERENCES `youi_menu` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单';

--
-- Dumping data for table `youi_r_role_menu`
--

/*!40000 ALTER TABLE `youi_r_role_menu` DISABLE KEYS */;
INSERT INTO `youi_r_role_menu` (`ROLE_ID`,`MENU_ID`) VALUES 
 ('ROLE_ADMIN','010000'),
 ('ROLE_OPER','010000'),
 ('ROLE_PLT','010000'),
 ('ROLE_ADMIN','010100'),
 ('ROLE_OPER','010100'),
 ('ROLE_PLT','010100'),
 ('ROLE_OPER','010200'),
 ('ROLE_PLT','010200'),
 ('ROLE_OPER','010300'),
 ('ROLE_PLT','010300'),
 ('ROLE_ADMIN','020000'),
 ('ROLE_PLT','020000'),
 ('ROLE_SUBSCRIPTION','020000'),
 ('ROLE_ADMIN','020100'),
 ('ROLE_PLT','020100'),
 ('ROLE_SUBSCRIPTION','020100'),
 ('ROLE_ADMIN','020200'),
 ('ROLE_PLT','020200'),
 ('ROLE_SUBSCRIPTION','020200'),
 ('ROLE_ADMIN','020300'),
 ('ROLE_PLT','020300'),
 ('ROLE_SUBSCRIPTION','020300'),
 ('ROLE_ADMIN','020400'),
 ('ROLE_PLT','020400'),
 ('ROLE_ADMIN','020500'),
 ('ROLE_PLT','020500'),
 ('ROLE_FLOW','030000'),
 ('ROLE_FLOW','030100'),
 ('ROLE_RPT','040000'),
 ('ROLE_RPT','040100'),
 ('ROLE_RPT','040200'),
 ('ROLE_RPT','040300'),
 ('ROLE_RPT','040400'),
 ('ROLE_RPT','040500'),
 ('ROLE_RPT','040600'),
 ('ROLE_RPT','040900'),
 ('ROLE_MEMBER','300100'),
 ('ROLE_USER','300100'),
 ('ROLE_MEMBER','309900'),
 ('ROLE_USER','309900'),
 ('ROLE_MEMBER','309901'),
 ('ROLE_USER','309901'),
 ('ROLE_MEMBER','309902'),
 ('ROLE_USER','309902'),
 ('ROLE_SUBSCRIPTION','700000'),
 ('ROLE_SUBSCRIPTION','700100'),
 ('ROLE_SUBSCRIPTION','700200'),
 ('ROLE_SUBSCRIPTION','700300'),
 ('ROLE_SUBSCRIPTION','704000'),
 ('ROLE_BUS','960000'),
 ('ROLE_BUS','960100'),
 ('ROLE_BUS','960200'),
 ('ROLE_BUS','960300'),
 ('ROLE_BUS','960400'),
 ('ROLE_BUS','960500'),
 ('ROLE_MON_ADMIN','980000'),
 ('ROLE_MON_ADMIN','980100'),
 ('ROLE_MON_ADMIN','980101'),
 ('ROLE_MON_ADMIN','980102'),
 ('ROLE_MON_ADMIN','980200'),
 ('ROLE_MON_ADMIN','980201'),
 ('ROLE_MON_ADMIN','980300'),
 ('ROLE_MON_ADMIN','980301'),
 ('ROLE_MON_ADMIN','980302'),
 ('ROLE_MON_ADMIN','980303'),
 ('ROLE_MON_ADMIN','980400'),
 ('ROLE_MON_ADMIN','980401'),
 ('ROLE_MON_ADMIN','980402');
/*!40000 ALTER TABLE `youi_r_role_menu` ENABLE KEYS */;


--
-- Definition of table `youi_r_user_role`
--

DROP TABLE IF EXISTS `youi_r_user_role`;
CREATE TABLE `youi_r_user_role` (
  `USER_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FK_YOUI_R_USER_ROLE2` (`ROLE_ID`),
  CONSTRAINT `FK_YOUI_R_USER_ROLE` FOREIGN KEY (`USER_ID`) REFERENCES `youi_user` (`USER_ID`),
  CONSTRAINT `FK_YOUI_R_USER_ROLE2` FOREIGN KEY (`ROLE_ID`) REFERENCES `youi_role` (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

--
-- Dumping data for table `youi_r_user_role`
--

/*!40000 ALTER TABLE `youi_r_user_role` DISABLE KEYS */;
INSERT INTO `youi_r_user_role` (`USER_ID`,`ROLE_ID`) VALUES 
 ('1','ROLE_ADMIN'),
 ('4028d08150e665930150e679d6fa0001','ROLE_BUS'),
 ('4028d08150a8de7a0150a8df35460001','ROLE_FLOW'),
 ('4028d08150b7055b0150b71bc0e20001','ROLE_MEMBER'),
 ('4028d081515856100151586ba71f0001','ROLE_MON_ADMIN'),
 ('1','ROLE_OPER'),
 ('2','ROLE_OPER'),
 ('4028d08150a8de7a0150a9f4827e0003','ROLE_PLT'),
 ('4028d08150a8de7a0150a9f25ea20002','ROLE_RPT');
/*!40000 ALTER TABLE `youi_r_user_role` ENABLE KEYS */;


--
-- Definition of table `youi_role`
--

DROP TABLE IF EXISTS `youi_role`;
CREATE TABLE `youi_role` (
  `ROLEID` varchar(32) NOT NULL,
  `ROLE_CAPTION` varchar(80) DEFAULT NULL,
  `ROLE_CODE` varchar(20) DEFAULT NULL,
  `ROLE_TYPE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920101角色';

--
-- Dumping data for table `youi_role`
--

/*!40000 ALTER TABLE `youi_role` DISABLE KEYS */;
INSERT INTO `youi_role` (`ROLEID`,`ROLE_CAPTION`,`ROLE_CODE`,`ROLE_TYPE`) VALUES 
 ('ROLE_actg','act',NULL,NULL),
 ('ROLE_ADMIN','系统管理员','ROLE_ADMIN','1'),
 ('ROLE_BUS','服务治理管理员',NULL,'1'),
 ('ROLE_FLOW','流程管理',NULL,'1'),
 ('ROLE_MEMBER','会员',NULL,'2'),
 ('ROLE_MON_ADMIN','监控配置人员',NULL,'1'),
 ('ROLE_OPER','操作用户','ROLE_OPER','1'),
 ('ROLE_PLT','代码管理人员',NULL,'1'),
 ('ROLE_RPT','报表管理',NULL,'1'),
 ('ROLE_SUBSCRIPTION','公众号用户','ROLE_SUBSCRIPTION','1'),
 ('ROLE_USER','普通用户','ROLE_USER','1');
/*!40000 ALTER TABLE `youi_role` ENABLE KEYS */;


--
-- Definition of table `youi_role_page_element`
--

DROP TABLE IF EXISTS `youi_role_page_element`;
CREATE TABLE `youi_role_page_element` (
  `PAGE_ELEMENT_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  `MENU_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`PAGE_ELEMENT_ID`,`ROLE_ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单页面元素';

--
-- Dumping data for table `youi_role_page_element`
--

/*!40000 ALTER TABLE `youi_role_page_element` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_role_page_element` ENABLE KEYS */;


--
-- Definition of table `youi_rpt_cube`
--

DROP TABLE IF EXISTS `youi_rpt_cube`;
CREATE TABLE `youi_rpt_cube` (
  `CUBE_ID` varchar(36) NOT NULL,
  `CUBE_NAME` varchar(60) DEFAULT NULL,
  `CUBE_DATA` text,
  `DATA_SET_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`CUBE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920106立方体';

--
-- Dumping data for table `youi_rpt_cube`
--

/*!40000 ALTER TABLE `youi_rpt_cube` DISABLE KEYS */;
INSERT INTO `youi_rpt_cube` (`CUBE_ID`,`CUBE_NAME`,`CUBE_DATA`,`DATA_SET_ID`) VALUES 
 ('4028d08150d131c40150d14194a00006','userCube','{\"measures\":[{\"name\":\"USER_ID\",\"caption\":\"个数\",\"func\":null,\"measureExpression\":null,\"dataType\":null,\"calculated\":false},{\"name\":\"USER_NAME\",\"caption\":\"金额\",\"func\":null,\"measureExpression\":null,\"dataType\":null,\"calculated\":false}],\"groups\":[{\"name\":\"USER_ID\",\"caption\":\"用户ID\",\"columnName\":\"USER_ID\"},{\"name\":\"USER_NAME\",\"caption\":\"用户名\",\"columnName\":\"USER_NAME\"}]}','4028d08150d131c40150d13317df0001');
/*!40000 ALTER TABLE `youi_rpt_cube` ENABLE KEYS */;


--
-- Definition of table `youi_rpt_data_set`
--

DROP TABLE IF EXISTS `youi_rpt_data_set`;
CREATE TABLE `youi_rpt_data_set` (
  `DATA_SET_ID` varchar(36) NOT NULL,
  `DATA_SOURCE_ID` varchar(36) DEFAULT NULL,
  `DATA_SET_NAME` varchar(40) DEFAULT NULL,
  `DATA_SET_CAPTION` varchar(80) DEFAULT NULL,
  `DATA_SET_BEAN_NAME` varchar(80) DEFAULT NULL,
  `QUERY_SQL` varchar(800) DEFAULT NULL,
  PRIMARY KEY (`DATA_SET_ID`),
  KEY `FK_R_92_0101_0103` (`DATA_SOURCE_ID`),
  CONSTRAINT `FK_R_92_0101_0103` FOREIGN KEY (`DATA_SOURCE_ID`) REFERENCES `youi_rpt_data_source` (`DATA_SOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920103报表数据集';

--
-- Dumping data for table `youi_rpt_data_set`
--

/*!40000 ALTER TABLE `youi_rpt_data_set` DISABLE KEYS */;
INSERT INTO `youi_rpt_data_set` (`DATA_SET_ID`,`DATA_SOURCE_ID`,`DATA_SET_NAME`,`DATA_SET_CAPTION`,`DATA_SET_BEAN_NAME`,`QUERY_SQL`) VALUES 
 ('4028d08150d131c40150d13317df0001','4028d08150d073310150d074b6950001','users','用户数据集',NULL,'select'),
 ('4028d08150d131c40150d18f8f6f0007','4028d08150d073310150d074b6950001','roles','角色数据集',NULL,'select ');
/*!40000 ALTER TABLE `youi_rpt_data_set` ENABLE KEYS */;


--
-- Definition of table `youi_rpt_data_set_column`
--

DROP TABLE IF EXISTS `youi_rpt_data_set_column`;
CREATE TABLE `youi_rpt_data_set_column` (
  `COLUMN_ID` varchar(36) NOT NULL,
  `DATA_SET_ID` varchar(36) DEFAULT NULL,
  `COLUMN_NAME` varchar(40) DEFAULT NULL,
  `NAME` varchar(40) DEFAULT NULL,
  `COLUMN_CAPTION` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`COLUMN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920105数据集列';

--
-- Dumping data for table `youi_rpt_data_set_column`
--

/*!40000 ALTER TABLE `youi_rpt_data_set_column` DISABLE KEYS */;
INSERT INTO `youi_rpt_data_set_column` (`COLUMN_ID`,`DATA_SET_ID`,`COLUMN_NAME`,`NAME`,`COLUMN_CAPTION`) VALUES 
 ('4028d08150d131c40150d13317e30002','4028d08150d131c40150d13317df0001','USER_ID','userId','用户ID'),
 ('4028d08150d131c40150d13317e40003','4028d08150d131c40150d13317df0001','USER_NAME','userName','用户名'),
 ('4028d08150d131c40150d18f8f700008','4028d08150d131c40150d18f8f6f0007','ROLE_ID','roleId','角色主键'),
 ('4028d08150d131c40150d18f8f710009','4028d08150d131c40150d18f8f6f0007','ROLE_NAME','roleName','角色名');
/*!40000 ALTER TABLE `youi_rpt_data_set_column` ENABLE KEYS */;


--
-- Definition of table `youi_rpt_data_set_param`
--

DROP TABLE IF EXISTS `youi_rpt_data_set_param`;
CREATE TABLE `youi_rpt_data_set_param` (
  `PARAM_ID` varchar(36) NOT NULL,
  `DATA_SET_ID` varchar(36) DEFAULT NULL,
  `PARAM_NAME` varchar(60) DEFAULT NULL,
  `PARAM_CAPTION` varchar(100) DEFAULT NULL,
  `DATA_TYPE` varchar(20) DEFAULT NULL,
  `DATA_LENGTH` varchar(20) DEFAULT NULL,
  `DATA_PRECISION` varchar(20) DEFAULT NULL,
  `PARAM_NUM` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`PARAM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920104据集参数';

--
-- Dumping data for table `youi_rpt_data_set_param`
--

/*!40000 ALTER TABLE `youi_rpt_data_set_param` DISABLE KEYS */;
INSERT INTO `youi_rpt_data_set_param` (`PARAM_ID`,`DATA_SET_ID`,`PARAM_NAME`,`PARAM_CAPTION`,`DATA_TYPE`,`DATA_LENGTH`,`DATA_PRECISION`,`PARAM_NUM`) VALUES 
 ('4028d08150d131c40150d13317e40004','4028d08150d131c40150d13317df0001','userId','用户ID',NULL,NULL,NULL,'001'),
 ('4028d08150d131c40150d13317e50005','4028d08150d131c40150d13317df0001','userName','用户名',NULL,NULL,NULL,'002');
/*!40000 ALTER TABLE `youi_rpt_data_set_param` ENABLE KEYS */;


--
-- Definition of table `youi_rpt_data_source`
--

DROP TABLE IF EXISTS `youi_rpt_data_source`;
CREATE TABLE `youi_rpt_data_source` (
  `DATA_SOURCE_ID` varchar(32) NOT NULL,
  `DATA_SOURCE_NAME` varchar(40) DEFAULT NULL,
  `JDBC_USERNAME` varchar(60) DEFAULT NULL,
  `JDBC_PASSWORD` varchar(40) DEFAULT NULL,
  `JDBC_URL` varchar(800) DEFAULT NULL,
  `JDBC_DRIVER` varchar(100) DEFAULT NULL,
  `JDBC_DBTYPE` varchar(20) DEFAULT NULL,
  `JDBC_SCHEMA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DATA_SOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='jdbc.initialSize=0\r\njdbc.maxActive=20\r\njdbc.maxIdl';

--
-- Dumping data for table `youi_rpt_data_source`
--

/*!40000 ALTER TABLE `youi_rpt_data_source` DISABLE KEYS */;
INSERT INTO `youi_rpt_data_source` (`DATA_SOURCE_ID`,`DATA_SOURCE_NAME`,`JDBC_USERNAME`,`JDBC_PASSWORD`,`JDBC_URL`,`JDBC_DRIVER`,`JDBC_DBTYPE`,`JDBC_SCHEMA`) VALUES 
 ('4028d08150d073310150d074b6950001','youi2','youi2','eW91aTI=','jdbc:mysql://localhost:3306/youi2?useUnicode=true&amp;characterEncoding=utf-8','org.gjt.mm.mysql.Driver','mysql','youi2');
/*!40000 ALTER TABLE `youi_rpt_data_source` ENABLE KEYS */;


--
-- Definition of table `youi_rpt_folder`
--

DROP TABLE IF EXISTS `youi_rpt_folder`;
CREATE TABLE `youi_rpt_folder` (
  `RPT_FOLDER_ID` varchar(32) NOT NULL,
  `RPT_FOLDER_NAME` varchar(40) DEFAULT NULL,
  `RPT_FOLDER_CAPTION` varchar(80) DEFAULT NULL,
  `RPT_FOLDER_PID` varchar(32) DEFAULT NULL,
  `RPT_FOLDER_PATH` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`RPT_FOLDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920102报表文件夹';

--
-- Dumping data for table `youi_rpt_folder`
--

/*!40000 ALTER TABLE `youi_rpt_folder` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_rpt_folder` ENABLE KEYS */;


--
-- Definition of table `youi_service`
--

DROP TABLE IF EXISTS `youi_service`;
CREATE TABLE `youi_service` (
  `SERVICE_ID` varchar(36) NOT NULL,
  `SERVICE_INTERFACE_ID` varchar(36) DEFAULT NULL,
  `SERVICE_NAME` varchar(40) DEFAULT NULL,
  `SERVICE_CODE` varchar(20) DEFAULT NULL,
  `SERVICE_CAPTION` varchar(80) DEFAULT NULL,
  `REQ_XML` text,
  PRIMARY KEY (`SERVICE_ID`),
  KEY `FK_R_90_0202_0201` (`SERVICE_INTERFACE_ID`),
  CONSTRAINT `FK_R_90_0202_0201` FOREIGN KEY (`SERVICE_INTERFACE_ID`) REFERENCES `youi_service_interface` (`SERVICE_INTERFACE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900201交易';

--
-- Dumping data for table `youi_service`
--

/*!40000 ALTER TABLE `youi_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_service` ENABLE KEYS */;


--
-- Definition of table `youi_service_interface`
--

DROP TABLE IF EXISTS `youi_service_interface`;
CREATE TABLE `youi_service_interface` (
  `SERVICE_INTERFACE_ID` varchar(36) NOT NULL,
  `INTERFACE_GROUP_ID` varchar(36) DEFAULT NULL,
  `SERVICE_INTERFACE_NAME` varchar(80) DEFAULT NULL,
  `SERVICE_INTERFACE_CAPTION` varchar(80) DEFAULT NULL,
  `SERVICE_XML` text,
  PRIMARY KEY (`SERVICE_INTERFACE_ID`),
  KEY `FK_R_90_0204_0202` (`INTERFACE_GROUP_ID`),
  CONSTRAINT `FK_R_90_0204_0202` FOREIGN KEY (`INTERFACE_GROUP_ID`) REFERENCES `youi_service_interface_group` (`INTERFACE_GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务接口';

--
-- Dumping data for table `youi_service_interface`
--

/*!40000 ALTER TABLE `youi_service_interface` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_service_interface` ENABLE KEYS */;


--
-- Definition of table `youi_service_interface_group`
--

DROP TABLE IF EXISTS `youi_service_interface_group`;
CREATE TABLE `youi_service_interface_group` (
  `INTERFACE_GROUP_ID` varchar(36) NOT NULL,
  `INTERFACE_GROUP_CAPTION` varchar(80) DEFAULT NULL,
  `CHANNEL_NAME` varchar(40) DEFAULT NULL,
  `INTERFACE_TYPE` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`INTERFACE_GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='900204接口组';

--
-- Dumping data for table `youi_service_interface_group`
--

/*!40000 ALTER TABLE `youi_service_interface_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_service_interface_group` ENABLE KEYS */;


--
-- Definition of table `youi_service_param`
--

DROP TABLE IF EXISTS `youi_service_param`;
CREATE TABLE `youi_service_param` (
  `PARAM_ID` varchar(36) NOT NULL,
  `SERVICE_ID` varchar(36) DEFAULT NULL,
  `PARAM_NAME` varchar(20) DEFAULT NULL,
  `PARAM_CAPTION` varchar(80) DEFAULT NULL,
  `PARAM_TYPE` varchar(20) DEFAULT NULL COMMENT '上行报文，上行二维报文，下行报文，下行二维报文',
  `PARAM_XPATH` varchar(800) DEFAULT NULL,
  `DATA_TYPE` varchar(800) DEFAULT NULL,
  `DATA_LENGTH` varchar(20) DEFAULT NULL,
  `INPUT_TYPE` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`PARAM_ID`),
  KEY `FK_R_90_0201_0203` (`SERVICE_ID`),
  CONSTRAINT `FK_R_90_0201_0203` FOREIGN KEY (`SERVICE_ID`) REFERENCES `youi_service` (`SERVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口输入输出参数\r\n输入：上行报文，上行二维报文\r\n输出：下行报文，下行二维报文';

--
-- Dumping data for table `youi_service_param`
--

/*!40000 ALTER TABLE `youi_service_param` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_service_param` ENABLE KEYS */;


--
-- Definition of table `youi_table_seq`
--

DROP TABLE IF EXISTS `youi_table_seq`;
CREATE TABLE `youi_table_seq` (
  `SEQ_ID` varchar(36) NOT NULL,
  `SEQ_NO` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`SEQ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `youi_table_seq`
--

/*!40000 ALTER TABLE `youi_table_seq` DISABLE KEYS */;
INSERT INTO `youi_table_seq` (`SEQ_ID`,`SEQ_NO`) VALUES 
 ('codeProjectSno',21),
 ('flowno',47201);
/*!40000 ALTER TABLE `youi_table_seq` ENABLE KEYS */;


--
-- Definition of table `youi_tree_data`
--

DROP TABLE IF EXISTS `youi_tree_data`;
CREATE TABLE `youi_tree_data` (
  `TREE_DATA_ID` varchar(36) NOT NULL,
  `TREE_DATA_CODE` varchar(80) DEFAULT NULL,
  `TREE_DATA_CAPTION` varchar(100) DEFAULT NULL,
  `TREE_DATA_PID` varchar(36) DEFAULT NULL,
  `TREE_NAME` varchar(20) DEFAULT NULL,
  `TREE_STYLE` varchar(60) DEFAULT NULL,
  `TREE_LEVEL` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`TREE_DATA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='990103树型结构数据';

--
-- Dumping data for table `youi_tree_data`
--

/*!40000 ALTER TABLE `youi_tree_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_tree_data` ENABLE KEYS */;


--
-- Definition of table `youi_user`
--

DROP TABLE IF EXISTS `youi_user`;
CREATE TABLE `youi_user` (
  `USER_ID` varchar(32) NOT NULL,
  `AGENCY_ID` varchar(32) DEFAULT NULL,
  `LOGIN_NAME` varchar(20) DEFAULT NULL,
  `USER_CAPTION` varchar(80) DEFAULT NULL,
  `PASSWORD` varchar(40) DEFAULT NULL,
  `USER_ACTIVE` int(11) DEFAULT NULL,
  `INIT_PASSWORD` varchar(20) DEFAULT NULL,
  `USER_GROUP` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='910102用户';

--
-- Dumping data for table `youi_user`
--

/*!40000 ALTER TABLE `youi_user` DISABLE KEYS */;
INSERT INTO `youi_user` (`USER_ID`,`AGENCY_ID`,`LOGIN_NAME`,`USER_CAPTION`,`PASSWORD`,`USER_ACTIVE`,`INIT_PASSWORD`,`USER_GROUP`) VALUES 
 ('1','010100','zhouyi','zhouyi','e10adc3949ba59abbe56e057f20f883e',1,'1','001'),
 ('2','010200','user','user','e10adc3949ba59abbe56e057f20f883e',1,'3','001'),
 ('2c8a624651a02e070151a0369b990002',NULL,'act','act','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL),
 ('4028d08150a8de7a0150a8df35460001','010100','flower','流程管理人员','e10adc3949ba59abbe56e057f20f883e',1,'2','002'),
 ('4028d08150a8de7a0150a9f25ea20002','010200','reporter','报表管理人员','e10adc3949ba59abbe56e057f20f883e',1,'4','003'),
 ('4028d08150a8de7a0150a9f4827e0003','010300','project','代码管理人员','e10adc3949ba59abbe56e057f20f883e',0,'5','003'),
 ('4028d08150b7055b0150b71bc0e20001','010100','zhangsan','张三','e10adc3949ba59abbe56e057f20f883e',1,'6','003'),
 ('4028d08150b7055b0150b71bc0e20002','010100','lisi','李四','e10adc3949ba59abbe56e057f20f883e',1,'7','003'),
 ('4028d08150e665930150e679d6fa0001',NULL,'esber','服务治理管理员1','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL),
 ('4028d081515856100151586ba71f0001',NULL,'mon','mon','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL);
/*!40000 ALTER TABLE `youi_user` ENABLE KEYS */;


--
-- Definition of table `youi_user_config_item`
--

DROP TABLE IF EXISTS `youi_user_config_item`;
CREATE TABLE `youi_user_config_item` (
  `USER_CONFIG_ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  `USER_CONFIG_NAME` varchar(20) DEFAULT NULL,
  `USER_CONFIG_CAPTION` varchar(80) DEFAULT NULL,
  `USER_CONFIG_VALUE` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`USER_CONFIG_ID`),
  KEY `FK_R_91_0102_0103` (`USER_ID`),
  CONSTRAINT `FK_R_91_0102_0103` FOREIGN KEY (`USER_ID`) REFERENCES `youi_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='910103用户配置项';

--
-- Dumping data for table `youi_user_config_item`
--

/*!40000 ALTER TABLE `youi_user_config_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_user_config_item` ENABLE KEYS */;


--
-- Definition of table `youi_wx_custom_message`
--

DROP TABLE IF EXISTS `youi_wx_custom_message`;
CREATE TABLE `youi_wx_custom_message` (
  `CUSTOME_MSG_ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `MESSAGE_ID` varchar(36) DEFAULT NULL,
  `OPENID` varchar(36) DEFAULT NULL,
  `MSG_STATUS` varchar(3) DEFAULT NULL,
  `MSG_SEND_TIME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CUSTOME_MSG_ID`),
  KEY `FK_R_70_0101_0305` (`USER_ID`),
  KEY `FK_R_70_0303_0305` (`MESSAGE_ID`),
  CONSTRAINT `FK_R_70_0101_0305` FOREIGN KEY (`USER_ID`) REFERENCES `youi_wx_subscription` (`USER_ID`),
  CONSTRAINT `FK_R_70_0303_0305` FOREIGN KEY (`MESSAGE_ID`) REFERENCES `youi_wx_message` (`MESSAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='700305客服消息记录';

--
-- Dumping data for table `youi_wx_custom_message`
--

/*!40000 ALTER TABLE `youi_wx_custom_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_wx_custom_message` ENABLE KEYS */;


--
-- Definition of table `youi_wx_district`
--

DROP TABLE IF EXISTS `youi_wx_district`;
CREATE TABLE `youi_wx_district` (
  `DISTRICT_ID` varchar(36) NOT NULL,
  `COUNTRY` varchar(100) DEFAULT NULL,
  `PROVINCE` varchar(100) DEFAULT NULL,
  `CITY` varchar(100) DEFAULT NULL,
  `COUNTRY_EN` varchar(100) DEFAULT NULL,
  `PROVINCE_EN` varchar(100) DEFAULT NULL,
  `CITY_EN` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DISTRICT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='700104微信行政区划';

--
-- Dumping data for table `youi_wx_district`
--

/*!40000 ALTER TABLE `youi_wx_district` DISABLE KEYS */;
INSERT INTO `youi_wx_district` (`DISTRICT_ID`,`COUNTRY`,`PROVINCE`,`CITY`,`COUNTRY_EN`,`PROVINCE_EN`,`CITY_EN`) VALUES 
 ('1001','中国','四川','凉山','China','Sichuan','Liangshan Yi Autonomous Prefecture'),
 ('1002','中国','四川','资阳','China','Sichuan','Ziyang'),
 ('1003','中国','四川','成都','China','Sichuan','Chengdu'),
 ('1004','中国','四川','自贡','China','Sichuan','Zigong'),
 ('1005','中国','四川','泸州','China','Sichuan','Luzhou'),
 ('1006','中国','四川','攀枝花','China','Sichuan','Panzhihua'),
 ('1007','中国','四川','绵阳','China','Sichuan','Mianyang'),
 ('1008','中国','四川','德阳','China','Sichuan','Deyang'),
 ('1009','中国','四川','遂宁','China','Sichuan','Suining'),
 ('1010','中国','四川','广元','China','Sichuan','Guangyuan'),
 ('1011','中国','四川','乐山','China','Sichuan','Leshan'),
 ('1012','中国','四川','内江','China','Sichuan','Neijiang'),
 ('1013','中国','四川','南充','China','Sichuan','Nancong'),
 ('1014','中国','四川','宜宾','China','Sichuan','Yibin'),
 ('1015','中国','四川','眉山','China','Sichuan','Meishan'),
 ('1016','中国','四川','达州','China','Sichuan','Dazhou'),
 ('1017','中国','四川','广安','China','Sichuan','Guang\'an'),
 ('1018','中国','四川','巴中','China','Sichuan','Bazhong'),
 ('1019','中国','四川','雅安','China','Sichuan','Ya\'an'),
 ('1020','中国','四川','甘孜','China','Sichuan','Garze Tibetan Autonomous Prefecture'),
 ('1021','中国','四川','阿坝','China','Sichuan','Aba Tibetan-Qiang Autonomous Prefecture'),
 ('1022','中国','重庆','酉阳','China','Chongqing','Youyang Tujia-Miao Autonomous Country'),
 ('1023','中国','重庆','彭水','China','Chongqing','Pengshui Miao-Tujia Autonomous Country'),
 ('1024','中国','重庆','合川','China','Chongqing','Hechuan'),
 ('1025','中国','重庆','永川','China','Chongqing','Yongchuan'),
 ('1026','中国','重庆','江津','China','Chongqing','Jiangjin'),
 ('1027','中国','重庆','南川','China','Chongqing','Nanchuan'),
 ('1028','中国','重庆','铜梁','China','Chongqing','Tongliang'),
 ('1029','中国','重庆','大足','China','Chongqing','Dazu'),
 ('1030','中国','重庆','荣昌','China','Chongqing','Rongchang'),
 ('1031','中国','重庆','璧山','China','Chongqing','Bishan'),
 ('1032','中国','重庆','长寿','China','Chongqing','Changshou'),
 ('1033','中国','重庆','綦江','China','Chongqing','Qijiang'),
 ('1034','中国','重庆','潼南','China','Chongqing','Tongnan'),
 ('1035','中国','重庆','梁平','China','Chongqing','Liangping'),
 ('1036','中国','重庆','城口','China','Chongqing','Chengkou'),
 ('1037','中国','重庆','石柱','China','Chongqing','Shizhu Tujia Autonomous Country'),
 ('1038','中国','重庆','秀山','China','Chongqing','Xiushan Tujia-Miao Autonomous Country'),
 ('1039','中国','重庆','万州','China','Chongqing','Wanzhou'),
 ('1040','中国','重庆','渝中','China','Chongqing','Yuzhong'),
 ('1041','中国','重庆','涪陵','China','Chongqing','Fuling'),
 ('1042','中国','重庆','江北','China','Chongqing','Jiangbei'),
 ('1043','中国','重庆','大渡口','China','Chongqing','Dadukou'),
 ('1044','中国','重庆','九龙坡','China','Chongqing','Jiulongpo'),
 ('1045','中国','重庆','沙坪坝','China','Chongqing','Shapingba'),
 ('1046','中国','重庆','北碚','China','Chongqing','Beibei'),
 ('1047','中国','重庆','南岸','China','Chongqing','Nan\'an'),
 ('1048','中国','重庆','黔江','China','Chongqing','Qianjiang'),
 ('1049','中国','重庆','巫溪','China','Chongqing','Wuxi'),
 ('1050','中国','重庆','双桥','China','Chongqing','Shuangqiao'),
 ('1051','中国','重庆','万盛','China','Chongqing','Wansheng'),
 ('1052','中国','重庆','巴南','China','Chongqing','Ba\'nan'),
 ('1053','中国','重庆','渝北','China','Chongqing','Yubei'),
 ('1054','中国','重庆','忠县','China','Chongqing','Zhongxian'),
 ('1055','中国','重庆','武隆','China','Chongqing','Wulong'),
 ('1056','中国','重庆','垫江','China','Chongqing','Dianjiang'),
 ('1057','中国','重庆','丰都','China','Chongqing','Fengdu'),
 ('1058','中国','重庆','巫山','China','Chongqing','Wushan'),
 ('1059','中国','重庆','奉节','China','Chongqing','Fengjie'),
 ('1060','中国','重庆','云阳','China','Chongqing','Yunyang'),
 ('1061','中国','重庆','开县','China','Chongqing','Kaixian'),
 ('1062','中国','陕西','商洛','China','Shaanxi','Shangluo'),
 ('1063','中国','陕西','西安','China','Shaanxi','Xi\'an'),
 ('1064','中国','陕西','宝鸡','China','Shaanxi','Baoji'),
 ('1065','中国','陕西','铜川','China','Shaanxi','Tongchuan'),
 ('1066','中国','陕西','渭南','China','Shaanxi','Weinan'),
 ('1067','中国','陕西','咸阳','China','Shaanxi','Xianyang'),
 ('1068','中国','陕西','汉中','China','Shaanxi','Hanzhong'),
 ('1069','中国','陕西','延安','China','Shaanxi','Yan\'an'),
 ('1070','中国','陕西','安康','China','Shaanxi','Ankang'),
 ('1071','中国','陕西','榆林','China','Shaanxi','Yulin'),
 ('1072','中国','甘肃','定西','China','Gansu','Dingxi'),
 ('1073','中国','甘肃','庆阳','China','Gansu','Qingyang'),
 ('1074','中国','甘肃','陇南','China','Gansu','Longnan'),
 ('1075','中国','甘肃','甘南','China','Gansu','Gannan Tibetan Autonomous Prefecture'),
 ('1076','中国','甘肃','临夏','China','Gansu','Linxia Hui Autonomous Prefecture'),
 ('1077','中国','甘肃','兰州','China','Gansu','Lanzhou'),
 ('1078','中国','甘肃','金昌','China','Gansu','Baiyin'),
 ('1079','中国','甘肃','嘉峪关','China','Gansu','Jinchang'),
 ('1080','中国','甘肃','天水','China','Gansu','Jiayuguan'),
 ('1081','中国','甘肃','白银','China','Gansu','Tianshui'),
 ('1082','中国','甘肃','张掖','China','Gansu','Zhangye'),
 ('1083','中国','甘肃','武威','China','Gansu','Wuwei'),
 ('1084','中国','甘肃','酒泉','China','Gansu','Jiuquan'),
 ('1085','中国','甘肃','平凉','China','Gansu','Pingliang'),
 ('1086','中国','青海','海南','China','Qinghai','Hainan Tibetan Autonomous Prefecture'),
 ('1087','中国','青海','果洛','China','Qinghai','Guoluo Tibetan Autonomous Prefecture'),
 ('1088','中国','青海','玉树','China','Qinghai','Yushu Tibetan Autonomous Prefecture'),
 ('1089','中国','青海','海东','China','Qinghai','Haidong'),
 ('1090','中国','青海','海北','China','Qinghai','Haibei Tibetan Autonomous Prefecture'),
 ('1091','中国','青海','黄南','China','Qinghai','Huangnan Tibetan Autonomous Prefecture'),
 ('1092','中国','青海','海西','China','Qinghai','Haixi Mongol-Tibetan Autonomous Prefecture'),
 ('1093','中国','青海','西宁','China','Qinghai','Xining'),
 ('1094','中国','宁夏','银川','China','Ningxia','Yinchuan'),
 ('1095','中国','宁夏','吴忠','China','Ningxia','Wuzhong'),
 ('1096','中国','宁夏','石嘴山','China','Ningxia','Shizuishan'),
 ('1097','中国','宁夏','中卫','China','Ningxia','Zhongwei'),
 ('1098','中国','宁夏','固原','China','Ningxia','Guyuan'),
 ('1099','中国','云南','红河','China','Yunnan','Honghe Hani-Yi Autonomous Prefecture'),
 ('1100','中国','云南','文山','China','Yunnan','Wenshan Zhuang-Miao Autonomous Prefecture'),
 ('1101','中国','云南','楚雄','China','Yunnan','Chuxiong Yi Autonomous Prefecture'),
 ('1102','中国','云南','怒江','China','Yunnan','Nujiang Lisu Autonomous Prefecture'),
 ('1103','中国','云南','德宏','China','Yunnan','Dehong Dai-Jingpo Autonomous Prefecture'),
 ('1104','中国','云南','西双版纳','China','Yunnan','Xishuangbanna Dai Autonomous Prefecture'),
 ('1105','中国','云南','大理','China','Yunnan','Dali Bai Autonomous Prefecture'),
 ('1106','中国','云南','迪庆','China','Yunnan','Diqing Tibetan Autonomous Prefecture'),
 ('1107','中国','云南','昆明','China','Yunnan','Kunming'),
 ('1108','中国','云南','曲靖','China','Yunnan','Qujing'),
 ('1109','中国','云南','保山','China','Yunnan','Baoshan'),
 ('1110','中国','云南','玉溪','China','Yunnan','Yuxi'),
 ('1111','中国','云南','丽江','China','Yunnan','Lijiang'),
 ('1112','中国','云南','昭通','China','Yunnan','Zhaotong'),
 ('1113','中国','云南','临沧','China','Yunnan','Lincang'),
 ('1114','中国','云南','普洱','China','Yunnan','Pu\'er'),
 ('1115','中国','澳门','None','China','Macao','SAR None'),
 ('1116','中国','贵州','毕节','China','Guizhou','Bijie'),
 ('1117','中国','贵州','黔东南','China','Guizhou','Qiandongnan Miao-Dong Autonomous Prefecture'),
 ('1118','中国','贵州','黔南','China','Guizhou','Qiannan Buyi Autonomous Prefecture'),
 ('1119','中国','贵州','铜仁','China','Guizhou','Tongren'),
 ('1120','中国','贵州','黔西南','China','Guizhou','Qianxinan Buyi-Miao Autonomous Prefecture'),
 ('1121','中国','贵州','贵阳','China','Guizhou','Guiyang'),
 ('1122','中国','贵州','遵义','China','Guizhou','Zunyi'),
 ('1123','中国','贵州','六盘水','China','Guizhou','Liupanshui'),
 ('1124','中国','贵州','安顺','China','Guizhou','Anshun'),
 ('1125','中国','香港','None','China','Hongkong','SAR None'),
 ('1126','中国','辽宁','盘锦','China','Liaoning','Panjin'),
 ('1127','中国','辽宁','辽阳','China','Liaoning','Liaoyang'),
 ('1128','中国','辽宁','朝阳','China','Liaoning','Chaoyang'),
 ('1129','中国','辽宁','铁岭','China','Liaoning','Tieling'),
 ('1130','中国','辽宁','葫芦岛','China','Liaoning','Huludao'),
 ('1131','中国','辽宁','沈阳','China','Liaoning','Shenyang'),
 ('1132','中国','辽宁','鞍山','China','Liaoning','Anshan'),
 ('1133','中国','辽宁','大连','China','Liaoning','Dalian'),
 ('1134','中国','辽宁','本溪','China','Liaoning','Benxi'),
 ('1135','中国','辽宁','抚顺','China','Liaoning','Fushun'),
 ('1136','中国','辽宁','锦州','China','Liaoning','Jinzhou'),
 ('1137','中国','辽宁','丹东','China','Liaoning','Dandong'),
 ('1138','中国','辽宁','阜新','China','Liaoning','Fuxin'),
 ('1139','中国','辽宁','营口','China','Liaoning','Yingkou'),
 ('1140','中国','吉林','延边','China','Jilin','Yanbian Korean Autonomous Prefecture'),
 ('1141','中国','吉林','长春','China','Jilin','Changchun'),
 ('1142','中国','吉林','四平','China','Jilin','Siping'),
 ('1143','中国','吉林','吉林','China','Jilin','Jilin'),
 ('1144','中国','吉林','通化','China','Jilin','Tonghua'),
 ('1145','中国','吉林','辽源','China','Jilin','Liaoyuan'),
 ('1146','中国','吉林','松原','China','Jilin','Songyuan'),
 ('1147','中国','吉林','白山','China','Jilin','Baishan'),
 ('1148','中国','吉林','白城','China','Jilin','Baicheng'),
 ('1149','中国','黑龙江','黑河','China','Heilongjiang','Heihe'),
 ('1150','中国','黑龙江','牡丹江','China','Heilongjiang','Mudanjiang'),
 ('1151','中国','黑龙江','绥化','China','Heilongjiang','Suihua'),
 ('1152','中国','黑龙江','哈尔滨','China','Heilongjiang','Harbin'),
 ('1153','中国','黑龙江','大兴安岭','China','Heilongjiang','Da Hinggan Ling'),
 ('1154','中国','黑龙江','鸡西','China','Heilongjiang','Jixi'),
 ('1155','中国','黑龙江','齐齐哈尔','China','Heilongjiang','Qiqihar'),
 ('1156','中国','黑龙江','双鸭山','China','Heilongjiang','Shuangyashan'),
 ('1157','中国','黑龙江','鹤岗','China','Heilongjiang','Hegang'),
 ('1158','中国','黑龙江','伊春','China','Heilongjiang','Yichun'),
 ('1159','中国','黑龙江','大庆','China','Heilongjiang','Daqing'),
 ('1160','中国','黑龙江','七台河','China','Heilongjiang','Qitaihe'),
 ('1161','中国','黑龙江','佳木斯','China','Heilongjiang','Jiamusi'),
 ('1162','中国','海南','乐东','China','Hainan','Ledong Li Autonomous County'),
 ('1163','中国','海南','昌江','China','Hainan','Jiang Li Autonomous County'),
 ('1164','中国','海南','白沙','China','Hainan','Baisha Li Autonomous County'),
 ('1165','中国','海南','西沙','China','Hainan','Xisha Qundao'),
 ('1166','中国','海南','琼中','China','Hainan','Qiongzhong Li-Miao Autonomous County'),
 ('1167','中国','海南','保亭','China','Hainan','Baoting Li-Miao Autonomous County'),
 ('1168','中国','海南','陵水','China','Hainan','Lingshui Li Autonomous County'),
 ('1169','中国','海南','中沙','China','Hainan','Zhongsha Qundao'),
 ('1170','中国','海南','南沙','China','Hainan','Nansha Qundao'),
 ('1171','中国','海南','海口','China','Hainan','Haikou'),
 ('1172','中国','海南','三亚','China','Hainan','Sanya'),
 ('1173','中国','海南','五指山','China','Hainan','Wuzhishan'),
 ('1174','中国','海南','儋州','China','Hainan','Danzhou'),
 ('1175','中国','海南','琼海','China','Hainan','Qionghai'),
 ('1176','中国','海南','文昌','China','Hainan','Wenchang'),
 ('1177','中国','海南','东方','China','Hainan','Dongfang'),
 ('1178','中国','海南','万宁','China','Hainan','Wanning'),
 ('1179','中国','海南','定安','China','Hainan','Ding\'an'),
 ('1180','中国','海南','屯昌','China','Hainan','Tunchang'),
 ('1181','中国','海南','澄迈','China','Hainan','Cengmai'),
 ('1182','中国','海南','临高','China','Hainan','Lingao'),
 ('1183','中国','广东','揭阳','China','Guangdong','Jieyang'),
 ('1184','中国','广东','中山','China','Guangdong','Zhongshan'),
 ('1185','中国','广东','广州','China','Guangdong','Guangzhou'),
 ('1186','中国','广东','深圳','China','Guangdong','Shenzhen'),
 ('1187','中国','广东','韶关','China','Guangdong','Shaoguan'),
 ('1188','中国','广东','汕头','China','Guangdong','Shantou'),
 ('1189','中国','广东','珠海','China','Guangdong','Zhuhai'),
 ('1190','中国','广东','江门','China','Guangdong','Jiangmen'),
 ('1191','中国','广东','佛山','China','Guangdong','Foshan'),
 ('1192','中国','广东','茂名','China','Guangdong','Maoming'),
 ('1193','中国','广东','湛江','China','Guangdong','Zhanjiang'),
 ('1194','中国','广东','惠州','China','Guangdong','Huizhou'),
 ('1195','中国','广东','肇庆','China','Guangdong','Zhaoqing'),
 ('1196','中国','广东','汕尾','China','Guangdong','Shanwei'),
 ('1197','中国','广东','梅州','China','Guangdong','Meizhou'),
 ('1198','中国','广东','阳江','China','Guangdong','Yangjiang'),
 ('1199','中国','广东','河源','China','Guangdong','Heyuan'),
 ('1200','中国','广东','东莞','China','Guangdong','Dongguan'),
 ('1201','中国','广东','清远','China','Guangdong','Qingyuan'),
 ('1202','中国','广东','潮州','China','Guangdong','Chaozhou'),
 ('1203','中国','广东','云浮','China','Guangdong','Yunfu'),
 ('1204','中国','广西','贺州','China','Guangxi','Hezhou'),
 ('1205','中国','广西','百色','China','Guangxi','Baise'),
 ('1206','中国','广西','来宾','China','Guangxi','Laibin'),
 ('1207','中国','广西','河池','China','Guangxi','Hechi'),
 ('1208','中国','广西','崇左','China','Guangxi','Chongzuo'),
 ('1209','中国','广西','南宁','China','Guangxi','Nanning'),
 ('1210','中国','广西','桂林','China','Guangxi','Guilin'),
 ('1211','中国','广西','柳州','China','Guangxi','Liuzhou'),
 ('1212','中国','广西','北海','China','Guangxi','Beihai'),
 ('1213','中国','广西','梧州','China','Guangxi','Wuzhou'),
 ('1214','中国','广西','钦州','China','Guangxi','Qinzhou'),
 ('1215','中国','广西','防城港','China','Guangxi','Fangchenggang'),
 ('1216','中国','广西','玉林','China','Guangxi','Yulin'),
 ('1217','中国','广西','贵港','China','Guangxi','Guigang'),
 ('1218','中国','湖北','黄冈','China','Hubei','Huanggang'),
 ('1219','中国','湖北','荆州','China','Hubei','Jingzhou'),
 ('1220','中国','湖北','随州','China','Hubei','Suizhou'),
 ('1221','中国','湖北','咸宁','China','Hubei','Xianning'),
 ('1222','中国','湖北','神农架','China','Hubei','Shennongjia'),
 ('1223','中国','湖北','恩施','China','Hubei','Enshi Tujia-Miao Autonomous Prefecture'),
 ('1224','中国','湖北','武汉','China','Hubei','Wuhan'),
 ('1225','中国','湖北','十堰','China','Hubei','Shiyan'),
 ('1226','中国','湖北','黄石','China','Hubei','Huangshi'),
 ('1227','中国','湖北','宜昌','China','Hubei','Yichang'),
 ('1228','中国','湖北','鄂州','China','Hubei','Ezhou'),
 ('1229','中国','湖北','襄樊','China','Hubei','Xiangyang'),
 ('1230','中国','湖北','孝感','China','Hubei','Xiaogan'),
 ('1231','中国','湖北','荆门','China','Hubei','Jingmen'),
 ('1232','中国','湖北','潜江','China','Hubei','Qianjiang'),
 ('1233','中国','湖北','仙桃','China','Hubei','Xiantao'),
 ('1234','中国','湖北','天门','China','Hubei','Tianmen'),
 ('1235','中国','湖南','永州','China','Hunan','Yongzhou'),
 ('1236','中国','湖南','郴州','China','Hunan','Chenzhou'),
 ('1237','中国','湖南','娄底','China','Hunan','Loudi'),
 ('1238','中国','湖南','怀化','China','Hunan','Huaihua'),
 ('1239','中国','湖南','湘西','China','Hunan','Xiangxi Tujia-Miao Autonomous Prefecture'),
 ('1240','中国','湖南','长沙','China','Hunan','Changsha'),
 ('1241','中国','湖南','湘潭','China','Hunan','Xiangtan'),
 ('1242','中国','湖南','株洲','China','Hunan','Zhuzhou'),
 ('1243','中国','湖南','邵阳','China','Hunan','Shaoyang'),
 ('1244','中国','湖南','衡阳','China','Hunan','Hengyang'),
 ('1245','中国','湖南','常德','China','Hunan','Changde'),
 ('1246','中国','湖南','岳阳','China','Hunan','Yueyang'),
 ('1247','中国','湖南','益阳','China','Hunan','Yiyang'),
 ('1248','中国','湖南','张家界','China','Hunan','Zhangjiajie'),
 ('1249','中国','河南','漯河','China','Henan','Luohe'),
 ('1250','中国','河南','许昌','China','Henan','Xuchang'),
 ('1251','中国','河南','南阳','China','Henan','Nanyang'),
 ('1252','中国','河南','三门峡','China','Henan','Sanmenxia'),
 ('1253','中国','河南','信阳','China','Henan','Xinyang'),
 ('1254','中国','河南','商丘','China','Henan','Shangqiu'),
 ('1255','中国','河南','驻马店','China','Henan','Zhumadian'),
 ('1256','中国','河南','周口','China','Henan','Zhoukou'),
 ('1257','中国','河南','济源','China','Henan','Jiyuan'),
 ('1258','中国','河南','郑州','China','Henan','Zhengzhou'),
 ('1259','中国','河南','洛阳','China','Henan','Luoyang'),
 ('1260','中国','河南','开封','China','Henan','Kaifeng'),
 ('1261','中国','河南','安阳','China','Henan','Anyang'),
 ('1262','中国','河南','平顶山','China','Henan','Pingdingshan'),
 ('1263','中国','河南','新乡','China','Henan','Xinxiang'),
 ('1264','中国','河南','鹤壁','China','Henan','Hebi'),
 ('1265','中国','河南','濮阳','China','Henan','Puyang'),
 ('1266','中国','河南','焦作','China','Henan','Jiaozuo'),
 ('1267','中国','台湾','屏东县','China','Taiwan','Pingtung County'),
 ('1268','中国','台湾','澎湖县','China','Taiwan','Penghu County'),
 ('1269','中国','台湾','台东县','China','Taiwan','Taitung County'),
 ('1270','中国','台湾','花莲县','China','Taiwan','Hualian County'),
 ('1271','中国','台湾','台北市','China','Taiwan','Taipei City'),
 ('1272','中国','台湾','基隆市','China','Taiwan','Keelung City'),
 ('1273','中国','台湾','高雄市','China','Taiwan','Kaohsiung City'),
 ('1274','中国','台湾','台南市','China','Taiwan','Tainan City'),
 ('1275','中国','台湾','台中市','China','Taiwan','Taichung City'),
 ('1276','中国','台湾','嘉义市','China','Taiwan','Chiayi City'),
 ('1277','中国','台湾','新竹市','China','Taiwan','Hsinchu City'),
 ('1278','中国','台湾','宜兰县','China','Taiwan','Ilan County'),
 ('1279','中国','台湾','台北县','China','Taiwan','Taipei County'),
 ('1280','中国','台湾','新竹县','China','Taiwan','Hsinchu County'),
 ('1281','中国','台湾','桃园县','China','Taiwan','Taoyuan County'),
 ('1282','中国','台湾','台中县','China','Taiwan','Taichung County'),
 ('1283','中国','台湾','苗栗县','China','Taiwan','Miaoli County'),
 ('1284','中国','台湾','南投县','China','Taiwan','Nantou County'),
 ('1285','中国','台湾','彰化县','China','Taiwan','Changhwa County'),
 ('1286','中国','台湾','嘉义县','China','Taiwan','Chiayi County'),
 ('1287','中国','台湾','云林县','China','Taiwan','Yunnlin County'),
 ('1288','中国','台湾','高雄县','China','Taiwan','Kaohsiung County'),
 ('1289','中国','台湾','台南县','China','Taiwan','Tainan County'),
 ('1290','中国','北京','房山','China','Beijing','Fangshan'),
 ('1291','中国','北京','大兴','China','Beijing','Daxing'),
 ('1292','中国','北京','顺义','China','Beijing','Shunyi'),
 ('1293','中国','北京','通州','China','Beijing','Tongzhou'),
 ('1294','中国','北京','昌平','China','Beijing','Changping'),
 ('1295','中国','北京','密云','China','Beijing','Miyun'),
 ('1296','中国','北京','平谷','China','Beijing','Pinggu'),
 ('1297','中国','北京','延庆','China','Beijing','Yanqing'),
 ('1298','中国','北京','东城','China','Beijing','Dongcheng'),
 ('1299','中国','北京','怀柔','China','Beijing','Huairou'),
 ('1300','中国','北京','崇文','China','Beijing','None'),
 ('1301','中国','北京','西城','China','Beijing','Xicheng'),
 ('1302','中国','北京','朝阳','China','Beijing','Chaoyang'),
 ('1303','中国','北京','宣武','China','Beijing','None'),
 ('1304','中国','北京','石景山','China','Beijing','Shijingshan'),
 ('1305','中国','北京','丰台','China','Beijing','Fengtai'),
 ('1306','中国','北京','门头沟','China','Beijing','Mentougou'),
 ('1307','中国','北京','海淀','China','Beijing','Haidian'),
 ('1308','中国','河北','衡水','China','Hebei','Hengshui'),
 ('1309','中国','河北','廊坊','China','Hebei','Langfang'),
 ('1310','中国','河北','石家庄','China','Hebei','Shijiazhuang'),
 ('1311','中国','河北','秦皇岛','China','Hebei','Qinhuangdao'),
 ('1312','中国','河北','唐山','China','Hebei','Tangshan'),
 ('1313','中国','河北','邢台','China','Hebei','Xingtai'),
 ('1314','中国','河北','邯郸','China','Hebei','Handan'),
 ('1315','中国','河北','张家口','China','Hebei','Zhangjiakou'),
 ('1316','中国','河北','保定','China','Hebei','Baoding'),
 ('1317','中国','河北','沧州','China','Hebei','Cangzhou'),
 ('1318','中国','河北','承德','China','Hebei','Chengde'),
 ('1319','中国','天津','西青','China','Tianjin','Xiqing'),
 ('1320','中国','天津','东丽','China','Tianjin','Dongli'),
 ('1321','中国','天津','北辰','China','Tianjin','Beichen'),
 ('1322','中国','天津','津南','China','Tianjin','Jinnan'),
 ('1323','中国','天津','宁河','China','Tianjin','Ninghe'),
 ('1324','中国','天津','武清','China','Tianjin','Wuqing'),
 ('1325','中国','天津','静海','China','Tianjin','Jinghai'),
 ('1326','中国','天津','宝坻','China','Tianjin','Baodi'),
 ('1327','中国','天津','和平','China','Tianjin','Heping'),
 ('1328','中国','天津','河西','China','Tianjin','Hexi'),
 ('1329','中国','天津','河东','China','Tianjin','Hedong'),
 ('1330','中国','天津','河北','China','Tianjin','Hebei'),
 ('1331','中国','天津','南开','China','Tianjin','Nankai'),
 ('1332','中国','天津','塘沽','China','Tianjin','None'),
 ('1333','中国','天津','红桥','China','Tianjin','Hongqiao'),
 ('1334','中国','天津','大港','China','Tianjin','None'),
 ('1335','中国','天津','汉沽','China','Tianjin','None'),
 ('1336','中国','天津','蓟县','China','Tianjin','Jixian'),
 ('1337','中国','内蒙古','锡林郭勒','China','Inner','Mongolia Xilin Gol'),
 ('1338','中国','内蒙古','兴安','China','Inner','Mongolia Xing\'an'),
 ('1339','中国','内蒙古','阿拉善','China','Inner','Mongolia Alxa'),
 ('1340','中国','内蒙古','呼和浩特','China','Inner','Mongolia Hohhot'),
 ('1341','中国','内蒙古','乌海','China','Inner','Mongolia Wuhai'),
 ('1342','中国','内蒙古','包头','China','Inner','Mongolia Baotou'),
 ('1343','中国','内蒙古','通辽','China','Inner','Mongolia Tongliao'),
 ('1344','中国','内蒙古','赤峰','China','Inner','Mongolia Chifeng'),
 ('1345','中国','内蒙古','呼伦贝尔','China','Inner','Mongolia Hulun Buir'),
 ('1346','中国','内蒙古','鄂尔多斯','China','Inner','Mongolia Ordos'),
 ('1347','中国','内蒙古','乌兰察布','China','Inner','Mongolia Ulan Qab'),
 ('1348','中国','内蒙古','巴彦淖尔','China','Inner','Mongolia Bayannur'),
 ('1349','中国','山西','吕梁','China','Shanxi','luliang'),
 ('1350','中国','山西','临汾','China','Shanxi','Linfen'),
 ('1351','中国','山西','太原','China','Shanxi','Taiyuan'),
 ('1352','中国','山西','阳泉','China','Shanxi','Yangquan'),
 ('1353','中国','山西','大同','China','Shanxi','Datong'),
 ('1354','中国','山西','晋城','China','Shanxi','Jincheng'),
 ('1355','中国','山西','长治','China','Shanxi','Changzhi'),
 ('1356','中国','山西','晋中','China','Shanxi','Jinzhong'),
 ('1357','中国','山西','朔州','China','Shanxi','Shuozhou'),
 ('1358','中国','山西','忻州','China','Shanxi','Xinzhou'),
 ('1359','中国','山西','运城','China','Shanxi','Yuncheng'),
 ('1360','中国','浙江','丽水','China','Zhejiang','Lishui'),
 ('1361','中国','浙江','台州','China','Zhejiang','Taizhou'),
 ('1362','中国','浙江','杭州','China','Zhejiang','Hangzhou'),
 ('1363','中国','浙江','温州','China','Zhejiang','Wenzhou'),
 ('1364','中国','浙江','宁波','China','Zhejiang','Ningbo'),
 ('1365','中国','浙江','湖州','China','Zhejiang','Huzhou'),
 ('1366','中国','浙江','嘉兴','China','Zhejiang','Jiaxing'),
 ('1367','中国','浙江','金华','China','Zhejiang','Jinhua'),
 ('1368','中国','浙江','绍兴','China','Zhejiang','Shaoxing'),
 ('1369','中国','浙江','舟山','China','Zhejiang','Zhoushan'),
 ('1370','中国','浙江','衢州','China','Zhejiang','Quzhou'),
 ('1371','中国','江苏','镇江','China','Jiangsu','Zhenjiang'),
 ('1372','中国','江苏','扬州','China','Jiangsu','Yangzhou'),
 ('1373','中国','江苏','宿迁','China','Jiangsu','Suqian'),
 ('1374','中国','江苏','泰州','China','Jiangsu','Taizhou'),
 ('1375','中国','江苏','南京','China','Jiangsu','Nanjing'),
 ('1376','中国','江苏','徐州','China','Jiangsu','Xuzhou'),
 ('1377','中国','江苏','无锡','China','Jiangsu','Wuxi'),
 ('1378','中国','江苏','苏州','China','Jiangsu','Suzhou'),
 ('1379','中国','江苏','常州','China','Jiangsu','Changzhou'),
 ('1380','中国','江苏','连云港','China','Jiangsu','Lianyungang'),
 ('1381','中国','江苏','南通','China','Jiangsu','Nantong'),
 ('1382','中国','江苏','盐城','China','Jiangsu','Yancheng'),
 ('1383','中国','江苏','淮安','China','Jiangsu','Huai\'an'),
 ('1384','中国','上海','杨浦','China','Shanghai','Yangpu'),
 ('1385','中国','上海','南汇','China','Shanghai','None'),
 ('1386','中国','上海','宝山','China','Shanghai','Baoshan'),
 ('1387','中国','上海','闵行','China','Shanghai','Minhang'),
 ('1388','中国','上海','浦东新','China','Shanghai','Pudongxin'),
 ('1389','中国','上海','嘉定','China','Shanghai','Jiading'),
 ('1390','中国','上海','松江','China','Shanghai','Songjiang'),
 ('1391','中国','上海','金山','China','Shanghai','Jinshan'),
 ('1392','中国','上海','崇明','China','Shanghai','Chongming'),
 ('1393','中国','上海','奉贤','China','Shanghai','Fengxian'),
 ('1394','中国','上海','青浦','China','Shanghai','Qingpu'),
 ('1395','中国','上海','黄浦','China','Shanghai','Huangpu'),
 ('1396','中国','上海','卢湾','China','Shanghai','Luwan'),
 ('1397','中国','上海','长宁','China','Shanghai','Changning'),
 ('1398','中国','上海','徐汇','China','Shanghai','Xuhui'),
 ('1399','中国','上海','普陀','China','Shanghai','Putuo'),
 ('1400','中国','上海','静安','China','Shanghai','Jing\'an'),
 ('1401','中国','上海','虹口','China','Shanghai','Hongkou'),
 ('1402','中国','上海','闸北','China','Shanghai','Zhabei'),
 ('1403','中国','山东','日照','China','Shandong','Rizhao'),
 ('1404','中国','山东','威海','China','Shandong','Weihai'),
 ('1405','中国','山东','临沂','China','Shandong','Linyi'),
 ('1406','中国','山东','莱芜','China','Shandong','Laiwu'),
 ('1407','中国','山东','聊城','China','Shandong','Liaocheng'),
 ('1408','中国','山东','德州','China','Shandong','Dezhou'),
 ('1409','中国','山东','菏泽','China','Shandong','Heze'),
 ('1410','中国','山东','滨州','China','Shandong','Binzhou'),
 ('1411','中国','山东','济南','China','Shandong','Jinan'),
 ('1412','中国','山东','淄博','China','Shandong','Zibo'),
 ('1413','中国','山东','青岛','China','Shandong','Qingdao'),
 ('1414','中国','山东','东营','China','Shandong','Dongying'),
 ('1415','中国','山东','枣庄','China','Shandong','Zaozhuang'),
 ('1416','中国','山东','潍坊','China','Shandong','Weifang'),
 ('1417','中国','山东','烟台','China','Shandong','Yantai'),
 ('1418','中国','山东','泰安','China','Shandong','Tai\'an'),
 ('1419','中国','山东','济宁','China','Shandong','Jining'),
 ('1420','中国','江西','上饶','China','Jiangxi','Shangrao'),
 ('1421','中国','江西','抚州','China','Jiangxi','Fuzhou'),
 ('1422','中国','江西','南昌','China','Jiangxi','Nanchang'),
 ('1423','中国','江西','萍乡','China','Jiangxi','Pingxiang'),
 ('1424','中国','江西','景德镇','China','Jiangxi','Jingdezhen'),
 ('1425','中国','江西','新余','China','Jiangxi','Xinyu'),
 ('1426','中国','江西','九江','China','Jiangxi','Jiujiang'),
 ('1427','中国','江西','赣州','China','Jiangxi','Ganzhou'),
 ('1428','中国','江西','鹰潭','China','Jiangxi','Yingtan'),
 ('1429','中国','江西','宜春','China','Jiangxi','Yichun'),
 ('1430','中国','江西','吉安','China','Jiangxi','Ji\'an'),
 ('1431','中国','福建','福州','China','Fujian','Fuzhou'),
 ('1432','中国','福建','莆田','China','Fujian','Putian'),
 ('1433','中国','福建','厦门','China','Fujian','Xiamen'),
 ('1434','中国','福建','泉州','China','Fujian','Quanzhou'),
 ('1435','中国','福建','三明','China','Fujian','Sanming'),
 ('1436','中国','福建','南平','China','Fujian','Nanping'),
 ('1437','中国','福建','漳州','China','Fujian','Zhangzhou'),
 ('1438','中国','福建','宁德','China','Fujian','Ningde'),
 ('1439','中国','福建','龙岩','China','Fujian','Longyan'),
 ('1440','中国','安徽','滁州','China','Anhui','Chuzhou'),
 ('1441','中国','安徽','黄山','China','Anhui','Huangshan'),
 ('1442','中国','安徽','宿州','China','Anhui','Suzhou'),
 ('1443','中国','安徽','阜阳','China','Anhui','Fuyang'),
 ('1444','中国','安徽','六安','China','Anhui','Lu\'an'),
 ('1445','中国','安徽','巢湖','China','Anhui','Chaohu'),
 ('1446','中国','安徽','池州','China','Anhui','Chizhou'),
 ('1447','中国','安徽','亳州','China','Anhui','Bozhou'),
 ('1448','中国','安徽','宣城','China','Anhui','Xuancheng'),
 ('1449','中国','安徽','合肥','China','Anhui','Hefei'),
 ('1450','中国','安徽','蚌埠','China','Anhui','Bengbu'),
 ('1451','中国','安徽','芜湖','China','Anhui','Wuhu'),
 ('1452','中国','安徽','马鞍山','China','Anhui','Ma\'anshan'),
 ('1453','中国','安徽','淮南','China','Anhui','Huainan'),
 ('1454','中国','安徽','铜陵','China','Anhui','Tongling'),
 ('1455','中国','安徽','淮北','China','Anhui','Huaibei'),
 ('1456','中国','安徽','安庆','China','Anhui','Anqing'),
 ('1457','中国','西藏','那曲','China','Tibet','Nagqu'),
 ('1458','中国','西藏','阿里','China','Tibet','Ngari'),
 ('1459','中国','西藏','林芝','China','Tibet','Nyingchi'),
 ('1460','中国','西藏','昌都','China','Tibet','Qamdo'),
 ('1461','中国','西藏','山南','China','Tibet','Shannan'),
 ('1462','中国','西藏','日喀则','China','Tibet','Xigaze'),
 ('1463','中国','西藏','拉萨','China','Tibet','Lhasa'),
 ('1464','中国','新疆','博尔塔拉','China','Xinjiang','Bortala Mongol Autonomous Prefecture'),
 ('1465','中国','新疆','吐鲁番','China','Xinjiang','Turpan'),
 ('1466','中国','新疆','哈密','China','Xinjiang','Hami'),
 ('1467','中国','新疆','昌吉','China','Xinjiang','Changji Hui Autonomous Prefecture'),
 ('1468','中国','新疆','和田','China','Xinjiang','Hotan'),
 ('1469','中国','新疆','喀什','China','Xinjiang','Kashi'),
 ('1470','中国','新疆','克孜勒苏','China','Xinjiang','Kizilsu Kirgiz Autonomous Prefecture'),
 ('1471','中国','新疆','巴音郭楞','China','Xinjiang','Bayingolin Mongol Autonomous Prefecture'),
 ('1472','中国','新疆','阿克苏','China','Xinjiang','Aksu'),
 ('1473','中国','新疆','伊犁','China','Xinjiang','Ili Kazakh Autonomous Prefecture'),
 ('1474','中国','新疆','塔城','China','Xinjiang','Tacheng'),
 ('1475','中国','新疆','乌鲁木齐','China','Xinjiang','Urumqi'),
 ('1476','中国','新疆','阿勒泰','China','Xinjiang','Altay'),
 ('1477','中国','新疆','克拉玛依','China','Xinjiang','Karamay'),
 ('1478','中国','新疆','石河子','China','Xinjiang','Shihezi'),
 ('1479','中国','新疆','图木舒克','China','Xinjiang','Tumsuk'),
 ('1480','中国','新疆','阿拉尔','China','Xinjiang','Alar'),
 ('1481','中国','新疆','五家渠','China','Xinjiang','Wujiaqu');
/*!40000 ALTER TABLE `youi_wx_district` ENABLE KEYS */;


--
-- Definition of table `youi_wx_follower`
--

DROP TABLE IF EXISTS `youi_wx_follower`;
CREATE TABLE `youi_wx_follower` (
  `OPENID` varchar(36) DEFAULT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `ID` varchar(36) DEFAULT NULL,
  `BLACKER` int(11) DEFAULT NULL,
  KEY `FK_R_70_0101_0202` (`USER_ID`),
  KEY `FK_R_70_0201_0202` (`OPENID`),
  KEY `FK_R_70_0203_0202` (`ID`),
  CONSTRAINT `FK_R_70_0101_0202` FOREIGN KEY (`USER_ID`) REFERENCES `youi_wx_subscription` (`USER_ID`),
  CONSTRAINT `FK_R_70_0201_0202` FOREIGN KEY (`OPENID`) REFERENCES `youi_wx_member` (`OPENID`),
  CONSTRAINT `FK_R_70_0203_0202` FOREIGN KEY (`ID`) REFERENCES `youi_wx_member_group` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='070202微信粉丝';

--
-- Dumping data for table `youi_wx_follower`
--

/*!40000 ALTER TABLE `youi_wx_follower` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_wx_follower` ENABLE KEYS */;


--
-- Definition of table `youi_wx_mass`
--

DROP TABLE IF EXISTS `youi_wx_mass`;
CREATE TABLE `youi_wx_mass` (
  `MASS_ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `TOTAL_COUNT` varchar(20) DEFAULT NULL,
  `LEFT_COUNT` varchar(20) DEFAULT NULL COMMENT '每日日终清0',
  PRIMARY KEY (`MASS_ID`),
  KEY `FK_R_70_0101_0301` (`USER_ID`),
  CONSTRAINT `FK_R_70_0101_0301` FOREIGN KEY (`USER_ID`) REFERENCES `youi_wx_subscription` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='700301群发管理';

--
-- Dumping data for table `youi_wx_mass`
--

/*!40000 ALTER TABLE `youi_wx_mass` DISABLE KEYS */;
INSERT INTO `youi_wx_mass` (`MASS_ID`,`USER_ID`,`TOTAL_COUNT`,`LEFT_COUNT`) VALUES 
 ('4028d081518ec22201518ed74a100002','4028d081518ba8ea01518beb97620001','1','1');
/*!40000 ALTER TABLE `youi_wx_mass` ENABLE KEYS */;


--
-- Definition of table `youi_wx_mass_log`
--

DROP TABLE IF EXISTS `youi_wx_mass_log`;
CREATE TABLE `youi_wx_mass_log` (
  `MASS_ID` varchar(36) NOT NULL,
  `YOU_MASS_ID` varchar(36) DEFAULT NULL,
  `MESSAGE_ID` varchar(36) DEFAULT NULL,
  `MASS_DATE` varchar(20) DEFAULT NULL,
  `MASS_STATUS` varchar(3) DEFAULT NULL,
  `MASS_TIME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`MASS_ID`),
  KEY `FK_R_70_0301_0302` (`YOU_MASS_ID`),
  KEY `FK_R_70_0303_0302` (`MESSAGE_ID`),
  CONSTRAINT `FK_R_70_0301_0302` FOREIGN KEY (`YOU_MASS_ID`) REFERENCES `youi_wx_mass` (`MASS_ID`),
  CONSTRAINT `FK_R_70_0303_0302` FOREIGN KEY (`MESSAGE_ID`) REFERENCES `youi_wx_message` (`MESSAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='700302群发记录';

--
-- Dumping data for table `youi_wx_mass_log`
--

/*!40000 ALTER TABLE `youi_wx_mass_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_wx_mass_log` ENABLE KEYS */;


--
-- Definition of table `youi_wx_media`
--

DROP TABLE IF EXISTS `youi_wx_media`;
CREATE TABLE `youi_wx_media` (
  `MEDIA_ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `MEDIA_CAPTION` varchar(100) DEFAULT NULL,
  `MEDIA_TYPE` varchar(20) DEFAULT NULL,
  `MEDIA_URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MEDIA_ID`),
  KEY `FK_R_70_0101_0304` (`USER_ID`),
  CONSTRAINT `FK_R_70_0101_0304` FOREIGN KEY (`USER_ID`) REFERENCES `youi_wx_subscription` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='700304图文素材';

--
-- Dumping data for table `youi_wx_media`
--

/*!40000 ALTER TABLE `youi_wx_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_wx_media` ENABLE KEYS */;


--
-- Definition of table `youi_wx_member`
--

DROP TABLE IF EXISTS `youi_wx_member`;
CREATE TABLE `youi_wx_member` (
  `OPENID` varchar(36) NOT NULL,
  `NICKNAME` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `SEX` varchar(3) DEFAULT NULL,
  `SUBSCRIBE` varchar(20) DEFAULT NULL,
  `LANGUAGE` varchar(100) DEFAULT NULL,
  `CITY` varchar(40) DEFAULT NULL,
  `PROVINCE` varchar(40) DEFAULT NULL,
  `COUNTRY` varchar(40) DEFAULT NULL,
  `HEADIMGURL` varchar(1024) DEFAULT NULL,
  `UNIONID` varchar(100) DEFAULT NULL,
  `REMARK` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`OPENID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储微信会员信息';

--
-- Dumping data for table `youi_wx_member`
--

/*!40000 ALTER TABLE `youi_wx_member` DISABLE KEYS */;
INSERT INTO `youi_wx_member` (`OPENID`,`NICKNAME`,`SEX`,`SUBSCRIBE`,`LANGUAGE`,`CITY`,`PROVINCE`,`COUNTRY`,`HEADIMGURL`,`UNIONID`,`REMARK`,`USER_ID`) VALUES 
 ('o34IKuL36RFCABfsdquh9gG3LY6Q','周毅','1','1','zh_CN','丰台','北京','中国','http://wx.qlogo.cn/mmopen/dTsbkkicficIqF89KfPy9QGUvLucYftUGcvAafBcJiaqR488NbcCwIFQYEr0JP23vlNKyY9QChpzpwHIYPxmhVzc28m5lTFmBRS/0',NULL,'','4028d081518ba8ea01518beb97620001'),
 ('oicG7wg22GN6D2SCH8WaCSz16X58','RONG.LXX','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6Qt54O7I5fwa608kaG4v3vSYBPrMnTrrLjJ7cibJyoMCB9pwNhenpJpvVNG4PB5Z59UzAup3avibI5/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgc8fzG5CH9EajiGp4oZbdA','天上虹','2','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6c5hbtWYJYkGWeNeTpBuuxYPIEsNbX9KTxBep1EoGXncvxUq3dOfuGqd0VM5gegDUCIZLujU6UcK/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgcB7Mhh1CQ12EK3T24R7rM','胡秀兰','2','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6ZmA40TrWyOZv0usib6hMxrTBu3dAs47KqMz8gQ8SRrko5icsm8JSlPliawiaMtVQNKwKfjXJWFibTkO9/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgcpCjpJBwmpIPR3XhyWRIQ','迟崇巍','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM7VgibtzdOpnZtcHdUiatibPDiaXPice4l5uGhjdZ8V2AeicvB4tR5Gx1gZnkYOwiadMBD4MOrNFSJMHMCow/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgdmEyV33v-8m0lKnA9j1jk','zoez','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6dRJM57NjM4Rwlyuqtonew5u5rd8nKKWpyauKHAMOa8bYay5ddibVx1TXNnVOLY6km1qsI2kH2LQp/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgDoabqnNHkI1X_OFrP_6VM','冻结','2','1','zh_CN','宿州','安徽','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4QMSfle06pc6RuyfKZJBp6ulQleZGMbKxMPUJIHr3ZM2DgH2HVEMZibIbznxGLWSHSQqYtZqcuGjY9JbSYFjtNc/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgea9RHG-lrOPNbryu-3cxo','树欲静而风不止','2','1','zh_CN','青岛','山东','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4riazZeqex045LwTUSX9LzwKtBD1uOby465cibGbFzFCPKoUo1OPmvCD5Qic545sTabHVX9gF9LiaeyYN/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgE_YAJa5xKHjSb_rzrszPI','折改梅','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5cc62BRCAQF1a6ccJHdWM14W4fr1xwFaZyaaJvRSglib9ZqfATicE5PJ6TMOcUreh7IOJ20IDHO5mpobqxFyGph2IK1dV9GupCc/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgHMufRXxxdmIDdPxuBHQBc','阿伦','1','1','zh_CN','南昌','江西','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6fHeE9DMwIiaW6JiaJia1ejCuhhwCF9FpWFicueDhtlvsK5J2eNl90z0kqvRHKqyNKpooHGns1YLibYpN/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgiehwv9ZPJu4EpW8Wy535M','nancy','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCNicsmc6OQH0K5T0QTuCEdY1rRgAQORrZicib5p4S6Pl7m4NANfX3sb4DN5Hwiagn0ibibacZOuGkwiaZbw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgiN4kWl9uNdZ-esyOXQN_Q','mooon','1','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1Icpn4bop1Ycbwib6YicBibZaKRiaGlu7DuEtcf5NWzTDGPVIjfPuWEibVHIrVwueO9kt7cuaODBf9Jcj7g/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgiPuqiiRjNxtLFcRb0X0mc','崎方','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GpdrE8JK6avqhnF91Xju5Nu1qjYTWlzPQc7k6aSliactNPdkykxTicBHCRibNZUvSibSGnaAbd9h6bNg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgJg_H3TmxazEbOEq8j-KTs','永泽','1','1','zh_CN','吕梁','山西','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCMMZ4iavvQdg6vg6iaWsyDaunaib2Z3KgKByAgib9U6L3q1icWDzQyGxpglsyiblhJHvMiacCZKMicw9D7ET/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgjIjh4RKPmzDQccUoVwyL8','胡海东','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCCUJbMAzTib4bxzmwWicQ8Y0R4EG19catI4tbT3y8LibMIa1fNsclSmXHhEUdGp4WecP09qTBiaeR3zE/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgkTFnivUg8yxXmmUmxGiBk','费庆国','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6cJnbOpgVKygT9ic5eWlVIctQAAJJbEyUvOAoAf3BdwlY74v7tcxJjZic0o2gUc0wZHeK3mV203bpr/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgMQVe7706blgE60B-t3dTs','陈翠红','2','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCBRu7Uqc2fN1YsibmfkoglHGjvY2iby91PDxSHuaYFRHGpyWM38RceCric9G9f5TrlwJ8a1oLpDNC5w/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgNpayuj81Q0gM3MY2oJMSc','李非','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJUFyvSbNgJ6j7iazgibBRY5DBoG6bly42CqxTeZeOc58HoGIsSVfRT82iaPrszzNibiaq4GeHWXx0MdMA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgoa5C6qQSxL4X2kknbuCNk','余凌虹','2','1','zh_CN','丰台','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnYpbVdwsoG1qyMEiaRkjoYuIpicaHk0vAQmCWBh791zZwwKhEbsaL5yonlpfwdyQ8RWhLHFBp4u5BI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgOFl9CRQhrt0Yn5a4E1rQI','郭峰','1','1','zh_CN','沈阳','辽宁','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6aic77B9DaG0fXib8liaibZriaftU0x3DHuq3iaklu7x9tkgqqLRpia0d1RaEib3XhghrpiciaMic5FLSz8Q5OJ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgpkYCwaxsnlMjUSRAGYJ70','王慧奇','1','1','zh_CN','太原','山西','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1FU7Vv5LXbZoWrib2TXBDtHJcflr3eXPE4riclbFezoVK5Zd75GOknFkyl5oFDXu7z5Ux4mo0cCQUicw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgpw-wjUSTQlx4rKPZXXOUw','蓝色雨点','2','1','zh_CN','郑州','河南','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EqlHgaMNc1rglX8cjOKgPv3SJkGzBP1z3Y0BSBD0kV7FdKU02aZg742zSYySOus3uSmWOcdt41zYkWvhmTnzX/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgsBdQ3YECk3hNaau0zPWDI','肖衍宇','2','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnaYmEgyqNn6fZuEIpllBsKZL2uO02xYw0xPGbTIZUNOVicOpaTbFqpLMIuC14vkAlQwIA2ECG2ekY/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgucPefhsuKbPk9qFh-DOkk','张勋','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1HSZkiajX8qN01UQmo5pF93rZBbezGUJaJGv4J3u9xtibWYfkBMExZf0HsV4YHv4zVatNTwtZxdHgUw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgufKhIegz7tnCdBqeKUqEQ','wenzi','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1Icxm43d9oTqJH6d9PycYnIJPibdgg3SLBunn4zQwOGL3rMoATF7rdiaCnuXLhod37rndjmRI7l7D6xTM9jEbfWk7L/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgUo0EeaIgwem-CCwAzX3Zg','小亮@科大','1','1','zh_CN','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6RU8kJMpL33QicKNnhx0AVETYrojP3Yt1j5G1ahzYZzZicdkmdXElouINeTpxViafunK7RskLX3mJuj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgvgqAWcPLjk_ylfxLq3WB4','宿芬','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6bEaiatqlz3Xg6xYL1H5LRJ6dzfFBGMibVJcztAKT7DFMhibdpnOxpaQcxzqbDj2iarqxTtlqq4asEXW/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgwLyvJSVcCNCTleLYAdNiY','晓风南月','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYRFice3GUnLaHZJDS9YiaibM6JduxxLpZnG3rzomaickbIwU9t32YXGVP3dVLn6LWq153pCkwFJVS9fs/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgXEVnTs_Dev_gQsk3a-DGY','Azwraith','1','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLndgJxKhQicqCenRg7TicVl0QLTEPresjSvdlia29PnpWJkibg5uiaX7IcUQuN840hf2HHR1vPcW1npOxZ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgYCOfH9Vk826X6ByqCnXIU','李勇','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnVnwCbTReRCNdMQvCJ1rztWcQvYGhTCDf8YmGPhaAicAAtRZLJdjkZBEXgDjq9xhJKF8iaiaPjyqzVw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wgYEwuKSnTpRRDR0cd1jnPs','wendy','2','1','zh_CN','','','马达加斯加','http://wx.qlogo.cn/mmopen/Q3auHgzwzM4KLHbpvTfttccVrsH1wmfxkBpPBxDqBfH6tTx2YQNBT6XCgaYWyeQNej2mWrvVmlAEic20QiaqLBQw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wg_9ZGP-DabgKDhwoCjX1-Q','兰艳艳','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEKtx9lqxtvgtC7ncllvTyA6sialnBZjibw1eLVghiajmsqajS7HGyVzzB5NibWNicUgkZfnV4QxqJR86Aw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wh3lOWP6EOETrHw8zYxeAoI','笛','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6W88kGw5lLuEuoaKcSaImzsu6TDlrd801ayfRg7hK5SmsXUhzpiaiaEBnOcTL7w18POrTtastHfQZd/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wh3PDPFl4AK7Phb3RscICNA','志耘','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1HBn36TTMGXapKIIVgQ3BbW7eO1wbGAK5ZRW1HM4r3BxzqMLCxeQQ1ljibgVOxRUAh8ekBP5EkPflg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wh5ljkG_tyYiG9Sx3ZxNs-Y','敏','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEIVP3H0lLw1r6qPlJW1T2aI1HcgdpzQac1y2lgKHxaSuftR6xq6zv4oWsxlhMz3R2Bibjk6kpHTBkQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wha8rkOlPSmmy-VPeVaW-PM','琳琳','2','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6SXG7PZcmcIDqzn8F3XLRtJzic7MpUryuicxKmZsibt9Hur3vdPqE06xQhRJaAg1HQ1J4qfBRwO8osj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whBN94_NmMmATGD-JDffe9I','杨跃江|宝德科技','1','1','zh_CN','深圳','广东','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAHG4Y0YVLajibe0pSAEkvbcxeJPWMATzkK5wZzj0VQMhOeyoEZKGGEKuGFZG7A6opumf8GOIbp3KD7xdzPMxyoibA5yg8KRvun4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whC1BLRe9cLB3Xzp3gyxweQ','Huang','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6Xs0WV4dDEAtrunP5ibibXl6JrYOJzyhVicicAFTrHgSsTeRY2nTN9cJA9BCha2gCxtxTia8NDPflX8vQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whcY0bm5Z1KYfswaOfPRG3E','刘彬芳','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcyNGwlyS5vQ6r7Q1tNS9z3WpNVXLk7ELUbTXJh1tczEbnYwUePqPatvOtlyokKXhOJeEac2KSXl5beNTWHBo1K/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whe3TDYjh7EdjIgoF4NeoR0','大饼博士','1','1','zh_CN','哈尔滨','黑龙江','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeKqk0cibUb7ibjJfnHgNBCUia4GPo8ERFfibe1g3NtG5xddpHrs7etMXb1PCLxz8T2rej6g7qIibVe3tw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whfBNT4yWyeVifxYYv7cz-w','王勇劲','1','1','zh_CN','','','也门','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCJMvsUL2Ak7abPOkdJqJmqNfIuFkD0LKZwvExJp2XymJxibHibJUaRqx0hQeu1rNlN2jXrjUdtzRLs/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whgP-9Y8mnEb8wHsrJLxj1c','青春泥泞着','1','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLBiaibLfSHu1BxkWGmvP43tVC9ic1PAJABMdctkqZI9LNHqAVxKNbgTrQjb5njSec51iaobSXBtBqcxvg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whKqv8rOSuDEEB39z2tKFGE','仰望星空','1','1','zh_CN','昌平','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6Th3VB2EAvRn2AsKvrX4SXUsCaeU06ZB0iagQM3LaO79c8TlagTzdF4zIZqExibKl2ozLibiachUaicpa/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whl0OYyVcceFJ1uZKmxcnfM','北极阁人','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJ2GSVNheklahot7NFc8m7dtljsZ8icdwbhc9xyhETz3gaCHZGmGdib9wp1gPuwQOiaah6iaYgJicTbmGQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whlHZDq_73pnNHyBpF9PYtE','张媛媛','2','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6UCZkThngIdgkz0wqcyy0chic5jzYuy2pAoseFLSm3mkO2QawnuNHFgia5r19A3WLTdE772IG3g7bu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whltiSA0meuHKLmsQyqN4_Y','杨勇','1','1','zh_CN','太原','山西','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnYzvwkvib6zNib5CmM6rEEnmCWG59nWHibl0rctjia8bVukUK3dt9F2uTbUERgSicueVZpIundwaEDETa/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whmOF3e9o7Nmcs6Y3L0nPF8','Juner','2','1','en','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJf9s0GIxmEzmLYvEfcdSJLBweUjkR7iaHAse6h0nOhiaNNOYDtco34icP3iasYIsfHtheZicz7o1vE37A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whNL-9xQKSIfrslA-MOD6qs','杨英','0','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK7xNc8hk6Q1ER55DQ1zMvdpp03LfDRN2OFeDuOEDibD7ibxtNibjQv94pbmQPhlibRIialQ4O9S0ibUkUF98xhoHPanaS/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whnnCpuOBV_UUDEWSG3_9vg','木子李-NPU','1','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLDlhfgWKGic80btDgQadEB7YD0H7Z0QxlDHaHV7koNqbGtLGJKuyyK1U9GDLPaucibsRhOxQ3mI7mdA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whqOfObzbw5dlWA5BOivmjw','赵丽红','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1HUniaNneza31Evp3nibD3u2sUHjfs6FVm1LImKhqAoBKibr4N4fwz3Kuf6NRdUT7hXTbdsWibq3hJ8vQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whQqvA0oSC5hvSPocFJCrVM','J.W','1','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJ9UYeTjKV3ZsEf40hcVmSeGfJEZxMjktUe8nObqouNDo3x7dWckx1FiaeGZSYqFSvwmp4YNCva5nQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whU05Qnnj00V0L6Arxr3VnU',' 吕明','1','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEIq0vRLF2EkMjMicW30Sgz5XbdMbE4RRx4PF9YFITGYmeWicysjofSicu9aicxqWTQWribicUVV2XnXwbOA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whuSMBShy6lc0kc7_84wCEA','rainbow(^-^)','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJaU3UlqaAQCUIbsGrshRNL4BA2ltHiceTvenliarqFPACndtPl4radmiablqib9WQmVFQZm4gKHliciaicQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whwRy3luj9OahvRsyqYyZC0','杨靖','1','1','zh_CN','绵阳','四川','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6exIXy5gNuNuu9LCHR21o1tkcHpfU9JqZ9aRrEwibx03FmYBYAj05nyWJODEZib88tzeme7icCX9yrR/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whwYwjIo0gy8dmOeOQyEZoA','育禾苗之土','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6fAL1YvN2YwkTnzbCPYg6z4XUEO7GAOnlpoTewstNNwykVcltyIRnr0cLibwaoVXibcZsxyuIApBUk/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whzEcra6p13EOvsSpK2bGhE','zhangyun','2','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1FHqHmYoYiatUqMuzIYODjvFo7xKwvVUnn5mzspSUFcympIYGlDIaCNbWmq7YnVBqiaJGkBaPwnl32w/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whZmoTdu0S2wAEmd2SWw6U8','耿新','1','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAqVRQlJtF8O81OURWpHCLRWKYhuOCJ9ibaAHVhA2zoa8UtSVbkV6QfqkpzCr2EOsRJGH293WIkndw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7whzNCjitk0yTiEJ4jX9uOfE','xiao倩','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLncIZibAAnrvdgYbicK4sicRLDeoa6SbGU4UpTMjdPU7hw5Vtm7OY1mr57sWGbIKFOUM800IV9t0PzF6/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi09uBKXa5bRydsQGAk-8DQ','金沙湾景区喜玛拉登欢迎您！滑沙！','1','1','zh_CN','海南','青海','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rkfjwQ1BXmUCicAmqmGCkiar9ZPPEGZjwABs0HiacLwVpupUliaUoJeibskOhuOBN5uFGicdQdYT2xC7MP/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi0cRf9OuXk_M8E4nyGEPrc','Leon','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAtUx6SrzQmq8GTQshdMredQNmmn1vY0W8HYmxk6Q2cz1NlmZ0ibub1dSN5lOljicf60jJkmicbRwjibw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi0VbLG111Rtl2pJl1AnRX0','Arendt','1','1','zh_CN','连云港','江苏','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAgicCpPiaZNs7lSl0LEGTDwT8jLxyd5lURkslwETlU2x2ibeqZmpXQicWwx9S5geAIKHa8UrJsXUFwZA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi1JJReREXJuyqFvd9UZ18o','周建忠','1','1','zh_CN','镇江','江苏','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCBjCKboC5GQjtchddJxcaPmnBIILTVIicLocPlrfYXpQQjhVKibvFXaavib3ER37eFBjVn3gBxibH6WH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi3FYdw872103FA00kJbpXQ','晓挺','1','1','zh_CN','宁波','浙江','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rnpYHqNJjoYicWaJcqOO3FklAPtBB0nGoibibXyrad1LEV69HRw7umIYdpxZu9pKDV5OU9fqBNDHRtF/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi3UJtkMfiHEJUCwKPxUuvQ','冬日阳光','2','1','zh_CN','邵阳','湖南','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1EicLwl5XxjYNGBp96758gJtEDbQImPGv0FxjB9SPo6rd6JjcnRib5mFMAqKD7ZC6icTPZmiaVHoick5y0cTHD4j8HFe/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi5k3EimoMXwXYJwDQL2a2U','李慧茹','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rmvrJtY8F1HW6Y99spDLL2xUYqAuzOMQzxCB0ia2SNzt3b19ZZoMNic3d1GoaibqLo14gPX16icCJhex/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi7P1UGW5Kx-elmoxcl3u-0','大师兄xl','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6Rn9EFxsWibMGbkvKsO1IGkcN3fyTzQtlpgbcHLNHbxTgZMLUWuA53rjvLo4wSSIic9ZQicsQ72WseB/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi7q39ZFjGQV-vpegk0FEKU','haiyan','0','1','zh_CN','','','','',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiCICvvEH2Vx45kuUKdfztQ','张小喵','0','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYeOdjssrnUYmBX0blsJaibPTgAHvEbEAfiap2XVpd7ZAmOVXBGgBeu1AuTBYFZV7HWjtvbTVmIv8Jj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wicY3mpxU7xbd8jrSyH9FNI','Xiaobing Li','1','1','zh_CN','徐州','江苏','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9JLOkLNSKZmO5kLvgCon6Em4CWia4wbYaQibUL6TtltEWughhqR2AEtYb65DPg6lCK9JhsVQ3VID8cYmAJo4piciccJ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7widImL_EIB4C21KkR24h6-E','张晓祥','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icatdnD8zyiczEFhXLuU8FnaooNxXH9M9XOIJpNh9NBhtSYTTNNicc8GTfP8x4tibHxicfsJQYib6YiaxcJu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiFroa2JfNlnmiv_n8xx7so','wuyg','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IciciazAdVXul8hBc6ibyRcmdVPxWz8aibRPzooQicglUx3b9uatfibiaX2jEaA4lk0mEGKbqo8sqmLO0Axg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiI4beBAg1cPj2E7uU7r3N0','533','1','1','zh_CN','阜阳','安徽','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCJO6KLyNNnYg8rzIoDJ68xxxicp7uTluvxs9zUpDFribeTjIYVpSbJ2EUkZhDzxLIghpyhyzCE84uN/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wij1lQ4he_4Wv_ANZxcH-yc','hai_wang','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4ibnoPNgmqGShZiaDDvZib5P3IPSuRnYLXz6gdM9JuMP3wZSU7iayiby1PoEW08pjs28eMdvMU3UuNgZf94xv4EicpO1/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wij4trLHC8c_gUDvaUV5ulY','冬日阳光','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCBj5Y9m88yy0RuUW1ibD5JNvDtO5EbF13bCcibQcX43XaqMgG1Nb0ftlUmfMNXYEkZtiaM5XQthQjfl/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiJBLmmG06yvHCArcq9wjCo','辉bao','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/23NzhTrg1IcJVDzzng6BOzzlqR2xmFOKSZm8nYxe9ID8WVzc7QGSKNluckniac4ARpGL1qdLDXNBw74hF086srCXFELTp1ej2/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wijiTvJwNn8XM_iRsGYz6Vs','张翼英','1','1','zh_CN','西城','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCGoFqibFHt2W0dxqbcmR9uzf3oMRhFMw9Lf8n79M20RUiarAUwzGN8vgMEb24jia2SGPc52wf9ticicW4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiJpM7tCtW8OcExdG67aEwQ','马也','2','1','zh_CN','包头','内蒙古','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6cZrkgc95da1bZXAUglSZickrK4sLfKAzo29QYk9rTMqB0iazChOhs8aQlr99iaNMrTuIPEPTF61lpk/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiJQLBmeZAw4_uhjrekV6BA','应世红','1','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEKSQpQzJ3EsJFicex7KvL0ghmSJozqj9cb5vDdtvzhibVYEo1xqWc0cicsJnyg1lbWbn3wPM5hEtS1PQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiJqNaCxy7EbrdwxYu1pCQg','刘鎏','2','1','zh_CN','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK424vh4fPMLhnl8njaicHGThc2DmGgzSyE669Y65CGmxuUTEOabn1CUeKRsHzpHgyYhNmbHvRTZZcQrX9ib2icc0e3/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiL3Wgrm9TU5MfSLNRZ31N0','momo','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEK3wCOm3aGAfrm5dgjxibZgKmOGPpXFVE65Wyib33qmv2ibY5hKUmflA5B9v3RYr8F4J6I2SQ7XH9ogg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wil91jVxxY5s9oUtc_1aalg','崔晋莲','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLCL4DGJibz4D5ZPWyWIswzHyGicG0Kj14PVmtibw6m5h7B6HwnfZuCyLBfm0SiapvFce3MXFoQ3sISLpQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wilFXoHbb3f2-A4lBOa-mJs','李幸','2','1','zh_CN','济宁','山东','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4ic8icib4OWC15BP12KYRCs0JyoLdG5nE9yOuMmFazqBicO9tCKD8AKLjkMZfMzs09cbWkO1U6YeazB2FhBMJ3xqCX/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wim6tYYBoXiEvvK0bpaivrM','Robert T.','1','1','zh_CN','','慕尼黑','德国','',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiNwWwnPLp2sQjJVIINW7aM','刘遵月','2','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWrRsGrrAiaicUWRqMbENonn8M9JDuXCMnzczbGziaibGjxnShQrqcLkLPjJKGnDLj7ic3PBwztRkPj8GW5CQHG4wLM/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wioOdHzKIVfLSQbK_M7peoI','Yanfeng','1','1','zh_CN','','','阿尔巴尼亚','http://wx.qlogo.cn/mmopen/23NzhTrg1Id5jVonjEgWMBIprBAg0qZ0XLPyp5bHTHRGIgUOUTjrMekjvXVaZBFKDBZeibORZFribLzTKTSzZhicnluicLt6H3WI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiPTc0VZNN5nrJONe3F_Ldo','金蕾❄️','2','1','zh_CN','秦皇岛','河北','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6ZQyyyVEOTJP0TrriaLzDUun9AxibO2zr88IsrJC00kXjYyeTNTZufGrx46LnRzZFEjegmpo3BH306/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiqoAHDAPmIZ6JeTn7uOknI','崔润','1','1','zh_CN','沈阳','辽宁','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLCA2icHmugy0dJI53xXCA7r1rY1AlIhIFzdY6SQXaN6VLzO2xMxvTH5a8JxhIrGlIIuEiabIUAz8e2g/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wis4Hh2lIw_8IQ69kWrnpCo','梁頔','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYQSNktR5ZRzC8fWd9MdHG9adJwDzpOknTJ7Njh6fuv57NyqzXic5587Uk0MuKnJgbZia7edBicvAp4w/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiT0_z6Ct-_ru6b2Fx-WU9I','Monk','1','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1F1H4K12KAcMowrl75446Zn48xiaicD0Edg5dlwCT0DSbb24vXx42t3icf9hmx1jesN0tvHlo9iaibqjuw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wiUnf3mHQ4Y7BtM7iWKh3js','再见理想','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcDxTWQDLH0ZNjH6icgHGUrkz89sFInsVbicWtjAxNheYSjqt1SIqIVkuSW3q0wtN8ictnpC5ZlDOx5Q/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wivQh04mY22UYIzPLUr1i_w','枼','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJFvJSD9xOV614HJeAbEiaEpCzFMtibPJctLbyPBDcc1iaEjQ5liboLkAtO8YxFXT7NibmIm7hbks4JfWw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wivqibvRW_TqQyZBjO1PAAA','JK','1','1','en','','','澳大利亚','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ik9qznpRhsQw2DH6ENcTNoFmkmB7IadRdib3FbJKE1o9g2XwVCxsWn2AKskSz1DWdia2CicSjCd2eh4schduIicDvw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wi_XYNs7vCHkmzeZOPiA6kk','金玉良文','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYV9wmME9dyuxF33dBLW4icPeI5I9tqAh79QKnkNiaeuD1GEwAp21icx3G3x18w0CunAORjibP5bc4Byt/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj-e_VhePue0Ojzo0QfZB_I','裴吉','1','1','zh_CN','镇江','江苏','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCNpWAxvMljfiaffH2L3w0hibGHd3cHMK68tFibialAmnbxfnxTdwIOp9gQVqk8sVJwZeW9ImJxDJSk2o/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj0l0Ph0l6_JqmjX1YswqaA','鲁涛','0','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4ruTSZmrYniaB7TEMJVru9ndqtcsE4AuMw2SkpakuOy7d4X6ia54rZKpXezxN36gTHlv7y3MBbWpVIf/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj2-2LiweXLbOlEsbvYjyZs','林宇','1','1','zh_CN','','','中非共和国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4riaL0WY56ZZq5bvGibGv8qgjZj72iaYmsEtutgEXAOY6FdsOrUgsRic77AI9fnpukSTylbtS7uKadK7l/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj3216EJUa1n5WSVWE8-lnI','潘帕斯雄鹰热爱搞芯片设计','1','1','en','','布宜诺斯艾利斯','阿根廷','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnU7A2icbjcxF2k8fH11tsx75JyVkBiaw4GjnbibpXVib8mFUw331vE9LMItQJ5yEqpIyr4r4q5rqcA7M/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj36HSwOG-vciTeKF0G4BBs','司南阁主','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCAYcCCFqHcTKiczd8rawHyTzp6VEGMLHMnsqg3NOF5xZl7tMZwKiaLejwaUKVUE2q9ygol0Ora3rFq/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj38A3YLFMrecShQIuH2bFw','李豪','1','1','en','苏州','江苏','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYel88UBseGMHfvHuITYyE5ADSyfPWQeRO2cFffTibjNfa9GmjQrlKFBepoz7VsAPYMWKDNDXygcSb/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj7cHFSb4LbrVQDXXGwNrEM','刘玉志','1','1','zh_CN','南开','天津','中国','http://wx.qlogo.cn/mmopen/MWd8XRcK123XibVqx8cibpEfOUuzBqOtBhQjuWqkEiaDWWzOBpJiaRjwG48ldHYrYic5IQFVNsV7dNmWcgDqicHvu7aWLicBaM6SEKH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj7VynkezUWBKVUciBwb80U','王炜','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1HWrNJ3MpTlKBo1yA0aDcWjj2icm61ye6sG45KYkGYksQic3n8GoOcwBEHCCQBb9wnhGJo76mnB2TUQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjbZSWH1qdQoT_gIWoAZmaE','悠悠','2','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rqJXpnGR74B1ua8BvYG8G7pWKB1f0Xnicox6sPdDPNxbgO3zfiamI1rfqiasqKNKDfsam3AHTibmA0xw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjChhTVdFgRnCdjgnYHu9_U','DAVID郑','1','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6S0VRV6PJmdXYeM6c29KIcHo6nOAMKozaosHmdicyczSkhDibHaPicMUAic266A1Ms4zMTJEMEmkrNvK/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjDnMo3DCp6F1U3Roa9uCDY','迎客松','1','1','zh_CN','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6NKjRZu3PUrsibR7UDZa0hFXrtzZ9ibpEaKPYADy0U3QyI8w0LurAcMoawSHhhRAJoPDNnrMtgZK61Lf4ISSykFt/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjdQmJ8zBcx-Ox3g2vGxmN4','Hong','2','1','zh_CN','','上海','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYQklT31TSPmFF7ibPMm3m5cBv7PEHkiaYqXKE8ZichQo14W8CEr7pA12nHYFWJicnyA3eL9wrXFibiasCC/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wje-J-spVfNP4GLfc3j8Iuc','zgzhang','1','1','en','','','新加坡','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ku1QI1hUoma5Qn5ZA960HJfYnTOnYiaibibaLuEwmribuP3yic44FubicGvQcYHQhfDZA8us3kPF9bwshNjHibcveYKmg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjGCk9_T8EEx4cLzfEge7nc','鄢伟安','1','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6QEGdzkTqRhFYpFehpme3xBae9oZViaITPj2ePtnszhBoHpLo1Tsww3gT2kkLxZVslGc8Z5Iiceibwz/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjI0Z0x8wpS2R9hIImaSu6g','醉东坡','1','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/W4OSDQ9eHbktNwNkmkGMeCB8LpNZbXeOsLosowKAxz6mk14tGQrEcuFuEuPt8kHPVzSxB2kg02VIkUeodWucAI54OtKoIEoc/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjLoX0pg_lbV4rxG0nJ-SUw','朵朵','2','1','zh_CN','','','塞尔维亚,黑山','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6eWldWnAWibtJTK9NPgdttndx4YPLMcoXOpebkZMwp5Q7cAqvdIDFpTRgm9UiarVkfGjE562Kmc5Zu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjn5WkHeS1dKgEADpDOQxv4','HYJ','1','1','zh_CN','怀柔','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6ajAcETVj0tAQ8J68AKDbBeictqFibmEwTl8ia6xEraJGKxC7lrHPKpbF4cw4Xf9dH2UicmIED0ZUI9b/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjn8Lgk2eyci-22e50FXbQY','SUN','1','1','en','洛杉矶','加利福尼亚','美国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCBUG24TEqDiaJSJAsZkb8ow5LicLZEVvNOpuVWYkh2Oic4AVv3lVVaJ8GRmUD4VLEp38iaHMdYvZb45P/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjNcGhYkZgHsZPzF6BaI9p8','达','1','1','zh_CN','深圳','广东','中国','http://wx.qlogo.cn/mmopen/icXStW6wUWPFUiaWnz4GTKQ9NxPeiaMYoibLVNeC4B3BYeGtONeEX3FMWbrAKicwIRVPU1kVPUknrNXqqfPdMqU02gxYXYicsTBZJM/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjp5ek_NTXLU3pytFXZBtVQ','临床科研','1','1','zh_CN','','','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icah4BbhxPsNliaDddR9UToEkgjxWRSeibjn7akwfDEQykPqPE0KT7SAK0jF0Uibq4nfrCGnpR6iaysQD4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjpJhlUHslwVLaIhnjQuHXg','渣渣','1','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1EHVG4XrrVZGckIFZbVVBmrbuJcBGoxickWBrvSFmD1lawVWLmSEGksefiboo1STvJsic1GumJo9Ric5A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjQD-3HGEFa6ud5OKm8jaZs','沈思','2','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEKUpFDdBkHjx8Rop1uQXNk5jlVTWia8jOUKEVxohOTLU66JPBBmsBVx54DSVGlk3YNaxugUpomFPvA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjqEZGHio3iVFj2ceI5uBFc','邹渊','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCOF5cicECsg79wbR8Aibg6QuiazJRLic6BolDWibvkAwBJBHy6tYtMxwasId7T9hO9SBShoFZiaasP9pcj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjQpurfKiainVmMwJO1bOoA','郑霄龙','1','1','zh_CN','丹东','辽宁','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icajjoBddcxZMaS0jlx0lkR2cLOlDzlLotlVMjdhQykOlSR24nPbooryMg9pwUURDmld1xcFmF5u37/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjszahzFaGEswOeejwFxCB8','Jiang','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6RAFryEDdEtxfkxEicAbObVcvT5oVH0C52FBnkTsOTiaUeLHKjqRsq7tcSksXk8bCiavzcvxxYxlS3Y/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wju66hTcjdxiI8LumJDJIGY','Zane','1','1','zh_CN','沈阳','辽宁','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6TNt2snc5p6YRKzL10jeicJEe8r48KLqlD5qZhgbNlzC6ATFSpSA94d0IQZcKXrPCTSOgDpvfkGdK/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjxX5VQWjxJoCGZgAw4dHec','落月摇情','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLDJRvhOxF47HYggUBhMcAA8lW8O98qCyBRib1IdRuiaibH1ib4HHwuDBIMchInemj6iakehZP5H7xmbs8Q/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjY8g9VhdEu44i6TV8ZI3JY','朱梅','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IfRd5Dx6ULzH8ARjV6JOEA0SDib5ibb1thFxjJ0p4lrlZJXAGU4tXa8J5ict3rnyRwvDjr9kZTOkibHrg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjZLBW98gJh6lGAEZTgrfb8','屈哲','1','1','zh_CN','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYZXoAM62angW8UMhEicsmCSB50JvPY9n9ybJibkNko3ESBlmftXzk0oyc9MA0wV8SN9FOrylkcfXmP/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wjZof4etFU8EzryS3VXfTUk','xinfang','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6ZrLfUtrum6fGs9mXHXhCibKXgPaHsT39X8JfxPh3awFHWG5y6tPSyNbEouy0zZgZVF7RCHygic4Mj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wj_hL5Xhp_fB2MWiMqEwBz0','SueJin','2','1','zh_HK','广州','广东','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9IjafLxZG6chiaqvafMTuZGIeSmZRianvgPAh9gpCfsQzcL4TknR4ITJWPXqL4K4uvGhW1iawfCVMD4G9GibOqXVELf/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wk--wYqL1OwbQVimtQ4mHAI','沙沙','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6XNdOJxhMVmibibQfgcMFvaDGAgLnCuCXmAkry4tHzjMDbZE4D2mshMfPH35bicldweRKN105gZGs4F/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wk1fNoaLvqyQ0CKk_d49gEI','至善若水','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYfUgeHdqpVhZpr6rlFKNSFSxicY9n0KhthUprib2k388IbnlNSmm5oibJpGeDblQFKIHkmUUo384VuE/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wk1mRSQO2TmJQw_kl7lRzAU','一盆仙人球','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYXDgKyHHPribaeV0EltKtDLX6Voca4gIjucFjtCEeObp3BC3muv7ibXrRYgiaQQR2icqk7EBb8gCtZWu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wk1sdSFX0SMDvxOSt0uhlLQ','张杭州，关节外科运动医学科','1','1','zh_CN','','','百慕大','http://wx.qlogo.cn/mmopen/Q3auHgzwzM6wJq563icicX9WDL0zpfFMwTjHRS5yDzaZCPZc5QD4mYB0B6BT9bn9ibZTJ0gKWP3aIumNDMqfsrusRiaWyluJpNSfeQSddodibAIA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wk20MaDLK92h0dTV4GJy7Tw','Christinayeol','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/PiajxSqBRaELSOjtLHfe79NXkeGibbuC3O3dCaYRxvHL4vweCYKG1gkhgAoEIofNFkpkJwZDlx3tgDbicuRSWkqOw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wk5_gw4SbHOMZlNmgmqXoWw','yy','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5cc62BRCAQF1a6ccJHdWM1bEvbjY79TVVONicg0Aicyljvjiavm0jqDLyXIibF1PvZsgoNOR0l8wHjiat7u5BEXAFjeC30iaySXFDJY/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wk8iddKDL4E3a6eiNSViOrU','Ethan','1','1','zh_CN','广州','广东','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEICIGR5aqwYdibiaEzCg5dlrEicsoqlVAibrBiaEpyUJHcdwMUPhS8Dbljo58kMg8LJc4wxHmSbSD0j8qGZnOFBiavHgh0AENHAp5330/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkA29yVBJxlRcOOHTy9-v-g','万熠','1','1','zh_CN','济南','山东','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCBpCWibXCEnnpHicB7O43ozBvCn6eHgwUCNrIUVwxjtPdxXoToSww4YVUcU6gBx2xtOlZNiaibqz1lWp/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkckblyKu5KPYYgzPt9Mw8E','琦岩＠istic','0','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeFib0d44HZ30eSRjWWc0VcDL3YtUNEibc5YWeiahicHINvkUyzibuKCESpusUTicotuJBe2rLMnSBzSlyKL4u1aOoLNe/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wke6x8xc2FxWBmf2Yc7d0IY','沈晔','1','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/Q3auHgzwzM6y8iaiaLgjqKApp4icQzPCzYwHrKnnicMibHCrstPf45SCJM2TBCKCWxFgVLVqKrUiaAbL9hmhBEBFIRHrJzJp5ReBPvZ2zywrzKNO4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkf4G3TOV6lfVgpLot5MMkE','贾立好','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYbibatamReL4MkXhq6t0M0pibgqfRicJI4ZFM98hJBEr5j05jRBpaEjfetHkm1m3ItaZmIhWBwPicBDG/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkFtSFANx439AIpdKmBX2Sc','马春蕊','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6N0jkkf3y5TxHLaaTqQUbehWIwKwhtGORxxHYtIyHLosdlpgtgXopvE9eFqQkJFfZv5NibLkoCYzULpH9R5ChKE/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkjbIWpnKqdeH1gHO1EK_xA','月圆景灭','1','1','zh_CN','','','圣马力诺','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5zUTFmgHftwbD9zsZEc7QSQrK2YX9yrslZdKN3cWaCZTHthJgnhoDAAVlUyzhgxX6SFiccaNsHQYerSQQT2qTT1sk6qecfr2VQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkjCABivVbalsKEuh13l_Hk','明含','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnavrNxqCzBk2Gxm8hzp3AtSkvddmhK3M6Jyh2hDSb6YwcFVM90coKmRfniadYyTyiauMPIMYJTHHnN/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkL5QRy_p24xqFFlpQbKaVk','LDY','2','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ku1QI1hUoma8uhcXI8DHxNzgwslNjibzZ20Lbes0JQIRPicsZsAMcIW5HZVYzPstrtuibFxp7ChYZTHQUuuj1iblEH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkMAGU_pjduRhQWPnoe5NfA','张鑫','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnXGBAOT4O4wJ5eUSO6pfvgO5mOdqbCgs41c0J2dk44AibeSyv8r6Lh6fIkTTaN7iaBjYhhJBm0rgXM/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkO-tW0IA-Z7daRchyd8Tro','糖糖麻麻','2','1','zh_CN','西宁','青海','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1EOoPfAFdOeWxSTDRaEwVF6veRcedRFhPuclgC3n1NDMORB41Mibolnz1mwZibmX21xBBtJn952qfiapYnUs4VE4YR/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkr9chEYo76Md0MmTkbcWO0','韩飞','1','1','zh_CN','石景山','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5cc62BRCAQF1a6ccJHdWM16sqYbibUFiaGibABXQ1j3Ae2pn35hg9hC8YicohAic6TicSsAwPebumo367CtCTKrmiarfXSibHVZz3ZJwY/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkUa7OhBMk2oX-ik-mDLJuc','王伟','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6ezHBCVFlpgmr3f7bU8hDBH0BNEwQlsN8cqTMIYpCUlEKFv8EWG1wnftYibHo5Hz7d9l97wecbcKl/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkuPg-_HCIOMiEP_n4Ry_Do','L岩','1','1','zh_CN','沈阳','辽宁','中国','',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkV2auDYCDI9xc7DxM-nftc','摇篮同学','2','1','zh_CN','嘉定','上海','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEIXfwBnhgyw254nWSmIAEickuLvgkWp395rqjkoyED0mF2Ztic4SOLhOkMsJXwgtJicw6abO63IxK66A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkz1wMi2vdEG35AJQ8jhXk4','黄丽华','0','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnYOiaceRPtFyQqB9vozIlwrhicVnlNee8p88czm9Hpd9ic2icTPxmwsnt38tU1W03af1mQwwcoPYHrjl/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkZ2Ecpo4G1QnbbCBSgsleo','zjgsu胡永铨','1','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5YhjPicPmbIibZvDNpeHiaXuARiatkIuXQnhRQ8H6QISOu8BUq6Pe9be0ib6x4OtiavwAw4qpKBw7Kra4A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkZI7vtH7SwdWINjy-v14C8','王健','1','1','zh_CN','','','英国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icapgTdLic5D2A03ggyHrJSoibHp7b56uH9P23QEjd1iahYuEPEWKYXArfZIbkIyTLZcdqOFHsLDmJzlm/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkzMrmzjF4z5K5GY2K7k4S4','许欣','1','1','zh_CN','深圳','广东','中国','',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wkz_Shd3IAC1Sm2aFu5pry4','pillow','1','1','zh_CN','深圳','广东','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5zUTFmgHftwbD9zsZEc7QSneLag2iaeFE49ib668GEWKHoRXR5e4aZSQ1DwavO4hOlOBfgzXFK6yIdY5Fs4IfxqP8BUhvCmFiaFc/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wl191am1j8FZsCEyx7ze2UE','大雁高飞','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCAj6TDrekD1YluB0RD1HQ3Z1fdl4kpCEG0KpZppOkUOSN3UNheLrBgLeiaia9vnU1Mu7POovtAx6lD/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wl1DQciZic4VIh3LUsa3ZFw','112233','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6UFaNH2FFgLXW7mL0PXc0xY2EwvUHr3ElBUV8NmeK3PRzeuNI1SjHOiciaC77F0nHb92SPYHFjbJhu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wl4K_aDp4Rwr5sElhkhd4hA','yaling','2','1','zh_CN','沙坪坝','重庆','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icaia9MpVd1wVz4pia4CRKcf8jegI5mL4KybMAYaToLTZia8LhNmVYKSibuCqbMR8GxibUxibkQ6tuNDt2pP/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wl4uBlvdRYY4Ppf8MUYwyzU','杜小杜','2','1','zh_CN','','上海','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCNdqvnQEm3TwZ3DOqP8QXZ3IgvWqWicCcibUWWOiaNe223SyTvaUZYgYsqVjKyqv3XVoaAfj3HlEibI8/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wl5Dz79dqwW7kVLtR8uPclo','加西[Jie Ma]','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJScwdpyDmWu3mEoOer6EuicMUq15qib8P206XzOfXrb1fHEp48LfKuJsRxoXqCe0Ut3sWknAibhYic7Q/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wl5k2C-ildq653IxOAffktM','独占神话','1','1','zh_CN','安康','陕西','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCEV8TcQjNIhot3sicRmjRfmOVsapzaG4NR3Xp4b1Iadibns2Q45dDcSmjQNNIm2gDzrZdrqPKI9V3e/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlb80GD7VO2URqoO1e0Hg94','乔三','1','1','en','温州','浙江','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1Idn4b7ysBGq00iaHHngYKn4evXc0Iico88oyibntCNM3EoWiaBINHZXJcT3eYCcUVuEOAzSfuzsY3OuT7WodEMcR8jT/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlBaGN9tgVSPRV48aN-iKlw','Li Chengyue','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ku1QI1hUoma2YlhU6k0GibPThaSMth1k5TSG5YHT6FA5Y1EjpAjA5xva2xdib6HDS7Ujib358fdqj8GVgfYkNN7dS/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlbGUzQMFg7LpsNWeL8IU9k','陈玉超','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IfaLhjwyIzKT9sQ3Fm5UAc01NAJ2uzbsXHvbve6deLV9p6HiaH271yTOY5kgNaMz7QAiaMnpXlaF9CA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlE8ZHKKCSUsyveWOxC5eaI','Isoveli Cook','1','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYTwG5RSUokBn9VrWyF37EENFgPOMhkDibePQzvgaibJJaEZtwSaj0yy6tjiaIBxcz2iaCiakKI1oFEagia/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlf2mluLexM3FnJf3ONQjHI','稻田里的流水','1','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rqWngsAib5X6a7SiaG4VaoicUICXhMibe6uK0iczSvIGj85vS7NfH4mRrRiceib0JE5FHt6q5gGsbLX1c4a/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlfsAUaqjTV9NyehNIN9OjI','雕刻时光','2','1','zh_CN','','山西','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4aT4sIxb4pLSAWEBO2c6rtPPictTcmQCMsuW8JjhnRAbicBYeXDbrAbVEjrHqCvicwTCt6s70j71OFw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlfVTfzzI3XJRSOQzQqHETI','幸运良','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnUlWeN2AUqT2kjP2UevADnV8fCiaic9NOs1hial2x4iakpO0Edx0YJ01AnSaCMk9Ofa3OOLuGlsKkhcp/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlgEZSfW4a1i4VG1ZCbBa2k','王亮','1','1','zh_CN','太原','山西','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnTsGzoRR8ZAAwY7KsI9qIOPWS3UIQNpehbvTAGicot5wsujicVVnEQnD7iapGHB7GPsWHLYTLibZVuVp/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlgSFNL-FAQq3M88XNuLveM','温治','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6RpvKksxXMMV0a1YWrnx7DH5VDuVKOv1EL8RWo0oWTcDpb2WR2osQIDicEJMfg9b5bJBMV17cM2fH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlitKTz_vC6h6TSySKrzXXg',' 习惯优秀','1','1','zh_CN','','河南','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYbXlDuDrBOe4dG2nmMxfubJh03G9G18BxAK5tZC6L6O7twNZTYgHEd27809UpPMvsawVMGCZibzMb/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlje8EecMEYH5lqdTMSsjr4','燕麟','1','1','zh_CN','南开','天津','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCIdiampjBz1zDVia1uJVoqBBcgicR9x3Zzr7du3DJNs4CibvNE9dZKz4ialRTGyoUDoSqiaaxHrPBJY5RD/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlJEL-X7q5LYvVD82pM41ts','陈乐如','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1EibIibiclGAI5ge3JBhkvibne0hIRDq6bZ9yVc1CLW5pBsQUFibJ0BGlKBr7B33J25ZPze9MSndcZKWxg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wll5RkZh2uRuVBUwNEc6tiw','石慧苓','2','1','zh_CN','银川','宁夏','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnWicdtaGOF9QXg09yiajozuFc0Jv5NrleUIskgvavcibPE9r3eIrJRjDicrYuHsrGRwXyjo7vYwbMOOe/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wloFOUjwEz8tkgPEM5avi2k','雪矾','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GEVfibzaTbQh2QMn2WtD8g4uLJ0nCTTgM6wOUibUuuT7nBcpGVPfQk6JpzBvvmcyI0FERicpFa4fSOQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlp02Od4L7DaaQI0AaPDomc','周毅','1','1','zh_CN','丰台','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCOicd2dqAAZ6Lq9ibg8jgjn1WfEv9WRjPXGaodND8icz8xCdD665748KgUjbnQCESjau61L03kCsiasW/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlPHKTRaDPNW_BbifAXQsME','小镇','1','1','zh_CN','徐州','江苏','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1Icxm43d9oTqJEFaXRcXjibVonU9QA6BC28iaoWaCgAtCvWEVrD3hQyXibguNuiasrNAK0TjNO4M9EEmYJsWiaEYHsvy3/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlUP3ysOiWwIU9F-iz0ZMZc','刘祯','1','1','zh_CN','咸阳','陕西','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYSH2BqUwedewCPia4qIqUDpibE6TDcRLGHxbpPpAnWOYibq9vJ29r9nmQPyteIRq9zdD9xdvTmOEOPx/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlX95eAZSx61PCgkLqUcWT8','王迪','1','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLA4xgILTlVbCev288iaCBDxicG0wce3Tl6KAOB3qI2Sc1GqSpsias4EgnIkJMRmUnoicgB2ic9DAOzkhKA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlyXniFJ08ZJfKrWn1biG8A','log幂','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLALjicCK238RKZuia1GwdXt2Gpz1RMM583swYBgowzVOm3icCVVoLiaYyjRf0LmialY27YspWDibsQAibiaXw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wlZW7VY_mnNwrjd2U-ePthw','杰','1','1','zh_CN','南开','天津','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJQgpdzmQaREWibO7ntvc7hXyngznXO8icMWqScnNrJHTN30LfY2UMjhyJEFtsza1uR7tBj8p0YjApA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wm-DqzNKync8Q5A0c6gTUs0','Elizabethzq','2','1','zh_CN','西城','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJlgqlI7wtCW6ic16V44QeIDFn5KBoAxIM0OkeDXWr0V0deibEd8lzWWB3y9V9vAlmYrcF1lsAn3riag/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wm06w8g05KeF2tz8J44COhw','李栋','1','1','zh_CN','泰安','山东','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYdYcq4Tmsm7zHGchxXdb3EW1cd6z8DUibQbMWh1Flia0p6TleIKp5Dzib3EqucvnXuO2x0rHBkybINH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wm0KG0CEczRvdq2Vif1Okn4','小黄豆','1','1','zh_CN','','堪培拉','澳大利亚','http://wx.qlogo.cn/mmopen/23NzhTrg1IcHaPq3micMpuibxcFjibG6WaYsicNHKDoge5licqibSnKQGkic0DzJGOH3aTW1kmLU6sqT2BCRZLynSWP4w/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wm17sFoG5xmCWiHO5lyn2xQ','liuhw','2','1','zh_CN','','','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6eZa7WppO20tqLJlWTtslD7pm6qxsKUmOCsriao71BJicqyEMeWZ0MQJoic9iaVujC3Hwu5dX4xFawHw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wm2bkfULCYkgVDH32dANbr0','军宁.果殼裏','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1Ha2Hice0pYUufUt9CD20Mu5oLTBUS1BpqAvmVd33W5DofKp0tichTqRxJII8wibf9rsvM1yxKh6UY0w/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmaCXdEka60OVkxxsrG7DJw','太阳雨','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcqgsMfKCcYVBxwRjd9n1ReVPnN6lSwJsXHjqQJk8wwJcu9Tj3qYpZoMUamFeHRyWVw3iaEnxmt7fw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmaoI3r25HlVvQ8eGjAnKfo','锦上添花','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK78GaO3YsR7XGnxoGKwTT3lccBwUQU1It1WKHNVLWobXOtdQicFGAoKRyn4AhV7qvInQYmkT9MLCw5DhBCxtyiaNG/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmbBGc8YRXyjOH_mf0_1LZk','april','2','1','zh_CN','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ir2MxXRgyl8Z5ic5oKuiaibibc2ms8Pa4JiaEVyibXVee8JHaAQULAQM0sSHWkhqEHYqSWTkjibQlwCy9bPoOugUQ4TMY/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmbha0VRIBd2AYk3qlICwQw','xgj2008best','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1Ie63O9qyiaGzRSFSEHcSaRqs8hiauo8fFFpQGVYNE63Uo9ZkDISfK04hrK54KCJtBbDibHVck4lfibKeIS6icWp222XB/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmdaDFdQz6Jr0JSjx_wnU7s','金山','2','1','zh_CN','沈阳','辽宁','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYcvFo1aqqCKiac9Dn2XA7pY2TTp8w4AwCrN3B6pcwibntfBib4PXbL8K8uwIiceIb0P2VcXj2cfA8BGj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmDXPrIfklxMaO4PcAvnC6U','马娟','2','1','zh_TW','马鞍山','安徽','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYfRVqCbwNIHKicDwG0MqwH6M1t57ict4qaRZNHxFMicicVa1KhBX1VScMgdB5t4FQSOtdF9aVbiccaGcf/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmEGN-mCcpNAnKGdv-REegg','刚','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rmbbzdctiapwPtAWwcL6jibVr24TbNxW2F2N8ibrwaPx1AmHIqwiaW9PREsVOb3ZbnCqMOdNJBZBsJTR/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmgCaxO1YQdvne3_rOJaGK4','赵欣','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCFvfROVBNhDhjP8qCjPgADib9RhRrqA6Hc6sNzvicrq4U7iaaoYhL8MuqtLppezmsfKR2WibncBJ8daB/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmGxFggJjDk7eKCROS6wnzw','徐志轩','1','1','zh_CN','','','阿鲁巴','http://wx.qlogo.cn/mmopen/ajNVdqHZLLCO6evGxt2EiaG5JnTv5BB6HOE5cy4aRMBkPu78PCqwhLLibAxFiahvfE1K56l7KibNm57iaZLyLy3FGTA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmnoQYykbWELgc0wjbZMA3I','倪春尧','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYaC0A5on6lX9wfk3gEdIVTm8aNMiayUAYjPcXCu5dTB4HDbGOpzJTU4I400icibPic5aZPSn17pRwiaB0/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmRd9KTZ_-Dy7t4bP-oNfbs','曲泽澎','1','1','zh_CN','深圳','广东','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEL6AWH9s0NNNUoGOHMpGlwz69zml14hHhe3icnaMKRXP1BicmiaWBia2u3Tfy8Dg25SkeMgDkdyC45NpQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmRYpKXwc6TyyddhndNvD5M','coco','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IdVSfMkSubXLDDIydGsSvTHlF2vkvzDXqTkaTGZB5pEw4pFqpPnjwhfRkbaSxfoORUeicEkjmfS6jw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmTaa4nL6NKXXi7Q3A-CHmc','程恋军','1','1','zh_CN','阜新','辽宁','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCAIxfb0efWibeicZxQFKRFc4m2ZzEWlSEos9icoRlkbiaLIH7HhYCXaYJQPEY4TgfibZmsnUI6UiaShwUic/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmUZaeuQw_qcxoFyoTKMeB4','刘敏','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GsFogQsdAwEIibqIpFiao0WZickkCNc0ck4ia1YyyLM5rV0p4Q6aMPGkOoAHice3QPnfib0EZIU3K2gyWg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmvH5MJfujlJWgDeTO9SaGU','天地之间','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM7WG7M0D255JbUKjtz3E2zY8DIn0I9icQHPPrHNSpQSLW1ZicOzGD3LAjkztiaTp5Ct6OZyPtgjodDUqAxBCeSYIp2sBEm3LQOpE8/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmvJFCd_DW4zZaqE6L6ALmw','李小莉','2','1','zh_CN','嘉定','上海','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYXJS13MZHXkxex9aibVDMoznZ2kicYQtEg2a4gMlicQ7TqJU2icqf90HH26yfD1Ukxl6Kx5g97vun7WX/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmvKZRkqCIASSyKqdapBy7Y',' meilina ️','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5cc62BRCAQF1a6ccJHdWM18ulyDeqK0BOknGMEaV8Nnib2lnZbVcpvzfDuPj6vpOo2dx7jK5Yo78bof6sXHnTF4nJicmFBjJDGU/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmvzJsT2zeK4VatFIK2bG0E','Roger','1','1','zh_CN','','','丹麦','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6VASStxsHkuZ6iaFnib8ibXWToUKyEH0IVSxttnhMPDspOGb9ia39hqko0OS5aHIZum1iakP8Ae0ACGQj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmW2XKZUnCk9dDtocoTmeV4','天高云淡','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCGibiaXK3VfdTSiazZmVWFiasNga4efIWqUS0wic4pnaibibC2Pp6qmS8C57jYWMvLBCfGvf9R8uCMcIeZh/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmWqpSwe6ISmTZVHVgUgcAo','雨打芭蕉','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5cc62BRCAQF1a6ccJHdWM1P4kb93D5z52VuwdvZ2PTiaCictJQ4huBbV4HiauUCL3PvNWgweTIZGptbbN6lDerRqeFS22g8HU7wk/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmxB9QJYGE6CaXaSMy6THYI','陈竟志','1','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnYQ4No5KwkaqJMfTkEWDibmsXJsSx4y50fia0bsVib7hYIUAwf4bZdWSdFPvfEbTG3m0pdQ7JW0jk6q/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wmXLGnYD7GltdVsTTCHLUlA','毛锐','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9JH4icZFZ4Bpj2WYRSHwgXSW6VUpibCakqXBjicfonhJl78wQ2Potp4pQ1sn2ibnhR2Riboj7H4GO9Go6dqrzTyggibFu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wn5zKzftAIQXxUenEoHFkOU','谢宏','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KDKG2ZnlH4HfsUbR6FjfGv3icTrE2JwEvG6bmRiaONR4xgNeJ1fNKv2VwKPibqNh2nKKKQJUm2yG9HnjKE3VdKiacd/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnb1elvNvEM2JmtOFYl6enQ','bfk','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1H3DFhTwxicQueicFjLWA6waCnHpTz5gU79srAZxt62XxtPWDvTAfPSp0Kf4vvicNBFQDxv6sptFK63A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnbPXxakMg-Ld9MgrzPVTdA','智权行修','1','1','zh_CN','闵行','上海','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeaoeKuVn7DZAagk8jU2GYIYmUUTD0KSpBy4CpPFctmB2js84jEZJGawbyjAxVMrlDYmmqnvKU2hQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wndK0DaT__9ly1yEY5sH2TA','Kaishun Wu','1','1','zh_CN','','九龙城区','中国香港','http://wx.qlogo.cn/mmopen/ajNVdqHZLLCBIzqNNcpRxajLSZV2rIzCcXCbbrsjkxdcHm3TRWuyWyickicclOcyBGtyVgn57yCpNPsCVU3EbuTg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wneeF8hOCdBBZEyvldnNoYw','丁丁丁','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCFBk0yReiaPhA9wicqycicVBQOFEMB7aut2ONYjQEo7TtrwCX9feW2ssXVWScvcWjdSGw8icRgXHdksP/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnf1hUPlcTV_Zhlopyqao8U','zhling','1','1','zh_CN','南通','江苏','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnY2149h3CiatwS524yzBnPsrxPibibsLoRjIjPpYSPiaTdFpLaicNb3SmvavqkG1hYY3Z5Gp5JsXGVf93/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnF6BEcuBVpebDRzOuf7OpI','馜亜','2','1','zh_CN','郑州','河南','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6V40AKtnqO7ZLr398VHdFw8ulaUOvzyGWRvrC1kqS1Y4nDKNtZ8JiaicI6yvVw7icQPGjISCDdMFKho/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnFrPi22mFsJob7c5tH_PLY','Роэа','2','1','zh_CN','','维也纳','奥地利','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCP4icp1DI5eavCpgFyJVPLoaGvRMia3zGAfbvrj2rAVjTXxU6KoaG2riajzk3CRKibQNBNdMvQONXWYc/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnG4Zp0TSEcZGHjbvJlgNDk','董擂','1','1','zh_CN','大连','辽宁','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLne3Vn9xx25J32bg3ZehX7QQIYjUUVQ0eInHSbIHBjaG4ONYpTC4dfyEeibAABICvj2eklhXH8aLNj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnG6mdyRj8H42GgMzu-GYU8','妮妮','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnZkKiaFE0CfSM7OQ6mds4xtxzvleMILxqPrxN0lLXibxMy05RjV8FgVR5IKXCKkPcVfdPO7icB0iaS5O/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnGc_sgMt9-BHTYx7wXOBzk','Jing','2','1','en','','乌斯怀亚','阿根廷','http://wx.qlogo.cn/mmopen/23NzhTrg1Ic0xicgpProqqtibliciaMpYZUghWibiaKP5FPMZf9thXzhn9Xicwcc626QS139z19EXWKHicpsPzCHEUEjK1nNHSgUz9mO/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnGiPY0Kv6NLdE7ggPfI37g','刘长利','1','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYdQ7E64Sfw4lQd7HbibQAoaaKfPjoa1oFicaibo7pYfwf7XPiaOVTcylCTEWGQv0gQrX6m4C1X8HauV9/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnGKVGCdfsjG3ej1XNUMTeQ','yzhu','2','1','zh_CN','沈阳','辽宁','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaELd3vm6cUJkKib7juCXWN9zLyqWk2HMpfLSE6eAHNtgVKpmO0Duvice3xnuWiccrqLCJob3U0U1JBt0Q/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnI0sVvPP-BGFsOaQkRtLxw','小牛','2','1','zh_CN','昌平','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5lV1dDNrCvh10vhS4bDCyefwaqbzNWswnKyKn87468Qot5Ogf1bmHUVIeBNYMRlQFAK3HMlvmbUsKBbLTz3icW4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnKnnoFe_Q76EQE2tOviulE','JOYCE','0','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rqlNwF3FqYmdibk6R5vZbMdnwtEu8J60vfQrJicjvaz8xh4aE1yn7UEVvc9US1CavzhiclMw4MZ7ia6n/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnLnCKLkNZUB2YUQkI-nSh8','zhong','2','1','zh_CN','','重庆','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK7ufQ2iaWWCbPpw619yd1d0KP9xNsWbySqicCv0GOc5Gb6oB49mqX6PDTibtU3DUu5sYOGo4tDvYoYzAd3lficpmDLh/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnmvQgLPCodi52b0JxpuIeU','朱斌','1','1','zh_CN','','迪拜','阿拉伯联合酋长国','http://wx.qlogo.cn/mmopen/23NzhTrg1IdTZvbYSRz7QbZPTN09XS23jqA3AKMKvUHYXF0H7TkAicVpxvVsbGJaXZ8FiaD5icKul7BTWYY30ibWU093QlEXrYKm/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnQOANhC5pO_7iy1uQ4dI0g','Tony 木安德南','1','1','zh_CN','','上海','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEKIkgTZ7UomF1nu1SW68DkSbUZIHrC7LjCicsMOUmQLAlPz5eia4hlo15lAxbVFQTlCUmBkEySicVVaA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnsOLbkSJGxyr0WkDQKS7eM','祖洁琛','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLBdeIfQFhhV4KlxYmZcjQ59Nq3vTrfMwMRrTiah2KZD03ibXeT4kPj6tjHyuRYEyeZBHL04DMbfrdhA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wntyT_rHHa44KpgqOBQk_Zk','nisp','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYU06wHIiasqnzIr565yMIg7KsZicfRkPZNfQ9XlPWoyqe1v07fnaK3PibjvW3orsrW5uGglVLOabiagB/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnWgYdTqJjcnXQpXfu9LhAw','一米阳光','1','1','zh_CN','克拉玛依','新疆','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYa6ibID80jEgFFHPCG3wHydlEibTr7V1Eice8iaE7opvwZCdY86lFfXic89icv87icPI7Decyok6LS09acp/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnXANCzW2r6v-w7kf7WtKZ4','王蓓蓓','1','1','zh_CN','','','安道尔','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6UbMibqicrgTcX8AiaxM7THKvZju0b8sfWMgVCRnMicicfWOuuPryNQ81NGMibmgkcfPpk2XjsJb9szTvs/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnXo8MlMclZVjoyXXAnu688','铁文','1','1','zh_CN','哈尔滨','黑龙江','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM4K2ibyicvHrIzMaUGGpQhYAM5ZhthD15LaPVoEs5hhJCauibrztKSp3E13pecCeMEOj2Mjs8ja0EzdQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnY86kQwzLx-dR25TWlylU8','张敏','2','1','zh_CN','西城','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCMCv5IoarQUYNrRmib5SVvzNvTw7FibQJfM1pNScKuxcYT3UlPofQMVFPnHIHy1FS7xjJ7OXZN0LEK/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnYhIio_a1otxdVooiA8lz8','刘振宇','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rvZUZrtNA7dHysvJof6IagK5T0zZ5uLOKUvUAsEr0Ovs0071ZODhd5eltGiaB3Gybue1LLjibrr0ft/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wnYRbu3iZArKKwRGyHo3-_0','霍玮','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6ZXhXh6KzvibUtQsc8yacjzo5qYSZehKN3NLWgKkapqpM5QBF62icA8wnhDB9BPWDClJDNCCDWPojn/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wo1n0nM7L_o0AHZgWENPQhY','智宸','0','1','zh_CN','','','','',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wo3ozKvBHFDINaDDq1KTPx8','H','1','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCOMI1o0722p5HH4gpKnlBlRMUHd9sibsibrLXGLQzf01aURVbmkzuszQGGRJiaLxicBoeltzXtPOLUWP/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wo6qtu55Wc3yHGW0CPSSQ80','Dentist Lu','1','1','zh_CN','利茲','英格兰','英国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLD7b9xpr5hNXT6SMYyvw4dKvkMs7GK13yorLPUybxibzsbyJ0icYQQskq5vDwxAm26sV3QVy31YANAQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wo7eKOhNLw2Abs5cHivmEZ4','→_→','1','1','zh_CN','西宁','青海','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLndDmL86eIYVWAaojeuKicrdHfj74gkslB4RLdjZLwlghmRuVsBm8tRF2oWaXfGdlnTcEbRKMcyJUX/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woaqmmTqkYTKp96T1CKRpc0','大张','2','1','zh_CN','临汾','山西','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6SBUHzE0nkewwjEibLLwtH8GPT6fdYUY7eVPV0CwQAvVIQ5LuYAiaL1QDViatxicgGQkMeKp26Q6ZhmJ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wocHz1c2cK4GAaVXKAGK2fU','温丰','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLDYvDLo2XPzuRRI0J7UibGElialtDEtnwldh6AQfweEXibiaYanECJSuW4p4O4H7xp1UGZZpUYjcafzUg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woD5RKXB5D4MQa_nzcGRq18','詹妮娜','2','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEIgexFanXiaYicE0n5eJBPPPFiauSMr3GMQW9hhJVOWJDjXb5rh9sbJrYYp2fo3hN1L4IJcV5k4QjLmw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wodmVzY6VpGAbjcP2C3hkIQ','赵改平','2','1','zh_CN','杨浦','上海','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6a7Yn1rKwSv5iaiaNzMHeb5eicI8GWopyBsU1OkJribdlD6zC8ZOQspbyoTcLxLkocIjb7OicV3TZKIQv/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woDwCCza0QwAqs9wphkEqxM','dreamweaver','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLndTKmw9FdrqmaeYxWQEJ9Brm8mqEMf2ZmGic4633c1b95vLFxOG3gkuWFgSksP95ib3bvVwuibO0ShU/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woeT6THO6sCZoogU3Dy7Ijc','啸天一山','2','1','zh_CN','','','蒙古','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK424vh4fPMLhp1qtJlrx7FMETg4MJ7zwXyA8x9s0mTEibkfMahIBX3oNqbTicmVagRVOS7a3shT9iaGVGNhNmtAQPj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woFSbmLWq6dtKVFksEgP8MU','丹','2','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icapnMDuQEV5iazJSGpeL3jCdfV2kS2fcL1mQfKXH3lSmIRU8rf8qvjTAib1dkaYHD5VY0ytUGy1Or11/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woh2evK3M2EjFrixQzKWKdo','子昂','1','1','zh_CN','宜昌','湖北','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IdTZvbYSRz7QSo5AqLsuJnENY701ECHDmQqUKeO871FmbiaWff96EkgD2EKAQN2ticEiaK3VfMxn6lEfBTMITbwv3C/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woJ4QS7A5cBdUdB-k8tfuE8','范国华','1','1','zh_CN','哈尔滨','黑龙江','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KV7w7xYOEeO9rjh1H5TEW61SByn44aGep5y2H1Z2sdOEXkYrEefBEC0diazRMgEiarpUmExlDfttz69ayrYrJsyo/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wojMtvQz2gKFPTRxhuOx0G8','鹏','1','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GUFUQzPJN4zsXiaCo5uJqIIsjJb4xyfR2DHtosW3MTGmbIWlzm3HaTWgK6mzpiayersEfHuAUeL81w/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wol0ZdDNWG0qSxhAZnCIyjc','乐乐','1','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ku1QI1hUoma6OZQUKNs5mUxS7ylEVgX26WFAB8rxqapZw4Q9Um4NFk9e84icltibwP5TqsgSVxicR1icID0UeJQT92/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wom-T3a6g8jQ04eNw4EKqQs','HuTaTa','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6dxbKkn40Cx5ibibDYQokrzX7ouqBTdS7uuQ7a3OC0vowmBWKLLwZ5JRGO7qQju3htFueFUAqGtXkw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woOutoVNAgye_zHfMgExPJ0','平凡之路','1','1','zh_TW','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcURiah0Pd9OEh3tsjAHSksSrFx0sDiaw5rXRuRDLzeyCRHhF7HNFuDiaTmyfOLWAYFic3uujys0y8SEw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woQWx4uxewZjDHwll4sfa-M','丄山丅山','2','1','zh_CN','常州','江苏','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rgQZO5e6hGicwEeyKWr0G7B7ITHGbenMicwmIPzEavTmGzxC5mY26d57lWkIVdtnarK1Gsu59StO2U/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woRL6RVgcc7bC54bxAlJ1kY','LIANG','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4EZdolKIkhHX36YFQkKdzQbGQhFUhOiam7o1IJkRbXVPIsLnjQuzBHWYKR6DxMun0X139B7jQiaZib90ic5aqraO8B/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wosNE4ZHn1GtRhRmLRjsewc','刘永椿','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1ical3XPHIpI1Mey5XvkQbTeufCs4ib07jTHtHWMZpXP08SDNVoicI3UFlI65Ia94E3ibJBnmic5yVlO0q2/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woSsX464STA5uCC2wL5NaXQ','张骥','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJoGsLkvPLhXicIJt2e2ZGEYe8LEvbBBj9IXLKbTVwtgwVKUNsmzibwfZtJWjTUhT5mWQdwHWWibYohQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wovbjLS_0D4kyGoq4IYuWLI','innocentman','1','1','zh_CN','嘉定','上海','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM4icrVjNRc1YhFQxE9jPtBILKH84IeiaGJEGywwCbXr18eyqGqvqiaptHhRYCicLqhia5RY5PJbHpPUrbybgaM4yMiapE9mK9QUvrdE4/0',NULL,'','4028d081518ba8ea01518beb97620002');
INSERT INTO `youi_wx_member` (`OPENID`,`NICKNAME`,`SEX`,`SUBSCRIBE`,`LANGUAGE`,`CITY`,`PROVINCE`,`COUNTRY`,`HEADIMGURL`,`UNIONID`,`REMARK`,`USER_ID`) VALUES 
 ('oicG7woVDRMpDx8pIA57HEm2iGoc','YYL','2','1','zh_CN','昆明','云南','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rpYXZpsznJR015bLCwlwNjNicxbxicx71KxoZWB59qXbRhicQq66Qf2nqBqlCK7VibfaibC63rHyTNTCh/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woVK0JYOqmypcP6nIz3L9JI','神秀','1','1','zh_CN','广州','广东','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6KYlv0IMyibvNvEKDJerqusAibttjmYas5vKQDcsaklIIXHs4icOaG1UNvT5IhRCjqgLUSuxCJDSBEhX1FKPG3I6X/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woWtmka8g7Mc6p41VGSU4Js','陈晓娟','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLncbkRg7AJJaodWNKapZ4XDJyibHOclMspUKQrwicLk7Xdib1bFs5g4CiaOfu6xvOK3jCcBQiaGNY7ePl8/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woyKhpPOjTmSOLpQdNM9jcQ','张张','2','1','zh_CN','普陀','上海','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnbHtAaA6QYT7TWK137qyrLdylaCnOm7t4ySFMT7NWkfQgK99Hvakv8fj9x534nlBhGmIZVFT1pu3/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7woYUCxtQ2uoNPXGx3LArAIk','地大-郑新奇-思想','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6ZXZLXOMdP722Qm3ibwNoF4MDYFqn7lEP0EupYKicKCacG5gdBzQTiazeO8xotXr6GBPZ8XXEibnTUx0/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wo_IJocf_qbSjszJrDvRXbY','迟象阳','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEIHvCd4y1SE8Me3Y7CxMrIFZGt9XRicfD6CzicvwpSnmYSkCDkibd1W3bppBPzBQMncd5R9PeKzuJGfA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wp1iflvtuJPmCwS2WaxBDd8','David','1','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/2CbEwGSnP9vllJWFylHpkjLmdlMeAYyDLvSfuDsqYyPdERuuGoibfUNJbVttB4UCfsuzibblvwJT4XC2WJTzj3icvCghB1TwgQE/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wp6LwgWcZkghvYvGBm7NpP4','許瓈文 南山保險 台灣台北','2','1','zh_TW','','台北市','中国台湾','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6xzbXTVQo2AUua9QTYvI72UsicU6tEWFncxSAGOu1kabypycDxylA0E9v6HwQ2mk2Gia1RlOFibp27v9H92Gjt6CG/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpa6AlP1nSboAFex3Rn3OCY','雷作胜','1','1','zh_CN','闸北','上海','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYXccrP9rgia2V7RKIDgaTgE4uQZnUs4QR8TrWTRzboXh8C9uhIJXeVTZsTqpofZy3mn0MwsOT8iaW2/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpA7GVNY4iI4IrwKHqcHw3M','朱四员外','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLC3Q0WxYlU4TJjibV2FTgW6DtpOJic1XdvCiaU7Xfx1CI4r6hGd9ohib7VCyCDDfWeP1T7iaZDv3CgDOug/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpAJmaEOFBa2kxi9aV0s8fU','lucky007','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAHG4Y0YVLajibe0pSAEkvbcTTk2xPibtuOicjYQOCEubRwYDiaXVqMciav90OyJX7T0t0mTfCKd9SMTl1iaSqJ9JDKzPeTOLcY8Hum4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpAUxrrQF5bkj6Ih18JNilQ','范荣辉','1','1','zh_CN','西城','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYc0nyQuM96Fa8iaQ8Sr95lJr37qicZ5ibL80eKJLMUZ0ziaxUK896I57Nd7B6Cr5OKSq0JQ2KGGjuofS/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpd3lbDE6796K3u5SxUmLRY','koala','1','1','zh_CN','','','安道尔','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Jz4WTAREfrmjoibU6a7G6gMia3fE2CytssVV6RjF0YPRqb2XmRCicibEsiaCqv3iay2wkIxiagWwGubkalInZjllsyL5a/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpeI8UhCN3LS8b8DlbqX3GA','一生平安','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4hMlV8c3WB4poslPg9SfKAicVLwKykibcS073xK8LONhV2NO2rpKic6waGyIibD3p1rGd2vr2CafcicDwujiccr0NzaF/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpFcAqFdRLrHjHhwRfWD6RY','Jinhua','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnfAdqxWmparjDf8Zncolg9YYWYGvesHzOGZnPt5ZfqOUMyleMqcakfb9zn2ymjZWpQrfAoUjDiabt/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpPQAWdvoXdnrzyKpnSitQc','Jessica❤Athena','2','1','zh_CN','虹口','上海','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEKRcbjDmO0ga4IfJSvIhKp98INun9PzCibScduMzFyhnDEicq3iaatPpzl8hIwXs790DIcHNV20kqNHg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpPzVLJWk8MuXNXxxzSBH5k','piaoluodeyu','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnZfZweULFPibtd3QYhAJU9tiaMrSwuzMQ18YZP0OEaC8ZlEeia1ERHD3kMlKCt7jOrOxOBLCKqWTWFf/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wprfOvCM1lUDINW_KU5_jLs','王晓光','1','1','zh_CN','嘉兴','浙江','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6fUicXCIb0KJh6tHEoibPNyZDptTvIWgZ0jlYzT1QzaIA6F09039znrhjVeOLkF76KA80iahE0CYnQb/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpsbpIbpZo4w_D0I64-EM8s','念一','1','1','zh_CN','包头','内蒙古','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnQZ5Vib4rd8T5vO33HEytmIBo8ZIIqVVfhMB3FtGyOibUWl5JiaxlRGR9d5yoQKR0eztoRI2Wicyczut/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpsf-v6Wg8o9hAaHSCDPdYY','何静','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/83Qlt32T2cRLq4JYE4BJnzkXu5TeYODWnc2AH9vWF5aMMFSC4QEsicZNicIFT2Neia1673zst9lxt2VTyQAoemUhDy33x7EBOTt/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wptTZHoprHUdm6HtbKYwxUc','润天妈','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rn2dnhBAt5XT29maFul22NLFrdAria0ElgI3QbcbWdagkaDtvIWicibCaiaXakicIPxWZ3olMpcOOJtZM/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpxiOWg8CZvJMLJe8SfKgdg','丢丢','2','1','zh_CN','','','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYeTDqG3ic17daHyRhbqXx2bs3cribFDVBic7otkicfrl2HYibTmXTpoYGawppLkDDWgt7HSWI1eA9pWA5/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpXmEfP8_79mlQF9NaHwkvQ','TokugawaYoshi','1','1','zh_CN','','','朝鲜','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5Y7JFqtm1ssOR3fKwANo0s1TibQ6mBsCnvF5OBjlRgCRvJg0lQ3aoGCp4zkP0epsPP2SIV4AQftqg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wpz-RFJmamzTn23E1xjo4fw','边颖','2','1','zh_CN','沈阳','辽宁','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCH8dk0jrRg19DAaC18oM0aiaz8UPlHa1JTofzmGykxCwCJkoOf572gxOjGgm6J59xxPGicDOgCucjZ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wp_XKSoyCPV-imxKunCs9EI','格勒勒','2','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAHG4Y0YVLajibe0pSAEkvbcdwDb1YjQ6FJc5cv2ZJBhziaiaRxIgo7IPcJPzMFO5Kd3vqq6jib6Haj5NgvOcuaHiajyfHZKSCibxLvQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wq3ZPYn-cJIAKcZmr4tdlvU','师华定','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLDOTsericyKicIACwYJ9GGicdI0yGiaSydOYGrACmmoicTOxqIqiaaqdVgFvkdY51bdqnO3rdeB1IVemDKA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wq6GELSCMr9louqQec2kcpg','闵超','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6aUgibkrKTGUpZ9dictPpZIKF2I5mhcCiaJqY4d3Qic4iakfXqQLdib0IrNWPAtVl8N4LSZB4gNdGQVBhZ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wq7617UW2oouwREVyovihJs','青鸟','1','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Iu3y1Oc2uvAglBVqb5ygkeTWceiaI6wNJXxdX44L3MKQgXH8VTVlSW6O0icmoBbtnBtFxic8889nDdTqnniayWSL9z/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqB32ZfHDf3X9--2OiDWHf4','李珊','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6X3F0rsumGM2N5YqXOibhiawuI9d53PqysQ9ISunuJMCyeIGp04rvr3ggsSdqmgzVLAfibcI8lOYY8C/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqB3cJw2txEuvrPmqspdnWg','问心','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6fibPFOScf90yic9YGRem8OBZ1geRibib6ozMMYxvmwlfAwjfGGCJwgq5dvzdjRCyRSTXP8MPbCkqnMT/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqCYm8RxvPQPMsZU8Zc7BK8','小黛','2','1','zh_CN','深圳','广东','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLDKrGeHuibALFQmicYUljckRKjI77SDqUPIqV4Gc0Nk129ItwfgziaQHW1T3ojo25tpOXEic5S9zibkmibw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqdhWCizJfTsU3x3C96SpYw','朱雪松','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM73UQLrMGvgPaibrESJxyECJo4kyu9Yf2SQBpfYnSBa6OoDlogJX4G1onWRkeGGdfq37AcibWK7MiaDg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqE1iQRpkt2YznqFsceXvkk','赵少凡','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcYpLsTEGricZy7B9tceR6f6Okf2JzELgJIXljQiaaerp59LMVZbR8vasHkoCOv2ZY8Njk42B93TYEA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqECRXlV5Y4bqgLvk-UB940','孟xj','2','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYSHa9ImYXjNuK4f6oaurvCdgxTEMTx7fdauFbgyA7gd5oSj4dbTEtibsZYOqicWrliblnIS8Srqo3fr/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqi0nDI0GOS-kS51qXrCbig','郑佳','0','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rkCD8tRGRGIEM8k4Cxia31x7HynHgtfarh6Kt1bwQIu0ZnRheaKibDjoGBPXOMV6yUvyWPma1QPdwq/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqJbw7Q62YNif7AH6AHIWZk','然然爸爸','1','1','zh_CN','贵阳','贵州','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IdTZvbYSRz7QR15IkF0erRqT9ib2TNYVibWLkngqicicYPCQoicBoticB5DNLGINFk2qan6u6dqWVhdkf9oEDRo1eAy2X/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqL3bueb3yc34_6aECPIgz4','乔阳','1','1','zh_CN','济南','山东','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK75oqUD0Q0LlQNm7Nk7nC2upYex3pePXWCS9oBAnHA5JeOoaLV6PPRzR99Wh3eSribYoMToQHmud2Q/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqp2rmPH_eov7R3d5EwAQcs','丑大叔Doctor Liu','1','1','zh_CN','肇庆','广东','中国','http://wx.qlogo.cn/mmopen/MWd8XRcK123XibVqx8cibpEQLdCcDfnJLiapBD0JJ5AwoVg6C9GjntypFeVtDtYrTxFicLhwauREDwySCBpdleto6NA2CTu9OTaI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqPdbJYZaSjrf4atJNQk4P0','暴风赤红','1','1','zh_CN','烟台','山东','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icasLs0MPaSFyD4b0yJPby6c7XNt7Ok0vhZKXc4nLUngDLfemPFo8XJ7onBia7R53bS3vDFfQ0pw7qb/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqQkGq7ZwLd1Lkl8Q3Wj8O4','难得糊涂','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6cu08qNRiaMEuHS3iamXRHvO1zhlCuicyxNq3Vu9GxRXAzAbDK6W9Y3BLOtIMhosMQ82L7A1hdRc80N/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqR5zr3ZhxB1a7R4oEKZN3I','大草笼','1','1','zh_CN','青岛','山东','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYedD2YWZL6t7GjjCWjBmV7icySREpRZBTyic1niaJXsyj5SibZPT4Ua6fQ6V8ibdhpOSXr2EMRO5ooLAX/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqRsLeEUmugXcw3EETKd1qA','有匪君子','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYaUvCJG0gsBGVx2qKKaqt9m1MfiaBrPDNQo3mCXMmCJnhjhdr4kiaSNlNwwicWicWm7O5peK5P32xqJH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqrWIZrTcekQqBMEUdbez-I','田庆华','1','1','zh_CN','长沙','湖南','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcjVARhtCIKf9UTqf4YgQvkVib2A4dYKHDNpL1Uww0iaGtEIAENDedfbJ9YQjpDzQcp1JSy2XEviatxg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqwOmFWl11JxDcNoW1u9_rU','小妖精薇','2','1','zh_CN','阜新','辽宁','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYbUs2ZnicC9v67ic9hG6dtKakm9QjyicCnRs53BOria4gU4NqJwTvq2j9FffKaDAMm2g9cZNJdjGPXG4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqXIQPrpPC8KcpBIlK2ePXU','彭秋菊','2','1','zh_CN','大兴','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6a3TD3mspt9EEx8S3mViaJtIDdib3hVMlZsias2iaoabSWeibW9UwI5pO7cIezUzibOlcz8CBX7Qh7L81a/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqXNL0PNOaSjC0vrxcgUE7I','任东明','1','1','zh_CN','宜昌','湖北','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAXPEnQAnl01xJGS6pJFfjfZFwMfbeicEn1cZP1kyL9BicjgLWFPibQwFLsTbDEMuWrXzrcdFtA9uwzw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqYL1Vlhe11xHh7xR6VPO_I','史凯','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1EL6RLK1INj2HeVIiaz5MlLeW2uhJ7crNKQa1icDlF6abeWanHJQrNQhNvVoAGg06OZpCu2t8G5iaQHw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqYV2fgSzvkVAu6Ks3Bpto0','魏庆来','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/1gvL9ficRs1HuSeZ4H59VWO9q18S7Xy4Uc1ECH9nI8JA7dxzXY3x6ib4oPZVo9QDPcJs68qQicbovylqUuk8qfEtycQXRXuLwTL/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqZdbebgG_pqh642eVIyj9s','Define','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLDTP8XKn5IRlIDXmh6oib0ia63SbHYsgYF5TzfZKiaSwAbZR9vMHt8ROWjibaFiadYEwSzVCWkCUGv90mw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wqZoG8zRaYg54admU-CEn3E','Barry','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJhvzcx9qPnnRUB2sIIOXDc3T3Wg41me3wiahZbDGTb2oeaPbjIsyMmhSuaKbUaIQsAichVevMT0MOw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wr25nAu-G_hMDZxPws1d6PI','春晓','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rmZFuAgdia00dAnu5Hy1o7vhfAib2yJfdt3rvbcdWDWWcSwicTnlh4HnZ9HxYPiapCZbBBdeqQmsPWnH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wr2HJMbWMPt_pF1zZ8OD8HU','徐宁','1','1','zh_CN','广州','广东','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6p6QibNnRKgXXpTMk6J1EAvXMu6OPiaBSD9kaWxIQeQsDC3mXSvwPCQIc2A9wSicHNlMB4ibgpicN2Lc8icHYibISHKBk/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wr5b12bWO8RP8w2Zzcb1y1c','Dr. Lou ','1','1','zh_CN','大连','辽宁','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM4WibaMNDicgDjY0iaW6vftJohiax663uLOV3QSmtkqY9Nxeiazy32YQawse6dXCZMvTJAdoTn1Y5yGDWQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wr6esqbjUsHRaW0vduC3oJo','YZM','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5cf3KuicdkLQPJP0RjUv1a5a1ia16JYGIN7F31WyxYaicsGJsD4tHtofLicWiaTyjOK359ribzicwjSVEJw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrANnMJYdekt6IdDpmqM6J0','筱梦','1','1','zh_CN','昆明','云南','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6Syw6FSe1RibC3x6X32tj4FGZ7Xcafr5byvTIwPicx5R1fjuAHHCFg9qlSUvL6XrE1CBGuyYuu1y1ib/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wraU5hWw4Oot0c-nJ0dmFUI',' 33  ','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYVtiaxHSYacsP7mDl4Pc8RwE0lNS4GSRIp7hBrIE6VTTBdwEZqRKpU6cS3hJq3lH0ldarKPfCzskI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrBru86SQ1329Enmi7OP348','张东霞','0','1','zh_CN','沙坪坝','重庆','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IdTZvbYSRz7QSzpfC6icNa0iaK4Ekp6gticfl5cdjWR5TPKvTibwm68dbKrOnuicmuiaxUqLSXhdSiaTtEPTicibkgbcCPJJ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrB_fKOXzCLKcRXvlvklH7I','土波鼠','1','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/MWd8XRcK123XibVqx8cibpERphEicDV77bD31WSiaEaIcIibhT3FKic4giboiaZL0jZltibnQfFTeLkiabvZC2eCDMlapcfGFgicasCjiaMF/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrC0sc4f8yS79U-iN1Wy2Wc','chengli','1','1','zh_CN','青岛','山东','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM6O1dr3umLEVMz8LPtJv3dVY7pn5z61yN6qibIFZhibJ8fSoichOkVCzovCGrq0eS6M4PiaRvQiak5k9icl3huAVdia3Jib2IEcPft5OaY/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrCanm4G_k7Uot7Nwp1LIwc','苗','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6VaicQGichLYJ9IkicyALHgTJOlKWzJTshlUwGW8KBj8W6gXn6qTFtOeFOMbmscek3SLN4nV4QUOZw3/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrEdq-41Y_LTWK57zTtjRyQ','董延超','1','1','zh_CN','','上海','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5wShu4tX8sgjdmvQK3LZdnbx7o47xFgEeTySvVCWwjN3zFdlVODnIdu9EqQ8ibW1qHXBhkwfL3M604ZhVhhpujF/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrEpdV9Cd8NL1NmDmqSFc1Q','cui wenjuan','2','1','zh_CN','莱芜','山东','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9JuhhMycJle1ia8J1eW2QcjJFMnoSXicSJibh0beNAgFU1vpdolbYsdic59d5Ds796blvTByVHEeial3nVibyHtemsH1C/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrgY2UciLe-7H3ikdw5zlEs','Junfeng','1','1','zh_CN','成都','四川','中国','',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrhaRhPpESam3z0eG2NtLf0','张桂林  ','1','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCGISqrNzYOcYwnPQUfKice9jnZQVOU5D4jPFRKFeNygRJR1DQ1S5HfsxGCzIoAJJfj7ribarbwXRJd/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wriNYwiideLp74su_uEl28E','安全一体化','1','1','zh_CN','','东京','日本','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYRfibEymVEwqeR2oragB036GgUmpqKBCYcKoLPsRQfH0qUjUsPewuUPsmGAribs1zDxt91XNhcbnD0/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrIPWQftcTXdMhTXyN3DYn4','xinxin','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/23NzhTrg1IeJYJQPavYSzibundFuErTGf1dPibFicQDUPN2ibUPTZZYH9qdeGUveNTTyR6rhLeibybOjcjqF2Gr0USEcAQcKvdbDm/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrjAIMcPVJ4p_CbJ_GbQNN4','王晔','2','1','zh_CN','呼和浩特','内蒙古','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rlbDc99zA2GiaEYpuibFYQzlSpM4t9z8FCPGDG0Em0aGWoZHbkOafyGcTp3qO5Fd39JS9QeFyLOsgI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrJW8Y8hyPv_Io-NlUhUqz4','郭艳萍','2','1','zh_CN','成都','四川','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnQ6EptXV9yjsTJVMxN1EqChJI79NUW2h7JVnNssm2JTsicC7v4dXnz0FXeCIrb6joGT19wdpx5IA6/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrLzhXHWy_6idN10d0c5DS0','左庆瑶（子凯妈妈）','2','1','en','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6blhOFdNNPAqSo6hnGBzZOKxOz93mBm4MeHRh0WR1BibzvG9iaAwBaTfNG7MdzZG3icBibXxQsXFSpvQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrMmF61uXu81uSPF9tOWTnU','星','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4pZf3YQaBchJiaDBia0ZUpFP9YgVkSrcwf4Lph2BqdQHez79aQT5e5Lbfp0X2QSJRc2rknqickOB2YQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrnZUHxmDhD8Wpb4TFCWNl4','黑桃K','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnRcxbAZEElfbKQ8eQLNqHgFcbBWz4Gbsu91IqO94PavNPVu9Ot3ywCZTfwwBGIXibt75H5RkohAHu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrOhmULckeBSXoZ9HN8vRtY','李軻','1','1','zh_TW','西安','陕西','中国','http://wx.qlogo.cn/mmopen/DkqGib4Wr2iaRzy7yELw5qUzGll5SNAiahsRUwGHsdkE2HiaH6Nib7mZUib5eFlNdwBp7LU0Z9f1ef8CP0kjfgbs9ZN6Y9OVibjAKEh/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrpgKfXTRcSGmRzRIgWmWqc','带刺的仙人掌','2','1','zh_CN','','巴塞尔乡村','瑞士','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnYcEYWXa9r1nfNLWQ0xqKYgjW7U2DsowHdIqibIk6NAlzzXEqfSUVHFzWtHiao9M3DiaXbOQMjsTMxo/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrPoWKLPl8IIM8rhig-YjwA','hongxia lan','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4PXT5iarUVwLvXRUA3Yyonk4Qe9slFiaY3SFs4GXKmFoGye3GicYo6UFcqUclN1biawnKa7uBTKib01apNAToVD7tiba/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrprl6tfcOtqmVY-Pbx0o7M','奇钢','1','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6QcQP33ibpxSGq8I6dOVNOFmEI18AXRKF8JJF4HnOnpASSsyiam6cHgotZ1sJfuRicR7YHrTfhw4E53/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrr-D43pfS6MGSFBqvd05k8','Dilber','2','1','zh_CN','','','卡塔尔','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCEQGZCurJcSv1WM9D6w00TIYabno2BBxVFxhYr4o8g6wJSu4SAiaAJfWKQBIrfDdBiarTJicstPWibf3/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrR_DE4NYjVKZC7yb89ZXfM','稻草人','1','1','zh_CN','绵阳','四川','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCKfUHIpb0WtlevsEsC0sQ4ydCHLt7Yib5BicOxIHTgicqpiaAJv9D1DiakewlR0AD0QdLeIQ4VtgnE6tw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrr_eCQy5DL81U_HVPbsUGs','懒不大','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK7NFb0HC1R0ic3nYa41MbNvem8ag6EKJe2Pso484ghyEbrt4XJ7MTxqyCsicraqHYRjXuwKibFv3haDVFZZJFGJUsZ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrtqOS20pmVoyG1-dcLmGpc','陈亮','1','1','zh_CN','','纳尔逊','新西兰','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6fqJTn7aHFoclibAXtsIT8JQ1qtf1QmhObCQiaXZia1E3VRRLdVCbfQc7hj2PDC5jeqwlL3RibhbkRvj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wruW4TBEEjMQ_JB0y7D_zNE','皓诚爹','1','1','zh_CN','通州','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1HovHhptESFTicYCpghTAeQJGpkP4sgOsy9EtKak9LtJKRARF1hwu0QK8pO7kLs2QA7ibW7gUx8uYBA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrVJD2PieFHxQn4RdwiMrJE','非一','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ku1QI1hUoma45rr4dzg86hvgOvkJatyFibfN7JOlOj27d595FA5yuN5UpfpLRLoP4eqWKaWzI0UfkvkVSSU2bFh/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrXZlSzNfKNcsl2_5wdik5Y','庄毅','1','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6Z9M8Y9aiaEzI9xK76HotOdlJBOyutnovd5X1LcQibhhakZe0EuoTTXwmic26KZicoYfWspCuNv7sXCj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrzFF2wSsDshN0N9URI35OM','耿喜军','1','1','zh_CN','淄博','山东','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCHnNjt5Fs6e1xbHibBm6ptbemOlUu3603l9VVf02UWF6mcpKV3qzJEYBnqXS6ibKz0ibLEfFJgRicMsI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wrZuD0x_FuylH83w2v7NCek','朱丽晶','2','1','zh_CN','昌平','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5wShu4tX8sgjsiaC7ESDXU8aXWzuNkhHiaQG6MlnggBF8tRqLcUXjlzuqyylltM0WztCW16eeG8ysl8geyyQ527Y/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7ws-gtPkmF3GYJ2r3DVx2b7Q','Song Francis ','1','1','zh_CN','','奥克兰','新西兰','http://wx.qlogo.cn/mmopen/ct5LeM4ZPOphHYXQhveIYeOp3gKr9GOPE9q0oVf0xTvS1uKGbFn6RufvtaIY8dpjQ0WDmBYwjeuEgtjoRicpWkzVTxmibKSpibI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7ws-lNO05NBjpuX4xQU3I3NA','杜江陵','1','1','zh_CN','','河北','中国','http://wx.qlogo.cn/mmopen/GaBia3AlPDuhNBzyz2wINcB5bLgqnWb4BDpbKMicq5JzXQXJK7WAiahufQAXjEMghV9YHsNgsH1MBK6pd4LBWRgClKdLjuAVDkd/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7ws0aQItnaBsAaorxljsQf0g','淼儿','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rheBIKE6ibLYFtSpxdyOmH2MtnXbaicPeEIzBtKawpFo2Aia0VKMibPUndaMKBxuiaicibVrtVSwKpX2CpH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7ws28j4b29AQzl-AIi6qXnL8','跃华','2','1','zh_CN','西城','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6TTAkwVxrOLbhcZEq0A4pThj0hIJBQYoZ4qt2FcW4QhOk5Sian4gHpe1VKT8gBXfyTTs6WOicptXSH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7ws5q6l1Ba6rCyACI3-DBJ0A','刚','1','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1EaHGVZXc8SH1XCnuvLxPf3vAMCJrvDtDZVme0mwxhZ5S7YibEDd0po3Yic5psRJicJnkDhY58dF8tz8RQ4AYZmkmH/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsAynbI20fq5p_HK-PVLRmE','欧小D','2','1','zh_CN','印第安纳波利斯','印第安那','美国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeeQTbj3aHGpKB1pF3Hc3XuvdYdpbbnBCjIphDgIWNfOBV5NWjQVu7FkVlExfBAq0kXo0vMuELB2fm7VIOWCKQZ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wscFBISBYRXgA6XnCmqpTaY','吴钧','1','1','zh_CN','波士顿','马萨诸塞','美国','http://wx.qlogo.cn/mmopen/kibCKu1DEGLf1vrZVITepllgyxPSQOic21lfBFUWQo7gkw7ACuy2VIp1R5JRRq2uLXmNMGzSB4h8b1HjPgdMQVaSx2YC350KBR/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsCnVBuHL7V9aEAHSn7SS7w','趙和','1','1','zh_CN','昆明','云南','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1Iebr5Du98PicraNUOPPbFxlXtrx2PCibsEs0UmWWWr1oJMhqwWuBD9tUxAssCib8x5aCDSRBLUD9cYZ3icPOjZUS4NL/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsdKiD3qDKgoD24vWtp8yCU','传杰','1','1','zh_CN','绵阳','四川','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icauYHlR5xs8d35riccCYib76G4GGkQvOINibYzHicY7WrxqT8NgzbQuibcEwAfTEca1J8f07HicKJRkZJXx/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsGt1Cfjq_9et9RVGdC6k1c','Hao Ran','1','1','zh_CN','波士顿','马萨诸塞','美国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCFBmNZelEuNthIorkIAS1oYCvsPicnbPGuSGQ0EGy6lh1pqrJCcD8ZEjx8WH2ms6AvZJznJ5ibfQcd/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsJCL7b6tHw6xOpgFQol-SA','张丽娟','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCNmdB1NukoJon6wufafOPUpFz0e0MoZt6QDqRA2CyBxX3eNKicgtlmnshZ4szZMfscHH0mywKicsKl/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsK9W6-eY5hqi6oSFI82R5M','张玉','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6RSPibmAnrVYoqlzTHJYJ46LCBT3LHPlnbNSBghzwWWdXlof5e6QIh4q9DOLtG7s8MJuwLPfp0Scn/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsKFjPNO699Ptr5e0J-ictw','华丽龙胆','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Ku1QI1hUomazGLib2iazkEAuq44WKwwAQYlABqtH7l3aR15cPasTT5mMkMJuKQcmeGO1c1OfeS9Q9aRgic73LLf2y/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wslePXNe5hR6ls660UaX0us','钟永光','1','1','zh_CN','青岛','山东','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcaeDMXtEiaG3ZGghM5A3dL6NqmuNIjrVm2b5tKliciceRGzQnXDiaQejibOZqfibc8iajQBxoicnJ2CFXYzQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsmdkbItzLOERBqVLQjqVyc','妮妮','2','1','zh_CN','','多伦多','加拿大','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6XYcGyCQ2xtObd4ic8w2csxHISv69tLXR9YOB6Vib4GAhiaoyiaJKribHXYMiayLZ7uiav47klAicWrXWZxj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsmqDHns97oeKdumwav1qmI','湘丁','2','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6bSaII3gZmgu0IfXe5KBtEQ5AWWww5O6PydFbf1BfD156icL2Qm0uWurTWMbrptdDodOlibvTwRagn/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsnhnzbJAbNLwIW3fGfFA1Q','不是生物可以吃','1','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IfZ7iaI0lCyhDFvKKJloUlUBYd1iciaicjBpEbh9pXxviaB1IpAfeovJGvgMibcAFvpro5guf0ox4pfHNLQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wso7gDsW6LNVBOElW-peVvM','阳光','1','1','zh_CN','丽江','云南','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLndNnU281MRSfiaYBlOuNv6k3bo8oyjFqM7msUiaLMxjlJWqw60ibSwHmfibhOxDTgyWtokb8ibaT3Uicum/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsoJU5sKNiNt9RgCJZyyi8c','云龙','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeD3fW6uKaLvS5kco4JrcZp70nFsQ2GzAI7qLWttSEBjwIkUUFBibxbAzmGg8uHpzBrPibAtAthtymw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsp9UOViHw8p-BEjCeXm8r0','李勇','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9Kz5hcNNX98TfbMuWGOECA7Hict9JHdKTKd4qKgq4Jia7mxDS18QUU0OZFRgl3eWDHCmiaGiceB8I5LorpcX0oD68sS/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wspGIbdcTg6OG7AnuBoU-mA','陈慧敏','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6e4AMWSoYCOMom7Yu4A0ZJeXnicKnRXghctogY0kofp7mVyMwEBw7N9YySIqhebVx6M5yHXAqsNTz/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsQph7Qdl6uJvZ8j7OjOtLI','BCC','2','1','en','西贡区','香港','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IdTZvbYSRz7QQPLQiaaKhYOBsXb3ibMQRAhmWKxl9cMeLg2VXtpIYgkzjwuJ0XWgawSbiaBsJwNnicWUWgrcicEFZhfD/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsQtXrDv_jOXqNwVQJ0YXdo','金芒果','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYdrJ4P2EORwNq8E7wzZicn2ib3QFictbzbjahXEcicpDpOB0ct7VlYXCxHh2F603Zhx3Kofibiaicjyexub/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsrwOrrSXJ92_lbMzv2EBg8','香水百合-wjh','2','1','zh_CN','长沙','湖南','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYZ86Pk5IcKhvMTebO8cZmsYoaYbRgAttyYvy3uEHSD4mWSwg8tZas7WEicrCtp6MxSpHLlcvTeaxd/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wstK6p3lDanxVGNQo8MoMo8','海泓','1','1','zh_CN','闵行','上海','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYT0KTfcX66BMnEl7picz1rb8Kal5iaOHrFsCXrVfFbfufabQicomMKhvrjJKmkvsp9M1RxqQ48UR8Hr/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsTtmwEPCTmWDYk2QL0Dliw','左','1','1','zh_CN','杭州','浙江','中国','',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wswDY0Kev9DjN7Ezt3p2Mi0','鲁文婷','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK65icE22OSbVuPpGIETBUYjE0ppYt0jYmzcyphkyZ3Fgcl81y2ZRlZoQe4ic2IFQFnl2H80yicSEnJianImaXAlIceu/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wswK0C2bJRY6WsWxfjcoRc4','大鹏展翅','1','1','zh_CN','大连','辽宁','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCOPviaquORgKQtZ8kJhk2gZ1KKgqLFq6e9fhY65jh6VHXLziaCZkMPMPm3qFniaku2sicphkqKIv7lx4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wsXt_WqQiX4LBkiaGaPKxDM','王杨','1','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rjqFPFibNvCLzA8fMMb9TNpbUebs9yrNePQ8sObQicatyJOibs944f2kUKfB3f8o39QxffaEpicM8g4Y/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7ws_RqnEOYHnsJew7YkT22xw','修行','1','1','zh_CN','','','泽西岛','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6UjE9oSc0zlAPzFbnb9869ex7uvgqIv8TugQGyL3AdZPWN2ZwbMvtf6rvwErEvtBM2nCvEribmmWx/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wt-f7i8rc4nLCg8gcGhzjwQ','张维冲','1','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6bV1wHsHUvibXLh20bS68WP3Lfic7pmrF8a7ghK0lgicD7L6XM7CVenKSUkibQHD4wRR2vQ8chlHVicPz/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wt1ba1ZK3IYnS0dndOmTzdQ','樊荣','0','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAdY7Hny0F2sPX7cqU0qYlPgJDseKMVPicq5v3XXibd7u1ibjEpxHWfxuhMq9icicnl7aUDdxqibl6iczUwvsmZfUM3xfyWbh01stlcok/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wt6oPoj9wdIHNStPOHnY9Cs','章丽娜','2','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/Q3auHgzwzM6Fb5ciaUtlEicPwGVMxV7D7z3DxkHM1j73YzMBXd8PClN3zAgZhPicibxhPoxaSplGCffNq9aGyvHs6bibdGGibqCgdWSWPSswQUGaM/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wt8NgRfL6gFWZxQqIaozHQI','梁新彦','1','1','zh_CN','太原','山西','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnZPndQpK5WC8rFHtwTXf6ib39w9G89kHmMCxBkN8ff3TPVJx8LGGkkblbg1Ns9jD3IvhONvAR6UtV/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtAFIs81LpL_DzaUVwAKf14','山河','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6VX09mX6UbhvrzywNILUfmg9AX5BDh3yvibiaTFtEeHiax9q8TeUQYM6vcARfbKZhXyNAJ5sBvv3uI0/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtAg3hdVfEk7KblJHOmOy0E','袁园','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnUhX70jgV8vNJqLtbpTFtGGEAKuCichuhB4m4OYeGpvDTaGecK7dc9725Ziaz7OcsgFRlTCIMHzm6X/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtAYyL9HEqXNQK6akAP2kDY','冯新娅','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCFJADKjziaS9Y6QROBsYExHePBWmO0ZLk8icRzvBhK7TAgF5ukMic84bjb6yvfxDciaaBpz3icoF3fNRL/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtFuXbC9ps4b6kfvWWbXmVg','格调旅程','2','1','zh_CN','南开','天津','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCHicIyBiayicZU7HXmNg9r0L1RnIG3xgnbcgVvNvKw0f4AOmV9qDSZA8b4Ficic7lZapv9AgnmxJOm3fK/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtFwKwE9BPUdI2rHn2KO66g','慧梅(融妈)','0','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAdY7Hny0F2sMxMgUUjBQsd9ssvg7kAJj0vQW9paic2j7Aia9hv9lgIfWD4FfM6qib1nJprf1fBsz02JEibibPu6cFkibkHLPCY8vbpI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtFYDAq2peU6z4bZF1TkGvM','王劲松华融宁波','1','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6Zz5d6RqrY8ye1BnpoAb7rk8heFJDb6qic2htnwW4UicQFILwJ1yjbh62EEesIvnhKQDvXzCvGvn8d/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtGuxzMjME-lrHBrsMWg66s','liang','1','1','zh_CN','','','斯里兰卡','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnZtrdsbRM7oF1Vylul2T4Hic2V4npe193oemic0V6BjEibMF7mMFSVJ8tzWhxP9SMkCCRDgeLCvSznv/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtgVC1G2FQhHATSzpuoErkk','Gsq清','2','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6WibWUScXuuodkDk74s4MwEhhr1HdJ9Hzoibq5gP6Gltia0auvh31BbukxVOwv7tJ53v6JURUOicnfPw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtJR0P2mP_qiKtCgmr6DhJA','Captain Yoghourt','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEL2kK7aZ8FjlezP53ibcpn4KUdxREcCYDzM0TPBzQbsnHsuk872nIFUSgsmDmXpHWFyX5ibicicibgLzRg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtjTuZuXsE2E3fTWyJl_TtA','亓洪良','1','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GBdEXTaUiccFA64HgYjKTHJl9btIEdcLLqSYLFfZAVR8ib8yf4WOvaicE1ZOWblviarMR4sJRULT642A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtKNl_U-tzTIIGF2GCb_lyk','mango','2','1','zh_CN','','','芬兰','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCA7n4PZ2SHBYlQBhOL6g5piaIPXiagBXtx17KBI6JUyr0F0VChEIZib8MVfIZuM41a3XaRamicIW8ENI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtkU9ELeqbZ_Z4MViftIKHk','范如霞','2','1','zh_CN','石家庄','河北','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icahMfclbFU57GdSTBSbg3TWmpfblenBlevSopUw0fIZOLX7uhibO6XzlRWYicTMCTCibsMluztmEm4Oc/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtKUprucLTzpyqFuVd6nHSw','山谷之秋','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/3pG4MtAL4b2Z2jqYsxj488eiaM15QU62uEk49k6ibGCY0srS8sSZKMvaAoZBUqaR47Rtb1mXycYohemEJ422wEZ193chrNNEicl/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtle8_nsJTnYjYrw9Drzr4I','Dongjin Xu','1','1','zh_CN','荆州','湖北','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAxoWueZ4O1K9Tdvic7kia3KVU9zxNMlgmibAMP7wk6lCYTAk5WV4pzqH72fMxVAK0MjibJo143ml2RMw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtMLmBA4RcBRQY-zA3DIL_A','flytree','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1HQLTvpo8NVx08GBiawBBOBxqsXamnQ1fBaLhiaCViahTxnAyrwmN0PIJYB6G59AseqTuOyn9a6h1Tgw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtp9fJ4khXuVS6Eq6Q3uEt8','陈影','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icahTAxqehoWZUK0rHV5LIKEWQoqtKz59oBsSKSbx2UWK8IdHG2D7R76Dv0pDefbsZloUQej9LJuCa/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtPGxsDd9omcjxHpqJpXd00','马培','2','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYbwDZibKhh2ICNsBb3ADrofkhjSVXy4QlyPU8BsvIKgRBn3hU724CFibGXSaRH6p0yB28kvtt8rL9C/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtpjaDWV0LDNwu_1QH5_GHY','木林森','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJEfDCjzYxvrKwNQqzXqnO3cqVia9IAic5F9lgrc4a9riclYsibW4VhYtRfv7sboDMAJk9daspqKRwuYA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtQ1aVjCXFlESwh_XHrl8i0','渤雅','2','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5ZHqOrLgW7LVR6iauzibZAHq6U8XPMUGSrcflqkxrR5HXTP4mWfA4S2V1bSHFZvDgoYa4kWxtDu3Bz7RutRwlKel52nRlSa81dk/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtqDIiHpETNmBBoZL6XFWBc','Lina','2','1','zh_CN','青岛','山东','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEKwUX8SjiaHlQxOSV631yMUqdGctv1aZtN72eh2THiabNY0Td5Rv3Qe5g5ChUicW5YAcjAtd5tst7rHA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtQI3RyUVSFs9Us2eY1r5Q8','Grossepointe','1','1','en','底特律','密歇根','美国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeSwXLBDJJjut4nZKqBa0V3zbR7801xoAw7nbWMicS2G6PfkTOGIAhkPvkQMIQEogboSYM9r1HPsTKQgozVnJNsw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtRMytmY_cE08iQIV7QRPbE','慧海','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1FwG1x6A2DV1icS5gibcrtt6HjOicquMYiaM1opLVO9PaPib1R2tG6TwbBJs6u0PkYiaape8qf0ViaiaUWsPw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wttsXJux8WB-aisVu4oxRCI','红色马扎','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCD4nA6nfWdiaVkibFIfjLRskfDeOicvjZ3OHufd51N1EULby0tI2SaebaQKKZzrjwic732gcia6zm1mial/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtU49gSbmGTDGAc7-RBXmqM','韩伟','2','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEIX1uu1NxUHVPAuoWDEjgWTJYtyvxc3KVdTBsRicpEhkFYoj4vwJZNU9Hy75R89SgHU9j9RP4u4iahw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtUg36MkyPvzcq_TJK8rzRk','悦','2','1','zh_CN','','','百慕大','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6d8fUiaSAicbYzbglUKqBOzjmBrTLZcmHVKjtOib9PTGZOibGUd5qprE96CibEc17J4e9L0r3rayow3fia/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtx1fagPQCbblYIvuh_m9Mg','Aa-1','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6fxmdWz00iakicF1NCXAeOxzicLBcGAlu5GFFW0riadKbz2TpWqEiaL1EtupWtsY6qhw55gQS6JhLLuRc/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtxmJ-L5GDVS8fyD8sdMG2o','Mouse Potato','1','1','zh_CN','通州','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6TfykVYCV1ItMjcMln4YjeibfrO0P0GoXY6TKiciaZKJh5FMQr78NoPs0klI1JYCyYng6ZWmCtBcuSg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtYnorp05CYTCRskjLd0OpU','张全浩','1','1','zh_CN','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IfsAkORwMyTaN0JvnuaBSzPUu6n5ibCcqCJVTF5mLGsTFjYBrxF08SpoXtQunkJheIcgnnHqTCYRiaeVozH2wMcp2/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wtYPr1uPFkvpp3rl58lh_ts','王桥','2','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6aWJicWgibSmibVCObOtpAYt4tx8BK8fgPwBiaKoG0rbL348CXpWT4XibKI8EC3NFLwWFey5ndveuMg9W/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wu-JYRoTpTIPAk1e4BekTvc','Tigerrose','2','1','en','徐汇','上海','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9IHoPL30doAiaVx6XugGmFGcSIViaP0FWUCic62mAvmarlpzhmRsV3KdUGDl2afibZS8856xWBSR8MY0w/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wu-U-EzRyqnbACdE9_MURsQ','龙存','1','1','zh_CN','广州','广东','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1Ie72QPDGiajWiaPPWrW5Ww4Gfg9CJXhvysnicL6rJSwDWXbfV1icsBS86sR2YibaczPA4E7YVyNfUrweOaC4kNPhf8Uia/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wualebbS8Fab0qA4C7_W29k','小蘑菇酱','2','1','zh_CN','','','阿尔巴尼亚','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rpVmKqtKibLBLtUPKBuwFscXS1VZHpic4WNVEiaKXvcGxiakhGUPV8JynIIdQQaLJbicKYJ3a6Fd3pg6A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuCfIdNTK0gvBzBt8Hg2tag','曹文磊','2','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6WuqOvGJRIXl0qEKBprbLLBndtKxgkq2k454yxPM7EP2GFJkaGZmib5wUv0oSYZicgXRejdBa42H91/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuDlztUi5MkYvPIxiRmlk4c','唐兵','1','1','zh_CN','长沙','湖南','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK7kKYMnvJzlXnSMZRY613Ity1Y5sDsetx6LCseWibMCF7s21ibZpGdZIH34y5CicA9gibiakAqd0Xlq0fGZMdiarKkLXM/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuEH0evTMlV94GE6Bpr-i5w','Alwei','2','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnWhH7lwiaGU9N7aJZXYfx6iaasJ0rcKLMz3rwyOXicx2WDL7OnCumMqq04ibVrMES9G1rGqUMhKCxeAE/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wugReD09SO5qyfmK6r2KMcA','林丽瑜','2','1','zh_CN','漳州','福建','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6RicT4hw3zVjcbMg8CqQ7ibTtb9yEXIPjMkCaBsxVorRKLQGpG3Wrtic5CHH82Sx0SZNgHXWceFkqLr/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuiAHpW1qEWYePPZaod-bgk','sisyxing','2','1','zh_CN','杭州','浙江','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6UZP69rzkeSkVRbmfSXzTLlMEQWwRn5XLJf4ZWNlCyoXvDuyVK4NMbibqBBZE5wxSyplPdyMnFicSo/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuIUI9ZL3VSYlPWzFEny1FQ','蔷薇_Once','2','1','zh_CN','广州','广东','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaELD2WWsR1MBhekeGKJd3h5QhUWUS1lwkkf68ibHAsAfq6MeEfmaVIJbGsHobib4PPeYmOLsDPDKS1SQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wujtAPdlNh6SI2NHmYJyDKQ','萌','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYYP5FR3p0IKTSsMf3v7ic9LBqHDn8H9ibWyibsJ7zqjeHOPbs5yia6RRn6xFhia21NyLvOpiaeIQz9sA2P/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wujwEVayAdyN9-vS0xWNZYg','text3','1','1','zh_CN','福州','福建','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYSm6tRVk0ghFQ9SKl15QoaTVXCjSK6libyKzxwL9Pz6HeSOys3ZEjpQJD5EGaBywZrwcEHxBavuub/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuk4OQaytL7Ybl6cZTnd8m4','遥','2','1','en','纽约市','纽约','美国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCF9KLZiaBLnPD86GB2mfaicib3Zciaw9Ql32hQYB8g9jicUBDuKOcOEm7kdh1iaqdzlvJdOFS5RotU1SmJ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuL4V5LT6iWdb6JCdfpG3PY','罗郁峰','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6cibEUicm9SW32IleWS7NMHbfaXicSuRBsUPxowJ6QrHdzdl6ZjWafzG9gB6DtL7DLLibgY7rExf3V79/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wulbNaX1lpjrPv3ePNCp5g8','Lebo','1','1','zh_CN','长沙','湖南','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK7Yn4IRXiaibf8xiaiaEft4xYOoGibU73xbeB23ibMVK0NZqFkcRWJYPXnBYzpicxUOpHLNgHsn8tEeibm6JzQPzKxvmoeB/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuNNQhR7pS3sncmy2sQsmNQ','Gromit','1','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCFh04ohODAO06y0VNSueMCXEEgAbtLiaKZvJmF7FWlJdudFKY07A6dOUFKvUibVXBnW2AGibC6EORHw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuRHa2VT_wKA4_kj-7SFmbM','❤','2','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5cc62BRCAQF1a6ccJHdWM1TkLeCMgSul826wkiaZ3TW3QRdFFvTvUGvWhafe2icicDOYg0ypsnP9QJCYGWgibdM64iaKL8RlUAzutg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuTMSQVH9uujykrIWpqr9Zk','郑在','1','1','zh_CN','合肥','安徽','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCLhVcl3rvtziaETROsb3SzibnBOSZdGqKdLoVHQV2VwWwYYX1Hz9m5nBZfh9zrDefibDib8AVicNDWkdj/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuU0IhrwZCghDFCgbaXNqwo','小屁丁','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCB77e3c7JQc8iapUcc2aXykCc5z9wiaskTycCpOsib1gGJNxubk7fYIIMS40UooMdziaLxPXicCZwWajx/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuuaWJokZ3yQzAd4HSoO5yU','胡秀','2','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6bnPtxcdmv7X3G1l4iaubwiaZ7DicyibWemInRIic5eR0udQQcViciaz2micnkCMiaU5sHugjgzg9HP8BWdur/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuwoIrd3QcDe8s5hobw5EzU','Hello Jone','1','1','zh_CN','荆州','湖北','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM4YPpjaxzyBlVy4GibrkHQymqI6YibEma4xyicxRdnHhKde3FEdYpO5Ce0ja3cRrBla6MaZyPvD6f2GS8UCiby881FCov9WNgmM91g/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuX-mEfO4pLHiqCnkVDa2DI','沈航','1','1','zh_CN','南京','江苏','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IcDaia4Zw4K4cpgSm9n8TwU4Oib4SHrmXchOFpwZicnBekKedsdrxgdX2g4SWkrFn0UScazxTy9q2EicA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuz0yJAP57CJ3l5z6eF3EAA','陶小疯子','2','1','zh_CN','通州','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6VqDKpKu4Pm7Kah9cp66T0wbzvricsUZ7mArVjMz3BlsyxKT2oGLBxEKRY9CF9kDzibbYX4Zia2oODy/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wuziVayHDe3RrmmAyjvWz_M','林','1','1','zh_CN','昌平','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCINR4Z88EScLt5d5Vd7Lb4EPvSyCiaPb2dRbtylTTmXMAUn4gzsvvlPq3Biaf26TjaLCxFjX2Idprf/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wv-wsUP6ZXtMSeb4sa6Hzak','lx','1','1','zh_CN','','','安道尔','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rsZhkiaVU6MCLB71qIDXPJK119w41DDDdoOyVK9Eo8l6u4uNNHjV7vWjpq70XJcm0MnzUQbxw0Ar8/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wv1bMs1K1ysy5HlrcVBW6_s','池在龙','0','1','zh_CN','波士顿','马萨诸塞','美国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK560VxsbNfJcetcOIwGA3aOU5R4GIKOCFpVUBcXIf5RP36beNrqXoZo2TrCmU7ZdPNvMhzdpwCPMt8AhBiajhFDy/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wv2f_o9QhTfenLgOEgmZuS8','莹勋勋','1','1','zh_CN','东城','北京','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnW5gM7D7NXJdHsjTUc9Vd64a2ffZy8P58HCLGFeuUpPGySCjMIDmO1bpbD3GUO9gG9iaOZzjumNx4/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wv2VrTweSmhwHhZjXRpTdRo','北半球','1','1','zh_CN','青岛','山东','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCBaouMw7m6110Hvk7Ms7k6evmnQxIDNf3bYk9ySDHaRtTLmOaNRKsEntCr93ceg3IQvFzChjjOVy/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wv7nA0KrLYBM7Dq772uwhnQ','静','2','1','zh_CN','朝阳','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCOzuyCaqlxfOTpRZdbfwW0KhibyTaybYfgkH2Z9iaKDAXhutRpfkBUlqtm18I7zSxAcmBaAf3W9K0A/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wv8EZr82_zNu4XVIhGs0Xpk','张萌','2','1','zh_CN','太原','山西','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLDJHCrqDgsiavkkO4Xe4T0D04ePW2sZ2iaWmpRMlWRZTMOLm4CrP7HqMHkE56R2oARl9WssV466bmhA/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvB8g2cr3Kw-oFhtwDmHWRY','秋田八十一','1','1','zh_CN','沙坪坝','重庆','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icamL4QRRLUFMUaXQXmmyv8kn1Jr4RAlVdfOe0OyjFgaib8icoXN6svVWaZgvmA77baWuJotX9p7adrm/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvbd3l4pGOaF0Y7VGBHw4MU','里呀听','2','1','zh_CN','武汉','湖北','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYaBTsDNaO7K0B091OdRibNjplVWl9TlKaueVV7sQ8PZ00HcwicW0esWkdKOwkRwPzibZeGZp7jsDb5ia/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvCAgEext-Na5dHAYwsHcKE','布衣牧师','1','1','zh_CN','昆明','云南','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9JI1kbMoaPe44p6M9ibJYDEy85AQWFoib13vwmRtpJmr62AK35ymelViaQvr9HiatWDH4q0gsHdOHtbaE2a5xPS7NLh/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvCvJOk388rgIAbf10kVufw','长光T2T','2','1','zh_CN','长春','吉林','中国','http://wx.qlogo.cn/mmopen/1gvL9ficRs1GDZhNGuqgLnRluGBETJFkc9SvJxmxib2GBwKSQOEuL50D583r3uAD4EZbWufaSKuk2AibjeWs9YSBeC2487Io1vp/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvD1A4aWQnnG08tRypDzwSg','袋鼠','2','1','zh_CN','广州','广东','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYQHN3S3PqiaAGOcwp2FkfAKkAIYJaW3mkMO3CNicTDUXzYxFNggDcicPZH5TIZbqBY9A9fCwiablnUEx/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvdR2Y1LofpiyZeWQgd4paw','Q','2','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5fpczySyQvIWEqaFQDuCwIcNqn6IE86JsYibD6k2O54sYcLf5gfqbfVovrG7yKcHwR0y8ViaD1HiaSQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvHkIrC6jeMhDPR8eDrKk2g','臧航','1','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9JVM3GrJ5JRicib1AWnGJgVc14icJZcZ9ibcenMSBdu8bPCYubWyvOhQ0D9IjSmvRbMbJwaic15SspT5j3AZTkPXI987/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvIsxL1TJPzNVI4NdmZTfxU','嘉谷老子','1','1','zh_CN','昆明','云南','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK6EYrJpJU7V6dcMd7CRacx00Xjf76YG4bmia7NWk6IthEwS5fQfKF4ATDeL0juib1tefjOZn3zB7nZrhfiawrjgJp1/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvKHpt__HuRQKuYslViggqg','Anyu','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCNOuNfUGscSibUZdt3mQsz1SgMdbibmJr9RJjLl6gbibSGzia0iaHcK9P1vKib9JQSlgpMYUviasRQKyepa/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvlJUTUpDmSSbXA4HLEgfiA','Dream Knight','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/PiajxSqBRaEKicpdexHOWOvLn6M0jOoOk5tOZQ8o4zyico7Nhbg793l265me5LbYvgXkqEfTkaibQ8M2QjeZyicUE6Q/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvLqo9VRt5dHE-5j0OQAVcM','晓叨','1','1','zh_CN','','北京','中国','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK796Nc66ImERELoxwGvBCJ9JNTQ4BzwDFGGuEKEr8MGJdwtkUHsJLCJkibssNdant3ZGicegRwT1YJsSofGibgwOMK/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvm8TjPYK9yBgsPVFukyC6Q','小子','1','1','zh_HK','烟台','山东','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLCnB8fiapvPPv4eX14FMtLTbPRV0chqAQ3QzLjehPUob8X5CJtChq5oLoSYbuCZLwQHibibaWiaGibib1jQ/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvq6TyVbQ3coDeuvHT26oI0','弓长志娟','0','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/LcfNKictVG829Ideuzsc4rg01zdXVXz0EDXbdHZPo19dVmA4dxnlrficEOwKo0BC28OO2cHU7cjibicN9VNoW25YWuSYvt9YbFGib/0',NULL,'张志娟','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvrEzwjqhV1cQS8l97hE2oE','周周','2','1','zh_CN','','佛罗伦萨','意大利','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK4vBlaHu3I64HPKOvhbwI8ozudOTcP2S2tV1JAOsDfnPBjHQeAoiaW7307Pe4kELKXicj34wgEC12OjyQ3U0O0jLd/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvTaqKXOcIk7HWMoGioVudQ','琴','2','1','zh_CN','徐汇','上海','中国','http://wx.qlogo.cn/mmopen/7FgrFUlWg9KGBK4eTwEvYawecyWdcDUffOBr66qOia47nz0BQAuiaxqJiayk0YymIQ3CrvRQGicnk5QOQ9p9OolCa6libgfDRNAea/0',NULL,'赵雪琴','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvuiKxnpeKbH9ypmvJ6EUDo','沛公','1','1','zh_CN','海淀','北京','中国','http://wx.qlogo.cn/mmopen/23NzhTrg1IeWBfb1UYeUCGciaEeE5dv4GZnl85jvHQmZmINKef4wYXxVTQrkXGuFsmBp6xZBxFyRt9yicpg3ibd4XYpxE3y8BWI/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvW2RS04r_wjpaKsIfu0gt0','一剑','1','1','zh_CN','','南苏瓦迪瓦','马尔代夫','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5ZibYbk7x1icaqTBcWdUXHianClXZxgIxz5TuCGMC5DWhoLE2qgfo9NxFJ1o91PuaKWW1b8sGnGc9YY9qj1gacjsW/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvwAHjoDWvkCpWe9C_pBU_c','朱腾','1','1','zh_CN','丰台','北京','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5Y5sFWv0fib3V7f6IJVyib1R96U8GERKmAV7wp2cWFVh4UHRKBEOkZWUJerndaMmKdUxPBlkMAtNhg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvxdnE6pJBY4EC6V5KUch7o','feronia179','2','1','zh_CN','通州','北京','中国','http://wx.qlogo.cn/mmopen/ajNVdqHZLLB1IlqB8HzCQhyfmfekjicwT1pfzekUvuR05PwkoWZh2hIq79cnMN7AWQviaCEXZTYbm0JgNFJibKIVw/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvXRFCFcTf3gYD9ci3IU6M0','牛进平','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/ajNVdqHZLLAHG4Y0YVLajibe0pSAEkvbcG6W3DJ8JHF8x2DHejJMncnfUoBYHI0fCg8j3ug81FEvDtO4ibsko07aTPkj3htWTSrdr6oiauAYmg/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvyqB4MMifCKfmqI7PvxWJ8','徐毅','1','1','zh_CN','西安','陕西','中国','http://wx.qlogo.cn/mmopen/Q3auHgzwzM5zUTFmgHftwbD9zsZEc7QSB4zOwKx81sNu8wAY7vgyN5vS4icvWnBcHGhc0vlVibKcibD7YyUga3L5tWL0QZECSMmctQJmfY8Ypo/0',NULL,'','4028d081518ba8ea01518beb97620002'),
 ('oicG7wvZDPR64iUVfd7UXbehwCLE','tiger','0','1','zh_CN','','','','http://wx.qlogo.cn/mmopen/BRDI5Fb8CK5QjOZj0RQ7fyBZyBdKlt1GUeYsic5icTpozibZu4x7uwvSCljywDFsLqMUM4RbaF0vTbMNG6zFE0VyaSBcFdB6DiaE/0',NULL,'','4028d081518ba8ea01518beb97620002');
/*!40000 ALTER TABLE `youi_wx_member` ENABLE KEYS */;


--
-- Definition of table `youi_wx_member_group`
--

DROP TABLE IF EXISTS `youi_wx_member_group`;
CREATE TABLE `youi_wx_member_group` (
  `ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_R_70_0101_0203` (`USER_ID`),
  CONSTRAINT `FK_R_70_0101_0203` FOREIGN KEY (`USER_ID`) REFERENCES `youi_wx_subscription` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='070203粉丝分组';

--
-- Dumping data for table `youi_wx_member_group`
--

/*!40000 ALTER TABLE `youi_wx_member_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `youi_wx_member_group` ENABLE KEYS */;


--
-- Definition of table `youi_wx_message`
--

DROP TABLE IF EXISTS `youi_wx_message`;
CREATE TABLE `youi_wx_message` (
  `MESSAGE_ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `MESSAGE_TITLE` varchar(100) DEFAULT NULL,
  `MESSAGE_CONTENT` text,
  `MESSAGE_TYPE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`MESSAGE_ID`),
  KEY `FK_R_70_0101_0303` (`USER_ID`),
  CONSTRAINT `FK_R_70_0101_0303` FOREIGN KEY (`USER_ID`) REFERENCES `youi_wx_subscription` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='700303微信消息';

--
-- Dumping data for table `youi_wx_message`
--

/*!40000 ALTER TABLE `youi_wx_message` DISABLE KEYS */;
INSERT INTO `youi_wx_message` (`MESSAGE_ID`,`USER_ID`,`MESSAGE_TITLE`,`MESSAGE_CONTENT`,`MESSAGE_TYPE`) VALUES 
 ('4028d081518ec22201518ed3b3ec0001','4028d081518ba8ea01518beb97620001','我的消息1','我的消息1','news');
/*!40000 ALTER TABLE `youi_wx_message` ENABLE KEYS */;


--
-- Definition of table `youi_wx_subscription`
--

DROP TABLE IF EXISTS `youi_wx_subscription`;
CREATE TABLE `youi_wx_subscription` (
  `USER_ID` varchar(36) NOT NULL,
  `USER_CAPTION` varchar(100) DEFAULT NULL,
  `SUBSCRIPTION_CAPTION` varchar(100) DEFAULT NULL,
  `APP_ID` varchar(40) DEFAULT NULL,
  `APP_SECRET` varchar(40) DEFAULT NULL,
  `LOGIN_NAME` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信公众号';

--
-- Dumping data for table `youi_wx_subscription`
--

/*!40000 ALTER TABLE `youi_wx_subscription` DISABLE KEYS */;
INSERT INTO `youi_wx_subscription` (`USER_ID`,`USER_CAPTION`,`SUBSCRIPTION_CAPTION`,`APP_ID`,`APP_SECRET`,`LOGIN_NAME`,`PASSWORD`) VALUES 
 ('4028d081518ba8ea01518beb97620001','测试号','youi测试号','wxfdb3ad82dd67bbb3','36dbcfb432940dfd46ac81e144f4e698','youi','e10adc3949ba59abbe56e057f20f883e'),
 ('4028d081518ba8ea01518beb97620002','科研指南针 ','科研指南针 ','wxbaf1e1bf1464cb14','047bab99b7ecee8da5330d020cfdb6e8','compass','e10adc3949ba59abbe56e057f20f883e');
/*!40000 ALTER TABLE `youi_wx_subscription` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
