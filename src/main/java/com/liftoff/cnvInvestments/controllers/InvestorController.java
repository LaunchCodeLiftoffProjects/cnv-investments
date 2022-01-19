package com.liftoff.cnvInvestments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "investors")
public class InvestorController {


    @GetMapping
    public String InvestorPage () {
        return "investor-portfolio-page";
    }
}
