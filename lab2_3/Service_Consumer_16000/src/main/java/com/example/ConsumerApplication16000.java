package com.example;

import com.example.rule.CustomLoadBalancerConfig;
import com.example.rule.CustomThreeTimeLoadBalancer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name="provider-server",configuration = CustomThreeTimeLoadBalancer.class)
public class ConsumerApplication16000 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication16000.class,args);
    }
}


