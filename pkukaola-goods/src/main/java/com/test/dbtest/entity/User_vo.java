package com.test.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User_vo {
    private String telephone;
    private String school;
    private int publish_count;
    private int look_count;
    private User_Base user_base;

    public User_vo(String telephone, String school, int publish_count, int look_count,int id,String nickname, int gender, String avatar,String address) {
        this.telephone = telephone;
        this.school = school;
        this.publish_count = publish_count;
        this.look_count = look_count;
        this.user_base = new User_Base(id,nickname,gender,avatar,address);
    }

}
