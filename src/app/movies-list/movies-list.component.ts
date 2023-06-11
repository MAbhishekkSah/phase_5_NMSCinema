import { Component,OnInit } from '@angular/core';
import { Movie } from '../movie';
import { ImportDataService } from '../import-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit{

  flag:string = 'N';
  isPurchased:string = 'N';
  moviesList:Movie[] = [];
  noItemFound:string = 'Yes';
  searchedMovies:Movie[] = [];
  constructor(private service:ImportDataService, private _route:Router){}
  ngOnInit() {
      return this.service.getAllMoviesList().subscribe(response =>
        {
          this.moviesList = response;
          console.log(this.moviesList);
        });
  }
  searchItem(userForm:any){
    if(userForm!=null)
    {
      let count = 0, i = 0;
      while(this.moviesList[count]!=null)
      {
        console.log("userForm -> "+userForm.value.search)
          if(this.moviesList[count].name == (userForm.value.search))
          {
            console.log("Inside if--");
            this.flag = "Y";
            this.searchedMovies[i] = this.moviesList[count];
            console.log(this.searchedMovies[i]);
            i++;
          }
          count++;
      }
      if(this.searchedMovies.length==0 || this.searchedMovies[0]==null)
      {
        console.log("searched Item -> "+this.searchedMovies)
        this.flag = "Y";
        this.noItemFound = "No Results Found!";
      }

    }

  }

  submit(userForm:any){
    
  }
  pageReload()
  {
    this.flag = 'N';
    this.noItemFound = "Yes";
    this._route.navigate(['moviesList']);
  }
}
