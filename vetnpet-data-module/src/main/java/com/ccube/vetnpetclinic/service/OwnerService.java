package com.ccube.vetnpetclinic.service;

import com.ccube.vetnpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner Save(Owner owner);

    Owner findOwnerByLastName(String lastName);

    Owner findById(Long id);

    Set<Owner> findAll(Owner owner);
}
