package com.skio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
*
*  Controller - HomeController
 * Description - Navigation to Home
* */
@RestController
@RequestMapping(path = {"/", "/index", "/home"})
public class HomeController {
    @GetMapping
    public String home(){
        return "Welcome to Home Page";
    }
}
