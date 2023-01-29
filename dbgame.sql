create database card_game;
use card_game;
/*
Navicat MySQL Data Transfer

Source Server         : mysql_local
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : imdb1user

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-11-24 18:26:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `play_info` varchar(500) DEFAULT NULL,
  `room_status` tinyint(2) NOT NULL DEFAULT '0',
  `play_counts` tinyint(4) NOT NULL DEFAULT '0',
  `room_owner` int(11) NOT NULL,
  `operate_type` tinyint(2) DEFAULT NULL,
  `operate_user` tinyint(11) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1000', 'ææ¯æ¿é´ä¿¡æ¯', '0', '0', '1', null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` char(11) DEFAULT NULL,
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 女 1 男',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '头像',
  `profile` varchar(50) NOT NULL DEFAULT '' COMMENT '简介',
  `vip` tinyint(4) NOT NULL DEFAULT '0' COMMENT '会员特权',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wuyingjie', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '2017-11-14 13:45:49', '', '', '9');
INSERT INTO `user` VALUES ('2', 'liuliji', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '2017-11-14 13:46:20', '', '', '9');
INSERT INTO `user` VALUES ('3', 'test', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '2017-11-22 15:02:23', '', '', '0');
INSERT INTO `user` VALUES ('4', 'test2', 'e10adc3949ba59abbe56e057f20f883e', null, '0', '2017-11-24 18:08:18', '', '', '0');

-- ----------------------------
-- Table structure for `user_game`
-- ----------------------------
DROP TABLE IF EXISTS `user_game`;
CREATE TABLE `user_game` (
  `id` int(11) NOT NULL,
  `level` tinyint(2) NOT NULL DEFAULT '1' COMMENT '用户游戏等级',
  `integral` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户积分',
  `game_bill` int(11) NOT NULL DEFAULT '0' COMMENT '用户游戏币',
  `game_times` int(11) NOT NULL DEFAULT '0' COMMENT '进行游戏次数',
  `game_win_times` int(11) NOT NULL DEFAULT '0' COMMENT '游戏胜利次数',
  `game_loss_times` int(11) NOT NULL DEFAULT '0' COMMENT '游戏失败次数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_game
-- ----------------------------

