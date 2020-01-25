import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { UserDto } from '../models/user';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor( private loginService:LoginService) { }
  password;
  password2
  username;
  checker=true;

  ngOnInit() {
  }
  chekcPass(){
    // console.log("Here check");
   this.password2===this.password?this.checker=false:this.checker=true;
   this.password2!=this.password?console.log("Password mismatch"):this.checker=false;
   
  }

  user:UserDto;
  signUp(){
    this.user= new UserDto();
    this.user.password=this.password;
    this.user.username=this.username;
    this.user.active=54;
    console.log(this.user);
    
    this.loginService.signUp(this.user).subscribe(
      (data) => {
        console.log(data);
        data.statusCode==200?alert("Saved!!"):console.log("Error occured!");
        
      },
      err=>{
        console.log(err);
        
      }

    );

  }

}
