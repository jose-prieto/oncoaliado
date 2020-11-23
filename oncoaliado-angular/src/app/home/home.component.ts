import { Component, HostBinding, OnInit } from '@angular/core';
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
  
  On="/assets/images/puntoverde.png";
  Off="/assets/images/puntoblanco.png"

  v1="shown"
  v2="hidden"
  v3="shown"

  b1="/assets/images/puntoverde.png";
  b2="/assets/images/puntoblanco.png";
  b3="/assets/images/puntoblanco.png";

  constructor() { }

  ngOnInit(): void {
    document.body.classList.add('bg-img');
  }

  ValidarTamaño():boolean{
    return true
  }

  sliderEvento(numero:number){
    console.log("hola")
    if(numero==1){
      this.v1="shown"
      this.v2="hidden"
      this.v3="hidden"

      this.b1=this.On;
      this.b2=this.Off;
      this.b3=this.Off;
    }
    else if(numero==2){
      this.v1="hidden"
      this.v2="shown"
      this.v3="hidden"

      this.b2=this.On;
      this.b1=this.Off;
      this.b3=this.Off;

    }
    else{
      this.v1="hidden"
      this.v2="hidden"
      this.v3="shown"

      this.b3=this.On;
      this.b2=this.Off;
      this.b1=this.Off;
    }


  }

}
