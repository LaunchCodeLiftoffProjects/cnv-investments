package com.liftoff.cnvInvestments.controllers;

import com.liftoff.cnvInvestments.data.SecurityRepository;
import com.liftoff.cnvInvestments.models.Security;
import com.liftoff.cnvInvestments.models.dto.SecurityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class SecurityController {

    @Autowired
    SecurityRepository securityRepository;

    @GetMapping("/add-security")
    public String displayAddSecurityForm(Model model) {
        model.addAttribute(new SecurityDTO());
        return "add-security";
    }

    @PostMapping("/add-security")
    public String processAddSecurityForm(@ModelAttribute @Valid SecurityDTO securityDTO,
                                          Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "add-security";
        }

        Security existingSecurity = securityRepository.findBySecurityName(securityDTO.getSecurityName());
        if (existingSecurity != null) {
            errors.rejectValue("securityName", "securityName.alreadyexists", "A security with that name already exists");
            return "add-security";
        }

        Security newSecurity = new Security(securityDTO.getSecurityName(), securityDTO.getTickerCode());
        securityRepository.save(newSecurity);
        return "redirect:/add";
    }

}
