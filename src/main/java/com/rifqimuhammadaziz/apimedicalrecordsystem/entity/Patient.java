package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
//    @NotNull(message = "ID Number is required")
//    @NotBlank(message = "ID Number is Blank")
    private String idNumber;

//    @NotBlank(message = "Name is required")
    private String fullName;

    private Date birthdate;

    private int age;
    private String gender;
    private String bloodGroup;
    private String religion;
    private String address;
    private String citizenship;

}
