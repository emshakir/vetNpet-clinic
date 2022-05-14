package com.ccube.vetnpetclinic.service;

import com.ccube.vetnpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet Save(Vet vet);

    Vet findById(Long id);

    Set<Vet> findAll(Vet vet);
}
