package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "doctors",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"doctorRecordNumber"})}
)
public class Doctor {

    @Id
    private String id;
    private String doctorRecordNumber;
    private String doctorName;
    private String address;
    private String contact;
    private String fieldOfSpecialization;

}
