package transport.company.dao;
import config.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class TemplateDAO<Type> implements DAO<Type> {
    @Override
    public Type get(long id, Class<Type> classType) {
        Type company;
        try (Session session = SessionFactoryUtil.getCurrentSessionFromConfig().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(classType, id);
            transaction.commit();
        }
        return company;
    }
    @Override
    public List<Type> getAll() {
        List<Type> result;
        try (Session session = SessionFactoryUtil.getCurrentSessionFromConfig().openSession()){
            session.beginTransaction();
            result = session.createQuery("SELECT t FROM classType t").getResultList();
            session.getTransaction().commit();
        }
        return result;
    }
    @Override
    public  void add(Type data) {
        try (Session session = SessionFactoryUtil.getCurrentSessionFromConfig().openSession()){
            session.beginTransaction();
            session.save(data);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Type data) {
        try (Session session = SessionFactoryUtil.getCurrentSessionFromConfig().openSession()){
            session.beginTransaction();
            session.remove(data);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Type data) {
        try (Session session = SessionFactoryUtil.getCurrentSessionFromConfig().openSession()){
            session.beginTransaction();
            session.saveOrUpdate(data);
            session.getTransaction().commit();
        }
    }
}
