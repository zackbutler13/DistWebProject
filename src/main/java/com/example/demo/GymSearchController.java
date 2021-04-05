package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

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

    @RequestMapping("/gymsearch")
    public String blank(Model model){
        boolean selected[] = new boolean[4];
        model.addAttribute("selected", selected);

        return "booksearch";
    }

    @RequestMapping(value="/gymsearch/search", method=RequestMethod.GET)
    public String form(Model model, @RequestParam(value="selectedField", required=true) String selectedField, @RequestParam(value="searchTerm", required=false, defaultValue="") String searchTerm){
        boolean selected[] = new boolean[4];

        if(selectedField.equals("id")){selected[0] = true;}
        if(selectedField.equals("name")){selected[1] = true;}
        if(selectedField.equals("membershipCost")){selected[2] = true;}
        if(selectedField.equals("location")){selected[3] = true;}

        model.addAttribute("selected",selected);
        model.addAttribute("searchTerm",searchTerm);

        if(searchTerm.equals("")){
            List<Gym> gym = gymService.getAll();
            model.addAttribute("gym", gym);
            model.addAttribute("error_msg", "");

            return "booksearch";
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/gymDatabase", "root", "student");
            Statement s = cn.createStatement();

            String select = "select * from gym where ";

            if(selectedField.equals("id")){select += "id like '%" + searchTerm + "%';";}
            if(selectedField.equals("name")){select += "name like '%" + searchTerm + "%';";}
            if(selectedField.equals("membershipCost")){select += "membershipCost like '%" + searchTerm + "%';";}
            if(selectedField.equals("location")){select += "membershipCost like '%" + searchTerm + "%';";}

            ResultSet rs = s.executeQuery(select);
            List<Gym> gyms = new ArrayList<Gym>();

            while(rs.next()){
                Gym gym = new Gym();
                gym.setGymId(Integer.parseInt(rs.getString(1)));
                gym.setName(rs.getString(2));
                gym.setMembershipCost(Integer.parseInt(rs.getString(3)));
                gym.setLocation(rs.getString(4));

                gyms.add(gym);
            }
            model.addAttribute("gyms", gyms);
            model.addAttribute("error_msg","");
        }catch(Exception e){
            System.out.println(e);
            model.addAttribute("error_msg", "Search Failed. Error: " + e);
        }
        return "gymseach";
    }
}