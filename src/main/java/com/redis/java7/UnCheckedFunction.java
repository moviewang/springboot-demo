package com.redis.java7;

/**
 * @Author: movie
 * @Date: 2018/5/18 14:30
 */
@FunctionalInterface
public interface UnCheckedFunction<T, R> {
    R apply(T t) throws Exception;
}
