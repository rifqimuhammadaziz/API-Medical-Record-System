package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.PatientDTO;

import java.util.List;

public interface PatientService {
    Patient createPatient(PatientDTO patientDTO);
    List<Patient> findAllPatients();
    Patient findSinglePatientByID(String id);
    Patient updatePatient(Patient patient);
    void deleteSinglePatientByID(String id);
}
