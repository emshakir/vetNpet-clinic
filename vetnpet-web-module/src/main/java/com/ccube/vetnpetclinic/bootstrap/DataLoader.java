package com.ccube.vetnpetclinic.bootstrap;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.service.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.time.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catPetType = petTypeService.save(cat);

        Speciality radilogy = new Speciality();
        radilogy.setDescription("Radiology");
        Speciality savedSpecialityRadilogy = specialityService.save(radilogy);

        Speciality surgery = new Speciality();
        surgery.setDescription("SURGERY");
        Speciality savedSurgerySpeciality = specialityService.save(radilogy);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("DENTISTRY");
        Speciality savedDenSpeciality = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Kalvagadda");
        owner1.setLastName("Chandrashekar");
        owner1.setAddress("Allapur");
        owner1.setCity("Hyderabad");
        owner1.setTelephone("8500331340");

        Pet mikesPet = new Pet();
        mikesPet.setPetName("Garuda");
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setPetType(dogPetType);
        mikesPet.setOwner(owner1);
        owner1.getSetOfPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dasari");
        owner2.setLastName("Anil");
        owner2.setAddress("Bowenpally");
        owner2.setCity("Hyderabad");
        owner2.setTelephone("7304456852");

        Pet katesPet = new Pet();
        katesPet.setPetName("Viking");
        katesPet.setBirthDate(LocalDate.now());
        katesPet.setPetType(catPetType);
        katesPet.setOwner(owner2);
        owner2.getSetOfPets().add(katesPet);
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Satish");
        owner3.setLastName("Singh");
        owner3.setAddress("Durgam Cheruvu");
        owner3.setCity("Hyderabad");
        owner3.setTelephone("8104567412");

        ownerService.save(owner3);

        System.out.println("Owners Loaded:::::::::");

        Vet vet1 = new Vet();
        vet1.setFirstName("Banaram");
        vet1.setLastName("Charan");
        vet1.getSpecialities().add(radilogy);

        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Krishna");
        vet2.setLastName("Naik");
        vet2.getSpecialities().add(dentistry);
        vetService.save(vet2);
        System.out.println("Vet Loaded:::::::::");
    }
}
