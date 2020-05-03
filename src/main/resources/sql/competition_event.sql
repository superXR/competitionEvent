/*
Navicat MySQL Data Transfer

Source Server         : xr
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : labs

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-04-26 22:56:38
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
  `suite_type` int(11) DEFAULT '1' COMMENT '1: 成年组\r\n2: 青少年组\r\n3：老年组\r\n',
  `plan_start_at` date DEFAULT NULL,
  `plan_end_at` date DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1: 未开始 2：进行中 3：已结束',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_by` varchar(50) DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;