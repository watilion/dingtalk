/*
Navicat MySQL Data Transfer

Source Server         : 47.98.171.116
Source Server Version : 50610
Source Host           : 47.98.171.116:21217
Source Database       : dingtalk

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2020-01-03 16:33:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dingtalkmessage
-- ----------------------------
DROP TABLE IF EXISTS `dingtalkmessage`;
CREATE TABLE `dingtalkmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `taskId` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dingtalkmessage
-- ----------------------------
INSERT INTO `dingtalkmessage` VALUES ('4', 'test text msg2', '64213866290');
INSERT INTO `dingtalkmessage` VALUES ('5', 'test text msg3', '64214958898');

-- ----------------------------
-- Table structure for dingtalkmessagereceiver
-- ----------------------------
DROP TABLE IF EXISTS `dingtalkmessagereceiver`;
CREATE TABLE `dingtalkmessagereceiver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(255) DEFAULT NULL COMMENT '钉钉用户id',
  `tblUserId` varchar(255) DEFAULT NULL COMMENT '系统用户id',
  `messageId` int(11) DEFAULT NULL COMMENT '信息推送任务id',
  `status` varchar(255) DEFAULT NULL COMMENT '发送状态，0-发送中，1-被限流用户，2-发送失败，3-已读，4-未读，5-无效部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dingtalkmessagereceiver
-- ----------------------------
INSERT INTO `dingtalkmessagereceiver` VALUES ('1', '1', '1', '1', '1');
INSERT INTO `dingtalkmessagereceiver` VALUES ('2', '2', '2', '2', '2');
INSERT INTO `dingtalkmessagereceiver` VALUES ('3', 'manager8784', null, null, '0');
INSERT INTO `dingtalkmessagereceiver` VALUES ('4', 'manager8784', null, '5', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'watilion', '15558072209');
