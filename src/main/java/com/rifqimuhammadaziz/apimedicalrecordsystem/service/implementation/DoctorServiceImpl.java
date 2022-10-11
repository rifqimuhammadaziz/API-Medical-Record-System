package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Doctor;
import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.DoctorRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
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
