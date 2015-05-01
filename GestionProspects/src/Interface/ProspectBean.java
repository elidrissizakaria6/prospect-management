package Interface;



import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.data.PageEvent;
import org.primefaces.model.UploadedFile;

import services.AgendaService;
import services.PiecejoinService;
import services.ProspectService;
import services.RepresentantService;
import services.StatutService;
import DAO.Prospect;
import DAO.Representant;
import DAO.Statut;
@ManagedBean(name="prospectBean")
@SessionScoped
public class ProspectBean {
	private static boolean piecejoinprospect;
	private Integer idProspect;
	private Representant representant;
	private PiecejoinService piecejoinService;
	private  Statut statut;
	private static String raisonsociale;
	private static String raisonsocialeabrg;
	private static String telephone;
	private String telephone2;
	private String chiffreaffaire;
	private String activite;
	private String secteur;
	private String fax;
	private String siteWeb;
	private String email;
	private String adresse;
	private String ville;
	private String pays="Maroc";
	private Integer nombreeff;
	private static boolean ajouter;
	private static  boolean modifier;
	private static boolean itest;
	private  Prospect selectedProspect;
	private static Prospect prospect;
	private ProspectService prospectservice=new ProspectService();
	private static AgendaService agendaService=new AgendaService();
	private static RepresentantBean representantbean=new RepresentantBean();
	
	
	private ArrayList<String> villes=new ArrayList<String>();
	private String tab[]={"Casablanca","Fès","Oujda","Rabat","Marrakech","Meknès","Tanger","Kénitra","Salé","Agadir","Beni Mellal","Tétouan","Nador"
			,"Safi","Khouribga","El Jadida","Errachidia","Berrechid","Taza"
			,"Mohammédia"
			,"Laâyoune"
			,"Larache"
			,"Ksar el-Kébir"
			,"Inezgane"
			,"Khémisset","Autre"};
	
	private static List<Prospect> list;
	private static List<Prospect> filteredProspects;
	private List<Statut> listStatut;
//	private List<Piecejoin> listPiecejoin;
	private List<Representant> listRepresentant;
	
	private ArrayList<String> listeStatutString=new ArrayList<String>();
	private StatutService statutService=new StatutService();
	private String resultStatut;
	
//	private ArrayList<String> listePiecejoinString=new ArrayList<String>();
//	private PiecejoinService piecejoinservice;
//	private String resultPiecejoin;
	
	private ArrayList<String> listeRepresentantString=new ArrayList<String>();
	private RepresentantService representantservice;
	private String resultrepresentant;
	private boolean checked=false;
	private static Prospect p;
	private static AgendaBean agendabean=new AgendaBean();
	private static PiecejoinBean piecejoinBean=new PiecejoinBean();
	private String erreur=null;
	
	 private UploadedFile file;
	 
	 private boolean representantb=false;
	private List<SelectItem> listIds;
	private SelectItem selectItem;
	
	private boolean autreVille=false;
	public ProspectBean()
	{
		representantb=true;
		AfficherProspects();
		try{
		listStatut=statutService.AfficherStatuts();
	}catch(Exception e){}
		try{
		listRepresentant=representantservice.AfficherRepresentants();
		}catch(Exception e){}
		InitialiserList();	
	}
	
	public boolean isChecked() {
	    return checked;
	}
	public void setChecked(boolean checked) {
	    this.checked = checked;
	}

	public Prospect getProspect() {
		return prospect;
	}

	public void setProspect(Prospect prospect) {
		ProspectBean.prospect = prospect;
	}

	public List<Prospect> getFilteredProspects() {
		return filteredProspects;
	}

	public void setFilteredProspects(List<Prospect> filteredProspects) {
		ProspectBean.filteredProspects = filteredProspects;
	}

