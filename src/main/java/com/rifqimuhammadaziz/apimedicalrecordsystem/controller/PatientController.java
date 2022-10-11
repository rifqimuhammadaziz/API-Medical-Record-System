package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping()
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping()
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping("/{id}")
    public Patient findSinglePatientByID(@PathVariable("id") String id) {
        return patientService.findSinglePatientByID(id);
    }

    @PutMapping()
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deleteSinglePatientByID(@PathVariable("id") String id) {
        patientService.deleteSinglePatientByID(id);
    }

}
