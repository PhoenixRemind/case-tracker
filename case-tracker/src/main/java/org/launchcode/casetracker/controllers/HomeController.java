package org.launchcode.casetracker.controllers;


import org.launchcode.casetracker.models.Cases;
import org.launchcode.casetracker.models.User;
import org.launchcode.casetracker.models.data.CasesRepository;
import org.launchcode.casetracker.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    CasesRepository casesRepository;

    @Autowired
    UserRepository userRepository;

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

    @GetMapping("index")
    public String displayCases(@RequestParam Integer caseId, Model model) {

        Optional<Cases> result = casesRepository.findById(caseId);

        Cases cases = result.get();
        model.addAttribute("cases", caseId);
        casesRepository.save(cases);

        return "index";
    }

    @RequestMapping("index")
    public String showCases(@ModelAttribute @Valid Model model, Cases newCase, @RequestParam int userId) {

        newCase.setUser(userRepository.findById(userId).get());

        return "index";
    }

    //model.addAttribute("cases", casesRepository.findAll());

}
