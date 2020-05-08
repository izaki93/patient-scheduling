package com.jpa.springdata.patientscheduling.repositories;

import com.jpa.springdata.patientscheduling.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
