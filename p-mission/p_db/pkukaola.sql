/*
Navicat MySQL Data Transfer

Source Server         : pkukaola
Source Server Version : 50562
Source Host           : 182.254.200.15:3306
Source Database       : pkukaola

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-12-23 18:35:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pkukaola_category
-- ----------------------------
DROP TABLE IF EXISTS `pkukaola_category`;
CREATE TABLE `pkukaola_category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(63) NOT NULL DEFAULT '' COMMENT '类目名称',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pkukaola_category
-- ----------------------------
INSERT INTO `pkukaola_category` VALUES ('0', '图书');
INSERT INTO `pkukaola_category` VALUES ('1', '电子');
INSERT INTO `pkukaola_category` VALUES ('2', '其他');

-- ----------------------------
-- Table structure for pkukaola_comment
-- ----------------------------
DROP TABLE IF EXISTS `pkukaola_comment`;
CREATE TABLE `pkukaola_comment` (
  `userid` int(20) DEFAULT NULL,
  `commentid` int(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `missionid` int(20) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pkukaola_comment
-- ----------------------------

-- ----------------------------
-- Table structure for pkukaola_goods
-- ----------------------------
DROP TABLE IF EXISTS `pkukaola_goods`;
CREATE TABLE `pkukaola_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publish_user_id` int(11) DEFAULT '0' COMMENT '谁发布了商品',
  `title` varchar(127) NOT NULL DEFAULT '' COMMENT '商品名称',
  `describe` text COMMENT '商品简介,是富文本格式',
  `publish_address` varchar(255) DEFAULT '' COMMENT '发布地址',
  `price` decimal(10,2) DEFAULT '1.00' COMMENT '零售价格',
  `publish_date` date NOT NULL COMMENT '创建时间',
  `look_count` int(11) DEFAULT '0' COMMENT '浏览人数',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论次数',
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pkukaola_goods_pkukaola_category_category_id_fk` (`category_id`),
  CONSTRAINT `pkukaola_goods_pkukaola_category_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `pkukaola_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pkukaola_goods
-- ----------------------------
INSERT INTO `pkukaola_goods` VALUES ('50', '57', '卫龙 八成新', '转让半包辣条，卫龙的，8月初才买的，吃了3条，里面还有23条，还有很多辣油，不舍的吃的时候就拿出来闻一闻，平常吃完都是用订书机订起来的，防止受潮。外表大概8成新吧。量很足，厚度约2cm，高度8cm，包行货，假一罚十，真的很好吃，平时小半条就可以回味半天...', '北京 大兴', '2.00', '2019-12-23', '55', '0', '2');
INSERT INTO `pkukaola_goods` VALUES ('51', '3', '正版哈利·波特与混血王子JK罗琳著', '这是你不能错过的更加精彩、刺激的魔法之旅', '北京 大兴', '25.00', '2019-12-09', '402', '0', '0');
INSERT INTO `pkukaola_goods` VALUES ('52', '4', '摆渡人系列123全套共3册套装中文译本', '媲美追风筝偷影子的人重返荒原无境之爱心灵治愈人性救赎外国文学小说畅销书籍', '北京 大兴', '45.00', '2019-12-17', '389', '0', '0');
INSERT INTO `pkukaola_goods` VALUES ('53', '3', 'Huawei/华为Mate 30 Pro 5G', '麒麟990徕卡四摄5G芯片智能手机mate30 pro 5g', '北京 大兴', '6300.00', '2019-12-01', '1003', '0', '1');
INSERT INTO `pkukaola_goods` VALUES ('54', '4', 'Lenovo/联想 拯救者 Y7000P 2019款', '内存容量:8GB 机械硬盘容量:1TB CPU:英特尔 酷睿i7-9750H 屏幕尺寸:15.6英寸 显存容量:6GB 显卡类型:NVIDIA GTX1660Ti', '北京 大兴', '6800.00', '2019-12-15', '1210', '0', '1');

-- ----------------------------
-- Table structure for pkukaola_images
-- ----------------------------
DROP TABLE IF EXISTS `pkukaola_images`;
CREATE TABLE `pkukaola_images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `path` varchar(255) NOT NULL COMMENT '商品图片或者商品货品图片',
  PRIMARY KEY (`image_id`),
  KEY `pkukaola_images` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pkukaola_images
-- ----------------------------
INSERT INTO `pkukaola_images` VALUES ('76', '50', 'http://ayy.ganzhiqiang.wang/tmp_cee2781691b5b924ef1e0423f8b37d899debfc3f4ae94214.jpg');
INSERT INTO `pkukaola_images` VALUES ('77', '51', 'https://i.loli.net/2019/12/23/p7hOoYbPlrG2E9q.jpg');
INSERT INTO `pkukaola_images` VALUES ('78', '52', 'https://i.loli.net/2019/12/23/5QCshPMy2mGfOoi.jpg');
INSERT INTO `pkukaola_images` VALUES ('79', '53', 'https://i.loli.net/2019/12/23/RJMo3QPDaWBv94k.jpg');
INSERT INTO `pkukaola_images` VALUES ('80', '54', 'https://i.loli.net/2019/12/23/JBQyEjucZlIfXo3.jpg');

-- ----------------------------
-- Table structure for pkukaola_mission
-- ----------------------------
DROP TABLE IF EXISTS `pkukaola_mission`;
CREATE TABLE `pkukaola_mission` (
  `missionid` int(20) NOT NULL,
  `missionname` varchar(255) DEFAULT NULL,
  `discribe` varchar(2550) DEFAULT NULL,
  `missionclass` char(255) DEFAULT NULL,
  `publisherid` int(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `lookcount` int(10) DEFAULT NULL,
  `commentcount` int(10) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `image_list` varchar(255) DEFAULT NULL,
  `publisher_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`missionid`),
  KEY `pkukaola_mission_ibfk_1` (`publisherid`),
  CONSTRAINT `pkukaola_mission_ibfk_1` FOREIGN KEY (`publisherid`) REFERENCES `pkukaola_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pkukaola_mission
-- ----------------------------
INSERT INTO `pkukaola_mission` VALUES ('71', '11', '11', '0', '53', '', '0', '0', '11.00', '', '北京 海淀');

-- ----------------------------
-- Table structure for pkukaola_user
-- ----------------------------
DROP TABLE IF EXISTS `pkukaola_user`;
CREATE TABLE `pkukaola_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名称',
  `password` varchar(63) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近一次登录时间',
  `last_login_ip` varchar(63) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '最近一次登录IP地址',
  `user_level` tinyint(3) DEFAULT '0' COMMENT '0 普通用户，1 VIP用户，2 高级VIP用户',
  `gender` tinyint(3) NOT NULL DEFAULT '0' COMMENT '性别：0 未知， 1男， 1 女',
  `nickname` varchar(63) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户昵称或网络名称',
  `mobile` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户手机号码',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户头像图片',
  `session_key` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信登录会话KEY',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0 可用, 1 禁用, 2 注销',
  `weixin_openid` varchar(63) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信登录openid',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `look_count` int(11) DEFAULT '0' COMMENT '浏览次数',
  `publish_count` int(11) DEFAULT '0' COMMENT '发布次数',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '地址',
  `school` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '学校',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of pkukaola_user
-- ----------------------------
INSERT INTO `pkukaola_user` VALUES ('3', '$2a$2a$10$lTu9qi0hr19OC800Db', '', '2019-12-11', '2019-12-23 15:32:57', '', '0', '0', 'sda', '1232', 'https://i.loli.net/2019/12/23/XqTt8IpMnZ9fGQj.jpg', '', '1', '', null, null, '12', '1', '北京 大兴', '软微', '0');
INSERT INTO `pkukaola_user` VALUES ('51', 'ou_eQ4gWSlDvtZsiLrck_0ec6sKA', 'ou_eQ4gWSlDvtZsiLrck_0ec6sKA', null, '2019-12-23 16:37:27', '124.205.76.23', '0', '1', 'leo', '17864267651', 'https://wx.qlogo.cn/mmopen/vi_32/uEaW1pic9mkCT7ZbdsDL2H1h7QAKOiciaXp5BdpSD19ShTj7ZmFbGG5bdD84RBMV4ic4GfraCH79Z6V4T71JuKPk2Q/132', 'd6g/ysR5SFO1RtTNFfOj2w==', '0', 'ou_eQ4gWSlDvtZsiLrck_0ec6sKA', '2019-12-23 15:40:10', '2019-12-23 16:37:27', '0', '0', '', '', '0');
INSERT INTO `pkukaola_user` VALUES ('52', 'ou_eQ4n-xR4mYR4OgXZWs6xhdXKc', 'ou_eQ4n-xR4mYR4OgXZWs6xhdXKc', null, '2019-12-23 16:33:00', '124.205.76.23', '0', '1', '王艺辉', '', 'https://wx.qlogo.cn/mmopen/vi_32/239h30GxsICHJqdQ60QQ6avUC9icTkegj9aA1TRasBWYvHyVHnUM2dzjxGlFSQ1KR4ObaWIXeXfPruAC1FZZFDw/132', 'IvIziNzbwiTRXjXCS9qDfA==', '0', 'ou_eQ4n-xR4mYR4OgXZWs6xhdXKc', '2019-12-23 16:33:00', '2019-12-23 17:25:18', '0', '0', '', '', '0');
INSERT INTO `pkukaola_user` VALUES ('53', 'ou_eQ4tiManN0ka2wWC8sq98v_TA', 'ou_eQ4tiManN0ka2wWC8sq98v_TA', null, '2019-12-23 16:53:49', '0:0:0:0:0:0:0:1', '0', '1', '动次打次', '', 'https://wx.qlogo.cn/mmopen/vi_32/ic1j9icicrWo9ChARtSZ2j29uCVc9dVAZUND6qibBCqsb2WbPXOSGqPHxax4Wc6SjH26jm6jdmEKUYuYMd0klWzQXw/132', 'lPH5i/2cXvdw+luExazNTw==', '0', 'ou_eQ4tiManN0ka2wWC8sq98v_TA', '2019-12-23 16:53:49', '2019-12-23 17:36:17', '0', '0', '', '', '0');
INSERT INTO `pkukaola_user` VALUES ('57', '$2a$2a$10$lTu9qi0hr19OC800Db.eludFr0AXuJUSrMHi/iPYhKRlPFeqJxlye', '$2a$2a$10$lTu9qi0hr19OC800Db.eludFr0AXuJUSrMHi/iPYhKRlPFeqJxlye', '2019-12-23', '2019-12-23 10:46:07', '', '0', '0', 'Mbin', '15955311246', 'https://i.loli.net/2019/12/23/XqTt8IpMnZ9fGQj.jpg', '', '1', '', null, null, '55', '5', '北京 大兴', '软微', '0');
