package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine createMedicine(Medicine medicine);
    List<Medicine> findAllMedicines();
    Medicine findSingleMedicineByID(String id);
    Medicine updateMedicine(Medicine medicine);
    void deleteMedicineByID(String id);
}
