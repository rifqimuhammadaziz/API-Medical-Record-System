package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    private String id;
    private String patientID;
    private String billTo;
    private Double billAmount;
    private Date dateRecorded;

}
