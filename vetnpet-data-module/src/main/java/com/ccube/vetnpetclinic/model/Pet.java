package com.ccube.vetnpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PET")
public class Pet extends BaseEntity {

    @Column(name = "PET_NAME")
    private String petName;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.petName = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;

        if (visits == null || visits.size() > 0 ) {
            this.visits = visits;
        }
    }

}
