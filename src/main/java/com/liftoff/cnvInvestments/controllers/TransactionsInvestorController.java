package com.liftoff.cnvInvestments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("transactions")

public class TransactionsInvestorController {

    @GetMapping
    public String displayTransactionsPage() { return "investor-transactions-page"; }

}
