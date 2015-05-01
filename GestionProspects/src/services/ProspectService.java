package services;

import java.util.List;

import DAO.Prospect;
import DAO.ProspectDAO;

public class ProspectService {

	ProspectDAO IDAO=new ProspectDAO();
	
	public void AjouterProspect(Prospect I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerProspect(int id)
	{
		IDAO.delete(id);
	}
	
	public void ModifierProspect(Prospect I)
	{
		IDAO.update(I);
	}
	
	public List<Prospect> AfficherProspects()
	{
		return(IDAO.Affiche());
	}
	
	public static void main(String [] args)
	{
//		ProspectService us=new ProspectService();
//		Prospect u=new Prospect("root","root");
//		us.AjouterProspect(u);
//		List list=us.AfficherProspects();
//		Prospect user=(Prospect) list.get(0);
//		System.out.println(user.getDenomination());
	}
}

