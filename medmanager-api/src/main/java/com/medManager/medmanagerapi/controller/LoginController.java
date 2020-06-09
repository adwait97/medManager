package com.medManager.medmanagerapi.controller;

import com.medManager.medmanagerapi.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    //mapping for both GET and POST requests will be mapped to the same
    //endpoint but handling is separated by the annotations

    @GetMapping("/login")
    public String showLogin(Login login){ return "login"; }


    @PostMapping("/login")
    public String submitLogin(@ModelAttribute Login login){
        System.out.println("Username: " + login.getUsername());
        System.out.println("Password: " + login.getPassword());
        return "result";
    }
}
