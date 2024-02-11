package com.skio.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/test")
public class TestController {

    static List<String> populateUserTypes(){
        List<String> typesList = new ArrayList<>();
        typesList.add("Developer");
        typesList.add("Tester");
        typesList.add("Project Manager");
        typesList.add("Project Lead");
        return typesList;
    }

    @GetMapping
    public List<String> getAllUserTypes(){
        return populateUserTypes();
    }
}
