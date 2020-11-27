import { Component, Input, OnInit } from '@angular/core';
import { visibility2 } from '../animations/app.animations';
@Component({
  animations: [
    
    visibility2()
  ],
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.css']
})
export class SliderComponent implements OnInit {
  @Input()imagenes:String[];
  On="/assets/images/puntoverde.png";
  Off="/assets/images/puntoblanco.png"

  v1="shown"
  v2="hidden"
  v3="hidden"
  botones="shown";

  b1="/assets/images/puntoverde.png";
  b2="/assets/images/puntoblanco.png";
  b3="/assets/images/puntoblanco.png";

  i1:String;
  i2:String;
  i3:String;

  constructor() { }

  ngOnInit(): void {
    console.log(this.imagenes)
   if(this.imagenes[3]=="multiple"){
    this.i1=this.imagenes[0];
    this.i2=this.imagenes[1];
    this.i3=this.imagenes[2];
    console.log(this.imagenes[0])

   }
   else{
    this.i1=this.imagenes[0];
    this.i2=this.imagenes[0];
    this.i3=this.imagenes[0];
    this.botones="hidden"
   }
  }

  sliderEvento(numero:number){
    
    
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
