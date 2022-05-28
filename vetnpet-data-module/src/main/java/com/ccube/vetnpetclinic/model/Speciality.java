package com.ccube.vetnpetclinic.model;

import javax.persistence.*;

@Entity
@Table(name = "SPECIALITY")
public class Speciality extends BaseEntity {

    @Column(name = "DESCRIPTION")
    private String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
