package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "given_medicines")
public class GivenMedicine {

    @Id
    private String id;
    private String consultationID;
    private String medicineID;
    private String amount;
    private String notes;

}
