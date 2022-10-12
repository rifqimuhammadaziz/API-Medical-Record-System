package com.rifqimuhammadaziz.apimedicalrecordsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    private String id;

    @JoinColumn
    @ManyToOne
    private Patient patient;
    private Date scheduleDate;
    private String scheduleStatus;

}
