package com.example.demo.Models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GymEquipment{
    String equipmentName;
    Date purchaseDate;
    double purchasePrice;
    String vendor;
    String description;
    Integer gymId;

    @Id
    Integer gymEquipmentId;

    public GymEquipment(){
        super();
    }
    public GymEquipment(String equipmentName, Date purchaseDate, double purchasePrice, String vendor, String description, Integer gymId, Integer gymEquipmentId){
        super();
        this.equipmentName = equipmentName;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.vendor = vendor;
        this.description = description;
        this.gymId = gymId;
        this.gymEquipmentId = gymEquipmentId;
    }
    public String getEquipmentName(){
        return this.equipmentName;
    }
    public void setEquipmentName(String equipmentName){
        this.equipmentName = equipmentName;
    }
    public Date getPurchaseDate(){
        return this.purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    public double getPurchasePrice(){
        return this.purchasePrice;
    }
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }
    public String getVendor(){
        return this.vendor;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Integer getGymId(){
        return this.gymId;
    }
    public void setGymId(Integer gymId){
        this.gymId= gymId;
    }
    public Integer getGymEquipmentId(){
        return this.gymEquipmentId;
    }
    public void setGymEquipmentId(Integer gymEquipmentId){
        this.gymEquipmentId = gymEquipmentId;
    }
}