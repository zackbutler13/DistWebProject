package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.GymEquipment;
import com.example.demo.Services.GymEquipmentService;

// handles mapping of gym equipment @author ZB

@Controller
@RequestMapping("/gymequipment")
public class GymEquipmentController{
    @Autowired
    private GymEquipmentService gymEquipmentService;


        @RequestMapping("/getAllEquipment")
        public String getAll(Model model){
            List<GymEquipment> gymEquipments = gymEquipmentService.getAll();

            int maxId = gymEquipments.get(0).getGymEquipmentId();

            for(int i =0; i< gymEquipments.size(); i++){
                if(maxId < gymEquipments.get(i).getGymEquipmentId()){
                    maxId = gymEquipments.get(i).getGymId();
                }
            }

            model.addAttribute("newID", maxId +1);
            model.addAttribute("gymEquipments", gymEquipments);
            return "gymequipment";
        }
        @PostMapping("/addNew")
        public String addNew(GymEquipment gymEquipment){
            gymEquipmentService.addNew(gymEquipment);
            return "redirect:/gymequipment/getAllEquipment";
        }

        @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
        public String update(GymEquipment gymEquipment){
            gymEquipmentService.update(gymEquipment);
            return "redirect:/gymequipment/getAllEquipment";
        }

        @RequestMapping("/getOne")
        public Optional<GymEquipment> getOne(Integer gymEquipmentId){
            return gymEquipmentService.getOne(gymEquipmentId);
        }

        @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
        public String delete(Integer gymEquipmentId){
            gymEquipmentService.delete(gymEquipmentId);
            return "redirect:/gymequipment/getAllEquipment";
        }	
    
}