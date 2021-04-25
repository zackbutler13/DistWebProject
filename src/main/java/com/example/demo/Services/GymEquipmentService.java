package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.GymEquipment;
import com.example.demo.Repositories.GymEquipmentRepository;

@Service
public class GymEquipmentService{

    @Autowired
    private GymEquipmentRepository gymEquipmentRepository;

    //Gets all gym equipment
    public List<GymEquipment> getAll(){
        return (List<GymEquipment>) gymEquipmentRepository.findAll();
    }

    //adds new gym equipment
    public void addNew(GymEquipment gymEquipment){
        gymEquipmentRepository.save(gymEquipment);
    }

    //updates gym equipment
    public void update(GymEquipment gymEquipment){
        gymEquipmentRepository.save(gymEquipment);
    }

    //retrieves gym equipment with its id
    public Optional<GymEquipment> getOne(Integer gymEquipmentId){
        return gymEquipmentRepository.findById(gymEquipmentId);
    }

    //deletes gym equipment with its id
    public void delete(Integer gymEquipmentId){
        gymEquipmentRepository.deleteById(gymEquipmentId);
    }

}