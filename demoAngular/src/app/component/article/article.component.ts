import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import {Movie} from "../../models/movie.models";
import {MovieService} from "../../services/movie.service";


@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  movies: Observable<Movie[]>;

  constructor(private movieService : MovieService) { }

  ngOnInit(){
    this.reloadData();
  }

  reloadData() {
    this.movies = this.movieService.getList();
  }

  deleteMovie(id: number) {
    this.movieService.deleteMovie(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
