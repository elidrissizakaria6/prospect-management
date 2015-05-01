package services;

import java.util.List;

import DAO.Statut;
import DAO.StatutDAO;

public class StatutService {

	StatutDAO IDAO=new StatutDAO();
	
	public void AjouterStatut(Statut I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerStatut(int id)
	{
		IDAO.delete(id);
	}
	
	public void ModifierStatut(Statut I)
	{
		IDAO.update(I);
	}
	
	public List<Statut> AfficherStatuts()
	{
		 return IDAO.Affiche();
	}
}

