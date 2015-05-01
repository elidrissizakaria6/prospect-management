package DAO;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class NatureEvenementDAO extends bdDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NatureEvenementDAO()
	{
		super();
	}
	public void Add(Natureevenement e)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(e);
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
	}
	public void delete(int id)
	{
	
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Natureevenement where id = '"+id+"'";
        Query q =session.createQuery(hql);
        Natureevenement p=(Natureevenement)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
	}
	public void update(Natureevenement a)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
	}
	public List<Natureevenement> Affiche()
	{
	
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Natureevenement a";
        List<Natureevenement> list=(List<Natureevenement>) session.createQuery(hql).list();
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
    	return list;
    	
	}
	public static void main(String [] args)
	{
		NatureEvenementDAO uDAO=new NatureEvenementDAO();
		Natureevenement u=new Natureevenement("Rendez vous");
		uDAO.Add(u);
	}
}