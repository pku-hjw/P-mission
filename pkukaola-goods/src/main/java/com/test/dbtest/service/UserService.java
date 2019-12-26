package com.test.dbtest.service;


import com.test.dbtest.dao.UserDao;
import com.test.dbtest.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<Goods> queryGoods(){ return  userDao.queryGoods();}
    public List<User_vo> getUserDetails(Integer id){return  userDao.getUserDetails(id);}
    public TotalGoodData getGoodsData(Integer id){return  userDao.getGoodsData(id);}
}
