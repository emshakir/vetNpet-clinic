package com.ccube.vetnpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
