import { Component, OnInit } from '@angular/core';


//clases
import { TipoCitaService } from "../services/tipo-cita.service";
import { TipoCita } from "../shared/tipoCita";

@Component({
  selector: 'app-gestion-tipo-cita',
  templateUrl: './gestion-tipo-cita.component.html',
  styleUrls: ['./gestion-tipo-cita.component.css']
})
export class GestionTipoCitaComponent implements OnInit {
  tiposCitas:TipoCita[]
  constructor(private tipoCitaService:TipoCitaService) { }

  ngOnInit(): void {
    this.tipoCitaService.getTiposCitas().subscribe(C=>this.tiposCitas=C)

  }

}
