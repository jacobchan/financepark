ALTER TABLE  `sp_activity_apply` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_activity_applylist` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_activity_comment` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_activity_document` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_applay_type` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_carport` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_enterbusinessmanager_rz` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_enterprise_employees` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_enterprise_invitation` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_enterprise_role` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_entrepreneurship` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_etype_enterprisetype` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_favorits_favoritactivity` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_favorits_favoritgoods` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_file_upload` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_finace` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_hotel_order` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_hotel_order_item` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_information_financing` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_information_knowledge` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_information_legal` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_information_media` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_information_notice` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_information_product` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_lettermanager_comment` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_lettermanager_letter` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_mc_msgdatas_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_mc_msgtempalate_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_mc_msgtype_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_member_comment` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_member_contracts` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_member_information` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_member_role` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_memberadr_address` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_nm_issueflow_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_nm_issuenews_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_nm_issuenews_d_or_c_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_nm_issuetempalate_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_nm_issuetype_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ordermanager_commoditydetail` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ordermanager_ordermerchan_nexus` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ordermanager_orderprojecttype_value_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ordermanager_userorder` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_paymanager_ordre_payflow` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_policy_apply` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_bx` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_charge` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_cos` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_entering` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_entrec` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_fkcode_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_fxtdc` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_moverec` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_oc` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_ser` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_sfpro` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_ts` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicemanager_twcrd` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_propertyservicenanager_back` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_publicutilitiesmanager_reso` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_category` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_commodity` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_commodity_extend` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_genre` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_genre_property` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_genreevaluate` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_merchant` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_purchasingmanager_merchant_address_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_recommend_member` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_refund_order` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_reservation_record` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_room_people` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_sales_rec` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_settle_rec` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_shoppingcar_catering` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_shoppingcar_companyserver` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_shoppingcar_group` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ticket_ctrancts` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ticket_order` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ticket_order_item` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ticket_passenger` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_ticket_passenger_relation` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;
ALTER TABLE  `sp_workflow_repair_` ADD COLUMN `PARK_ID_` varchar(36) , ADD COLUMN `PARK_NAME_` varchar(256) AFTER `PARK_ID_`;