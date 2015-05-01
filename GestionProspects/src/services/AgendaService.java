package services;

import java.util.Date;
import java.util.List;

import DAO.Agenda;
import DAO.AgendaDAO;
import DAO.Prospect;

public class AgendaService {

	AgendaDAO IDAO=new AgendaDAO();
	
	public void AjouterAgenda(Agenda I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerAgenda(Date h)
	{
		IDAO.delete(h);
	}
	
	public void ModifierAgenda(Agenda I)
	{
		IDAO.update(I);
	}
	
	public List<Agenda> AfficherAgendas()
	{
		return(IDAO.Affiche());
	}
	public List<Agenda> AfficherAgendas(Prospect prospect)
	{
		return(IDAO.Affiche(prospect));
	}
	public static void main(String [] args)
	{
//		AgendaService as=new AgendaService();
//		Calendar c = Calendar.getInstance ();
//		Date date = c.getTime ();
//		Intervenant i=new Intervenant("zakaria","zaza","0987654","sdfdfdf",null);
//		i.setIdIntervenant(1);
//		Natureevenement n=new Natureevenement("Rendez vous");
//		n.setIdevenement(1);
		Prospect p=new Prospect();
		p.setIdProspect(1);
		Agenda u=new Agenda();
		u.setId(1);
//		uDAO.Add(u);
//		List list=as.AfficherAgendas(p);
//		Agenda a=(Agenda) list.get(0);		
//		System.out.println(a.getLieu());
	}
}

