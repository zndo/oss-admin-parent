/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MariaDB
 Source Server Version : 50626
 Source Host           : localhost:3306
 Source Database       : ADMIN

 Target Server Type    : MariaDB
 Target Server Version : 100206
 File Encoding         : utf-8

 Date: 01/01/2018 09:30:00 AM
 TINYINT (1) 0-FALSE 1-TRUE
*/
SET NAMES utf8;


SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `ADMIN_USER` - 后台管理用户表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_USER`;

CREATE TABLE `ADMIN_USER` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `OPENID` VARCHAR (64) NULL COMMENT '用户唯一身份识别 ID',
    `USERNAME` VARCHAR (32) DEFAULT NULL COMMENT '帐号',
    `PASSWORD` VARCHAR (128) DEFAULT NULL COMMENT '密码',
    `SIGNIN_TYPE` VARCHAR (16) DEFAULT 'DEFAULT' COMMENT '登录类型：DEFAULT/DEFAULT/WEIXIN/WEIBO/GITHUB',
    `NICKNAME` VARCHAR (32) DEFAULT NULL COMMENT '昵称',
    `AVATAR_URL` VARCHAR (255) DEFAULT NULL COMMENT '头像地址',
    `GENDER` VARCHAR (2) DEFAULT NULL COMMENT '性别',
    `EMAIL` VARCHAR (32) DEFAULT NULL COMMENT '邮箱',
    `PHONE` VARCHAR (16) NOT NULL COMMENT '手机号',
    `USER_STATUS` TINYINT (2) NOT NULL DEFAULT 0 COMMENT '用户状态：-1-未激活/0-已禁用/1-已激活/2-已锁定',
    `META` VARCHAR (64) DEFAULT NULL COMMENT '其他信息',
    `MD5` VARCHAR (128) NOT NULL COMMENT '个人信息MD5',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`),
    UNIQUE KEY (`USERNAME`),
    UNIQUE KEY (`PHONE`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_USER`
-- ----------------------------
BEGIN;

INSERT INTO `admin`.`admin_user` (
	`ID`,
	`OPENID`,
	`USERNAME`,
	`PASSWORD`,
	`SIGNIN_TYPE`,
	`NICKNAME`,
	`AVATAR_URL`,
	`GENDER`,
	`EMAIL`,
	`PHONE`,
	`USER_STATUS`,
	`CREATED`,
	`UPDATED`,
	`DELETED`,
	`META`,
	`MD5`
)
VALUES
	(
		'9',
		'',
		'admin',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'im@test.com',
		'18800000001',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de8'
	),
	(
		'18',
		'',
		'user',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'im@test.com',
		'18800000002',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'27',
		'',
		'user1',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user1@test.com',
		'18800000111',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de8'
	),
	(
		'30',
		'',
		'user2',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000222',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'33',
		'',
		'user3',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000333',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'36',
		'',
		'user4',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000004',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'39',
		'',
		'user5',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000005',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'42',
		'',
		'user6',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000006',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'45',
		'',
		'user7',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000007',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'48',
		'',
		'user8',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000008',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'51',
		'',
		'user9',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000009',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'54',
		'',
		'user10',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000010',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'57',
		'',
		'user11',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000011',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	),
	(
		'60',
		'',
		'user12',
		'$2a$10$2snJe5a9Y5upuC.GtzF4lumS8r6WaAji2XymT1Nl3WKOwCAcqQNFm',
		'DEFAULT',
		'zndo',
		'https://avatars3.githubusercontent.com/u/3707021?s=40&v=4',
		'男',
		'user2@test.com',
		'18800000012',
		'0',
		'2018-02-05 17:20:55',
		'2018-02-05 17:21:11',
		'0',
		'Shanghai',
		'cceb16794b768cabf72abd45757e9de9'
	);

COMMIT;

-- ----------------------------
--  Table structure for `ADMIN_USER_PROFILE` - 后台管理用户资料表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_USER_PROFILE`;

CREATE TABLE `ADMIN_USER_PROFILE` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `USERID` BIGINT (20) NOT NULL COMMENT '用户ID，外键',
    `REALNAME` VARCHAR (16) NOT NULL COMMENT '真实姓名',
    `IDENTITY` VARCHAR (16) NOT NULL COMMENT '身份证号',
    `ADDRESS` VARCHAR (64) DEFAULT NULL COMMENT '住址',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`),
    UNIQUE KEY (`IDENTITY`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `ADMIN_ROLE` - 后台管理角色表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_ROLE`;

CREATE TABLE `ADMIN_ROLE` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `ROLE_NAME` VARCHAR (32) NOT NULL COMMENT '角色名',
    `DESCRIPTION` VARCHAR (128) DEFAULT NULL COMMENT '角色描述',
    `F_ID` BIGINT (32) DEFAULT NULL COMMENT 'F_ID',
    `ROLE_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '角色状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`),
    UNIQUE KEY (`ROLE_NAME`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_ROLE`
-- ----------------------------
BEGIN;

INSERT INTO `admin`.`admin_role` (
	`ID`,
	`ROLE_NAME`,
	`DESCRIPTION`,
	`F_ID`,
	`ROLE_STATUS`,
	`CREATED`,
	`UPDATED`,
	`DELETED`
)
VALUES
	(
		'9',
		'ROLE_ADMIN',
		'管理员',
		NULL,
		'1',
		'2018-02-05 17:27:10',
		'2018-02-05 17:27:12',
		'0'
	),
	(
		'18',
		'ROLE_USER',
		'用户',
		NULL,
		'1',
		'2018-02-05 17:27:10',
		'2018-02-05 17:27:12',
		'0'
	),
	(
		'27',
		'ROLE_GUEST',
		'访客',
		NULL,
		'1',
		'2018-02-05 17:27:10',
		'2018-02-05 17:27:12',
		'0'
	);

COMMIT;

-- ----------------------------
--  Table structure for `ADMIN_AUTHORITY` - 后台管理权限表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_AUTHORITY`;

CREATE TABLE `ADMIN_AUTHORITY` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `AUTHORITY` VARCHAR (128) NOT NULL COMMENT '权限标识',
    `AUTHORITY_NAME` VARCHAR (32) NOT NULL COMMENT '权限名',
    `DESCRIPTION` VARCHAR (128) DEFAULT NULL COMMENT '权限描述',
    `AUTHORITY_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '权限状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`),
    UNIQUE KEY (`AUTHORITY`),
    UNIQUE KEY (`AUTHORITY_NAME`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_AUTHORITY`
-- ----------------------------

-- ----------------------------
--  Table structure for `ADMIN_RESOURCE` - 后台管理资源表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_RESOURCE`;

CREATE TABLE `ADMIN_RESOURCE` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `TYPE` VARCHAR (128) NOT NULL COMMENT '资源类型',
    `RESOURCE_NAME` VARCHAR (32) NOT NULL COMMENT '资源名',
    `DESCRIPTION` VARCHAR (128) DEFAULT NULL COMMENT '资源描述',
    `URL` VARCHAR (255) DEFAULT NULL COMMENT '资源地址',
    `PRIORITY` INT DEFAULT NULL COMMENT '优先级',
    `RESOURCE_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '资源状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`),
    UNIQUE KEY (`RESOURCE_NAME`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_RESOURCE`
-- ----------------------------

-- ----------------------------
--  Table structure for `ADMIN_USER_ROLE` - 用户角色关系表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_USER_ROLE`;

CREATE TABLE `ADMIN_USER_ROLE` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `USERID` BIGINT (20) NOT NULL COMMENT '用户ID',
    `ROLEID` BIGINT (20) NOT NULL COMMENT '角色ID',
    `RLAT_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '关系状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_USER_ROLE`
-- ----------------------------

BEGIN;

INSERT INTO `admin`.`ADMIN_USER_ROLE` (
	`ID`,
	`USERID`,
	`ROLEID`,
	`RLAT_STATUS`,
	`CREATED`,
	`UPDATED`,
	`DELETED`
)
VALUES
	(
		'9',
		'9',
		'9',
		'1',
		'2018-02-05 17:31:14',
		'2018-02-05 17:31:17',
		'0'
	);

COMMIT;

-- ----------------------------
--  Table structure for `ADMIN_ROLE_AUTHORITY` - 角色权限关系表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_ROLE_AUTHORITY`;

CREATE TABLE `ADMIN_ROLE_AUTHORITY` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `ROLEID` BIGINT (20) NOT NULL COMMENT '角色ID',
    `AUTHORITYID` BIGINT (20) NOT NULL COMMENT '权限ID',
    `RLAT_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '关系状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_ROLE_AUTHORITY`
-- ----------------------------

-- ----------------------------
--  Table structure for `ADMIN_AUTHORITY_RESOURCE` - 权限资源关系表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_AUTHORITY_RESOURCE`;

CREATE TABLE `ADMIN_AUTHORITY_RESOURCE` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `AUTHORITYID` BIGINT (20) NOT NULL COMMENT '角色ID',
    `RESOURCEID` BIGINT (20) NOT NULL COMMENT '权限ID',
    `RLAT_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '关系状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_AUTHORITY_RESOURCE`
-- ----------------------------

-- ----------------------------
--  Table structure for `ADMIN_MODULE` - 后台管理模块表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_MODULE`;

CREATE TABLE `ADMIN_MODULE` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `TYPE` VARCHAR (128) NOT NULL COMMENT '模块类型',
    `MODULE_NAME` VARCHAR (32) NOT NULL COMMENT '模块名',
    `DESCRIPTION` VARCHAR (128) DEFAULT NULL COMMENT '模块描述',
    `PARENT_MODULE` VARCHAR (32) NOT NULL COMMENT '父模块',
    `URL` VARCHAR (255) DEFAULT NULL COMMENT '模块地址',
    `MENU_LEVEL` INT DEFAULT NULL COMMENT '菜单级别',
    `BUTTOM_LEVEL` INT DEFAULT NULL COMMENT '最下级',
    `APP_NAME` VARCHAR (32) NOT NULL COMMENT '应用名',
    `CONTROLLER_NAME` VARCHAR (128) NOT NULL COMMENT '控制器名',
    `PRIORITY` INT DEFAULT NULL COMMENT '优先级',
    `MODULE_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '模块状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`),
    UNIQUE KEY (`MODULE_NAME`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_MODULE`
-- ----------------------------

-- ----------------------------
--  Table structure for `ADMIN_ROLE_MODULE` - 角色模块关系表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_ROLE_MODULE`;

CREATE TABLE `ADMIN_ROLE_MODULE` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `ROLEID` BIGINT (20) NOT NULL COMMENT '角色ID',
    `MODULEID` BIGINT (20) NOT NULL COMMENT '模块ID',
    `RLAT_STATUS` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '关系状态：0-FALSE-禁用/1-TRUE-正常',
    `CREATED` DATETIME NOT NULL COMMENT '创建时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '更新时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_ROLE_MODULE`
-- ----------------------------

-- ----------------------------
--  Table structure for `persistent_logins` - 后台管理登录记忆表
-- ----------------------------
DROP TABLE
IF EXISTS `PERSISTENT_LOGINS`;

CREATE TABLE `PERSISTENT_LOGINS` (
    `USERNAME` VARCHAR (64) NOT NULL COMMENT '帐号',
    `SERIES` VARCHAR (64) NOT NULL COMMENT '序列',
    `TOKEN` VARCHAR (64) NOT NULL COMMENT 'TOKEN',
    `LAST_USED` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后使用',
    PRIMARY KEY (`SERIES`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `PERSISTENT_LOGINS`
-- ----------------------------

-- ----------------------------
--  Table structure for `ADMIN_SIGNIN_ATTEMPTS` - 后台管理登录尝试次数表
-- ----------------------------
DROP TABLE
IF EXISTS `ADMIN_SIGNIN_ATTEMPTS`;

CREATE TABLE `ADMIN_SIGNIN_ATTEMPTS` (
    `ID` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `USERNAME` VARCHAR (32) NOT NULL COMMENT '帐号',
    `ATTEMPTS` INT NOT NULL COMMENT '尝试登录次数',
    `TOKEN` VARCHAR (64) NOT NULL COMMENT 'TOKEN',
    `CREATED` DATETIME NOT NULL COMMENT '首次登录错误时间',
    `UPDATED` DATETIME NOT NULL NOT NULL COMMENT '最后错误登录时间',
    `DELETED` TINYINT (1) NOT NULL DEFAULT 0 NULL COMMENT '是否删除：0-FALSE-未删除/1-TRUE-已删除',
    PRIMARY KEY (`ID`)
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `ADMIN_SIGNIN_ATTEMPTS`
-- ----------------------------


