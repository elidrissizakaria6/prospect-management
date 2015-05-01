package services;

import java.util.List;

import DAO.Utilisateur;
import DAO.UtilisateurDAO;
import Interface.SessionBean;
public class UtilisateurService {
	public static SessionBean sessionBean=new SessionBean();

	UtilisateurDAO IDAO=new UtilisateurDAO();
	
	public void AjouterUtilisateur(Utilisateur I)
	{
		IDAO.Add(I);
	}
	
	public void SupprimerUtilisateur(int id)
	{
		IDAO.delete(id);
	}
	
	public void ModifierUtilisateur(Utilisateur I)
	{
		IDAO.update(I);
	}
	
	public List<Utilisateur> AfficherUtilisateurs()
	{
		return (IDAO.Affiche());
	}
	public boolean Authentification(String Login,String MotDePasse)
	{
		List <Utilisateur>list=AfficherUtilisateurs();
		for(int i=0;i<list.size();i++)
		{
			Utilisateur u=list.get(i);
			if((u.getNom().equals(Login)&&(u.getMotdepasse().equals(MotDePasse)))){ System.out.println("c'est fait");sessionBean.setUtilisateur(u); return true;}
		}
		return false;
	}
	public static void main(String [] args)
	{
//		UtilisateurService us=new UtilisateurService();
//		Utilisateur u=new Utilisateur("root","root");
//		us.AjouterUtilisateur(u);
//		List list=us.AfficherUtilisateurs();
//		Utilisateur user=(Utilisateur) list.get(0);
//		System.out.println(user.getNom());
	}
}

