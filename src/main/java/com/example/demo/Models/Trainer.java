package com.example.demo.Models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer{
    String name;
    Integer salary;
    String specialization;
    @Id
    Integer trainerId;

    public Trainer(){
        super();
    }
    public Trainer(String name, Integer salary, String specialization, Integer trainerId){
        super();
        this.name = name;
        this.salary = salary;
        this.specialization = specialization;
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
    public void setSalary(Intger salary){
        this.salary = salary;
    }
    public String getSpecialization(){
        return this.specialization;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public Integer getTrainerId(){
        return this.specialization;
    }
    public void setTrainerId(Integer trainerId){
        this.trainerId = trainerId;
    }

}