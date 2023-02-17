package animal;

import animal.entity.Animal;
import org.hibernate.Criteria;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AnimalHelper {
    EntityManagerFactory emf;
    EntityManager em;

    public AnimalHelper() {
        emf = Persistence.createEntityManagerFactory("animalmanager");
        em = emf.createEntityManager();
    }

    public List<Animal> getAnimalList() {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT animal_table FROM Animal animal_table");
        List<Animal> list = query.getResultList();
        em.getTransaction().commit();
        emf.close();
        return list;
    }

    public void addAnimal(Animal animal) {
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        emf.close();
    }

    public void removeAnimal(Animal animal) {
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
        emf.close();
    }

    public Animal getById(int id) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        emf.close();
        return animal;
    }

    public void update(int id,String name) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        animal.setName(name);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(int id, int age) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        animal.setAge(age);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(int id, boolean tail) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        animal.setTail(tail);
        em.getTransaction().commit();
        emf.close();
    }

}
