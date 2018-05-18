package com.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Movie on 2017/7/12.
 */
@Component
public class RedisProperties {
    @Value("${redis.min}")
    private Integer min;
    @Value("${redis.max}")
    private Integer max;
    @Value("${redis.random.num}")
    private Integer num;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
