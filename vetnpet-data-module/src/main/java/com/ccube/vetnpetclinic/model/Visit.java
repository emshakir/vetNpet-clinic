package com.ccube.vetnpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
