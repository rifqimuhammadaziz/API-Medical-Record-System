package com.rifqimuhammadaziz.apimedicalrecordsystem.repository;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.enums.Gender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    // Test for save patient
    @Test
    public void savePatientTest() {
        Patient patient = Patient.builder()
                .idNumber("000001")
                .fullName("Test Repository")
                .birthdate(Date.valueOf("1999-05-22"))
                .age(23)
                .gender("MALE")
                .bloodGroup("O")
                .religion("Islam")
                .address("Tegal, Jawa Tengah")
                .citizenship("WNI")
                .build();

        patientRepository.save(patient);
        Assertions.assertThat(patient.getIdNumber()).isGreaterThan(String.valueOf(0));
    }

    @Test
    public void getPatientTest() {
        Patient patient = patientRepository.findById("001").get();
        Assertions.assertThat(patient.getIdNumber()).isEqualTo("001");
    }

    @Test
    public void getListOfPatients() {
        List<Patient> patients = patientRepository.findAll();
        Assertions.assertThat(patients.size()).isGreaterThan(0);
    }

    @Test
    public void updatePatientTest() {
        Patient patient = patientRepository.findById("001").get();
        patient.setFullName("Updated Name");

        Patient patientUpdated = patientRepository.save(patient);
        Assertions.assertThat(patientUpdated.getFullName()).isEqualTo("Updated Name");
    }

    @Test
    public void deletePatientTest() {
        Patient patient = patientRepository.findById("001").get();
        patientRepository.delete(patient);

        Patient patient1 = null;
        Optional<Patient> optionalPatient = patientRepository.findByFullName("Test Full Name");
        if (optionalPatient.isPresent()) {
            patient1 = optionalPatient.get();
        }

        Assertions.assertThat(patient1).isNull();
    }
}