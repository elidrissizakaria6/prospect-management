package Interface;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.ProspectService;
import services.RepresentantService;
import DAO.Prospect;
import DAO.Representant;

@ManagedBean(name="RepresentantBean")@SessionScoped

public class RepresentantBean {
	private Integer idRepresantant;
	private static Prospect prospect;
	private  String nom;
	private  String prenom;
	private  String telephone;
	private  String ville;
	
	private Representant selectedRepresentant;
	private static Representant representant;
	private RepresentantService representantservice=new RepresentantService();
	private static List<Representant> list=new ArrayList<Representant>();
	private static List<Representant> tmplist=new ArrayList<Representant>();
	private static List<Representant> supplist=new ArrayList<Representant>();
	private List<Representant> filteredRepresentant;
	
	private String erreur=null;
	private ProspectBean prospectbean;
	private ProspectService prospectservice;
	private static boolean ajouter;
	private static  boolean modifier;
	
	public RepresentantBean() {

	}
	public Integer getIdRepresantant() {
		return idRepresantant;
	}
	public void setIdRepresantant(Integer idRepresantant) {
		this.idRepresantant = idRepresantant;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Representant getSelectedRepresentant() {
		return selectedRepresentant;
	}
	public void setSelectedRepresentant(Representant selectedRepresentant) {
		this.selectedRepresentant = selectedRepresentant;
	}
	public Representant getRepresentant() {
		return representant;
	}
	public void setRepresentant(Representant representant) {
		RepresentantBean.representant = representant;
	}
	public RepresentantService getRepresentantservice() {
		return representantservice;
	}
	public void setRepresentantservice(RepresentantService representantservice) {
		this.representantservice = representantservice;
	}
	public List<Representant> getList() {
		return list;
	}
	public void setList(List<Representant> list) {
		RepresentantBean.list = list;
	}
	public List<Representant> getFilteredRepresentant() {
		return filteredRepresentant;
	}
	public void setFilteredRepresentant(List<Representant> filteredRepresentant) {
		this.filteredRepresentant = filteredRepresentant;
	}
	
public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
public Prospect getProspect() {
		return prospect;
	}
	public void setProspect(Prospect prospect) {
		RepresentantBean.prospect = prospect;
	}
public ProspectBean getProspectbean() {
		return prospectbean;
	}
	public void setProspectbean(ProspectBean prospectbean) {
		this.prospectbean = prospectbean;
	}
public ProspectService getProspectservice() {
		return prospectservice;
	}
	public void setProspectservice(ProspectService prospectservice) {
		this.prospectservice = prospectservice;
	}
	
public  boolean isAjouter() {
		return ajouter;
	}
	public  void setAjouter(boolean ajouter) {
		RepresentantBean.ajouter = ajouter;
	}
	public boolean isModifier() {
		return modifier;
	}
	public void setModifier(boolean modifier) {
		RepresentantBean.modifier = modifier;
	}
public List<Representant> getTmplist() {
		return tmplist;
	}
	public void setTmplist(List<Representant> tmplist) {
		RepresentantBean.tmplist = tmplist;
	}
public static List<Representant> getSupplist() {
		return supplist;
	}
	public static void setSupplist(List<Representant> supplist) {
		RepresentantBean.supplist = supplist;
	}
public String AjouterRepresentant()
	{
	setNom("");
	setPrenom("");
	setTelephone("");
	setVille("");
	setAjouter(true);
	setModifier(false);
		return "representant";
	}

public String AppliquerAjouterRepresentant() {
	setAjouter(true);
	setModifier(false);
		
		tmplist.removeAll(list);
		for(int i=0;i<tmplist.size();i++)
		{
			tmplist.get(i).setProspect(prospect);
			representantservice.AjouterRepresentant(tmplist.get(i));
		}
	
			return null;
		}
public String AppliquerAjouterRepresentantQuitter() {
	setAjouter(true);
	setModifier(false);
	
		representant=new Representant(prospect,getNom(),getPrenom(),getTelephone(),getVille());
	
		tmplist.removeAll(list);
		for(int i=0;i<tmplist.size();i++)
		{
			representantservice.AjouterRepresentant(tmplist.get(i));
		}
	System.out.print(representant.toString());
		
			return "AjouterProspect";
		}
public String AppliquerAjouterRepresentantBis()
{
	representant=new Representant(prospect,getNom(),getPrenom(),getTelephone(),getVille());
	tmplist.add(representant);
setNom(null);
setPrenom(null);
setTelephone(null);
setVille(null);
setAjouter(true);
setModifier(false);
return null;
}
public String AppliquerAjouterRepresentantBisQuitter()
{
	representant=new Representant(prospect,getNom(),getPrenom(),getTelephone(),getVille());
	
tmplist.add(representant);
setNom(null);
setPrenom(null);
setTelephone(null);
setVille(null);
setAjouter(true);
setModifier(false);
return "AjouterProspect";
}
	public String ModifierRepresentant(Representant r)
	{
		representant=r;
		setModifier(true);
		setAjouter(false);
		setNom(r.getNom());
		setPrenom(r.getPrenom());
		setTelephone(r.getTelephone());
		setVille(r.getVille());
		return "representant";
	}
	public String AppliquerModifierRepresentant()
	{
		setModifier(true);
		setAjouter(false);
		representant.setNom(getNom());
		representant.setPrenom(getPrenom());
		representant.setTelephone(getTelephone());
		representant.setVille(getVille());
		representantservice.ModifierRepresentant(representant);
		return "AjouterProspect";
	}
	
	public String AfficherRepresentants()
	{		tmplist.removeAll(getTmplist());
			supplist.removeAll(getSupplist());
			list=representantservice.AfficherRepresentants();
			tmplist.addAll(list);
			System.out.println("Afficher hello");
			return "list";
	}
	public String AfficherRepresentants(Prospect p)
	{
		prospect=p;
		list.removeAll(getList());
		tmplist.removeAll(getTmplist());
		supplist.removeAll(getSupplist());
			List<Representant> listbis=representantservice.AfficherRepresentants();
			for(int i=0;i<listbis.size();i++)
			{
				if((listbis.get(i).getProspect().getIdProspect())==p.getIdProspect())
					{
					list.add(listbis.get(i));
					}
			}
			tmplist.addAll(list);
			System.out.println("Afficher hello");
			return "list";
	}
	public String SupprimerPiecejoin(Representant r)
	 {
		
		 tmplist.remove(r);
		 supplist.add(r);
		 return null;
	 }
	 public String AppliquerSupprimerPiecejoin()
	 {
		 try{
		 for(int i=0;i<supplist.size();i++) representantservice.SupprimerRepresentant(supplist.get(i).getIdRepresantant());
				 supplist.removeAll(getSupplist());
		 }catch(Exception e ){e.printStackTrace();}
		 return null;
		 
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
