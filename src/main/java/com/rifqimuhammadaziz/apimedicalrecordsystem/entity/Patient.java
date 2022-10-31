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
    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "religion")
    private String religion;

    @Column(name = "address")
    private String address;

    @Column(name = "citizenship")
    private String citizenship;

}
