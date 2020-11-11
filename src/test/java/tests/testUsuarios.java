package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelos.ESTADO;
import modelos.PAIS;

public class testUsuarios {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cliente");

    public static void main(String[] args) {

        crearDatos();
        imprimirDatos();

    }

    static void crearDatos() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        PAIS pais = new PAIS(1, "venezuela");
        em.persist(pais);

        em.persist(new ESTADO(1, "caracas", pais));
        em.persist(new ESTADO(2, "maracaibo", pais));

        em.getTransaction().commit();

        em.close();
    }

    static void imprimirDatos() {
        EntityManager em = emf.createEntityManager();
        
        PAIS pais = em.find(PAIS.class, 1);
        List<ESTADO> estados = pais.getEstados();
        
        for (ESTADO estado : estados) {
            System.out.println("* " + estado.toString());
        }

        System.out.println(pais.toString());
    }

}
