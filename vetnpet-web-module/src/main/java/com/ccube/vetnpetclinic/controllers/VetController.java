package com.ccube.vetnpetclinic.controllers;

import com.ccube.vetnpetclinic.service.map.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetMapService vetMapService;

    public VetController(VetMapService vetMapService) {
        this.vetMapService = vetMapService;
    }

//    private final VetSDJpa vetSDJpa;
//
//    public VetController(VetSDJpa vetSDJpa) {
//        this.vetSDJpa = vetSDJpa;
//    }

    @RequestMapping({"", "/", "/index", "/index.html", "/vets.html"})
    public String listOfVets(Model model) {
        model.addAttribute("listOfVets", vetMapService.findAll());
        return "vets/index";
    }
}
