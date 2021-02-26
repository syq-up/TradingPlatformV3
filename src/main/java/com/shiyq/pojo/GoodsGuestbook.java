package com.shiyq.pojo;

import java.util.Date;

public class GoodsGuestbook {
    private Integer msgId;
    private int goodsId;
    private int userId;
    private String userNickname;
    private String userImg;
    private String message;
    private Date datetime;

    public GoodsGuestbook() {
    }

    public GoodsGuestbook(Integer msgId, int goodsId, int userId, String userNickname, String userImg, String message, Date datetime) {
        this.msgId = msgId;
        this.goodsId = goodsId;
        this.userId = userId;
        this.userNickname = userNickname;
        this.userImg = userImg;
        this.message = message;
        this.datetime = datetime;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
