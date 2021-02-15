import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { Common } from '../common';
import { constants } from '../constants';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
lid:any;
pwd:any;
inputData;
  data;
 
  
  input= { };
  constructor(private router: Router, private dataService: DataService, private common?: Common) { }

  ngOnInit() {
  }

  UserLogin(){
    this.input = {
      lid:this.lid,
      pwd:this.pwd,  
    }
    var relativePath = this.common.getAPI("", "UserLogin");

    this.dataService.getAll(relativePath, this.input).subscribe(
      (response: any) => {
       // this.data = JSON.parse(response);
        if(response.sts==0){
          document.getElementById('id01').style.display='none';
          sessionStorage.setItem("lid",response.lid);
          sessionStorage.setItem("name",response.nme);
          sessionStorage.setItem("point",response.pts);
          alert(response.str);
          window.location.reload();
        }else{
          alert(response.str);
        }
      }
    )
  }

}
