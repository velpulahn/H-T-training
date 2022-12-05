import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-view-details',
  templateUrl: './view-details.component.html',
  styleUrls: ['./view-details.component.scss']
})
export class ViewDetailsComponent implements OnInit {

  constructor(private router : ActivatedRoute, private userService : UserService,  private route : Router) { }

  hcoUser = {
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

  ngOnInit(): void {
    console.log(this.router.snapshot.params.id);
    this.userService.getHcoUserById(this.router.snapshot.params.id).subscribe(
      (res:any)=>{
        console.log(res);
        this.hcoUser=res;
      },
      err=>{
        console.log(err);
      }
    )
    }

    approve(hcoId:any) {
       console.log(hcoId)
       let status = 'Approved';
       console.log(status);
       this.userService.updateStatus(status, hcoId).subscribe(
        (res:any)=>{
          alert("This request has been Approved successfully");
          this.hcoUser.status=status;
        },err=>{
          alert("This request has not been Approved successfully");
        }
       );
     }
   
     reject(hcoId:any) {
       console.log(hcoId)
       let status = 'Rejected';
       console.log(status);
       this.userService.updateStatus(status, hcoId).subscribe(
         (res:any)=>{
           alert("This request has been Rejected successfully");
           this.hcoUser.status=status;
         },err=>{
           alert("This request has not been Rejected successfully");
         }
       );
     }
}
