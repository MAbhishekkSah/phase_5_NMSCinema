import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MoviesListComponent } from './movies-list/movies-list.component';
import { MovieDetailsComponent } from './BookTickets/movie-details/movie-details.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path:'moviesList', component:MoviesListComponent},
  { path:'movieDetails/:id', component:MovieDetailsComponent},
  { path:'home', component:HomeComponent  },
  { path:'', component:HomeComponent  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
