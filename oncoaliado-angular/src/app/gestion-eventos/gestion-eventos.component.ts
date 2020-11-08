import { Component, OnInit } from '@angular/core';

//clases

import { Evento } from "../shared/evento";
import { EventoService } from "../services/evento.service";

@Component({
  selector: 'app-gestion-eventos',
  templateUrl: './gestion-eventos.component.html',
  styleUrls: ['./gestion-eventos.component.css']
})
export class GestionEventosComponent implements OnInit {
  eventos:Evento[];
  constructor(private eventoService:EventoService) { }

  ngOnInit(): void {
  this.eventoService.getEventos().subscribe(E=>this.eventos);
  }

}
