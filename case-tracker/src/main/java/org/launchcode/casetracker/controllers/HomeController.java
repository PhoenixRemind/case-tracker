package org.launchcode.casetracker.controllers;


import org.launchcode.casetracker.models.Ticket;
import org.launchcode.casetracker.models.User;
import org.launchcode.casetracker.models.data.TicketRepository;
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
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    TicketRepository ticketRepository;

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

        Optional<Ticket> result = ticketRepository.findById(caseId);

        Ticket aCase = result.get();
        model.addAttribute("cases", caseId);

        ticketRepository.save(aCase);

        return "index";
    }

    @RequestMapping("index")
    public String showCases(@ModelAttribute @Valid Model model, Ticket newCase, @RequestParam int userId) {

        newCase.setUser(userRepository.findById(userId).get());

        return "index";
    }

    //model.addAttribute("cases", casesRepository.findAll());

}
