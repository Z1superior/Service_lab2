package com.example.controller;

import com.example.entity.CommonResult;
import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> getUserById(@PathVariable("userId") Integer userId){
        CommonResult<User> result =new CommonResult<>();
        Integer code = 200;
        String message = "success";
        try {
            User u = new User(userId,"小明","123456","这是GET请求");
            result.setCode(code);
            result.setMessage(message);
            result.setUser(u);

        }catch (Exception e){
            result.setCode(404);
            result.setMessage("error");
        }
        return result;

    }

    @PostMapping("/getUserByInfo")
    public CommonResult<User> getUserByInfo(@RequestBody User user){
        CommonResult<User> result =new CommonResult<>();
        Integer code = 200;
        String message = "success";
        try {
            result.setCode(code);
            result.setMessage(message);
            result.setUser(user);

        }catch (Exception e){
            result.setCode(404);
            result.setMessage("error");
        }
        return result;

    }

    @PutMapping("/changeUserInfo")
    public CommonResult<User> changeUserInfo(@RequestBody User changeduser){
        CommonResult<User> result= new CommonResult<>();
        result.setUser(changeduser);
        Integer code = 200;
        String message = "success";
        try {
            result.setCode(code);
            result.setMessage(message);
            result.setUser(changeduser);
        }catch (Exception e){
            result.setCode(404);
            result.setMessage("error");
        }
        System.out.println(result);
        return result;
    }

   @DeleteMapping("/deleteUserById/{userId}")
    public CommonResult<User> deleteUserById(@PathVariable("userId") Integer userId){
       CommonResult<User> result =new CommonResult<>();
       Integer code = 200;
       String message = "success";
       try {
           User u = new User(userId,"小明","123456","这是Delete请求");
           result.setCode(code);
           result.setMessage(message);
           result.setUser(u);

       }catch (Exception e){
           result.setCode(404);
           result.setMessage("error");
       }
       System.out.println(result);
       return result;
   }
}
