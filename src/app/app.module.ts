import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { EditMovieComponent } from './BookTickets/edit-movie/edit-movie.component';
import { AddMovieComponent } from './BookTickets/add-movie/add-movie.component';
import { MoviesListComponent } from './movies-list/movies-list.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { MovieDetailsComponent } from './BookTickets/movie-details/movie-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EditMovieComponent,
    AddMovieComponent,
    MoviesListComponent,
    MovieDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
