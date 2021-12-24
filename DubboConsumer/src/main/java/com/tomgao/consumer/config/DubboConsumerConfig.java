//package com.tomgao.consumer.config;
//
//import org.apache.dubbo.config.ApplicationConfig;
//import org.apache.dubbo.config.RegistryConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author tomgao
// * @Description
// * @date 2021/12/10
// */
////@Configuration
//public class DubboConsumerConfig {
//
//    @Bean
//    public ApplicationConfig myApplicationConfig() {
//        ApplicationConfig config = new ApplicationConfig();
//        config.setName("consumer");
//        return config;
//    }
//
//    @Bean
//    public RegistryConfig registryConfig() {
//        RegistryConfig config = new RegistryConfig();
//        config.setAddress("zookeeper://127.0.0.1:2181");
//        config.setProtocol("zookeeper");
//        return config;
//    }
//
//}
