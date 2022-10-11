package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.GivenMedicine;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.GivenMedicineRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.GivenMedicineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GivenMedicineServiceImpl implements GivenMedicineService {

    private final GivenMedicineRepository givenMedicineRepository;

    @Override
    public GivenMedicine createGivenMedicine(GivenMedicine givenMedicine) {
        return givenMedicineRepository.save(givenMedicine);
    }

    @Override
    public List<GivenMedicine> findAllGivenMedicines() {
        return givenMedicineRepository.findAll();
    }

    @Override
    public GivenMedicine findSingleGivenMedicine(String id) {
        return givenMedicineRepository.findById(id).get();
    }

    @Override
    public GivenMedicine updateGivenMedicine(GivenMedicine givenMedicine) {
        return givenMedicineRepository.save(givenMedicine);
    }

    @Override
    public void deleteGivenMedicineByID(String id) {
        givenMedicineRepository.deleteById(id);
    }
}
