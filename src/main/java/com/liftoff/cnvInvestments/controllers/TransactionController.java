package com.liftoff.cnvInvestments.controllers;
import com.liftoff.cnvInvestments.data.SecurityRepository;
import org.springframework.data.repository.CrudRepository;
import com.liftoff.cnvInvestments.data.TransactionRepository;
import com.liftoff.cnvInvestments.data.UserRepository;
import com.liftoff.cnvInvestments.models.Transaction;
import com.liftoff.cnvInvestments.models.TransactionData;
import com.liftoff.cnvInvestments.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityRepository securityRepositoryRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public TransactionController () {
        columnChoices.put("user", "User");
        columnChoices.put("security", "Security");
        columnChoices.put("date", "Date");
        columnChoices.put("type", "Type");
        columnChoices.put("shares", "Shares");
        columnChoices.put("cost", "Cost");
        columnChoices.put("invested capital", "Invested Capital");
    }

    @RequestMapping
    public String displayAllTransactions(Model model) {
        Iterable<Transaction> transactions;
        User loggedInUser = AuthenticationController.loggedInUser;
        if (loggedInUser.getId() == 1) {
            transactions = transactionRepository.findAll();
            model.addAttribute("title", "All Transactions");
            model.addAttribute("transactions", transactions);
            return "fundManager-transactions-page";
        } else {
            transactions = TransactionData.findByUser(loggedInUser, transactionRepository.findAll());
            model.addAttribute("title", "Transactions of " + columnChoices.get(loggedInUser));
            model.addAttribute("transactions", transactions);
            return "investor-transactions-page";
        }
    }

}
