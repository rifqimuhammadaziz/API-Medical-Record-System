package com.rifqimuhammadaziz.apimedicalrecordsystem.repository;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    List<Schedule> findSchedulesByPatientIdNumber(String patientId);
    Schedule findScheduleByPatientIdNumber(String patientId);
}
