package com.tomgao.api;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/20
 */
public interface AsyncService {

    CompletableFuture<String> asyncMethod(String name);

}
