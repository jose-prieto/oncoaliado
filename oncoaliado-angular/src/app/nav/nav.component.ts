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
    this.visibility="hidden"
    this.visibility2="hidden"
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
