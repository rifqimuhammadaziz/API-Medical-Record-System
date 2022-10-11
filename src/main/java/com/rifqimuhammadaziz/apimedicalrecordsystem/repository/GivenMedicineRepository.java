package com.rifqimuhammadaziz.apimedicalrecordsystem.repository;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.GivenMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GivenMedicineRepository extends JpaRepository<GivenMedicine, String> {
}
