/*
Navicat MySQL Data Transfer

Source Server         : porject
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : read_book_system_db

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2017-03-18 22:18:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_kind_table
-- ----------------------------
DROP TABLE IF EXISTS `book_kind_table`;
CREATE TABLE `book_kind_table` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for book_table
-- ----------------------------
DROP TABLE IF EXISTS `book_table`;
CREATE TABLE `book_table` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT '0.00',
  `num` varchar(255) DEFAULT NULL COMMENT '条形码',
  `kind` int(4) DEFAULT '0',
  `editer_id` int(8) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `num_key` (`num`),
  KEY `kind_fk` (`kind`),
  KEY `editer_id_fk` (`editer_id`),
  CONSTRAINT `editer_id_fk` FOREIGN KEY (`editer_id`) REFERENCES `people_table` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `kind_fk` FOREIGN KEY (`kind`) REFERENCES `book_kind_table` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for look_book_table
-- ----------------------------
DROP TABLE IF EXISTS `look_book_table`;
CREATE TABLE `look_book_table` (
  `id` int(8) NOT NULL,
  `book_id` int(8) DEFAULT NULL,
  `user_id` int(8) DEFAULT NULL,
  `page` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id_fk` (`book_id`),
  KEY `user_id_fk` (`user_id`),
  CONSTRAINT `book_id_fk` FOREIGN KEY (`book_id`) REFERENCES `book_table` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `people_table` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for people_kind_table
-- ----------------------------
DROP TABLE IF EXISTS `people_kind_table`;
CREATE TABLE `people_kind_table` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for people_table
-- ----------------------------
DROP TABLE IF EXISTS `people_table`;
CREATE TABLE `people_table` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` int(4) DEFAULT NULL COMMENT '0为男，1为女',
  `age` int(4) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `type` int(4) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`),
  KEY `type_fk` (`type`),
  CONSTRAINT `type_fk` FOREIGN KEY (`type`) REFERENCES `people_kind_table` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
