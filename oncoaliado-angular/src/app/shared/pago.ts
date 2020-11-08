import { Cita } from './cita';



export class Pago{
    id:Number;
    fecha:String;
    comprobante:String;
    banco:String;
    estatus:String;
    Total:number;
    correoCliente:String;
    cita:Cita;


}