/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/2/23 15:28:28                           */
/*==============================================================*/


alter table sp_OrderManager_commodityDetail
   drop primary key;

drop table if exists sp_OrderManager_commodityDetail;

alter table sp_OrderManager_orderMerchan_nexus
   drop primary key;

drop table if exists sp_OrderManager_orderMerchan_nexus;

alter table sp_OrderManager_orderProjectType_
   drop primary key;

drop table if exists sp_OrderManager_orderProjectType_;

alter table sp_OrderManager_orderProjectType_value_
   drop primary key;

drop table if exists sp_OrderManager_orderProjectType_value_;

alter table sp_OrderManager_orderType_
   drop primary key;

drop table if exists sp_OrderManager_orderType_;

alter table sp_OrderManager_userOrder
   drop primary key;

drop table if exists sp_OrderManager_userOrder;

alter table sp_PayManager_ordre_payFlow
   drop primary key;

drop table if exists sp_PayManager_ordre_payFlow;

alter table sp_activity_apply
   drop primary key;

drop table if exists sp_activity_apply;

alter table sp_activity_applyList
   drop primary key;

drop table if exists sp_activity_applyList;

alter table sp_activity_comment
   drop primary key;

drop table if exists sp_activity_comment;

alter table sp_activity_document
   drop primary key;

drop table if exists sp_activity_document;

alter table sp_bbm_building_
   drop primary key;

drop table if exists sp_bbm_building_;

alter table sp_bbm_floor_
   drop primary key;

drop table if exists sp_bbm_floor_;

alter table sp_bbm_park_
   drop primary key;

drop table if exists sp_bbm_park_;

alter table sp_bbm_room_
   drop primary key;

drop table if exists sp_bbm_room_;

alter table sp_enterbusinessmanager_rz
   drop primary key;

drop table if exists sp_enterbusinessmanager_rz;

alter table sp_enterprise_employees
   drop primary key;

drop table if exists sp_enterprise_employees;

alter table sp_enterprise_invitation
   drop primary key;

drop table if exists sp_enterprise_invitation;

alter table sp_enterprise_role
   drop primary key;

drop table if exists sp_enterprise_role;

alter table sp_etype_enterprisetype
   drop primary key;

drop table if exists sp_etype_enterprisetype;

alter table sp_favorits_favoritGoods
   drop primary key;

drop table if exists sp_favorits_favoritGoods;

alter table sp_information_financing
   drop primary key;

drop table if exists sp_information_financing;

alter table sp_information_knowledge
   drop primary key;

drop table if exists sp_information_knowledge;

alter table sp_information_legal
   drop primary key;

drop table if exists sp_information_legal;

alter table sp_information_media
   drop primary key;

drop table if exists sp_information_media;

alter table sp_information_notice
   drop primary key;

drop table if exists sp_information_notice;

alter table sp_information_product
   drop primary key;

drop table if exists sp_information_product;

alter table sp_lettermanager_comment
   drop primary key;

drop table if exists sp_lettermanager_comment;

alter table sp_lettermanager_letter
   drop primary key;

drop table if exists sp_lettermanager_letter;

alter table sp_mc_msgDatas_
   drop primary key;

drop table if exists sp_mc_msgDatas_;

alter table sp_mc_msgTempalate_
   drop primary key;

drop table if exists sp_mc_msgTempalate_;

alter table sp_mc_msgType_
   drop primary key;

drop table if exists sp_mc_msgType_;

alter table sp_memberAdr_address
   drop primary key;

drop table if exists sp_memberAdr_address;

alter table sp_member_comment
   drop primary key;

drop table if exists sp_member_comment;

alter table sp_member_information
   drop primary key;

drop table if exists sp_member_information;

alter table sp_nm_issueFlow_
   drop primary key;

drop table if exists sp_nm_issueFlow_;

alter table sp_nm_issueNews_
   drop primary key;

drop table if exists sp_nm_issueNews_;

alter table sp_nm_issueTempalate_
   drop primary key;

drop table if exists sp_nm_issueTempalate_;

alter table sp_nm_issueType_
   drop primary key;

drop table if exists sp_nm_issueType_;

alter table sp_policy_apply
   drop primary key;

drop table if exists sp_policy_apply;

alter table sp_propertyservicemanager_bx
   drop primary key;

drop table if exists sp_propertyservicemanager_bx;

alter table sp_propertyservicemanager_charge
   drop primary key;

drop table if exists sp_propertyservicemanager_charge;

alter table sp_propertyservicemanager_cos
   drop primary key;

drop table if exists sp_propertyservicemanager_cos;

alter table sp_propertyservicemanager_entering
   drop primary key;

drop table if exists sp_propertyservicemanager_entering;

alter table sp_propertyservicemanager_entrec
   drop primary key;

drop table if exists sp_propertyservicemanager_entrec;

alter table sp_propertyservicemanager_fkcode_
   drop primary key;

drop table if exists sp_propertyservicemanager_fkcode_;

alter table sp_propertyservicemanager_fxtdc
   drop primary key;

drop table if exists sp_propertyservicemanager_fxtdc;

alter table sp_propertyservicemanager_moverec
   drop primary key;

drop table if exists sp_propertyservicemanager_moverec;

alter table sp_propertyservicemanager_oc
   drop primary key;

drop table if exists sp_propertyservicemanager_oc;

alter table sp_propertyservicemanager_ser
   drop primary key;

drop table if exists sp_propertyservicemanager_ser;

alter table sp_propertyservicemanager_sfpro
   drop primary key;

drop table if exists sp_propertyservicemanager_sfpro;

alter table sp_propertyservicemanager_ts
   drop primary key;

drop table if exists sp_propertyservicemanager_ts;

alter table sp_propertyservicemanager_twcrd
   drop primary key;

drop table if exists sp_propertyservicemanager_twcrd;

alter table sp_propertyservicenanager_back
   drop primary key;

drop table if exists sp_propertyservicenanager_back;

alter table sp_publicutilitiesmanager_reso
   drop primary key;

drop table if exists sp_publicutilitiesmanager_reso;

alter table sp_purchasingManager_category
   drop primary key;

drop table if exists sp_purchasingManager_category;

alter table sp_purchasingManager_commodity
   drop primary key;

drop table if exists sp_purchasingManager_commodity;

alter table sp_purchasingManager_commodity_extend
   drop primary key;

drop table if exists sp_purchasingManager_commodity_extend;

alter table sp_purchasingManager_commodity_extend_value
   drop primary key;

drop table if exists sp_purchasingManager_commodity_extend_value;

alter table sp_purchasingManager_genre
   drop primary key;

drop table if exists sp_purchasingManager_genre;

alter table sp_purchasingManager_genre_property
   drop primary key;

drop table if exists sp_purchasingManager_genre_property;

alter table sp_purchasingManager_merchant
   drop primary key;

drop table if exists sp_purchasingManager_merchant;

alter table sp_purchasingManager_merchant_address_
   drop primary key;

drop table if exists sp_purchasingManager_merchant_address_;

alter table sp_reservation_record
   drop primary key;

drop table if exists sp_reservation_record;

alter table sp_shoppingCar_catering
   drop primary key;

drop table if exists sp_shoppingCar_catering;

alter table sp_shoppingCar_companyServer
   drop primary key;

drop table if exists sp_shoppingCar_companyServer;

alter table sp_shoppingCar_group
   drop primary key;

drop table if exists sp_shoppingCar_group;

