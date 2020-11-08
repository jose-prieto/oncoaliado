import { Injectable } from '@angular/core';

import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';


import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


import { Medico } from "../shared/medico";
import { MEDICOS } from "../shared/medicos";


@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  constructor() { }

  getMedicos():Observable<Medico[]>{

    return of(MEDICOS).pipe(delay(2000));
  }

  getMedico():Observable<Medico>{

    return of(MEDICOS[0]).pipe(delay(2000));
  }


  postMedico():String{


    return "exito"
  }

  putMedico():String{


    return "exito"
  }


}
