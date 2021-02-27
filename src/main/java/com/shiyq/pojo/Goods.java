package com.shiyq.pojo;

import java.util.Date;

public class Goods {
    private Integer goodsId;
    private UserDetail userDetail;
    private String goodsImg;
    private String goodsName;
    private double newPrice;
    private double oldPrice;
    private String quality;
    private String tradeWay;
    private String goodsDetail;
    private String sort;
    private Date lastEditTime = new Date();
    private int State;

    public Goods() {
    }

    public Goods(Integer goodsId, UserDetail userDetail, String goodsImg, String goodsName, double newPrice, double oldPrice, String quality, String tradeWay, String goodsDetail, String sort, Date lastEditTime, int state) {
        this.goodsId = goodsId;
        this.userDetail = userDetail;
        this.goodsImg = goodsImg;
        this.goodsName = goodsName;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.quality = quality;
        this.tradeWay = tradeWay;
        this.goodsDetail = goodsDetail;
        this.sort = sort;
        this.lastEditTime = lastEditTime;
        State = state;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getTradeWay() {
        return tradeWay;
    }

    public void setTradeWay(String tradeWay) {
        this.tradeWay = tradeWay;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
