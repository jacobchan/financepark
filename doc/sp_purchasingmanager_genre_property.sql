/*
Navicat MySQL Data Transfer

Source Server         : loclhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-03-02 15:52:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sp_purchasingmanager_genre_property`
-- ----------------------------
DROP TABLE IF EXISTS `sp_purchasingmanager_genre_property`;
CREATE TABLE `sp_purchasingmanager_genre_property` (
  `GENRE_PROPERTY_ID_` char(36) NOT NULL,
  `GENRE_ID_` char(36) DEFAULT NULL,
  `GENRE_PROPERTY_DISPLAY_NAME_` varchar(128) DEFAULT NULL,
  `GENRE_PROPERTY_FIELD_NAME_` varchar(128) DEFAULT NULL,
  `GENRE_PROPERTY_FIELD_TYPE_` char(2) DEFAULT NULL,
  `GENRE_PROPERTY_ISNOT_MUST_` varchar(1) DEFAULT NULL,
  `GENRE_PROPERTY_ISNOT_DISPLAY_` varchar(1) DEFAULT NULL,
  `GENRE_PROPERTY_DEFAULT_VALUE_` varchar(128) DEFAULT NULL,
  `GENRE_PROPERTY_FIELD_LENGTH_` int(11) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`GENRE_PROPERTY_ID_`),
  KEY `FK_Relationship_22` (`GENRE_ID_`),
  CONSTRAINT `FK_Relationship_22` FOREIGN KEY (`GENRE_ID_`) REFERENCES `sp_purchasingmanager_genre` (`GENRE_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='320306商品类属性';

-- ----------------------------
-- Records of sp_purchasingmanager_genre_property
-- ----------------------------
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153356c5f015335ded6bf0001', '40285e8153216adc01532175090f0001', '公共资源预定日期', 'publicResoIdDate', null, null, null, null, null, null, '2016-03-02 15:50:31', null, '2016-03-02 13:48:29');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153356c5f015335df26ea0002', '40285e8153216adc01532175090f0001', '公共资源预定时段', 'publicResoIdTime', null, null, null, null, null, null, '2016-03-02 15:50:25', null, '2016-03-02 13:48:50');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153356c5f015335e038bf0003', '40285e8153216adc015321786619000f', '物业报修记录ID', 'orderBxId', null, null, null, null, null, null, '2016-03-02 13:50:00', null, '2016-03-02 13:50:00');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153364d020153364e38710001', '40285e8153216adc01532175090f0001', '公共资源ID', 'publicResoId', null, null, null, null, null, null, '2016-03-02 15:50:09', null, '2016-03-02 15:50:09');
