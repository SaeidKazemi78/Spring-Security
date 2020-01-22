import { Component, OnInit } from '@angular/core';
import { UserDto } from '../models/user';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginSer: LoginService) { }

  ngOnInit() {
  }
  username;
  pass;

  user: UserDto;
  doLogin() {
    
    this.user = new UserDto();
    this.user.username = this.username;
    this.user.password = this.pass;
    // this.user.pass = "Kazemi";
    this.user.active = 1;
    console.log(this.user);
    
    this.loginSer.signUp(this.user).subscribe(
      (data) => {
        console.log(data);
      },
      err=>{
        console.log(err);
        
      }

    );
    // alert("Login.... called")
  }
}
