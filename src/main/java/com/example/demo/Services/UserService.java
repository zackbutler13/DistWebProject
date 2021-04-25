package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    //get all users
    public List<User> getAll(){
        List<User> users = new ArrayList<User>();
        users.addAll((List<User>)userRepository.findAll());

        return users;
    }

    //add new user
    public void addNew(User user){
        userRepository.save(user);
    }

    //update user
    public void update(User user){
        userRepository.save(user);
    }

    //retrieves user by user id
    public Optional<User> getOne(Integer userId){
        return userRepository.findById(userId);
    }

    //delete user by user id
    public void delete(Integer userId){
        userRepository.deleteById(userId);
    }
}