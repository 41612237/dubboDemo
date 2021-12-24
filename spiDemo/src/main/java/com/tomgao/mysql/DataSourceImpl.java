package com.tomgao.mysql;

import com.tomgao.spi.DataSource;

/**
 * @author tomgao
 * @Description
 * @date 2021/12/24
 */
public class DataSourceImpl implements DataSource {
    public String getConnection() {
        return "Mysql提供数据库连接";
    }
}
