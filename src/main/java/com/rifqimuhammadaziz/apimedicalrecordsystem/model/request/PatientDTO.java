package com.rifqimuhammadaziz.apimedicalrecordsystem.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDTO {
    private String idNumber;
    private String fullName;
    private Date birthdate;
    private int age;
    private String gender;
    private String bloodGroup;
    private String religion;
    private String address;
    private String citizenship;
}
