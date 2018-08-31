/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.estado;

import br.com.projeto.jpa.EntityManagerUtil;
import br.com.projeto.modelo.Estado;
import br.com.projeto.modelo.Pais;
import javax.persistence.EntityManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marci
 */
public class TestePersistirEstado {
    
    EntityManager em;
    
    public TestePersistirEstado() {
    }
    
    @Before
    public void setUp() {
        
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste() {
        
        boolean exception = false;
        try {
            
            Pais pais = em.find(Pais.class,7L);
            Estado estado = new Estado();
            estado.setNome("São Paulo");
            estado.setUf("SP");
            estado.setPais(pais);
            
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
        } catch (Exception e) {
            
            exception = true;
            e.printStackTrace();
        }
        
        assertEquals(false, exception);
        
    }
    
}
