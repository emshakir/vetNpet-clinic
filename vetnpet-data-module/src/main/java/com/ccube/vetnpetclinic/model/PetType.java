package com.ccube.vetnpetclinic.model;

import javax.persistence.*;

@Entity
@Table(name = "PET_TYPE")
public class PetType extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
