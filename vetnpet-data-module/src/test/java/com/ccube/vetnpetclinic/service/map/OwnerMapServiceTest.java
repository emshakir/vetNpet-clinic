package com.ccube.vetnpetclinic.service.map;

import com.ccube.vetnpetclinic.model.*;
import org.junit.jupiter.api.*;

import java.util.*;


class OwnerMapServiceTest {

    OwnerMapService mapService;

    final Long id = 1L;
    final String lastName = "smith";

    @BeforeEach
    void setUp() {
        mapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        mapService.save(Owner.builder().id(id).lastName("smith").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = mapService.findAll();
        Assertions.assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = mapService.findById(id);
        Assertions.assertEquals(id, owner.getId());
    }

    @Test
    void saveExistingId() {

        Long id = 2L;
        Owner savedOwner = mapService.save(Owner.builder().id(id).build());
        Assertions.assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNullId() {
        Owner savedOwner = mapService.save(Owner.builder().build());
        Assertions.assertNotNull(savedOwner);
        Assertions.assertNotNull(savedOwner.getId());

    }

    @Test
    void delete() {
        mapService.delete(mapService.findById(id));
        Assertions.assertEquals(0, mapService.findAll().size());
    }

    @Test
    void deleteById() {
        mapService.deleteById(id);
        Assertions.assertEquals(0, mapService.findAll().size());
    }


    @Test
    void findOwnerByLastName() {
        Owner owner = mapService.findOwnerByLastName(lastName);
        Assertions.assertEquals("smith", owner.getLastName());
    }
}