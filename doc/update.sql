/*==============================================================*/
/* 修改人:              Jack                                     */
/* 修改表序号:     320301		                               */
/* 修改表名称:     sp_memberInfomation                            */
/*==============================================================*/
ALTER TABLE `test`.`tree_test` ADD COLUMN `test` varchar(256) ;

ALTER TABLE `sp_purchasingmanager_genre_property`
ADD COLUMN `CATEGORY_`  char(2) NULL AFTER `CREATE_TIME_`;


