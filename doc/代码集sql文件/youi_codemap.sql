/*
Navicat MySQL Data Transfer

Source Server         : yuanqu
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-03-02 15:12:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `youi_codemap`
-- ----------------------------
DROP TABLE IF EXISTS `youi_codemap`;
CREATE TABLE `youi_codemap` (
  `CODEMAP_ID` varchar(36) NOT NULL,
  `CODE` varchar(40) DEFAULT NULL,
  `CAPTION` varchar(80) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `EXPRESSION` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`CODEMAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='990101代码集';

-- ----------------------------
-- Records of youi_codemap
-- ----------------------------
INSERT INTO `youi_codemap` VALUES ('2c9dc604391da4c701391daaedc80001', 'codemapType', '代码集类型', '1', '');
INSERT INTO `youi_codemap` VALUES ('40283f8153168c33015316f2fa9c0001', 'payWay', '支付方式', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad53078875015307bebcbe0001', 'financingStatus', '发布状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad53078875015307bfe6520004', 'financingType', '融资状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad53078875015307c09d610007', 'recordType', '预约类型', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad53078875015307c1b80c000c', 'recordVisiteStatus', '是否到访', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad53078875015307c266c3000f', 'enterrecStatus', '预约记录状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307f0c77f0001', 'sfproName', '物业收费项目', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307f207980005', 'bx_way', '报修方式', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307f3190a0009', 'bx_type', '报修类型', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307f3fb47000d', 'bx_project', '报修项目', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307f4ddf70011', 'bx_status', '报修状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307f882a7001b', 'ts_status', '派工状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307f971ef001f', 'ser_type', '材料类别', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015307fa37580023', 'ser_name', '材料名称', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015308000cd70027', 'activityApplyStatus', '活动申请状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015308038d88002a', 'pubStatus', '公共状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a601530804d9ad0030', 'addressStatus', '地址状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a6015308057ef50033', 'yesOrNo', '是或否', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a60153081a5bbe0037', 'isAbleVisible', '是否接受回访', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aad5307d0a60153081a9204003a', 'acceptanceStatus', '投诉受理状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aae5322165501532219eb9d0002', 'buildingType', '楼栋类别', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aaf52fca91d0152fcabefdb0001', 'floorUsingStatus', '楼层使用状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aaf52fca91d0152fcae28580006', 'saleState', '销售状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288aaf52fca91d0152fcaf96140009', 'policyStatus ', '政策新闻发布状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288ab252f905180152f908e1d30001', 'roomstatus', '房间使用状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288ab2531113db015311211cf40001', 'policyApplyStatus', '政策申请状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288abc531c24bb01531c2a418c0001', 'resoStatus', '资源状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acb53314dd40153318d8a160009', 'oc_status', '一卡通预约状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acb53314dd40153318e54d8000c', 'oc_way', '一卡通办理方式', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acb53314dd40153318f0c3b000f', 'resoTime', '可用时段', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f23628bf0001', 'businessType', '园区商品类型', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f23664670002', 'orderType', '订单类型', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f2369e7a0003', 'commodityOrderStatus', '商品订单状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f23716b80004', 'foodOrderStatus', '餐饮订单状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f237601b0005', 'serviceOrderStatus', '企业服务订单状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f237f5540006', 'ITorderStatus', 'IT服务订单状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f238261a0007', 'tenementOrderStatus', '物业订单状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f238669e0008', 'resourceOrderStatus', '公共资源订单状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('40288acd52f2342b0152f277c39b0032', 'enteringStatus', '可预约状态', '1', null);
INSERT INTO `youi_codemap` VALUES ('4028d0815094e93f01509519de3e0010', 'codeProjectType', '项目类型', '1', null);
INSERT INTO `youi_codemap` VALUES ('4028d08150a1df4a0150a208fc1c0007', 'moduleWebType', 'war模块类型', '1', null);
INSERT INTO `youi_codemap` VALUES ('4028d08150f3d9900150f408a1a70001', 'adapterGroup', '适配器类型', '1', null);
INSERT INTO `youi_codemap` VALUES ('4028d08151f126740151f184dbe80001', 'sex', '性别', '1', null);
INSERT INTO `youi_codemap` VALUES ('ff80808152f2fa0a0152f316e17d0006', 'enteringTime', '预约办理时段', '1', null);
INSERT INTO `youi_codemap` VALUES ('ff80808152f2fa0a0152f38940d40009', 'bool', '是否', '1', null);
INSERT INTO `youi_codemap` VALUES ('ff80808152f2fa0a0152f38b08a7000c', 'merchant_type', '商户类型', '1', null);
