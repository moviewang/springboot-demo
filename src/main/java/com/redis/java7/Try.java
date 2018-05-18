package com.redis.java7;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Author: movie
 * @Date: 2018/5/18 14:32
 */
public class Try {
    public static <T, R> Function<T, R> of(UnCheckedFunction<T, R> mapper, R defaultR) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception e) {
                return defaultR;
            }
        };
    }
}
