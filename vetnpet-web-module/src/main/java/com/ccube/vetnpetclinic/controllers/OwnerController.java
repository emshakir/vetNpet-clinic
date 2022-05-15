package com.ccube.vetnpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping({"owners","owners/index","owners/index.html"})
    public String vetIndex(Model model){
        model.addAttribute("ownerWelcomeNote","List of Owner's Names");
        return "owners/index";
    }
}
