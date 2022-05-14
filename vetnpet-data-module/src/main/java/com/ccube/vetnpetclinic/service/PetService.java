package com.ccube.vetnpetclinic.service;

import com.ccube.vetnpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet Save(Pet pet);

    Pet findById(Long id);

    Set<Pet> findAll(Pet pet);

}
