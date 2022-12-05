import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
user : any;
public loggedIn=false;
  constructor(private loginService:LoginService, private userService:UserService) { }

  ngOnInit(): void {
    this.loggedIn=this.loginService.isLoggedIn();
    this.user=localStorage.getItem('username');
    console.log(this.user);
  }
logoutUser(){
  this.loginService.logout();
  location.reload();
}
}
