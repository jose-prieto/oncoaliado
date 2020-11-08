import { Component, OnInit } from '@angular/core';

//clases 

import { PagoService } from "../services/pago.service";
import { Pago } from "../shared/pago";

@Component({
  selector: 'app-gestion-pagos',
  templateUrl: './gestion-pagos.component.html',
  styleUrls: ['./gestion-pagos.component.css']
})
export class GestionPagosComponent implements OnInit {
  pagos:Pago[];
  constructor(private pagoService:PagoService){ }

  ngOnInit(): void {
    this.pagoService.getPagos().subscribe(P=>this.pagos=P)
  }

}
