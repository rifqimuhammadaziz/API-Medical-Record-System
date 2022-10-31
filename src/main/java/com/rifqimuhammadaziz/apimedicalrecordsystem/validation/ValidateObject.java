package com.rifqimuhammadaziz.apimedicalrecordsystem.validation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.PatientDTO;

import java.util.HashMap;
import java.util.Map;

public class ValidateObject {

    public static Map<String, String> validatePatient(PatientDTO dto) {
        Map<String, String> errors = new HashMap<>();

        // ID NUMBER
        errors.putAll(ValidateUtils.builder()
                .fieldName("idNumber")
                .value(dto.getIdNumber())
                .required(true)
                .maxLength(16)
                .build().validate());

        // FULL NAME
        errors.putAll(ValidateUtils.builder()
                .fieldName("fullName")
                .required(true)
                .maxLength(150)
                .build().validate());

        // DATE
        errors.putAll(ValidateUtils.builder()
                .fieldName("birthdate")
                .value(dto.getBirthdate())
                .required(true)
                .isDate(true)
                .build().validate());

        // AGE
        errors.putAll(ValidateUtils.builder()
                .fieldName("age")
                .value(dto.getAge())
                .required(false)
                .isInteger(true)
                .build().validate());

        // GENDER
        errors.putAll(ValidateUtils.builder()
                .fieldName("gender")
                .value(dto.getGender())
                .required(true)
                .maxLength(7)
                .build().validate());

        // BLOOD GROUP
        errors.putAll(ValidateUtils.builder()
                .fieldName("bloodGroup")
                .value(dto.getBloodGroup())
                .required(false)
                .build().validate());

        // RELIGION
        errors.putAll(ValidateUtils.builder()
                .fieldName("religion")
                .value(dto.getReligion())
                .required(false)
                .build().validate());

        // ADDRESS
        errors.putAll(ValidateUtils.builder()
                .fieldName("address")
                .value(dto.getAddress())
                .required(true)
                .build().validate());

        // CITIZENSHIP
        errors.putAll(ValidateUtils.builder()
                .fieldName("citizenship")
                .value(dto.getCitizenship())
                .required(true)
                .build().validate());

        return errors;
    }
}
