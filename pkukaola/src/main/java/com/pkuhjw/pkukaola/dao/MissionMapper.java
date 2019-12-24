package com.pkuhjw.pkukaola.dao;

import com.pkuhjw.pkukaola.domain.Comment;
import com.pkuhjw.pkukaola.domain.Goods;
import com.pkuhjw.pkukaola.domain.Mission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MissionMapper {
    public String test = "test";

    @Select("SELECT * FROM pkukaola_mission")
    public List<Mission> findAllMission();

    @Select("SELECT * FROM pkukaola_mission WHERE mission=#{id}")
    public Mission getMission(@Param("id") int missionid);

    /* 查找某个mission的评论 */
    @Select("SELECT * FROM pkukaola_comment WHERE MISSIONID=#{id}")
    public List<Comment> getMissionComment(@Param("id") int missionid);


    @Insert("INSERT INTO pkukaola_mission VALUES (#{missionid}, #{missionname}, #{discrible},#{missionclass}, #{publisherid}, #{publisher},#{lookcount}, #{commentcount}, #{price}, #{image_list}, #{publisher_location});")
    public void addMission(Mission mission);

    /* 插入一个comment */
    @Insert("INSERT INTO pkukaola_comment VALUES (#{userid}, #{commentid}, #{content},#{missionid},#{date})")
    public void addComment(Comment comment);

    /* 插入一个商品 */
    @Insert("INSERT INTO pkukaola_goods VALUES (#{id}, #{look_count}, #{pubulish_address},#{price},#{title},#{describe},#{publish_date},#{category_id} ,#{publish_user_id}")
    public void addGoods(Goods good);

}