package DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class PiecejoinDAO extends bdDAO {
	public void Add(Piecejoin a)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(a);
    	session.getTransaction().commit();
//    	session.close();
	}
	public void delete(int id)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Piecejoin where id = '"+id+"'";
        Query q =session.createQuery(hql);
        Piecejoin p=(Piecejoin)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
//    	session.close();
	}
	public void update(Piecejoin a)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession(); 
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
//    	session.close();
	}
	public List<Piecejoin> Affiche()
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Piecejoin a";
        List<Piecejoin> list=(List<Piecejoin>) session.createQuery(hql).list();
    	session.getTransaction().commit();
//    	session.close();
    	return list;
    	
	}
	public static void main(String [] args)
	{
		PiecejoinDAO uDAO=new PiecejoinDAO();
		Piecejoin u=new Piecejoin();
		uDAO.Add(u);
	}
}