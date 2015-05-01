package DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class IntervenantDAO extends bdDAO {
	
	public IntervenantDAO()
	{
		super();
	}
	public void Add(Intervenant a)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(a);
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
	}
	public void delete(int id)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Intervenant where id = '"+id+"'";
        Query q =session.createQuery(hql);
        Intervenant p=(Intervenant)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
	}
	public void update(Intervenant a)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
	}
	public List<Intervenant> Affiche()
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Intervenant a";
        List<Intervenant> list=(List<Intervenant>) session.createQuery(hql).list();
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
    	return list;
    	
	}
	public static void main(String [] args)
	{
		IntervenantDAO uDAO=new IntervenantDAO();
		Intervenant u=new Intervenant("Idrissi","zakaria","045678","@hotmail.com",null);
		uDAO.Add(u);
	}
}