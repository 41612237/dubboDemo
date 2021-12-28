package com.tomgao.provider.impl;

import com.tomgao.api.AsyncService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/20
 */
//@Service(timeout = 10000)
@org.springframework.stereotype.Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    public CompletableFuture<String> asyncMethod(String name) {
        RpcContext context = RpcContext.getContext();

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(context.getAttachment("key1"));

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "async response from provider";
        });
    }

    public static void main(String[] args) {
        String tenantIdList = "mi-cn";
        String[] tenantIds = tenantIdList.trim().split(",");
        StringBuilder subExpression = new StringBuilder();

        for (int i = 0; i < tenantIds.length; i++) {
            subExpression.append(tenantIds[i]);
            if (i < tenantIds.length - 1) {
                subExpression.append(" || ");
            }
        }

        System.out.println(subExpression.toString());
    }
}
