/*
 Navicat Premium Data Transfer

 Source Server         : My 194.26.213.114
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41-0ubuntu0.24.04.1)
 Source Host           : 194.26.213.114:3306
 Source Schema         : DemoForDeviceAtlas

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41-0ubuntu0.24.04.1)
 File Encoding         : 65001

 Date: 17/03/2025 02:12:34
*/

CREATE DATABASE IF NOT EXISTS `DemoForDeviceAtlas` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE DemoForDeviceAtlas
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_info
-- ----------------------------
DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `primary_hardware_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `vendor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `os_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `os_version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `browser_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `browser_rendering_engine` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_info
-- ----------------------------
INSERT INTO `device_info` VALUES (1, 'Tablet', 'Google', 'Pixel C', 'Android', '7.0', 'Chrome', 'Blink');
INSERT INTO `device_info` VALUES (2, 'Mobile Phone', 'Huawei', 'MAR-LX1A', 'Android', '10', 'Chrome', 'Blink');
INSERT INTO `device_info` VALUES (3, 'Mobile Phone', 'Apple', 'iPhone', 'iOS', '12.0', 'Safari', 'WebKit');
INSERT INTO `device_info` VALUES (4, 'Tablet', 'Amazon', 'Kindle Fire HDX 7', 'Android', '4.4.3', 'Amazon Silk', 'Blink');
INSERT INTO `device_info` VALUES (5, 'Tablet', 'Apple', 'iPad', 'iPadOS', '18.3', 'Chrome', 'WebKit');
INSERT INTO `device_info` VALUES (6, 'Mobile Phone', 'Redmi', 'Note 9 Pro', 'Android', '12', 'Chrome', 'Blink');
INSERT INTO `device_info` VALUES (7, 'Tablet', 'Samsung', 'SM-X906C', 'Android', '12', 'Chrome', 'Blink');
INSERT INTO `device_info` VALUES (8, 'Tablet', 'Acer', 'ACTAB1021', 'Android', '10', 'Chrome', 'Blink');
INSERT INTO `device_info` VALUES (9, 'Mobile Phone', 'Samsung', 'SM-A515U', 'Android', '13', 'Chrome', 'Blink');
INSERT INTO `device_info` VALUES (10, 'Tablet', 'LG', 'V410', 'Android', '5.0.2', 'Chrome', 'Blink');

SET FOREIGN_KEY_CHECKS = 1;
