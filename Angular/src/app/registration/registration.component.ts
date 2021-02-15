import { Component, OnInit,NgModule } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { Common } from '../common';
import { constants } from '../constants';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  inputData;
  data;
  input: { };


  constructor(private router: Router, private dataService: DataService, private common?: Common) { }

  ngOnInit() {
  }
  SubmitValues() {
    this.inputData = {
      q:"b",
      from:"2020-03-25",
      sortBy:"publishedAt",
      apiKey:"1848b5465b1449d78d10c2991b1bea98"
    }
    var relativePath = this.common.getAPI("", "GetQuestion");

    this.dataService.getAll(relativePath, this.inputData).subscribe(
      (response: any) => {
        this.data = JSON.parse(response.msgBuffer);
        var datas = this.data;
      }
    )
  }
  myfunction(){
    this.input = {
      aid:"fdfv",
      pqr:"2596"
      
    }
    var relativePath = this.common.getAPI("", "GetQuestion");

    this.dataService.getAll(relativePath, this.input).subscribe(
      (response: any) => {
        this.data = JSON.parse(response.msgBuffer);
        var datas = this.data;
      }
    )
  }

}
