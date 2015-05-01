package Interface;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.NatureevenementService;
import DAO.Natureevenement;

@ManagedBean(name="natureevenementBean")
@SessionScoped
public class NatureevenementBean {
	private Integer idevenement;
	private String libelle;
//	private Set agendas = new HashSet(0);
	
	private Natureevenement selectedNatureevenement;
	private Natureevenement natureevenement;
	private NatureevenementService natureevenementservice=new NatureevenementService();
	private List<Natureevenement> list;
	private List<Natureevenement> filteredNatureevenement;
	public Integer getIdevenement() {
		return idevenement;
	}
	public void setIdevenement(Integer idevenement) {
		this.idevenement = idevenement;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
//	public Set getAgendas() {
//		return agendas;
//	}
//	public void setAgendas(Set agendas) {
//		this.agendas = agendas;
//	}
	public Natureevenement getSelectedNatureevenement() {
		return selectedNatureevenement;
	}
	public void setSelectedNatureevenement(Natureevenement selectedNatureevenement) {
		this.selectedNatureevenement = selectedNatureevenement;
	}
	public Natureevenement getNatureevenement() {
		return natureevenement;
	}
	public void setNatureevenement(Natureevenement natureevenement) {
		this.natureevenement = natureevenement;
	}
	public NatureevenementService getNatureevenementservice() {
		return natureevenementservice;
	}
	public void setNatureevenementservice(
			NatureevenementService natureevenementservice) {
		this.natureevenementservice = natureevenementservice;
	}
	public List<Natureevenement> getList() {
		return list;
	}
	public void setList(List<Natureevenement> list) {
		this.list = list;
	}
	public List<Natureevenement> getFilteredNatureevenement() {
		return filteredNatureevenement;
	}
	public void setFilteredNatureevenement(
			List<Natureevenement> filteredNatureevenement) {
		this.filteredNatureevenement = filteredNatureevenement;
	}
	
public String AppliquerAjouterNatureevenement() {
		
		Natureevenement p=new Natureevenement();
		natureevenementservice.AjouterNatureevenement(p);
		list=natureevenementservice.AfficherNatureevenements();
		setLibelle("");

			return "formulaire";
		}

	public String AppliquerModifierNatureevenement()
	{
		natureevenementservice.ModifierNatureevenement(natureevenement);
		list=natureevenementservice.AfficherNatureevenements();
		return"formulaire";
	}
	public String AfficherNatureevenements()
	{
			list=natureevenementservice.AfficherNatureevenements();
			System.out.println("Afficher hello");
			return "list";
	}
}
