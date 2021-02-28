package com.shiyq.service;

import com.shiyq.mapper.UserMapper;
import com.shiyq.pojo.User;
import com.shiyq.pojo.UserAddr;
import com.shiyq.pojo.UserDetail;
import com.shiyq.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.List;

/**
 * @author shiyq
 * @create 2021-02-08 21:09
 */
@Service
public class UserService {

    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 查找用户对象
     * @param userName  用户名
     * @return 用户对象
     */
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    /**
     * 查找用户对象
     * @param userId 用户id
     */
    public void findUserByUserId(Integer userId) {
        userMapper.findUserByUserId(userId);
    }

    /**
     * 注册用户
     * @param user  用户对象
     */
    public void saveUser(User user){
        userMapper.saveUserDetail(user.getUserDetail());
        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
        userMapper.saveUser(user);
    }

    /**
     * 查找用户详情对象
     * @param user_detail   用户id
     * @return  用户详情对象
     */
    public UserDetail findUserDetailById(Integer user_detail){
        return userMapper.findUserDetailById(user_detail);
    }

    /**
     * 查询用户收货地址
     * @param id    用户id
     * @return  返回地址集合
     */
    public List<UserAddr> findUserAddrById(Integer id) {
        return userMapper.findUserAddrById(id);
    }

    /**
     * 更新用户详细信息
     * @param userDetail  用户id
     */
    public void updateUserDetail(UserDetail userDetail, CommonsMultipartFile file) {

        // 更新用户头像
        if (file != null) {
            String headImgPath = UploadFile.uploadFile(file);
            // 如果用户原头像为默认头像，则跳过，否则删除上一个头像
            if (!"user-default-headImage.jpg".equals(userDetail.getHeadImg())){
                new File(headImgPath).delete();
            }
            userDetail.setHeadImg(headImgPath);
        }

        userMapper.updateUserDetailById(userDetail);
    }

}
