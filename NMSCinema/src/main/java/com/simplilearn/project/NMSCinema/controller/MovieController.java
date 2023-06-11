package com.simplilearn.project.NMSCinema.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.simplilearn.project.NMSCinema.service.FileUtil;
import com.simplilearn.project.NMSCinema.model.Movie;
import com.simplilearn.project.NMSCinema.service.MovieService;

@RestController
@RequestMapping("/nmsCinema")
@CrossOrigin(origins="http://localhost:4200")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping("/moviesList")
	public List<Movie> getAllMovieList(){
		return service.getAllMovies();
	}
	
	@GetMapping("movieById/{id}")
	public ResponseEntity<Object> findMovieById(@PathVariable int id)
	{
		if(service.getMovieById(id)!=null)
		{
			System.out.println("Movie By Id -> "+service.getMovieById(id).getPhoto());
			return new ResponseEntity<Object>(service.getMovieById(id),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>("Movie Not Found !",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/movieByName/{name}")
	public ResponseEntity<Object> findMovieByName(@PathVariable String name)
	{
		return new ResponseEntity<Object>(service.getMovieByName(name),HttpStatus.FOUND);
	}
	
	@PostMapping(value="/addMovie",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFiles(@RequestParam("files")MultipartFile files,@RequestParam("name") String name,
						@RequestParam("casts") String casts,@RequestParam("director") String director,@RequestParam("language") String language,
						@RequestParam("category") String category,@RequestParam("ticketsAvailable")String ticketsAvailable,
						@RequestParam("price") String price,@RequestParam("time") String time)
	{
		System.out.println("Inside uploadFiles");
		try {
			this.createDirIfNotExist();
			
			List<String> fileNames = new ArrayList<>();
			//Read and write the file in the local folder
			Arrays.asList(files).stream().forEach(file ->{
				byte[] bytes = new byte[0];
				
				try {
					bytes = file.getBytes();
					Path path = Paths.get(FileUtil.folderPath + name.toLowerCase() + ".png");
					Files.write(path, bytes);
					fileNames.add(path.toString());
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
			});
			Movie movie = new Movie(name,casts,director, language,category,ticketsAvailable,price,time);
			System.out.println("Adding the new Medicine"+movie);
			int pos = fileNames.get(0).lastIndexOf("assets");
			String fileName = ".\\"+fileNames.get(0).substring(pos);
			movie.setPhoto(fileName);
			service.addMovies(movie);
			return new ResponseEntity<Object>(movie,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>("Exception while Uploading files !",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	//Create directory to SAVE FILE IF NOT EXIST
	private void createDirIfNotExist()
	{
		File directory = new File(FileUtil.folderPath);
		if(!directory.exists())
		{
			directory.mkdir();
		}
	}
	@PutMapping("updateMovieById/{id}")
	public ResponseEntity<Object> updateMovieById(@PathVariable int id, @RequestBody Movie newMovie)
	{
		Movie movie = service.getMovieById(id);
		if(movie!=null)
		{
			return new ResponseEntity<Object>(service.updateMovieDetails(id, newMovie),HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not able to update.Please try with correct id!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("deleteMovieById/{id}")
	public ResponseEntity<String> deleteMovieById(@PathVariable int id)
	{
		boolean isDeleted = service.deleteMovie(id);
		if(isDeleted)
		{
			return new ResponseEntity<String>("Movie Deleted Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Movie Not Found!",HttpStatus.NOT_FOUND);
		}
	}
}
