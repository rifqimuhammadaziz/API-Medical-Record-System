package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "medicines",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"medicineName"})}
)
public class Medicine {

    @Id
    private String id;
    private String medicineName;
    private String purpose;
    private int initialQty;
    private Date dateDelivered;
}
