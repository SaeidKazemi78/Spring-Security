import { Component, OnInit } from '@angular/core';
import { user } from '../models/user';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginSer:LoginService) { }

  ngOnInit() {
  }
  username;
  password;

  user:user;
  doLogin(){
    this.user= new user();
    this.user.username=this.username;
    this.user.password=this.password;

    this.loginSer.signUp(this.user).subscribe(
      (data)=>{
        console.log(data);
      }
    );
    // alert("Login.... called")
  }
}
