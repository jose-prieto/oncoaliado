package oncoaliado.Comandos.TipoCita;

import accesos.DaoFactory;
import accesos.Daos.DaoTipoCita;
import entidades.TipoCita;
import excepciones.Excepciones;
import excepciones.exceptions;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoFactory;
import transfer.DtoTipoCita;

import java.util.*;

public class ComandoGetTipoCitas extends ComandoBase {

    private List<TipoCita> tipoCitas = null;
    private List<DtoTipoCita> dtoTipoCitas = new ArrayList<DtoTipoCita>();

    @Override
    public void execute() throws Exception {
        DaoTipoCita daoTipoCita = new DaoTipoCita();
        this.tipoCitas = daoTipoCita.findAll(TipoCita.class);
        for(TipoCita obj: this.tipoCitas) {
            DtoTipoCita dtoTipoCita = DtoFactory.DtoTipoCitaInstancia();
            dtoTipoCita.setNombre(obj.getNombre());
            dtoTipoCita.setDescripcion(obj.getDescripcion());
            dtoTipoCita.setPrecio(daoTipoCita.getPrecio(obj));
            dtoTipoCita.setId(obj.getId());

            this.dtoTipoCitas.add(dtoTipoCita);
        }
    }

    @Override
    public List<DtoTipoCita> getResult() {
        return this.dtoTipoCitas;
    }

}
