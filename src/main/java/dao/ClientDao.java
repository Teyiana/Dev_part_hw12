package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.Client;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class ClientDao {

    public Client findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }

    public Client create(String clientName) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Client client = new Client(clientName);
        session.persist(client);
        tx1.commit();
        session.close();
        return client;
    }

    public void update(Client client) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(client);
        tx1.commit();
        session.close();
    }

    public void delete(Client client) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(client);
        tx1.commit();
        session.close();
    }

    public List<Client> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Client", Client.class).list();


    }

}
