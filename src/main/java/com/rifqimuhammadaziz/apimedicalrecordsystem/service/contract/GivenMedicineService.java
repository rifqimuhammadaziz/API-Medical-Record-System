package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.GivenMedicine;

import java.util.List;

public interface GivenMedicineService {
    GivenMedicine createGivenMedicine(GivenMedicine givenMedicine);
    List<GivenMedicine> findAllGivenMedicines();
    GivenMedicine findSingleGivenMedicine(String id);
    GivenMedicine updateGivenMedicine(GivenMedicine givenMedicine);
    void deleteGivenMedicineByID(String id);
}
