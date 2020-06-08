package org.launchcode.casetracker.controllers;

import org.launchcode.casetracker.models.data.CasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cases")
public class CasesController {

    @Autowired
    private CasesRepository caseRepository;

    @GetMapping
    public String displayCase(@RequestParam(required=false) Integer caseId, Model model) {
        return "case/index";
    }

}
