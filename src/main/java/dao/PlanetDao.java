package dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Planet;
import util.HibernateSessionFactoryUtil;

import java.util.List;


public class PlanetDao {
    public Planet findById(String id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Planet.class, id);

    }

    public Planet create(String planeId, String planetName) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Planet planet = new Planet(planeId, planetName);
        session.persist(planet);
        tx1.commit();
        session.close();
        return planet;
    }

    public void update(Planet planet) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(planet);
        tx1.commit();
        session.close();
    }

    public void delete(Planet planet) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(planet);
        tx1.commit();
        session.close();
    }


    public List<Planet> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Planet", Planet.class).list();


    }

}
