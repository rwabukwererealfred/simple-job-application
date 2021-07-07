import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API ='http://localhost:8080/api/authentication/';
const OPTIONS = {
  headers : new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  login(user:any):Observable<any>{
    return this.http.post( API+ 'signin',{
      username: user.username,
      password : user.password
    },OPTIONS);
  }
}
