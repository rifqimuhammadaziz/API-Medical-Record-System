package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @NotNull(message = "ID Number is required")
    @NotBlank(message = "ID Number is Blank")
    private String idNumber;

    @NotBlank(message = "Name is required")
    private String fullName;

    private Date birthdate;

    private int age;

    @NotNull
    private String gender;

    private String bloodGroup;
    private String religion;
    private String address;
    private String citizenship;

}
