/*
Navicat MySQL Data Transfer

Source Server         : loclhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-03-14 16:28:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sp_purchasingmanager_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `sp_purchasingmanager_merchant`;
CREATE TABLE `sp_purchasingmanager_merchant` (
  `MERCHANT_ID_` char(36) NOT NULL,
  `MERCHANT_NAME_` varchar(128) DEFAULT NULL,
  `MERCHANT_TYPE_` varchar(36) DEFAULT NULL,
  `MERCHANT_ENTERPRISE_NAME_` varchar(128) DEFAULT NULL,
  `MERCHANT_RETURN_ADDRESS_` varchar(256) DEFAULT NULL,
  `MERCHANT_SEND_ADDRESS_` varchar(256) DEFAULT NULL,
  `MERCHANT_LINKMAN_` varchar(32) DEFAULT NULL,
  `MERCHANT_LINKMAN_PHONE_` varchar(16) DEFAULT NULL,
  `PARK_BUSINESS_TUPE_` char(2) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `MERCHANT_LOGO_` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`MERCHANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='320307商户信息表';

-- ----------------------------
-- Records of sp_purchasingmanager_merchant
-- ----------------------------
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e815321ca06015321cd20770001', '麦当劳', '40285e815320d801015320dac7090002', '麦当劳', '美国伊利诺伊州欧克布鲁克', '美国伊利诺伊州欧克布鲁克', '迈克尔', '13812345678', null, null, '2016-03-10 10:38:21', null, '2016-02-27 16:16:44', 'uploadImages/201603/e7b4dac4-3f38-4f78-9255-377c6a05c161.png');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e815321ea3b015321ef06b80001', '智慧园区', '40285e8153216adc01532176c3ac0006', '智慧园区', '深圳科技园', '深圳科技园', '张伟', '13812345678', null, null, '2016-03-10 10:38:09', null, '2016-02-27 16:53:46', 'uploadImages/201603/569bca73-5870-458b-a251-499bf2826ec5.png');
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532bbee801532bc3093d0002', '物业管理', '40285e8153216adc01532175090f0001', '智慧园区', '深圳科技园', '深圳科技园', '李四', '13812345678', null, null, '2016-02-29 17:49:01', null, '2016-02-29 14:41:55', null);
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6b35020004', '联想集团', '40285e815320d801015320da4be90001', '联想集团', '中国北京海淀区上地创业路6号', '中国北京海淀区上地创业路6号', '柳传志', '13821345678', null, null, '2016-02-29 17:45:36', null, '2016-02-29 17:45:36', null);
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6c22540005', '智慧园区', '40285e8153216adc0153217685ff0005', '智慧园区', '深圳科技园', '深圳科技园', '张伟', '13812345678', null, null, '2016-02-29 17:48:57', null, '2016-02-29 17:46:37', null);
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6cebf70006', '智慧园区', '40285e8153216adc015321783d6a000e', '智慧园区', '深圳科技园', '深圳科技园', '张伟', '13812345678', null, null, '2016-02-29 17:47:29', null, '2016-02-29 17:47:29', null);
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6db7a50007', '物业管理', '40285e8153216adc015321786619000f', '智慧园区', '深圳科技园', '深圳科技园', '李四', '13812345678', null, null, '2016-02-29 17:48:21', null, '2016-02-29 17:48:21', null);
INSERT INTO `sp_purchasingmanager_merchant` VALUES ('40285e81532c5e7701532c6e19640008', '物业管理', '40285e8153216adc0153217889720010', '智慧园区', '深圳科技园', '深圳科技园', '李四', '13812345678', null, null, '2016-02-29 17:48:46', null, '2016-02-29 17:48:46', null);
