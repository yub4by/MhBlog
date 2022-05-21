/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : vueblog

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2022-05-21 18:59:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_blog
-- ----------------------------
DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `content` longtext,
  `created` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog` VALUES ('11', '1', 'test1', 'test1', 'test1test1test1', '2021-12-14 20:25:24', '0');
INSERT INTO `m_blog` VALUES ('12', '2', 'test2', 'test2', 'test2test2', '2021-12-14 20:40:37', '0');
INSERT INTO `m_blog` VALUES ('13', '1', 'test1', 'test1', 'test1test1test1', '2021-12-14 20:25:24', '0');
INSERT INTO `m_blog` VALUES ('14', '1', '这时修改后的标题', '这是修改的摘要哈哈哈', '这是修改的内容哈哈哈', '2021-12-14 20:40:40', '0');
INSERT INTO `m_blog` VALUES ('15', '1', '测试标题1111', '测试摘要啊啊啊', '测试内容zzzz', '2021-12-14 20:36:35', '0');
INSERT INTO `m_blog` VALUES ('16', '1', '测试标题555', '测试摘要啊啊啊', '测试内容zzzz', '2021-12-15 11:54:24', '0');
INSERT INTO `m_blog` VALUES ('17', '1', '测试标题444', '测试摘要啊啊啊', '测试内容zzzz', '2021-12-15 11:54:21', '0');
INSERT INTO `m_blog` VALUES ('44', '1', '测试标题333', '测试摘要啊啊啊', '测试内容zzzz', '2021-12-15 11:54:17', '0');
INSERT INTO `m_blog` VALUES ('66', '1', '测试标题222', '测试摘要啊啊啊', '测试内容zzzz', '2021-12-15 11:54:13', '0');
INSERT INTO `m_blog` VALUES ('67', '1', 'bbbbbbbb测试', 'aaaa', '### 三级标题aaaaaa\n\n\n```\nprintf(\"helloworld\")\n```\n\n~~中划线~~\n\n++下划线++\n\n==标记==', '2021-12-15 12:15:40', '0');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `status` int(5) NOT NULL,
  `created` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `UK_USERNAME` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', 'markerhub', 'https://cdn.jsdelivr.net/gh/yub4by/picx-image-hosting@master/20211115/01492131S-2.rvk7dn3rcts.jpg', 'yub4by@qq.com', '96e79218965eb72c92a549dd5a330112', '0', '2020-04-20 10:44:01', null);
