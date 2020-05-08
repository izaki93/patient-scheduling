package com.jpa.springdata.patientscheduling.repositories;

import com.jpa.springdata.patientscheduling.entities.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
