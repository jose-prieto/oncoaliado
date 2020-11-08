import { TipoCita } from './tipoCita';
import { Medico } from "./medico";



export class Cita{
    id:number;
    estatus:String;
    fecha:string;
    descripcion:string;
    tipoCita:TipoCita;
    medicoInicial:Medico;
    medicoTDiagnostico:Medico;
}