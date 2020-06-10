package org.launchcode.casetracker.controllers;


import org.launchcode.casetracker.models.Cases;
import org.launchcode.casetracker.models.User;
import org.launchcode.casetracker.models.data.CasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    CasesRepository casesRepository;

    @GetMapping
    public String index(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("isloggedin", (user != null));

        if (user != null) {
            model.addAttribute("username", user.getUsername());
        }

        return "index";
    }

    @RequestMapping("")
    public String displayCases(@RequestParam Integer caseId, Model model) {

        Optional<Cases> result = casesRepository.findById(caseId);

        if(result.isEmpty()) {
            model.addAttribute("cases", "No Open Cases" + caseId);
        } else {
            Cases cases = result.get();
            model.addAttribute("cases", cases);
        }

        return "index";
    }

    //model.addAttribute("cases", casesRepository.findAll());

}
