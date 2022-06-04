package com.ccube.vetnpetclinic.springdatajpa;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.repository.*;
import com.ccube.vetnpetclinic.service.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpa implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpa(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitySet = new HashSet<>();
        specialitySet.forEach(specialitySet::add);
        return specialitySet;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
