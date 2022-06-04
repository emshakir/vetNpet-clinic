package com.ccube.vetnpetclinic.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String indexPage(Model model) {
//        model.addAttribute("welcomeNote", "Welcome to Pet and Vet Clinic.");
        return "index";
    }

    @RequestMapping("/oups")
    public String errorPage() {
        return "notImplemented";
    }
}
