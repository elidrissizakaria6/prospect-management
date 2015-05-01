package Interface;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import services.IntervenantService;
import DAO.Intervenant;
@ManagedBean(name="IntervenantBean")
@SessionScoped
public class IntervenantBean {
	private Integer idIntervenant;
	private String nom;
	private String prenom;
	private String portable;
	private String email;
//	private Set agendas = new HashSet(0);
	
	private  Intervenant selectedIntervenant;
	private static Intervenant intervenant;
	private IntervenantService intervenantservice=new IntervenantService();
	private static List<Intervenant> list;
	private List<Intervenant> filteredIntervenants;
	private UtilisateurBean utilisateurBean =new UtilisateurBean();
	private ProspectBean pb=new ProspectBean();
	private boolean modifier;
	private boolean ajouter;
	private static AgendaBean agendabean=new AgendaBean();
	public IntervenantBean()
	{
		AfficherIntervenants();
	}
	public ProspectBean getPb() {
		return pb;
	}
	public void setPb(ProspectBean pb) {
		this.pb = pb;
	}
	public boolean isModifier() {
		return modifier;
	}
	public void setModifier(boolean modifier) {
		this.modifier = modifier;
	}
	public boolean isAjouter() {
		return ajouter;
	}
	public void setAjouter(boolean ajouter) {
		this.ajouter = ajouter;
	}
	public Intervenant getIntervenant() {
		return intervenant;
	}
	public void setIntervenant(Intervenant intervenant) {
		IntervenantBean.intervenant = intervenant;
	}
	public Integer getIdIntervenant() {
		return idIntervenant;
	}
	public void setIdIntervenant(Integer idIntervenant) {
		this.idIntervenant = idIntervenant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		 this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPortable() {
		return portable;
	}
	public void setPortable(String portable) {
		this.portable = portable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public Set getAgendas() {
//		return agendas;
//	}
//	public void setAgendas(Set agendas) {
//		this.agendas = agendas;
//	}
	public Intervenant getSelectedIntervenant() {
		return selectedIntervenant;
	}
	public void setSelectedIntervenant(Intervenant selectedIntervenant) {
		this.selectedIntervenant = selectedIntervenant;
	}
	public Intervenant getProspect() {
		return intervenant;
	}
	public void setProspect(Intervenant intervenant) {
		IntervenantBean.intervenant = intervenant;
	}
	public IntervenantService getIntervenantservice() {
		return intervenantservice;
	}
	public void setIntervenantservice(IntervenantService intervenantservice) {
		this.intervenantservice = intervenantservice;
	}
	public List<Intervenant> getList() {
		return list;
	}
	public void setList(List<Intervenant> list) {
		IntervenantBean.list = list;
	}
	public List<Intervenant> getFilteredIntervenants() {
		return filteredIntervenants;
	}
	public void setFilteredIntervenants(List<Intervenant> filteredIntervenants) {
		this.filteredIntervenants = filteredIntervenants;
	}
	public AgendaBean getAgendabean() {
		return agendabean;
	}
	public void setAgendabean(AgendaBean agendabean) {
		IntervenantBean.agendabean = agendabean;
	}
	public UtilisateurBean getUtilisateurBean() {
		return utilisateurBean;
	}
	public void setUtilisateurBean(UtilisateurBean utilisateurBean) {
		this.utilisateurBean = utilisateurBean;
	}
	public String viderlist()
	{
		agendabean.getList().removeAll(agendabean.getList());
		selectedIntervenant=null;
		return "GestionIntervenant";
	}
	public String AjouterProspect()
	{
		setEmail(null);
		setNom(null);
		setPrenom(null);
		setPortable(null);
		setAjouter(true);
		setModifier(false);
		return "AjouterIntervenant";
	}
	
public String AppliquerAjouterIntervenant() {
	Intervenant p = null;
		try
		{
		 p=new Intervenant(getNom(),getPrenom(),getPortable(),getEmail(),null);
		}catch(Exception e ){e.printStackTrace();}
		try
		{
		intervenantservice.AjouterIntervenant(p);
		list=intervenantservice.AfficherIntervenants();
		char [] tmp=getNom().toCharArray();
		char []tmp2=new char[tmp.length+2];
		tmp2[0]=getPrenom().charAt(0);
		tmp2[1]='.';
		int j=2;
		for(int i=0;i<tmp.length;i++)
		{
			if(tmp[i]!=' ') { tmp2[j]=tmp[i]; j++; }
		}
		nom=String.valueOf(tmp2);
		nom=nom.toUpperCase();
		utilisateurBean.AppliquerAjouterUtilisateur(getNom(),null,false);
		}catch(Exception e ){e.printStackTrace();}
		setEmail(null);
		setNom(null);
		setPrenom(null);
		setPortable(null);
		return null;

		}
public String AppliquerAjouterIntervenantQuitter() {
	Intervenant p = null;
		try
		{
		 p=new Intervenant(getNom(),getPrenom(),getPortable(),getEmail(),null);
		}catch(Exception e ){e.printStackTrace();}
		try
		{
		intervenantservice.AjouterIntervenant(p);
		list=intervenantservice.AfficherIntervenants();
		char [] tmp=getNom().toCharArray();
		char []tmp2=new char[tmp.length+2];
		tmp2[0]=getPrenom().charAt(0);
		tmp2[1]='.';
		int j=2;
		for(int i=0;i<tmp.length;i++)
		{
			if(tmp[i]!=' ') { tmp2[j]=tmp[i]; j++; }
		}
		nom=String.valueOf(tmp2);
		nom=nom.toUpperCase();
		utilisateurBean.AppliquerAjouterUtilisateur(getNom(),null,false);
		}catch(Exception e ){e.printStackTrace();}
		setEmail(null);
		setNom(null);
		setPrenom(null);
		setPortable(null);
		return "GestionIntervenant";

		}
public String ModifierIntervenant(Intervenant i)
{
	setModifier(true);
	setAjouter(false);
	
	setEmail(null);
	setNom(null);
	setPrenom(null);
	setPortable(null);
	intervenant = i;
	setEmail(intervenant.getEmail());
	setNom(intervenant.getNom());
	setPrenom(intervenant.getPrenom());
	setPortable(intervenant.getPortable());
		return "AjouterIntervenant";
}
	public String AppliquerModifierIntervenant()
	{
		intervenant.setEmail(getEmail());
		intervenant.setNom(getNom());
		intervenant.setPortable(getPortable());
		intervenant.setPrenom(getPrenom());
		intervenantservice.ModifierIntervenant(intervenant);
		list=intervenantservice.AfficherIntervenants();
		char [] tmp=getNom().toCharArray();
		char []tmp2=new char[tmp.length];
		int j=0;
		for(int i=0;i<tmp.length;i++)
		{
			if(tmp[i]!=' ') { tmp2[j]=tmp[i]; j++; }
		}
		nom=String.valueOf(tmp2);
		utilisateurBean.AppliquerModifierUtilisateur(getNom());
		setEmail(null);
		setNom(null);
		setPrenom(null);
		setPortable(null);
		return"GestionIntervenant";
	}
	public String AfficherIntervenants()
	{
			list=intervenantservice.AfficherIntervenants();
			System.out.println("Afficher hello");
			return "list";
	}
	public void onRowSelect(SelectEvent se)
	{
		setIntervenant(selectedIntervenant);
		agendabean.setIntervenant(getIntervenant());
	try{
		AgendaBean.AfficherAgendasInt(getIntervenant());
	}catch(Exception e){e.printStackTrace();}
	System.out.print("ca marche encore");
	}
	public boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}
}
