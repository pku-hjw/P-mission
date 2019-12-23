package com.pkuhjw.pkukaola.domain;

public class Mission {
    private int missionid;
    private String missionname="";
    private String discrible="";
    private String missionclass="";
    private int publisherid;
    private String publisher="";
    private int lookcount;
    private int commentcount;
    private float price=0;
    private String image_list="";
    private String publisher_location="";


    @Override
    public String toString() {
        return "Mission{" +
                "missionid=" + missionid +
                ", missionname='" + missionname + '\'' +
                ", discrible='" + discrible + '\'' +
                ", missionclass='" + missionclass + '\'' +
                ", publisherid=" + publisherid +
                ", publisher='" + publisher + '\'' +
                ", lookcount=" + lookcount +
                ", commentcount=" + commentcount +
                ", price=" + price +
                ", image_list='" + image_list + '\'' +
                ", publisher_location='" + publisher_location + '\'' +
                '}';
    }

    public Mission(int missionid, String missionname, String discrible, String missionclass, int publisherid, String publisher, float price, String image_list, String publisher_location) {
        this.missionid = missionid;
        this.missionname = missionname;
        this.discrible = discrible;
        this.missionclass = missionclass;
        this.publisherid = publisherid;
        this.publisher = publisher;
        this.lookcount = 0;
        this.commentcount = 0;
        this.price = price;
        this.image_list = image_list;
        this.publisher_location = publisher_location;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage_list() {
        return image_list;
    }

    public void setImage_list(String image_list) {
        this.image_list = image_list;
    }

    public String getPublisher_location() {
        return publisher_location;
    }

    public void setPublisher_location(String publisher_location) {
        this.publisher_location = publisher_location;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getLookcount() {
        return lookcount;
    }

    public void setLookcount(int lookcount) {
        this.lookcount = lookcount;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public String getMissionname() {
        return missionname;
    }

    public void setMissionname(String missionname) {
        this.missionname = missionname;
    }

    public String getDiscrible() {
        return discrible;
    }

    public void setDiscrible(String discrible) {
        this.discrible = discrible;
    }

    public String getMissionclass() {
        return missionclass;
    }

    public void setMissionclass(String missionclass) {
        this.missionclass = missionclass;
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }
    public void addview(){
        lookcount++;
    }
    public void addcommnet(){
        commentcount++;
    }

}
