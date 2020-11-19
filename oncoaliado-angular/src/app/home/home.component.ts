import { Component, OnInit } from '@angular/core';
import { visibility2 } from '../animations/app.animations';

@Component({
  animations: [
    
    visibility2()
  ],
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  v1="shown"
  v2="hidden"
  v3="shown"

  constructor() { }

  ngOnInit(): void {
  }

  sliderEvento(numero:number){
    console.log("hola")
    if(numero==1){
      this.v1="shown"
      this.v2="hidden"
      this.v3="hidden"
    }
    else if(numero==2){
      this.v1="hidden"
      this.v2="shown"
      this.v3="hidden"

    }
    else{
      this.v1="hidden"
      this.v2="hidden"
      this.v3="shown"
    }


  }

}
