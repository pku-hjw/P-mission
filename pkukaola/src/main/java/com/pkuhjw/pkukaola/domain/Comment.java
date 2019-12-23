package com.pkuhjw.pkukaola.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
    private int commentid;
    private String content;
    private int missionid;
    private int userid;
    private String date;

    public Comment() {
    }

    public Comment(int commentid, String content, int missionid, int userid) {
        this.commentid = commentid;
        this.content = content;
        this.missionid = missionid;
        this.userid = userid;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = dateFormat.format(date);
//        formatDate="06-05";
        this.date = formatDate;
    }


    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", content='" + content + '\'' +
                ", missionid=" + missionid +
                ", userid=" + userid +
                ", date='" + date + '\'' +
                '}';
    }
}
