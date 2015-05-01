package Interface;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.UtilisateurService;
import DAO.Utilisateur;
@ManagedBean(name="utilisateurBean")
@SessionScoped
public class UtilisateurBean {
	private int idUtilisateur;
	private String nom;
	private String motdepasse;
	private boolean admin;
	private static List<Utilisateur> list=new  ArrayList<Utilisateur>();
	private static List<Utilisateur> tmplist=new ArrayList<Utilisateur>();
	private boolean isLoggedIn;
	
	private Utilisateur utilisateur;
	private UtilisateurService utilisateurservice= new UtilisateurService() ;
	
	private boolean ajouter;
	private boolean modifier;
	public UtilisateurBean()
	{
		
	}
	
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public UtilisateurService getUtilisateurservice() {
		return utilisateurservice;
	}

	public void setUtilisateurservice(UtilisateurService utilisateurservice) {
		this.utilisateurservice = utilisateurservice;
	}

	public List<Utilisateur> getList() {
		return list;
	}

	public void setList(List<Utilisateur> list) {
		UtilisateurBean.list = list;
	}

	public List<Utilisateur> getTmplist() {
		return tmplist;
	}

	public void setTmplist(List<Utilisateur> tmplist) {
		UtilisateurBean.tmplist = tmplist;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public boolean isAjouter() {
		return ajouter;
	}

	public void setAjouter(boolean ajouter) {
		this.ajouter = ajouter;
	}

	public boolean isModifier() {
		return modifier;
	}

	public void setModifier(boolean modifier) {
		this.modifier = modifier;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String AjouterUtilisateur()
	{
		setNom(null);
		setMotdepasse(null);
		setAjouter(true);
		setModifier(false);
		return "AjouterUtilisateur";
	}
	
public String AppliquerAjouterUtilisateur() {
	Utilisateur p = null;
		try
		{
		 p=new Utilisateur(getNom(),getMotdepasse(),isAdmin());
		}catch(Exception e ){e.printStackTrace();}
		try
		{
		utilisateurservice.AjouterUtilisateur(p);
		list=utilisateurservice.AfficherUtilisateurs();
		}catch(Exception e ){e.printStackTrace();}
		setNom(null);
		setMotdepasse(null);
		return "GestionUtilisateur";
		}
public String AppliquerAjouterUtilisateur(String nom, String mdp,boolean b) {
	Utilisateur p = null;
		try
		{
		 p=new Utilisateur(nom,mdp,b);
		}catch(Exception e ){e.printStackTrace();}
		try
		{
		utilisateurservice.AjouterUtilisateur(p);
		list=utilisateurservice.AfficherUtilisateurs();
		}catch(Exception e ){e.printStackTrace();}
		setNom(null);
		setMotdepasse(null);
		return "GestionUtilisateur";
		}

public String ModifierUtilisateur(Utilisateur i)
{
	setModifier(true);
	setAjouter(false);
	
	setNom(null);
	setMotdepasse(null);
	utilisateur = i;
	setNom(utilisateur.getNom());
	setMotdepasse(utilisateur.getMotdepasse());
	
		return "AjouterUtilisateur";
}
	public String AppliquerModifierUtilisateur()
	{
		utilisateur.setNom(getNom());
		utilisateur.setMotdepasse(getMotdepasse());
		utilisateurservice.ModifierUtilisateur(utilisateur);
		list=utilisateurservice.AfficherUtilisateurs();
		setNom(null);
		setMotdepasse(null);
		return "GestionUtilisateur";
	}
	public String AfficherAdmins()
	{
		try{
		list.removeAll(list);
		tmplist.removeAll(tmplist);
		}catch(Exception e){e.printStackTrace();}
		list=utilisateurservice.AfficherUtilisateurs();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).isAdmin()==true) tmplist.add(list.get(i));
		}
		return null;
	}
	public String AppliquerModifierUtilisateur(String nom)
	{
		utilisateur.setNom(nom);
		utilisateurservice.ModifierUtilisateur(utilisateur);
		list=utilisateurservice.AfficherUtilisateurs();
		setNom(null);
		setMotdepasse(null);
		return "GestionUtilisateur";
	}
	public static void main(String[] args)
	{
//		UtilisateurBean ub=new UtilisateurBean();
//		Utilisateur u=new Utilisateur();
//		String s=ub.authentification();
	}
}
