package com.redis.netty;

/**
 * @Author: movie
 * @Date: 2018/5/28 15:44
 */
public interface ReadCallBack {
    void onDate(Object data);

    void onError(Throwable t);
}
