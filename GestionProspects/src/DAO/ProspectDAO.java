package DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class ProspectDAO extends bdDAO {
//	Configuration configuration;
//	StandardServiceRegistryBuilder ssrb;
//	SessionFactory sessionFactory ;
//	 Session session;
	public ProspectDAO()
	{
	super();
//	configuration = new Configuration();
//	configuration.configure("hibernate.cfg.xml");
//	 ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//	 sessionFactory = configuration.buildSessionFactory(ssrb.build());
//	
	}
	public void Add(Prospect a)
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
        String hql = "from Prospect where id = '"+id+"'";
        Query q =session.createQuery(hql);
        Prospect p=(Prospect)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
	}
	public void update(Prospect a)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
	}
	public List<Prospect> Affiche()
	{

		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Prospect a";
        List<Prospect> list=(List<Prospect>) session.createQuery(hql).list();
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
    	return list;
    	
	}
	public static void main(String [] args)
	{
		ProspectDAO uDAO=new ProspectDAO();
//		Prospect u=new Prospect("ABNSOFT","06234567");
//		uDAO.Add(u);
	}
}