package com.ccube.vetnpetclinic.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PET_TYPE")
public class PetType extends BaseEntity {

    @Column(name = "NAME")
    private String name;

}
