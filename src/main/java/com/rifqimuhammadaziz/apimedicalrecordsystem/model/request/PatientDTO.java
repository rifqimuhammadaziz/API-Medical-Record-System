package com.rifqimuhammadaziz.apimedicalrecordsystem.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PatientDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("id_number")
    private String idNumber;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("birthdate")
    private Date birthdate;

    @JsonProperty("age")
    private int age;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("blood_group")
    private String bloodGroup;

    @JsonProperty("religion")
    private String religion;

    @JsonProperty("address")
    private String address;

    @JsonProperty("citizenship")
    private String citizenship;
}
