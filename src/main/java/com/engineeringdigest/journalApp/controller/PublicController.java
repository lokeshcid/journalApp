package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    UserService userService;
    @PostMapping("/create-user")
    public void creatUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
}
