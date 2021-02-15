import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { environment } from '../environments/environment';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegistrationComponent } from './registration/registration.component';
import { Common } from './common';
import { DataService } from './data.service';
import { RoomsComponent } from './home/rooms/rooms.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrationComponent,
    RoomsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, 
    ReactiveFormsModule
  ],
  providers: [
    Common,
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
