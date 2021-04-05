package com.example.demo.Models;




import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule{
    String name;
    String date;
    Integer price;
    Integer difficulty;
    Integer trainerId;
    @Id
    Integer gymId;

    public Schedule(){
        super();
    }
    public Schedule(String name, String date, Integer price, Integer difficulty, Integer trainerId, Integer gymId){
        super();
        this.name = name;
        this.date = date;
        this.price = price;
        this.difficulty = difficulty;
        this.trainerId = trainerId;
        this.gymId = gymId;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDate(){
        return this.date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public Integer getPrice(){
        return this.price;
    }
    public void setPrice(Integer price){
        this.price = price;
    }
    public Integer getDifficulty(){
        return this.difficulty;
    }
    public void setDifficulty(Integer difficulty){
        this.difficulty = difficulty;
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