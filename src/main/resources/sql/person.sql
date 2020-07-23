/*
Navicat MySQL Data Transfer

Source Server         : notes
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : notes

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-07-23 14:40:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
CREATE TABLE `person` (
  `id` bigint NOT NULL,
  `person_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '人名',
  `person_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '人员code',
  `sex` int NOT NULL COMMENT '性别(1男 2女)',
  `telephone` bigint DEFAULT NULL COMMENT '手机号码',
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮箱',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '管理员', 'ADMIN', '1', '10086', '1294405880@qq.com', '管理员账户');
