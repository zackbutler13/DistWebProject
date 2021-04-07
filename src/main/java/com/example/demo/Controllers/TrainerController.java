package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Trainer;
import com.example.demo.Services.TrainerService;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;


        @RequestMapping("/getAllTrainers")
        public String getAll(Model model){
            List<Trainer> trainers = trainerService.getAll();

            int maxId = trainers.get(0).getTrainerId();

            for(int i =0; i< trainers.size(); i++){
                if(maxId < trainers.get(i).getTrainerId()){
                    maxId = trainers.get(i).getGymId();
                }
            }

            model.addAttribute("newID", maxId +1);
            model.addAttribute("trainers", trainers);
            return "trainer";
        }
        @PostMapping("/addNew")
        public String addNew(Trainer trainer){
            trainerService.addNew(trainer);
            return "redirect:/trainers/getAllTrainers";
        }

        @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
        public String update(Trainer trainer){
            trainerService.update(trainer);
            return "redirect:/trainers/getAllTrainers";
        }

        @RequestMapping("/getOne")
        public Optional<Trainer> getOne(Integer trainerId){
            return trainerService.getOne(trainerId);
        }

        @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
        public String delete(Integer trainerId){
            trainerService.delete(trainerId);
            return "redirect:/trainers/getAllTrainers";
        }	

}
