import { Injectable } from '@angular/core';


import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';


import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

//clases
import { Pago } from "../shared/pago";
import { PAGOS } from "../shared/pagos";

@Injectable({
  providedIn: 'root'
})
export class PagoService {

  constructor() { }
  getPagos():Observable<Pago[]>{

    return of(PAGOS).pipe(delay(2000))
  }

  getPago():Observable<Pago>{

    return of(PAGOS[0]).pipe(delay(2000))
  }

  postPago(cuerpo:Pago):String{
    return "exito";
  }

  putPago(cuerpo:Pago):String{
    return "exito"
  }


}
