package com.rifqimuhammadaziz.apimedicalrecordsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ApiMedicalRecordSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMedicalRecordSystemApplication.class, args);
    }

}
