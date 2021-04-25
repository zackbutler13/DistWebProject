package com.example.demo.Models;



import javax.persistence.Entity;
import javax.persistence.Id;
//Create model of Gym, with getters an setters

@Entity
public class Gym{
    String name;
    Integer membershipCost;
    String location;
    @Id
    Integer gymId;

    public Gym(){
        super();
    }
    public Gym(Integer gymId, String location,  Integer membershipCost, String name ){
        this.name = name;
        this.membershipCost = membershipCost;
        this.location = location;
        this.gymId = gymId;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getMembershipCost(){
        return this.membershipCost;
    }
    public void setMembershipCost(Integer membershipCost){
        this.membershipCost = membershipCost;
    }
    public String getLocation(){
        return this.location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public Integer getGymId(){
        return this.gymId;
    }
    public void setGymId(Integer gymId){
        this.gymId = gymId;
    }
}