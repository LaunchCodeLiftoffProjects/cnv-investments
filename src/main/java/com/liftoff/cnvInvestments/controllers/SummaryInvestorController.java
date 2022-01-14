package com.liftoff.cnvInvestments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("summary")
public class SummaryInvestorController {

    @GetMapping
    public String displaySummaryPage() {
        return "investor-summary-page";
    }
}
