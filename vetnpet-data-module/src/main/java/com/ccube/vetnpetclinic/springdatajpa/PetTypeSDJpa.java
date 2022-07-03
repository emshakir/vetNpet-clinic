package com.ccube.vetnpetclinic.springdatajpa;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.repository.*;
import com.ccube.vetnpetclinic.service.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpa implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypeSet::add);
        return petTypeSet;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
