package com.tomgao.invoker;

import com.sun.tools.javac.util.ServiceLoader;
import com.tomgao.spi.DataSource;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/24
 */
public class Main {

    private static ServiceLoader<DataSource> loader = ServiceLoader.load(DataSource.class);

    public static void main(String[] args) {
        for (DataSource dataSource : loader) {
            System.out.println(dataSource.getConnection());
        }
    }
}
