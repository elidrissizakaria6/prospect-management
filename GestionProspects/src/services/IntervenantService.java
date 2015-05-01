package services;

import java.util.List;

import DAO.Intervenant;
import DAO.IntervenantDAO;

public class IntervenantService {

	IntervenantDAO IDAO=new IntervenantDAO();
	
	public void AjouterIntervenant(Intervenant I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerIntervenant(int id)
	{
		IDAO.delete(id);
	}
	
	public void ModifierIntervenant(Intervenant I)
	{
		IDAO.update(I);
	}
	
	public List<Intervenant> AfficherIntervenants()
	{
		return(IDAO.Affiche());
	}
}
