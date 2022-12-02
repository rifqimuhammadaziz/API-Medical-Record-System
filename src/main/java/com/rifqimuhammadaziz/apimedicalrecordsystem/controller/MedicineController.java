package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Medicine;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.MedicineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/medicines")
@Tag(name = "Medicine Controller", description = "Controller for medicine resources")
public class MedicineController {

    private final MedicineService medicineService;

    @Operation(summary = "Save Medicine", description = "API for save medicine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success insert medicine to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed insert medicine to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }

    @Operation(summary = "Get All Medicines", description = "API for fetch all medicines from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success get all medicines from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed get all medicines from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @GetMapping
    public List<Medicine> findAllMedicines() {
        return medicineService.findAllMedicines();
    }

    @Operation(summary = "Get Single Medicine By ID", description = "API for get single medicine by ID from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success get medicine from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed get medicine from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{id}")
    public Medicine findSingleMedicineByID(@PathVariable("id") String id) {
        return medicineService.findSingleMedicineByID(id);
    }

    @Operation(summary = "Update Medicine", description = "API for update medicine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success update medicine to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed update medicine to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PutMapping
    public Medicine updateMedicine(@RequestBody Medicine medicine) {
        return medicineService.updateMedicine(medicine);
    }

    @Operation(summary = "Delete Medicine By ID", description = "API for delete single medicine by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success insert medicine to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed insert medicine to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/{id}")
    public void deleteMedicineByID(@PathVariable String id) {
        medicineService.deleteMedicineByID(id);
    }
}
