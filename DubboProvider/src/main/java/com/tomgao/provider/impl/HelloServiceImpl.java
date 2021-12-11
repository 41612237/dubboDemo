package com.tomgao.provider.impl;

import com.tomgao.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/10
 */
@Service
@org.springframework.stereotype.Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
