package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Schedule;
import com.example.demo.Services.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;


    @RequestMapping("/getAllSchedules")
    public String getAll(Model model){
        List<Schedule> schedules = scheduleService.getAll();

        int maxId = schedules.get(0).getGymId();

        for(int i =0; i< schedules.size(); i++){
            if(maxId < schedules.get(i).getGymId()){
                maxId = schedules.get(i).getGymId();
            }
        }

        model.addAttribute("newID", maxId +1);
        model.addAttribute("schedules", schedules);
        return "schedule";
    }
    @PostMapping("/addNew")
    public String addNew(Schedule schedule){
        scheduleService.addNew(schedule);
        return "redirect:/schedule/getAllSchedules";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Schedule schedule){
        scheduleService.update(schedule);
        return "redirect:/schedule/getAllSchedules";
    }

    @RequestMapping("/getOne")
    public Optional<Schedule> getOne(Integer gymId){
        return scheduleService.getOne(gymId);
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer gymId){
        scheduleService.delete(gymId);
        return "redirect:/schedule/getAllSchedule";
    }	


	
}
