package com.liftoff.cnvInvestments.controllers;

import com.liftoff.cnvInvestments.data.PortfolioRepository;
import com.liftoff.cnvInvestments.data.SecurityRepository;
import com.liftoff.cnvInvestments.data.TransactionRepository;
import com.liftoff.cnvInvestments.data.UserRepository;
import com.liftoff.cnvInvestments.models.Portfolio;
import com.liftoff.cnvInvestments.models.Security;
import com.liftoff.cnvInvestments.models.Transaction;
import com.liftoff.cnvInvestments.models.User;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityRepository securityRepository;

    @GetMapping("add")
    public String displayAddTransactionForm(Model model) {
        model.addAttribute("title", "Add Transaction");
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("securities", securityRepository.findAll());
        model.addAttribute(new Transaction());
        return "add-transactions";
    }

    @PostMapping("add")
    public String processAddTransactionForm(@ModelAttribute @Valid Transaction newTransaction, @ModelAttribute Portfolio newPortfolio,
                                    Errors errors, Model model, @RequestParam int userId, @RequestParam int securityId) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Transaction");
            model.addAttribute(new Transaction());
            return "add";
        }

        Optional userObj = userRepository.findById(userId);
        if (userObj.isPresent()) {
            User user = (User) userObj.get();
            newTransaction.setUser(user);
            newPortfolio.setUser(user);
        }

        Optional securityObj = securityRepository.findById(securityId);
        if (securityObj.isPresent()) {
            Security security = (Security) securityObj.get();
            newTransaction.setSecurity(security);
            newTransaction.setInvestedCap(newTransaction.getShares() * newPortfolio.getCost());

            if (portfolioRepository.findBySecurity(security) == null) {
                newPortfolio.setSecurity(security);
                newPortfolio.setShares(newTransaction.getShares());
                newPortfolio.setCost(newTransaction.getCost());
                newPortfolio.setInvestedCap(newTransaction.getInvestedCap());
                portfolioRepository.save(newPortfolio);
            } else {
                portfolioRepository.findBySecurity(security).setSecurity(security);
                int newShares = portfolioRepository.findBySecurity(security).getShares() + newTransaction.getShares();
                portfolioRepository.findBySecurity(security).setShares(newShares);
                double newInvestedCap = portfolioRepository.findBySecurity(security).getInvestedCap() + newTransaction.getInvestedCap();
                portfolioRepository.findBySecurity(security).setInvestedCap(newInvestedCap);
                double newCost = portfolioRepository.findBySecurity(security).getInvestedCap() / newShares;
                portfolioRepository.findBySecurity(security).setCost(newCost);
            }

            transactionRepository.save(newTransaction);
        }

        return "redirect:/transactions";
    }

}
