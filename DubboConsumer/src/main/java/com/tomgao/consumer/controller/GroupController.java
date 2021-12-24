package com.tomgao.consumer.controller;

import com.tomgao.api.GroupService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/17
 */
@RestController
public class GroupController {

    @Reference(group = "g1")
    private GroupService groupService;

    @Reference(group = "g2")
    private GroupService groupService2;

    @RequestMapping("/g1")
    public String group1() {
        return groupService.differentImpl();

    }


    @RequestMapping("/g2")
    public String group2() {
        return groupService2.differentImpl();
    }
}
