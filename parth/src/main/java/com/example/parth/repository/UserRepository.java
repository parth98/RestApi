package com.example.parth.repository;

import com.example.parth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User , UUID> {

    User findByUsername(String username);

    boolean existsByUsername(String username);

}
