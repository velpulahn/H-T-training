import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  public updateForm!: FormGroup
  constructor(private router : ActivatedRoute, private formBuilder:FormBuilder, private userService:UserService) { }
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
    status:''
  }
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

    this.updateForm=this.formBuilder.group({
      hcoId:['', Validators.required],
      userId:['', Validators.required],
      organizationName:['', Validators.required],
      address:['', Validators.required],
      country:['',Validators.required],
      state:['', Validators.required],
      city:['', Validators.required],
      zipcode:['', Validators.required],
      email:['',Validators.required],
      website:['', Validators.required],
      primaryContact:['', Validators.required],
      primaryContactMobile:['', Validators.required],
      secondaryContact:['', Validators.required],
      secondaryContactMobile:['', Validators.required],
      programs:['', Validators.required]

     })
  }

  updateDetails(hcoUser: any){
    console.log(this.hcoUser.hcoId);
    this.userService.updateHCOUserDetails(this.hcoUser.hcoId, this.hcoUser.userId, hcoUser).subscribe(
      (res:any)=>{
        console.log(res);
        alert( res.hcoId+ "HCO User updated successfully");
        //hcoUser.reset();
      },
      err=>{
        console.log(err);
        alert("HCO User failed to update");
       // hcoUser.reset();
      }
    )
   }
}
