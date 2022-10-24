package com.rifqimuhammadaziz.apimedicalrecordsystem.service;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.PatientRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.PatientService;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation.PatientServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock private PatientRepository patientRepository;
    private PatientService patientService;

    // executed before each test
    @BeforeEach
    void setUp() {
        patientService = new PatientServiceImpl(patientRepository);
    }

    @Test
    void addPatient() {
        // given
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

        // when
        patientService.createPatient(patient);

        // then
        ArgumentCaptor<Patient> patientArgumentCaptor = ArgumentCaptor.forClass(Patient.class);

        // capture the actual patient that was passed inside the save repo method (value of argument, is patient)
        Mockito.verify(patientRepository).save(patientArgumentCaptor.capture());

        // check
        Patient capturedPatient = patientArgumentCaptor.getValue();
        Assertions.assertThat(capturedPatient).isEqualTo(patient);
    }

    @Test
    void willThrowExceptionWhenIdIsTaken() {
        // given
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

        given(patientRepository.existsByIdNumber(patient.getIdNumber()))
                .willReturn(true);

        // when
        // then
        Assertions.assertThatThrownBy(() -> patientService.createPatient(patient))
//                .isInstanceOf("name of exception handler")
                .hasMessageContaining("ID: " + patient.getIdNumber() + " is taken"); // message is same in service

        // never save any patient
        verify(patientRepository, never()).save(any());
    }

    @Test
    void canGetAllPatients() {
        // when
        patientService.findAllPatients();

        // then
        Mockito.verify(patientRepository).findAll();
    }

    @Test
    @Disabled
    void deletePatient() {

    }

}