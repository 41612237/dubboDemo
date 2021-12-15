package com.tomgao.api;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/14
 */
public interface CallbackService {

    void addListener(String key, CallbackListener listener);
}
