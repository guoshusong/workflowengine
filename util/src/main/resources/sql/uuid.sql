/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : workflow_engine

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 14/09/2020 20:34:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for uuid
-- ----------------------------
DROP TABLE IF EXISTS `uuid`;
CREATE TABLE `uuid`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `biz_type` int(0) NULL DEFAULT NULL,
  `max_id` int(0) NULL DEFAULT NULL,
  `step_length` int(0) NULL DEFAULT NULL,
  `version` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
