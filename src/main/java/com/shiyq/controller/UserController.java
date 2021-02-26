package com.shiyq.controller;

import com.shiyq.pojo.User;
import com.shiyq.pojo.UserAddr;
import com.shiyq.pojo.UserDetail;
import com.shiyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shiyq
 * @create 2021-02-08 9:35
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 进入首页
     */
    @RequestMapping
    public String toJsp(){
        return "redirect:/goods/all/recent/1";
    }

    /**
     * 进入登录页面
     * @return  返回注册页面
     */
    @GetMapping("/login")
    public String toLoginJsp(){
        return "login";
    }

    // TODO 这样写虽然能达到效果，但我想实现的是登录失败直接返回页面信息，比如说ajax请求，然后返回json
    @PostMapping("/toLogin")
    public String toLoginJsp2(HttpServletRequest request, Model model){
        model.addAttribute("msg",request.getAttribute("msg"));
        return "login";
    }

    /**
     * 进入注册页面
     * @return  返回注册页面
     */
    @GetMapping("/register")
    public String toRegisterJsp(){
        return "register";
    }

    @ResponseBody
    @PostMapping("/ajaxCheckUsername")
    public String ajaxForReg(String username){
        System.out.println(username);
        if (userService.findUserByUserName(username) != null)
            return "";
        return "ok";
    }

    /**
     * 用户注册
     * @param userName  用户名
     * @param userPwd   用户密码
     * @return  返回登录页面
     */
    @PostMapping("/register")
    public String userRegister(@RequestParam("username")String userName,
                               @RequestParam("pwd")String userPwd){
        userService.saveUser(new User(userName, userPwd));
        return "login";
    }

    /**
     * 查询用户详细信息
     * @param userId    用户id
     * @param model     写入传值
     * @return  返回
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/userInfo/{userId}")
    public String showUserInfo(@PathVariable int userId,
                               Model model){
        List<UserAddr> userAddrList = userService.findUserAddrById(userId);
        model.addAttribute("userAddrList",userAddrList);
        return "me-info";
    }

    /**
     * 更新用户详细信息
     * @param userDetail    新的用户信息
     * @return  返回
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/userUpdate")
    public String updateUserInfo(@ModelAttribute UserDetail userDetail,
                                 @RequestParam("file") CommonsMultipartFile file,
                                 HttpSession session,
                                 HttpServletRequest request){
        // 更新数据库
        userService.updateUserDetail(userDetail, file, request);
        // 更新session中的user对象
        User user = (User) session.getAttribute("user");
        user.setUserDetail(userService.findUserDetailById(userDetail.getDetailId()));
        session.setAttribute("user", user);
        // 返回
        return "redirect:/user/userInfo/"+userDetail.getDetailId();
    }

    /**
     * 进入用户详情修改页面
     * @return 返回
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/userModify")
    public String toModifyJsp(){
        return "me-info-modify";
    }
}
