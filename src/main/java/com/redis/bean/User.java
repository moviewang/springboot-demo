package com.redis.bean;

import java.io.Serializable;

/**
 * Created by Movie on 2017/7/7.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 565251291403346383L;

    private String username;
    private int age;




    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    private static String testReturn() throws Exception {
        try {
            int a = 1 / 0;
            return "0";
        } catch (Exception e) {
            throw new Exception("divide by 0");
        }
    }


    public static String test1() {
        String s = "null";
        try {
            System.out.println(testReturn());
            s = testReturn();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return s;
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        int star = 4 / 2;
        for (int i = 0; i < star; i++) {
            stringBuilder.append("[星]");
        }

        for (int i = 0; i < 5 - star; i++) {
            stringBuilder.append("[空星]");
        }
        System.out.println(stringBuilder.toString());

        String start_time = "2018-01-16 00：00：1";
        System.out.println(start_time.replaceAll("\\.\\d+", ""));
    }
}
