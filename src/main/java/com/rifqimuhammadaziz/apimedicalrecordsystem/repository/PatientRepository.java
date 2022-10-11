package com.rifqimuhammadaziz.apimedicalrecordsystem.repository;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
