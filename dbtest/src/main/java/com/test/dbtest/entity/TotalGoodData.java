package com.test.dbtest.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class TotalGoodData extends Goods {
    private  User_vo user_vo;
    public TotalGoodData(int id, int publish_user_id, String title, String describe, String publish_address, double price,
                         Timestamp publish_date, int look_count, int image_id, String path, int comment_count, String telephone,
                         String school, int publish_count, int user_look_count, String nickname, int gender, String avatar, String address) {
        super(id, publish_user_id, title, describe, publish_address, price, publish_date, look_count, image_id, path,comment_count);

        this.user_vo = new User_vo( telephone ,school,  publish_count,  user_look_count, id,nickname, gender, avatar, address);
    }
}
