package com.example.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theatre.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
