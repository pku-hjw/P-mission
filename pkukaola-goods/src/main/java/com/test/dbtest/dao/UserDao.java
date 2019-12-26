package com.test.dbtest.dao;

import com.test.dbtest.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("SELECT  pkukaola_goods.id,\n" +
            "        pkukaola_goods.publish_user_id,\n" +
            "        pkukaola_goods.title,\n" +
            "        pkukaola_goods.describe,\n" +
            "        pkukaola_goods.publish_address,\n" +
            "        pkukaola_goods.price,\n" +
            "        pkukaola_goods.publish_date,\n" +
            "        pkukaola_goods.look_count,\n" +
            "        pkukaola_images.image_id,\n" +
            "        pkukaola_images.path,\n" +
            "        pkukaola_goods.comment_count\n" +
            "FROM pkukaola_images,pkukaola_goods\n" +
            "WHERE pkukaola_goods.id=pkukaola_images.id")
    List<Goods> queryGoods();

    @Select("SELECT mobile,school,publish_count,look_count,id,nickname,gender,avatar,address from pkukaola_user where pkukaola_user.id = #{goods_id}")
    List<User_vo> getUserDetails(@Param("goods_id") Integer id);

    @Select("SELECT pkukaola_goods.id,\n" +
            "        pkukaola_goods.publish_user_id,\n" +
            "        pkukaola_goods.title,\n" +
            "        pkukaola_goods.describe,\n" +
            "        pkukaola_goods.publish_address,\n" +
            "        pkukaola_goods.price,\n" +
            "        pkukaola_goods.publish_date,\n" +
            "        pkukaola_goods.look_count,\n" +
            "        pkukaola_images.image_id,\n" +
            "        pkukaola_images.path,\n" +
            "        pkukaola_goods.comment_count,\n" +
            "        pkukaola_user.mobile,\n" +
            "        pkukaola_user.school,\n" +
            "        pkukaola_user.publish_count,\n" +
            "        pkukaola_user.look_count as user_look_count,\n" +
            "        pkukaola_user.nickname,\n" +
            "        pkukaola_user.gender,\n" +
            "        pkukaola_user.avatar,\n" +
            "        pkukaola_user.address\n" +
            "FROM pkukaola_images,pkukaola_goods,pkukaola_user\n" +
            "WHERE pkukaola_goods.id=pkukaola_images.id and pkukaola_goods.publish_user_id=pkukaola_user.id and pkukaola_goods.id =#{param1}\n" +
            "\n")
    TotalGoodData getGoodsData(@Param("goods_id") Integer id);

}
