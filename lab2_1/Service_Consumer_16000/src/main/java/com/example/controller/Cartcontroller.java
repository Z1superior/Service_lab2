package com.example.controller;

import com.example.entity.User;
import jakarta.annotation.Resource;
import com.example.entity.CommonResult;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class Cartcontroller {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/getCartById/{userId}")
    public CommonResult<User> getCartById(@PathVariable("userId") Integer userId){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        CommonResult<User> result = restTemplate.getForObject(
                "http://"+instance.getHost()+":"+instance.getPort()+"/user/getUserById/" + userId.toString(), CommonResult.class);
        return result;
    }

    @PostMapping("/getCartByUser")
    public CommonResult<User> getCartByInfo(@RequestBody User user){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        CommonResult<User> result = restTemplate.postForObject(
                "http://"+instance.getHost()+":"+instance.getPort()+"/user/getUserByInfo",user, CommonResult.class);
        return result;
    }

    @PutMapping("/changeCartInfo")
    public void changeUserInfo(@RequestBody User changeduser){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);

         try {
             restTemplate.put(
                     "http://"+instance.getHost()+":"+instance.getPort()+"/user/changeUserInfo",changeduser);
             System.out.println("成功发送PUT请求给服务提供者");
         }catch (Exception e){
             System.out.println(e);
         }

    }

    @DeleteMapping("/deleteCartById/{userId}")
    public void deleteCartById(@PathVariable("userId") Integer userId){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        try {
            restTemplate.delete(
                    "http://"+instance.getHost()+":"+instance.getPort()+"/user/deleteUserById/"+ userId.toString());
            System.out.println("成功发送DELETE请求给服务提供者");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
