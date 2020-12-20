package controller;

import oncoaliado.Comandos.Citas.*;
import oncoaliado.Comandos.ComandoFactory;
import transfer.DtoCita;
import transfer.DtoGenerarCitas;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/citas")
public class CitaApi extends AplicacionBase {

    //http://localhost:8080/Servidor/api/citas
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response getAllCitas() {
        try {
            ComandoGetAllCitas comandoGetAllCitas = ComandoFactory.ComandoGetAllCitasInstancia();
            comandoGetAllCitas.execute();
            return Response.ok(comandoGetAllCitas.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //http://localhost:8080/Servidor/api/citas/medico/id
    @GET
    @Path("medico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response getAllCitasMedico(@PathParam("id") long id) {
        try {
            ComandoGetAllCitasMedico comandoGetAllCitasMedico = ComandoFactory.ComandoGetAllCitasMedicoInstancia(id);
            comandoGetAllCitasMedico.execute();
            return Response.ok(comandoGetAllCitasMedico.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //http://localhost:8080/Servidor/api/citas/medico/inactivas/id
    @GET
    @Path("medico/inactivas/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response getAllCitasInactivasMedico(@PathParam("id") long id) {
        try {
            ComandoGetAllCitasMedico comandoGetAllCitasMedico = ComandoFactory.ComandoGetAllCitasMedicoInstancia(id);
            comandoGetAllCitasMedico.execute();
            return Response.ok(comandoGetAllCitasMedico.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //http://localhost:8080/Servidor/api/citas/paciente/id
    @GET
    @Path("paciente/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response getAllCitasPaciente(@PathParam("id") long id) {
        try {
            ComandoGetAllCitasPaciente comandoGetAllCitasPaciente = ComandoFactory.ComandoGetAllCitasPacienteInstancia(id);
            comandoGetAllCitasPaciente.execute();
            return Response.ok(comandoGetAllCitasPaciente.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //http://localhost:8080/Servidor/api/citas/id
    @POST
    @Path("/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response GenerarCitas(@PathParam("id") long medId, List<DtoGenerarCitas> dtoGenerarCitas) {
        try {
            ComandoGenerarCitas comandoGenerarCitas = ComandoFactory.ComandoGenerarCitasInstancia(medId, dtoGenerarCitas);
            comandoGenerarCitas.execute();
            return Response.ok(comandoGenerarCitas.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex).build();
        }
    }

    @PUT
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateCita(DtoCita dtoCita) {
        try {
            ComandoUpdateCita comandoUpdateCita = ComandoFactory.ComandoUpdateCitaInstancia(dtoCita);
            comandoUpdateCita.execute();
            return Response.ok(comandoUpdateCita.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

}
