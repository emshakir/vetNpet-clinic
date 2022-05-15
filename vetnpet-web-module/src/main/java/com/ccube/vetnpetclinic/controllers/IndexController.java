package com.ccube.vetnpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String indexPage(Model model) {
        model.addAttribute("welcomeNote", "Welcome to Pet and Vet Clinic.");
        return "index";
    }
}
