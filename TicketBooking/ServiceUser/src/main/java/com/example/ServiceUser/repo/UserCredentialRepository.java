package com.example.ServiceUser.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ServiceUser.entity.UserCredential;

import java.util.Optional;

@Repository  // Ensure this annotation is present
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByName(String name);
}
