import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImportDataService } from 'src/app/import-data.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  isSubmitted = false;
  constructor(private service:ImportDataService, private route:Router) {}
  ngOnInit(): void {
  }
  selectedFiles?: FileList;
  currentFile?:File;
  progress = 0;
  message = '';
  name:string = '';

  movie = {
    name:'',
    casts:'',
    director:'',
    language:'',
    category:'',
    ticketsAvailable:'',
    price:'',
    time:''
  }

  selectFile(event:any){
    console.log("select A file -> ");
    this.selectedFiles = event.target.files;
    console.log("slected File is "+this.selectedFiles);
  }

  addMovies()
  {
    console.log("Adding Movies..");
    const data = {
        name:this.movie.name,
        casts:this.movie.casts,
        director:this.movie.director,
        language:this.movie.language,
        category:this.movie.category,
        ticketsAvailable:this.movie.ticketsAvailable,
        price:this.movie.price,
        time:this.movie.time
    };
    alert(data.name);
    console.log("progress = "+this.progress);
    this.progress = 0;
    if(this.selectedFiles)
    {
      console.log("Inside If** ");
      const file:File |null = this.selectedFiles.item(0);
      if(file)
      {
        console.log("Inside file if -- ");
        this.currentFile = file;
        this.service.uploadFilesAndMovie(this.currentFile,data).subscribe();
      }
      this.selectedFiles = undefined;
    }
      this.route.navigate(['moviesList']);
  }
}
