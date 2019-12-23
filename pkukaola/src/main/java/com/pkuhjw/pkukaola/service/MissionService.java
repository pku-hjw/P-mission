package com.pkuhjw.pkukaola.service;


import com.pkuhjw.pkukaola.dao.MissionMapper;
import com.pkuhjw.pkukaola.domain.Comment;
import com.pkuhjw.pkukaola.domain.Goods;
import com.pkuhjw.pkukaola.domain.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    private int tempmissionid=0;
    private int tempcommentid=0;
    private int tempGoodsid=0;
    int test = 70;

    @Autowired
    private MissionMapper missionMapper;


    public List<Mission> findAllMission(){
        return missionMapper.findAllMission();
    }
    public Mission getmission(int missionid){
        return missionMapper.getMission(missionid);
    }

    public List<Comment> getComment(int missionid){return missionMapper.getMissionComment(missionid);}
    public String addMission(String missionname,
                             String discribe,
                             String missionclass,
                             int publisherid,
                             String publisher,
                             float price,
                             String image_list,
                             String publisher_location
    ){
        tempmissionid=test;
        tempmissionid++;
        try{
            System.out.println(tempmissionid);
            Mission mission = new Mission(tempmissionid, missionname,discribe,missionclass,publisherid,publisher,price, image_list,publisher_location);
            System.out.println(mission.toString());
            missionMapper.addMission(mission);
            System.out.println("添加成功");
            return "添加成功";
        } catch (Exception e) {
            return "添加失败";
        }
    }
    public String addComment(int missionid,int userid,String content
    ){
        tempcommentid=test;
        tempcommentid++;
        System.out.println(tempcommentid);
        Comment comment = new Comment(tempcommentid,content,missionid,userid);
        System.out.println(comment.toString());
        missionMapper.addComment(comment);
        System.out.println("添加成功");
        return "添加成功";
    }
    public String addGoods(String address,float price,String title,String desc,int category_id,int publish_user_id ){
        tempGoodsid=test;
        tempGoodsid++;
        System.out.println(tempGoodsid);
        Goods good  = new Goods(tempGoodsid,address,price,title,desc,category_id,publish_user_id);
        System.out.println(good.toString());
        missionMapper.addGoods(good);
        System.out.println("添加成功");
        return "添加成功";
    }
}
