package com.jpa.springdata.patientscheduling.repositories;

import com.jpa.springdata.patientscheduling.entities.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
