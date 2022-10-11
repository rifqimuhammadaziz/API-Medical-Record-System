package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
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