	public Integer getIdProspect() {
		return idProspect;
	}
	public void setIdProspect(Integer idProspect) {
		this.idProspect = idProspect;
	}
	public Representant getRepresentant() {
		return representant;
	}
	public void setRepresentant(Representant representant) {
		this.representant = representant;
	}
//	public Piecejoin getPiecejoin() {
//		return piecejoin;
//	}
//	public void setPiecejoin(Piecejoin piecejoin) {
//		this.piecejoin = piecejoin;
//	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		ProspectBean.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		boolean b=false;
		if(siteWeb!=null){
		for(int i=0;i<2;i++)
		{
		if(siteWeb.charAt(i)!='w') b=true;
		}
		}
		if(b==false) this.siteWeb=siteWeb;
		else this.siteWeb="";
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public Prospect getSelectedProspect() {
		return selectedProspect;
	}
	public void setSelectedProspect(Prospect selectedProspect) {
		this.selectedProspect = selectedProspect;
	}
	public ProspectService getProspectservice() {
		return prospectservice;
	}
	public void setProspectservice(ProspectService prospectservice) {
		this.prospectservice = prospectservice;
	}
	
	public List<Prospect> getList() {
		return list;
	}
	public boolean isPiecejoinprospect() {
		return piecejoinprospect;
	}

	public void setPiecejoinprospect(boolean piecejoinprospect) {
		ProspectBean.piecejoinprospect = piecejoinprospect;
	}

	public void setList(List<Prospect> list) {
		ProspectBean.list = list;
	}
	
	public boolean isAjouter() {
		return ajouter;
	}
	public void setAjouter(boolean ajouter) {
		ProspectBean.ajouter = ajouter;
	}
	public boolean isModifier() {
		return modifier;
	}
	public void setModifier(boolean modifier) {
		ProspectBean.modifier = modifier;
	}
	
	public Prospect getP() {
		return p;
	}

	public void setP(Prospect p) {
		ProspectBean.p = p;
	}

	public AgendaBean getAgendabean() {
		return agendabean;
	}

	public void setAgendabean(AgendaBean agendabean) {
		ProspectBean.agendabean = agendabean;
	}
	
	public List<Statut> getListStatut() {
		return listStatut;
	}

	public void setListStatut(List<Statut> listStatut) {
		this.listStatut = listStatut;
	}

	public ArrayList<String> getListeStatutString() {
		return listeStatutString;
	}

	public void setListeStatutString(ArrayList<String> listeStatutString) {
		this.listeStatutString = listeStatutString;
	}

	public StatutService getStatutService() {
		return statutService;
	}

	public void setStatutService(StatutService statutService) {
		this.statutService = statutService;
	}

	public String getResultStatut() {
		return resultStatut;
	}

	public void setResultStatut(String resultStatut) {
		this.resultStatut = resultStatut;
	}

//	public PiecejoinService getPiecejoinservice() {
//		return piecejoinservice;
//	}
//
//	public void setPiecejoinservice(PiecejoinService piecejoinservice) {
//		this.piecejoinservice = piecejoinservice;
//	}

	public RepresentantService getRepresentantservice() {
		return representantservice;
	}

	public void setRepresentantservice(RepresentantService representantservice) {
		this.representantservice = representantservice;
	}

	public List<Representant> getListRepresentant() {
		return listRepresentant;
	}

	public void setListRepresentant(List<Representant> listRepresentant) {
		this.listRepresentant = listRepresentant;
	}

	public ArrayList<String> getListeRepresentantString() {
		return listeRepresentantString;
	}

	public void setListeRepresentantString(ArrayList<String> listeRepresentantString) {
		this.listeRepresentantString = listeRepresentantString;
	}

	public String getResultrepresentant() {
		return resultrepresentant;
	}

