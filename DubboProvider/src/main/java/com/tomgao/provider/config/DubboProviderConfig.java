package com.tomgao.provider.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tomgao
 * @Description 替代 application.properties 配置
 *
 * @date 2021/12/10
 */
//@Configuration
public class DubboProviderConfig {

    @Bean
    public ApplicationConfig myApplicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("provider");
        return config;
    }

    @Bean
    public RegistryConfig MyegistryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setAddress("zookeeper://127.0.0.1:2181");
        config.setProtocol("zookeeper");
        return config;
    }

    @Bean
    public ProtocolConfig myProtocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20880);
        return config;
    }
}
