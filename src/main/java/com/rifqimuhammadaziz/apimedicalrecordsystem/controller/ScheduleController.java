package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Schedule;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @GetMapping
    public List<Schedule> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }

    @GetMapping("/{id}")
    public Schedule findSingleSchedule(@PathVariable("id") String id) {
        return scheduleService.findSingleSchedule(id);
    }

    @PutMapping
    public Schedule updateSchedule(@RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduleByID(@PathVariable("id") String id) {
        scheduleService.deleteScheduleByID(id);
    }

}
