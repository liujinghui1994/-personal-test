package com.umbrella.dubboproduct.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.umbrella.dubboproduct.service.UserService;
import com.umbrella.dubboproduct.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaycekon on 2017/9/19.
 */
@RestController
public class UserController {

//    @Autowired
//    private UserServiceImpl userService;

    @Reference(check = false)
    UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String saveUser() {
        return userService.saveUser(new User()).toString();
    }
}
