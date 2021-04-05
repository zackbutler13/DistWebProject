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



import com.example.demo.Models.User;
import com.example.demo.Services.UserService;

@Controller
public class UserSearchController{
    @Autowired
    UserService userService;

    @RequestMapping("/usersearch")
    public String blank(Model model){
        boolean selected[] = new boolean[6];
        model.addAttribute("selected", selected);

        return "usersearch";
    }

    @RequestMapping(value= "/usersearch/search", method=RequestMethod.GET)
    public String form(Model model,@RequestParam(value="selectedField", required=true) String selectedField, @RequestParam(value="searchTerm", required=false, defaultValue="") String searchTerm ){
        boolean selected[] = new boolean[6];

        if(selectedField.equals("id")){selected[0] = true;}
        if(selectedField.equals("name")){selected[1] = true;}
        if(selectedField.equals("dateJoined")){selected[2] = true;}
        if(selectedField.equals("membershipStatus")){selected[3]=true;}
        if(selectedField.equals("gymId")){selected[4] = true;}
        if(selectedField.equals("trainerId")){selected[5] = true;}

        model.addAttribute("selected", selected);
        model.addAttribute("searchTerm", searchTerm);

        if(searchTerm.equals("")){
            List<User> user = userService.getAll();
            model.addAttribute("user", user);
            model.addAttribute("error_msg", "");

            return "usersearch";
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/gymDatabase", "root", "student");
            Statement s = cn.createStatement();

            String select = "select * from user where ";

            if(selectedField.equals("id")){select += "id like '%" + searchTerm + "%';";}
            if(selectedField.equals("name")){select += "name like '%" + searchTerm + "%';";}
            if(selectedField.equals("dateJoined")){select += "dateJoined like '%" + searchTerm + "%';";}
            if(selectedField.equals("membershipStatus")){select += "membershipStatus like '%" + searchTerm + "%';";}
            if(selectedField.equals("gymId")){select += "gymId like '%" + searchTerm + "%';";}
            if(selectedField.equals("trainerId")){select += "trainerId like '%" + searchTerm + "%';";}

            ResultSet rs = s.executeQuery(select);
            List<User> users = new ArrayList<User>();

            while(rs.next()){
                User user = new User();
                user.setUserId(Integer.parseInt(rs.getString(1)));
                user.setName(rs.getString(2));
                user.setDateJoined(rs.getString(3));
                user.setMembershipStatus(Integer.parseInt(rs.getString(4)));
                user.setGymId(Integer.parseInt(rs.getString(5)));
                user.setTrainerId(Integer.parseInt(rs.getString(6)));

                users.add(user);
            }
            model.addAttribute("users", users);
            model.addAttribute("error_msg", "");
        }catch(Exception e){
            System.out.println(e);
            model.addAttribute("error_msg", "Search failed. Error: " + e);
        }
        return "usersearch";
    }
}