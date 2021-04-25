package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Models.Gym;
import com.example.demo.Repositories.*;

// retrieves and adds to database

@Service
public class GymService{

    @Autowired
    private GymRepository gymRepository;

    //gets all gyms
    public List<Gym> getAll(){
        return (List<Gym>) gymRepository.findAll();
    }

    //adds new gym
    public void addNew(Gym gym){
        gymRepository.save(gym);
    }

    //updates gym 
    public void update(Gym gym){
        gymRepository.save(gym);
    }

    //retrieves gym by gym id
    public Optional<Gym> getOne(Integer gymId){
        return gymRepository.findById(gymId);
    }
    
    //delete gym by gym id
    public void delete(Integer gymId){
        gymRepository.deleteById(gymId);
    }
}