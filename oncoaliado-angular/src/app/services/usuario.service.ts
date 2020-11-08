import { Injectable } from '@angular/core';

import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';


import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

//objetos
import { Usuario } from "../shared/usuario";
import { USUARIOS } from "../shared/usuarios";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor() { }
  getUsuarios():Observable<Usuario[]>{


    return of(USUARIOS).pipe(delay(2000))
  }
  getUsuario(id:number):Observable<Usuario>{

    return of(USUARIOS[0]).pipe(delay(2000));
  }

  postUsuario(cuerpo:Usuario):String{

    return "exito"
  }

  putUsuario(cuerpo:Usuario):String{


    return "exito"
  }





}
