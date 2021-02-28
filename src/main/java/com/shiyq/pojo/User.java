package com.shiyq.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements UserDetails {

    private Integer userId;
    private String userName;
    private String userPwd;
    private Date userReg;
    private UserDetail userDetail;

    // 计算一下总注册时间
    // 这样就不符合ORM思想了，应该改一改……
    private int daysAfterReg;

    public User() {
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userReg = new Date();
        this.userDetail = new UserDetail(userName);
    }

    public User(Integer userId, String userName, String userPwd, Date userReg, UserDetail userDetail) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userReg = userReg;
        this.userDetail = userDetail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getUserReg() {
        return userReg;
    }

    public void setUserReg(Date userRegister) {
        this.userReg = userRegister;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public int getDaysAfterReg() {
        return daysAfterReg;
    }

    public void setDaysAfterReg(int daysAfterReg) {
        this.daysAfterReg = daysAfterReg;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPwd;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
