package com.concept.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concept.jwtauthentication.dto.RegisterDTO;
import com.concept.jwtauthentication.service.RegisterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/register")
public class RegisterController {
    
    @Autowired
    private RegisterService registerService;

    @PostMapping
    public String register(@RequestBody RegisterDTO registerDTO) {
        return this.registerService.registerPerson(registerDTO);
    }
    

    
}
