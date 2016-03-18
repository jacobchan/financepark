/*
Navicat MySQL Data Transfer

Source Server         : 220.249.113.12
Source Server Version : 50616
Source Host           : 220.249.113.12:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2016-03-18 15:54:10
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
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153303e0e19000e', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303cef58000a', '电脑', '68.00', null, '维修电脑', null, null, '2016-03-01 08:12:00', '2016-03-31 22:28:00', null, null, null, '1', null, null, '2016-03-11 14:57:26', null, '2016-03-01 11:34:46');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153303ec317000f', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303cef58000a', '网络', '67.00', null, '维修网络', null, null, '2016-03-01 21:23:00', '2016-03-31 22:23:00', null, null, null, '1', null, null, '2016-03-11 15:00:21', null, '2016-03-01 11:35:32');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40285e81533020490153303fdbb60010', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303d155c000b', '季付', '168.00', null, '设备数量<10台,7*24小时服务,按月巡检,备份支持,耗材配送', null, null, '2016-03-01 22:18:00', '2016-03-31 21:23:00', null, null, null, '1', null, null, '2016-03-17 16:39:41', null, '2016-03-01 11:36:44');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '402880825383941b015383a651df0001', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303d155c000b', '半年付', '288.00', null, '设备数量<10台,7*24小时服务,按月巡检,备份支持,耗材配送', null, null, '2016-03-17 15:18:00', '2016-03-15 13:16:00', null, null, null, '1', null, null, '2016-03-17 16:41:59', null, '2016-03-17 16:17:08');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '402880825383941b015383bbc7370004', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303d298b000c', '季付', '500.00', null, '设备数量<30台,7*24小时服务,按月巡检,备份支持,耗材配送', null, null, '2016-03-17 15:18:00', '2016-03-22 19:21:00', null, null, null, '1', null, null, '2016-03-17 16:40:49', null, '2016-03-17 16:40:34');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '402880825383941b015383bc865e0005', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303d298b000c', '半年付', '900.00', null, '设备数量<30台,7*24小时服务,按月巡检,备份支持,耗材配送', null, null, '2016-03-17 15:18:00', '2016-03-29 20:21:00', null, null, null, '1', null, null, '2016-03-17 16:41:23', null, '2016-03-17 16:41:23');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '402880825383941b015383bdb8ee0006', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303d3b7f000d', '季付', '888.00', null, '设备数量<60台,7*24小时服务,按月巡检,备份支持,耗材配送', null, null, '2016-03-17 16:18:00', '2016-03-23 20:22:00', null, null, null, '1', null, null, '2016-03-17 16:42:42', null, '2016-03-17 16:42:42');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '402880825383941b015383be2ddd0007', null, '40285e81532c5e7701532c6cebf70006', '40285e81533020490153303d3b7f000d', '半年付', '1588.00', null, '设备数量<60台,7*24小时服务,按月巡检,备份支持,耗材配送', null, null, '2016-03-17 16:18:00', '2016-03-24 22:23:00', null, null, null, '1', null, null, '2016-03-17 16:43:12', null, '2016-03-17 16:43:12');
INSERT INTO `sp_purchasingmanager_commodity` VALUES (null, '40288ad5537950dd015379ab0f990001', null, '40285e815321ea3b015321ef06b80001', '40285e8153216adc01532176f9f10007', '公司快速注册', '2000.00', null, '公司快速注册', null, null, '2016-03-15 14:17:00', '2016-03-15 14:17:00', null, null, null, '1', null, null, '2016-03-15 17:46:07', null, '2016-03-15 17:46:07');

-- ----------------------------
-- Table structure for `sp_purchasingmanager_commodity_extend`
-- ----------------------------
DROP TABLE IF EXISTS `sp_purchasingmanager_commodity_extend`;
CREATE TABLE `sp_purchasingmanager_commodity_extend` (
  `COMMODITY_EXTEND_ID_` char(36) NOT NULL,
  `GENRE_PROPERTY_ID_` char(36) DEFAULT NULL,
  `PARK_BUSINESS_TUPE_` char(2) DEFAULT NULL,
  `COMMODITY_EXTEND_FIELD_NAME_` varchar(128) DEFAULT NULL,
  `COMMODITY_EXTEND_FIELD_TYPE_` char(2) DEFAULT NULL,
  `COMMODITY_EXTEND_DISPLAY_NAME_` varchar(128) DEFAULT NULL,
  `COMMODITY_EXTEND_CONTENT_` text,
  `COMMODITY_EXTEND_INFORMATION_TYPE_` char(2) DEFAULT NULL,
  `COMMODITY_EXTEND_ISNOT_DISPLAY_` varchar(1) DEFAULT NULL,
  `COMMODITY_EXTEND_ISNOT_MUST_` varchar(1) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `GENRE_ID_` char(36) DEFAULT NULL,
  `COMMODITY_ID_` char(36) DEFAULT NULL,
  PRIMARY KEY (`COMMODITY_EXTEND_ID_`),
  KEY `FK_Relationship_65` (`GENRE_PROPERTY_ID_`),
  CONSTRAINT `FK_Relationship_65` FOREIGN KEY (`GENRE_PROPERTY_ID_`) REFERENCES `sp_purchasingmanager_genre_property` (`GENRE_PROPERTY_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='320302采购商品信息扩展';

-- ----------------------------
-- Records of sp_purchasingmanager_commodity_extend
-- ----------------------------
INSERT INTO `sp_purchasingmanager_commodity_extend` VALUES ('402880825383941b015383a934eb0003', '40288ad55378044d015378099fb80001', null, null, null, null, '2年', null, null, null, null, '2016-03-17 16:20:20', null, '2016-03-17 16:20:17', null, '40285e8153302049015330305e510006');

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
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217768bf0009', '40285e8153216adc01532176c3ac0006', '人事社保', null, '2016-03-01 11:15:12', null, '2016-02-27 14:43:07', null, '0503');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217798c5000a', '40285e8153216adc01532176c3ac0006', '代理记账', null, '2016-02-27 14:43:19', null, '2016-02-27 14:43:19', null, '0504');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532177bed9000b', '40285e8153216adc01532176c3ac0006', '法律服务', null, '2016-02-27 14:43:29', null, '2016-02-27 14:43:29', null, '0505');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc01532177e899000c', '40285e8153216adc01532176c3ac0006', '商标专利', null, '2016-02-27 14:43:39', null, '2016-02-27 14:43:39', null, '0506');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc015321781137000d', '40285e8153216adc01532176c3ac0006', '威客服务', null, '2016-02-27 14:43:50', null, '2016-02-27 14:43:50', null, '0507');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc015321783d6a000e', null, 'IT服务', null, '2016-02-27 14:44:01', null, '2016-02-27 14:44:01', null, '06');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc015321786619000f', null, '物业报修', null, '2016-02-27 14:44:11', null, '2016-02-27 14:44:11', null, '07');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e8153216adc0153217889720010', null, '物业缴费', null, '2016-02-27 14:44:20', null, '2016-02-27 14:44:20', null, '08');
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e815321d109015321ddcb120001', '40285e815320d801015320da4be90001', '办公用品', null, '2016-02-27 16:34:56', null, '2016-02-27 16:34:56', null, null);
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e815321d109015321ddf7ce0002', '40285e815321d109015321ddcb120001', '文件册', null, '2016-02-27 16:35:08', null, '2016-02-27 16:35:08', null, null);
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e81533020490153303cef58000a', '40285e8153216adc015321783d6a000e', '预约单次', null, '2016-03-16 14:24:46', null, '2016-03-01 11:33:33', null, null);
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e81533020490153303d155c000b', '40285e8153216adc015321783d6a000e', '套餐一', null, '2016-03-01 11:33:42', null, '2016-03-01 11:33:42', null, null);
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e81533020490153303d298b000c', '40285e8153216adc015321783d6a000e', '套餐二', null, '2016-03-01 11:33:48', null, '2016-03-01 11:33:48', null, null);
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40285e81533020490153303d3b7f000d', '40285e8153216adc015321783d6a000e', '套餐三', null, '2016-03-01 11:33:52', null, '2016-03-01 11:33:52', null, null);
INSERT INTO `sp_purchasingmanager_genre` VALUES (null, '40288082537d7a9201537e1961740002', null, '退货订单', null, '2016-03-16 14:25:05', null, '2016-03-16 14:25:05', null, '09');

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
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153356c5f015335ded6bf0001', '40285e8153216adc0153217585b90002', '公共资源预定日期', 'publicResoIdDate', null, null, null, null, null, null, '2016-03-16 14:40:33', null, '2016-03-02 13:48:29');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153356c5f015335df26ea0002', '40285e8153216adc0153217585b90002', '公共资源预定时段', 'publicResoIdTime', null, null, null, null, null, null, '2016-03-16 14:40:23', null, '2016-03-02 13:48:50');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153356c5f015335e038bf0003', '40285e8153216adc015321786619000f', '物业报修记录ID', 'orderBxId', null, null, null, null, null, null, '2016-03-02 13:50:00', null, '2016-03-02 13:50:00');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e8153364d020153364e38710001', '40285e8153216adc0153217585b90002', '公共资源ID', 'publicResoId', null, null, null, null, null, null, '2016-03-16 14:40:10', null, '2016-03-02 15:50:09');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40285e81533b1eb301533b1f7c740001', '40285e8153216adc0153217889720010', '物业缴费记录ID', 'orderChargeId', null, null, null, null, null, null, '2016-03-03 14:17:12', null, '2016-03-03 14:17:12');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('402880825383941b015383a8be200002', '40285e81533020490153303cef58000a', '故障描述', 'faultDes', null, null, null, null, null, null, '2016-03-17 16:19:47', null, '2016-03-17 16:19:47');
INSERT INTO `sp_purchasingmanager_genre_property` VALUES ('40288ad55378044d015378099fb80001', '40285e8153216adc0153217798c5000a', '服务期限', 'serviceTerm', null, null, null, null, null, null, '2016-03-15 10:10:09', null, '2016-03-15 10:10:09');

-- ----------------------------
-- Table structure for `sp_purchasingmanager_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `sp_purchasingmanager_merchant`;
CREATE TABLE `sp_purchasingmanager_merchant` (
  `MERCHANT_ID_` char(36) NOT NULL,
  `MERCHANT_NAME_` varchar(128) DEFAULT NULL,
  `MERCHANT_TYPE_` char(36) DEFAULT NULL,
  `MERCHANT_ENTERPRISE_NAME_` varchar(128) DEFAULT NULL,
  `MERCHANT_RETURN_ADDRESS_` varchar(256) DEFAULT NULL,
  `MERCHANT_SEND_ADDRESS_` varchar(256) DEFAULT NULL,
  `MERCHANT_LINKMAN_` varchar(32) DEFAULT NULL,
  `MERCHANT_LINKMAN_PHONE_` varchar(16) DEFAULT NULL,
  `PARK_BUSINESS_TUPE_` char(2) DEFAULT NULL,
  `MERCHANT_LOGO_` varchar(256) DEFAULT NULL,
  `MERCHANT_URL_` varchar(256) DEFAULT NULL,
  `MERCHANT_ABOUT_` varchar(2048) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`MERCHANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='320307商户信息表';

-- ----------------------------
-- Records of sp_purchasingmanager_merchant
-- ----------------------------
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e815321ca06015321cd20770001', '麦当劳', '40285e815320d801015320dac7090002', '麦当劳', '美国伊利诺伊州欧克布鲁克', '美国伊利诺伊州欧克布鲁克', '迈克尔', '13812345678', null, null, null, null, null, '2016-03-10 10:38:21', null, '2016-02-27 16:16:44');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e815321ea3b015321ef06b80001', '智慧园区企业服务', '40285e8153216adc01532176c3ac0006', '智慧园区', '深圳科技园', '深圳科技园', '张伟', '13812345678', null, 'uploadImages/201603/59e09869-a223-4409-8bc9-50cf7418c693.png', 'http://www.szczh.com.cn', '公司已经通过ISBO9FD001质量管理体系环境资源认证，构建了符合世界各个公司开立街坊四邻即可立即更换发生大幅缩水是个很反感复合风管很反感你放过风格很反感好烦活动 生大幅缩水是个很反感复合风管很反感你放过风格很反感好烦活动生大幅缩水是个很反感复合', null, '2016-03-17 16:05:23', null, '2016-02-27 16:53:46');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532bbee801532bc3093d0002', '物业管理公共资源', '40285e8153216adc01532175090f0001', '智慧园区', '深圳科技园', '深圳科技园', '李四', '13812345678', null, null, null, null, null, '2016-03-17 16:06:13', null, '2016-02-29 14:41:55');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6b35020004', '联想集团', '40285e815320d801015320da4be90001', '联想集团', '中国北京海淀区上地创业路6号', '中国北京海淀区上地创业路6号', '柳传志', '13821345678', null, null, null, null, null, '2016-02-29 17:45:36', null, '2016-02-29 17:45:36');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6c22540005', '智慧园区众创空间', '40285e8153216adc0153217685ff0005', '智慧园区', '深圳科技园', '深圳科技园', '张伟', '13812345678', null, null, null, null, null, '2016-03-17 16:06:23', null, '2016-02-29 17:46:37');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6cebf70006', '智慧园区IT服务', '40285e8153216adc015321783d6a000e', '智慧园区', '深圳科技园', '深圳科技园', '张伟', '13812345678', null, null, null, null, null, '2016-03-17 16:06:31', null, '2016-02-29 17:47:29');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6db7a50007', '物业管理物业报修', '40285e8153216adc015321786619000f', '智慧园区', '深圳科技园', '深圳科技园', '李四', '13812345678', null, null, null, null, null, '2016-03-17 16:06:41', null, '2016-02-29 17:48:21');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6e19640008', '物业管理物业缴费', '40285e8153216adc0153217889720010', '智慧园区', '深圳科技园', '深圳科技园', '李四', '13812345678', null, null, null, null, null, '2016-03-17 16:06:52', null, '2016-02-29 17:48:46');
