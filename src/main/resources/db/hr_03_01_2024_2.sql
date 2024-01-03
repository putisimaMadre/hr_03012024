/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100432
 Source Host           : localhost:3306
 Source Schema         : hr

 Target Server Type    : MySQL
 Target Server Version : 100432
 File Encoding         : 65001

 Date: 03/01/2024 09:24:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `manager_id` int NULL DEFAULT NULL,
  `location_id` int NOT NULL,
  PRIMARY KEY (`department_id`) USING BTREE,
  INDEX `manager_id`(`manager_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 271 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES (10, 'Administration', 200, 1700);
INSERT INTO `departments` VALUES (40, 'Human Resources', 203, 2400);
INSERT INTO `departments` VALUES (70, 'Public Relations', 204, 2700);
INSERT INTO `departments` VALUES (80, 'Sales', 145, 2500);
INSERT INTO `departments` VALUES (90, 'Executive', 100, 1700);
INSERT INTO `departments` VALUES (100, 'Finance', 108, 1700);
INSERT INTO `departments` VALUES (110, 'Accounting', 205, 1700);
INSERT INTO `departments` VALUES (120, 'Treasury', 205, 1700);
INSERT INTO `departments` VALUES (130, 'Corporate Tax', 205, 1700);
INSERT INTO `departments` VALUES (140, 'Control And Credit', 205, 1700);
INSERT INTO `departments` VALUES (150, 'Shareholder Services', 205, 1700);
INSERT INTO `departments` VALUES (160, 'Benefits', 205, 1700);
INSERT INTO `departments` VALUES (170, 'Manufacturing', 205, 1700);
INSERT INTO `departments` VALUES (180, 'Construction', 205, 1700);
INSERT INTO `departments` VALUES (190, 'Contracting', 205, 1700);
INSERT INTO `departments` VALUES (200, 'Operations', 205, 1700);
INSERT INTO `departments` VALUES (210, 'IT Support', 205, 1700);
INSERT INTO `departments` VALUES (220, 'NOC', 205, 1700);
INSERT INTO `departments` VALUES (230, 'IT Helpdesk', 205, 1700);
INSERT INTO `departments` VALUES (240, 'Government Sales', 205, 1700);
INSERT INTO `departments` VALUES (250, 'Retail Sales', 205, 1700);
INSERT INTO `departments` VALUES (260, 'Recruiting', 205, 1700);
INSERT INTO `departments` VALUES (270, 'Payroll', 205, 1700);

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `salary` int NOT NULL,
  `manager_id` int NOT NULL,
  `department_id` int NOT NULL,
  `job_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE,
  INDEX `employee_department`(`department_id`) USING BTREE,
  INDEX `employee_job`(`job_id`) USING BTREE,
  INDEX `employee_manager`(`manager_id`) USING BTREE,
  CONSTRAINT `employee_department` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_job` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_manager` FOREIGN KEY (`manager_id`) REFERENCES `departments` (`manager_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES (100, 'jorge', 'nieto', 'jorge@gmail.com', 24000, 200, 10, 'AD PRES');

-- ----------------------------
-- Table structure for jobs
-- ----------------------------
DROP TABLE IF EXISTS `jobs`;
CREATE TABLE `jobs`  (
  `job_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `job_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `min_salary` decimal(6, 0) NOT NULL,
  `max_salary` decimal(6, 0) NOT NULL,
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobs
-- ----------------------------
INSERT INTO `jobs` VALUES ('AC_ACCOUNT', 'Public Accountant', 4200, 9000);
INSERT INTO `jobs` VALUES ('AC_MGR', 'Accounting Manager', 4200, 9000);
INSERT INTO `jobs` VALUES ('AC_TEST', 'Public test', 4200, 9000);
INSERT INTO `jobs` VALUES ('AD PRES', 'President', 20800, 40000);
INSERT INTO `jobs` VALUES ('AD VP', 'Administration Vice President', 30000, 45000);
INSERT INTO `jobs` VALUES ('AD_ASST', 'Administration Assistant', 3000, 6000);
INSERT INTO `jobs` VALUES ('AD_VP', 'Administration Vice President', 15000, 30000);
INSERT INTO `jobs` VALUES ('FI_ACCOUNT', 'Accountant', 4200, 9000);
INSERT INTO `jobs` VALUES ('FI_MGR', 'Finance Manager', 8200, 16000);
INSERT INTO `jobs` VALUES ('HR_REP', 'Human Resources Representative', 4000, 9000);
INSERT INTO `jobs` VALUES ('IT_PROG', 'Programmer', 4000, 10000);
INSERT INTO `jobs` VALUES ('MK_MAN', 'Marketing Manager', 9000, 15000);
INSERT INTO `jobs` VALUES ('MK_REP', 'Marketing Representative', 4000, 9000);
INSERT INTO `jobs` VALUES ('PR_REP', 'Public Relations Representative', 4500, 10500);
INSERT INTO `jobs` VALUES ('PU_CLERK', 'Purchasing Clerk', 2500, 5500);
INSERT INTO `jobs` VALUES ('PU_MAN', 'Purchasing Manager', 8000, 15000);
INSERT INTO `jobs` VALUES ('SA_MAN', 'Sales Manager', 10000, 20080);
INSERT INTO `jobs` VALUES ('SA_REP', 'Sales Representative', 6000, 12008);
INSERT INTO `jobs` VALUES ('SH_CLERK', 'Shipping Clerk', 2500, 5500);
INSERT INTO `jobs` VALUES ('ST_CLERK', 'Stock Clerk', 2008, 5000);
INSERT INTO `jobs` VALUES ('ST_MAN', 'Stock Manager', 5500, 8500);

SET FOREIGN_KEY_CHECKS = 1;
