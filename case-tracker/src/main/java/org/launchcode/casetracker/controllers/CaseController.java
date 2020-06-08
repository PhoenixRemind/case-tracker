package org.launchcode.casetracker.controllers;

import org.launchcode.casetracker.models.data.CaseRepository;
import org.launchcode.casetracker.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("case")
public class CaseController {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String displayCase(@RequestParam(required=false) Integer caseId, Model model) {
        return "case/index";
    }

}
