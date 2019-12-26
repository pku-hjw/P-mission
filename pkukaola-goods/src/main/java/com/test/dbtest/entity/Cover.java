package com.test.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cover {
    private int id;
    private int image_id;
    private  String path;
}
