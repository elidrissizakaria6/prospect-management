package DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class UtilisateurDAO extends bdDAO {
	public void Add(Utilisateur a)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(a);
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
	}
	public void delete(int id)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Utilisateur where id = '"+id+"'";
        Query q =session.createQuery(hql);
        Utilisateur p=(Utilisateur)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
	}
	public void update(Utilisateur a)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
	}
	public List<Utilisateur> Affiche()
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Utilisateur a";
        List<Utilisateur> list=(List<Utilisateur>) session.createQuery(hql).list();
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
    	return list;
    	
	}
	
}