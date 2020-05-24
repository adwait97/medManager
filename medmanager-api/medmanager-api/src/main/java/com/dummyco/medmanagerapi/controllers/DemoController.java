/*
Author: Adwait Wadekar

Code Description: This is a demo controller to show how requests will be handled. The RestController annotation
        handles the HTTP requests and GetMapping annotation ensures that GET requests to the specified extension
        are mapped to the appropriate methods.

 */

//TODO: Implement different controllers based on db ER diagram.

package com.dummyco.medmanagerapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public String template = "Fix me";

    // annotation to map request extension and method.
    @GetMapping("/api/demo")
    public String demo(){
        return template;
    }

}
