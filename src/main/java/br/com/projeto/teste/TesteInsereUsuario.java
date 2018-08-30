package br.com.projeto.teste;

import br.com.projeto.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteInsereUsuario {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
        
        EntityManager em = emf.createEntityManager();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Márcio Fujikura");
        usuario.setLogin("marcio");
        usuario.setSenha("123");
        usuario.setAtivo(true);
        
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
