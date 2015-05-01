package services;

import java.util.List;

import DAO.Representant;
import DAO.RepresentantDAO;

public class RepresentantService {

	RepresentantDAO IDAO=new RepresentantDAO();
	
	public void AjouterRepresentant(Representant I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerRepresentant(int id)
	{
		IDAO.delete(id);
	}
	
	public void ModifierRepresentant(Representant I)
	{
		IDAO.update(I);
	}
	
	public List<Representant> AfficherRepresentants()
	{
		return(IDAO.Affiche());
	}
}