	public void setResultrepresentant(String resultrepresentant) {
		this.resultrepresentant = resultrepresentant;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	
	public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
	public String getRaisonsociale() {
		return raisonsociale;
	}

	public void setRaisonsociale(String raisonsociale) {
		ProspectBean.raisonsociale = raisonsociale;
	}

	public String getRaisonsocialeabrg() {
		return raisonsocialeabrg;
	}

	public void setRaisonsocialeabrg(String raisonsocialeabrg) {
		ProspectBean.raisonsocialeabrg = raisonsocialeabrg;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getChiffreaffaire() {
		return chiffreaffaire;
	}

	public void setChiffreaffaire(String chiffreaffaire) {
		this.chiffreaffaire = chiffreaffaire;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public Integer getNombreeff() {
		return nombreeff;
	}

	public void setNombreeff(Integer nombreeff) {
		this.nombreeff = nombreeff;
	}

	public boolean isRepresentantb() {
		return representantb;
	}

	public void setRepresentantb(boolean representantb) {
		this.representantb = representantb;
	}

	public ArrayList<String> getVilles() {
		return villes;
	}

	public void setVilles(ArrayList<String> villes) {
		this.villes = villes;
	}

	public String[] getTab() {
		return tab;
	}

	public void setTab(String[] tab) {
		this.tab = tab;
	}

	public RepresentantBean getRepresentantbean() {
		return representantbean;
	}

	public void setRepresentantbean(RepresentantBean representantbean) {
		ProspectBean.representantbean = representantbean;
	}


	public boolean isItest() {
		return itest;
	}

	public void setItest(boolean itest) {
		ProspectBean.itest = itest;
	}
	public void trueItest() {
		ProspectBean.itest = true;
	}
	public void falseItest() {
		ProspectBean.itest = false;
	}

	public List<SelectItem> getListIds() {
		return listIds;
	}

	public void setListIds(List<SelectItem> listIds) {
		this.listIds = listIds;
	}

	public SelectItem getSelectItem() {
		return selectItem;
	}

	public void setSelectItem(SelectItem selectItem) {
		this.selectItem = selectItem;
	}

	public static AgendaService getAgendaService() {
		return agendaService;
	}

	public static void setAgendaService(AgendaService agendaService) {
		ProspectBean.agendaService = agendaService;
	}

	public static PiecejoinBean getPiecejoinBean() {
		return piecejoinBean;
	}

	public static void setPiecejoinBean(PiecejoinBean piecejoinBean) {
		ProspectBean.piecejoinBean = piecejoinBean;
	}

	public PiecejoinService getPiecejoinService() {
		return piecejoinService;
	}

	public void setPiecejoinService(PiecejoinService piecejoinService) {
		this.piecejoinService = piecejoinService;
	}

	public boolean isAutreVille() {
		return autreVille;
	}

	public void setAutreVille(boolean autreVille) {
		this.autreVille = autreVille;
	}
	public String viderlist()
	{
		try{
		agendabean.getList().removeAll(agendabean.getList());
		selectedProspect=null;
		}catch(Exception e){e.printStackTrace();}
		
		return "GestionProspect";
	}
	public String AjouterProspect()
	{
		setPiecejoinprospect(true);
		piecejoinprospect=true;
		setAdresse(null);
		setSecteur(null);
		setActivite(null);
		setRaisonsociale(null);
		setRaisonsocialeabrg(null);
		setEmail(null);
		setFax(null);
		setSiteWeb(null);
		setStatut(null);
		setTelephone(null);
		setTelephone2(null);
		setChiffreaffaire(null);
		setNombreeff(0);
		setVille(null);
		setResultStatut(null);
		autreVille=false;
		setAjouter(true);
		setModifier(false);
		representantbean.getList().removeAll(representantbean.getList());
		representantbean.getTmplist().removeAll(representantbean.getTmplist());
		piecejoinBean.getTmplist().removeAll(piecejoinBean.getTmplist());
		piecejoinBean.getList().removeAll(piecejoinBean.getList());
		

		return "Ajouter";
	}
	
	public String AppliquerAjouterProspect() {
		setAjouter(true);
		setModifier(false);
		try{
		for(int i=0;i<listStatut.size();i++)
		{
			if(resultStatut.equals(listStatut.get(i).getDenomination())) setStatut(listStatut.get(i));
		}
		}catch(Exception e){erreur="Veuillez remplir tous les champs";}
		try{
		for(int i=0;i<listRepresentant.size();i++)
		{
			if(resultrepresentant.equals(listRepresentant.get(i).getNom())) representant=listRepresentant.get(i);
		}
		}catch(Exception e){}
		
		Prospect p =new Prospect();
		try
		{
		p=new Prospect(getStatut(),getRaisonsociale(),getRaisonsocialeabrg(),getTelephone(),getTelephone2(),getFax(),getSiteWeb(),getEmail(),getAdresse(),getVille(),getPays(),getChiffreaffaire(),getActivite(),getSecteur(),getNombreeff(),null, null,null);
		prospectservice.AjouterProspect(p);
		list=prospectservice.AfficherProspects();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getRaisonsociale().equals(p.getRaisonsociale()));
			p.setIdProspect(list.get(i).getIdProspect());
		}
		prospect=p;
		}catch(Exception e){e.printStackTrace();}
		
		representantb=true;
		System.out.println("helo");
		representantbean.setProspect(prospect);
		piecejoinBean.setProspect(prospect);
		representantbean.AppliquerAjouterRepresentant();
		piecejoinBean.AppliquerAjouterPiecejoin();
		piecejoinBean.AppliquerSupprimerPiecejoin();
		representantbean.AppliquerSupprimerPiecejoin();
		setAdresse(null);
		setSecteur(null);
		setActivite(null);
		setRaisonsociale(null);
		setRaisonsocialeabrg(null);
		setEmail(null);
		setFax(null);
		setSiteWeb(null);
		setStatut(null);
		setTelephone(null);
		setTelephone2(null);
		setChiffreaffaire(null);
		setNombreeff(0);
		setVille(null);
		setResultStatut(null);
		setAjouter(true);
		setModifier(false);
		agendabean.setProspect(prospect);
		agendabean.setAjouter(true);
		return null;
		}
	public String AppliquerAjouterProspectQuitter() {
		setAjouter(true);
		setModifier(false);
		try{
		for(int i=0;i<listStatut.size();i++)
		{
			if(resultStatut.equals(listStatut.get(i).getDenomination())) setStatut(listStatut.get(i));
		}
		}catch(Exception e){erreur="Veuillez remplir tous les champs";}
		try{
		for(int i=0;i<listRepresentant.size();i++)
		{
			if(resultrepresentant.equals(listRepresentant.get(i).getNom())) representant=listRepresentant.get(i);
		}
		}catch(Exception e){}
		
		Prospect p = null;
		try
		{
		p=new Prospect(getStatut(),getRaisonsociale(),getRaisonsocialeabrg(),getTelephone(),getTelephone2(),getFax(),getSiteWeb(),getEmail(),getAdresse(),getVille(),getPays(),getChiffreaffaire(),getActivite(),getSecteur(),getNombreeff(),null, null,null);
		prospectservice.AjouterProspect(p);
		list=prospectservice.AfficherProspects();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getRaisonsociale().equals(p.getRaisonsociale()));
			p.setIdProspect(list.get(i).getIdProspect());
		}
		prospect=p;
		}catch(Exception e){erreur="Veuillez remplir tous les champs"; System.out.print("errer");}
		
