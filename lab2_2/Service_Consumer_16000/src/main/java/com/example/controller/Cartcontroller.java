package com.example.controller;

import com.example.Feign.ServiceProviderService;
import com.example.entity.User;
import jakarta.annotation.Resource;
import com.example.entity.CommonResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class Cartcontroller {
    @Resource
    private ServiceProviderService serviceProviderService;

    @GetMapping("/getCartById/{userId}")
    public CommonResult<User> getCartById(@PathVariable("userId") Integer userId){

        CommonResult<User> result = serviceProviderService.getUserById(userId);
        return result;
    }

    @PostMapping("/getCartByUser")
    public CommonResult<User> getCartByInfo(@RequestBody User user){

        CommonResult<User> result = serviceProviderService.getUserByInfo(user);

        return result;
    }

    @PutMapping("/changeCartInfo")
    public CommonResult<User> changeUserInfo(@RequestBody User changeduser) {

        CommonResult<User> result = serviceProviderService.changeUserInfo(changeduser);
        return result;
    }

    @DeleteMapping("/deleteCartById/{userId}")
    public CommonResult<User> deleteCartById(@PathVariable("userId") Integer userId){
            CommonResult<User> result =serviceProviderService.deleteUserById(userId);
            return result;
    }
}
