package controller;

import oncoaliado.Comandos.Citas.*;
import oncoaliado.Comandos.ComandoFactory;
import transfer.DtoCita;
import transfer.DtoGenerarCitas;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author José Prieto
 * @version 1.0
 */
@Path("/citas")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CitaApi extends AplicacionBase {

    /**
     * URL: http://localhost:8080/Servidor/api/citas
     * @since 25/12/2020
     * @see ComandoGetAllCitas Lógica de la Api.
     * @apiNote Api hecha para obtener todas las citas registradas en la base de datos.
     * @return Lista de citas.
     */
    @GET
    public Response getAllCitas() {
        try {
            ComandoGetAllCitas comandoGetAllCitas = ComandoFactory.ComandoGetAllCitasInstancia();
            return Response.ok(comandoGetAllCitas.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas/{idCita}
     * @since 27/12/2020
     * @see ComandoGetCita Lógica de la Api.
     * @apiNote Api hecha para mostrar una cita en base al id.
     * @param idCita Objeto de tipo long con el id de la cita a consultar.
     * @return Objeto de tipo Cita
     */
    @GET
    @Path("/{idCita}")
    public Response getCita(@PathParam("idCita") long idCita) {
        try {
            ComandoGetCita comandoGetCita = ComandoFactory.ComandoGetCitaInstancia(idCita);
            return Response.ok(comandoGetCita.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas/medico/id
     * @since 25/12/2020
     * @see ComandoGetAllCitas Lógica de la api.
     * @apiNote Api creada para retornar todas las citas registradas de un médico registrado en la base de datos.
     * @param id obtiene el id del medico.
     * @return Lista de citas.
     */
    @GET
    @Path("/medico/{id}")
    public Response getAllCitasMedico(@PathParam("id") long id) {
        try {
            ComandoGetAllCitasMedico comandoGetAllCitasMedico = ComandoFactory.ComandoGetAllCitasMedicoInstancia(id);
            return Response.ok(comandoGetAllCitasMedico.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas/medico/inactivas/id
     * @since 25/12/2020
     * @see ComandoGetCitasInactivas Lógica de la api.
     * @apiNote Api hecha para retornar lista de citas en estado "inactiva" registradas de un médico registrado en la
     * base de datos.
     * @param id obtiene el id del medico.
     * @return Lista de citas.
     */
    @GET
    @Path("/medico/inactivas/{id}")
    public Response getCitasInactivasMedico(@PathParam("id") long id) {
        try {
            ComandoGetCitasInactivas comandoGetCitasInactivas = ComandoFactory.ComandoGetCitasInactivasInstancia(id);
            return Response.ok(comandoGetCitasInactivas.getResult()).build();
        } catch(Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas/pendientes
     * @since 25/12/2020
     * @see ComandoGetCitasPendientes Lógica de la Api.
     * @apiNote Api hecha para retornar todas las citas en estado "pendiente" registradas en la base de datos.
     * @return Lista de citas
     */
    @GET
    @Path("/pendientes")
    public Response getAllCitasPendientes() {
        try {
            ComandoGetCitasPendientes comandoGetCitasPendientes = ComandoFactory.ComandoGetCitasPendientesInstancia();
            return Response.ok(comandoGetCitasPendientes.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas/paciente/id
     * @since 25/12/2020
     * @see ComandoGetAllCitasPaciente Lógica de la api.
     * @apiNote Api hecho para retornar todas las citas del paciente registradas en la base de datos.
     * @param id objeto de tipo long con el id del paciente (no del usuario).
     * @return Lista de objetos de tipo cita.
     */
    @GET
    @Path("/paciente/{id}")
    public Response getAllCitasPaciente(@PathParam("id") long id) {
        try {
            ComandoGetAllCitasPaciente comandoGetAllCitasPaciente = ComandoFactory.ComandoGetAllCitasPacienteInstancia(id);
            return Response.ok(comandoGetAllCitasPaciente.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas/id
     * @since 25/12/2020
     * @see ComandoGenerarCitas Lógica de la api.
     * @apiNote Api hecha para generar citas nuevas hechas por el médico.
     * @param medEspId Objeto de tipo lon con el id de la intersección medico_especialidad (no del médico)
     * @param dtoGenerarCitas Lista de objetos de tipo DtoGenerarCitas donde estarán los datos de las citas creadas por
     *                        día.
     * @see DtoGenerarCitas Data transfer object usado para objeter los datos de las citas a crear.
     * @return Lista de citas
     */
    @POST
    @Path("/{id}")
    public Response GenerarCitas(@PathParam("id") long medEspId, List<DtoGenerarCitas> dtoGenerarCitas) {
        try {
            ComandoGenerarCitas comandoGenerarCitas = ComandoFactory.ComandoGenerarCitasInstancia(medEspId, dtoGenerarCitas);
            return Response.ok(comandoGenerarCitas.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas
     * @since 25/12/2020
     * @apiNote Api hecha para actualizar una cita.
     * @param dtoCita Objeto de tipo DtoCita con los datos nuevos de la cita a actualizar.
     * @see ComandoUpdateCita Lógica de la api.
     * @return Objeto de tipo Cita recién actualizado.
     */
    @PUT
    public Response updateCita(DtoCita dtoCita) {
        try {
            ComandoUpdateCita comandoUpdateCita = ComandoFactory.ComandoUpdateCitaInstancia(dtoCita);
            return Response.ok(comandoUpdateCita.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/citas/idCita/idPaciente/idTipoCita
     * @since 25/12/2020
     * @apiNote Api hecha para cuando un paciente va a apartar una cita.
     * @param citaId Objeto de tipo long con el id de la cita a apartar.
     * @param usrId Objeto de tipo long con el id del paciente que apartará la cita.
     * @param tipoCitaId Objeto de tipo long con el id del tipo de cita a apartar.
     * @see ComandoApartarCita Lógica de la api.
     * @return Objeto de tipo cita recién apartada.
     */
    @PUT
    @Path("/{idCita}/{idPaciente}/{idTipoCita}")
    public Response ApartarCita(@PathParam("idCita") long citaId, @PathParam("idPaciente") long usrId, @PathParam("idTipoCita") long tipoCitaId) {
        try {
            ComandoApartarCita comandoApartarCita = ComandoFactory.ComandoApartarCitaInstancia(citaId, usrId, tipoCitaId);
            return Response.ok(comandoApartarCita.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

}
