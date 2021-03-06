package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Gym;
import com.example.demo.Services.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gyms")
public class GymController {
        @Autowired
        private GymService gymService;


        //Gets all gyms from database
        @RequestMapping("/getAllGyms")
        public String getAll(Model model){
            List<Gym> gyms = gymService.getAll();

            int maxId = gyms.get(0).getGymId();

            for(int i =0; i< gyms.size(); i++){
                if(maxId < gyms.get(i).getGymId()){
                    maxId = gyms.get(i).getGymId();
                }
            }

            model.addAttribute("newID", maxId +1);
            model.addAttribute("gyms", gyms);
            return "gym";
        }

        //adds new gym to database
        @PostMapping("/addNew")
        public String addNew(Gym gym){
            gymService.addNew(gym);
            return "redirect:/gyms/getAllGyms";
        }

        //updates/edits gym
        @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
        public String update(Gym gym){
            gymService.update(gym);
            return "redirect:/gyms/getAllGyms";
        }

        //Gets gym from database based on the gym id
        @RequestMapping("/getOne")
        public Optional<Gym> getOne(Integer gymId){
            return gymService.getOne(gymId);
        }

        //deletes gym from database using gym ids
        @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
        public String delete(Integer gymId){
            gymService.delete(gymId);
            return "redirect:/gyms/getAllGyms";
        }	
}
