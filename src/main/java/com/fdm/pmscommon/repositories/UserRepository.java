package com.fdm.pmscommon.repositories;

import org.springframework.stereotype.Repository;

import com.fdm.pmscommon.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}