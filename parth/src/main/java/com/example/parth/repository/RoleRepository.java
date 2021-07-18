package com.example.parth.repository;

import com.example.parth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role , UUID> {

    Role findByUuid(String uuid);

    Set<Role> findByName(String uuid);

    boolean existsByName(String name);

}
