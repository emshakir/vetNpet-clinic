package com.ccube.vetnpetclinic.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PET_TYPE")
public class PetType extends BaseEntity {

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "NAME")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
