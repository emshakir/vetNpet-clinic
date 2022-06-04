package com.ccube.vetnpetclinic.springdatajpa;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.repository.*;
import com.ccube.vetnpetclinic.service.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Profile("springdatajpa")
public class VisitSDJpa implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet = new HashSet<>();
        visitSet.forEach(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
