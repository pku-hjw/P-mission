
use pkukaola;
/* 字段的AUTO_INCREMENT属性告诉MySQL自动增加id字段下一个可用编号。 */
DROP TABLE IF EXISTS `pkukaola_category`;
CREATE TABLE `pkukaola_category` (
  `category_id` int(11) NOT NULL,
  `id` int(11) DEFAULT '0' COMMENT'商品编号',
  `category_name` varchar(63) NOT NULL DEFAULT '' COMMENT '类目名称',
  PRIMARY KEY (`category_id`)
  /* FOREIGN KEY (`id`) REFERENCES `pkukaola_goods` (`id`) */
);


DROP TABLE IF EXISTS `pkukaola_goods`;
CREATE TABLE `pkukaola_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publish_user_id` int(11) DEFAULT '0' COMMENT '谁发布了商品',
  `title` varchar(127) NOT NULL DEFAULT '' COMMENT '商品名称',
  `describe` text  COMMENT '商品简介,是富文本格式',
  `publish_address` varchar(255) DEFAULT '' COMMENT '发布地址',
  `price` decimal(10,2) DEFAULT '1.00' COMMENT '零售价格',
  -- `detail` text COMMENT '商品详细介绍，是富文本格式',
  `publish_date` date NOT NULL COMMENT '创建时间',
  `look_count` int(11) DEFAULT '0' COMMENT '浏览人数',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论次数',
  PRIMARY KEY (`id`)
  /* FOREIGN KEY (`category_id`) REFERENCES `pkukaola_category` (`category_id`) */
);

-- {"id":50,"publish_user_id":57,"title":"卫龙 八成新","descible":"转让半包辣条，卫龙的，8月初才买的，吃了3条，里面还有23条，还有很多辣油，不舍的吃的时候就拿出来闻一闻，平常吃完都是用订书机订起来的，防止受潮。外表大概8成新吧。量很足，厚度约2cm，高度8cm，包行货，假一罚十，真的很好吃，平时小半条就可以回味半天... ","cover":{"id":76,"path":"http://ayy.ganzhiqiang.wang/tmp_cee2781691b5b924ef1e0423f8b37d899debfc3f4ae94214.jpg"},"price":"2.0","publish_address":"北京 大兴","publish_date":"2018年4月11日 22:29","look_count":97}

--
-- Table structure for table `pkukaola_image`
--

DROP TABLE IF EXISTS `pkukaola_images`;
CREATE TABLE `pkukaola_images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `path` varchar(255) NOT NULL  COMMENT '商品图片或者商品货品图片',
  PRIMARY KEY (`image_id`),
  KEY `pkukaola_images` (`id`)
);


DROP TABLE IF EXISTS `pkukaola_users`;
CREATE TABLE `pkukaola_users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `username` varchar(63) NOT NULL COMMENT '用户名称',
  `password` varchar(63) NOT NULL DEFAULT '' COMMENT '用户密码',
  `gender` tinyint(3) NOT NULL DEFAULT '0' COMMENT '性别：0 未知， 1男， 1 女',
  `nickname` varchar(63) NOT NULL DEFAULT '' COMMENT '用户昵称或网络名称',
  `telephone` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号码',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像图片',
  `weixin_openid` varchar(63) NOT NULL DEFAULT '' COMMENT '微信登录openid',
  `look_count` int(11) DEFAULT '0' COMMENT '浏览次数',
  `publish_count` int(11) DEFAULT '0' COMMENT '发布次数',
  `address` varchar(255) DEFAULT '' COMMENT '地址',
  `school` varchar(255) DEFAULT '' COMMENT '学校',
  PRIMARY KEY (`user_id`)
);