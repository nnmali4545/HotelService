import { Component, OnInit,Input } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { Common } from '../common';
import { constants } from '../constants';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  inputData;
  data;
  checkinDate:any;
  checkoutDate:any;
  rid:any;
  lid:any;
  name:any;
  point:any;
  
  input: { };
  constructor(private router: Router, private dataService: DataService, private common?: Common) { }

  ngOnInit() {
    this.checkinDate="09/02/2021";
    this.checkoutDate="10/02/2021";
    this.name=sessionStorage.getItem("name");
    this.point=sessionStorage.getItem("point");

  }
  Book(event:any){
    this.input = {
      cdate:this.checkinDate,
      odate:this.checkoutDate, 
      sts:"",
      rid:event,
      lid:sessionStorage.getItem("lid"),
    }
    var relativePath = this.common.getAPI("", "Booking");

    this.dataService.getAll(relativePath, this.input).subscribe(
      (response: any) => {
        alert(response.str);

      }
    )
  }
}
