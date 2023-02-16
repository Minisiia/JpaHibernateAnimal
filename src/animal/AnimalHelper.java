package animal;

import animal.entity.Animal;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AnimalHelper {
    private SessionFactory sessionFactory;

    public AnimalHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Animal> getAnimalList(){
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Animal.class);
        List<Animal> list = criteria.list();
        session.close();
        return list;
    }

    public Animal addAnimal(Animal animal){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
        return animal;
    }
}
