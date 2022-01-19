package com.liftoff.cnvInvestments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class HomePageController {

    @RequestMapping(value = "")
    public String login(Model model) {

        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("investors", "Investors");
        actionChoices.put("fund-managers", "Fund Managers");

        model.addAttribute("actions", actionChoices);

        return "login-page";
    }
}
