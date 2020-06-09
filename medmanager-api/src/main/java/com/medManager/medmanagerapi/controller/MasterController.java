/*
Author: Adwait Wadekar
File Description: This is a controller and is used to handle HTTP requests

 */
package com.medManager.medmanagerapi.controller;

import org.springframework.stereotype.Controller;
//Model is used to define a model in Spring MVC. Acts as a container for primarily adding attributes
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MasterController {

    //following mapping demonstrates input from URL
    @GetMapping(value="/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")
                                       String name, Model model) {
        model.addAttribute("name", name);
        return "greeting"; // thymeleaf parses greeting.html template and evaluates the th:text expression
    }
}
