/*==============================================================*/
/* 修改人:              Jack                                     */
/* 修改表序号:     320301		                               */
/* 修改表名称:     sp_memberInfomation                            */
/*==============================================================*/
ALTER TABLE `test`.`tree_test` ADD COLUMN `test` varchar(256) ;

ALTER TABLE `sp_purchasingmanager_genre_property`
ADD COLUMN `CATEGORY_`  char(2) NULL AFTER `CREATE_TIME_`;

ALTER TABLE `sp_nm_issueNews_`
ADD COLUMN `IMAGE_URL_`  varchar(100) NULL ;
ADD COLUMN `BROWSE_COUNT_`  int(20) NULL ;
ADD COLUMN `DING_COUNT_`  int(20) NULL ;
ADD COLUMN `CAI_COUNT_`  int(20) NULL ;

ALTER TABLE `sp_bbm_building_`
ADD COLUMN `BUILDING_NAME_`  varchar(32)  NULL;



alter table sp_information_financing modify column FINANCING_SUB_ varchar(36);

alter table sp_enterbusinessmanager_rz modify column RZ_SIGN_ varchar(32);
ALTER TABLE `sp_propertyservicemanager_entrec` ADD COLUMN `ENTERING_TYPE_` varchar(2);
/*新增报修人字段*/
ALTER TABLE `sp_propertyservicemanager_bx` ADD COLUMN `MEMBERID_` varchar(36)  NULL;

ALTER TABLE `sp_reservation_record` ADD COLUMN `RECORD_CODE_` varchar(32);

ALTER TABLE `sp_lettermanager_comment` ADD COLUMN `MEMBER_ID_` varchar(36);

ALTER TABLE `sp_reservation_record` ADD COLUMN `VISITE_NAME_` varchar(32);
ALTER TABLE `sp_reservation_record` ADD COLUMN `VISITE_TEL_` varchar(32);

ALTER TABLE `sp_policy_apply` ADD COLUMN `POLICY_APPLY_CODE_` varchar(50);

ALTER TABLE `sp_activity_apply` ADD COLUMN `APPLAY_ADR_` varchar(256);

/*** 添加回访记录的拒绝理由 ***/
ALTER TABLE `sp_propertyservicemanager_cos` ADD COLUMN `BACK_REMARK_` varchar(256);

/*** 修改了预约记录表 ***/
ALTER TABLE `sp_reservation_record` ADD COLUMN `RECORD_COMMDITY_ID_` varchar(36) AFTER `VISITE_TEL_`, ADD COLUMN `COMPANY_NAME_` varchar(256) AFTER `RECORD_COMMDITY_ID_`, ADD COLUMN `COMPANY_SCALE_` varchar(2) AFTER `COMPANY_NAME_`, ADD COLUMN `INCOMING_DATE_` varchar(20) AFTER `COMPANY_SCALE_`, ADD COLUMN `COMPANY_DISCRPTION_` varchar(1024) AFTER `INCOMING_DATE_`;

/* 新增活动文档数 */
ALTER TABLE `sp_activity_apply` ADD COLUMN `DOCUMENT_COUNT_` INT(10);
/*初始化文档数*/
UPDATE sp_activity_apply a set a.DOCUMENT_COUNT_ =0;
/*update文档数*/
update sp_activity_apply a inner join (select COUNT(b.DOCUMENT_PATH_) cc,b.APPLY_ID_ as appid from sp_activity_document b GROUP BY b.APPLY_ID_) c on a.APPLY_ID_ =c.appid set a.DOCUMENT_COUNT_ = c.cc;


/** 修改订单表 **/
ALTER TABLE `sp_ordermanager_userorder` ADD COLUMN `PAY_STATUS_` varchar(2) ;
ALTER TABLE `sp_ordermanager_userorder` ADD COLUMN `PAY_RETURN_CODE_` varchar(32);

