import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
credentials={
  username:'',
  password:''
}
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    if((this.credentials.username!='' && this.credentials.password!='') 
    && (this.credentials.username!=null && this.credentials.password!=null))
{
    console.log(this.credentials);
    this.loginService.authenticate(this.credentials).subscribe(
      (res:any)=>{
        console.log(res);
        console.log(res.token);
        console.log(this.credentials.username);
        this.loginService.loginUser(res.token, this.credentials.username);
        this.loginService.getRoleByUserName(this.credentials.username).subscribe(
        (res:any)=>{        
          if(res.statusMessage == "HCO User"){
            window.location.href="/hcoUser";
          } else if(res.statusMessage == "Account Executive") {
            window.location.href="/ae";
          } 
        },
        err=>{
          alert("Not a Valid HCO User nor a AccountExecutive");     
           }
        )
      }, 
      err=>{
        alert("InValid Credentials");    
          }
      
    )
} else {
  console.log("Fields are Empty");
}
  }
}
