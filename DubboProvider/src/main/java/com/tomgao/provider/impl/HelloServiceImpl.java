package com.tomgao.provider.impl;

import com.tomgao.api.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/10
 */
@Service(timeout = 10000)
@org.springframework.stereotype.Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public CompletableFuture<String> byeDubbo(String name) {

        RpcContext savedContext = RpcContext.getContext();

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(savedContext.getAttachment("consumer-key1"));
            try {
                System.out.println("异步执行 byeDubbo 中.....");
//                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "async response from provider";
        });
    }
}
