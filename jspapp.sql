/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : jspapp

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-07-09 21:13:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '学生');
INSERT INTO `t_role` VALUES ('2', '教师');
INSERT INTO `t_role` VALUES ('3', '管理员');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `role_id` int(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '2017117128', '3', '管理员爱华', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('5', '153633983281', '3', '153633983281', 'lhb659431', null, null, null);
INSERT INTO `t_student` VALUES ('7', '15363398328', '3', '15363398328', '123456', null, null, null);
INSERT INTO `t_student` VALUES ('11', '2017117130', '1', '学生爱华4', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('12', '2017117131', '1', '学生爱华1', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('13', '2017117132', '1', '学生爱华3', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('14', '2017117133', '1', '学生爱华2', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('15', '2017117134', '1', '学生爱华5', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('16', '2017117135', '1', '学生爱华6', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('17', '2017117136', '1', '学生爱华7', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('18', '2017117137', '1', '学生爱华8', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('19', '2017117138', '1', '学生爱华9', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('21', '2017117140', '1', '学生爱华11', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('22', '2017117141', '1', '学生爱华12', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('23', '2017117142', '1', '学生爱华13', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('24', '2017117143', '1', '学生爱华14', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('25', '2017117144', '1', '学生爱华15', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('26', '2017117145', '1', '学生爱华16', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
INSERT INTO `t_student` VALUES ('27', '2017117146', '1', '学生爱华17', '123456', '广东省梅州市', '30', '2020-07-01 13:50:10');
