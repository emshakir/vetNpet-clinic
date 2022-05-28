package com.ccube.vetnpetclinic.model;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "VET")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "VET_SPECIALITY", joinColumns = @JoinColumn(name = "VET_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPECIALITY_ID"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
