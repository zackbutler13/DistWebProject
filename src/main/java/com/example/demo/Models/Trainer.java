package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
//Create model of trainer with getters and setters

@Entity
public class Trainer{
    String name;
    Integer salary;
    String specialization;
    Integer gymId;
    @Id
    Integer trainerId;

    public Trainer(){
        super();
    }
    public Trainer(String name, Integer salary, String specialization, Integer gymId, Integer trainerId){
        super();
        this.name = name;
        this.salary = salary;
        this.specialization = specialization;
        this.gymId = gymId;
        this.trainerId = trainerId;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getSalary(){
        return this.salary;
    }
    public void setSalary(Integer salary){
        this.salary = salary;
    }
    public String getSpecialization(){
        return this.specialization;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public Integer getGymId(){
        return this.gymId;
    }
    public void setGymId(Integer gymId){
        this.gymId = gymId;
    }
    public Integer getTrainerId(){
        return this.trainerId;
    }
    public void setTrainerId(Integer trainerId){
        this.trainerId = trainerId;
    }

}