package com.ccube.vetnpetclinic.model;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "VISITS")
public class Visit extends BaseEntity {

    @Column(name = "LOCAL_DATE")
    private LocalDate localDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
