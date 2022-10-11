package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.GivenMedicine;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.GivenMedicineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/given-medicine")
public class GivenMedicineController {

    private final GivenMedicineService givenMedicineService;

    @PostMapping
    public GivenMedicine createGivenMedicine(@RequestBody GivenMedicine givenMedicine) {
        return givenMedicineService.createGivenMedicine(givenMedicine);
    }

    @GetMapping
    public List<GivenMedicine> findAllGivenMedicines() {
        return givenMedicineService.findAllGivenMedicines();
    }

    @GetMapping("/{id}")
    public GivenMedicine findSingleGivenMedicine(@PathVariable("id") String id) {
        return givenMedicineService.findSingleGivenMedicine(id);
    }

    @PutMapping
    public GivenMedicine updateGivenMedicine(@RequestBody GivenMedicine givenMedicine) {
        return givenMedicineService.updateGivenMedicine(givenMedicine);
    }

    @DeleteMapping("/{id}")
    public void deleteGivenMedicineByID(@PathVariable("id") String id) {
        givenMedicineService.deleteGivenMedicineByID(id);
    }
}
