package com.pkuhjw.pkukaola.web;

import com.pkuhjw.pkukaola.domain.Comment;
import com.pkuhjw.pkukaola.domain.Mission;
import com.pkuhjw.pkukaola.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WxMissionController {
    @Autowired
    private MissionService missionService;


    @RequestMapping(value = "/mission/getAllMission")
    @ResponseBody
    public List<Mission> findAllMission(){
        return missionService.findAllMission();
    }

    @RequestMapping(value = "/mission/getMission")
    @ResponseBody
    public Mission findMission(@RequestParam(value = "missionid") int   missionid){
        System.out.println(missionid);
        return missionService.getmission(missionid);
    }
    /* 添加任务 */
    @RequestMapping(value="/mission/addmissison")
    public String addMission(
            @RequestParam (value = "missionname") String missionname,
            @RequestParam (value = "discribe") String discribe,
            @RequestParam (value = "missionclass") String missionclass,
            @RequestParam (value = "publisherid") int publisherid,
            @RequestParam (value = "publisher") String publisher,
            @RequestParam (value = "price") float price,
            @RequestParam (value = "image_list") String image_list,
            @RequestParam (value = "publisher_location") String publisher_location
    ){
        System.out.println(missionname);
        return missionService.addMission(missionname,discribe,missionclass,publisherid,publisher,price, image_list,publisher_location);
    }
    /* 评论 */
    @RequestMapping(value = "/comment/getcomment")
    @ResponseBody
    public List<Comment> getComment(@RequestParam(value = "missionid") int missionid){
        return missionService.getComment(missionid);
    }
    /* 添加评论 */
    @RequestMapping(value = "/comment/addComment")
    public String addComment(
            @RequestParam (value = "missionid") int missionid,
            @RequestParam (value = "userid") int userid,
            @RequestParam (value = "content") String content
    ){
        System.out.println(missionid);
        return missionService.addComment(missionid,userid,content);
    }
    /* 添加商品 */
    @RequestMapping(value="/goods/addgood")
    public String addGoods(
            @RequestParam (value = "address") String address,
            @RequestParam (value = "price") float good_price,
            @RequestParam (value = "title") String title,
            @RequestParam (value = "describe") String desc,
            @RequestParam (value = "category_id") int category_id,
            @RequestParam (value = "publish_user_id") int publisher_id
    ){
        System.out.println(good_price);
        return missionService.addGoods(address,good_price,title,desc,category_id,publisher_id);
    }

}
