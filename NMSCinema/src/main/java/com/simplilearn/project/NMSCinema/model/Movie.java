package com.simplilearn.project.NMSCinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String casts;
	private String director;
	private String language;
	private String category;
	private String ticketsAvailable;
	private String price;
	private String photo;
	private String time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCasts() {
		return casts;
	}
	public void setCasts(String casts) {
		this.casts = casts;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTicketsAvailable() {
		return ticketsAvailable;
	}
	public void setTicketsAvailable(String ticketsAvailable) {
		this.ticketsAvailable = ticketsAvailable;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Movie(String name, String casts, String director, String language, String category, String ticketsAvailable,
			String price, String time) {
		super();
		this.name = name;
		this.casts = casts;
		this.director = director;
		this.language = language;
		this.category = category;
		this.ticketsAvailable = ticketsAvailable;
		this.price = price;
		//this.photo = photo;
		this.time = time;
	}
	public Movie(String name, String casts, String director, String language, String category, String ticketsAvailable,
			String price,String photo, String time) {
		super();
		this.name = name;
		this.casts = casts;
		this.director = director;
		this.language = language;
		this.category = category;
		this.ticketsAvailable = ticketsAvailable;
		this.price = price;
		this.photo = photo;
		this.time = time;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", casts=" + casts + ", director=" + director + ", language="
				+ language + ", category=" + category + ", ticketsAvailable=" + ticketsAvailable + ", price=" + price
				+ ", photo=" + photo +", time=" + time + "]";
	}
	
	

}
