package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Patient;
import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Schedule;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.PatientRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.ScheduleRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final PatientRepository patientRepository;

    @Override
    public Schedule createSchedule(String patientId, Schedule schedule) {
        // Find Patient By ID
        Patient patient = patientRepository.findById(patientId).get();

        schedule.setId(UUID.randomUUID().toString());
        schedule.setPatient(patient);
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findSingleSchedule(String id) {
        return scheduleRepository.findById(id).get();
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        // Find Schedule By ID
        Schedule currentSchedule = scheduleRepository.findById(schedule.getId()).get();

        currentSchedule.setScheduleDate(schedule.getScheduleDate());
        currentSchedule.setScheduleStatus(schedule.getScheduleStatus());

        return scheduleRepository.save(currentSchedule);
    }

    @Override
    public void deleteScheduleByID(String id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> findAllSchedulesByPatient(String patientId) {
        return scheduleRepository.findSchedulesByPatientIdNumber(patientId);
    }
}
