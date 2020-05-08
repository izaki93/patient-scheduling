package com.jpa.springdata.patientscheduling.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    @Embedded
    private Insurance insurance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patients_doctors",
            joinColumns = {@JoinColumn(name = "patient_id",referencedColumnName = "id", nullable = false,
                    updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "doctor_id",referencedColumnName = "id", nullable = false,
                    updatable = false)})
    private Set<Doctor> doctors;

    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER)
    private Set<Appointment> appointment = new HashSet<>();

    public void addDoctor(Doctor doctor){
        if(doctor !=null){
            if(doctors == null) {
                doctors = new HashSet<>();
            }
            doctors.add(doctor);
        }
    }
}
