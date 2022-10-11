package com.rifqimuhammadaziz.apimedicalrecordsystem.repository;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
