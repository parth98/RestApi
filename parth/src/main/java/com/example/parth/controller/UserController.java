package com.example.parth.controller;


import com.example.parth.entity.Role;
import com.example.parth.entity.User;
import com.example.parth.payload.ApplicationPayload;

import com.example.parth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

/*    @Autowired
    private ModelMapper modelMapper;*/

/*    @PostMapping("/signup")
    public String signup(@RequestBody UserDataDTO user) {
        return userService.signup(modelMapper.map(user, User.class));
    }*/

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/create/role")
    @Secured("ROLE_ADMIN")
    public ApplicationPayload roleCreation(@RequestBody Role role){
        return userService.createRole(role);
    }


}
