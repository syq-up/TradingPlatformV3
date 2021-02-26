package com.shiyq.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shiyq
 * @create 2021-02-25 22:39
 */
//@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    HttpSession session;

    //@Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    // 写完才发现登出后会自动清除session。。。不需要自定义清除了
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        session.removeAttribute("user");
        response.sendRedirect("/goods/all/recent/1");
    }
}
