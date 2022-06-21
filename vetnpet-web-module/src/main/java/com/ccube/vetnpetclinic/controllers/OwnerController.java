package com.ccube.vetnpetclinic.controllers;

import com.ccube.vetnpetclinic.service.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerController {


    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

//    private final OwnerSDJpa ownerSDJpa;

//    public OwnerController(OwnerSDJpa ownerSDJpa) {
//        this.ownerSDJpa = ownerSDJpa;
//    }


    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(Model model) {
        model.addAttribute("ownersList", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notImplemented";
    }
}
