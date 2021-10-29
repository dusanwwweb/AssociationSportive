import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SportifComponent } from './sportif/sportif.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'sportif', component: SportifComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
