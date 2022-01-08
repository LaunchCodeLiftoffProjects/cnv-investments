package com.liftoff.cnvInvestments.controllers;

import com.liftoff.cnvInvestments.data.InvestorRepository;
import com.liftoff.cnvInvestments.models.Investor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    InvestorRepository investorRepository;

    private static final String userSessionKey = "user";

    public Investor getInvestorFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<Investor> investor = investorRepository.findById(userId);

        if (investor.isEmpty()) {
            return null;
        }

        return investor.get();
    }

    private static void setUserInSession(HttpSession session, Investor investor) {
        session.setAttribute(userSessionKey, investor.getId());
    }
}
