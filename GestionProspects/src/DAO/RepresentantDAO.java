package DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class RepresentantDAO extends bdDAO {
	public RepresentantDAO()
	{
		super();
	}
	public void Add(Representant a)
	{

		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(a);
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
	}
	public void delete(int id)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Representant where id = '"+id+"'";
        Query q =session.createQuery(hql);
        Representant p=(Representant)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
	}
	public void update(Representant a)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
	}
	public List<Representant> Affiche()
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Representant a";
        List<Representant> list=(List<Representant>) session.createQuery(hql).list();
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
    	return list;
    	
	}
	public static void main(String [] args)
	{
//		RepresentantDAO uDAO=new RepresentantDAO();
//		Representant u=new Representant("idrissi","zakaria","0645678","casablanca");
//		uDAO.Add(u);
	}
}