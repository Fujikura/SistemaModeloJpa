package br.com.projeto.teste.pais;

import br.com.projeto.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteAlterarPais {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
        
        EntityManager em = emf.createEntityManager();
        
        
        
        try {
            Pais pais = em.find(Pais.class, 1L);
            pais.setNome("Brasil");
            pais.setIso("BR");
            em.getTransaction().begin();
            em.merge(pais);
            em.getTransaction().commit();
        
            System.out.println("Pais alterado com sucesso!"); 
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Erro ao alterar: " + ex.getMessage());
        }
        
        em.close();
        emf.close();
    }
}
