import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { user } from '../models/user';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  public login(user:user):Observable<Object>{
    return this.http.post<Object>(`${environment.baseUrl}/login`,user);
  }

  public signUp(user:user):Observable<Object>{
    return this.http.post<object>("http://localhost:8080/sign-up",user);
  }
}
