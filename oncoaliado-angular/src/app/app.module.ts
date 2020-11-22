import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


//Componentes
import { AppRoutingModule } from './app-routing/app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { EventosComponent } from './eventos/eventos.component';
import { TelemedicinaComponent } from './telemedicina/telemedicina.component';
import { TelemedicinaFormualarioComponent } from './telemedicina-formualario/telemedicina-formualario.component';
import { TelemedicinaPagoComponent } from './telemedicina-pago/telemedicina-pago.component';
import { GestionCitasComponent } from './gestion-citas/gestion-citas.component';
import { CrearCitaComponent } from './crear-cita/crear-cita.component';
import { CitaComponent } from './cita/cita.component';
import { ModificarCitaComponent } from './modificar-cita/modificar-cita.component';
import { GestionUsuariosComponent } from './gestion-usuarios/gestion-usuarios.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { CrearUsuarioComponent } from './crear-usuario/crear-usuario.component';
import { ModificarUsuarioComponent } from './modificar-usuario/modificar-usuario.component';
import { GestionPagosComponent } from './gestion-pagos/gestion-pagos.component';
import { PagoComponent } from './pago/pago.component';
import { ModificarPagoComponent } from './modificar-pago/modificar-pago.component';
import { GestionEventosComponent } from './gestion-eventos/gestion-eventos.component';
import { EventoComponent } from './evento/evento.component';
import { CrearEventoComponent } from './crear-evento/crear-evento.component';
import { ModificarEventoComponent } from './modificar-evento/modificar-evento.component';
import { GestionTipoCitaComponent } from './gestion-tipo-cita/gestion-tipo-cita.component';
import { TipoCitaComponent } from './tipo-cita/tipo-cita.component';
import { CrearTipoCitaComponent } from './crear-tipo-cita/crear-tipo-cita.component';
import { MedicosComponent } from './medicos/medicos.component';


//Servicios
import { EventoService } from "./services/evento.service";
import { UsuarioService } from "./services/usuario.service";
import { MedicoService } from "./services/medico.service";
import { TipoCitaService } from "./services/tipo-cita.service";
import { CitaService } from "./services/cita.service";
import { PagoService } from "./services/pago.service";
import { NavComponent } from './nav/nav.component';
import { ContactosComponent } from './contactos/contactos.component';
import { ContactoHeaderComponent } from './contacto-header/contacto-header.component';
import { ContactoFormularioComponent } from './contacto-formulario/contacto-formulario.component';
import { ContactoDonacionesComponent } from './contacto-donaciones/contacto-donaciones.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistroComponent,
    EventosComponent,
    TelemedicinaComponent,
    TelemedicinaFormualarioComponent,
    TelemedicinaPagoComponent,
    GestionCitasComponent,
    CrearCitaComponent,
    CitaComponent,
    ModificarCitaComponent,
    GestionUsuariosComponent,
    UsuarioComponent,
    CrearUsuarioComponent,
    ModificarUsuarioComponent,
    GestionPagosComponent,
    PagoComponent,
    ModificarPagoComponent,
    GestionEventosComponent,
    EventoComponent,
    CrearEventoComponent,
    ModificarEventoComponent,
    GestionTipoCitaComponent,
    TipoCitaComponent,
    CrearTipoCitaComponent,
    MedicosComponent,
    NavComponent,
    ContactosComponent,
    ContactoHeaderComponent,
    ContactoFormularioComponent,
    ContactoDonacionesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [
    EventoService,
    UsuarioService,
    MedicoService,
    TipoCitaService,
    CitaService,
    PagoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
