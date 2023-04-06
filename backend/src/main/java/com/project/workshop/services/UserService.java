package com.project.workshop.services;

import com.project.workshop.dto.UserDTO;
import com.project.workshop.entities.User;
import com.project.workshop.repositories.UserRepository;
import com.project.workshop.services.exceptions.DatabaseException;
import com.project.workshop.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
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
        try {
            User user = repository.getReferenceById(id);
            converterDtoInEntity(userDTO, user);
            user = repository.save(user);
            return new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }

    }

    public void deleteUser(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violation Integrity");
        }
    }

    private void converterDtoInEntity(UserDTO userDTO, User user) {
        user.setName(userDTO.getName());
        user.setEmail(user.getEmail());
        user.setPhone(userDTO.getPhone());

    }

}
