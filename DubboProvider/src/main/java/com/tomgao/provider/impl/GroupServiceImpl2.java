package com.tomgao.provider.impl;

import com.tomgao.api.GroupService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/17
 */
@Service(group = "g2")
@org.springframework.stereotype.Service
public class GroupServiceImpl2 implements GroupService {
    @Override
    public String differentImpl() {
        System.out.println("impl22222222222222222222222");
        return "impl22222222222222222222222";
    }
}
