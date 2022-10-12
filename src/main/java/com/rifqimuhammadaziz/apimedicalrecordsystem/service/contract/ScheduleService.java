package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule createSchedule(String patientId, Schedule schedule);
    List<Schedule> findAllSchedules();
    Schedule findSingleSchedule(String id);
    Schedule updateSchedule(Schedule schedule);
    void deleteScheduleByID(String id);

    List<Schedule> findAllSchedulesByPatient(String patientId);

}
