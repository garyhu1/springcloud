# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2018-01-13 10:41:58
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "account_"
#

DROP TABLE IF EXISTS `account_`;
CREATE TABLE `account_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "account_"
#

INSERT INTO `account_` VALUES (1,'����',20,100.00),(2,'����',28,180.00),(3,'����',32,280.00);

#
# Structure for table "category_"
#

DROP TABLE IF EXISTS `category_`;
CREATE TABLE `category_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "category_"
#

/*!40000 ALTER TABLE `category_` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_` ENABLE KEYS */;

#
# Structure for table "department"
#

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "department"
#

INSERT INTO `department` VALUES (1,'����'),(2,'�з�'),(3,'�ͷ�');

#
# Structure for table "employee"
#

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) unsigned NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "employee"
#


#
# Structure for table "order_"
#

DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "order_"
#

INSERT INTO `order_` VALUES (1,'֥�Ӹ�','18923476534','Chicago','USA'),(2,'����','15987634092','Paris','France'),(3,'�׶�','13823096781','London','England'),(4,'����','15088293471','Beijing','China'),(5,'���׶�','13298761220','Toronto','Canada'),(6,'ŦԼ','18823974406','NYC','USA'),(7,'������','18733296763','Miami','USA'),(8,'�Ϻ�','15589230061','Shanghai','China'),(9,'��ɼ�','13887493329','Los Angeles','USA'),(10,'�¸绪','15833729453','Vancouver','Canada');

#
# Structure for table "product_"
#

DROP TABLE IF EXISTS `product_`;
CREATE TABLE `product_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "product_"
#

/*!40000 ALTER TABLE `product_` DISABLE KEYS */;
INSERT INTO `product_` VALUES (1,'ƻ��',2.5,2),(2,'�㽶',4.8,2),(3,'iPhone 7',5399,1),(4,'����',26.8,2),(5,'����',5,2),(6,'oppo',2699,1),(7,'dell',5899,3),(8,'mac',12900,3),(9,'_meizu',3999,2);
/*!40000 ALTER TABLE `product_` ENABLE KEYS */;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'С��',1),(2,'С��',1),(3,'Jone',1),(4,'���',2),(5,'����',1),(6,'Judy',2),(7,'James',3),(8,'С��',3),(9,'����',2),(10,'������',3),(11,'������',2),(12,'������',3),(13,'����',3),(14,'����',3),(15,'�ܽ���',3),(16,'�ֿ���',3),(17,'������',3),(18,'������',3),(19,'���ӽ�',3);

#
# Structure for table "user_"
#

DROP TABLE IF EXISTS `user_`;
CREATE TABLE `user_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `height` float DEFAULT NULL,
  `age` int(11) DEFAULT '18',
  `sex` enum('male','female') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "user_"
#

/*!40000 ALTER TABLE `user_` DISABLE KEYS */;
INSERT INTO `user_` VALUES (1,'����',183,18,'male'),(2,'����',168,23,'male'),(3,'��÷÷',170,23,'female'),(4,'��Ө',157,23,'female'),(5,'��ȫ��',168,23,'male'),(6,'С��',161,23,'female');
/*!40000 ALTER TABLE `user_` ENABLE KEYS */;
