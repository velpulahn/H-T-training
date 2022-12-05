import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountExecutiveComponent } from './components/account-executive/account-executive.component';
import { HcoUserComponent } from './components/hco-user/hco-user.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ViewDetailsComponent } from './components/view-details/view-details.component';
import { AuthGuard } from './services/auth.guard';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
   {path:'', component:HomeComponent, pathMatch:'full'},
   {path:'login', component:LoginComponent},
   {path:'hcoUser', component:HcoUserComponent, canActivate:[AuthGuard]},
   {path:'viewhcos', component:AccountExecutiveComponent, canActivate:[AuthGuard]},
   {path:'edit/:id', component:UpdateComponent, canActivate:[AuthGuard]},
   {path:'register', component:RegisterComponent},
   {path:'viewDetails/:id', component:ViewDetailsComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
