import { Component, OnInit } from '@angular/core';
import { UserDto } from '../models/user';
import { LoginService } from '../services/login.service';
import { Routes, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginSer: LoginService,private  route:Router) { }

  ngOnInit() {
  }
  username;
  password;
  //j_security_check
  user: UserDto;
  doLogin() {
    this.user = new UserDto();
    this.user.username = this.username;
    this.user.password = this.password;
    console.log(this.user);

    this.loginSer.login(this.user).subscribe(
      (data) => {
        console.log(data);
        if (data.statusCode == 200) {
          alert("You've loggen in successfully")
          console.log(data);
          
          this.route.navigate(["/"+data.message]);
        }
        console.log("Here is data : in ok section");
        
        console.log(data);
        

      },
      err => {
        if(err.ok==false){
          // this.route.navigate(["/"]);
          document.getElementById('id01').style.display='none';
          alert("Bad Credentials")
        }
        // console.log(err.ok);

      }
    );
  }

  getCurrentUser() {
    this.loginSer.getCurrentUser().subscribe(
      (data) => {
        alert(data.message)
      }
    );

  }
}
