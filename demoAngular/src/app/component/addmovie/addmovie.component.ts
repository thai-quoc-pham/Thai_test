import { Movie } from './../../models/movie.models';
import { Component, OnInit, Input } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-addmovie',
  templateUrl: './addmovie.component.html',
  styleUrls: ['./addmovie.component.scss']
})
export class AddmovieComponent implements OnInit {
  @Input() movies: Movie;
  movie: Movie = new Movie();
  submitted = false;
  constructor(private movieService: MovieService) { }

  ngOnInit(): void {
  }

  ewEmployee(): void {
    this.submitted = false;
    this.movie = new Movie();
  }

  save() {
    this.movieService.addMovie(this.movie)
      .subscribe(data => console.log(data), error => console.log(error));
    this.movie = new Movie();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
