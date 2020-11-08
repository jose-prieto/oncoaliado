import { Pago } from './pago';


export const PAGOS:Pago[]=[
  {  id:1,
    fecha:"24/4/20",
    comprobante:"255414122",
    banco:"venezuela",
    estatus:"Listo",
    Total:19,
    correoCliente:"bryrodri1@gmail.com",
    cita: {
        id:1,
        estatus:"Por ver",
        fecha:"24/4/20",
        descripcion:"link de zoom aqui",
        tipoCita:{
            nombre:"Tipo 1",
            descripcion:"TRatamiento 1",
            precio:19.99
        },
        medicoInicial:{
            correo:"bryrodri1@gmail.com",
            nombre:"bryan",
            nombre2:"",
            apellido:"rodriguez",
            apellido2:"",
            fechaNacimiento:"10/04/97",
            genero:"M",
            foto:"jpg",
            direccion:{descripcion:"calle tal", Estado:"caracas",Pais:"venezuela"},
            especialidades:[{nombre:"Medico",descripcion:"descripcion"}]},
        medicoTDiagnostico:null
        }},
        {  id:1,
            fecha:"24/4/20",
            comprobante:"255414122",
            banco:"venezuela",
            estatus:"Listo",
            Total:19,
            correoCliente:"bryrodri1@gmail.com",
            cita: {
                id:1,
                estatus:"Por ver",
                fecha:"24/4/20",
                descripcion:"link de zoom aqui",
                tipoCita:{
                    nombre:"Tipo 1",
                    descripcion:"TRatamiento 1",
                    precio:19.99
                },
                medicoInicial:{
                    correo:"bryrodri1@gmail.com",
                    nombre:"bryan",
                    nombre2:"",
                    apellido:"rodriguez",
                    apellido2:"",
                    fechaNacimiento:"10/04/97",
                    genero:"M",
                    foto:"jpg",
                    direccion:{descripcion:"calle tal", Estado:"caracas",Pais:"venezuela"},
                    especialidades:[{nombre:"Medico",descripcion:"descripcion"}]},
                medicoTDiagnostico:null
                }},
                {  id:1,
                    fecha:"24/4/20",
                    comprobante:"255414122",
                    banco:"venezuela",
                    estatus:"Listo",
                    Total:19,
                    correoCliente:"bryrodri1@gmail.com",
                    cita: {
                        id:1,
                        estatus:"Por ver",
                        fecha:"24/4/20",
                        descripcion:"link de zoom aqui",
                        tipoCita:{
                            nombre:"Tipo 1",
                            descripcion:"TRatamiento 1",
                            precio:19.99
                        },
                        medicoInicial:{
                            correo:"bryrodri1@gmail.com",
                            nombre:"bryan",
                            nombre2:"",
                            apellido:"rodriguez",
                            apellido2:"",
                            fechaNacimiento:"10/04/97",
                            genero:"M",
                            foto:"jpg",
                            direccion:{descripcion:"calle tal", Estado:"caracas",Pais:"venezuela"},
                            especialidades:[{nombre:"Medico",descripcion:"descripcion"}]},
                        medicoTDiagnostico:null
                        }}


]