package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Models.User;
import com.example.demo.Services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUsers")
    public String getAll(Model model){
        List<User> users = userService.getAll();

        int maxId = users.get(0).getUserId();

        for(int i = 0; i< users.size(); i++){
            if(maxId < users.get(i).getUserId()){
                maxId = users.get(i).getUserId();
            }
        }

        model.addAttribute("newID", maxId + 1);
        model.addAttribute("users", users);
        return "user";
    }
    @PostMapping("/addNew")
    public String addNew(User user){
        userService.update(user);
        return "redirect:/user/getAllUsers";
    }
    @RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user){
        userService.update(user);
        return "redirect:/user/getAllUsers";
    }

    @RequestMapping("/getOne")
    public Optional<User> getOne(Integer userId){
        return userService.getOne(userId);
    }

    @RequestMapping(value="/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer userId){
        userService.delete(userId);
        return "redirect:/user/getAllUsers";
    }

}
