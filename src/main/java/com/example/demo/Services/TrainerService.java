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

    public List<Trainer> getAll(){
        return (List<Trainer>) trainerRepository.findAll();
    }

    public void addNew(Trainer trainer){
        trainerRepository.save(trainer);
    }

    public void update(Trainer trainer){
        trainerRepository.save(trainer);
    }

    public Optional<Trainer> getOne(Integer trainerId){
        return trainerRepository.findById(trainerId);
    }

    public void delete(Integer trainerId){
        trainerRepository.deleteById(trainerId);
    }
}