package com.ccube.vetnpetclinic.service;

import com.ccube.vetnpetclinic.model.*;

import java.util.*;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findOwnerByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
