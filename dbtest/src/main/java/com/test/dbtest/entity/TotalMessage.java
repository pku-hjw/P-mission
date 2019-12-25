package com.test.dbtest.entity;

import java.util.HashMap;
import java.util.Map;

public class TotalMessage {

    public static  Object returnErrors(Object errorMessage){
        Map<String,Object> obj = new HashMap<>();
        obj.put("status", 0);
        obj.put("Error", errorMessage);
        return  obj;
    }
    public static Object totalGoods(Object data){
        Map<String,Object> obj = new HashMap<>();
        obj.put("status", 1);
        obj.put("message", "success");
        obj.put("data",data);
        return obj;
    }
    public static Object totalGoodsDetails(Object goods,Object user_vo){
        Map<String,Object> obj = new HashMap<>();
        obj.put("status", 1);
        obj.put("message", "success");
        TotalData data = new TotalData(user_vo,goods);
        obj.put("data",data);
        return obj;
    }

    public static Object totalGoodsDetails(Object data){
        Map<String,Object> obj = new HashMap<>();
        obj.put("status", 1);
        obj.put("message", "success");
        obj.put("data",data);
        return obj;
    }


}
