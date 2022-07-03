package com.ccube.vetnpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "OWNER")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> setOfPets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if (setOfPets != null) {
            this.setOfPets = setOfPets;
        }
    }

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "TELEPHONE")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> setOfPets = new HashSet<>();

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : setOfPets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getPetName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }
}
