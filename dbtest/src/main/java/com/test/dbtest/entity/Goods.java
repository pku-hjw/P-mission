package com.test.dbtest.entity;

import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.*;


@Getter
@Setter
public class Goods {
    private int id;
    private int publish_user_id;
    private String title;
    private String describe;
    private String publish_address;
    private double price;
//    private String detail;
    private Timestamp publish_date;
    private int look_count;
    private Cover cover;
    private List<Cover> photos;
    public int comment_count;

    public Goods(int id, int publish_user_id, String title, String describe, String publish_address, double price, Timestamp publish_date, int look_count, int image_id,
                  String path,int comment_count) {
        this.id = id;
        this.publish_user_id = publish_user_id;
        this.title = title;
        this.describe = describe;
        this.publish_address = publish_address;
        this.price = price;
        this.publish_date = publish_date;
        this.look_count = look_count;
        this.comment_count = comment_count;
        this.cover = new Cover(id,image_id,path);
        this.photos=new ArrayList<>();photos.add(this.cover);//调用它自己就好了!初始化也是调用自己
    }


    public String getPublish_date() {
        return publish_date.toString().substring(0,10);
    }

//    public static Object setCover(Cover images){
//        Map<String,Object> cover = new HashMap<>();
//        cover.put("cover",images);
//        return cover;}
}
