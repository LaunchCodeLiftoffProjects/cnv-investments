package com.liftoff.cnvInvestments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomePageController {

    @GetMapping(value = "")
    public String loginPage (Model model) {
        return "authentication";
    }
}
