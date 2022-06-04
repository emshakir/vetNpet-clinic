package com.ccube.vetnpetclinic.repository;

import com.ccube.vetnpetclinic.model.*;
import org.springframework.data.repository.*;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findOwnerByLastName(String lastName);
}
