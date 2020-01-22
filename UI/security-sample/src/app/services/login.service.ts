import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserDto } from '../models/user';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  public login(user:UserDto):Observable<Object>{
    return this.http.post<Object>(`${environment.baseUrl}/login`,user);
  }

  public signUp(user:UserDto){
    
    
    console.log("Here is service layer : " +user)
    return this.http.post("http://localhost:8080/users/sign-up",user);
  }
}
