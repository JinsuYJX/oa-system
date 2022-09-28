-- --------------------------------------------------------------------------
-- table structure for system_parameter
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `system_parameter`;
CREATE TABLE `system_parameter`
(
    `id`       INT                                                           NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `value`    VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '参数值',
    `describe` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '参数描述',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统参数表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for system_role
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`
(
    `id`            INT                                                           NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `name`          VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '角色名',
    `describe`      VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '角色描述',
    `create_date`   INT                                                           NOT NULL COMMENT '创建日期',
    `create_time`   INT                                                           NOT NULL COMMENT '创建时间',
    `create_person` INT                                                           NOT NULL COMMENT '创建用户',
    `update_date`   INT                                                           NOT NULL COMMENT '修改日期',
    `update_time`   INT                                                           NOT NULL COMMENT '修改时间',
    `update_person` INT                                                           NOT NULL COMMENT '修改人',
    `remark`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统角色表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- records of system_role
-- --------------------------------------------------------------------------
INSERT INTO system_role (`id`, `name`, `describe`, `create_date`, `create_time`, `create_person`,`update_date`, `update_time`, `update_person`, `remark`) VALUES ('100', '超级管理员', '超级管理员', '20220920', '2000', '1000000', '20220920', '2000', '1000000', '无');

-- --------------------------------------------------------------------------
-- table structure for system_menu
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu`
(
    `id`          INT                                                                       NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `name`        VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci              NOT NULL COMMENT '菜单名称',
    `path`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci             NOT NULL COMMENT '前端的路径',
    `component`   VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci             NOT NULL COMMENT '组件',
    `icon`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '#' NOT NULL COMMENT '菜单图标',
    `create_date` INT                                                                       NOT NULL COMMENT '创建日期',
    `create_time` INT                                                                       NOT NULL COMMENT '创建时间',
    `parent_id`   INT                                                           DEFAULT -1  NOT NULL COMMENT '父id，无则 -1',
    `status`      CHAR(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      DEFAULT 0   NOT NULL COMMENT '菜单状态',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统菜单表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for system_resource
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `system_resource`;
CREATE TABLE `system_resource`
(
    `id`             INT                                                           NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `name`           VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '资源名',
    `url`            VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'url',
    `menu_id`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单序号，无则-1',
    `identity`       VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '资源标识',
    `request_method` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '请求方法',
    `is_anonymous`   TINYINT                                                       NOT NULL COMMENT '是否匿名',
    `create_date`    INT                                                           NOT NULL COMMENT '创建日期',
    `create_time`    INT                                                           NOT NULL COMMENT '创建时间',
    `update_date`    INT                                                           NOT NULL COMMENT '修改日期',
    `update_time`    INT                                                           NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统资源表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- records of system_resource
-- --------------------------------------------------------------------------
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`) VALUES (100, '登录图片验证码获取', '/login/image-code', '-1','login:image-code', 'GET', '1', '20220920', '2000', '20220920', '2000');
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`) VALUES (101, '登录邮箱验证码', '/login/code', '-1', 'login:code', 'POST', '1', '20220924', '0729', '20220924', '0729');

-- --------------------------------------------------------------------------
-- table structure for system_role_resource
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `system_role_resource`;
CREATE TABLE `system_role_resource`
(
    `role_id`     INT NOT NULL COMMENT '角色序号',
    `resource_id` INT NOT NULL COMMENT '资源序号',
    PRIMARY KEY (`role_id`, `resource_id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统角色资源表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for person_info
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `person_info`;
CREATE TABLE `person_info`
(
    `id`            INT                                                                                 NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `name`          VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                        NOT NULL COMMENT '姓名',
    `nickname`      VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                       NULL COMMENT '昵称',
    `password`      CHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                           NOT NULL COMMENT '密码',
    `email`         VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                       NULL COMMENT '邮箱',
    `phone`         CHAR(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                           NULL COMMENT '手机号',
    `sex`           CHAR(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      DEFAULT '0'           NOT NULL COMMENT '性别',
    `avatar`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'default.png' NOT NULL COMMENT '头像',
    `create_date`   INT                                                                                 NOT NULL COMMENT '创建日期',
    `create_time`   INT                                                                                 NOT NULL COMMENT '创建时间',
    `update_date`   INT                                                                                 NOT NULL COMMENT '修改日期',
    `update_time`   INT                                                                                 NOT NULL COMMENT '修改时间',
    `update_person` INT                                                                                 NOT NULL COMMENT '修改人',
    `join_date`     INT                                                                                 NOT NULL COMMENT '加入日期',
    `status`        CHAR(1)                                                       DEFAULT '0'           NOT NULL COMMENT '状态',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '人员信息表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- table structure for person_role
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `person_role`;
CREATE TABLE `person_role`
(
    `person_id` INT NOT NULL COMMENT '用户序号',
    `role_id`   INT NOT NULL COMMENT '角色序号',
    PRIMARY KEY (`person_id`, `role_id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '人员角色表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for person_auth
-- ----------------------------
DROP TABLE IF EXISTS `person_auth`;
CREATE TABLE `person_auth`
(
    `person_id`   int        NOT NULL COMMENT '用户id',
    `username`    varchar(255) DEFAULT NULL,
    `password`    varchar(255) DEFAULT NULL,
    `login_type`  tinyint(1) NOT NULL COMMENT '登录类型',
    `create_date` int          DEFAULT NULL COMMENT '日期',
    `create_time` int          DEFAULT NULL COMMENT '时间',
    `update_date` int          DEFAULT NULL COMMENT '修改日期',
    `update_time` int          DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`person_id`, `login_type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT '人员认证表';