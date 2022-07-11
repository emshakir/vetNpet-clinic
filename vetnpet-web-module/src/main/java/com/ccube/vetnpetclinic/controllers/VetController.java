package com.ccube.vetnpetclinic.controllers;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.springdatajpa.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/vets")
public class VetController {

//    private final VetMapService vetMapService;
//
//    public VetController(VetMapService vetMapService) {
//        this.vetMapService = vetMapService;
//    }

    private final VetSDJpa vetSDJpa;

    public VetController(VetSDJpa vetSDJpa) {
        this.vetSDJpa = vetSDJpa;
    }

    @RequestMapping({"", "/", "/index", "/index.html", "/vets.html"})
    public String listOfVets(Model model) {
        model.addAttribute("listOfVets", vetSDJpa.findAll());
        return "vets/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetSDJpa.findAll();
    }
}
