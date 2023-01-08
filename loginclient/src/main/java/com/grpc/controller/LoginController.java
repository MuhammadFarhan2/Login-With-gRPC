package com.grpc.controller;

import com.grpc.model.User;
import com.grpc.service.LoginClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
//    @Autowired
    @Autowired
    private LoginClientService loginClientService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
      return   loginClientService.login(user.getUsername(), user.getPassword());
    }

}
