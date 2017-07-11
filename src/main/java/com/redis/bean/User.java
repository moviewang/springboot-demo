package com.redis.bean;

import java.io.Serializable;

/**
 * Created by Movie on 2017/7/7.
 */
public class User implements Serializable {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
