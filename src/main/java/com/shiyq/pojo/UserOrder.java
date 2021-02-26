package com.shiyq.pojo;

import java.util.Date;

public class UserOrder {
    private Integer orderId;
    private Integer userId;
    private Goods goods;
    private Date datetime;

    public UserOrder() {
    }

    public UserOrder(Integer orderId, Integer userId, Goods goods, Date datetime) {
        this.orderId = orderId;
        this.userId = userId;
        this.goods = goods;
        this.datetime = datetime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
