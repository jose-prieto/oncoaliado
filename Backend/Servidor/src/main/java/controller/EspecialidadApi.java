package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Especialidades.ComandoGetAllEspecialidades;
import oncoaliado.Comandos.TipoCita.ComandoGetTipoCitas;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/especialidad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EspecialidadApi extends AplicacionBase {

    @GET
    public Response getEspecialidades() {
        try {
            ComandoGetAllEspecialidades comandoGetAllEspecialidades = ComandoFactory.ComandoGetAllEspecialidadesInstancia();
            comandoGetAllEspecialidades.execute();
            return Response.ok(comandoGetAllEspecialidades.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
