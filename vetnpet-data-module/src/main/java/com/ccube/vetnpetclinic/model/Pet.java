package com.ccube.vetnpetclinic.model;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "PET")
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @Column(name = "LOCAL_DATE")
    private LocalDate localDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
