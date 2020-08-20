import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class BackendService {
  constructor(private httpClient: HttpClient) { }

  public get(){
    return this.httpClient.get("http://server.com/endpoint");
  }
}
