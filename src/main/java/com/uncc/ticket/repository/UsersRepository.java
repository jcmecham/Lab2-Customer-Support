package com.uncc.ticket.repository;

import com.uncc.ticket.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByEmail(String email);

}
