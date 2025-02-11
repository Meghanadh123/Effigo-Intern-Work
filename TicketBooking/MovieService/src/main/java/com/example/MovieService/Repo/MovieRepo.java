package com.example.MovieService.Repo;

import com.example.MovieService.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
}
