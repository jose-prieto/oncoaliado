import { Component, OnInit } from '@angular/core';

//clases
import { Cita } from "../shared/cita";
import { TipoCita } from "../shared/tipoCita";

import { CitaService } from "../services/cita.service";
import { TipoCitaService } from "../services/tipo-cita.service";



@Component({
  selector: 'app-crear-cita',
  templateUrl: './crear-cita.component.html',
  styleUrls: ['./crear-cita.component.css']
})
export class CrearCitaComponent implements OnInit {
  tiposCitas:TipoCita[];
  cita:Cita;
  constructor(private tipoCitaService:TipoCitaService,
              private citaService:CitaService) { }

  ngOnInit(): void {
  this.tipoCitaService.getTiposCita().subscribe(T=>this.tiposCitas=T)
  
  }

}
