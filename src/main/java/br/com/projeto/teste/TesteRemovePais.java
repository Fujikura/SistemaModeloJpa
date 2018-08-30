package br.com.projeto.teste;

import br.com.projeto.modelo.Pais;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteRemovePais {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
        
        EntityManager em = emf.createEntityManager();
        
        
        
        try {
            Pais pais = em.find(Pais.class, 3L);
        
            em.getTransaction().begin();
            em.remove(pais);
            em.getTransaction().commit();
        
            System.out.println("Pais removido com sucesso!"); 
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Erro ao remover: " + ex.getMessage());
        }
        
        em.close();
        emf.close();
    }
}
