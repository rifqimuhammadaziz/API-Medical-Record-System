package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Medicine;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.MedicineRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Override
    public Medicine createMedicine(Medicine medicine) {
        medicine.setId(UUID.randomUUID().toString());
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> findAllMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine findSingleMedicineByID(String id) {
        return medicineRepository.findById(id).get();
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicineByID(String id) {
        medicineRepository.deleteById(id);
    }
}
