package com.example.MovieService.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_details")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String genre;
    private String language;
    private String duration;
    private String director;
    private String releaseDate;
}
