import { Injectable } from '@angular/core';
import {HttpClient}  from '@angular/common/http'
import { Movie } from './movie';
import { Observable } from 'rxjs';
import { MovieWithoutPhoto } from './movie-without-photo';
@Injectable({
  providedIn: 'root'
})
export class ImportDataService {

  constructor(private http:HttpClient) { }

  baseUrl:string = "http://localhost:8081/nmsCinema";
   //get All movie list
   getAllMoviesList() : Observable<Movie[]>{
    let endPoint = 'moviesList';
    let url = `${this.baseUrl}/${endPoint}`;
    return this.http.get<Movie[]>(`${url}`);
  }

  getMoviesById(id:any): Observable<Movie>{
    console.log("getMoviesById = "+id)
    let endPoint = 'movieById';
    let url = `${this.baseUrl}/${endPoint}/${id}`;
    console.log("before returning")
    return this.http.get<Movie>(`${url}`);
  }

  updateMovie(id:number,updatedMovie:Movie):Observable<any>{
    let endPoint = 'updateMovieById';
    let url = `${this.baseUrl}/${endPoint}/${id}`;
    return this.http.put(`${url}`,updatedMovie);
  }

  deleteMovie(id:number){
    let endPoint = 'deleteMovieById';
    let url = `${this.baseUrl}/${endPoint}/${id}`;
    this.http.delete(`${url}`).subscribe(data =>{
      return this.getAllMoviesList();
    });
  }

  uploadFilesAndMovie(file:File,data:MovieWithoutPhoto):Observable<Movie>
  {
    console.log("data -> "+data.price);
    let endPoint = 'addMovie';
      let url = `${this.baseUrl}/${endPoint}`;
      const formData:FormData = new FormData();
      formData.append('files',file);
      formData.append('name',data.name);
      formData.append('casts',data.casts);
      formData.append('director',data.director);
      formData.append('language',data.language);
      formData.append('category',data.category);
      formData.append('ticketsAvailable',data.ticketsAvailable);
      formData.append('price',data.price);
      formData.append('time',data.time);
    console.log("Before calling upload Med");
      return this.http.post<Movie>(`${url}`,formData);
  }

}
