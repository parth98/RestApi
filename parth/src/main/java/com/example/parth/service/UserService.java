package com.example.parth.service;


import com.example.parth.entity.Role;
import com.example.parth.entity.User;
import com.example.parth.exception.BadRequestException;
import com.example.parth.jwt.JwtTokenProvider;
import com.example.parth.payload.ApplicationPayload;
import com.example.parth.payload.LoginSuccessPayload;
import com.example.parth.repository.RoleRepository;
import com.example.parth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public String signup(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new BadRequestException("Username is already in use");
        }
    }


    public ApplicationPayload createRole(Role role){
        if (!roleRepository.existsByName(role.getName())) {
            roleRepository.save(role);
            ApplicationPayload apiResponse = new ApplicationPayload(
                    ZonedDateTime.now(ZoneId.of("Z")),
                    "Role created Successfully",
                    HttpStatus.CREATED
            );
                    return apiResponse;
        } else {
            throw new BadRequestException("Role is already in use");
        }
    }


}
