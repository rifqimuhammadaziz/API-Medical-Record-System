package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Doctor;
import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;

import java.util.List;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    List<Doctor> findAllDoctors();
    Doctor findSingleDoctorByID(String id);
    Doctor updateDoctor(Doctor doctor);
    void deleteSingleDoctorByID(String id);
}
