package com.test.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cover {
    private int id;
    private int image_id;
    private  String path;


//    public Cover(int id, int image_id, String path) {
//        this.id = id;
//        this.image_id = image_id;
//        this.path = path;
//    }
}
