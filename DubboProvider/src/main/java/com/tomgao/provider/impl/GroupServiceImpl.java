package com.tomgao.provider.impl;

import com.tomgao.api.GroupService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/17
 */
@Service(group = "g1")
@org.springframework.stereotype.Service
public class GroupServiceImpl implements GroupService {
    @Override
    public String differentImpl() {
        System.out.println("impl1111111111111111111111111");
        return "11111111";
    }
}
