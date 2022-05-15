package com.ccube.vetnpetclinic.service;

import com.ccube.vetnpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findOwnerByLastName(String lastName);
}
