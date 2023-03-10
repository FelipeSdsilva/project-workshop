package com.project.workshop.services;

import com.project.workshop.dto.UserDTO;
import com.project.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<UserDTO> findAllUser(){
        return repository.findAll().stream().map(UserDTO::new).toList();
    }
}
