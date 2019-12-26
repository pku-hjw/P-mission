package com.test.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User_Base {
    private int id;
    private String nickname;
    private int gender;
    private String avatar;
    private String address;
}
