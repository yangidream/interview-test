/*
 Navicat Premium Data Transfer

 Source Server         : NAS-DockerMySQL56
 Source Server Type    : MySQL
 Source Server Version : 50648
 Source Host           : 192.168.1.12:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50648
 File Encoding         : 65001

 Date: 26/09/2020 00:24:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `age` int(8) DEFAULT NULL,
  `department` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `salary` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
BEGIN;
INSERT INTO `t_staff` VALUES (1, 'mic', 22, '后勤部', 1000);
INSERT INTO `t_staff` VALUES (2, 'liLy', 21, '账务部', 2000);
INSERT INTO `t_staff` VALUES (3, 'linlei', 21, '研发部', 3000);
INSERT INTO `t_staff` VALUES (4, 'tom', 31, '后勤部', 4000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
