/*
Navicat MySQL Data Transfer

Source Server         : 608
Source Server Version : 50716
Source Host           : 192.168.60.8:3306
Source Database       : ihome

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-09 16:09:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `acc` varchar(20) DEFAULT NULL,
  `regTime` date DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `loginIp` varchar(30) DEFAULT NULL,
  `lastLoginIp` varchar(30) DEFAULT NULL,
  `status` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `index_acc` (`acc`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '05d5fcd9fd993a4fa50e930cbfb2b2bd', '123', 'admin', '2016-11-29', '2016-12-09 11:34:18', '2016-12-09 11:34:18', '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `t_admin` VALUES ('2', 'test1', '05d5fcd9fd993a4fa50e930cbfb2b2bd', '13800138004', 'test', '2016-12-01', null, null, null, null, '0');
INSERT INTO `t_admin` VALUES ('3', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('4', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '0');
INSERT INTO `t_admin` VALUES ('5', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('6', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('7', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('8', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('9', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('10', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('11', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('12', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('13', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('14', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('15', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('16', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '0');
INSERT INTO `t_admin` VALUES ('17', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('18', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '0');
INSERT INTO `t_admin` VALUES ('19', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('20', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('21', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('22', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('23', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('24', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('25', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('26', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('27', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('28', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('29', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('30', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('31', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('32', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('33', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('34', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('35', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('36', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('37', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('38', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('39', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('40', 'aaa', null, 'ccc', 'bbb', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('41', '1233', null, '13800138001', '你', null, null, null, null, null, '1');
INSERT INTO `t_admin` VALUES ('42', '22', null, '13800138002', 'ss', '2016-12-09', null, null, null, null, '1');

-- ----------------------------
-- Table structure for `t_house`
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL COMMENT '房名称',
  `addr` varchar(500) DEFAULT NULL COMMENT '地址',
  `area` varchar(30) DEFAULT NULL COMMENT '区',
  `city` varchar(30) DEFAULT NULL COMMENT '市',
  `province` varchar(30) DEFAULT NULL COMMENT '省',
  `price` varchar(60) DEFAULT NULL COMMENT '价格',
  `startTime` date DEFAULT NULL COMMENT '合同开始时间',
  `endTime` date DEFAULT NULL COMMENT '合同结束时间',
  `waterPrice` double(11,0) DEFAULT NULL COMMENT '水价',
  `elecPrice` double(11,0) DEFAULT NULL COMMENT '电价',
  `imgs` varchar(500) DEFAULT NULL COMMENT '房源图片以;隔开',
  `own` varchar(60) DEFAULT NULL COMMENT '房东',
  `tel` varchar(20) DEFAULT NULL COMMENT '房东电话',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_house
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) DEFAULT NULL,
  `title` varchar(60) DEFAULT NULL COMMENT '标题',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `spread` tinyint(2) DEFAULT '0' COMMENT '是否打开:1是,0否',
  `href` varchar(60) DEFAULT NULL COMMENT '路径',
  `state` tinyint(2) DEFAULT '1' COMMENT '状态:1启用,0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '0', '系统管理', '&#xe641;', '0', null, '1');
INSERT INTO `t_menu` VALUES ('2', '0', '房源管理', '&#xe62d;', '0', null, '1');
INSERT INTO `t_menu` VALUES ('3', '0', '租金管理', '&#xe63c;', '0', null, '1');
INSERT INTO `t_menu` VALUES ('4', '0', '客户管理', '&#xe612;', '0', null, '1');
INSERT INTO `t_menu` VALUES ('5', '0', '报表管理', '&#xe629;', '0', null, '1');
INSERT INTO `t_menu` VALUES ('6', '0', '微信管理', '&#xe63a;', '0', null, '1');
INSERT INTO `t_menu` VALUES ('9', '1', '管理员', '&#xe612;', '0', 'admin/list', '1');
INSERT INTO `t_menu` VALUES ('10', '1', '系统设置', '&#xe620;', '0', 'admin/profile', '1');
INSERT INTO `t_menu` VALUES ('11', '2', '房源列表', '&#xe649;', '0', 'house/list', '1');
INSERT INTO `t_menu` VALUES ('12', '2', '故障维修', '&#xe620;', '0', null, '1');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uId` int(11) DEFAULT NULL,
  `hId` int(11) DEFAULT NULL,
  `rId` int(11) DEFAULT NULL,
  `orderTime` date DEFAULT NULL,
  `state` varchar(11) DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `payType` varchar(60) DEFAULT NULL,
  `totalPrice` decimal(11,2) DEFAULT NULL,
  `rentPrice` decimal(11,2) DEFAULT NULL,
  `waterPrice` decimal(11,2) DEFAULT NULL,
  `elecPrice` decimal(11,2) DEFAULT NULL,
  `netPrice` decimal(11,2) DEFAULT NULL,
  `cleanPrice` decimal(11,2) DEFAULT NULL,
  `orderPrice` decimal(11,2) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_profile`
-- ----------------------------
DROP TABLE IF EXISTS `t_profile`;
CREATE TABLE `t_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(60) NOT NULL,
  `value` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_profile
-- ----------------------------
INSERT INTO `t_profile` VALUES ('1', 'key_1', '22123', '123');
INSERT INTO `t_profile` VALUES ('2', 'key_2', '223', '131');

-- ----------------------------
-- Table structure for `t_room`
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hId` int(11) DEFAULT NULL,
  `uId` int(11) DEFAULT NULL COMMENT '住户ID',
  `doorplate` varchar(60) DEFAULT NULL COMMENT '门牌',
  `floor` varchar(60) DEFAULT NULL COMMENT '楼层',
  `number` varchar(60) DEFAULT NULL COMMENT '房号',
  `roomType` varchar(60) DEFAULT NULL COMMENT '房间属性',
  `rentPrice` decimal(11,2) DEFAULT NULL,
  `startTime` date DEFAULT NULL COMMENT '开始时间',
  `endTime` date DEFAULT NULL COMMENT '到期时间',
  `deposit` decimal(11,2) DEFAULT NULL COMMENT '压金',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `water` int(11) DEFAULT NULL COMMENT '水表读数',
  `elec` int(11) DEFAULT NULL COMMENT '电表读数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_room
-- ----------------------------

-- ----------------------------
-- Table structure for `t_swot`
-- ----------------------------
DROP TABLE IF EXISTS `t_swot`;
CREATE TABLE `t_swot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rId` int(11) DEFAULT NULL,
  `type` int(2) DEFAULT NULL COMMENT '读数类型:1电,2水',
  `year` int(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `val` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_swot
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL COMMENT '真实姓名',
  `nickName` varchar(120) DEFAULT NULL COMMENT '昵称',
  `openId` varchar(64) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `integral` int(11) DEFAULT NULL COMMENT '积分',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `job` varchar(20) DEFAULT NULL COMMENT '职业',
  `img` varchar(500) DEFAULT NULL COMMENT '头像',
  `pwd` varchar(255) DEFAULT NULL,
  `regTime` date DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'aa', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('2', 'bbb', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('3', 'ccc', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('4', 'ddd', null, null, null, null, null, null, null, null, null, null);
