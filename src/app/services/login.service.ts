import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl="http://localhost:8981/api/v1/healthcare/users"

 token = '';
 username = '';
  constructor(private http: HttpClient) { }

  authenticate(credentials:any){
    console.log(`${this.baseUrl}/signIn/token` + JSON.stringify(credentials));
    return this.http.post<any>(`${this.baseUrl}/signIn/token`,credentials)
  }

  loginUser(token:string, username:string){
    localStorage.setItem("token", token)
    localStorage.setItem("username", username)
    return true;
  }

  getRoleByUserName(username:string){
   // console.log(`${this.baseUrl}/userrole/{username}` + JSON.stringify(username));
    return this.http.get<any>(`${this.baseUrl}/userrole/${username}`,{responseType:'json'} )
  }

  isLoggedIn(){
    let token= localStorage.getItem("token");
    let username= localStorage.getItem("username");
    if(token==undefined || token==='' || token==null)
    {
      console.log("token not generated");
      return false;
    } else{
      console.log("token generated");
      return true;
    }
  }
  getToken(){
    return localStorage.getItem("token")
  }
  logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    return true;
  }
}
