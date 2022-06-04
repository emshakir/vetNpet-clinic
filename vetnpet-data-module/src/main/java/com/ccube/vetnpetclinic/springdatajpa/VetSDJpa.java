package com.ccube.vetnpetclinic.springdatajpa;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.repository.*;
import com.ccube.vetnpetclinic.service.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Profile("springdatajpa")
public class VetSDJpa implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetSet.forEach(vetSet::add);
        return vetSet;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
