import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contactos',
  templateUrl: './contactos.component.html',
  styleUrls: ['./contactos.component.css']
})
export class ContactosComponent implements OnInit {
  Imagenes:String[]=["/assets/images/imagencontacto.png","","","simple"]
  constructor() { }

  ngOnInit(): void {
    document.body.classList.add('bg-img');
  }

}
