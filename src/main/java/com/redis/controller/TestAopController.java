package com.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Movie on 2017/7/12.
 */
@RestController
@RequestMapping("")
public class TestAopController {
    @RequestMapping("/hello")
    public String test(String name) {
        return "hello" + name;
    }
}
