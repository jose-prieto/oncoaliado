package oncoaliado.Comandos.Factura;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoFactura;
import entidades.Cita;
import entidades.FactoryEntidades;
import entidades.Factura;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoFactura;

import java.util.GregorianCalendar;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoPagarFactura extends ComandoBase {

    private Factura factura = FactoryEntidades.FacturaInstancia();
    private final long idFactura;
    private final DtoFactura dtoFactura;

    /**
     * Constructor de la clase
     * @since 27/12/2020
     * @param dtoFactura Objeto del tipo DtoFactura.
     * @see DtoFactura Data transfer object usado para obtener los datos del pago.
     * @throws Excepciones Devuelve excepcion en caso de dato faltante o inválido.
     */
    public ComandoPagarFactura(DtoFactura dtoFactura) throws Excepciones {
        if (dtoFactura.getId() <= 0) {
            throw new Excepciones("El id de la factura debe ser mayor o igual a 0.");
        }else if(dtoFactura.getEstatus() != null && !dtoFactura.getEstatus().equals("pagado") && !dtoFactura.getEstatus().equals("rechazada") && !dtoFactura.getEstatus().equals("pendiente")) {
            throw new Excepciones("Los estatus posibles para la factura a evaluar son 'pagado', 'rechazada'.");
        }else {
            this.idFactura = dtoFactura.getId();
            this.dtoFactura = dtoFactura;
        }
    }

    @Override
    public void execute() throws Excepciones {
        DaoFactura daoFactura = DaoFactory.DaoFacturaInstancia();
        this.factura = daoFactura.find(this.idFactura, Factura.class);
        if(this.factura == null) {
            throw new Excepciones("Factura especificada inexistente en la base de datos.");
        }

        if(this.dtoFactura.getEstatus() != null) {
            this.factura.setEstatus(this.dtoFactura.getEstatus());
            if(this.factura.getEstatus().equals("pagado")) {
                DaoCita daoCita = DaoFactory.DaoCitaInstancia();
                Cita cita = daoCita.citaFactura(this.factura);
                cita.setEstatus("en proceso");
                daoCita.update(cita);
            }
        } else {
            this.factura.setEstatus("pagado");
        }
        this.factura = daoFactura.update(this.factura);
    }

    @Override
    public Factura getResult() throws Excepciones {
        execute();
        return this.factura;
    }
}
