package com.shiyq.mapper;

import com.shiyq.pojo.User;
import com.shiyq.pojo.UserAddr;
import com.shiyq.pojo.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查找用户对象
     * @param userName：用户名
     * @return 用户对象
     */
    User findUserByUserName(String userName);

    /**
     * 查找用户对象
     * @param userId 用户id
     */
    void findUserByUserId(Integer userId);

    /**
     * 注册用户，添加User对象到数据库
     * @param user  用户对象
     */
    void saveUser(User user);

    /**
     * 注册用户，添加UserDetail对象到数据库
     * @param userDetail：只有属性nickname有值，添加到数据库后会将主键返回到该实体中
     */
    void saveUserDetail(UserDetail userDetail);

    /**
     * 查找用户详情对象
     * @param user_detail   用户id
     * @return  用户详情对象
     */
    UserDetail findUserDetailById(Integer user_detail);

    /**
     * 查询用户收货地址
     * @param userId    用户id
     * @return  返回地址集合
     */
    List<UserAddr> findUserAddrById(Integer userId);

    /**
     * 更新用户详细信息
     * @param userDetail  用户详情对象
     */
    void updateUserDetailById(UserDetail userDetail);

}
