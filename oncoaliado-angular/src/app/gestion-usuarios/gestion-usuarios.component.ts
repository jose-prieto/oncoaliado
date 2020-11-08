import { Component, OnInit } from '@angular/core';

//clases
import { Usuario } from "../shared/usuario";
import { UsuarioService } from "../services/usuario.service";

@Component({
  selector: 'app-gestion-usuarios',
  templateUrl: './gestion-usuarios.component.html',
  styleUrls: ['./gestion-usuarios.component.css']
})
export class GestionUsuariosComponent implements OnInit {
  usuarios:Usuario[];
  constructor(private usuarioSerivice:UsuarioService) { }

  ngOnInit(): void {

    this.usuarioSerivice.getUsuarios().subscribe(U=>this.usuarios=U)
  }

}
