package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.exception.ApiRequestException;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.PatientDTO;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.PatientRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.PatientService;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.mail.MailService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final MailService mailService;
    private final ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepository patientRepository, MailService mailService, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.mailService = mailService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Patient createPatient(PatientDTO patientDTO) {
        // thr with message "ID: ... is taken"
//        boolean patientExists = patientRepository.existsById(patientDTO.getIdNumber());

        // Convert DTO to Entity
        Patient patient = mapToEntity(patientDTO);

        // Send Email After Create Patient
        mailService.sendMailCreatePatient(patientDTO);

        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findSinglePatientByID(String id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Not found"));
        return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleteSinglePatientByID(String id) {
        patientRepository.deleteById(id);
    }

    private PatientDTO mapToDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

    private Patient mapToEntity(PatientDTO patientDTO) {
        return modelMapper.map(patientDTO, Patient.class);
    }
}
