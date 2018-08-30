package br.com.projeto.teste.pais;

import br.com.projeto.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteInserePais {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
        
        EntityManager em = emf.createEntityManager();
        
        Pais pais = new Pais();
        pais.setNome("Estados Unidos");
        pais.setIso("US");
        
        try {
            em.getTransaction().begin();
            em.persist(pais);
            em.getTransaction().commit();
        
            System.out.println("Pais inserido com sucesso!"); 
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Erro ao inserir: " + ex.getMessage());
        }
        
        em.close();
        emf.close();
    }
}
