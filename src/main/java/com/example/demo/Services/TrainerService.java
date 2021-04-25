package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Trainer;
import com.example.demo.Repositories.TrainerRepository;

@Service
public class TrainerService{

    @Autowired
    private TrainerRepository trainerRepository;

    //gets all trainers
    public List<Trainer> getAll(){
        return (List<Trainer>) trainerRepository.findAll();
    }

    //add new trainer
    public void addNew(Trainer trainer){
        trainerRepository.save(trainer);
    }

    //update trainer
    public void update(Trainer trainer){
        trainerRepository.save(trainer);
    }

    //get one trainer by trainer id
    public Optional<Trainer> getOne(Integer trainerId){
        return trainerRepository.findById(trainerId);
    }

    //delete trainer by trainer id
    public void delete(Integer trainerId){
        trainerRepository.deleteById(trainerId);
    }
}