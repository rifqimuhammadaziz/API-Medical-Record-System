package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Consultation;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.ConsultationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;

    @PostMapping
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationService.createConsultation(consultation);
    }

    @GetMapping
    public List<Consultation> findAllConsultations() {
        return consultationService.findAllConsultations();
    }

    @GetMapping("/{id}")
    public Consultation findSingleConsultation(@PathVariable("id") String id) {
        return consultationService.findSingleConsultation(id);
    }

    @PutMapping
    public Consultation updateConsultation(@RequestBody Consultation consultation) {
        return consultationService.updateConsultation(consultation);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultationByID(@PathVariable("id") String id) {
        consultationService.deleteConsultationByID(id);
    }
}
