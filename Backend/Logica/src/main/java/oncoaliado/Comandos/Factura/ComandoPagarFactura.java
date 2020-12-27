package oncoaliado.Comandos.Factura;

import accesos.DaoFactory;
import accesos.Daos.DaoFactura;
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
        }else if(dtoFactura.getBanco() == null){
            throw new Excepciones("El dtoPagoFactura debe tener banco asignado.");
        }else if(dtoFactura.getComprobante() == null){
            throw new Excepciones("El dtoPagoFactura debe tener un comprobante de pago.");
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
        this.factura.setFecha(new GregorianCalendar());
        this.factura.setEstatus("pagado");
        this.factura.setComprobante(this.dtoFactura.getComprobante());
        this.factura.setBanco(this.dtoFactura.getBanco());
        this.factura = daoFactura.update(this.factura);
    }

    @Override
    public Factura getResult() throws Excepciones {
        execute();
        return this.factura;
    }
}
