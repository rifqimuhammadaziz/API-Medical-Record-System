package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation createConsultation(Consultation consultation);
    List<Consultation> findAllConsultations();
    Consultation findSingleConsultation(String id);
    Consultation updateConsultation(Consultation consultation);
    void deleteConsultationByID(String id);
}
