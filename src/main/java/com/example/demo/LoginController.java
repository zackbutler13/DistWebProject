package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Home page 
@Controller	
public class LoginController {
	
	@RequestMapping("/")
	public String test() {
		return "login";
	}
    @RequestMapping(value= "/login", method=RequestMethod.GET)
    public String form(Model model,@RequestParam(value="uname", required=true) String uname, @RequestParam(value="psw", required=false, defaultValue="") String psw ){
        
        if(uname.equals("") || psw.equals("")){
            return "";
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "Zachary1");
            Statement s = cn.createStatement();

            String select = "select * from login where ";

            select+= "userName like '%" + uname + "%';";

            ResultSet rs = s.executeQuery(select);

            while(rs.next()){
                String userName = rs.getString(1);
                String password = rs.getString(2);
                if(userName.equalsIgnoreCase(uname) && password.equalsIgnoreCase(psw)){
                    return "home";
                }
            }

            
        }catch(Exception e){
            System.out.println(e);
            model.addAttribute("error_msg", "Search failed. Error: " + e);
        }
        return "login";
    }

}