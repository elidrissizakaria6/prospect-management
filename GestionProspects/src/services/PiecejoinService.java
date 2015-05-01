package services;

import java.util.List;

import DAO.Piecejoin;
import DAO.PiecejoinDAO;

public class PiecejoinService {

	PiecejoinDAO IDAO=new PiecejoinDAO();
	
	public void AjouterPiecejoin(Piecejoin I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerPiecejoin(int id)
	{
		IDAO.delete(id);
	}
	
	public void ModifierPiecejoin(Piecejoin I)
	{
		IDAO.update(I);
	}
	
	public List<Piecejoin> AfficherPiecejoins()
	{
		return IDAO.Affiche();
	}
}

