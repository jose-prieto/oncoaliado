import { Component, OnInit } from '@angular/core';
import { visibility, visibility2 } from '../animations/app.animations';


@Component({
  animations: [
    visibility(),
    visibility2()
  ],
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  visibility ="hidden";
  visibility2="hidden"
  constructor() { }

  ngOnInit(): void {
  }

  menu(){
    if(this.visibility=="shown"){
      this.visibility="hidden"
    }
    else{
      this.visibility="shown"
    }
  }

  onResize(){
    console.log("height"+ window.innerHeight)
    console.log("width"+ window.innerWidth)

    if(window.innerWidth>1023){
      this.visibility="hidden"
    }
    if(window.innerWidth<1023){
      this.visibility2="hidden"
    }
    
    
  }

  menuLogin(){
    if(this.visibility2=="shown"){
      this.visibility2="hidden"
    }
    else{
      this.visibility2="shown"
    }
  }

}
