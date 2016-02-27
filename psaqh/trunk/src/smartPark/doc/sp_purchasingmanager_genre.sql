/*
Navicat MySQL Data Transfer

Source Server         : loclhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-02-27 15:59:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sp_purchasingmanager_genre`
-- ----------------------------
DROP TABLE IF EXISTS `sp_purchasingmanager_genre`;
CREATE TABLE `sp_purchasingmanager_genre` (
  `PARK_BUSINESS_TUPE_` char(2) DEFAULT NULL,
  `GENRE_ID_` char(36) NOT NULL,
  `sp__GENRE_ID_` char(36) DEFAULT NULL,
  `GENRE_NAME_` varchar(128) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `GENRE_MODULE_URL_` varchar(256) DEFAULT NULL,
  `GENRE_CODE_` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`GENRE_ID_`),
  KEY `FK_Relationship_21` (`sp__GENRE_ID_`),
  CONSTRAINT `FK_Relationship_21` FOREIGN KEY (`sp__GENRE_ID_`) REFERENCES `sp_purchasingmanager_genre` (`GENRE_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='320305商品类别表';

-- ----------------------------
-- Records of sp_purchasingmanager_genre
-- ----------------------------
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e815320d801015320da4be90001', null, '急速采购', null, '2016-02-27 14:34:30', null, '2016-02-27 11:51:30', null, '01');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e815320d801015320dac7090002', null, '餐饮', null, '2016-02-27 11:52:02', null, '2016-02-27 11:52:02', null, '02');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532175090f0001', null, '公共资源', null, '2016-02-27 14:40:31', null, '2016-02-27 14:40:31', null, '03');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217585b90002', '40285e8153216adc01532175090f0001', '会议室', null, '2016-02-27 14:44:32', null, '2016-02-27 14:41:03', null, '0301');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532175b2800003', '40285e8153216adc01532175090f0001', '车辆租赁', null, '2016-02-27 14:41:14', null, '2016-02-27 14:41:14', null, '0302');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532175dd8b0004', '40285e8153216adc01532175090f0001', '广告位', null, '2016-02-27 14:41:25', null, '2016-02-27 14:41:25', null, '0303');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217685ff0005', null, '众创空间', null, '2016-02-27 14:42:09', null, '2016-02-27 14:42:09', null, '04');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532176c3ac0006', null, '企业服务', null, '2016-02-27 14:42:24', null, '2016-02-27 14:42:24', null, '05');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532176f9f10007', '40285e8153216adc01532176c3ac0006', '公司注册', null, '2016-02-27 14:42:38', null, '2016-02-27 14:42:38', null, '0501');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc015321772f9a0008', '40285e8153216adc01532176c3ac0006', '工商变更', null, '2016-02-27 14:42:52', null, '2016-02-27 14:42:52', null, '0502');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217768bf0009', '40285e8153216adc01532176c3ac0006', '认识社保', null, '2016-02-27 14:43:07', null, '2016-02-27 14:43:07', null, '0503');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217798c5000a', '40285e8153216adc01532176c3ac0006', '代理记账', null, '2016-02-27 14:43:19', null, '2016-02-27 14:43:19', null, '0504');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532177bed9000b', '40285e8153216adc01532176c3ac0006', '法律服务', null, '2016-02-27 14:43:29', null, '2016-02-27 14:43:29', null, '0505');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532177e899000c', '40285e8153216adc01532176c3ac0006', '商标专利', null, '2016-02-27 14:43:39', null, '2016-02-27 14:43:39', null, '0506');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc015321781137000d', '40285e8153216adc01532176c3ac0006', '威客服务', null, '2016-02-27 14:43:50', null, '2016-02-27 14:43:50', null, '0507');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc015321783d6a000e', null, 'IT服务', null, '2016-02-27 14:44:01', null, '2016-02-27 14:44:01', null, '06');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc015321786619000f', null, '物业报修', null, '2016-02-27 14:44:11', null, '2016-02-27 14:44:11', null, '07');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217889720010', null, '物业缴费', null, '2016-02-27 14:44:20', null, '2016-02-27 14:44:20', null, '08');
