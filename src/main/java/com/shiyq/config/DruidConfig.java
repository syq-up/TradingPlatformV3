package com.shiyq.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyq
 * @create 2021-02-24 13:16
 */
@Configuration
public class DruidConfig {

    // 后台监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 后台登录 账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");

        // 允许谁访问，""空，则任何人都可以访问
        initParameters.put("allow", "");

        // 禁止谁访问
        //initParameters.put("s","192.168.11.111");

        bean.setInitParameters(initParameters);
        return bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean web(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        // 过滤
        Map<String, String> initParameter = new HashMap<>();
        initParameter.put("exclusions", "*.js, *.css, /druid/*");

        bean.setInitParameters(initParameter);
        return bean;
    }

}
