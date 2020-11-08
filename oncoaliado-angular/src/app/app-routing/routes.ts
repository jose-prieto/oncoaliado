import { Routes } from "@angular/router";

//componentes
import { HomeComponent } from "../home/home.component";
import { LoginComponent } from "../login/login.component";
import { RegistroComponent } from "../registro/registro.component";
import { EventosComponent } from "../eventos/eventos.component";
import { TelemedicinaComponent } from "../telemedicina/telemedicina.component";
import { GestionCitasComponent } from "../gestion-citas/gestion-citas.component";
import { CrearCitaComponent } from "../crear-cita/crear-cita.component";
import { GestionUsuariosComponent } from "../gestion-usuarios/gestion-usuarios.component";
import { CrearUsuarioComponent } from "../crear-usuario/crear-usuario.component";
import { ModificarUsuarioComponent } from "../modificar-usuario/modificar-usuario.component";
import { GestionPagosComponent } from "../gestion-pagos/gestion-pagos.component";
import { GestionEventosComponent } from "../gestion-eventos/gestion-eventos.component";
import { CrearEventoComponent } from "../crear-evento/crear-evento.component";
import { ModificarEventoComponent } from "../modificar-evento/modificar-evento.component";
import { GestionTipoCitaComponent } from "../gestion-tipo-cita/gestion-tipo-cita.component";
import { CrearTipoCitaComponent } from "../crear-tipo-cita/crear-tipo-cita.component";

export const routes:Routes=[
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    {path:"home", component:HomeComponent},
    {path:"login", component:LoginComponent},
    {path:"registro", component:RegistroComponent},
    {path:"eventos", component:EventosComponent},
    {path:"telemedicina", component:TelemedicinaComponent},
    {path:"gestionCitas", component:GestionCitasComponent},
    {path:"crearCita", component:CrearCitaComponent},
    {path:"gestionUsuarios", component:GestionUsuariosComponent},
    {path:"crearUsuario", component:CrearUsuarioComponent},
    {path:"gestionPagos", component:GestionPagosComponent},
    {path:"gestionEventos", component:GestionEventosComponent},
    {path:"crearEvento", component:CrearEventoComponent},
    {path:"gestionTipoCita", component:GestionTipoCitaComponent},
    {path:"crearTipoCita", component:CrearTipoCitaComponent},


]