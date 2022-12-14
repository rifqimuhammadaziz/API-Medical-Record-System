package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.PatientDTO;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
@Tag(name = "Patient Controller", description = "Controller for patient resources")
public class PatientController {

    private final PatientService patientService;

    @Operation(summary = "Save Patient", description = "API for save of patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success insert patient to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed insert patient to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PostMapping()
    public Patient createPatient(@RequestBody @Valid PatientDTO patientDTO) {
        log.info("[{}][REQUEST RECEIVED][{}]", patientDTO.getIdNumber(), patientDTO.getFullName());
        return patientService.createPatient(patientDTO);
    }

    @Operation(summary = "Get All Patients", description = "API for fetch all patient from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success get all patients from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed get all patients from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @GetMapping()
    public List<Patient> findAllPatients() {
        log.info("[][DATA PATIENT RECEIVED]");
        return patientService.findAllPatients();
    }

    @Operation(summary = "Get Single Patient By ID", description = "API for get single patient by ID from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success get patient from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed get patient from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Patient> findSinglePatientByID(@PathVariable("id") String id) {
        log.info("[{}][DATA PATIENT RECEIVED]", id);
        return ResponseEntity.ok(patientService.findSinglePatientByID(id));
    }

    @Operation(summary = "Update Patient", description = "API for update patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success update patient to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed update patient to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PutMapping()
    public Patient updatePatient(@RequestBody Patient patient) {
        log.info("[{}][DATA PATIENT UPDATED][{}]", patient.getIdNumber(), patient.getFullName());
        return patientService.updatePatient(patient);
    }

    @Operation(summary = "Delete Patient By ID", description = "API for delete single patient by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success insert patient to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed insert patient to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/{id}")
    public void deleteSinglePatientByID(@PathVariable("id") String id) {
        patientService.deleteSinglePatientByID(id);
        log.info("[{}][DATA PATIENT DELETED SUCCESSFULLY]", id);
    }

}
