package services;

import java.util.List;

import DAO.NatureEvenementDAO;
import DAO.Natureevenement;

public class NatureevenementService  {


	NatureEvenementDAO IDAO=new NatureEvenementDAO();
	
	public void AjouterNatureevenement(Natureevenement I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerNatureevenement(int id)
	{
		IDAO.delete(id);
	}
	
	public void ModifierNatureevenement(Natureevenement I)
	{
		IDAO.update(I);
	}
	
	public List<Natureevenement> AfficherNatureevenements()
	{
		return (IDAO.Affiche());
	}
}

