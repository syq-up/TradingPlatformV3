package com.shiyq.handler;

import com.shiyq.pojo.User;
import com.shiyq.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author shiyq
 * @create 2021-02-25 18:05
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;
    private HttpSession session;

    @Autowired
    public void setUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.userDetailsService = customUserDetailsService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取输入的用户名
        String username = authentication.getName();
        //获取输入的明文
        String password = (String) authentication.getCredentials();

        //查询用户是否存在
        User user = (User) userDetailsService.loadUserByUsername(username);

        if (!user.isEnabled()) {
            throw new DisabledException("该账户已被禁用，请联系管理员");

        } else if (!user.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定");

        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期，请联系管理员");

        } else if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("该账户的登录凭证已过期，请重新登录");
        }

        //验证密码
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("输入密码错误!");
        }
        user.setDaysAfterReg((int) (new Date().getTime() - user.getUserReg().getTime())/1000/3600/24 + 1);
        session.setAttribute("user", user);
        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
