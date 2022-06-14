package com.ccube.vetnpetclinic.springdatajpa;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaTest {

    public static final String LAST_NAME = "smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpa service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findOwnerByLastName() {
        when(ownerRepository.findOwnerByLastName(any())).thenReturn(returnOwner);
        Owner owner = ownerRepository.findOwnerByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findOwnerByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> returnedOwners = service.findAll();
        assertEquals(2, service.findAll().size());
        verify(ownerRepository, times(2)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(returnOwner.getId());
        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(2L).lastName("Shakir").build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        assertNotNull(service.save(ownerToSave));
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnOwner.getId());
        verify(ownerRepository).deleteById(anyLong());
    }
}