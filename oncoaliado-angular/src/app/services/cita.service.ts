import { Injectable } from '@angular/core';

import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';


import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


//objeto
import { Cita } from "../shared/cita";
import { CITAS } from "../shared/citas";

@Injectable({
  providedIn: 'root'
})
export class CitaService {

  constructor() { }
  getCitas():Observable<Cita[]>{

    return of(CITAS).pipe(delay(2000));
  }
  getCita():Observable<Cita>{

    return of(CITAS[0]).pipe(delay(2000));
  }
  postCita(cuerpo:Cita):String{

    return "exito"
  }
putCita(cuerpo:Cita):String{
  return "exito"

}







}
