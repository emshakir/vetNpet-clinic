package com.ccube.vetnpetclinic.service.map;

import com.ccube.vetnpetclinic.model.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class PetMapServiceTest {

    private PetMapService petMapService;

    private final Long petId = 1L;

    @BeforeEach
    void setUp() {

        petMapService = new PetMapService();

        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {

        Set<Pet> petSet = petMapService.findAll();

        Assertions.assertEquals(1, petSet.size());
    }

    @Test
    void findByIdExistingId() {

        Pet pet = petMapService.findById(petId);

        Assertions.assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {

        Pet pet = petMapService.findById(5L);

        Assertions.assertNull(pet);
    }

    @Test
    void findByIdNullId() {

        Pet pet = petMapService.findById(null);

        Assertions.assertNull(pet);
    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Pet pet2 = Pet.builder().id(id).build();

        Pet savedPet = petMapService.save(pet2);

        Assertions.assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {

        Long id = 1L;

        Pet pet2 = Pet.builder().id(id).build();

        Pet savedPet = petMapService.save(pet2);

        Assertions.assertEquals(id, savedPet.getId());
        Assertions.assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        Pet savedPet = petMapService.save(Pet.builder().build());

        Assertions.assertNotNull(savedPet);
        Assertions.assertNotNull(savedPet.getId());
        Assertions.assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void deletePet() {

        petMapService.delete(petMapService.findById(petId));

        Assertions.assertEquals(0, petMapService.findAll().size());

    }

    @Test
    void deleteWithWrongId() {

        Pet pet = Pet.builder().id(5L).build();

        petMapService.delete(pet);

        Assertions.assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        Pet pet = Pet.builder().build();

        petMapService.delete(pet);

        Assertions.assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        petMapService.delete(null);

        Assertions.assertEquals(1, petMapService.findAll().size());

    }

    @Test
    void deleteByIdCorrectId() {

        petMapService.deleteById(petId);

        Assertions.assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        petMapService.deleteById(5L);

        Assertions.assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        petMapService.deleteById(null);

        Assertions.assertEquals(1, petMapService.findAll().size());
    }
}
