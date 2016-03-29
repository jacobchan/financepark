/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : youi2

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2016-03-29 17:19:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `youi_codeitem`
-- ----------------------------
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

-- ----------------------------
-- Records of youi_codeitem
-- ----------------------------
INSERT INTO `youi_codeitem` VALUES ('2c9dc604391da4c701391dab23d70002', '2c9dc604391da4c701391daaedc80001', '1', '代码集', null);
INSERT INTO `youi_codeitem` VALUES ('2c9dc604391da4c701391dab42bd0003', '2c9dc604391da4c701391daaedc80001', '2', 'SQL代码集', null);
INSERT INTO `youi_codeitem` VALUES ('402809cb53365be001533660c94b0001', '40288aad53078875015307c266c3000f', '04', '已取消', null);
INSERT INTO `youi_codeitem` VALUES ('402809cb53365be001533661e3a60002', '40288aad53078875015307c266c3000f', '05', '未到访', null);
INSERT INTO `youi_codeitem` VALUES ('402809cb533674c5015336805c120005', '40288aad53078875015307c266c3000f', '06', '已入驻', null);
INSERT INTO `youi_codeitem` VALUES ('40283f8153168c33015316f351170002', '40283f8153168c33015316f2fa9c0001', '01', '网银', null);
INSERT INTO `youi_codeitem` VALUES ('40283f8153168c33015316f387d90003', '40283f8153168c33015316f2fa9c0001', '02', '支付宝', null);
INSERT INTO `youi_codeitem` VALUES ('40283f8153168c33015316f3c08e0004', '40283f8153168c33015316f2fa9c0001', '03', '微信', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307bf3fb60002', '40288aad53078875015307bebcbe0001', '1', '已发布', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307bf6a7c0003', '40288aad53078875015307bebcbe0001', '2', '未发布', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c023650005', '40288aad53078875015307bfe6520004', '1', '融资完成', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c051610006', '40288aad53078875015307bfe6520004', '2', '正在融资', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c0f7e30008', '40288aad53078875015307c09d610007', '04', '众创空间', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c1eab1000d', '40288aad53078875015307c1b80c000c', '01', '是', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c212f0000e', '40288aad53078875015307c1b80c000c', '02', '否', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c2aec80010', '40288aad53078875015307c266c3000f', '01', '待受理', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c2dda00011', '40288aad53078875015307c266c3000f', '02', '已受理', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad53078875015307c315be0012', '40288aad53078875015307c266c3000f', '03', '已到访', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f14bcd0002', '40288aad5307d0a6015307f0c77f0001', '01', '物业费', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f17ec70003', '40288aad5307d0a6015307f0c77f0001', '02', '水费 ', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f1af4c0004', '40288aad5307d0a6015307f0c77f0001', '03', '电费', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f24b760006', '40288aad5307d0a6015307f207980005', '00', '方式一', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f283450007', '40288aad5307d0a6015307f207980005', '01', '方式二', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f2be460008', '40288aad5307d0a6015307f207980005', '02', '方式三', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f350b2000a', '40288aad5307d0a6015307f3190a0009', '00', '空调类', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f379d5000b', '40288aad5307d0a6015307f3190a0009', '01', '水工类', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f3a8a1000c', '40288aad5307d0a6015307f3190a0009', '02', '木工类', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f445eb000e', '40288aad5307d0a6015307f3fb47000d', '00', '项目一', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f46394000f', '40288aad5307d0a6015307f3fb47000d', '01', '项目二', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f48a9a0010', '40288aad5307d0a6015307f3fb47000d', '02', '项目三', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f543160012', '40288aad5307d0a6015307f4ddf70011', '00', '待受理', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f576400013', '40288aad5307d0a6015307f4ddf70011', '01', '已受理', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f5af270014', '40288aad5307d0a6015307f4ddf70011', '02', '待接单', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f5eab60015', '40288aad5307d0a6015307f4ddf70011', '03', '已派工', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f642c70016', '40288aad5307d0a6015307f4ddf70011', '04', '已完工', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f6fec40017', '40288aad5307d0a6015307f4ddf70011', '05', '已定价', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f7aa330018', '40288aad5307d0a6015307f4ddf70011', '06', '已付款', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f7f7de0019', '40288aad5307d0a6015307f4ddf70011', '07', '已完成', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f8316e001a', '40288aad5307d0a6015307f4ddf70011', '08', '未受理', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f8c410001c', '40288aad5307d0a6015307f882a7001b', '00', '未接单', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f8ff92001d', '40288aad5307d0a6015307f882a7001b', '01', '已接单', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f931b9001e', '40288aad5307d0a6015307f882a7001b', '02', '已拒单', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f9af2d0020', '40288aad5307d0a6015307f971ef001f', '00', '类别一', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f9d2130021', '40288aad5307d0a6015307f971ef001f', '01', '类别二', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307f9f5670022', '40288aad5307d0a6015307f971ef001f', '02', '类别三', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307fa7c920024', '40288aad5307d0a6015307fa37580023', '00', '名称一', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307fa9e980025', '40288aad5307d0a6015307fa37580023', '01', '名称二', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015307face8e0026', '40288aad5307d0a6015307fa37580023', '02', '名称三', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153080321fd0028', '40288aad5307d0a6015308000cd70027', '00', '申请中', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153080349090029', '40288aad5307d0a6015308000cd70027', '01', '已结束', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a601530803d030002b', '40288aad5307d0a6015308038d88002a', '00', '状态1', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a601530803ecb2002c', '40288aad5307d0a6015308038d88002a', '01', '状态2', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a6015308041c2d002d', '40288aad5307d0a6015308038d88002a', '02', '状态3', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153080435d2002e', '40288aad5307d0a6015308038d88002a', '03', '状态4', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a601530804701a002f', '40288aad5307d0a6015308038d88002a', '04', '状态5', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a601530805159e0031', '40288aad5307d0a601530804d9ad0030', '00', '默认地址', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153080543200032', '40288aad5307d0a601530804d9ad0030', '01', '非默认地址', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a601530805af1f0034', '40288aad5307d0a6015308057ef50033', '0', '否', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a601530805c49b0035', '40288aad5307d0a6015308057ef50033', '1', '是', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081a931c0038', '40288aad5307d0a60153081a5bbe0037', '0', '是', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081aadd60039', '40288aad5307d0a60153081a5bbe0037', '1', '否', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081ac869003b', '40288aad5307d0a60153081a9204003a', '0', '待受理', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081aef54003c', '40288aad5307d0a60153081a9204003a', '1', '受理中', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081b14a6003d', '40288aad5307d0a60153081a9204003a', '2', '已受理', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081b381d003e', '40288aad5307d0a60153081a9204003a', '3', '已退回', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081b628d003f', '40288aad5307d0a60153081a9204003a', '4', '已回访', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081b8bb80040', '40288aad5307d0a60153081a9204003a', '5', '待评价', null);
INSERT INTO `youi_codeitem` VALUES ('40288aad5307d0a60153081baf660041', '40288aad5307d0a60153081a9204003a', '6', '已评价', null);
INSERT INTO `youi_codeitem` VALUES ('40288aae532216550153221a39440003', '40288aae5322165501532219eb9d0002', '01', '居民楼', null);
INSERT INTO `youi_codeitem` VALUES ('40288aae532216550153221a66510004', '40288aae5322165501532219eb9d0002', '02', '科技楼', null);
INSERT INTO `youi_codeitem` VALUES ('40288aae532216550153221a8e9b0005', '40288aae5322165501532219eb9d0002', '03', '行政楼', null);
INSERT INTO `youi_codeitem` VALUES ('40288aae532216550153221ad2f40006', '40288aae5322165501532219eb9d0002', '04', '娱乐楼', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcaca1ce0002', null, '0', '再建', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcad0e0c0003', '40288aaf52fca91d0152fcabefdb0001', '0', '再建', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcad4fab0004', '40288aaf52fca91d0152fcabefdb0001', '1', '交付中', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcad791e0005', '40288aaf52fca91d0152fcabefdb0001', '2', '已用', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcae76860007', '40288aaf52fca91d0152fcae28580006', '0', '售罄', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcaeb1660008', '40288aaf52fca91d0152fcae28580006', '1', '可以预订', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcafec23000a', '40288aaf52fca91d0152fcaf96140009', '0', '未发布', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf52fca91d0152fcb00920000b', '40288aaf52fca91d0152fcaf96140009', '1', '已发布', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf53c12a7b0153c1a9341f0002', '40288aaf53c12a7b0153c1a8f86c0001', '01', '视频会议室', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf53c12a7b0153c1a966310003', '40288aaf53c12a7b0153c1a8f86c0001', '02', '普通会议室', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf53c12a7b0153c1aa18b60005', '40288aaf53c12a7b0153c1a9bfed0004', '01', '有', null);
INSERT INTO `youi_codeitem` VALUES ('40288aaf53c12a7b0153c1aa31030006', '40288aaf53c12a7b0153c1a9bfed0004', '02', '无', null);
INSERT INTO `youi_codeitem` VALUES ('40288ab1538cb28f01538ccd47a90001', '40288ab252f905180152f908e1d30001', '02', '已售已招', null);
INSERT INTO `youi_codeitem` VALUES ('40288ab252f905180152f909de230002', '40288ab252f905180152f908e1d30001', '00', '未售', null);
INSERT INTO `youi_codeitem` VALUES ('40288ab252f905180152f90a172a0003', '40288ab252f905180152f908e1d30001', '01', '已售待招', null);
INSERT INTO `youi_codeitem` VALUES ('40288ab2531113db01531121c6d60002', '40288ab2531113db015311211cf40001', '1', '申请中', null);
INSERT INTO `youi_codeitem` VALUES ('40288ab2531113db01531122be800003', '40288ab2531113db015311211cf40001', '2', '申请成功', null);
INSERT INTO `youi_codeitem` VALUES ('40288ab2531113db01531122ec4c0004', '40288ab2531113db015311211cf40001', '3', '申请失败', null);
INSERT INTO `youi_codeitem` VALUES ('40288ab2533a65bb01533a6de7480001', '40288acd52f2342b0152f2369e7a0003', '05', '已取消', null);
INSERT INTO `youi_codeitem` VALUES ('40288abc531c24bb01531c2a88940002', '40288abc531c24bb01531c2a418c0001', '01', '可用', null);
INSERT INTO `youi_codeitem` VALUES ('40288abc531c24bb01531c2ab6970003', '40288abc531c24bb01531c2a418c0001', '02', '已预订', null);
INSERT INTO `youi_codeitem` VALUES ('40288abc531c24bb01531c2ad5960004', '40288abc531c24bb01531c2a418c0001', '03', '不可用', null);
INSERT INTO `youi_codeitem` VALUES ('40288ac05374415b015374959a120004', '40288acb53314dd40153318d8a160009', '02', '已领卡', null);
INSERT INTO `youi_codeitem` VALUES ('40288ac05374415b01537495b96f0005', '40288acb53314dd40153318d8a160009', '08', '取消', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318dd747000a', '40288acb53314dd40153318d8a160009', '00', '待处理', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318dfea0000b', '40288acb53314dd40153318d8a160009', '01', '已处理', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318e94e7000d', '40288acb53314dd40153318e54d8000c', '00', '线上', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318ec387000e', '40288acb53314dd40153318e54d8000c', '01', '线下', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318f50210010', '40288acb53314dd40153318f0c3b000f', '01', '8:00-9:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318f84490011', '40288acb53314dd40153318f0c3b000f', '02', '9:00-10:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318fb06f0012', '40288acb53314dd40153318f0c3b000f', '03', '10:00-11:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153318fdea50013', '40288acb53314dd40153318f0c3b000f', '04', '11:00-12:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd4015331900e580014', '40288acb53314dd40153318f0c3b000f', '05', '12:00-13:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd401533190413d0015', '40288acb53314dd40153318f0c3b000f', '06', '13:00-14:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153319069330016', '40288acb53314dd40153318f0c3b000f', '07', '14:00-15:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd40153319093800017', '40288acb53314dd40153318f0c3b000f', '08', '15:00-16:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acb53314dd401533190c44d0018', '40288acb53314dd40153318f0c3b000f', '09', '16:00-17:00', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f238b84c0009', '40288acd52f2342b0152f238669e0008', '01', '已预定', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f238d793000a', '40288acd52f2342b0152f238669e0008', '02', '已支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23951c2000b', '40288acd52f2342b0152f23628bf0001', '01', '急速采购', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f2397196000c', '40288acd52f2342b0152f23628bf0001', '02', '饮食', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f239918a000d', '40288acd52f2342b0152f23628bf0001', '03', '公共资源', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f239b88c000e', '40288acd52f2342b0152f23628bf0001', '04', '众创空间', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f239e7fe000f', '40288acd52f2342b0152f23628bf0001', '05', '企业服务', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23a0d250010', '40288acd52f2342b0152f23628bf0001', '06', 'IT服务', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23a3f7d0011', '40288acd52f2342b0152f23664670002', '01', '急速采购', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23aa9a60012', '40288acd52f2342b0152f23664670002', '02', '饮食餐品', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23ae7c70013', '40288acd52f2342b0152f23664670002', '0301', '会议室', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23b43a10014', '40288acd52f2342b0152f23664670002', '0302', '车辆租赁', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23b7ba50015', '40288acd52f2342b0152f23664670002', '0303', '广告位', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23ba2640016', '40288acd52f2342b0152f23664670002', '04', '众创空间', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23bd2060017', '40288acd52f2342b0152f23664670002', '0501', '公司注册', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23c10f70018', '40288acd52f2342b0152f23664670002', '0502', '工商变更', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23c687f0019', '40288acd52f2342b0152f23664670002', '0503', '认识社保', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23c89d9001a', '40288acd52f2342b0152f23664670002', '0504', '代理记账', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23cad3f001b', '40288acd52f2342b0152f23664670002', '0505', '法律服务', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23cdc59001c', '40288acd52f2342b0152f23664670002', '0506', '商标专利', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23d02b3001d', '40288acd52f2342b0152f23664670002', '0507', '威客服务', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23d3a6a001e', '40288acd52f2342b0152f23664670002', '06', 'IT服务', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23d64a4001f', '40288acd52f2342b0152f23664670002', '07', '物业报修', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23d86350020', '40288acd52f2342b0152f23664670002', '08', '物业缴费', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23deaca0021', '40288acd52f2342b0152f2369e7a0003', '01', '未支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23e02eb0022', '40288acd52f2342b0152f2369e7a0003', '02', '已支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23e1f860023', '40288acd52f2342b0152f2369e7a0003', '03', '已发货', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23e83100024', '40288acd52f2342b0152f2369e7a0003', '04', '已收货', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23ec0c80025', '40288acd52f2342b0152f23716b80004', '01', '未支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23ed9e50026', '40288acd52f2342b0152f23716b80004', '02', '已支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23efe4e0027', '40288acd52f2342b0152f23716b80004', '03', '已送餐', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23f1f640028', '40288acd52f2342b0152f23716b80004', '04', '已收货', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23f62770029', '40288acd52f2342b0152f237601b0005', '01', '未支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23f789f002a', '40288acd52f2342b0152f237601b0005', '02', '已支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23f924f002b', '40288acd52f2342b0152f237601b0005', '03', '已采购', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23fafd1002c', '40288acd52f2342b0152f237601b0005', '04', '已收货', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f23ff2a0002d', '40288acd52f2342b0152f237f5540006', '01', '未支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f24008ac002e', '40288acd52f2342b0152f237f5540006', '02', '已支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f24029f8002f', '40288acd52f2342b0152f237f5540006', '03', '已过期', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f240950e0030', '40288acd52f2342b0152f238261a0007', '01', '未支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f240a9110031', '40288acd52f2342b0152f238261a0007', '02', '已支付', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f27803fa0033', '40288acd52f2342b0152f277c39b0032', '00', '不可预约', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f27832e30034', '40288acd52f2342b0152f277c39b0032', '01', '可以预约', null);
INSERT INTO `youi_codeitem` VALUES ('40288acd52f2342b0152f27863960035', '40288acd52f2342b0152f277c39b0032', '02', '预约已满', null);
INSERT INTO `youi_codeitem` VALUES ('4028d0815094e93f01509526a09c0011', '4028d0815094e93f01509519de3e0010', 'default', '普通项目', null);
INSERT INTO `youi_codeitem` VALUES ('4028d0815094e93f01509526ce0a0012', '4028d0815094e93f01509519de3e0010', 'esb', 'esb项目', null);
INSERT INTO `youi_codeitem` VALUES ('4028d0815094e93f015095270f7b0013', '4028d0815094e93f01509519de3e0010', 'esbsso', '带SSO的ESB项目', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08150a1df4a0150a20a29e50008', '4028d08150a1df4a0150a208fc1c0007', 'esbssoweb', '集成SSO的WEB项目', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08150a1df4a0150a20afe3a0009', '4028d08150a1df4a0150a208fc1c0007', 'esbserver', 'esb业务系统', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08150f3d9900150f4090b200002', '4028d08150f3d9900150f408a1a70001', 'expression', '表达式', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08150f3d9900150f40942cf0003', '4028d08150f3d9900150f408a1a70001', 'rmi', 'rmi适配器', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08150f3d9900150f4097bd10004', '4028d08150f3d9900150f408a1a70001', 'amqp', 'amqp适配器', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08150f3d9900150f409cf930005', '4028d08150f3d9900150f408a1a70001', 'ws', 'webservice适配器', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08151f126740151f1851ade0002', '4028d08151f126740151f184dbe80001', '1', '男', null);
INSERT INTO `youi_codeitem` VALUES ('4028d08151f126740151f18533f10003', '4028d08151f126740151f184dbe80001', '2', '女', null);
INSERT INTO `youi_codeitem` VALUES ('ff80808152f2fa0a0152f321bd5b0007', 'ff80808152f2fa0a0152f316e17d0006', 'AM', '09:00-12:00', null);
INSERT INTO `youi_codeitem` VALUES ('ff80808152f2fa0a0152f321f9350008', 'ff80808152f2fa0a0152f316e17d0006', 'PM', '14:00-17:00', null);
INSERT INTO `youi_codeitem` VALUES ('ff80808152f2fa0a0152f3896b57000a', 'ff80808152f2fa0a0152f38940d40009', '0', '是', null);
INSERT INTO `youi_codeitem` VALUES ('ff80808152f2fa0a0152f3897ec0000b', 'ff80808152f2fa0a0152f38940d40009', '1', '否', null);
INSERT INTO `youi_codeitem` VALUES ('ff80808152f2fa0a0152f38b9b48000d', 'ff80808152f2fa0a0152f38b08a7000c', '01', '集采供应商', null);
INSERT INTO `youi_codeitem` VALUES ('ff80808152f2fa0a0152f38bf0fc000e', 'ff80808152f2fa0a0152f38b08a7000c', '02', '招商部门', null);
INSERT INTO `youi_codeitem` VALUES ('ff80808152f2fa0a0152f38c7a4e000f', 'ff80808152f2fa0a0152f38b08a7000c', '03', '企业服务供应商', null);
