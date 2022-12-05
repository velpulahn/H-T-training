import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import {MatDialog} from '@angular/material/dialog';
import { ConditionalExpr } from '@angular/compiler';
// MAT_DIALOG_DATA, MatDialogRef
@Component({
  selector: 'app-account-executive',
  templateUrl: './account-executive.component.html',
  styleUrls: ['./account-executive.component.scss']
})
export class AccountExecutiveComponent implements OnInit {

  userName: any;
  dataSource:any;
  status:any;
  constructor(private userService: UserService) { }
  // displayedColumns: string[] = ['hcoId','userId','organizationName','address','country','state','city',
  // 'zipcode','email','website','primaryContact','primaryContactMobile','secondaryContact',
  // 'secondaryContactMobile','programs','status','viewDetails','action1','action2'];

  displayedColumns: string[] = ['hcoId','userId','organizationName','programs','status','viewDetails'];

  ngOnInit(): void {
    this.userName = localStorage.getItem('username');
    console.log(this.userName);
    this.userService.getUserIdByUserName(this.userName).subscribe(
      res => {
        console.log(res);
        console.log(res.userId);
        this.userService.getAllHcoUserDetails(res.userId).subscribe(
          res => {
            console.log(res);
            this.dataSource =res;
            console.log(this.dataSource);
          },err=>{
            console.log(err);
          }
        )
      }, err => {
        console.log(err);
      }
    );
  }
  
  viewDetails(hcoId:any){
    console.log(hcoId);
    window.location.href=`/viewDetails/${hcoId}`;
    }
}
