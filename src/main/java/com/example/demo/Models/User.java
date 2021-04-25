package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
//Create model for user with getters and setters

@Entity
public class User{
    String name;
    String dateJoined;
    Integer membershipStatus;
    Integer gymId;
    Integer trainerId;
    @Id
    Integer userId;

    public User(){
        super();
    }
    public User(Integer userId, String dateJoined, Integer gymId, Integer membershipStatus,  String name, Integer trainerId){
        super();
        this.userId = userId;
        this.dateJoined = dateJoined;
        this.gymId = gymId;
        this.membershipStatus = membershipStatus;
        this.name = name;
        this.trainerId = trainerId;
        
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDateJoined(){
        return this.dateJoined;
    }
    public void setDateJoined(String dateJoined){
        this.dateJoined = dateJoined;
    }
    public Integer getMembershipStatus(){
        return this.membershipStatus;
    }
    public void setMembershipStatus(Integer membershipStatus){
        this.membershipStatus = membershipStatus;
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
    public Integer getUserId(){
        return this.userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
}