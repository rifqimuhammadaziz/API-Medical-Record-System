package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Medicine;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }

    @GetMapping
    public List<Medicine> findAllMedicines() {
        return medicineService.findAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine findSingleMedicineByID(@PathVariable("id") String id) {
        return medicineService.findSingleMedicineByID(id);
    }

    @PutMapping
    public Medicine updateMedicine(@RequestBody Medicine medicine) {
        return medicineService.updateMedicine(medicine);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicineByID(@PathVariable String id) {
        medicineService.deleteMedicineByID(id);
    }
}
