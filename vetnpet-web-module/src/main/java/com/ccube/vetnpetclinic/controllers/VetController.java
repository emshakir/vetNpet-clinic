package com.ccube.vetnpetclinic.controllers;

import com.ccube.vetnpetclinic.service.map.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetServiceMap vetServiceMap;

    public VetController(VetServiceMap vetServiceMap) {
        this.vetServiceMap = vetServiceMap;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfVets(Model model) {
        model.addAttribute("listOfVets", vetServiceMap.findAll());
        return "vets/index";
    }
}
