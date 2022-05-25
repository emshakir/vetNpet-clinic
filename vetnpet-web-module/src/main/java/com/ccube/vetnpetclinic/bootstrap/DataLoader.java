package com.ccube.vetnpetclinic.bootstrap;

import com.ccube.vetnpetclinic.model.*;
import com.ccube.vetnpetclinic.service.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Kalvagadda");
        owner1.setLastName("Chandrashekar");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dasari");
        owner2.setLastName("Anil");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Satish");
        owner3.setLastName("Singh");
        ownerService.save(owner3);

        System.out.println("Owners Loaded:::::::::");

        Vet vet1 = new Vet();
        vet1.setFirstName("Banaram");
        vet1.setLastName("Charan");

        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Krishna");
        vet2.setLastName("Naik");
        vetService.save(vet2);
        System.out.println("Vet Loaded:::::::::");
    }
}
