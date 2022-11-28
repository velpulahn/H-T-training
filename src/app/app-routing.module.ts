import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountExecutiveComponent } from './account-executive/account-executive.component';
import { HcoUserComponent } from './components/hco-user/hco-user.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
   {path:'', component:HomeComponent, pathMatch:'full'},
   {path:'login', component:LoginComponent},
   {path:'hcoUser', component:HcoUserComponent, canActivate:[AuthGuard]},
   {path:'ae', component:AccountExecutiveComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
