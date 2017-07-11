package com.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Movie on 2017/7/10.
 */
//@RestController
@RequestMapping("exception")
@Controller
public class TestController {
    @RequestMapping("/test")
    public String testExcetionHandler() throws Exception {
        throw new Exception("test什么贵呀");
    }

//    @ExceptionHandler(value = {Exception.class})
//    public String handleExp() {
//        return "出异常了";
//    }

}
