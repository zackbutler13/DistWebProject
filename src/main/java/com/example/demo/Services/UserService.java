package com.example.demo.Services;

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

    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }

    public void addNew(User user){
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public Optional<User> getOne(Integer userId){
        return userRepository.findById(userId);
    }

    public void delete(Integer userId){
        userRepository.deleteById(userId);
    }
}