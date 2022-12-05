import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import * as countrycitystatejson from 'countrycitystatejson';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = "http://localhost:8981/api/v1/healthcare"

  constructor(private http: HttpClient) { }
  
  getUserIdByUserName(userName : string){
    console.log(`${this.baseUrl}/${userName}`+ JSON.stringify(userName));
    return this.http.get<any>(`${this.baseUrl}/${userName}`);
  }
  getAllHcoUserDetails(userId : number){
    console.log(`${this.baseUrl}/accountexecutive/${userId}/allhcouserdetails`);
    return this.http.get<any>(`${this.baseUrl}/accountexecutive/${userId}/allhcouserdetails`);
  }
  saveUserDetails(userId : number, user:any){
    console.log(`${this.baseUrl}/hcouser/${userId}/register`+JSON.stringify(user));
    return this.http.post<any>(`${this.baseUrl}/hcouser/${userId}/register`, user);
  }
  getHcoUserDetailsByUserId(userId : number){
    console.log(`${this.baseUrl}/hcouser/user/+${userId}`);
    return this.http.get<any>(`${this.baseUrl}/hcouser/user/+${userId}`);
  }
  getHcoUserById(hcoId:number){
    console.log(`${this.baseUrl}`+`/hcouser/${hcoId}`);
    return this.http.get<any>(`${this.baseUrl}`+`/hcouser/${hcoId}`);
  }
  updateHCOUserDetails(hcoId : number, userId : number, hcoUser:any){
    console.log(`${this.baseUrl}/hcouser/${userId}/updateDetails/${hcoId}`+JSON.stringify(hcoUser));
    return this.http.put<any>(`${this.baseUrl}/hcouser/${userId}/updateDetails/${hcoId}`, hcoUser);
  }
  updateStatus(status:any, hcoId : number){
    console.log(`${this.baseUrl}/hcouser/updateStatus/${status}/${hcoId}`);
    return this.http.get<any>(`${this.baseUrl}/hcouser/updateStatus/${status}/${hcoId}`);
  }
}
