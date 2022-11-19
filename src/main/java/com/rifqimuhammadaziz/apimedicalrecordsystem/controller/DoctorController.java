package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Doctor;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Operation(summary = "Save Doctor", description = "API for save of doctor")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success insert doctor to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed insert doctor to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @PostMapping()
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @Operation(summary = "Get All Doctors", description = "API for save of doctor")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success get all doctors from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed get all doctors from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @GetMapping()
    public List<Doctor> findAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @Operation(summary = "Get Single Doctor By ID", description = "API for get single doctor by ID from database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success get doctor from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed get doctor from database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @GetMapping("/{id}")
    public Doctor findSingleDoctorByID(@PathVariable("id") String id) {
        return doctorService.findSingleDoctorByID(id);
    }

    @Operation(summary = "Update Doctor", description = "API for update doctor")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success update doctor to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed update doctor to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @PutMapping()
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor);
    }

    @Operation(summary = "Delete Doctor By ID", description = "API for delete single doctor by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success insert doctor to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed insert doctor to database",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @DeleteMapping("/{id}")
    public void deleteDoctorByID(@PathVariable("id") String id) {
        doctorService.deleteSingleDoctorByID(id);
    }
}
