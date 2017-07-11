package com.redis.controller;

import com.redis.exception.MyExcetion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Movie on 2017/7/10.
 */
//@RestController
@RequestMapping("")
@Controller
public class TestController {
    @RequestMapping("/exception")
    public String testExcetionHandler() throws Exception {
        throw new Exception("test什么贵呀");
    }

    @RequestMapping("/restexception")
    public String testRestExcetionHandler() throws MyExcetion {
        throw new MyExcetion("rest exception");
    }

//    @ExceptionHandler(value = {Exception.class})
//    public String handleExp() {
//        return "出异常了";
//    }

}
