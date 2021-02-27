package com.shiyq.config;

import com.shiyq.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @author shiyq
 * @create 2021-02-24 20:35
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private PersistentTokenRepository persistentTokenRepository;
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    private AuthenticationFailureHandler authenticationFailureHandler;
    private AuthenticationProvider authenticationProvider;
    //private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public void setUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.userDetailsService = customUserDetailsService;
    }

    @Autowired
    public void setPersistentTokenRepository(PersistentTokenRepository persistentTokenRepository) {
        this.persistentTokenRepository = persistentTokenRepository;
    }

    @Autowired
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Autowired
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Autowired
    public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    //@Autowired
    //public void setLogoutSuccessHandler(LogoutSuccessHandler logoutSuccessHandler) {
    //    this.logoutSuccessHandler = logoutSuccessHandler;
    //}

    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 授权
        http
                .authorizeRequests()
                .antMatchers("/", "/favicon.ico", "/css/**", "/images/**", "/upload/**",
                        "/user/login", "/user/toLogin", "/user/ajaxCheckUsername", "/user/register",
                        "/goods/all/**").permitAll()
                .anyRequest().hasAuthority("user")  // 其它路径都需要验证

                .and()
                .formLogin()                                    // 登录认证
                .loginPage("/user/login")                       // 自定义前端登录页面
                .loginProcessingUrl("/user/login")              // 处理登录请求的映射地址
                .successHandler(authenticationSuccessHandler)   // 自定义认证成功处理
                .failureHandler(authenticationFailureHandler)   // 自定义认证失败处理
                .usernameParameter("username")                  // 前端表单name属性值
                .passwordParameter("pwd")                       // 前端表单name属性值
                .permitAll()                                    //

                // TODO 待实现自定义RememberMe功能
                .and()
                .rememberMe()                               // 开启自动登录功能
                .rememberMeParameter("remember-me")         // 前端表单name属性值
                .tokenRepository(persistentTokenRepository) // 向数据库添加需要的验证信息
                .tokenValiditySeconds(864000)               // cookie保存时长，10天
                .userDetailsService(userDetailsService)     //

                .and()
                .logout()                                   // 开启登出功能
                .logoutUrl("/user/logout")                  // 处理登出请求的映射地址
                .logoutSuccessUrl("/")                      // 登出后返回首页
                //.logoutSuccessHandler(logoutSuccessHandler) // 自定义登出后处理
                //.permitAll()

                //.and()
                //.exceptionHandling().accessDeniedPage("/error/403.html")
                .and()
                .csrf().disable()
        ;
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
