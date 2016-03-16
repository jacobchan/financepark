/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost
 Source Database       : youi2

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : utf-8

 Date: 03/16/2016 11:52:39 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `youi_role`
-- ----------------------------
DROP TABLE IF EXISTS `youi_role`;
CREATE TABLE `youi_role` (
  `ROLEID` varchar(32) NOT NULL,
  `ROLE_CAPTION` varchar(80) DEFAULT NULL,
  `ROLE_CODE` varchar(20) DEFAULT NULL,
  `ROLE_TYPE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='920101角色';

-- ----------------------------
--  Records of `youi_role`
-- ----------------------------
BEGIN;
INSERT INTO `youi_role` VALUES ('ROLE_actg', 'act', null, null), ('ROLE_ADMIN', '系统管理员', 'ROLE_ADMIN', '1'), ('ROLE_BUS', '服务治理管理员', null, '1'), ('ROLE_FLOW', '流程管理', null, '1'), ('ROLE_MEMBER', '会员', null, '5'), ('ROLE_MON_ADMIN', '监控配置人员', null, '1'), ('ROLE_OPER', '操作用户', 'ROLE_OPER', '1'), ('ROLE_OPER_ADMIN', '运营主管', null, '9'), ('ROLE_PLT', '代码管理人员', null, '1'), ('ROLE_QY_ACC', '财务支付', null, '6'), ('ROLE_QY_ADMIN', '企业管理员', null, '6'), ('ROLE_QY_PRO', '前台文员', null, '6'), ('ROLE_QY_USER', '企业员工', null, '6'), ('ROLE_RPT', '报表管理', null, '1'), ('ROLE_SALE_ADMIN', '招商主管', null, '7'), ('ROLE_SALE_MAG', '客户经理', null, '7'), ('ROLE_SALE_SER', '招商客服', null, '7'), ('ROLE_SUBSCRIPTION', '公众号用户', 'ROLE_SUBSCRIPTION', '1'), ('ROLE_TENE_ADMIN', '物业主管', null, '8'), ('ROLE_TENE_OPER', '维修员工', null, '8'), ('ROLE_TENE_SEC', '岗亭保安', null, '8'), ('ROLE_TENE_SER', '物业客服', null, '8'), ('ROLE_USER', '普通用户', 'ROLE_USER', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
