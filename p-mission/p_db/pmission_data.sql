use pkukaola;
--
-- Dumping data for table `pkukaola_category`
--

LOCK TABLES `pkukaola_category` WRITE;
INSERT INTO `pkukaola_category` VALUES (2,50,'其他');
UNLOCK TABLES;

--
-- Dumping data for table `pkukaola_goods`
--

LOCK TABLES `pkukaola_goods` WRITE;
INSERT IGNORE INTO `pkukaola_goods` VALUES (50,57,'卫龙 八成新','转让半包辣条，卫龙的，8月初才买的，吃了3条，里面还有23条，还有很多辣油，不舍的吃的时候就拿出来闻一闻，平常吃完都是用订书机订起来的，防止受潮。外表大概8成新吧。量很足，厚度约2cm，高度8cm，包行货，假一罚十，真的很好吃，平时小半条就可以回味半天...','北京 大兴',2.00,now(),55);
UNLOCK TABLES;

--
-- Dumping data for table `pkukaola_images`
--

LOCK TABLES `pkukaola_images` WRITE;
INSERT IGNORE INTO `pkukaola_images` VALUES (76,50,'http://ayy.ganzhiqiang.wang/tmp_cee2781691b5b924ef1e0423f8b37d899debfc3f4ae94214.jpg');
UNLOCK TABLES;

--
-- Dumping data for table `pkukaola_users`
--
    
LOCK TABLES `pkukaola_users` WRITE;
INSERT INTO `pkukaola_users` VALUES (57,'艺辉','123',1,'Mbin','15955311246','https://www.woyaogexing.com/touxiang/nan/2019/901513.html','istarwyh',33,5,'北京 大兴','软微学院');
UNLOCK TABLES;