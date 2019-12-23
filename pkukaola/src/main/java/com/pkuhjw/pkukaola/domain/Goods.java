package com.pkuhjw.pkukaola.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {
    private int goods_id;
    private int lookCount;
    private String address;
    private float price;
    private String title;
    private String desc;
    private String publish_date;
    private int category_id;
    private int publish_user_id;

    public Goods() {
    }

    public Goods(int goods_id, String address, float price, String title, String desc, int category_id, int publish_user_id) {
        this.goods_id = goods_id;
        this.lookCount = 0;
        this.address = address;
        this.price = price;
        this.title = title;
        this.desc = desc;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = dateFormat.format(date);
        this.publish_date = formatDate;
        this.category_id = category_id;
        this.publish_user_id = publish_user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getLookCount() {
        return lookCount;
    }

    public void setLookCount(int lookCount) {
        this.lookCount = lookCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPublish_user_id() {
        return publish_user_id;
    }

    public void setPublish_user_id(int publish_user_id) {
        this.publish_user_id = publish_user_id;
    }
}

