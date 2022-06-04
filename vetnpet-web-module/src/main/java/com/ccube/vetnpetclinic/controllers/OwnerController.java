package com.ccube.vetnpetclinic.controllers;

import com.ccube.vetnpetclinic.service.map.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerMapService ownerMapService;

    public OwnerController(OwnerMapService ownerMapService) {
        this.ownerMapService = ownerMapService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(Model model) {
        model.addAttribute("ownersList", ownerMapService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notImplemented";
    }
}
