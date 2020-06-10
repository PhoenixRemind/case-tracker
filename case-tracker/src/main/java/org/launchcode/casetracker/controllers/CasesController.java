package org.launchcode.casetracker.controllers;

import org.launchcode.casetracker.models.User;
import org.launchcode.casetracker.models.data.CasesRepository;
import org.launchcode.casetracker.models.data.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("cases")
public class CasesController {

    @Autowired
    private CasesRepository caseRepository;

    @Autowired
    private TranscriptRepository transcriptRepository;

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping
    public String displayCase(@RequestParam(required=false) Integer caseId, Model model) {
        return "cases";
    }

    @GetMapping("index")
    public String index(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("isloggedin", (user != null));

        if (user != null) {
            model.addAttribute("username", user.getUsername());
        }
        return "cases";
    }

}
