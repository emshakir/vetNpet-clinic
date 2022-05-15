package com.ccube.vetnpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"vets","vets/index","vets/index.html"})
    public String vetIndex(Model model){
        model.addAttribute("vetWelcomeNote","List of Vet's Names");
        return "vets/index";
    }
}
