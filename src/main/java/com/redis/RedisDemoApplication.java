package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SpringBootApplication
//@EnableScheduling
@EnableAsync
public class RedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
        //用来禁用web应用
//        new SpringApplicationBuilder(RedisDemoApplication.class).web(false);

        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> stringStringEntry : entrySet) {
            if (stringStringEntry.getKey().equals("1")) {
                map.remove(stringStringEntry.getKey());
            }
        }
        System.out.println(map.toString());
        LocalDateTime mtime = LocalDateTime.parse("2017-10-20 11:44:44", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        ZonedDateTime zonedDateTime = mtime.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime.toEpochSecond());

//        System.out.println(Integer.parseInt("1508811735403"));

        try {
            System.out.println(URLEncoder.encode("描述", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        TreeMap<String, String> treeMap = new TreeMap<>();
        try {
            treeMap.put(URLEncoder.encode("描述", "UTF-8"), "11");
            treeMap.put("aapp", "11");
            treeMap.put("bb", "11ewew");
            Set<Map.Entry<String, String>> entries = treeMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(entry.getKey() + entry.getValue());
            }

            List list = new ArrayList();
            list.add(URLEncoder.encode("描述", "UTF-8"));
            list.add("add");
            list.add("bb");
            Collections.sort(list);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String attachments = (String) treeMap.get("attachments");
        System.out.println(attachments);
        treeMap.remove("hello");

        ThreadLocal threadLocal = new ThreadLocal();

        Integer ss = 33354;
        int sss = 33355;
        System.out.println(ss == sss);


    }

}
