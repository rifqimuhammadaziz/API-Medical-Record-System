package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.MedicalRecord;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patient")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    // Medical Record of Patient
    @PostMapping("/{id}/medical-record")
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.createMedicalRecord(medicalRecord);
    }

    @GetMapping
    public List<MedicalRecord> findAllMedicalRecords() {
        return medicalRecordService.findAllMedicalRecords();
    }

    @GetMapping("/{id}")
    public MedicalRecord findSingleMedicalRecord(@PathVariable("id") String id) {
        return medicalRecordService.findSingleMedicalRecord(id);
    }

    @PutMapping
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.updateMedicalRecord(medicalRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalRecordByID(@PathVariable("id") String id) {
        medicalRecordService.deleteMedicalRecordByID(id);
    }
}
