package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.PatientRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findSinglePatientByID(String id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleteSinglePatientByID(String id) {
        patientRepository.deleteById(id);
    }
}
