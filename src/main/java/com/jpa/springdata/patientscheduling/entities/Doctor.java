package com.jpa.springdata.patientscheduling.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String speciality;

    @ManyToMany(mappedBy = "doctors")
    private Set<Patient> patients;


    @OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
    private Set<Appointment> appointment;

}
