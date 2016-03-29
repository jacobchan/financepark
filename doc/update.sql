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




