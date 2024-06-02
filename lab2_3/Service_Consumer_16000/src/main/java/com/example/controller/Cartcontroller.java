package com.example.controller;

import com.example.entity.User;
import com.example.feign.ServiceProviderService;
import jakarta.annotation.Resource;
import com.example.entity.CommonResult;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class Cartcontroller {
//    @Resource
//    private RestTemplate restTemplate;
    @Resource
    private ServiceProviderService serviceProviderService;

    @GetMapping("/getCartById/{userId}")
    public CommonResult<User> getCartById(@PathVariable("userId") Integer userId){

        CommonResult<User> result = serviceProviderService.getUserById(userId);
        return result;
    }
}
