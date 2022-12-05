import { Component, OnInit } from '@angular/core';
import { HCOUser } from 'src/app/model/hcoUser';
import { UserService } from 'src/app/services/user.service';
import { Country, State, City }  from 'country-state-city';
import { ICountry, IState, ICity } from 'country-state-city'
import { AbstractControl, FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ErrorStateMatcher } from '@angular/material/core';
import { ConditionalExpr } from '@angular/compiler';

@Component({
  selector: 'app-hco-user',
  templateUrl: './hco-user.component.html',
  styleUrls: ['./hco-user.component.scss']
})
export class HcoUserComponent implements OnInit {

  userName:any;
  userId : any;
  userDetails: HCOUser[]=[];
  user = {
    hcoId :0,
    userId :0,
    organizationName :'',
    address :'',
    country :'',
    state : '',
    city :'',
    zipcode : '',
    email :'',
    website :'',
    primaryContact :'',
    primaryContactMobile :'',
    secondaryContact :'',
    secondaryContactMobile :'',
    programs :'',
    status : ''
  };
 

  constructor(private userService: UserService) {}
  
  ngOnInit() {
    this.userName = localStorage.getItem('username');
    console.log(this.userName);
    this.userService.getUserIdByUserName(this.userName).subscribe(
      res=>{
        console.log(res.userId);
        localStorage.setItem("userId", res.userId);
        this.user=res;
      },err=>{
        console.log(err);
      }
    )
  }

  onRegister(register:any){
    this.userService.saveUserDetails(this.user.userId,this.user).subscribe(
      res=>{
        console.log(res);
        localStorage.setItem("hcoId",res.hcoId);
        alert("User Details saved Successfully !" + res.hcoId);
        this.user=res;
      },err=>{
        console.log(err);
        alert("User Details not saved Successfully !");
      }
    )
  }

  getDetails(userId:any){
     this.userService.getHcoUserDetailsByUserId(this.user.userId).subscribe(
       (res:any)=>{
         console.log(res);
         this.userDetails = res;
       },
       err=>{
         console.log(err);
         alert("could not fetch the data using userId");
       }
     )
  }

}
