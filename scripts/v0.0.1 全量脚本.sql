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
-- table structure for sys_role
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `SYS_ROLE`;
CREATE TABLE `SYS_ROLE`
(
    `ID`       INT                                                           NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `NAME`     VARCHAR(50) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI  NOT NULL COMMENT '角色名',
    `DESC`     VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NULL COMMENT '角色描述',
    `CRT_DATE` INT                                                           NOT NULL COMMENT '创建日期',
    `CRT_TIME` INT                                                           NOT NULL COMMENT '创建时间',
    `UPD_DATE` INT                                                           NOT NULL COMMENT '修改日期',
    `UPD_TIME` INT                                                           NOT NULL COMMENT '修改时间',
    `UPD_PRSN` INT                                                           NOT NULL COMMENT '修改人',
    `REMK`     VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NOT NULL COMMENT '备注',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '系统角色表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for sys_menu
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `SYS_MENU`;
CREATE TABLE `SYS_MENU`
(
    `ID`        INT                                                                       NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `NAME`      VARCHAR(50) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI              NOT NULL COMMENT '菜单名称',
    `PATH`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI             NOT NULL COMMENT '前端的路径',
    `COPT` VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI             NOT NULL COMMENT '组件',
    `ICON`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI DEFAULT '#' NOT NULL COMMENT '菜单图标',
    `CRT_DATE`  INT                                                                       NOT NULL COMMENT '创建日期',
    `CRT_TIME`  INT                                                                       NOT NULL COMMENT '创建时间',
    `PARN_ID`   INT                                                           DEFAULT -1  NOT NULL COMMENT '父id，无则 -1',
    `STAT`      CHAR(1) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI      DEFAULT 0   NOT NULL COMMENT '菜单状态',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '系统菜单表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for sys_rsre
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `SYS_RSRE`;
CREATE TABLE `SYS_RSRE`
(
    `ID`        INT                                                           NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `NAME`      VARCHAR(50) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI  NOT NULL COMMENT '资源名',
    `URL`       VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI NOT NULL COMMENT 'url',
    `REQT_METD` VARCHAR(10) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI  NOT NULL COMMENT '请求方法',
    `PARN_ID`   INT DEFAULT -1                                                NOT NULL COMMENT '父id，无则 -1',
    `IS_ANON`   TINYINT                                                       NOT NULL COMMENT '是否匿名',
    `CRT_DATE`  INT                                                           NOT NULL COMMENT '创建日期',
    `CRT_TIME`  INT                                                           NOT NULL COMMENT '创建时间',
    `UPD_DATE`  INT                                                           NOT NULL COMMENT '修改日期',
    `UPD_TIME`  INT                                                           NOT NULL COMMENT '修改时间',
    `UPD_PRSN`  INT                                                           NOT NULL COMMENT '修改人',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '系统资源表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for sys_menu_rsre
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `SYS_MENU_RSRE`;
CREATE TABLE `SYS_MENU_RSRE`
(
    `MENU_ID` INT NOT NULL COMMENT '菜单序号',
    `RSRE_ID` INT NOT NULL COMMENT '资源序号',
    PRIMARY KEY (`MENU_ID`, `RSRE_ID`)
) ENGINE = InnoDB
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '系统菜单资源表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for prsn_info
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `PRSN_INFO`;
CREATE TABLE `PRSN_INFO`
(
    `ID`        INT                                                                                 NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `NAME`      VARCHAR(50) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI                        NOT NULL COMMENT '姓名',
    `NINA`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI                       NULL COMMENT '昵称',
    `PWD`       CHAR(32) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI                           NOT NULL COMMENT '密码',
    `MAIL`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI                       NULL COMMENT '邮箱',
    `PHOE`      CHAR(11) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI                           NULL COMMENT '手机号',
    `SEX`       CHAR(1) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI      DEFAULT '0'           NOT NULL COMMENT '性别',
    `AVAR`      VARCHAR(255) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_0900_AI_CI DEFAULT 'default.png' NOT NULL COMMENT '头像',
    `CRT_DATE`  INT                                                                                 NOT NULL COMMENT '创建日期',
    `CRT_TIME`  INT                                                                                 NOT NULL COMMENT '创建时间',
    `UPD_DATE`  INT                                                                                 NOT NULL COMMENT '修改日期',
    `UPD_TIME`  INT                                                                                 NOT NULL COMMENT '修改时间',
    `UPD_PRSN`  INT                                                                                 NOT NULL COMMENT '修改人',
    `JOIN_DATE` INT                                                                                 NOT NULL COMMENT '加入日期',
    `STAT`      CHAR(1)                                                       DEFAULT '0'           NOT NULL COMMENT '状态',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '人员信息表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for prsn_role
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `PRSN_ROLE`;
CREATE TABLE `PRSN_ROLE`
(
    `PRSN_ID` INT NOT NULL COMMENT '用户序号',
    `ROLE_ID` INT NOT NULL COMMENT '角色序号',
    PRIMARY KEY (`PRSN_ID`, `ROLE_ID`)
) ENGINE = InnoDB
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '人员角色表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for prsn_role_menu
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `PRSN_ROLE_MENU`;
CREATE TABLE `PRSN_ROLE_MENU`
(
    `ROLE_ID` INT NOT NULL COMMENT '角色序号',
    `MENU_ID` INT NOT NULL COMMENT '菜单序号',
    PRIMARY KEY (`ROLE_ID`, `MENU_ID`)
) ENGINE = InnoDB
  CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_0900_AI_CI COMMENT '人员角色菜单表'
  ROW_FORMAT = DYNAMIC;