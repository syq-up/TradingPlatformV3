package com.shiyq.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shiyq
 * @create 2021-02-25 16:28
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    //private ObjectMapper objectMapper;
    //@Autowired
    //public void setObjectMapper(ObjectMapper objectMapper) {
    //    this.objectMapper = objectMapper;
    //}

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //response.setContentType("application/json;charset=utf-8");
        //response.getWriter().write(objectMapper.writeValueAsString(authentication));
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null)
            redirectStrategy.sendRedirect(request, response, "/");
        else
            redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
    }
}
