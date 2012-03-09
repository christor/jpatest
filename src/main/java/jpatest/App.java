package jpatest;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test", new HashMap());
        EntityManager em = emf.createEntityManager();
        TestEntity testEntity = new TestEntity();

        em.getTransaction().begin();
        testEntity = em.merge(testEntity);
        em.flush();
        testEntity = em.merge(testEntity);
        em.flush();
        em.getTransaction().commit();
        System.err.println("ok");
    }
}
