package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Models.Gym;
import com.example.demo.Services.GymService;

@Controller
public class GymSearchController{
    @Autowired
    GymService gymService;

    //gets gym search before anything has been selected
    @RequestMapping("/gymsearch")
    public String blank(Model model){
        boolean selected[] = new boolean[4];
        model.addAttribute("selected", selected);

        return "gymsearch";
    }

    //fetches data once a keyword is selected 
    @RequestMapping(value="/gymsearch/search", method=RequestMethod.GET)
    public String form(Model model, @RequestParam(value="selectedField", required=true) String selectedField, @RequestParam(value="searchTerm", required=false, defaultValue="") String searchTerm){
        boolean selected[] = new boolean[4];

        //checks which keyword has been selected
        if(selectedField.equals("id")){selected[0] = true;}
        if(selectedField.equals("location")){selected[1] = true;}
        if(selectedField.equals("membershipCost")){selected[2] = true;}
        if(selectedField.equals("name")){selected[3] = true;}

        model.addAttribute("selected",selected);
        model.addAttribute("searchTerm",searchTerm);

        //if no search term then select all gyms
        if(searchTerm.equals("")){
            List<Gym> gym = gymService.getAll();
            model.addAttribute("gym", gym);
            model.addAttribute("error_msg", "");

            return "gymsearch";
        }

        try{
            //connect to database and create statement
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "Zachary1");
            Statement s = cn.createStatement();

            String select = "select * from gym where ";

            //check keyword and add to query statement
            if(selectedField.equals("gymId")){select += "gym_id like '%" + searchTerm + "%';";}
            if(selectedField.equals("location")){select += "location like '%" + searchTerm + "%';";}
            if(selectedField.equals("membershipCost")){select += "membership_cost like '%" + searchTerm + "%';";}
            if(selectedField.equals("name")){select += "name like '%" + searchTerm + "%';";}

            //execute query and receive back results 
            ResultSet rs = s.executeQuery(select);
            List<Gym> gyms = new ArrayList<Gym>();

            //cycle through the result set and add the gym to arraylist
            while(rs.next()){
                Gym gym = new Gym();
                gym.setGymId(Integer.parseInt(rs.getString(1)));
                gym.setLocation(rs.getString(2));
                gym.setMembershipCost(Integer.parseInt(rs.getString(3)));
                gym.setName(rs.getString(4));

                gyms.add(gym);
            }
            //add gyms to model
            model.addAttribute("gyms", gyms);
            model.addAttribute("error_msg","");
        }catch(Exception e){
            System.out.println(e);
            model.addAttribute("error_msg", "Search Failed. Error: " + e);
        }
        return "gymsearch";
    }
}