package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Operation(summary = "Save Patient", description = "API for save of patient")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success insert patient to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed insert patient to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @PostMapping()
    public Patient createPatient(@RequestBody @Valid Patient patient) {
        return patientService.createPatient(patient);
    }

    @Operation(summary = "Get All Patients", description = "API for fetch all patient from database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success get all patients from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed get all patients from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @GetMapping()
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }

    @Operation(summary = "Get Single Patient By ID", description = "API for get single patient by ID from database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success get patient from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed get patient from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Patient> findSinglePatientByID(@PathVariable("id") String id) {
        return ResponseEntity.ok(patientService.findSinglePatientByID(id));
    }

    @Operation(summary = "Update Patient", description = "API for update patient")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success update patient to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed update patient to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @PutMapping()
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @Operation(summary = "Delete Patient By ID", description = "API for delete single patient by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success insert patient to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed insert patient to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @DeleteMapping("/{id}")
    public void deleteSinglePatientByID(@PathVariable("id") String id) {
        patientService.deleteSinglePatientByID(id);
    }

}
