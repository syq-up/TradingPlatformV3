package com.shiyq.pojo;

public class UserAddr {

    private Integer addrId;
    private Integer userId;
    private String province;
    private String city;
    private String county;
    private String detail;
    private Integer isHome = 0;

    public UserAddr() {
    }

    public UserAddr(Integer addrId, Integer userId, String province, String city, String county, String detail) {
        this.addrId = addrId;
        this.userId = userId;
        this.province = province;
        this.city = city;
        this.county = county;
        this.detail = detail;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getIsHome() {
        return isHome;
    }

    public void setIsHome(Integer isHome) {
        this.isHome = isHome;
    }
}
