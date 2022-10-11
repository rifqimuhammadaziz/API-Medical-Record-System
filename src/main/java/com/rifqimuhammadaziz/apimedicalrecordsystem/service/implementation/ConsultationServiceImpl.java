package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Consultation;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.ConsultationRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.ConsultationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;

    @Override
    public Consultation createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation findSingleConsultation(String id) {
        return consultationRepository.findById(id).get();
    }

    @Override
    public Consultation updateConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public void deleteConsultationByID(String id) {
        consultationRepository.deleteById(id);
    }
}
