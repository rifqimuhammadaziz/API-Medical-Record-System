package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Doctor;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping()
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping()
    public List<Doctor> findAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor findSingleDoctorByID(@PathVariable("id") String id) {
        return doctorService.findSingleDoctorByID(id);
    }

    @PutMapping()
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorByID(@PathVariable("id") String id) {
        doctorService.deleteSingleDoctorByID(id);
    }
}
