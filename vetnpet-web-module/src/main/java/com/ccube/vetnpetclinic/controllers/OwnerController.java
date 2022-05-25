package com.ccube.vetnpetclinic.controllers;

import com.ccube.vetnpetclinic.service.map.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerServiceMap ownerServiceMap;

    public OwnerController(OwnerServiceMap ownerServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(Model model) {
        model.addAttribute("ownersList", ownerServiceMap.findAll());
        return "owners/index";
    }
}
