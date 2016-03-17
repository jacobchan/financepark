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

 Date: 03/17/2016 19:31:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sp_member_role`
-- ----------------------------
DROP TABLE IF EXISTS `sp_member_role`;
CREATE TABLE `sp_member_role` (
  `MEMBER_ID_` varchar(36) NOT NULL,
  `ROLE_ID_` varchar(36) NOT NULL,
  `ID_` varchar(36) NOT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
