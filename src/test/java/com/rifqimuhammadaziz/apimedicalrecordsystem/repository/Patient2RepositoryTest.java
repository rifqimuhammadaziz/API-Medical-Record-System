package com.rifqimuhammadaziz.apimedicalrecordsystem.repository;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;

// Using H2 Database
@DataJpaTest
public class Patient2RepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    // after each test, data will be deleted
    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
    }

    @Test
    void itShouldCheckIfPatientNameExists() {
        // give
        Patient patient = new Patient(
                "IDTEST001",
                "Rifqi Muhammad Aziz",
                Date.valueOf("1999-05-21"),
                23,
                "MALE",
                "0",
                "Islam",
                "Tegal, Jawa Tengah",
                "WNI"
        );
        patientRepository.save(patient);

        // when
        boolean exists = patientRepository.existsByFullName(patient.getFullName());

        // then
        Assertions.assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckIfPatientNameNotExists() {
        // give
        String name = "Rifqi Muhammad Aziz";

        // when
        boolean exists = patientRepository.existsByFullName(name);

        // then
        Assertions.assertThat(exists).isFalse();
    }
}
