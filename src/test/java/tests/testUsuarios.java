package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testUsuarios {
    
    private static EntityManager manager;
    
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        
        emf = Persistence.createEntityManagerFactory("cliente");
        manager = emf.createEntityManager();
        
        List paises =  manager.createQuery("FROM PAIS").getResultList();
        System.out.println("Existen: " + paises.size() + " paises.");
        
    }
    
    
}