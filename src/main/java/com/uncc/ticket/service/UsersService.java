package com.uncc.ticket.service;

import com.uncc.ticket.model.UsersEntity;
import com.uncc.ticket.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

    }

    public void registerUser(UsersEntity users) {
        usersRepository.save(users);
    }

    public UsersEntity findById(Long id) {
        return usersRepository.getOne(id);
    }

    public UsersEntity findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}

