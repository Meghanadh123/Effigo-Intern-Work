package com.example.theatre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theatre.model.Theater;
import com.example.theatre.repository.TheaterRepository;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    public Theater updateTheater(Long id, Theater updatedTheater) {
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new RuntimeException("Theater not found"));
        theater.setName(updatedTheater.getName());
        theater.setLocation(updatedTheater.getLocation());
        theater.setTotalSeats(updatedTheater.getTotalSeats());
        return theaterRepository.save(theater);
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
