package com.tomgao.api;

import java.util.concurrent.CompletableFuture;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/10
 */
public interface HelloService {

    String sayHello(String name);

    CompletableFuture<String> byeDubbo(String name);

}
