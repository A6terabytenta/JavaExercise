/*
Navicat MySQL Data Transfer

Source Server         : TA
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-03-06 21:56:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `scores`
-- ----------------------------
DROP TABLE IF EXISTS `scores`;
CREATE TABLE `scores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUBJECT_ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  `SCORES` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `STUDENT_ID` (`STUDENT_ID`),
  CONSTRAINT `STUDENT_ID` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of scores
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_CORE` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `STUDENT_NAME` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLASS_NAME` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHONE_NUMBER` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DAY_OF_BIRTH` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '12130155', 'Nguyễn Tuấn Anh', 'DH12DT', 'Biên Hòa, Đồng Nai', '01653354390', '1994-07-14');
