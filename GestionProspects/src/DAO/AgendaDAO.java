package DAO;



import java.util.Calendar;
import java.util.Date;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.relational.Database;





public class AgendaDAO extends bdDAO {
//	Configuration configuration;
//	StandardServiceRegistryBuilder ssrb;
//	SessionFactory sessionFactory;
//	Session session;
	
	public AgendaDAO()
	{
		super();
//	 configuration = new Configuration();
//	 configuration.configure("hibernate.cfg.xml");
//	 ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//    sessionFactory = configuration.buildSessionFactory(ssrb.build());
     
	}
	public void Add(Agenda a)
	{
		
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(a);
    	session.getTransaction().commit();
//    	sessionFactory.close();
//    	session.close();
	}
	public void delete(Date date)
	{
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Agenda where date = '"+date+"'";
        Query q =session.createQuery(hql);
        Agenda p=(Agenda)q.list().get(0);
        session.delete(p);
    	session.getTransaction().commit();
    	sessionFactory.close();
//    	session.close();
	}
	public void update(Agenda a)
	{
		
		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(a);
    	session.getTransaction().commit();
    	
//    	sessionFactory.close();
//    	session.close();
	}
	public List<Agenda> Affiche()
	{


		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT a FROM Agenda a";
        List<Agenda> list=(List<Agenda>) session.createQuery(hql).list();
    	session.getTransaction().commit();
//    	session.close();
//    	sessionFactory.close();
    	return list;
    	
	}
	public List<Agenda> Affiche(Prospect prospect)
	{
	

		SessionFactory sessionFactory =createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Agenda where keyprospect='"+prospect.getIdProspect()+"'";
        List<Agenda> list=(List<Agenda>) session.createQuery(hql).list();
    	session.getTransaction().commit();
//    	sessionFactory.close();
//    	session.close();
    	return list;
    	
	}
	public static void main(String [] args)
	{
		AgendaDAO uDAO=new AgendaDAO();
//		Calendar c = Calendar.getInstance ();
//		Date date = c.getTime ();
//		Intervenant i=new Intervenant("zakaria","zaza","0987654","sdfdfdf",null);
//		i.setIdIntervenant(1);
//		Natureevenement n=new Natureevenement("Rendez vous");
//		n.setIdevenement(1);
//		Prospect p=new Prospect();
//		p.setIdProspect(1);
//		Agenda u=new Agenda(date,i,n,p,120);
//		uDAO.Add(u);
		List list=uDAO.Affiche();
		Agenda a=(Agenda) list.get(1);		
		System.out.println(a.getLieu());
	}
}