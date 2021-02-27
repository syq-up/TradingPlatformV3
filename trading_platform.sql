/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.33-log : Database - trading_platform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`trading_platform` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `trading_platform`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_detail` int(11) NOT NULL,
  `goods_img` varchar(50) NOT NULL,
  `goods_name` varchar(50) NOT NULL,
  `new_price` decimal(10,2) NOT NULL,
  `old_price` decimal(10,2) DEFAULT NULL,
  `quality` varchar(10) DEFAULT NULL,
  `trade_way` varchar(4) NOT NULL DEFAULT '在线交易',
  `goods_detail` text,
  `sort` varchar(10) NOT NULL,
  `last_edit_time` datetime NOT NULL,
  `state` int(1) NOT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `fk_goods_udetail` (`user_detail`),
  CONSTRAINT `fk_goods_udetail` FOREIGN KEY (`user_detail`) REFERENCES `user_detail` (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`goods_id`,`user_detail`,`goods_img`,`goods_name`,`new_price`,`old_price`,`quality`,`trade_way`,`goods_detail`,`sort`,`last_edit_time`,`state`) values 
(1,1,'goods-default-image','手机',5.00,10.00,'全新','在线交易','是个手机','digital','2020-02-09 17:16:50',1),
(2,1,'goods-default-image','手机',5.00,10.00,'全新','在线交易','是个手机','digital','2020-02-09 17:16:50',1),
(3,1,'goods-default-image','手机',5.00,10.00,'全新','在线交易','是个手机','digital','2020-02-09 17:16:50',1),
(4,1,'goods-default-image','手机',5.00,10.00,'全新','在线交易','是个手机','digital','2020-02-09 17:16:50',1),
(5,1,'goods-default-image','手机',5.00,10.00,'全新','在线交易','是个手机','digital','2020-02-09 17:16:50',1),
(6,1,'goods-default-image','手机',5.00,10.00,'全新','在线交易','是个手机','digital','2020-02-09 17:16:50',1),
(7,1,'goods-default-image','手机',5.00,10.00,'全新','在线交易','是个手机','digital','2020-02-09 17:16:50',1);

/*Table structure for table `goods_collection` */

DROP TABLE IF EXISTS `goods_collection`;

CREATE TABLE `goods_collection` (
  `collection_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods` int(11) NOT NULL,
  PRIMARY KEY (`collection_id`),
  KEY `fk_collect_goods` (`goods`),
  CONSTRAINT `fk_collect_goods` FOREIGN KEY (`goods`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `goods_collection` */

insert  into `goods_collection`(`collection_id`,`user_id`,`goods`) values 
(1,1,1),
(2,1,2),
(3,1,1),
(4,1,1),
(5,1,1),
(6,1,1),
(7,1,1);

/*Table structure for table `goods_guestbook` */

DROP TABLE IF EXISTS `goods_guestbook`;

CREATE TABLE `goods_guestbook` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_nickname` varchar(20) NOT NULL,
  `user_img` varchar(30) DEFAULT '1.jpg',
  `message` varchar(50) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `goods_guestbook` */

insert  into `goods_guestbook`(`msg_id`,`goods_id`,`user_id`,`user_nickname`,`user_img`,`message`,`datetime`) values 
(1,1,1,'sss','1.jpg','sss','2021-02-09 17:51:38');

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `persistent_logins` */

insert  into `persistent_logins`(`username`,`series`,`token`,`last_used`) values 
('sss','0c+tBCWlO3lnZSbU2ADvHw==','a6qSpOwkZFbqn+k5qbfkfA==','2021-02-26 08:01:47');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_pwd` varchar(60) NOT NULL,
  `user_reg` date NOT NULL,
  `user_detail` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_user_detail` (`user_detail`),
  CONSTRAINT `fk_user_detail` FOREIGN KEY (`user_detail`) REFERENCES `user_detail` (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_pwd`,`user_reg`,`user_detail`) values 
(1,'sss','$2a$10$qDaNA7N480QdkXI9SiPbceYwu7RCYiyd87BjsoMB51s/u1ZohTiny','2021-02-08',1),
(2,'ss','$2a$10$D1I6ivusG8LUvStCQmoEru/9BseQs44B/mILBBDbi//WHbHQP9/1i','2021-02-09',NULL);

/*Table structure for table `user_addr` */

DROP TABLE IF EXISTS `user_addr`;

CREATE TABLE `user_addr` (
  `addr_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `province` varchar(8) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `county` varchar(10) DEFAULT NULL,
  `detail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`addr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_addr` */

insert  into `user_addr`(`addr_id`,`user_id`,`province`,`city`,`county`,`detail`) values 
(1,1,NULL,NULL,NULL,NULL);

/*Table structure for table `user_detail` */

DROP TABLE IF EXISTS `user_detail`;

CREATE TABLE `user_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) NOT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT '保密',
  `birthday` date DEFAULT '2000-01-01',
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `head_img` varchar(50) DEFAULT 'user-default-headImage.jpg',
  `cur_addr` int(11) DEFAULT NULL,
  `selling_count` int(11) DEFAULT '0',
  `sold_count` int(11) DEFAULT '0',
  `collect_count` int(11) DEFAULT '0',
  `buy_count` int(11) DEFAULT '0',
  PRIMARY KEY (`detail_id`),
  KEY `fk_detail_addr` (`cur_addr`),
  CONSTRAINT `fk_detail_addr` FOREIGN KEY (`cur_addr`) REFERENCES `user_addr` (`addr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_detail` */

insert  into `user_detail`(`detail_id`,`nickname`,`real_name`,`sex`,`birthday`,`phone`,`email`,`head_img`,`cur_addr`,`selling_count`,`sold_count`,`collect_count`,`buy_count`) values 
(1,'sss昵称','','保密','2000-01-01','',NULL,'user-default-headImage.jpg',1,0,0,0,0),
(2,'ss昵称',NULL,'保密','2000-01-01',NULL,NULL,'user-default-headImage.jpg',NULL,0,0,0,0);

/*Table structure for table `user_order` */

DROP TABLE IF EXISTS `user_order`;

CREATE TABLE `user_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_goods` (`goods`),
  CONSTRAINT `fk_order_goods` FOREIGN KEY (`goods`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_order` */

insert  into `user_order`(`order_id`,`user_id`,`goods`,`datetime`) values 
(1,1,2,'2021-02-09 17:52:43');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
