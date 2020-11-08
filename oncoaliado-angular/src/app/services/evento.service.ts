import { Injectable } from '@angular/core';


import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';


import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { baseURL } from '../shared/baseurl';

//objetos
import { Evento } from "../shared/evento";
import { EVENTOS } from "../shared/eventos";


@Injectable({
  providedIn: 'root'
})
export class EventoService {

  constructor() { }
  getEventos():Observable<Evento[]>{


    return of(EVENTOS).pipe(delay(2000));
  }

  getEvento(id:number):Observable<Evento>{


    return of(Evento[0]).pipe(delay(2000));
  }

  postEvento(Cuerpo:Evento):String{

    return "Exito"
  }
  putEvento(Cuerpo:Evento):String{

    return "Exito"
  }

}
