package com.simplilearn.project.NMSCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.project.NMSCinema.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{

}
