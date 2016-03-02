/*
Navicat MySQL Data Transfer

Source Server         : loclhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-03-01 11:37:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sp_purchasingmanager_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `sp_purchasingmanager_commodity`;
CREATE TABLE `sp_purchasingmanager_commodity` (
  `PARK_BUSINESS_TUPE_` char(2) DEFAULT NULL,
  `COMMODITY_ID_` char(36) NOT NULL,
  `CATEGORY_ID_` char(36) DEFAULT NULL,
  `MERCHANT_ID_` char(36) DEFAULT NULL,
  `GENRE_ID_` char(36) DEFAULT NULL,
  `COMMODITY_TITLE_` varchar(128) DEFAULT NULL,
  `COMMODITY_PRICE_` decimal(10,2) DEFAULT NULL,
  `COMMODITY_STOCK_` int(11) DEFAULT NULL,
  `COMMODITY_DESCRIBE_` text,
  `COMMODITY_IMAGE_` varchar(256) DEFAULT NULL,
  `COMMODITY_COVER_IMAGE_` varchar(256) DEFAULT NULL,
  `COMMODITY_UP_TIME_` varchar(20) DEFAULT NULL,
  `COMMODITY_DOWN_TIME_` varchar(20) DEFAULT NULL,
  `COMMODITY_ORIGINAL_PRICE_` decimal(10,2) DEFAULT NULL,
  `COMMODITY_HIGHEST_PRICE_` decimal(10,2) DEFAULT NULL,
  `COMMODITY_LOWEST_PRICE_` decimal(10,2) DEFAULT NULL,
  `COMMODITY_ISNOT_DISPLAY_STOCK_` varchar(1) DEFAULT NULL,
  `COMMODITY_BRAND_` varchar(128) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`COMMODITY_ID_`),
  KEY `FK_Relationship_23` (`CATEGORY_ID_`),
  KEY `FK_Relationship_24` (`GENRE_ID_`),
  KEY `FK_Relationship_29` (`MERCHANT_ID_`),
  CONSTRAINT `FK_Relationship_23` FOREIGN KEY (`CATEGORY_ID_`) REFERENCES `sp_purchasingmanager_category` (`CATEGORY_ID_`),
  CONSTRAINT `FK_Relationship_24` FOREIGN KEY (`GENRE_ID_`) REFERENCES `sp_purchasingmanager_genre` (`GENRE_ID_`),
  CONSTRAINT `FK_Relationship_29` FOREIGN KEY (`MERCHANT_ID_`) REFERENCES `sp_purchasingmanager_merchant` (`MERCHANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='320301商品信息';

-- ----------------------------
-- Records of sp_purchasingmanager_commodity
-- ----------------------------
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e815321e265015321e631f20001', null, '40285e81532c5e7701532c6b35020004', '40285e815321d109015321ddf7ce0002', '原味资料册/文件车', '13.80', '100', '齐心（COMIX）A511原味资料册/文件车 A4 60袋 橙色', null, null, '2016-02-27 23:19:00', '2016-02-27 23:24:00', null, null, null, '0', null, null, '2016-02-29 18:02:31', null, null);
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e815321ea3b015321f061a40002', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc015321772f9a0008', '经营范围变更', '1000.00', null, '经营范围变更', null, null, '2016-02-27 23:19:00', '2016-02-27 23:24:00', null, null, null, '1', null, null, '2016-02-29 17:56:04', null, null);
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81532bbee801532bc42afe0003', null, '40285e81532bbee801532bc3093d0002', '40285e8153216adc0153217585b90002', '会议室01', '100.00', null, '会议室01', null, null, '2016-02-29 01:01:00', '2016-12-01 10:08:00', null, null, null, '1', null, null, '2016-02-29 18:03:09', null, null);
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81532c5e7701532c7740370009', null, '40285e815321ca06015321cd20770001', '40285e815320d801015320dac7090002', '深海鳕鱼堡', '15.00', '1000', '深海鳕鱼堡', null, null, '2016-02-29 05:38:00', '2016-02-29 20:37:00', null, null, null, '0', null, null, '2016-02-29 17:58:46', null, '2016-02-29 17:58:46');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81532c5e7701532c7cf3b6000a', null, '40285e81532bbee801532bc3093d0002', '40285e8153216adc01532175b2800003', '别克商务车租赁', '100.00', '10', '别克商务车租赁', null, null, '2016-11-29 14:12:00', '2016-03-24 14:17:00', null, null, null, '0', null, null, '2016-02-29 18:04:59', null, '2016-02-29 18:04:59');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e815330204901533026b6660001', null, '40285e81532bbee801532bc3093d0002', '40285e8153216adc01532175dd8b0004', '广告位01', '10000.00', '1', '广告位01', null, null, '2016-03-01 08:07:00', '2016-03-09 09:13:00', null, null, null, '0', null, null, '2016-03-01 11:09:16', null, '2016-03-01 11:09:16');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153302a372a0002', null, '40285e81532c5e7701532c6c22540005', '40285e8153216adc0153217685ff0005', '创立方', '100.00', '100', '创立方', null, null, '2016-03-01 08:07:00', '2016-03-16 15:18:00', null, null, null, '0', null, null, '2016-03-01 11:13:06', null, '2016-03-01 11:13:06');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153302ace6d0003', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc01532176f9f10007', '公司注册', '1000.00', null, '公司注册', null, null, '2016-03-01 08:07:00', '2016-03-30 21:23:00', null, null, null, '1', null, null, '2016-03-01 11:13:45', null, '2016-03-01 11:13:45');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153302b3d530004', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc015321772f9a0008', '工商变更', '1000.00', null, '工商变更', null, null, '2016-03-01 08:07:00', '2016-03-16 15:17:00', null, null, null, '1', null, null, '2016-03-01 11:14:13', null, '2016-03-01 11:14:13');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153302ec8660005', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc0153217768bf0009', '人事社保', '1000.00', null, '人事社保', null, null, '2016-03-01 08:07:00', '2016-03-22 20:22:00', null, null, null, '1', null, null, '2016-03-01 11:18:05', null, '2016-03-01 11:18:05');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e8153302049015330305e510006', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc0153217798c5000a', '代理记账', '1000.00', null, '代理记账', null, null, '2016-03-01 08:07:00', '2016-03-23 21:17:00', null, null, null, '1', null, null, '2016-03-01 11:19:49', null, '2016-03-01 11:19:49');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e815330204901533030e58e0007', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc01532177bed9000b', '法律服务', '1000.00', null, '法律服务', null, null, '2016-03-01 08:07:00', '2016-03-23 21:23:00', null, null, null, '1', null, null, '2016-03-01 11:20:24', null, '2016-03-01 11:20:24');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e8153302049015330329cf50008', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc01532177e899000c', '商标专利', '1000.00', null, '商标专利', null, null, '2016-03-01 15:18:00', '2016-03-23 21:23:00', null, null, null, '1', null, null, '2016-03-01 11:22:16', null, '2016-03-01 11:22:16');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153303501730009', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc015321781137000d', '威客服务', '1000.00', null, '威客服务', null, null, '2016-03-01 09:12:00', '2016-03-23 21:23:00', null, null, null, '1', null, null, '2016-03-01 11:24:53', null, '2016-03-01 11:24:53');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153303e0e19000e', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303cef58000a', '电脑', '69.00', null, '维修电脑', null, null, '2016-03-01 08:12:00', '2016-03-31 22:28:00', null, null, null, '1', null, null, '2016-03-01 11:34:46', null, '2016-03-01 11:34:46');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153303ec317000f', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303cef58000a', '网络', '69.00', null, '维修网络', null, null, '2016-03-01 21:23:00', '2016-03-31 22:23:00', null, null, null, '1', null, null, '2016-03-01 11:35:32', null, '2016-03-01 11:35:32');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153303fdbb60010', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303d155c000b', 'IT服务套餐一', '169.00', null, '设备小于10台', null, null, '2016-03-01 22:18:00', '2016-03-31 21:23:00', null, null, null, '1', null, null, '2016-03-01 11:36:44', null, '2016-03-01 11:36:44');
