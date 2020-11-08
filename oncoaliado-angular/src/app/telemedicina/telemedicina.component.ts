import { Component, OnInit } from '@angular/core';

//clases
import { Medico } from "../shared/medico";
import { MedicoService } from "../services/medico.service";



@Component({
  selector: 'app-telemedicina',
  templateUrl: './telemedicina.component.html',
  styleUrls: ['./telemedicina.component.css']
})
export class TelemedicinaComponent implements OnInit {
  medicos:Medico[];
  constructor(private medicoService:MedicoService) { }

  ngOnInit(): void {
    this.medicoService.getMedicos().subscribe(M=> this.medicos=M)

  }

}
