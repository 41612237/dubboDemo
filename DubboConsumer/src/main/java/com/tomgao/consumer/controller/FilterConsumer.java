package com.tomgao.consumer.controller;

import com.tomgao.api.FilterService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/24
 */
@RestController
public class FilterConsumer {

    @Reference
    private FilterService filterService;

    @RequestMapping("/filter")
    public String filter() {
        return filterService.filterTest();
    }
}
