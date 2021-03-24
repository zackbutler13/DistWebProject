package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Schedule;
import com.example.demo.Repositories.ScheduleRepository;

@Service
public class ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAll(){
        return (List<Schedule>) scheduleRepository.findAll();
    }

    public void addNew(Schedule schedule){
        scheduleRepository.save(schedule);
    }

    public void update(Schedule schedule){
        scheduleRepository.save(schedule);
    }

    public Optional<Schedule> getOne(Integer scheduleId){
        return scheduleRepository.findById(scheduleId);
    }

    public void delete(Integer scheduleId){
        scheduleRepository.deleteById(scheduleId);
    }
}