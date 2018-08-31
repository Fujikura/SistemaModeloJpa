package br.com.projeto.estado;

import br.com.projeto.jpa.EntityManagerUtil;
import br.com.projeto.modelo.Pais;
import javax.persistence.EntityManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirPais {
    
    EntityManager em;
    
    public TestePersistirPais() {
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
           Pais pais = new Pais();
           pais.setNome("BRASIL");
           pais.setIso("BR");
            
            em.getTransaction().begin();
            em.persist(pais);
            em.getTransaction().commit();
            System.out.println("País adicionado com sucesso!");
        } catch (Exception e) {
            
            exception = true;
            e.printStackTrace();
        }
        
        assertEquals(false, exception);
        
    }
    
}
