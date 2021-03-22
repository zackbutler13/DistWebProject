package com.example.demo.Models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User{
    String name;
    Date dateJoined;
    Integer membershipStatus;
    Integer gymId;
    Integer trainerId;
    @Id
    Integer userId;

    public User(){
        super();
    }
    public User(String name, Date dateJoined, Integer membershipStatus, Integer gymId, Integer trainerId, Integer userId){
        super();
        this.name = name;
        this.dateJoined = dateJoined;
        this.membershipStatus = membershipStatus;
        this.gymId = gymId;
        this.trainerId = trainerId;
        this.userId = userId;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Date getDateJoined(){
        return this.dateJoined;
    }
    public void setDateJoined(Date dateJoined){
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