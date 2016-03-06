/*
Navicat MySQL Data Transfer

Source Server         : TA
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : exercise

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-03-06 21:56:14
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_core` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `student_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('3', '12130355', 'Nguyễn Tuấn Em');
INSERT INTO `student` VALUES ('5', '12130355', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('6', '12130355', 'Nguyen Tuan Anh');
INSERT INTO `student` VALUES ('36', '12130155', 'Phan Xuan Manh');
INSERT INTO `student` VALUES ('37', '12130355', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('38', '12130355', 'Nguyen Tuan Anh');
INSERT INTO `student` VALUES ('39', '12130355', 'Nguyen Tuan Anh');
INSERT INTO `student` VALUES ('42', '12130155', 'Phan Xuan Manh');
INSERT INTO `student` VALUES ('43', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('44', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('45', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('46', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('47', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('48', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('49', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('50', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('51', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('52', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('53', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('54', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('56', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('57', '12130355', 'Nguyễn Tuấn Em');
INSERT INTO `student` VALUES ('58', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('59', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('60', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('61', '12130356', 'Nguyễn Tuấn Anh');
INSERT INTO `student` VALUES ('62', '12130356', 'Nguyễn Tuấn Anh');

-- ----------------------------
-- Table structure for `student_info`
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `average_score` double NOT NULL,
  `date_of_birth` date NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `FK_bh82tq62obr45sxkjjm9wn056` (`student_id`),
  KEY `FK_gad9x638frmk134ovwpl08jv1` (`info_id`),
  CONSTRAINT `FK_bh82tq62obr45sxkjjm9wn056` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `FK_gad9x638frmk134ovwpl08jv1` FOREIGN KEY (`info_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('2', 'Ho Nai, Bien Hoa, Dong Nai', '5.5', '2016-02-29', '2');
INSERT INTO `student_info` VALUES ('3', 'Bien Hoa, Dong Nai', '7', '2016-03-16', '3');
INSERT INTO `student_info` VALUES ('5', 'Bien Hoa, Dong Nai', '7.5', '1994-07-14', '5');
INSERT INTO `student_info` VALUES ('6', 'Bien Hoa, Dong Nai', '7.5', '1994-07-14', '6');
INSERT INTO `student_info` VALUES ('36', 'Bien Hoa, Dong Nai', '7', '1994-07-14', '36');
INSERT INTO `student_info` VALUES ('37', 'Ho Nai, Bien Hoa, Dong Nai', '7.5', '1994-07-14', '37');
INSERT INTO `student_info` VALUES ('38', 'Bien Hoa, Dong Nai', '7.4', '1994-07-14', '38');
INSERT INTO `student_info` VALUES ('39', 'Bien Hoa, Dong Nai', '7.4', '1994-07-14', '39');
INSERT INTO `student_info` VALUES ('42', 'Bien Hoa, Dong Nai', '7', '1994-07-14', '42');
INSERT INTO `student_info` VALUES ('43', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '43');
INSERT INTO `student_info` VALUES ('44', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '44');
INSERT INTO `student_info` VALUES ('45', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '45');
INSERT INTO `student_info` VALUES ('46', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '46');
INSERT INTO `student_info` VALUES ('47', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '47');
INSERT INTO `student_info` VALUES ('48', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '48');
INSERT INTO `student_info` VALUES ('49', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '49');
INSERT INTO `student_info` VALUES ('50', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-09', '50');
INSERT INTO `student_info` VALUES ('51', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '51');
INSERT INTO `student_info` VALUES ('52', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '52');
INSERT INTO `student_info` VALUES ('53', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '53');
INSERT INTO `student_info` VALUES ('54', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-24', '54');
INSERT INTO `student_info` VALUES ('56', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-09', '56');
INSERT INTO `student_info` VALUES ('57', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-25', '57');
INSERT INTO `student_info` VALUES ('58', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-25', '61');
INSERT INTO `student_info` VALUES ('59', 'Ho Nai, Bien Hoa, Dong Nai', '7.6', '2016-03-25', '62');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `group_user` int(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('2', 'user', 'user', '0');
