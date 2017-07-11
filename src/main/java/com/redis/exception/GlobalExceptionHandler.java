package com.redis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Movie on 2017/7/10.
 */
//@RestControllerAdvice
    @ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }
//    @ExceptionHandler(value = Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e);
//        modelAndView.addObject("url", request.getRequestURI());
//        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
//        return "全局异常，出错了！";
//    }

}
