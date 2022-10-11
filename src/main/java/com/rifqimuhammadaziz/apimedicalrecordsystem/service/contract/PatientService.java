package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    List<Patient> findAllPatients();
    Patient findSinglePatientByID(String id);
    Patient updatePatient(Patient patient);
    void deleteSinglePatientByID(String id);
}
