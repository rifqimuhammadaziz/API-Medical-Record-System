package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Doctor;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.DoctorService;
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
@RequestMapping("/api/doctors")
@Tag(name = "Doctor Controller", description = "Controller for doctor resources")
public class DoctorController {

    private final DoctorService doctorService;

    @Operation(summary = "Save Doctor", description = "API for save of doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success insert doctor to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed insert doctor to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PostMapping()
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        log.info("[{}][REQUEST RECEIVED][{}]", doctor.getId(), doctor.getDoctorName());
        return doctorService.createDoctor(doctor);
    }

    @Operation(summary = "Get All Doctors", description = "API for fetch all doctor from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success get all doctors from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed get all doctors from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @GetMapping()
    public List<Doctor> findAllDoctors() {
        log.info("[REQUEST DATA RECEIVED]");
        return doctorService.findAllDoctors();
    }

    @Operation(summary = "Get Single Doctor By ID", description = "API for get single doctor by ID from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success get doctor from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed get doctor from database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{id}")
    public Doctor findSingleDoctorByID(@PathVariable("id") String id) {
        log.info("[{}][REQUEST DATA RECEIVED", id);
        return doctorService.findSingleDoctorByID(id);
    }

    @Operation(summary = "Update Doctor", description = "API for update doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success update doctor to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed update doctor to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @PutMapping()
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        log.info("[{}][REQUEST UPDATE RECEIVED][{}]", doctor.getId(), doctor.getDoctorName());
        return doctorService.updateDoctor(doctor);
    }

    @Operation(summary = "Delete Doctor By ID", description = "API for delete single doctor by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2xx", description = "Success insert doctor to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4xx", description = "Failed insert doctor to database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "5xx", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/{id}")
    public void deleteDoctorByID(@PathVariable("id") String id) {
        doctorService.deleteSingleDoctorByID(id);
        log.info("[{}][REQUEST DELETE RECEIVED]", id);
    }
}
