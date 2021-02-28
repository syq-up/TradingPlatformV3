package com.shiyq.pojo;

import java.util.Date;

public class UserDetail {
    private Integer detailId;
    private String nickname;
    private String realName;
    private String sex;
    private Date birthday;
    private String phone;
    private String email;
    private String headImg;
    private UserAddr curAddr;
    private Integer sellingCount;
    private Integer soldCount;
    private Integer collectCount;
    private Integer buyCount;


    public UserDetail() {
    }

    public UserDetail(String nickname) {
        this.nickname = nickname;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public UserAddr getCurAddr() {
        return curAddr;
    }

    public void setCurAddr(UserAddr curAddr) {
        this.curAddr = curAddr;
    }

    public Integer getSellingCount() {
        return sellingCount;
    }

    public void setSellingCount(Integer sellingCount) {
        this.sellingCount = sellingCount;
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }
}
