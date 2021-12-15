package com.tomgao.provider.impl;

import com.tomgao.api.CallbackListener;
import com.tomgao.api.CallbackService;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/14
 */
@Service(connections = 1, callbacks = 1000)
@org.springframework.stereotype.Service
public class CallbackServiceImpl implements CallbackService {

    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<>();


    public CallbackServiceImpl() {
        Thread t = new Thread(() -> {
           while (true) {
               try {
                   for (Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
                       try {
                           entry.getValue().changed(entry.getKey());
                       } catch (Throwable throwable) {
                           listeners.remove(entry.getKey());
                       }
                   }
                   // 定时触发变更通知
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged(key));
    }

    private String getChanged(String key) {
        return "Changed" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
