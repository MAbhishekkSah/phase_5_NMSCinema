package com.simplilearn.project.NMSCinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.project.NMSCinema.model.Movie;
import com.simplilearn.project.NMSCinema.repository.MovieRepo;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepo repo;
	
	public Movie addMovies(Movie movies)
	{
		return repo.save(movies);
	}
	public List<Movie> getAllMovies()
	{
		return repo.findAll();
	}
	public Movie getMovieById(int id)
	{
		if(repo.findById(id)!=null)
		{
			return repo.findById(id).get();
		}
		return null;
	}
	
	public Movie getMovieByName(String name)
	{
		List<Movie> moviesList = repo.findAll();
		if(moviesList.size()!=0)
		{
			for(int i = 0; i<moviesList.size(); i++)
			{
				if(moviesList.get(i).getName().equalsIgnoreCase(name))
				{
					return moviesList.get(i);
				}
			}
		}
		return null;
	}
	
	public Movie updateMovieDetails(int id, Movie movie)
	{
		if(repo.findById(id).get()!=null)
		{
			Movie newMovie = repo.findById(id).get();
			newMovie.setId(id);
			newMovie.setName(movie.getName());
			newMovie.setCasts(movie.getCasts());
			newMovie.setCategory(movie.getCategory());
			newMovie.setDirector(movie.getDirector());
			newMovie.setTime(movie.getTime());
			newMovie.setTicketsAvailable(movie.getTicketsAvailable());
			newMovie.setPrice(movie.getPrice());
			return repo.save(newMovie);
			
		}
		else
		{
			return null;
		}
	}
	
	public boolean deleteMovie(int id)
	{
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}
}
