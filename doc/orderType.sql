/*
Navicat MySQL Data Transfer

Source Server         : loclhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-02-25 16:33:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sp_ordermanager_ordertype_`
-- ----------------------------
DROP TABLE IF EXISTS `sp_ordermanager_ordertype_`;
CREATE TABLE `sp_ordermanager_ordertype_` (
  `ORDERTYPE_ID_` char(36) NOT NULL,
  `ORDERTYPE_NAME_` varchar(128) DEFAULT NULL,
  `ORDERTYPE_PROJECT_NAME_` varchar(128) DEFAULT NULL,
  `ORDERTYPE_PROJECT_TEMPLATE_ADDRESS_` varchar(256) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ORDERTYPE_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='320402订单类型表';

-- ----------------------------
-- Records of sp_ordermanager_ordertype_
-- ----------------------------
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('01', '急速采购', '急速采购', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('02', '饮食餐品', '饮食餐品', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0301', '会议室', '会议室', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0302', '车辆租赁', '车辆租赁', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0303', '广告位', '广告位', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('04', '众创空间', '众创空间', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0501', '公司注册', '公司注册', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0502', '工商变更', '工商变更', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0503', '认识社保', '认识社保', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0504', '代理记账', '代理记账', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0505', '法律服务', '法律服务', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0506', '商标专利', '商标专利', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('0507', '威客服务', '威客服务', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('06', 'IT服务', 'IT服务', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('07', '物业报修', '物业报修', null, null, null, null, null);
INSERT INTO `sp_ordermanager_ordertype_` VALUES ('08', '物业缴费', '物业缴费', null, null, null, null, null);
