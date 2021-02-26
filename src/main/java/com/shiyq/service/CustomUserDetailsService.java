package com.shiyq.service;

import com.shiyq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author shiyq
 * @create 2021-02-24 21:02
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过用户名从数据库获取用户
        User user = userService.findUserByUserName(username);

        if (user == null) throw new UsernameNotFoundException("用户不存在");

        return user;
    }

}
