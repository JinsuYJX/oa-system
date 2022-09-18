-- --------------------------------------------------------------------------
-- table structure for sys_para
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `SYS_PARA`;
CREATE TABLE `SYS_PARA`
(
    `ID`        INT                                                           NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `PARA_VAL`  VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NOT NULL COMMENT '参数值',
    `PARA_DESC` VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NOT NULL COMMENT '参数描述',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '系统参数表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for prsn_info
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `PRSN_INFO`;
CREATE TABLE `PRSN_INFO`
(
    `ID`        INT                                                           NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `NAME`      VARCHAR(50) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI  NOT NULL COMMENT '姓名',
    `NINA`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NULL COMMENT '昵称',
    `PWD`       CHAR(32) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI     NOT NULL COMMENT '密码',
    `MAIL`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NULL COMMENT '邮箱',
    `PHOE`      CHAR(11) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI     NULL COMMENT '手机号',
    `SEX`       CHAR(1) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI      NOT NULL DEFAULT '0' COMMENT '性别',
    `AVAR`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NOT NULL DEFAULT 'default.png' COMMENT '头像',
    `CRT_DATE`  INT                                                           NOT NULL COMMENT '创建日期',
    `CRT_TIME`  INT                                                           NOT NULL COMMENT '创建时间',
    `UPD_DATE`  INT                                                           NOT NULL COMMENT '修改日期',
    `UPD_TIME`  INT                                                           NOT NULL COMMENT '修改时间',
    `UPD_PRSN`  INT                                                           NOT NULL COMMENT '修改人',
    `JOIN_DATE` INT                                                           NOT NULL COMMENT '加入日期',
    `STAT`      CHAR(1)                                                       NOT NULL DEFAULT '0' COMMENT '状态',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '人员信息表'
  ROW_FORMAT = DYNAMIC;