/*==============================================================*/
/* Table: sp_OrderManager_commodityDetail                       */
/*==============================================================*/
create table sp_OrderManager_commodityDetail
(
   COMMODITYDETAIL_ID_  char(36) not null,
   USERORDER_ID_        char(36),
   COMMODITY_ID_        char(36),
   COMMODITYDETAIL_COMMODITY_ID_ char(36),
   COMMODITYDETAIL_NUM_ int,
   COMMODITYDETAIL_URL_ varchar(256),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_OrderManager_commodityDetail comment '320405订单商品明细';

alter table sp_OrderManager_commodityDetail
   add primary key (COMMODITYDETAIL_ID_);

/*==============================================================*/
/* Table: sp_OrderManager_orderMerchan_nexus                    */
/*==============================================================*/
create table sp_OrderManager_orderMerchan_nexus
(
   ORDERMERCHAN_NEXUS_ID_ char(36) not null,
   MERCHANT_ID_         char(36),
   USERORDER_ID_        char(36),
   ORDERMERCHAN_NEXUS_EXPRESS_ORDER_ varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_OrderManager_orderMerchan_nexus comment '320406订单商户关系表';

alter table sp_OrderManager_orderMerchan_nexus
   add primary key (ORDERMERCHAN_NEXUS_ID_);

/*==============================================================*/
/* Table: sp_OrderManager_orderProjectType_                     */
/*==============================================================*/
create table sp_OrderManager_orderProjectType_
(
   ORDERPROJECTTYPE_ID_ char(36) not null,
   ORDERTYPE_ID_        char(36),
   ORDERPROJECTTYPE_DISPLAY_NAME_ varchar(128),
   ORDERPROJECTTYPE_FIELD_NAME_ varchar(128),
   ORDERPROJECTTYPE_FIELD_TYPE_ char(2),
   ORDERPROJECTTYPE_FIELD_LENGTH_ int,
   ORDERPROJECTTYPE_DEFAULT_VALUE_ varchar(128),
   ORDERPROJECTTYPE_CHECK_FORMAT_ varchar(64),
   ORDERPROJECTTYPE_ISNOT_MUST_ varchar(1),
   ORDERPROJECTTYPE_ISNOT_DISPLAY_ varchar(1),
   ORDERPROJECTTYPE_OPTION_CODESET_ varchar(32),
   ORDERPROJECTTYPE_SORT_CHAR_ varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_OrderManager_orderProjectType_ comment '320403订单项目类型表';

alter table sp_OrderManager_orderProjectType_
   add primary key (ORDERPROJECTTYPE_ID_);

/*==============================================================*/
/* Table: sp_OrderManager_orderProjectType_value_               */
/*==============================================================*/
create table sp_OrderManager_orderProjectType_value_
(
   ORDERPROJECTTYPE_VALUE_ID_ char(36) not null,
   USERORDER_ID_        char(36),
   ORDERPROJECTTYPE_ID_ char(36),
   ORDERPROJECTTYPE_VALUE_DISPLAY_NAME_ varchar(128),
   ORDERPROJECTTYPE_VALUE_FIELD_NAME_ varchar(128),
   ORDERPROJECTTYPE_VALUE_FIELD_VALUE_ text,
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_OrderManager_orderProjectType_value_ comment '320404订单项目值表';

alter table sp_OrderManager_orderProjectType_value_
   add primary key (ORDERPROJECTTYPE_VALUE_ID_);

/*==============================================================*/
/* Table: sp_OrderManager_orderType_                            */
/*==============================================================*/
create table sp_OrderManager_orderType_
(
   ORDERTYPE_ID_        char(36) not null,
   ORDERTYPE_NAME_      varchar(128),
   ORDERTYPE_PROJECT_NAME_ varchar(128),
   ORDERTYPE_PROJECT_TEMPLATE_ADDRESS_ varchar(256),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_OrderManager_orderType_ comment '320402订单类型表';

alter table sp_OrderManager_orderType_
   add primary key (ORDERTYPE_ID_);

/*==============================================================*/
/* Table: sp_OrderManager_userOrder                             */
/*==============================================================*/
create table sp_OrderManager_userOrder
(
   USERORDER_ID_        char(36) not null,
   MEMBER_ID_           char(36),
   ORDERTYPE_ID_        char(36),
   BX_ID_               varchar(36),
   USERORDER_CODE_      varchar(32),
   USERORDER_PROJECT_   varchar(128),
   USERORDER_AMOUNT_    decimal(10,2),
   USERORDER_STATUS_    char(2),
   USERORDER_TIME_      varchar(20),
   USERORDER_BUY_USER_  varchar(64),
   USERORDER_PAY_MODE_  char(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_OrderManager_userOrder comment '320401用户订单表';

alter table sp_OrderManager_userOrder
   add primary key (USERORDER_ID_);

/*==============================================================*/
/* Table: sp_PayManager_ordre_payFlow                           */
/*==============================================================*/
create table sp_PayManager_ordre_payFlow
(
   ORDER_PAYFLOW_ID_    char(36) not null,
   ORDER_PAYFLOW_CODE_  varchar(32),
   ORDER_PAYFLOW_ORDER_CODE_ varchar(32),
   ORDER_PAYFLOW_ORDER_PAYMODE_ char(2),
   ORDER_PAYFLOW_PAY_AMOUNT_ decimal(10,2),
   ORDER_PAYFLOW_PAY_PROJECT_ varchar(128),
   ORDER_PAYFLOW_PAY_TIME_ varchar(20),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_PayManager_ordre_payFlow comment '320801订单支付流水表';

alter table sp_PayManager_ordre_payFlow
   add primary key (ORDER_PAYFLOW_ID_);

/*==============================================================*/
/* Table: sp_activity_apply                                     */
/*==============================================================*/
create table sp_activity_apply
(
   APPLY_ID_            char(36) not null,
   MEMBER_ID_           char(36),
   APPLY_TITLE_         varchar(32),
   COMMENT_CONTENT_     varchar(32),
   COMMENT_TIME_        datetime,
   APPLY_MAXUSER_       varchar(32),
   APPLY_STATUS_        varchar(2),
   APPLY_NUMBER_        varchar(32),
   APPLY_ORDER_NUMBER_  varchar(32),
   START_TIME_          varchar(32),
   END_TIME_            varchar(32),
   create_time_         datetime,
   update_time_         datetime,
   update_user_         char(36),
   create_user_         char(36)
);

alter table sp_activity_apply comment '330701-活动申请内容列表';

alter table sp_activity_apply
   add primary key (APPLY_ID_);

/*==============================================================*/
/* Table: sp_activity_applyList                                 */
/*==============================================================*/
create table sp_activity_applyList
(
   APPLYLIST_ID_        char(36) not null,
   APPLY_ID_            char(36),
   APPLYLIST_TIME_      datetime,
   APPLY_MEMBER_        varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_activity_applyList comment '330702-报名名单';

alter table sp_activity_applyList
   add primary key (APPLYLIST_ID_);

/*==============================================================*/
/* Table: sp_activity_comment                                   */
/*==============================================================*/
create table sp_activity_comment
(
   COMMENT_ID           char(36) not null,
   APPLY_ID_            char(36),
   COMMENT_CONTENT_     varchar(32),
   COMMENT_TIME_        datetime,
   COMMENT_MEMBER_      varchar(32),
   create_time_         datetime,
   update_time_         datetime,
   update_user_         char(36),
   create_user_         char(36)
);

alter table sp_activity_comment comment '330704-活动评论';

alter table sp_activity_comment
   add primary key (COMMENT_ID);

/*==============================================================*/
/* Table: sp_activity_document                                  */
/*==============================================================*/
create table sp_activity_document
(
   DOCUMENT_ID_         char(36) not null,
   APPLY_ID_            char(36),
   DOCUMENT_NAME_       varchar(32),
   DOCUMENT_PATH_       varchar(256),
   create_time_         datetime,
   update_time_         datetime,
   update_user_         char(36),
   create_user_         char(36)
);

alter table sp_activity_document comment '330703-文档列表';

alter table sp_activity_document
   add primary key (DOCUMENT_ID_);

/*==============================================================*/
/* Table: sp_bbm_building_                                      */
/*==============================================================*/
create table sp_bbm_building_
(
   BUILDING_ID_         char(36) not null,
   sp__PARK_ID_         char(36),
   BUILDING_NO_         varchar(32),
   BUILDING_CAPTION     varchar(32),
   BUILDING_UNIT_COUNT_ varchar(32),
   Attribute_FLOOR_COUNT_ varchar(32),
   COMPANY_             varchar(32),
   BUILDING_TYPE_       varchar(36),
   Z_FLOOR_NUM_2        char(2),
   Z_USE_STATUS_        char(2) comment '0-在建，1-交付中，2-已用',
   PARK_ID_             char(36),
   update_time_         datetime,
   create_time_         datetime,
   create_user_         char(36),
   update_user_         char(36)
);

alter table sp_bbm_building_ comment '320102楼栋基础信息';

alter table sp_bbm_building_
   add primary key (BUILDING_ID_);

/*==============================================================*/
/* Table: sp_bbm_floor_                                         */
/*==============================================================*/
create table sp_bbm_floor_
(
   FLOOR_ID_            char(36) not null,
   sp__BUILDING_ID_     char(36),
   RZ_ID_               varchar(36),
   FLOOR_NO_            varchar(32),
   FLOOR_CAPTION_       varchar(32),
   FLOOR_ROOM_COUNT_    varchar(32),
   Z_ROOM_NUM_          char(2),
   Z_ROOM_NO_           varchar(36),
   Z_COMPANY_           varchar(36),
   Z_USE_STATUS_        char(2) comment '0-在建，1-交付中，2-已用',
   PARK_ID_             char(36),
   BUILDING_ID_         char(36),
   update_time_         datetime,
   create_time_         datetime,
   create_user_         char(36),
   update_user_         char(36)
);

alter table sp_bbm_floor_ comment '320103楼层基础信息';

alter table sp_bbm_floor_
   add primary key (FLOOR_ID_);

/*==============================================================*/
/* Table: sp_bbm_park_                                          */
/*==============================================================*/
create table sp_bbm_park_
(
   PARK_ID_             char(36) not null,
   PARK_NAME_           varchar(32),
   PARK_INTRODUCE_      varchar(224),
   BUILD_DATE           varchar(32),
   MAIN_INDUSTRY        varchar(56),
   MANAGER_             varchar(32),
   TEL_                 varchar(32),
   EMAIL_               varchar(32),
   ADDRESS_             varchar(56),
   update_time_         datetime,
   create_time_         datetime,
   create_user_         char(36),
   update_user_         char(36)
);

alter table sp_bbm_park_ comment '320101园区信息';

alter table sp_bbm_park_
   add primary key (PARK_ID_);

/*==============================================================*/
/* Table: sp_bbm_room_                                          */
/*==============================================================*/
create table sp_bbm_room_
(
   ROOM_ID_             char(36) not null,
   sp__FLOOR_ID_        char(36),
   RZ_ID_               varchar(36),
   B_ROOM_NO_           varchar(10),
   B_ROOM_CAPTION_      varchar(256),
   B_ENTERED_ENT_       varchar(32),
   B_FLOOR_             varchar(32),
   B_STATUS_            varchar(2),
   Z_SALE_STATE_        varchar(2),
   W_WATER_CHARGE_      decimal(10,2),
   W_ENERY_CHARGE_      decimal(10,2),
   W_PROPERTY_CHARGE_   decimal(10,2),
   W_RENT_CHARGE_       decimal(10,2),
   B_ROOM_NAME          varchar(32),
   B_AREA_              varchar(32),
   B_ASPECT_            varchar(32),
   B_ROOM_MODULE        varchar(32),
   B_FURNISH_           varchar(2),
   Z_SALES_PRICE_       decimal(10,2),
   Z_REBATE_            varchar(10),
   Z_LOWER_PRICE_       decimal(10,2),
   PARK_ID_             char(36),
   BUILDING_ID_         char(36),
   FLOOR_ID_            char(36),
   update_time_         datetime,
   create_time_         datetime,
   create_user_         char(36),
   update_user_         char(36)
);

alter table sp_bbm_room_ comment '320104单元基础信息';

alter table sp_bbm_room_
   add primary key (ROOM_ID_);

/*==============================================================*/
/* Table: sp_enterbusinessmanager_rz                            */
/*==============================================================*/
create table sp_enterbusinessmanager_rz
(
   RZ_ID_               varchar(36) not null,
   PARK_ID_             char(36),
   BUILDING_ID_         char(36),
   en_type_id_          char(36),
   ENTREC_ID_           varchar(36),
   RZ_MEM_              varchar(36),
   RZ_BUSS_             varchar(2),
   RZ_TELEPHONE_        varchar(16),
   RZ_REMARK_           varchar(200),
   RZ_DATE_             varchar(20),
   RZ_SIGN_             varchar(8),
   RZ_MANAGER_          char(36),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_enterbusinessmanager_rz comment '330101入驻企业基本信息';

alter table sp_enterbusinessmanager_rz
   add primary key (RZ_ID_);

/*==============================================================*/
/* Table: sp_enterprise_employees                               */
/*==============================================================*/
create table sp_enterprise_employees
(
   EMPLOYEES_ID         char(36) not null,
   RZ_ID_               varchar(36),
   MEMBER_ID_           char(36),
   EMPLOYEES_COM_ID     varchar(32),
   EMPLOYEES_NAME       varchar(32),
   EMPLOYEES_TELEPHONE  varchar(16),
   EMPLOYEES_DEPARTMENT varchar(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_enterprise_employees comment '330401企业员工表';

alter table sp_enterprise_employees
   add primary key (EMPLOYEES_ID);

/*==============================================================*/
/* Table: sp_enterprise_invitation                              */
/*==============================================================*/
create table sp_enterprise_invitation
(
   INVITATION_ID_       char(36) not null,
   RZ_ID_               varchar(36),
   INVITATION_CODE      varchar(32),
   INVITATION_TELEPHONE varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_enterprise_invitation comment '330402邀请记录表';

alter table sp_enterprise_invitation
   add primary key (INVITATION_ID_);

/*==============================================================*/
/* Table: sp_enterprise_role                                    */
/*==============================================================*/
create table sp_enterprise_role
(
   R_ID_                char(36) not null,
   R_E_ID_              char(36),
   R_R_ID_              char(36),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_enterprise_role comment '330403企业会员角色表';

alter table sp_enterprise_role
   add primary key (R_ID_);

/*==============================================================*/
/* Table: sp_etype_enterprisetype                               */
/*==============================================================*/
create table sp_etype_enterprisetype
(
   en_type_id_          char(36) not null,
   sp__en_type_id_      char(36),
   en_type_name_        varchar(32),
   parent_id_           char(36),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_etype_enterprisetype comment '320901企业行业类型表';

alter table sp_etype_enterprisetype
   add primary key (en_type_id_);

/*==============================================================*/
/* Table: sp_favorits_favoritGoods                              */
/*==============================================================*/
create table sp_favorits_favoritGoods
(
   FAVORIT_GOODS_ID_    char(36) not null,
   COMMODITY_ID_        char(36) not null,
   MEMBER_ID_           char(36),
   create_time_         datetime,
   create_user_         char(36),
   update_time_         datetime,
   update_user_         char(36)
);

alter table sp_favorits_favoritGoods comment '340401-商品收藏表';

alter table sp_favorits_favoritGoods
   add primary key (FAVORIT_GOODS_ID_, COMMODITY_ID_);

/*==============================================================*/
/* Table: sp_information_financing                              */
/*==============================================================*/
create table sp_information_financing
(
   FINANCING_ID_        char(36) not null,
   RZ_ID_               varchar(36),
   FINANCING_NAME_      varchar(64),
   FINANCING_AMOUNT_    decimal(10,2),
   FINANCING_COST_      decimal(10,2),
   FINANCING_PRE_       int,
   FINANCING_SUB_       varchar(2),
   FINANCING_TP_        varchar(2),
   FINANCING_TIME_      varchar(32),
   FINANCING_STATUS_    varchar(2),
   FINANCING_RE_        varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_information_financing comment '330505融资信息';

alter table sp_information_financing
   add primary key (FINANCING_ID_);

/*==============================================================*/
/* Table: sp_information_knowledge                              */
/*==============================================================*/
create table sp_information_knowledge
(
   KNOWLEDGE_ID_        varchar(32) not null,
   RZ_ID_               varchar(36),
   KNOWLEDGE_URL_       varchar(64),
   KNOWLEDGE_TITLE_     varchar(64),
   KNOWLEDGE_CONTENT_   varchar(256),
   KNOWLEDGE_STATUS_    varchar(2),
   KNOWLEDGE_RE_        varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_information_knowledge comment '330504知识产权信息';

alter table sp_information_knowledge
   add primary key (KNOWLEDGE_ID_);

/*==============================================================*/
/* Table: sp_information_legal                                  */
/*==============================================================*/
create table sp_information_legal
(
   LEGAL_ID_            char(36) not null,
   RZ_ID_               varchar(36),
   LEGAL_NAME_          varchar(64),
   LEGAL_TELEPHONE_     varchar(16),
   LEGAL_RE_            varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_information_legal comment '330503法人介绍';

alter table sp_information_legal
   add primary key (LEGAL_ID_);

/*==============================================================*/
/* Table: sp_information_media                                  */
/*==============================================================*/
create table sp_information_media
(
   MEDIA_ID_            char(36) not null,
   RZ_ID_               varchar(36),
   MEDIA_URL_           varchar(64),
   MEDIA_TITLE_         varchar(64),
   MEDIA_TILURL_        varchar(128),
   MEDIA_STATUS_        varchar(2),
   MEDIA_RE_            varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_information_media comment '330502媒体报道信息';

alter table sp_information_media
   add primary key (MEDIA_ID_);

/*==============================================================*/
/* Table: sp_information_notice                                 */
/*==============================================================*/
create table sp_information_notice
(
   NOTICE_ID_           varchar(32) not null,
   RZ_ID_               varchar(36),
   NOTICE_TITLE_        varchar(64),
   NOTICE_CONTENT_      varchar(256),
   NOTICE_TIME_         varchar(32),
   NOTICE_COUNT_        int,
   NOTICE_SUM_          int,
   NOTICE_RE_           varchar(32),
   create_time_         datetime,
   create_user_         char(36),
   update_time_         datetime,
   update_user_         char(36)
);

alter table sp_information_notice comment '330501公告信息';

alter table sp_information_notice
   add primary key (NOTICE_ID_);

/*==============================================================*/
/* Table: sp_information_product                                */
/*==============================================================*/
create table sp_information_product
(
   PRODUCT_ID_          char(36) not null,
   RZ_ID_               varchar(36),
   PRODUCT_NAME_        varchar(64),
   PRODUCT_TYPE_        varchar(2),
   PRODUCT_CONTENT_     varchar(256),
   PRODUCT_RE_          varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_information_product comment '330506产品信息';

alter table sp_information_product
   add primary key (PRODUCT_ID_);

/*==============================================================*/
/* Table: sp_lettermanager_comment                              */
/*==============================================================*/
create table sp_lettermanager_comment
(
   COMMENT_ID_          char(36) not null,
   RZ_ID_               varchar(36),
   COMMENT_ENTERPRISE   varchar(64),
   COMMENT_CONTENT      varchar(1024),
   COMMENT_TIME         varchar(32),
   COMMENT_REPLY_CONTENT varchar(256),
   COMMENT__REPLY_TIME  varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_lettermanager_comment comment '330601评论';

alter table sp_lettermanager_comment
   add primary key (COMMENT_ID_);

/*==============================================================*/
/* Table: sp_lettermanager_letter                               */
/*==============================================================*/
create table sp_lettermanager_letter
(
   LETTER_ID            char(36) not null,
   RZ_ID_               varchar(36),
   LETTER_ENTERPRISE_ID varchar(32),
   LETTER_RECIPIENT_ID  varchar(32),
   LETTER_CONTENT       varchar(1024),
   LETTER_TIME          varchar(32),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_lettermanager_letter comment '330602私信';

alter table sp_lettermanager_letter
   add primary key (LETTER_ID);

/*==============================================================*/
/* Table: sp_mc_msgDatas_                                       */
/*==============================================================*/
create table sp_mc_msgDatas_
(
   MSG_ID_              char(36) not null,
   MSG_TEMPALATE_ID_    char(36),
   MSG_CAPTION_         varchar(36),
   MSG_TYPE_            varchar(36),
   MSG_CONTENT_         varchar(256),
   SEND_DATE_           varchar(20),
   RECEIVE_             varchar(36),
   SEND_STATUS_         varchar(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_mc_msgDatas_ comment '320203消息列表';

alter table sp_mc_msgDatas_
   add primary key (MSG_ID_);

/*==============================================================*/
/* Table: sp_mc_msgTempalate_                                   */
/*==============================================================*/
create table sp_mc_msgTempalate_
(
   MSG_TEMPALATE_ID_    char(36) not null,
   MSG_TYPE_ID_         char(36),
   MSG_TEMPALATE_CAPTION_ varchar(32),
   MSG_TEMPALATE_CONTENT_ varchar(56),
   MSG_TEMPALATE_PARAMS_ varchar(256),
   MSG_RECEIVER_        varchar(36),
   MSG_RECEIVETYPE_     char(2),
   MSG_TEMPUSE_         char(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_mc_msgTempalate_ comment '320202消息模板';

alter table sp_mc_msgTempalate_
   add primary key (MSG_TEMPALATE_ID_);

/*==============================================================*/
/* Table: sp_mc_msgType_                                        */
/*==============================================================*/
create table sp_mc_msgType_
(
   MSG_TYPE_ID_         char(36) not null,
   MSG_TYPE_CAPTION_    varchar(36),
   MSG_TYPE_PARENT_     varchar(36),
   MSG_TYPE_STATUS_     char(2),
   IS_LEAF_             char(1),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_mc_msgType_ comment '320201消息类型';

alter table sp_mc_msgType_
   add primary key (MSG_TYPE_ID_);

/*==============================================================*/
/* Table: sp_memberAdr_address                                  */
/*==============================================================*/
create table sp_memberAdr_address
(
   ADDRESS_ID_          char(36) not null,
   MEMBER_ID_           char(36),
   ADDRESS_DETAIL_      varchar(128),
   ADDRESS_STATUS_      varchar(2),
   create_time_         datetime,
   create_user_         char(36),
   update_time_         datetime,
   update_user_         char(36)
);

alter table sp_memberAdr_address comment '340101-我的地址';

alter table sp_memberAdr_address
   add primary key (ADDRESS_ID_);

/*==============================================================*/
/* Table: sp_member_comment                                     */
/*==============================================================*/
create table sp_member_comment
(
   GOODS_COMMENT_ID_    char(36) not null,
   COMMODITY_ID_        char(36),
   MEMBER_ID_           char(36),
   GOODS_COMMENT_CONTENT_ varchar(1024),
   GOODS_COMMENT_TIME_  datetime,
   GOODS_COMMENT_LEVEL_ varchar(2),
   GOODS_COMMENT_REVIEW_ varchar(1024),
   GOODS_COMMENT_REVIEWTIME_ datetime,
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_member_comment comment '340201-商品评价';

alter table sp_member_comment
   add primary key (GOODS_COMMENT_ID_);

/*==============================================================*/
/* Table: sp_member_information                                 */
/*==============================================================*/
create table sp_member_information
(
   MEMBER_ID_           char(36) not null,
   MEMBER_PHONE_NUMBER_ varchar(16),
   COMPANY_ID_          char(36),
   COMPANY_INVITECODE_  varchar(32),
   MEMBER_HEAD_PORTRAIT_ varchar(32),
   MEMBER_NICKNAME_     varchar(32),
   MEMBER_NAME_         varchar(32),
   MEMBER_BIRTHDATE_    datetime,
   MEMBER_DESCRIBE2_    varchar(256),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_member_information comment '320701-会员信息表';

alter table sp_member_information
   add primary key (MEMBER_ID_);

/*==============================================================*/
/* Table: sp_nm_issueFlow_                                      */
/*==============================================================*/
create table sp_nm_issueFlow_
(
   ISSUE_FLOW_ID_       char(36) not null,
   ISSUE_TYPE_ID_       char(36),
   ISSUE_FLOW_CAPTION_  varchar(36),
   ISSUE_FLOW_C_STATUS_ varchar(36),
   ISSUE_FLOW_N_STATUS_ varchar(36),
   ISSUE_OPERATE_       varchar(36),
   FLOW_USE_            varchar(36),
   FLOW_INSTANCE_       varchar(36),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_nm_issueFlow_ comment '320603流程定义';

alter table sp_nm_issueFlow_
   add primary key (ISSUE_FLOW_ID_);

/*==============================================================*/
/* Table: sp_nm_issueNews_                                      */
/*==============================================================*/
create table sp_nm_issueNews_
(
   POLICY_ID_           char(36) not null,
   ISSUE_TEMPALATE_ID_  char(36),
   POLICY_CAPTION_      varchar(36),
   POLICY_CONTENT_      varchar(36),
   POLICY_TYPE_         varchar(36),
   POLICY_COME_         varchar(36),
   POLICY_ISSUE_DATE_   varchar(20),
   POLICY_STATUS_       char(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_nm_issueNews_ comment '320604政策新闻内容';

alter table sp_nm_issueNews_
   add primary key (POLICY_ID_);

/*==============================================================*/
/* Table: sp_nm_issueTempalate_                                 */
/*==============================================================*/
create table sp_nm_issueTempalate_
(
   ISSUE_TEMPALATE_ID_  char(36) not null,
   ISSUE_TYPE_ID_       char(36),
   ISSUE_TEMPALATE_CAPTION_ varchar(36),
   ISSUE_TEMPALATE_CONTENT_ varchar(256),
   ISSUE_TEMPALATE_SRC_ varchar(256),
   ISSUE_TEMPALATE_TO_  varchar(36),
   ISSUE_SENDSTATUS_    char(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_nm_issueTempalate_ comment '320602发布模板';

alter table sp_nm_issueTempalate_
   add primary key (ISSUE_TEMPALATE_ID_);

/*==============================================================*/
/* Table: sp_nm_issueType_                                      */
/*==============================================================*/
create table sp_nm_issueType_
(
   ISSUE_TYPE_ID_       char(36) not null,
   sp__ISSUE_TYPE_ID_   char(36),
   ISSUE_TYPE_CAPTION_  varchar(36),
   ISSUE_PARENT_TYPE_   varchar(36),
   ISSUE_TYPE_STATUS_   char(2),
   IS_LEAF_2            char(1),
   ISSUE_TYPE_CODE_     varchar(12),
   ISSUE_TYPE_PATH_     varchar(256),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_nm_issueType_ comment '320601发布类型';

alter table sp_nm_issueType_
   add primary key (ISSUE_TYPE_ID_);

/*==============================================================*/
/* Table: sp_policy_apply                                       */
/*==============================================================*/
create table sp_policy_apply
(
   POLICY_APPLY_ID_     char(36) not null,
   MEMBER_ID_           char(36),
   POLICY_APPLY_CONTACT_PEOPLE_ varchar(32),
   POLICY_APPLY_CONTACT_TEL_ varchar(32),
   POLICY_APPLY_CONPANY_NAME_ varchar(32),
   POLICY_APPLY_STATUS_ varchar(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_policy_apply comment '330801-政策申请记录';

alter table sp_policy_apply
   add primary key (POLICY_APPLY_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_bx                          */
/*==============================================================*/
create table sp_propertyservicemanager_bx
(
   BX_ID_               varchar(36) not null,
   BX_COMP_             varchar(50),
   BX_TYPE_             varchar(2),
   BX_WAY_              varchar(2),
   BX_PROJECT_          varchar(2),
   BX_ADDRESS_          varchar(36),
   BX_REMARK_           varchar(300),
   BX_FUJIAN            varchar(50),
   BX_AMOUNT_           decimal(14,2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_bx comment '330208物业报修记录';

alter table sp_propertyservicemanager_bx
   add primary key (BX_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_charge                      */
/*==============================================================*/
create table sp_propertyservicemanager_charge
(
   CHARGE_ID_           varchar(36) not null,
   RZ_ID_               varchar(36),
   ROOM_ID_             char(36),
   USERORDER_ID_        char(36),
   CHARGE_UNIT_         varchar(10),
   CHARGE_COMP_         varchar(50),
   CHARGE_BEDATE_       varchar(20),
   CHARGE_ENDATE_       varchar(20),
   CHARGE_TIME_         varchar(20),
   CHARGE_ISBOOL_       varchar(2),
   CHARGE_AMOUNT_       decimal(14,2),
   CHARGE_CREATETIME_   varchar(20),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_charge comment '330311物业收费登记表';

alter table sp_propertyservicemanager_charge
   add primary key (CHARGE_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_cos                         */
/*==============================================================*/
create table sp_propertyservicemanager_cos
(
   COS_ID_              varchar(36) not null,
   MEMBER_ID_           char(36),
   COS_NAME_            varchar(32),
   COS_CONTENT_         varchar(300),
   COS_BOOL_            varchar(2),
   COS_TELEPHONE_       varchar(16),
   COS_STATUS_          varchar(2),
   COS_CODE_            varchar(32),
   COS_TIME_            varchar(20),
   create_time_         datetime,
   update_time_         datetime,
   update_user_         char(36),
   create_user_         char(36)
);

alter table sp_propertyservicemanager_cos comment '330206物业投诉记录表';

alter table sp_propertyservicemanager_cos
   add primary key (COS_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_entering                    */
/*==============================================================*/
create table sp_propertyservicemanager_entering
(
   ENTERING_ID_         varchar(36) not null,
   ENTERING_DATE_       varchar(20),
   ENTERING_TIME_       varchar(20),
   ENTERING_SUM_        int,
   ENTERING_ALRE_       int,
   ENTERING_REMAIN_     int,
   ENTERING_STATUS_     varchar(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_entering comment '330203可办理预约记录';

alter table sp_propertyservicemanager_entering
   add primary key (ENTERING_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_entrec                      */
/*==============================================================*/
create table sp_propertyservicemanager_entrec
(
   ENTREC_ID_           varchar(36) not null,
   MEMBER_ID_           char(36),
   ENTERING_ID_         varchar(36),
   ENTERING_NAME_       varchar(32),
   ENTERING_TELEPHONE_  varchar(16),
   ENTERING_DATE_       varchar(20),
   ENTERING_TIME_       varchar(20),
   ENTERREC_STATUS_     varchar(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_entrec comment '330202入驻服务办理预约记录表';

alter table sp_propertyservicemanager_entrec
   add primary key (ENTREC_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_fkcode_                     */
/*==============================================================*/
create table sp_propertyservicemanager_fkcode_
(
   FKCODE_ID_           varchar(36) not null,
   MEMBER_ID_           char(36),
   FKCODE_NAME_         varchar(32),
   FKCODE_SEX_          varchar(2),
   FKCODE_TELEPHONE_    varchar(16),
   FKCODE_TIME_         varchar(20),
   FKCODE_COMP_         varchar(36),
   FKCODE_REMARK_       varchar(300),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_fkcode_ comment '330213访客申请记录';

alter table sp_propertyservicemanager_fkcode_
   add primary key (FKCODE_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_fxtdc                       */
/*==============================================================*/
create table sp_propertyservicemanager_fxtdc
(
   FXTDC_ID_            varchar(36) not null,
   MOVEREC_ID_          varchar(36),
   TWCRD_ADDREC_        varchar(50),
   create_time_         datetime,
   create_user_         char(36),
   update_time_         datetime,
   update_user_         char(36)
);

alter table sp_propertyservicemanager_fxtdc comment '330205搬家放行二维码记录表';

alter table sp_propertyservicemanager_fxtdc
   add primary key (FXTDC_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_moverec                     */
/*==============================================================*/
create table sp_propertyservicemanager_moverec
(
   MOVEREC_ID_          varchar(36) not null,
   MEMBER_ID_           char(36),
   MOVEREC_COMP_        varchar(32),
   MOVEREC_UNIT_        varchar(20),
   MOVEREC_NAME_        varchar(32),
   MOVEREC_WAY_         varchar(2),
   MOVEREC_REMARK_      varchar(300),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_moverec comment '330204搬家申请记录';

alter table sp_propertyservicemanager_moverec
   add primary key (MOVEREC_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_oc                          */
/*==============================================================*/
create table sp_propertyservicemanager_oc
(
   OC_ID_               varchar(36) not null,
   MEMBER_ID_           char(36),
   OC_NUMBER_           varchar(20),
   OC_STATUS_           varchar(2),
   OC_COMP_             varchar(50),
   OC_ADDREE_           varchar(36),
   OC_DATE_             varchar(20),
   OC_WAY_              varchar(2),
   OC_REMARK_           varchar(300),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_oc comment '330201一卡通办理申请记录';

alter table sp_propertyservicemanager_oc
   add primary key (OC_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_ser                         */
/*==============================================================*/
create table sp_propertyservicemanager_ser
(
   SER_ID_              varchar(36) not null,
   TS_ID_               varchar(36),
   SER_TYPE_            varchar(2),
   SER_NAME_            varchar(2),
   SER_PRICE_           decimal(14,2),
   SER_PAY_STATUS_      varchar(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_ser comment '330210费用清单';

alter table sp_propertyservicemanager_ser
   add primary key (SER_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_sfpro                       */
/*==============================================================*/
create table sp_propertyservicemanager_sfpro
(
   SFPRO_ID_            varchar(36) not null,
   CHARGE_ID_           varchar(36),
   SFPRO_NAME_          varchar(36),
   SFPRO_AMOUNT_        decimal(14,2),
   create_time_         datetime,
   create_user_         char(36),
   update_time_         datetime,
   update_user_         char(36)
);

alter table sp_propertyservicemanager_sfpro comment '330312物业收费项目表';

alter table sp_propertyservicemanager_sfpro
   add primary key (SFPRO_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_ts                          */
/*==============================================================*/
create table sp_propertyservicemanager_ts
(
   TS_ID_               varchar(36) not null,
   BX_ID_               varchar(36),
   TS_NAME_             varchar(32),
   TS_TELEPHONE_        varchar(20),
   TS_STATUS_           varchar(2),
   TS_REMARK_           varchar(300),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicemanager_ts comment '330209派工维修记录';

alter table sp_propertyservicemanager_ts
   add primary key (TS_ID_);

/*==============================================================*/
/* Table: sp_propertyservicemanager_twcrd                       */
/*==============================================================*/
create table sp_propertyservicemanager_twcrd
(
   TWCRD_ID_            varchar(36) not null,
   FKCODE_ID_           varchar(36),
   TWCRD_ADDREC_        varchar(50),
   create_time_         datetime,
   create_user_         char(36),
   update_time_         datetime,
   update_user_         char(36)
);

alter table sp_propertyservicemanager_twcrd comment '330214二维码记录';

alter table sp_propertyservicemanager_twcrd
   add primary key (TWCRD_ID_);

/*==============================================================*/
/* Table: sp_propertyservicenanager_back                        */
/*==============================================================*/
create table sp_propertyservicenanager_back
(
   BACK_ID_             varchar(36) not null,
   COS_ID_              varchar(36),
   BACK_CODE_           varchar(32),
   BACK_RECORD_         varchar(300),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_propertyservicenanager_back comment '330207投诉回访记录表';

alter table sp_propertyservicenanager_back
   add primary key (BACK_ID_);

/*==============================================================*/
/* Table: sp_publicutilitiesmanager_reso                        */
/*==============================================================*/
create table sp_publicutilitiesmanager_reso
(
   RESO_ID_             varchar(36) not null,
   COMMODITY_ID_        char(36),
   RESO_DATE_           varchar(20),
   RESO_TIME_           varchar(20),
   RESO_STATUS_         varchar(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_publicutilitiesmanager_reso comment '330301资源状态';

alter table sp_publicutilitiesmanager_reso
   add primary key (RESO_ID_);

/*==============================================================*/
/* Table: sp_purchasingManager_category                         */
/*==============================================================*/
create table sp_purchasingManager_category
(
   PARK_BUSINESS_TUPE_  char(2),
   CATEGORY_ID_         char(36) not null,
   sp__CATEGORY_ID_     char(36),
   CATEGORY_NAME_       varchar(128),
   CATEGORY_ISNOT_ENABLE_ varchar(1),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_category comment '320304商品类目表';

alter table sp_purchasingManager_category
   add primary key (CATEGORY_ID_);

/*==============================================================*/
/* Table: sp_purchasingManager_commodity                        */
/*==============================================================*/
create table sp_purchasingManager_commodity
(
   PARK_BUSINESS_TUPE_  char(2),
   COMMODITY_ID_        char(36) not null,
   CATEGORY_ID_         char(36),
   MERCHANT_ID_         char(36),
   GENRE_ID_            char(36),
   COMMODITY_TITLE_     varchar(128),
   COMMODITY_PRICE_     decimal(10,2),
   COMMODITY_STOCK_     int,
   COMMODITY_DESCRIBE_  text,
   COMMODITY_IMAGE_     varchar(256),
   COMMODITY_COVER_IMAGE_ varchar(256),
   COMMODITY_UP_TIME_   varchar(20),
   COMMODITY_DOWN_TIME_ varchar(20),
   COMMODITY_ORIGINAL_PRICE_ decimal(10,2),
   COMMODITY_HIGHEST_PRICE_ decimal(10,2),
   COMMODITY_LOWEST_PRICE_ decimal(10,2),
   COMMODITY_ISNOT_DISPLAY_STOCK_ varchar(1),
   COMMODITY_BRAND_     varchar(128),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_commodity comment '320301商品信息';

alter table sp_purchasingManager_commodity
   add primary key (COMMODITY_ID_);

/*==============================================================*/
/* Table: sp_purchasingManager_commodity_extend                 */
/*==============================================================*/
create table sp_purchasingManager_commodity_extend
(
   COMMODITY_EXTEND_ID_ char(36) not null,
   PARK_BUSINESS_TUPE_  char(2),
   COMMODITY_EXTEND_FIELD_NAME_ varchar(128),
   COMMODITY_EXTEND_FIELD_TYPE_ char(2),
   COMMODITY_EXTEND_DISPLAY_NAME_ varchar(128),
   COMMODITY_EXTEND_CONTENT_ text,
   COMMODITY_EXTEND_INFORMATION_TYPE_ char(2),
   COMMODITY_EXTEND_ISNOT_DISPLAY_ varchar(1),
   COMMODITY_EXTEND_ISNOT_MUST_ varchar(1),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_commodity_extend comment '320302采购商品信息扩展';

alter table sp_purchasingManager_commodity_extend
   add primary key (COMMODITY_EXTEND_ID_);

/*==============================================================*/
/* Table: sp_purchasingManager_commodity_extend_value           */
/*==============================================================*/
create table sp_purchasingManager_commodity_extend_value
(
   COMMODITY_EXTEND_VALUE_id_ char(36) not null,
   COMMODITY_ID_        char(36),
   COMMODITY_EXTEND_ID_ char(36),
   COMMODITY_EXTEND_VALUE_DISPLAY_NAME_ varchar(128),
   COMMODITY_EXTEND_VALUE_FIELD_NAME_ varchar(128),
   COMMODITY_EXTEND_VALUE_DISPLAY_CONTENT_ text,
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_commodity_extend_value comment '320303商品扩展属性值表';

alter table sp_purchasingManager_commodity_extend_value
   add primary key (COMMODITY_EXTEND_VALUE_id_);

/*==============================================================*/
/* Table: sp_purchasingManager_genre                            */
/*==============================================================*/
create table sp_purchasingManager_genre
(
   PARK_BUSINESS_TUPE_  char(2),
   GENRE_ID_            char(36) not null,
   sp__GENRE_ID_        char(36),
   GENRE_NAME_          varchar(128),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_genre comment '320305商品类别表';

alter table sp_purchasingManager_genre
   add primary key (GENRE_ID_);

/*==============================================================*/
/* Table: sp_purchasingManager_genre_property                   */
/*==============================================================*/
create table sp_purchasingManager_genre_property
(
   GENRE_PROPERTY_ID_   char(36) not null,
   GENRE_ID_            char(36),
   GENRE_PROPERTY_DISPLAY_NAME_ varchar(128),
   GENRE_PROPERTY_FIELD_NAME_ varchar(128),
   GENRE_PROPERTY_FIELD_TYPE_ char(2),
   GENRE_PROPERTY_ISNOT_MUST_ varchar(1),
   GENRE_PROPERTY_ISNOT_DISPLAY_ varchar(1),
   GENRE_PROPERTY_DEFAULT_VALUE_ varchar(128),
   GENRE_PROPERTY_FIELD_LENGTH_ int,
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_genre_property comment '320306商品类属性';

alter table sp_purchasingManager_genre_property
   add primary key (GENRE_PROPERTY_ID_);

/*==============================================================*/
/* Table: sp_purchasingManager_merchant                         */
/*==============================================================*/
create table sp_purchasingManager_merchant
(
   MERCHANT_ID_         char(36) not null,
   MERCHANT_NAME_       varchar(128),
   MERCHANT_TYPE_       char(2),
   MERCHANT_ENTERPRISE_NAME_ varchar(128),
   MERCHANT_RETURN_ADDRESS_ varchar(256),
   MERCHANT_SEND_ADDRESS_ varchar(256),
   MERCHANT_LINKMAN_    varchar(32),
   MERCHANT_LINKMAN_PHONE_ varchar(16),
   PARK_BUSINESS_TUPE_  char(2),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_merchant comment '320307商户信息表';

alter table sp_purchasingManager_merchant
   add primary key (MERCHANT_ID_);

/*==============================================================*/
/* Table: sp_purchasingManager_merchant_address_                */
/*==============================================================*/
create table sp_purchasingManager_merchant_address_
(
   MERCHANT_ADDRESS_ID_ char(36) not null,
   MERCHANT_ID_         char(36),
   MERCHANT_ADDRESS_LINKMAN_ varchar(32),
   MERCHANT_ADDRESS_PHONE_ varchar(16),
   MERCHANT_ADDRESS_ADDRESS_ varchar(256),
   MERCHANT_ADDRESS_ISNOT_DEFAULT_ varchar(1),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_purchasingManager_merchant_address_ comment '320308商户地址库';

alter table sp_purchasingManager_merchant_address_
   add primary key (MERCHANT_ADDRESS_ID_);

/*==============================================================*/
/* Table: sp_reservation_record                                 */
/*==============================================================*/
create table sp_reservation_record
(
   RECORD_ID            char(36) not null,
   RECORD_MEMBER_ID     varchar(32),
   RECORD_STATUS        varchar(2),
   RECORD_TYPE          varchar(2),
   RECORD_CUSTOMER      varchar(32),
   RECORD_SERVICE_TEL   varchar(32),
   RECORD_VISITE_STATUS varchar(2),
   VISITE_DATE_         varchar(20),
   VISITE_TIME_         varchar(20),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_reservation_record comment '330901预约记录';

alter table sp_reservation_record
   add primary key (RECORD_ID);

/*==============================================================*/
/* Table: sp_shoppingCar_catering                               */
/*==============================================================*/
create table sp_shoppingCar_catering
(
   COMPANY_CATERING_ID_ char(36) not null,
   COMPANY_CATERING_UNIVALENCE_ varchar(16),
   COMPANY_CATERING_AMOUNT_ varchar(16),
   COMMODITY_ID_        char(36) not null,
   MEMBER_ID_           char(36),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_shoppingCar_catering comment '340303-餐饮购物车';

alter table sp_shoppingCar_catering
   add primary key (COMPANY_CATERING_ID_, COMMODITY_ID_);

/*==============================================================*/
/* Table: sp_shoppingCar_companyServer                          */
/*==============================================================*/
create table sp_shoppingCar_companyServer
(
   COMPANY_SERVER_ID_   char(36) not null,
   COMPANY_CATERING_UNIVALENCE_ varchar(16),
   COMPANY_CATERING_AMOUNT_ varchar(16),
   COMMODITY_ID_        char(36) not null,
   MEMBER_ID_           char(36),
   update_user_         char(36),
   update_time_         datetime,
   create_user_         char(36),
   create_time_         datetime
);

alter table sp_shoppingCar_companyServer comment '340301-企业服务购物车';

alter table sp_shoppingCar_companyServer
   add primary key (COMPANY_SERVER_ID_, COMMODITY_ID_);

/*==============================================================*/
/* Table: sp_shoppingCar_group                                  */
/*==============================================================*/
create table sp_shoppingCar_group
(
   COMPANY_GROUP_ID_    char(36) not null,
   COMPANY_CATERING_UNIVALENCE_ varchar(16),
   COMPANY_CATERING_AMOUNT_ varchar(16),
   COMPANY_GROUP_COLLECT_STATUS_ varchar(1),
   COMMODITY_ID_        char(36) not null,
   MEMBER_ID_           char(36),
   create_time_         datetime,
   update_time_         datetime,
   update_user_         char(36),
   create_user_         char(36)
);

alter table sp_shoppingCar_group comment '340302-集采购物车';

alter table sp_shoppingCar_group
   add primary key (COMPANY_GROUP_ID_, COMMODITY_ID_);

alter table sp_OrderManager_commodityDetail add constraint FK_Relationship_16 foreign key (COMMODITY_ID_)
      references sp_purchasingManager_commodity (COMMODITY_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_commodityDetail add constraint FK_Relationship_17 foreign key (USERORDER_ID_)
      references sp_OrderManager_userOrder (USERORDER_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_orderMerchan_nexus add constraint FK_Relationship_18 foreign key (USERORDER_ID_)
      references sp_OrderManager_userOrder (USERORDER_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_orderMerchan_nexus add constraint FK_Relationship_19 foreign key (MERCHANT_ID_)
      references sp_purchasingManager_merchant (MERCHANT_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_orderProjectType_ add constraint FK_Relationship_1 foreign key (ORDERTYPE_ID_)
      references sp_OrderManager_orderType_ (ORDERTYPE_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_orderProjectType_value_ add constraint FK_Relationship_3 foreign key (USERORDER_ID_)
      references sp_OrderManager_userOrder (USERORDER_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_orderProjectType_value_ add constraint FK_Relationship_4 foreign key (ORDERPROJECTTYPE_ID_)
      references sp_OrderManager_orderProjectType_ (ORDERPROJECTTYPE_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_userOrder add constraint FK_Relationship_15 foreign key (BX_ID_)
      references sp_propertyservicemanager_bx (BX_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_userOrder add constraint FK_Relationship_2 foreign key (ORDERTYPE_ID_)
      references sp_OrderManager_orderType_ (ORDERTYPE_ID_) on delete restrict on update restrict;

alter table sp_OrderManager_userOrder add constraint FK_Relationship_8 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_activity_apply add constraint FK_Relationship_54 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_activity_applyList add constraint FK_Relationship_52 foreign key (APPLY_ID_)
      references sp_activity_apply (APPLY_ID_) on delete restrict on update restrict;

alter table sp_activity_comment add constraint FK_Relationship_53 foreign key (APPLY_ID_)
      references sp_activity_apply (APPLY_ID_) on delete restrict on update restrict;

alter table sp_activity_document add constraint FK_Relationship_51 foreign key (APPLY_ID_)
      references sp_activity_apply (APPLY_ID_) on delete restrict on update restrict;

alter table sp_bbm_building_ add constraint FK_320101_320102 foreign key (sp__PARK_ID_)
      references sp_bbm_park_ (PARK_ID_) on delete restrict on update restrict;

alter table sp_bbm_floor_ add constraint FK_320102_320103 foreign key (sp__BUILDING_ID_)
      references sp_bbm_building_ (BUILDING_ID_) on delete restrict on update restrict;

alter table sp_bbm_floor_ add constraint FK_Relationship_38 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_bbm_room_ add constraint FK_320103_320104 foreign key (sp__FLOOR_ID_)
      references sp_bbm_floor_ (FLOOR_ID_) on delete restrict on update restrict;

alter table sp_bbm_room_ add constraint FK_Relationship_37 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_enterbusinessmanager_rz add constraint FK_Relationship_35 foreign key (PARK_ID_)
      references sp_bbm_park_ (PARK_ID_) on delete restrict on update restrict;

alter table sp_enterbusinessmanager_rz add constraint FK_Relationship_36 foreign key (BUILDING_ID_)
      references sp_bbm_building_ (BUILDING_ID_) on delete restrict on update restrict;

alter table sp_enterbusinessmanager_rz add constraint FK_Relationship_57 foreign key (en_type_id_)
      references sp_etype_enterprisetype (en_type_id_) on delete restrict on update restrict;

alter table sp_enterbusinessmanager_rz add constraint FK_Relationship_58 foreign key (ENTREC_ID_)
      references sp_propertyservicemanager_entrec (ENTREC_ID_) on delete restrict on update restrict;

alter table sp_enterprise_employees add constraint FK_Relationship_11 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_enterprise_employees add constraint FK_Relationship_48 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_enterprise_invitation add constraint FK_Relationship_10 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_etype_enterprisetype add constraint FK_Relationship_5 foreign key (sp__en_type_id_)
      references sp_etype_enterprisetype (en_type_id_) on delete restrict on update restrict;

alter table sp_favorits_favoritGoods add constraint FK_Relationship_80 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_information_financing add constraint FK_Relationship_12 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_information_knowledge add constraint FK_Relationship_42 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_information_legal add constraint FK_Relationship_41 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_information_media add constraint FK_Relationship_33 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_information_notice add constraint FK_Relationship_45 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_information_product add constraint FK_Relationship_39 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_lettermanager_comment add constraint FK_Relationship_50 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_lettermanager_letter add constraint FK_Relationship_49 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_mc_msgDatas_ add constraint FK_320202_320203 foreign key (MSG_TEMPALATE_ID_)
      references sp_mc_msgTempalate_ (MSG_TEMPALATE_ID_) on delete restrict on update restrict;

alter table sp_mc_msgTempalate_ add constraint FK_320201_320202 foreign key (MSG_TYPE_ID_)
      references sp_mc_msgType_ (MSG_TYPE_ID_) on delete restrict on update restrict;

alter table sp_memberAdr_address add constraint FK_Relationship_47 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_member_comment add constraint FK_Relationship_6 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_member_comment add constraint FK_Relationship_7 foreign key (COMMODITY_ID_)
      references sp_purchasingManager_commodity (COMMODITY_ID_) on delete restrict on update restrict;

alter table sp_nm_issueFlow_ add constraint FK_320601_360203 foreign key (ISSUE_TYPE_ID_)
      references sp_nm_issueType_ (ISSUE_TYPE_ID_) on delete restrict on update restrict;

alter table sp_nm_issueNews_ add constraint FK_320602_360204 foreign key (ISSUE_TEMPALATE_ID_)
      references sp_nm_issueTempalate_ (ISSUE_TEMPALATE_ID_) on delete restrict on update restrict;

alter table sp_nm_issueTempalate_ add constraint FK_320601_360202 foreign key (ISSUE_TYPE_ID_)
      references sp_nm_issueType_ (ISSUE_TYPE_ID_) on delete restrict on update restrict;

alter table sp_nm_issueType_ add constraint FK_Relationship_56 foreign key (sp__ISSUE_TYPE_ID_)
      references sp_nm_issueType_ (ISSUE_TYPE_ID_) on delete restrict on update restrict;

alter table sp_policy_apply add constraint FK_Relationship_46 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_charge add constraint FK_Relationship_31 foreign key (USERORDER_ID_)
      references sp_OrderManager_userOrder (USERORDER_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_charge add constraint FK_Relationship_61 foreign key (RZ_ID_)
      references sp_enterbusinessmanager_rz (RZ_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_charge add constraint FK_Relationship_62 foreign key (ROOM_ID_)
      references sp_bbm_room_ (ROOM_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_cos add constraint FK_Relationship_44 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_entrec add constraint FK_Relationship_20 foreign key (ENTERING_ID_)
      references sp_propertyservicemanager_entering (ENTERING_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_entrec add constraint FK_Relationship_34 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_fkcode_ add constraint FK_Relationship_67 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_fxtdc add constraint FK_Relationship_71 foreign key (MOVEREC_ID_)
      references sp_propertyservicemanager_moverec (MOVEREC_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_moverec add constraint FK_Relationship_70 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_oc add constraint FK_Relationship_69 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_ser add constraint FK_Relationship_40 foreign key (TS_ID_)
      references sp_propertyservicemanager_ts (TS_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_sfpro add constraint FK_Relationship_64 foreign key (CHARGE_ID_)
      references sp_propertyservicemanager_charge (CHARGE_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_ts add constraint FK_Relationship_14 foreign key (BX_ID_)
      references sp_propertyservicemanager_bx (BX_ID_) on delete restrict on update restrict;

alter table sp_propertyservicemanager_twcrd add constraint FK_Relationship_68 foreign key (FKCODE_ID_)
      references sp_propertyservicemanager_fkcode_ (FKCODE_ID_) on delete restrict on update restrict;

alter table sp_propertyservicenanager_back add constraint FK_Relationship_43 foreign key (COS_ID_)
      references sp_propertyservicemanager_cos (COS_ID_) on delete restrict on update restrict;

alter table sp_publicutilitiesmanager_reso add constraint FK_Relationship_9 foreign key (COMMODITY_ID_)
      references sp_purchasingManager_commodity (COMMODITY_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_category add constraint FK_Relationship_13 foreign key (sp__CATEGORY_ID_)
      references sp_purchasingManager_category (CATEGORY_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_commodity add constraint FK_Relationship_23 foreign key (CATEGORY_ID_)
      references sp_purchasingManager_category (CATEGORY_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_commodity add constraint FK_Relationship_24 foreign key (GENRE_ID_)
      references sp_purchasingManager_genre (GENRE_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_commodity add constraint FK_Relationship_29 foreign key (MERCHANT_ID_)
      references sp_purchasingManager_merchant (MERCHANT_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_commodity_extend_value add constraint FK_Relationship_30 foreign key (COMMODITY_ID_)
      references sp_purchasingManager_commodity (COMMODITY_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_commodity_extend_value add constraint FK_Relationship_81 foreign key (COMMODITY_EXTEND_ID_)
      references sp_purchasingManager_commodity_extend (COMMODITY_EXTEND_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_genre add constraint FK_Relationship_21 foreign key (sp__GENRE_ID_)
      references sp_purchasingManager_genre (GENRE_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_genre_property add constraint FK_Relationship_22 foreign key (GENRE_ID_)
      references sp_purchasingManager_genre (GENRE_ID_) on delete restrict on update restrict;

alter table sp_purchasingManager_merchant_address_ add constraint FK_Relationship_55 foreign key (MERCHANT_ID_)
      references sp_purchasingManager_merchant (MERCHANT_ID_) on delete restrict on update restrict;

alter table sp_shoppingCar_catering add constraint FK_Relationship_77 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_shoppingCar_companyServer add constraint FK_Relationship_78 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

alter table sp_shoppingCar_group add constraint FK_Relationship_76 foreign key (MEMBER_ID_)
      references sp_member_information (MEMBER_ID_) on delete restrict on update restrict;

