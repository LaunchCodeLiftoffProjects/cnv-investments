package com.liftoff.cnvInvestments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class LoginPageController {

    @GetMapping("")
    public String login() {

        return "login-page";
    }


}
