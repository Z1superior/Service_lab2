package com.example.Feign;

import com.example.entity.CommonResult;
import com.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("provider-server")
public interface ServiceProviderService {
    @GetMapping("/user/getUserById/{userId}")
    CommonResult<User>  getUserById(@PathVariable("userId") Integer userId);
    @PostMapping("/user/getUserByInfo")
    CommonResult<User> getUserByInfo(@RequestBody User user);
    @PutMapping("/user/changeUserInfo")
    CommonResult<User> changeUserInfo(@RequestBody User changeduser);
    @DeleteMapping("/user/deleteUserById/{userId}")
    CommonResult<User> deleteUserById(@PathVariable("userId") Integer userId);
}

