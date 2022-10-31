package com.rifqimuhammadaziz.apimedicalrecordsystem.repository;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.custom.PatientRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, String>, PatientRepositoryCustom {
    Optional<Patient> findByFullName(String fullName);
    Boolean existsByIdNumber(String idNumber);
    Boolean existsByFullName(String fullName);

    // PAGING
    @Query("SELECT p FROM Patient p WHERE p.fullName LIKE %?1%")
    Page<Patient> findAllByNameLike(String name, Pageable pageable);
    Page<Patient> findAllByGender(String gender, Pageable pageable);
}
