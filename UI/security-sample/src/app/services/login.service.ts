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

  public login(user:UserDto):Observable<any>{
    return this.http.post<any>("http://localhost:8081/login?username="+user.username+"&password="+user.password,new Object);
  }

  public getCurrentUser():Observable<any>{
    return this.http.get<any>("http://localhost:8081/rest/user-now");
  }

  public signUp(user:UserDto):Observable<any>{
    console.log("Here is service layer : " +user)
    return this.http.post<any>("http://localhost:8081/users/sign-up",user);
    
  }
}
