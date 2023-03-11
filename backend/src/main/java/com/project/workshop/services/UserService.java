package com.project.workshop.services;

import com.project.workshop.dto.UserDTO;
import com.project.workshop.entities.User;
import com.project.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAllUser() {
        return repository.findAll().stream().map(UserDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = repository.findById(id).orElseThrow();
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insertNewUser(UserDTO userDTO) {
        User user = new User();
        converterDtoInEntity(userDTO, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = repository.getReferenceById(id);
        converterDtoInEntity(userDTO, user);
        user = repository.save(user);
        return new UserDTO(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    private void converterDtoInEntity(UserDTO userDTO, User user) {
        user.setName(userDTO.getName());
        user.setEmail(user.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
    }

}
