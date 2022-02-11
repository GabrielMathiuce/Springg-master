package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.exceptions.DataBaseException;
import com.example.demo.exceptions.ResourceNotFindException;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<User> findAll() {
        return repository.findAll();

    }
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFindException(id));

    }

    public User insert(User obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFindException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
        catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }



    public User update(Long id, User obj) {
        User entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
