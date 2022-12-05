import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})


export class RegisterComponent implements OnInit {
  public loginForm!: FormGroup
  credentials = {
    userName : '',
    password : '',
    emailId : '',
    role : ''
  }

  constructor(private loginService:LoginService, private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      userName:['', Validators.required],
      password:['', Validators.required],
      role:['',Validators.required],
    })
  }
 
  login(data : any){
    console.log(this.credentials);
    this.loginService.saveUser(this.credentials).subscribe((res:any)=>{
      console.log(res);
      alert("User added successfully : " + res.userId);
      data.reset();
    },error=>{
      console.log(error);
      alert("User not saved successfully");
      data.reset();
    })
  }

  }

