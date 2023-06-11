import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ImportDataService } from 'src/app/import-data.service';
import { Movie } from 'src/app/movie';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit{

  selectedMovie!:Movie;
  flag:string = 'N';
  showTiming:string = "";
  constructor(private activatedRoute:ActivatedRoute, private movieService:ImportDataService, private _router:Router){}
  selectedId!:any;
  ngOnInit(){
    console.log("Hiiii!");
     this.selectedId = this.activatedRoute.snapshot.paramMap.get('id');
     console.log("selected Id -> "+this.selectedId);
     this.movieService.getMoviesById(this.selectedId).subscribe(data => {
      this.selectedMovie = data
      console.log("selected movie =" +this.selectedMovie.photo);
     });
      
  }

  btnClick(data:string){
      this.flag = 'Y';
      this.showTiming = data;

  }
  goBack(){
    this._router.navigate(['moviesList']);
  }
}
