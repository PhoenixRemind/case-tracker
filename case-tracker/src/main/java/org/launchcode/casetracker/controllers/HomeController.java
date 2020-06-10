package org.launchcode.casetracker.controllers;


import org.launchcode.casetracker.models.Cases;
import org.launchcode.casetracker.models.User;
import org.launchcode.casetracker.models.data.CasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
    public String displayCases(Model model) {
        model.addAttribute("cases", casesRepository.findAll());

        return "index";
    }


}
