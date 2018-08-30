package br.com.projeto.teste.pais;

import br.com.projeto.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class TesteValidarPais {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");

        EntityManager em = emf.createEntityManager();

        Pais pais = new Pais();
        pais.setNome("Argentina");
        pais.setIso("AG");

        try {
            em.getTransaction().begin();

            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Pais>> erros = validador.validate(pais);

            if (erros.size() > 0) {
                for (ConstraintViolation<Pais> erro : erros) {
                    System.out.println("Erro: " + erro.getMessage());
                }
            } else {
                em.persist(pais);
                em.getTransaction().commit();

                System.out.println("Pais inserido com sucesso!");
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Erro ao inserir: " + ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
