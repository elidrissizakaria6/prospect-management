package Interface;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import services.UtilisateurService;
import DAO.Utilisateur;

@ManagedBean(name="SessionBean")
@SessionScoped
public class SessionBean {
	
	private int idUtilisateur;
	private static String nom;
	private static String motdepasse;
	private List<Utilisateur> list;
	private String erreur=null;
	private boolean isLoggedIn;
	private static Utilisateur utilisateur;
	private UtilisateurService utilisateurservice= new UtilisateurService() ;
	private static UtilisateurBean utilisateurBean =new UtilisateurBean();
	private static boolean ajoutermdp=false;
	private static boolean supprimermdp=true;
	private static boolean admin;
	private static AgendaBean agendaBean=new AgendaBean();
	public SessionBean()
	{
		 ajoutermdp=false;
		 supprimermdp=true;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		SessionBean.nom = nom;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		SessionBean.motdepasse = motdepasse;
	}
	public List<Utilisateur> getList() {
		return list;
	}
	public void setList(List<Utilisateur> list) {
		this.list = list;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		SessionBean.utilisateur = utilisateur;
	}
	public boolean isSupprimermdp() {
		return supprimermdp;
	}

	public void setSupprimermdp(boolean supprimermdp) {
		SessionBean.supprimermdp = supprimermdp;
	}

	public boolean isAjoutermdp() {
		return ajoutermdp;
	}

	public void setAjoutermdp(boolean ajoutermdp) {
		SessionBean.ajoutermdp = ajoutermdp;
	}
	public UtilisateurService getUtilisateurservice() {
		return utilisateurservice;
	}
	public void setUtilisateurservice(UtilisateurService utilisateurservice) {
		this.utilisateurservice = utilisateurservice;
	}
	
	public UtilisateurBean getUtilisateurBean() {
		return utilisateurBean;
	}
	public void setUtilisateurBean(UtilisateurBean utilisateurBean) {
		SessionBean.utilisateurBean = utilisateurBean;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		SessionBean.admin = admin;
	}
	public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	public String AjouterMotdepasse()
	{
		setAjoutermdp(true);
		setSupprimermdp(false);
		return "Ajoutermotdepasse";
	}
	public String AppliquerAjouterMotdepasse()
	{
		System.out.print("jesuismalade");
		list=utilisateurservice.AfficherUtilisateurs();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getNom().equals(getNom()))
			{
				if(list.get(i).getMotdepasse()==null)
					{
					utilisateur=list.get(i); setMotdepasse(motdepasse); utilisateur.setMotdepasse(getMotdepasse());
					utilisateurservice.ModifierUtilisateur(utilisateur);
					}
			}
		}
		return null;
	}
	public String login(){  
		  //default url in case of login failure;  
		  String url="Login.xhtml";  
		   if(isAjoutermdp()==true) {AppliquerAjouterMotdepasse();}
		  //user a custom method to authenticate a user  
		    nom=nom.toUpperCase();
		  if(utilisateurservice.Authentification(nom,motdepasse)){
		   //changed the state to true  
		   isLoggedIn=true;  
		   admin=utilisateur.isAdmin();
		   url="GestionProspect";
		  }
		   else{  
			   erreur="Vérifier le Login ou le mot de passe";
		   //set the message to display when authentication fails  
		   FacesContext.getCurrentInstance().addMessage("frmLogin:btnLogin", new FacesMessage("Invalid Username and or Password"));  
		  }
		  return url;  
		 }  
		  
		 /** 
		 * An event listener for redirecting the user to login page if he/she is not currently logged in 
		 * @param event 
		 */  
		 public void verifyUseLogin(ComponentSystemEvent event){  
		  if(!isLoggedIn){  
		   doRedirect("Login.xhtml");  
		  }  
		 } 
		 public void verifyUseAdmin(ComponentSystemEvent event){  
			  if(!isAdmin()){  
			   doRedirect("GestionProspect.xhtml");  
			  }  
			 } 
		  
		 /** 
		 * Method for redirecting a request 
		 * @param url 
		 */  
		 private void doRedirect(String url){  
		  try {  
		   FacesContext context=FacesContext.getCurrentInstance();  
		   context.getExternalContext().redirect(url);  
		  } catch (IOException e) {  
		   e.printStackTrace();  
		  }  
		 }
		 public String sedeconnecter() throws IOException
		 {
			 isLoggedIn=false;
			 setAjoutermdp(false);
			 setSupprimermdp(true);
			 agendaBean.viderlist();
			 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			 FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
			 
			 
			 return "Login";
		 }
		 public void deco(ActionEvent actionEvent){
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");
				
				FacesContext.getCurrentInstance().addMessage(null, message);
				
			}
		  
		 
		  
}
