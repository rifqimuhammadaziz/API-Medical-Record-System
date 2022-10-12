package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Schedule;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // Create Schedule of Patient
    @PostMapping("/patients/{patientId}/schedules")
    public Schedule createSchedule(@PathVariable("patientId") String patientId,
                                   @RequestBody Schedule schedule) {
        return scheduleService.createSchedule(patientId, schedule);
    }

    // Find All Schedules (All Patient)
    @GetMapping("/schedules")
    public List<Schedule> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }

    // Find All Schedules (Single Patient)
    @GetMapping("/patients/{patientId}/schedules")
    public List<Schedule> findAllSchedulesByPatient(@PathVariable String patientId) {
        return scheduleService.findAllSchedulesByPatient(patientId);
    }

    // Find Single Schedule By Schedule ID
    @GetMapping("/patients/{patientId}/schedules/{scheduleId}")
    public Schedule findSingleSchedule(@PathVariable("scheduleId") String scheduleId) {
        return scheduleService.findSingleSchedule(scheduleId);
    }

    // Update Schedule By Patient
    @PutMapping("/patients/{patientId}/schedules")
    public Schedule updateSchedule(@RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(schedule);
    }

    // Delete Schedule
    @DeleteMapping("/schedules/{id}")
    public void deleteScheduleByID(@PathVariable("id") String id) {
        scheduleService.deleteScheduleByID(id);
    }

}
