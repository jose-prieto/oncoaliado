import { Component, OnInit } from '@angular/core';

//Clases
import { Evento } from "../shared/evento";
import { EventoService } from "../services/evento.service";

@Component({
  selector: 'app-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent implements OnInit {
  eventos:Evento[];
  constructor(private eventoService:EventoService) { }

  ngOnInit(): void {
    this.eventoService.getEventos().subscribe(E=>this.eventos=E)

  }

}
