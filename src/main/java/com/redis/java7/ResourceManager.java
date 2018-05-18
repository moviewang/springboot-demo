package com.redis.java7;

/**
 * Created by Movie on 2018/3/30.
 * java 7 资源管理
 */
public class ResourceManager {
    public static void main(String[] args) {
        try (RM rm = new RM()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class RM implements AutoCloseable{
        @Override
        public void close() throws Exception {
            System.out.println("resourc closed");
        }
    }
}