/** 修改活动评论 **/
ALTER TABLE `sp_activity_comment` CHANGE COLUMN `APPLY_ID_` `DOCUMENT_ID_` char(36) DEFAULT NULL;
ALTER TABLE `sp_activity_comment` DROP FOREIGN KEY `FK_Relationship_53`;
ALTER TABLE `sp_activity_comment` ADD CONSTRAINT `FK_Relationship_53` FOREIGN KEY (`DOCUMENT_ID_`) REFERENCES `sp_activity_document` (`DOCUMENT_ID_`);
/** 修改活动评论 添加评价星数 **/
ALTER TABLE `sp_activity_comment` ADD COLUMN `COMMENT_LEVEL_` int;
/*新增活动收藏表*/
DROP TABLE IF EXISTS `sp_favorits_favoritactivity`;
CREATE TABLE `sp_favorits_favoritactivity` (
  `FAVORIT_ACTIVITY_ID_` char(36) NOT NULL,
  `ACTIVITY_ID_` char(36) NOT NULL,
  `MEMBER_ID_` char(36) DEFAULT NULL,
  `UPDATE_USER_` char(36) DEFAULT NULL,
  `UPDATE_TIME_` datetime DEFAULT NULL,
  `CREATE_USER_` char(36) DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`FAVORIT_ACTIVITY_ID_`,`ACTIVITY_ID_`),
  KEY `FK_320701-340402` (`MEMBER_ID_`) USING BTREE,
  CONSTRAINT `FK_320701-340402` FOREIGN KEY (`MEMBER_ID_`) REFERENCES `sp_member_information` (`MEMBER_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='340402-活动收藏表';

/**乘机人实体  修改时间：2016年5月9日10:28:34    by cqf**/
alter table sp_ticket_passenger_relation
   drop primary key;

drop table if exists sp_ticket_passenger_relation;

/*==============================================================*/
/* Table: sp_ticket_passenger_relation      机票乘机人关联表                    */
/*==============================================================*/
create table sp_ticket_passenger_relation
(
   TICKET_PASSENGER_ID  varchar(36) not null,
   ITEM_ID_             char(36),
   PASSENGER_ID         char(36) not null
);

alter table sp_ticket_passenger_relation
   add primary key (TICKET_PASSENGER_ID);

alter table sp_ticket_passenger_relation add constraint FK_340502_340506 foreign key (ITEM_ID_)
      references sp_ticket_order_item (ITEM_ID_) on delete restrict on update restrict;

alter table sp_ticket_passenger_relation add constraint FK_340506_340505 foreign key (PASSENGER_ID)
      references sp_ticket_passenger (PASSENGER_ID) on delete restrict on update restrict;

/*增加一个第三方机票订单号字段*/
alter table sp_ticket_order_item add COLUMN ORDER_ID_THIRD varchar(64);
/*增加第三方酒店订单号保存字段*/
alter table sp_hotel_order add COLUMN  ORDER_ID_THIRD varchar(64);
/*增加平台系统订单号*/
alter table sp_hotel_order add COLUMN  ORDER_NUM_ varchar(64);
/*==============================================================*/
/* Table: sp_ticket_passenger     乘机人                              */
/*==============================================================*/
drop table if exists sp_ticket_passenger;
create table sp_ticket_passenger
(
   PASSENGER_ID         char(36) not null,
   name                 varchar(16),
   tel                  varchar(16),
   type                 varchar(16),
   identity_type        varchar(16),
   identity_num         varchar(16),
   insurance            varchar(32),
   input_time           timestamp
);

alter table sp_ticket_passenger
   add primary key (PASSENGER_ID);
ALTER TABLE sp_ticket_passenger ADD COLUMN ticket_num VARCHAR(32);
/**END   ------------------------------------------------**/
   
 /* 创建新闻顶或踩关联表 */
 DROP TABLE IF EXISTS `sp_nm_issuenews_d_or_c_`;
 CREATE TABLE `sp_nm_issuenews_d_or_c_` (
  `D_OR_C_ID_` varchar(36) NOT NULL DEFAULT '',
  `ISSUE_NEWS_ID_` varchar(36) DEFAULT NULL,
  `USER_IP_` varchar(16) DEFAULT NULL,
  `STATUS_` varchar(2) DEFAULT NULL,
  `CURRENT_DING_COUNT_` int(11) DEFAULT NULL,
  `CURRENT_CAI_COUNT_` int(11) DEFAULT NULL,
  PRIMARY KEY (`D_OR_C_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
   

alter table sp_enterprise_invitation add COLUMN INVITATION_STATUS_ Integer(20);

alter table sp_activity_applylist modify column APPLYLIST_TIME_ VARCHAR(20);