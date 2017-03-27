/*
SQLyog Community Edition- MySQL GUI v8.12 
MySQL - 5.5.28 : Database - quickstart
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`cjttest` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cjttest`;

DROP TABLE IF EXISTS `ss_case`;
DROP TABLE IF EXISTS `ss_req`;
DROP TABLE IF EXISTS `ss_module`;
DROP TABLE IF EXISTS `ss_user`;
DROP TABLE IF EXISTS `ss_scipt_config`;
DROP TABLE IF EXISTS `ss_version_task`;
DROP TABLE IF EXISTS `ss_task_case`;

CREATE TABLE `ss_req` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `req_name` varchar(100) NOT NULL DEFAULT '0',
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `req_disc` varchar(50) DEFAULT '0',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `priority` varchar(20) DEFAULT NULL,
  `req_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

CREATE TABLE `ss_case` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_name` varchar(100) NOT NULL DEFAULT '0',
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `case_disc` varchar(50) DEFAULT '0',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `priority` varchar(20) DEFAULT NULL,
  `scipt_id` bigint(20) DEFAULT NULL,
  `case_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;



/*Table structure for table `ss_module` */

CREATE TABLE `ss_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `module_type` varchar(50) DEFAULT NULL,
  `request` varchar(255) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `discription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;




/*Table structure for table `ss_user` */



CREATE TABLE `ss_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `roles` varchar(255) NOT NULL,
  `register_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



/*Table structure for table `ss_scpit_config` */



CREATE TABLE `ss_scipt_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) DEFAULT NULL,
  `order_num` int(8) NOT NULL,
  `step_name` varchar(128) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `request_params` varchar(500) DEFAULT NULL,
  `response_params` varchar(500) DEFAULT NULL,
  `rele_params` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

/*Data for the table `ss_scpit_config` */


CREATE TABLE `ss_version_task` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '0',
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `leaf` tinyint(4) NOT NULL DEFAULT '0',
  `discription` varchar(50) DEFAULT '0',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0未执行，1正在执行',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE `ss_task_case` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `discription` varchar(50) DEFAULT '0',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `case_id` bigint(20) DEFAULT NULL,
  `task_name` varchar(255) DEFAULT NULL COMMENT '0未执行，1正在执行,2执行结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
