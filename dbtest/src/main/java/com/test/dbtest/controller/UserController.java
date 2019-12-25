package com.test.dbtest.controller;

import com.test.dbtest.entity.*;
import com.test.dbtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/goods")
    @ResponseBody
    public Object goods(){
        List<Goods> goods = userService.queryGoods();
        if (goods == null) { return TotalMessage.returnErrors( "啊哦,還沒有商品"); }
        return TotalMessage.totalGoods(TotalData.totalGoodsData(goods));
    }

    @GetMapping(value = "/goods/details")
    @ResponseBody
    public Object detail(@RequestParam(value = "goods_id", required = false) Integer goods_id) {
        if (goods_id == null) { return TotalMessage.returnErrors("缺少必要参数"); }
        TotalGoodData goodsdata = userService.getGoodsData(goods_id);
        if (goodsdata == null) { return TotalMessage.returnErrors( "非法参数:找不到相關數據"); }
        return  TotalMessage.totalGoodsDetails(goodsdata);
    }

    @RequestMapping(value = "/test")
    public  String test(){
        return "test";
    }
}