		representantb=true;
		System.out.println("helo");
		representantbean.setProspect(prospect);
		piecejoinBean.setProspect(prospect);
		representantbean.AppliquerAjouterRepresentant();
		piecejoinBean.AppliquerAjouterPiecejoin();
		piecejoinBean.AppliquerSupprimerPiecejoin();
		representantbean.AppliquerSupprimerPiecejoin();
		setAdresse(null);
		setSecteur(null);
		setActivite(null);
		setRaisonsociale(null);
		setRaisonsocialeabrg(null);
		setEmail(null);
		setFax(null);
		setSiteWeb(null);
		setStatut(null);
		setTelephone(null);
		setTelephone2(null);
		setChiffreaffaire(null);
		setNombreeff(0);
		setVille(null);
		setResultStatut(null);
		setAjouter(true);
		setModifier(false);
		return "GestionProspect";
		}

	public String ModifierProspect(Prospect p)
	{
		setAdresse(null);
		setSecteur(null);
		setActivite(null);
		setRaisonsociale(null);
		setRaisonsocialeabrg(null);
		setEmail(null);
		setFax(null);
		setSiteWeb(null);
		setStatut(null);
		setTelephone(null);
		setTelephone2(null);
		setChiffreaffaire(null);
		setNombreeff(0);
		setVille(null);
		setResultStatut(null);
		autreVille=false;
		setModifier(true);
		setAjouter(false);
		setPiecejoinprospect(true);
		piecejoinprospect=true;
//		prospect=selectedProspect;
		prospect = p;
//		prospect.setIdProspect(selectedProspect.getIdProspect());
//		System.out.print("dkhol");

			setAdresse(prospect.getAdresse());
			setSecteur(prospect.getSecteur());
			setActivite(prospect.getActivite());
			setRaisonsociale(prospect.getRaisonsociale());
			setRaisonsocialeabrg(prospect.getRaisonsocialeabrg());
			setEmail(prospect.getEmail());
			setFax(prospect.getFax());
			setPays(prospect.getPays());
			setSiteWeb(prospect.getSiteWeb());
			setStatut(prospect.getStatut());
			setResultStatut(prospect.getStatut().getDenomination());
			setTelephone(prospect.getTelephone());
			setTelephone2(prospect.getTelephone2());
			setChiffreaffaire(prospect.getChiffreaffaire());
			setNombreeff(prospect.getNombreeff());
			setVille(prospect.getVille());
			representantbean.AfficherRepresentants(prospect);
			piecejoinBean.AfficherPiecejoinProspect(prospect);
			villeChanged(null);
			setVille(prospect.getVille());
			return "Ajouter";
	}
	public String AppliquerModifierProspect()
	{
		System.out.print(prospect.toString());
		
//		prospect=selectedProspect;
		prospect.setAdresse(getAdresse());
		prospect.setRaisonsociale(getRaisonsociale());
		prospect.setRaisonsocialeabrg(getRaisonsocialeabrg());
		prospect.setChiffreaffaire(getChiffreaffaire());
		prospect.setNombreeff(getNombreeff());
		prospect.setActivite(getActivite());
		prospect.setSecteur(getSecteur());
		prospect.setEmail(getEmail());
		prospect.setFax(getFax());
		prospect.setPays(getPays());
		prospect.setSiteWeb(getSiteWeb());
		prospect.setTelephone(getTelephone());
		prospect.setTelephone2(getTelephone2());
		prospect.setVille(getVille());
		for(int i=0;i<listStatut.size();i++)
		{
			if(listStatut.get(i).getDenomination().equals(getResultStatut())) prospect.setStatut(listStatut.get(i));
		}
		prospectservice.ModifierProspect(prospect);
		list=prospectservice.AfficherProspects();
		representantbean.setProspect(prospect);
		piecejoinBean.setProspect(prospect);
		representantbean.AppliquerAjouterRepresentant();
		piecejoinBean.AppliquerAjouterPiecejoin();
		piecejoinBean.AppliquerSupprimerPiecejoin();
		representantbean.AppliquerSupprimerPiecejoin();
		System.out.print("khroj");
		setAdresse(null);
		setSecteur(null);
		setActivite(null);
		setRaisonsociale(null);
		setRaisonsocialeabrg(null);
		setEmail(null);
		setFax(null);
		setSiteWeb(null);
		setStatut(null);
		setTelephone(null);
		setTelephone2(null);
		setChiffreaffaire(null);
		setNombreeff(0);
		setVille(null);
		setResultStatut(null);
		
		return "GestionProspect";
	}
	public String AfficherProspects()
	{
			list=prospectservice.AfficherProspects();
			System.out.println("Afficher hello");
			return "list";
	}
	public void InitialiserList()
	{

		try
		{
		for(int i=0;i<listStatut.size();i++)
		{
			String tmp=(String)(listStatut.get(i).getDenomination());
			if(listStatut.get(i).getStatutprospect()==true) listeStatutString.add(tmp);
		}
		}catch(Exception e ){}
		try
		{
		for(int i=0;i<listRepresentant.size();i++)
		{
			String tmp=(String)listRepresentant.get(i).getNom();
			listeRepresentantString.add(tmp);
		}
		
		}catch(Exception e ){}
		try
		{
		for(int i=0;i<tab.length;i++)
		{
			villes.add(tab[i]);
		}
		}catch(Exception e){System.out.println("erreur");}
		
	}
	public void onRowSelect(SelectEvent se)
	{
		setProspect(selectedProspect);
		agendabean.setProspect(getProspect());
		
		checked=true;
	try{
		agendabean.AfficherAgendas(getProspect());
	}catch(Exception e){e.printStackTrace();}
	}
	public void onRowUnSelect(SelectEvent se)
	{
		checked=false;
	}
	public void villeChanged(final AjaxBehaviorEvent event)
	{
		
		boolean b=false;
		for(int i=0;i<villes.size()-1;i++)
		{
		if(getVille().equals(villes.get(i))){ autreVille=false;b=false; break; }
		else b=true;
		}
		if(b==true){ autreVille=true; setVille(null);}
		
	}
	public void update(PageEvent event) {
		
		AfficherProspects();
		System.out.println("je test");
		
	}
	public void representantb()
	{
		representantb=true;
	}


	public static void main(String args[] )
	{
		
		ProspectBean pb =new ProspectBean();
		pb.InitialiserList();
	}
}
