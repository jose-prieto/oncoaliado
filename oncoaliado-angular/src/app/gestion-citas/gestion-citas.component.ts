import { Component, OnInit } from '@angular/core';


//clases
  import { Cita } from "../shared/cita";
  import { CitaService } from "../services/cita.service";

@Component({
  selector: 'app-gestion-citas',
  templateUrl: './gestion-citas.component.html',
  styleUrls: ['./gestion-citas.component.css']
})
export class GestionCitasComponent implements OnInit {
  citas:Cita[];
  constructor(private citaService:CitaService) { }

  ngOnInit(): void {
    this.citaService.getCitas().subscribe(C=> this.citas=C)


  }

}
