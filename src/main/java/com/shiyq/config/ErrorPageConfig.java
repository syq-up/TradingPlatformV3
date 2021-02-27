package com.shiyq.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author shiyq
 * @create 2021-02-26 15:22
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST,"/error/400");
        ErrorPage errorPage401 = new ErrorPage(HttpStatus.UNAUTHORIZED,"/error/401");
        ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN,"/error/403");
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND,"/error/404");
        ErrorPage errorPage415 = new ErrorPage(HttpStatus.UNSUPPORTED_MEDIA_TYPE,"/error/415");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500");
        registry.addErrorPages(errorPage400,errorPage401,errorPage403,errorPage404,errorPage415,errorPage500);
    }
}
