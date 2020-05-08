package com.jpa.springdata.patientscheduling;

import com.jpa.springdata.patientscheduling.entities.Appointment;
import com.jpa.springdata.patientscheduling.entities.Doctor;
import com.jpa.springdata.patientscheduling.entities.Insurance;
import com.jpa.springdata.patientscheduling.entities.Patient;
import com.jpa.springdata.patientscheduling.repositories.AppointmentRepository;
import com.jpa.springdata.patientscheduling.repositories.DoctorRepository;
import com.jpa.springdata.patientscheduling.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class PatientSchedulingApplicationTests {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    public void testCreateDoctor() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Ibrahim");
        doctor.setLastName("Mohsen");
        doctor.setSpeciality("All");
        doctorRepository.save(doctor);
    }

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient();
        patient.setFirstName("Hassen");
        patient.setLastName("Maohamed");
        patient.setPhone("12345664");

        Insurance insurance = new Insurance();
        insurance.setProviderName("Blue Cross");
        insurance.setCopay(20d);

        patient.setInsurance(insurance);

        Doctor doctor = doctorRepository.findById(1L).get();
        patient.addDoctor(doctor);

        patientRepository.save(patient);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = new Appointment();

        Timestamp appointmentTime = new Timestamp(new Date().getTime());
        appointment.setAppointmentTime(appointmentTime);
        appointment.setReason("I have a problem");
        appointment.setStarted(true);
        appointment.setEnded(false);

        appointment.setPatient(patientRepository.findById(6L).get());
        appointment.setDoctor(doctorRepository.findById(1L).get());

        appointmentRepository.save(appointment);

    }

}
