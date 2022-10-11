package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Doctor;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.DoctorRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        doctor.setId(UUID.randomUUID().toString());
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findSingleDoctorByID(String id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteSingleDoctorByID(String id) {
        doctorRepository.deleteById(id);
    }
}
