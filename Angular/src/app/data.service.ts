import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { observable } from 'rxjs';

import { Common } from './common';

import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  key: string;
  public url = "http://localhost:8080/HotelServiceServer/Server/"

  constructor(private http: HttpClient, private common?: Common) {

  }
  getAll(relativePath: any, data: any) {
    return this.http.post(this.url + relativePath,data, {
      //headers: new HttpHeaders(),
      //withCredentials:false 
    })
  }
  create() {
    return this.http.post(this.url, {});
  }
}
