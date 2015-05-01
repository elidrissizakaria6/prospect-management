package DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class StatutDAO extends bdDAO {
	public StatutDAO()
	{
		super();
	}
	public void Add(Statut a)
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
        String hql = "from Statut where id = '"+id+"'";
        Query q =session.createQuery(hql);
        Statut p=(Statut)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
	}
	public void update(Statut a)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
	}
	public List<Statut> Affiche()
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Statut a";
        List<Statut> list=(List<Statut>) session.createQuery(hql).list();
    	session.getTransaction().commit();
//    	session.close();
    	sessionFactory.close();
    	return list;
    	
	}
	public static void main(String [] args)
	{
		StatutDAO uDAO=new StatutDAO();
		Statut u=new Statut("En cours","CRS");
		u.setStatutevenement(true);
		u.setStatutprospect(false);
		uDAO.Add(u);
	}
}