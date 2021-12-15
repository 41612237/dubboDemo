package com.tomgao.consumer.controller;

import com.tomgao.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/10
 */
@RestController
public class HelloController {

    /**
     * Error creating bean with name 'helloController':
     * Injection of @Reference dependencies is failed; nested exception is java.lang.IllegalStateException: No registry config found or it's not a valid config! The registry config is: <dubbo:registry valid="false" zookeeperProtocol="false" prefix="dubbo.registry" />
     */
    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        String hello = helloService.sayHello("tomgao");
        System.out.println(hello);
        return hello;
    }


    @RequestMapping("/bye")
    public void byeDubbo() {
        CompletableFuture<String> future = helloService.byeDubbo("tomgaooo");
        future.whenComplete( (v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("Response: " + v);
            }
        });

        System.out.println("Executed before response return.");
    }
}
