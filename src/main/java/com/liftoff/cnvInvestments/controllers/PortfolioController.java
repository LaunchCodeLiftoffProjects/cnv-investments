package com.liftoff.cnvInvestments.controllers;

import com.liftoff.cnvInvestments.data.PortfolioRepository;
import com.liftoff.cnvInvestments.data.SecurityRepository;
import com.liftoff.cnvInvestments.data.TransactionRepository;
import com.liftoff.cnvInvestments.data.UserRepository;
import com.liftoff.cnvInvestments.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityRepository securityRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public PortfolioController () {
        columnChoices.put("security", "Security");
        columnChoices.put("shares", "Shares");
        columnChoices.put("cost", "Cost");
        columnChoices.put("current price", "Current Price");
        columnChoices.put("invested capital", "Invested Capital");
        columnChoices.put("present value", "Present Value");
        columnChoices.put("return", "Return");
    }

    @RequestMapping
    public String displayPortfolio(Model model) {
//         Iterable<Transaction> transactions;
//         User loggedInUser = AuthenticationController.loggedInUser;
//         transactions = TransactionData.findByUser(loggedInUser, transactionRepository.findAll());
//         model.addAttribute("title", "Portfolio of " + columnChoices.get(loggedInUser));
//         model.addAttribute("transactions", transactions);
//         return "investor-portfolio-page";

        ArrayList<Portfolio> portfolio;
        User loggedInUser = AuthenticationController.loggedInUser;
        portfolio = PortfolioData.findByUser(loggedInUser, portfolioRepository.findAll());
        model.addAttribute("title", "Portfolio of " + columnChoices.get(loggedInUser));
        model.addAttribute("portfolio", portfolio);
        return "investor-portfolio-page";


//        Iterable<Portfolio> portfolio;
//        User loggedInUser = AuthenticationController.loggedInUser;
//        if (loggedInUser.getId() == 1) {
//            portfolio = portfolioRepository.findAll();
//            model.addAttribute("title", "Portfolio");
//            model.addAttribute("portfolio", portfolio);
//            return "fundManager-portfolio-page";
//        } else {
//            portfolio = PortfolioData.findByUser(loggedInUser, portfolioRepository.findAll());
//            model.addAttribute("title", "Portfolio of " + columnChoices.get(loggedInUser));
//            model.addAttribute("portfolio", portfolio);
//            return "investor-transactions-page";
//        }

    }

}
