package com.helg893.pp_3_1_2_spring_boot_crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("KATA PP 2.3.1 Spring+MVC+Hibernate");
        model.addAttribute("messages", messages);
        return "index";
    }
}
