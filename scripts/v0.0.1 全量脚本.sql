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
INSERT INTO system_role (`id`, `name`, `describe`, `create_date`, `create_time`, `create_person`,`update_date`, `update_time`, `update_person`, `remark`) VALUES ('1000', '超级管理员', '超级管理员', '20220920', '200000', '1000000', '20220920', '200000', '1000000', '无');

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
    `is_default`  TINYINT                                                       DEFAULT 0   NOT NULL COMMENT '是否默认权限',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统菜单表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- records of system_role
-- --------------------------------------------------------------------------
INSERT INTO system_menu (`id`, `name`, `path`, `component`, `icon`, `create_date`, `create_time`, `parent_id`, `status`, `is_default`) VALUES ('1000', '权限管理', '/permission', 'role.vue', 'el-icon', '20221003', '220500', '-1', '0', '0');
INSERT INTO system_menu (`id`, `name`, `path`, `component`, `icon`, `create_date`, `create_time`, `parent_id`, `status`, `is_default`) VALUES ('1001', '角色管理', '/permission/roles', 'roles.vue', 'el-icon', '20221003', '220500', '1000', '0', '0');
INSERT INTO system_menu (`id`, `name`, `path`, `component`, `icon`, `create_date`, `create_time`, `parent_id`, `status`, `is_default`) VALUES ('1002', '菜单管理', '/permission/menus', 'menus.vue', 'el-icon', '20221003', '220500', '1000', '0', '0');
INSERT INTO system_menu (`id`, `name`, `path`, `component`, `icon`, `create_date`, `create_time`, `parent_id`, `status`, `is_default`) VALUES ('1003', '个人中心', '/user/', 'user.vue', 'el-icon', '20221004', '070300', '-1', '0', '1');

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
    `is_default`     TINYINT DEFAULT 0                                             NOT NULL COMMENT '是否默认权限',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统资源表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- records of system_resource
-- --------------------------------------------------------------------------
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`, `is_default`) VALUES (1000, '登录图片验证码获取', '/login/code/image', '-1','login:image-code:get', 'GET', '1', '20220920', '2000', '20220920', '2000', '0');
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`, `is_default`) VALUES (1001, '登录接口', '/login', '-1', 'login', 'POST', '1', '20221003', '0729', '20221003', '0729', '0');
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`, `is_default`) VALUES (1002, '获取自己菜单', '/user/menu', '1003', 'user:menu:get', 'GET', '0', '20221004', '070300', '20221004', '070300', '1');
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`, `is_default`) VALUES (1003, '新建角色', '/permission/role', '1001', 'permission:role:create', 'POST', '0', '20221005', '140300', '20221005', '140300', '0');
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`, `is_default`) VALUES (1004, '删除角色', '/permission/role/{roleId}', '1001', 'permission:role:delete', 'DELETE', '0', '20221005', '140300', '20221005', '140300', '0');
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`, `is_default`) VALUES (1005, '修改角色', '/permission/role/{roleId}', '1002', 'permission:role:update', 'PUT', '0', '20221006', '140300', '20221006', '140300', '0');
INSERT INTO `system_resource` (`id`, `name`, `url`, `menu_id`, `identity`, `request_method`, `is_anonymous`, `create_date`, `create_time`, `update_date`, `update_time`, `is_default`) VALUES (1006, '查询角色', '/permission/role/query', '1002', 'permission:role:query', 'POST', '0', '20221006', '140300', '20221006', '140300', '0');

-- --------------------------------------------------------------------------
-- table structure for system_role_resource
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `system_role_resource`;
CREATE TABLE `system_role_resource`
(
    `role_id`      INT               NOT NULL COMMENT '角色序号',
    `resource_id`  INT               NOT NULL COMMENT '资源序号',
    `is_only_read` TINYINT DEFAULT 0 NOT NULL COMMENT '是否只读',
    PRIMARY KEY (`role_id`, `resource_id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统角色资源表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- records of system_role_resource
-- --------------------------------------------------------------------------
INSERT INTO system_role_resource (`role_id`, `resource_id`, `is_only_read`) VALUES ('1000', '1002', '1');
INSERT INTO system_role_resource (`role_id`, `resource_id`, `is_only_read`) VALUES ('1000', '1003', '0');
INSERT INTO system_role_resource (`role_id`, `resource_id`, `is_only_read`) VALUES ('1000', '1004', '0');
INSERT INTO system_role_resource (`role_id`, `resource_id`, `is_only_read`) VALUES ('1000', '1005', '0');
INSERT INTO system_role_resource (`role_id`, `resource_id`, `is_only_read`) VALUES ('1000', '1006', '0');

-- --------------------------------------------------------------------------
-- table structure for system_role_menu
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE `system_role_menu`
(
    `role_id`      INT               NOT NULL COMMENT '角色序号',
    `menu_id`      INT               NOT NULL COMMENT '菜单序号',
    `is_only_read` TINYINT DEFAULT 0 NOT NULL COMMENT '是否只读',
    PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE utf8mb4_0900_ai_ci COMMENT '系统角色菜单表'
  ROW_FORMAT = DYNAMIC;

-- --------------------------------------------------------------------------
-- records of system_role_menu
-- --------------------------------------------------------------------------
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `is_only_read`) VALUES ('1000', '1000', '0');
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `is_only_read`) VALUES ('1000', '1001', '0');
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `is_only_read`) VALUES ('1000', '1002', '0');
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `is_only_read`) VALUES ('1000', '1003', '1');

-- --------------------------------------------------------------------------
-- table structure for person_info
-- --------------------------------------------------------------------------
DROP TABLE IF EXISTS `person_info`;
CREATE TABLE `person_info`
(
    `id`            INT                                                                                 NOT NULL AUTO_INCREMENT COMMENT '唯一序号',
    `name`          VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                        NOT NULL COMMENT '姓名',
    `nickname`      VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                       NULL COMMENT '昵称',
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
-- table records for person_info
-- --------------------------------------------------------------------------
INSERT INTO person_info (`id`, `name`, `nickname`, `email`, `phone`, `sex`, `avatar`, `create_date`, `create_time`, `update_date`, `update_time`, `update_person`, `join_date`, `status`) VALUES ('1000', 'admin', 'admin', 'azwcl@outlook.com', '15656297586', '1', 'default.png', '20221111', '111100','20221111','111100','-1','20221111','0');

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
-- --------------------------------------------------------------------------
-- table records for person_info
-- --------------------------------------------------------------------------
INSERT INTO person_role (`person_id`, `role_id`) VALUES ('1000','1000');

-- ----------------------------
-- table structure for person_auth
-- ----------------------------
DROP TABLE IF EXISTS `person_auth`;
CREATE TABLE `person_auth`
(
    `person_id`   int        NOT NULL COMMENT '用户id',
    `username`    varchar(255) DEFAULT NULL,
    `password`    varchar(255) DEFAULT NULL,
    `auth_type`  tinyint(1) NOT NULL COMMENT '登录类型',
    `create_date` int          DEFAULT NULL COMMENT '日期',
    `create_time` int          DEFAULT NULL COMMENT '时间',
    `update_date` int          DEFAULT NULL COMMENT '修改日期',
    `update_time` int          DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`person_id`, `auth_type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT '人员认证表';

-- ----------------------------
-- table records for person_auth
-- ----------------------------
INSERT INTO person_auth (person_id, username, password, auth_type, create_date, create_time, update_date, update_time) VALUES ('1000', 'azwcl@outlook.com',	'd9b1d7db4cd6e70935368a1efb10e377',	'1', '20221111', '111100', '20221111', '111100');