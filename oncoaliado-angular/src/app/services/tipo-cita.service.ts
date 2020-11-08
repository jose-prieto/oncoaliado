import { Injectable } from '@angular/core';


import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';


import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


//objetos
  import { TipoCita } from "../shared/tipoCita";
  import { TIPOSCITA } from "../shared/tiposCita";


@Injectable({
  providedIn: 'root'
})
export class TipoCitaService {

  constructor() { }
  getTiposCita():Observable<TipoCita[]>{

    return of(TIPOSCITA).pipe(delay(2000))
  }

  getTipoCita():Observable<TipoCita>{

    return of(TIPOSCITA[0]).pipe(delay(2000))
  }

  postTipoCita(cuerpo:TipoCita):String{


    return "exito"
  }
  putTipoCita(cuerpo:TipoCita):String{


    return "exito"
  }




}
