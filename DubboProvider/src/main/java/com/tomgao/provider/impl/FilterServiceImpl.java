package com.tomgao.provider.impl;

import com.tomgao.api.FilterService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/24
 */
@Service(filter = "filterDemo")
@org.springframework.stereotype.Service
public class FilterServiceImpl implements FilterService {

    @Override
    public String filterTest() {
        return "run filterService";
    }
}
