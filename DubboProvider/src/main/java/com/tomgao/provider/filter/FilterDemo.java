package com.tomgao.provider.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.springframework.stereotype.Service;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/24
 */
@Activate
@Service
public class FilterDemo implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("FilterDemo 开始");
        Result result = invoker.invoke(invocation);
        System.out.println("FilterDemo 结束");
        return result;
    }
}
