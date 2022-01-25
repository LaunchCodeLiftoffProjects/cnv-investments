package com.liftoff.cnvInvestments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value = "investors")
public class InvestorController {

    static HashMap<String, String> columnChoices = new HashMap<>();

    public InvestorController () {
        columnChoices.put("investor-portfolio-page", "Investor Portfolio Page");
        columnChoices.put("investor-summary-page", "Investor Summary Page");
        columnChoices.put("investor-transactions-page", "Investor Transaction Page");
    }

    @RequestMapping(value = "")
    public String investor(Model model) {
        model.addAttribute("columns", columnChoices);

        return "investor";
    }

}
