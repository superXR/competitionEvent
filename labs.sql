/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : labs

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-04-28 20:32:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for competition_event
-- ----------------------------
DROP TABLE IF EXISTS `competition_event`;
CREATE TABLE `competition_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_code` varchar(20) CHARACTER SET latin1 NOT NULL,
  `competition_event_code` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `competition_event_name` varchar(20) DEFAULT NULL,
  `suite_type` varchar(20) DEFAULT NULL,
  `plan_start_at` datetime DEFAULT NULL,
  `plan_end_at` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_by` varchar(50) DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition_event
-- ----------------------------
INSERT INTO `competition_event` VALUES ('5', '001', 'CE2004250003', '春天', '成年组', '2020-04-30 08:30:00', '2020-07-07 18:20:00', '未开始', '2020-04-25 12:35:05', '2020-04-27 14:52:32', 'TE000001', 'TE000001');
INSERT INTO `competition_event` VALUES ('7', '001', 'CE2004250006', '夏天', '成年组', '2020-04-30 00:00:00', '2020-04-30 00:00:00', '未开始', '2020-04-25 19:24:44', '2020-04-27 14:52:37', 'TE000001', 'TE000001');
INSERT INTO `competition_event` VALUES ('13', '001', 'CE2004270001', '夕阳', '青少年组', '2020-07-10 00:00:00', '2020-07-18 00:00:00', '进行中', '2020-04-27 12:20:48', '2020-04-27 14:52:49', 'TE000001', 'TE000001');
INSERT INTO `competition_event` VALUES ('14', '001', 'CE2004280001', '落叶', '老年组', '2020-11-10 09:00:00', '2020-11-10 17:00:00', '未开始', '2020-04-28 19:44:31', '2020-04-28 19:49:31', 'TE000001', 'TE000001');

-- ----------------------------
-- Table structure for key_max_value
-- ----------------------------
DROP TABLE IF EXISTS `key_max_value`;
CREATE TABLE `key_max_value` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_code` varchar(20) DEFAULT NULL COMMENT '租户代码',
  `key_prefix` char(2) DEFAULT NULL COMMENT '业务主键前缀',
  `date_part` char(6) DEFAULT NULL COMMENT '日期',
  `current_value` int(11) DEFAULT '1' COMMENT '业务后缀',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk` (`tenant_code`,`key_prefix`,`date_part`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of key_max_value
-- ----------------------------
INSERT INTO `key_max_value` VALUES ('32', '001', 'DP', '191203', '8', '2019-12-03 10:40:28');
INSERT INTO `key_max_value` VALUES ('33', '001', 'CE', '200421', '8', '2020-04-21 00:54:53');
INSERT INTO `key_max_value` VALUES ('34', '001', 'CE', '200422', '18', '2020-04-22 23:33:40');
INSERT INTO `key_max_value` VALUES ('35', '001', 'DP', '200424', '2', '2020-04-24 00:47:04');
INSERT INTO `key_max_value` VALUES ('36', '001', 'CE', '200424', '3', '2020-04-24 01:01:47');
INSERT INTO `key_max_value` VALUES ('37', '001', 'CE', '200425', '15', '2020-04-25 12:35:42');
INSERT INTO `key_max_value` VALUES ('38', '001', 'DP', '200425', '2', '2020-04-25 12:48:44');
INSERT INTO `key_max_value` VALUES ('39', '001', 'CE', '200426', '1', '2020-04-26 13:32:35');
INSERT INTO `key_max_value` VALUES ('40', '001', 'CE', '200427', '8', '2020-04-27 11:51:13');
INSERT INTO `key_max_value` VALUES ('41', '001', 'CE', '200428', '1', '2020-04-28 19:18:36');
