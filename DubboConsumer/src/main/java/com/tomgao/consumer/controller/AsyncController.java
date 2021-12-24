package com.tomgao.consumer.controller;

import com.tomgao.api.AsyncService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/20
 */

@RestController
public class AsyncController {

    @Reference(async = true)
    AsyncService asyncService;

    @RequestMapping("/async")
    public String asyncMethod() {

        // 调用直接返回CompletableFuture
        CompletableFuture<String> future = asyncService.asyncMethod("tomgao");
        // 增加回调
        //  v 异常, t 是回调返回值
        future.whenComplete( (v, t) -> {
            System.out.println("回调执行...");
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("response " + v);
            }
        });
        System.out.println("跳过回调,早于结果输出");
        return "asyncMethod";
    }
}
