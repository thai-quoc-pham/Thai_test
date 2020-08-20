import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseUrl = 'https://crud-app-hunglm.herokuapp.com/v2/api-docs';

  // private static readonly MovieStorageKey = 'movies';
  // private movies: Movie[];

  constructor(private http: HttpClient) { }

  getMovie(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  addMovie(movie: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, movie);
  }

  updateMovie(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteMovie(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
