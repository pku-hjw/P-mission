package com.test.dbtest.entity;



import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TotalData {
    private  Object goods;
    private  Object user_vo;

    public TotalData(Object goods, Object user_vo) {
        this.goods = goods;
        this.user_vo = user_vo;
    }

    // query goods 的返回
    public static Object totalGoodsData(Object goods){
        Map<String,Object> obj = new HashMap<>();
        obj.put("more", 1);
        obj.put("next_start", 24);
        obj.put("object_list",goods);
        return obj;
    }

}
